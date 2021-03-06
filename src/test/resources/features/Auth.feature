#language:ru
Функциональность: Авторизация

  Сценарий: Авторизация в личном кабинете (позитивный)
    Пусть открыта Страница с формой авторизации "http://localhost:9999"
    Когда пользователь пытается авторизоваться с валидным именем "vasya" и валидным паролем "qwerty123"
    И пользователь вводит проверочный код 'из смс' "12345"
    Тогда происходит успешная авторизация и пользователь попадает на страницу 'Личный кабинет'

  Структура сценария: Авторизация в личном кабинете (негативный, неверный логин или пароль)
    Пусть открыта Страница с формой авторизации "http://localhost:9999"
    Когда пользователь пытается авторизоваться с невалидным именем <login> или невалидным паролем <password>
    Тогда появляется ошибка о неверном логине или пароле
    Примеры:
      | login   | password    |
      | "vasia" | "qwerty123" |
      | "vasya" | "qwerti123" |

  Структура сценария: Авторизация в личном кабинете (негативный, неверный код)
    Пусть открыта Страница с формой авторизации "http://localhost:9999"
    Когда пользователь пытается авторизоваться с валидным именем <login> и валидным паролем <password>
    И пользователь вводит проверочный код 'из смс' <code>
    Тогда появляется ошибка о неверном коде проверки
    Примеры:
      | login   | password    | code    |
      | "vasya" | "qwerty123" | "00000" |
      | "vasya" | "qwerty123" | "11111" |


