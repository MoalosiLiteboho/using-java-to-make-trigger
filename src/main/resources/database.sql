create database if not exists Triggers;

use Triggers;

create table if not exists Course(
    Id int not null primary key auto_increment,
    Name varchar(255) not null,
    Retire date not null
);

create table if not exists Students(
    Id int not null primary key auto_increment,
    CourseId int not null,
    Name varchar(255) not null,
    Surname varchar(255) not null,
    foreign key(CourseId) references Course(Id)
);

create table if not exists StudentGrades(
    Id int not null primary key auto_increment,
    StudentId int not null,
    Grade varchar(10) not null,
    Mark int,
    Submitted bit not null default false,
    foreign key(StudentId) references Students(Id)
);

create table if not exists CourseAssignment(
    Id int not null primary key auto_increment,
    CourseId int not null,
    Name varchar(255) not null,
    Deadline date not null,
    foreign key(CourseId) references Course(Id)
);