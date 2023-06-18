package localization;

import java.util.ListResourceBundle;

public class Labels_ua extends ListResourceBundle {

    private static final Object[][] contents =
    {
            {"separator", ","},
            {"date_format", "dd.MM.yyyy"},
            {"name", "Назва"},
            {"zip", "Поштовий індекс"},
            {"annual", "Річний оборот"},
            {"emploees", "Кількість співробітників"},
            {"type", "Тип"},
            {"add", "Додати"},
            {"if_min", "Якщо менше"},
            {"invalid", "Неправильне введення"},
            {"not_min", "Занадто велике"},
            {"delete", "Видалити"},
            {"not_ur", "Не Ваше"},
            {"update", "Оновити"},
            {"info", "Інформація"},
            {"u_sure", "Ви впевнені?"},
            {"init", "Дата ініціалізації"},
            {"amount", "Кількість елементів"},
            {"choose", "Виберіть файл"},
            {"user", "Ім'я користувача"},
            {"coordinates", "Координати"},
            {"date", "Дата створення"},
            {"creator", "Створювач"},
            {"attempt", "Спроба входу"},
            {"success", "Успішно!!!"},
            {"exists", "Логін вже існує"},
            {"have_acc", "Вже є обліковий запис?"},
            {"sign_up", "Зареєструватися"},
            {"login", "Увійти"},
            {"no_acc", "Немає облікового запису?"},
            {"password", "Пароль"}
    };

    public Object[][] getContents() {
        return contents;
    }

}
