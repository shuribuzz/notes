**Запуск на Linux**

Необходимые требования:

-[Java Development Kit 8 (JDK8)](https://jdk8.java.net/download.html);

-[Maven 3.0+](http://maven.apache.org/download.cgi);

-[cURL 7.0+](http://curl.haxx.se/download.html).


Запуск:
1. открыть терминал и перейти в корень разархивированного проекта notes
2. Выполнить команду: mvn clean compile
3. Выполнить команду: mvn exec:java

`INFO: Started listener bound to [localhost:8080]
мая 22, 2018 3:23:11 PM org.glassfish.grizzly.http.server.HttpServer start`

`INFO: [HttpServer] Started.
Jersey app started with WADL available at http://localhost:8080//application.wadl
Hit enter to stop it...`

4. открыть новое окно терминала и перейти в директорию, где установлен cURL: /usr/bin/


Формирование запросов:

**GET**

Запрос:
*curl -X GET http://localhost:8080/notes/all*

Ответ:
200 OK

Вывод:

`[{"id":"31795660-a71f-413b-9bbc-1dc93ee36306","title":"1 заметка","text":"Текст первой заметки","date_create":1526984634,"date_update":1526984634},{"id":"e2e1b46a-d1b3-4aa1-bdb7-700ef58d761e","title":"2 заметка","text":"Текст второй заметки","date_create":1526984634,"date_update":1526984634}]`

**POST**

Запрос:
*curl -X POST -i -H "Content-Type: application/json" -d '{"title":"3 заметка","text":"Текст третьей заметки"}' http://localhost:8080/notes/add*

Ответ:
201 Created

`[{"id":"31795660-a71f-413b-9bbc-1dc93ee36306","title":"1 заметка","text":"Текст первой заметки","date_create":1526984634,"date_update":1526984634},{"id":"e2e1b46a-d1b3-4aa1-bdb7-700ef58d761e","title":"2 заметка","text":"Текст второй заметки","date_create":1526984634,"date_update":1526984634},{"id":"df1a0283-568c-4906-b9eb-d8dd10c3ec0d","title":"3 заметка","text":"Текст третьей заметки","date_create":1526984833,"date_update":1526984833}]`

**DELETE**

Запрос:
*curl -X DELETE -i http://localhost:8080/notes/remove/id*

**id** - необходимо вставить нужный id, в данном примере удалим 1ю заметку "31795660-a71f-413b-9bbc-1dc93ee36306"(без кавычек)

Ответ:
200 OK. Если id не найден, то 404 Not Found

`[{"id":"e2e1b46a-d1b3-4aa1-bdb7-700ef58d761e","title":"2 заметка","text":"Текст второй заметки","date_create":1526984634,"date_update":1526984634},{"id":"df1a0283-568c-4906-b9eb-d8dd10c3ec0d","title":"3 заметка","text":"Текст третьей заметки","date_create":1526984833,"date_update":1526984833}]`

**PUT**

Запрос:
*curl -X PUT -i -H "Content-Type:application/json" -d '{"id":"**id**", "title":"new 2 заметка", "text":"обновлённая вторая заметка"}' http://localhost:8080/notes/id/update*

**id** - необходимо вставить нужный id, в данном примере обновим 2ю заметку "e2e1b46a-d1b3-4aa1-bdb7-700ef58d761e"(без кавычек)

Ответ:
200 OK. Если id не найден, то 404 Not Found

`[{"id":"e2e1b46a-d1b3-4aa1-bdb7-700ef58d761e","title":"new 2 заметка","text":"обновлённая вторая заметка","date_create":1526984634,"date_update":1526985266},{"id":"df1a0283-568c-4906-b9eb-d8dd10c3ec0d","title":"3 заметка","text":"Текст третьей заметки","date_create":1526984833,"date_update":1526984833}]`
