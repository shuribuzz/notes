====================================
Linux
====================================
curl -X GET http://localhost/notes/all

curl -X POST -i -H "Content-Type: application/json" -d '{"title":"3 заметка","text":"Текст третьей заметки"}' http://localhost:8080/notes/add

curl -X DELETE -i http://localhost:8080/notes/remove/id

curl -X PUT -i -H "Content-Type:application/json" -d '{"id":"id", "title":"new 2 заметка", "text":"обновлённая вторая заметка"}' http://localhost:8080/notes/id/update
