CREATE TABLE RulesUser (
	id serial PRIMARY KEY,
	name varchar(255) NOT NULL
);

CREATE TABLE RoleUsers (
	id serial PRIMARY KEY,
	name varchar(255) NOT NULL,
	rules_user_id int REFERENCES RulesUser(id)
);

CREATE TABLE Users (
id serial PRIMARY KEY,
	name varchar(255),
	role_id int REFERENCES RoleUsers(id)
);

create table item_status (
id serial primary key,
	name varchar(255)
);

create table Item_category (
id serial primary key,
	name varchar(255)
);

CREATE Table items (
id serial primary key,
	name varchar(255),
	iser_id int references users(id),
status_id int references item_status(id),
category_id int references item_category(id)
);

create table item_files (
id serial primary key,
	name varchar (255),
	item_id int references items(id),
	files bytea
);

create table item_comments (
id serial primary key,
	name varchar(255),
	item_id int references items(id)
);

insert into item_category
values
(1, 'New'),
(2, 'Worked'),
(3, 'Glossed');

insert into item_status
values
(1, 'Red'),
(2, 'Yellow'),
(3, 'Green');

insert into rulesuser
values
(1, 'Add'),
(2, 'Edit'),
(3, 'Delete'),
(4, 'Read');

insert into roleusers
values
(1, 'Admin', 1),
(2, 'Admin', 2),
(3, 'Admin', 3),
(4, 'User', 1),
(5, 'User', 2),
(6, 'Read only', 4);

insert into users
values
(1, 'Ivan', 1),
(2, 'Serg', 2),
(3, 'Petr', 3);

insert into items
values
(1, 'Task1', 1, 1, 2),
(2, 'Task2', 2, 1, 3),
(3, 'Task3', 3, 3, 3);

insert into item_comments
values
(1, 'Add', 1),
(2, 'Edit', 1),
(3, 'End', 1);

insert into item_files
values
(1, 'Doc', 1, 'log.txt'),
(2, 'Picture', 1, 'picture.jpg');