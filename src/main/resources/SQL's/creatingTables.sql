create table employees
(
    id int auto_increment,
    name varchar(20) not null,
    email varchar(50) not null,
    phone varchar(15) not null,
    nationalID bigint not null,
    role varchar(50) not null,
    constraint employees_pk
        primary key (id)
);

create table projects
(
    id int auto_increment,
    projectName varchar(20) not null,
    startDate date not null,
    appointedManger varchar(20) not null,
    constraint projects_pk
        primary key (id)
);

create table project_employee
(
    id int auto_increment,
    employee_id int null,
    project_id int null,
    constraint table_name_pk
        primary key (id),
    constraint employee___fk
        foreign key (employee_id) references employees (id),
    constraint project___fk
        foreign key (project_id) references projects (id)
);



