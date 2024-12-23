package services;

import db.DataBaseProvider;
import localization.Lang;
import model.Organization;
import model.OrganizationType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class OrganizationController {
    private final DataBaseProvider source;

    public OrganizationController(DataBaseProvider source) {
        this.source = source;
    }

    public OrganizationController(CurrentUserManager userManager) {
        source = new DataBaseProvider(userManager);
    }

    public int addOrganization(Organization request){
        //validateOrganization() {throw new valid}
        return source.addOrganizationToDB(request);
    }
    public int addOrganizationifMin(Organization request){
        if (source.getList().size() == 0){
            return source.addOrganizationToDB(request);
        } else {
            Optional<Organization> min = source.getDataSet().stream()
                    .min(Comparator.comparing(Organization::getAnnualTurnover));
            int id;
            if (min.isPresent() && request.getAnnualTurnover() < min.get().getAnnualTurnover()){
                id = source.addOrganizationToDB(request);
            } else {
                id = -1;
            }
            return id;
        }
    }
    public boolean updateOrganizationById(Organization request, int id){
        boolean answ = false;
        if (source.getDataSet().stream().filter(p -> p.getCreator().equals(source.getUserManager().getUserName()))
                .map(Organization::getId).toList().contains(id)){
            answ = source.updateOrganization(request, id);
        }
        return answ;
    }
    public double averageTurnover(){
        return source.getDataSet().stream().mapToLong(Organization::getAnnualTurnover).average().orElse(Double.NaN);
    }
    public boolean clear(){
        return source.clearOrganization();
    }
    public String filter(String substring){
        return source.getDataSet().stream()
                .filter(e->e.getName().toUpperCase().contains(substring))
                .map(Organization::toString)
                .collect(Collectors.joining());
    }
    public boolean removeOrganizationById(int id){
        return source.removeOrganizationById(id);
    }
    public Set<Organization> showOrganizations(){
        return source.getDataSet();
    }
    public List<Organization> shuffleOrganizations(){
        return source.shuffleDataList();
    }
    public int countType(OrganizationType type){
        return source.getList().stream()
                .filter(p -> p.getType().getValue() < type.getValue())
                .toList().size();
    }

    public List<Organization> getAll(){
        return source.getList();
    }

    public String info() {
        String answer = "";
        answer += Lang.getString("type") + ": " + Vector.class.getTypeName().split("\\.")[2] + "\n";
        answer += Lang.getString("init") + ": " + source.getCreationDate().toLocalDate() + "\n";
        answer += Lang.getString("amount") + ": " + (source.getDataSet().size()) + "\n";
        return answer;
    }
    public boolean checkUserPassword(String username, String password) {
        return source.checkUserPassword(username, password);
    }
    public void userRegister(String username, String password) {
        source.userRegister(username, password);
    }
    public Set<String> getUserNameList() {
        return source.getUserNameList();
    }
    public Set<Organization> getDataSet() {
        source.updateDataSet();
        return source.getDataSet();
    }

}
