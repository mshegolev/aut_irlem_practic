# language: ru
Функция: Авторизация

  @Закрытьбраузер

  Структура сценария: Успешный вход пользователя
    Дано Открыть в браузере ссылку: <ссылка>
    Когда Пользователь ввел <логин> и <пароль>
    И Нажал кнопку "Войти"
    Тогда На сайте видно поля <имя> и <фамилия> пользователя
    Когда Нажал кнопку "Выйти"
    Тогда В браузере открыта страница авторизации
    Примеры:
      | ссылка                  | логин     | пароль    | имя     | фамилия   |
      | "https://rithm-time.tv" | "test001" | "001test" | "Frodo" | "Baggins" |
      | "https://rithm-time.tv" | "test002" | "002test" | "Frodo" | "Baggins" |
      | "https://rithm-time.tv" | "test003" | "003test" | "Frodo" | "Baggins" |
