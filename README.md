<h3>Запуск на Linux<h3>



Необходимые требования:
-Java Development Kit 8 (JDK8);
-Maven 3.0+;
-cURL 7.0+.

Запуск:
1. открыть терминал и перейти в корень проекта notes
2. mvn clean compile
3. mvn exec:java
4. открыть новое окно терминала и перейти в корень cURL

Далее ввод запросов:
-------------------------
GET
-------------------------
Запрос:
curl -X GET http://localhost:8080/notes/all

Ответ:
200 OK


-------------------------
POST
-------------------------
Запрос:
curl -X POST -i -H "Content-Type: application/json" -d '{"title":"3 заметка","text":"Текст третьей заметки"}' http://localhost:8080/notes/add

Ответ:
201 Created


-------------------------
DELETE
-------------------------
Запрос:
curl -X DELETE -i http://localhost:8080/notes/remove/id

Ответ:
200 OK. Если id не найден, то 404 Not Found

-------------------------
PUT
-------------------------
Запрос:
curl -X PUT -i -H "Content-Type:application/json" -d '{"id":"id", "title":"new 2 заметка", "text":"обновлённая вторая заметка"}' http://localhost:8080/notes/id/update

Ответ:
200 OK. Если id не найден, то 404 Not Found
