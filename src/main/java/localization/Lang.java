package localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class Lang {

    public static final ResourceBundle es = ResourceBundle.getBundle("localization.Labels", new Locale("es", "NI"));

    public static final ResourceBundle ru = ResourceBundle.getBundle("localization.Labels", new Locale("ru", "RU"));

    public static final ResourceBundle sr = ResourceBundle.getBundle("localization.Labels", new Locale("sr", "SR"));

    public static final ResourceBundle ua = ResourceBundle.getBundle("localization.Labels", new Locale("ua", "UA"));

    private static ResourceBundle appLang = ru;

    public static void setAppLang(ResourceBundle appLang) {
        Lang.appLang = appLang;
    }

    public static String getString(String string) {
        return appLang.getString(string);
    }

}
