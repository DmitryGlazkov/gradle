### gradle
###### РСУБД - MySQL
###### база данных - test
###### таблица - books
###### пользователь - root
###### пароль - root
----------------------------
###### INSERT INTO test.books (author, date_of_publication, title) VALUES ('Лев Николаевич Толстой', '1877-07-01', 'Анна Каренина');
###### INSERT INTO test.books (author, date_of_publication, title) VALUES ('Пушкин Александр Сергеевич', '1832-07-01', 'Евгений Онегин');
###### INSERT INTO test.books (author, date_of_publication, title) VALUES ('Иван Алексеевич Бунин', '1943-07-01', 'Темные аллеи');
###### INSERT INTO test.books (author, date_of_publication, title) VALUES ('Stephen Edwin King', '1983-07-01', 'Christine');
###### INSERT INTO test.books (author, date_of_publication, title) VALUES ('Stephen King', '1977-07-01', 'The Shining');
###### INSERT INTO test.books (author, date_of_publication, title) VALUES ('Виктор Пелевин', '1999-07-01', 'Generation «П»');
###### INSERT INTO test.books (author, date_of_publication, title) VALUES ('Иванов Иван Иванович', '2017-11-13', 'более поздняя дата, чем в условии');
###### INSERT INTO test.books (author, date_of_publication, title) VALUES ('Михаил Михайлович Михайлов-Михайловский', '2000-01-01', 'больше трех заглавных букв в имени автора');
###### INSERT INTO test.books (author, date_of_publication, title) VALUES ('Петр Петрович Петров', '2017-11-01', 'больше пятидесяти символов в названии книги йцукенгшщзфывапролдячсмить');
----------------------------------------------------------------------------------------------------------------------------------------
### методы:
###### POST - http://localhost:8080/books - добавить книгу в таблицу
###### GET - http://localhost:8080/books - получить все книги из таблицы
###### GET - http://localhost:8080/books/select - получить книги согласно условию
###### PUT - http://localhost:8080/books/{title} - изменить данные о книге
###### DELETE - http://localhost:8080/books/{id} - удалить книгу по id
