create database veterinariajb;
use veterinariajb;

-- tabla de roles
create table role (
    id int primary key auto_increment,
    name varchar(50)
);

-- insertar roles 
insert into role (name) values ('admin'), ('receptionist'), ('veterinary'), ('costumer'); -- roles ya predeterminados

-- tabla login
create table login (
    id int primary key auto_increment,
    user varchar(45),
    password varchar(255), 
    role_id int,
    foreign key (role_id) references role(id)
);

-- tabla people
create table people (
    id int primary key auto_increment,
    name varchar(45),
    identification varchar(45),
    phone varchar(45),
    email varchar(45),
    role_id int,
    created_at timestamp default current_timestamp,                                 -- para ver cuando se creo o se modifico
    updated_at timestamp default current_timestamp on update current_timestamp,		-- para ver cuando se creo o se modifico
    foreign key (role_id) references role(id)
);

-- tabla pet
create table pet (
    id int primary key auto_increment,
    name varchar(100),
    specie varchar(50),
    race varchar(100),
    age int,
    date_birth date,
    sex enum('macho', 'hembra'), -- nuevo campo
    microchip_tattoo varchar(45),
    photo text,
    costumer_id int,
    foreign key (costumer_id) references people(id) 
);

-- tabla medicalhistory
create table medicalhistory (
    id int primary key auto_increment,
    pet_id int,
    allergies text,
    pre_conditions text,
    weight varchar(45),
    foreign key (pet_id) references pet(id)
);

-- tabla medicalconsult
create table medicalconsult (
    id int primary key auto_increment,
    pet_id int,
    date date,
    time time,
    reason text,
    diagnostic text,
    recommendations text,
    state enum('programada', 'en proceso', 'finalizada', 'cancelada'), 
    veterinary_id int,
    foreign key (pet_id) references pet(id),
    foreign key (veterinary_id) references people(id) 
);

-- tabla vaccine
create table vaccine (
    id int primary key auto_increment,
    pet_id int,
    name varchar(100),
    lot varchar(50),
    manufacturer varchar(100), 
    date_application date,
    next_dose date,
    foreign key (pet_id) references pet(id)
);

-- tabla supplier
create table supplier (
    id int primary key auto_increment,
    name varchar(45),
    contact varchar(45),
    phone varchar(45),
    email varchar(45),
    address varchar(255) 
);

-- tabla inventory
create table inventory (
    id int primary key auto_increment,
    name varchar(100),
    type varchar(50),
    manufacturer varchar(100),
    stock int,
    expirationdate date,
    supplier_id int,
    foreign key (supplier_id) references supplier(id)
);

-- tabla inventoryconsult
create table inventoryconsult (
    id int primary key auto_increment,
    medicalconsult_id int,
    inventory_id int,
    quantity int,
    foreign key (medicalconsult_id) references medicalconsult(id),
    foreign key (inventory_id) references inventory(id)
);

-- tabla procedures
create table procedures (
    id int primary key auto_increment,
    medicalconsult_id int,
    description text,
    typeprocedures_id int,
    foreign key (medicalconsult_id) references medicalconsult(id),
    foreign key (typeprocedures_id) references typeprocedures(id)
);

-- tabla typeprocedures
create table typeprocedures (
    id int primary key auto_increment,
    name varchar(100),
    price decimal(10,2)
);

-- tabla invoice
create table invoice (
    id int primary key auto_increment,
    costumer_id int,
    date date,
    total decimal(10,2),
    tax decimal(10,2),
    cufe varchar(100),
    qr text,
    foreign key (costumer_id) references people(id) 
);

-- tabla invoicedetails
create table invoicedetails (
    id int primary key auto_increment,
    invoice_id int,
    description text,
    quantity int,
    unitvalue decimal(10,2),
    subtotal decimal(10,2),
    inventory_id int,
    foreign key (invoice_id) references invoice(id),
    foreign key (inventory_id) references inventory(id)
);

