Feature: Проверка авторизации
  @TestCaseKey=GO-T1
  Scenario Outline: Проверка авторизации

    Given Открыть в браузере ссылку: <ссылка>
    When Пользователь ввел <логин> и <пароль>
    And Нажал кнопку "Войти"
    Then На сайте видно поля <имя> и <фамилия> пользователя
    When Нажал кнопку "Выйти"
    Then В браузере открыта страница авторизации
    Examples:
      | ссылка                  | логин     | пароль    | имя     | фамилия   |
      | "https://rithm-time.tv" | "test001" | "001test" | "Frodo" | "Baggins" |
      | "https://rithm-time.tv" | "test002" | "002test" | "Frodo" | "Baggins" |