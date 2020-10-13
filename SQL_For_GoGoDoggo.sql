create table humanUsers (
    firstName varchar(100) not null,
    lastName varchar(100) not null,
    email varchar(100) not null,
    password varchar (50) not null,
    id varchar (50)not null,
    primary key(id)
);
create table dogShelter (
    shelterName varchar(100) not null,
    locationPoint varchar(100) not null,
    email varchar(100)not null,
    phone varchar(10),
    password varchar (50) not null,
    id varchar (50) not null,
    primary key(id)
);
create table dogprofile (
    dogName varchar(100), 
    gender varchar(100), 
    breed varchar(100) not null,
    age varchar (50) not null,
    id varchar (50) not null,
    shelterID varchar(50) not null,
    primary key(id),
    foreign key(shelterID) references dogShelter(id)
);