# demo-for-RCR
Разработать демо приложение (rest-service) с использованием springboot 2.5:
1. Создать модель данных с использованием технологии spring-data-jpa, СУБД - h2.
2. Для реализации rest-api применить технологию spring-data-rest, java 11
Необходимо разработать справочник кредитных организаций (КО), атрибуты КО - рег. номер (1, 2, ... 9999), наименование (приер: 1000, "Банк ВТБ"). Каждая КО "привязана" к 
подразделению Банка России (ПБР), атрибуты ПБР - код подразделения (01, 02, ... , 99), наименование (пример: 65 "ГУ Банка России по Свердловской области"). У каждой КО 
существует множество корреспондентских счетов (КорСчет), атрибуты КорСчет - номер счета, наименование (пример: Счет N 30111 "Корреспондентские счета банков-нерезидентов").

С помощью тактических паттернов DDD формируем структуру проекта.

Вычитываем из csv списки кредитных организаций и департаментов и заполняем таблицы через репозиторий.
Используем библиотеку hibernate envers для хранения истории изменений, добавляем endpoint для просмотра списка измененных объектов в формате json.
Решаем проблему n+1 через entity graph.
Делаем объект Корреспондентские счета встроенным к организациям (не имеет идентичности и своего жизненного цикла).
В основной модели используем в качестве полей Enams.
Добавляем собственные типы в качестве полей модели, используем jpa конвертеры.
Добавляем создание и обработку доменных событий.
Добавляем обработку событий репозиториев.
Добавляем querydsl для создание запросов в стиле sql java-кодом и упрощенной фильтрации через rest-api.
