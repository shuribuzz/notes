**Запуск на Linux**

Необходимые требования:

-[Java Development Kit 8 (JDK8)](https://jdk8.java.net/download.html);

-[Maven 3.0+](http://maven.apache.org/download.cgi);

-[cURL 7.0+](http://curl.haxx.se/download.html).


Запуск:
1. открыть терминал и перейти в корень проекта notes
2. Выполнить команду: mvn clean compile
3. Выполнить команду: mvn exec:java
4. открыть новое окно терминала и перейти в директорию, где установлен cURL: /usr/bin

Далее ввод запросов:
*id* - id объекта типа UUID, например, 10dcdccb-8876-4245-ac53-92900c6509bd.

**GET**

Запрос:
curl -X GET http://localhost:8080/notes/all

Ответ:
200 OK


**POST**

Запрос:
curl -X POST -i -H "Content-Type: application/json" -d '{"title":"3 заметка","text":"Текст третьей заметки"}' http://localhost:8080/notes/add

Ответ:
201 Created


**DELETE**

Запрос:
curl -X DELETE -i http://localhost:8080/notes/remove/id

Ответ:
200 OK. Если id не найден, то 404 Not Found

**PUT**

Запрос:
curl -X PUT -i -H "Content-Type:application/json" -d '{"id":"id", "title":"new 2 заметка", "text":"обновлённая вторая заметка"}' http://localhost:8080/notes/id/update

Ответ:
200 OK. Если id не найден, то 404 Not Found
