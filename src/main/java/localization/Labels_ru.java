package localization;

import java.util.ListResourceBundle;

public class Labels_ru extends ListResourceBundle {

    private static final Object[][] contents =
    {
            {"separator", ","},
            {"date_format", "dd.MM.yyyy"},
            {"name", "Название"},
            {"zip", "Zip-код"},
            {"annual", "Годовой оборот"},
            {"emploees", "Количество сотрудников"},
            {"type", "Тип"},
            {"add", "Добавить"},
            {"if_min", "Если меньше"},
            {"invalid", "Неверный ввод"},
            {"not_min", "Слишком большой"},
            {"delete", "Удалить"},
            {"not_ur", "Не Ваше"},
            {"update", "Обновить"},
            {"info", "Информация"},
            {"u_sure", "Вы уверены?"},
            {"init", "Дата инициализации"},
            {"amount", "Количество элементов"},
            {"choose", "Выберите файл"},
            {"user", "Имя пользователя"},
            {"coordinates", "Координаты"},
            {"date", "Дата создания"},
            {"creator", "Создатель"},
            {"attempt", "Попытка входа"},
            {"success", "Успешно!!!"},
            {"exists", "Логин уже существует"},
            {"have_acc", "Уже есть аккаунт?"},
            {"sign_up", "Зарегистрироваться"},
            {"login", "Войти"},
            {"no_acc", "Нет аккаунта?"},
            {"password", "Пароль"}
    };

    public Object[][] getContents() {
        return contents;
    }

}
