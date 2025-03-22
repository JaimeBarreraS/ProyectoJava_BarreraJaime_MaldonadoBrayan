create database VeterinariaJB;
use VeterinariaJB;

-- Login table
create table Login (
    id int primary key auto_increment,
    user varchar(45),
    password varchar(45),
    role varchar(45)
);

-- People table
create table People (
    id int primary key auto_increment,
    name varchar(45),
    identification varchar(45),
    phone varchar(45),
    email varchar(45),
    login_id int,
    foreign key (login_id) references Login(id)
);

-- tables roles
create table Admin(
    id int primary key auto_increment,
    people_id int,
    foreign key (people_id) references People(id)
);

create table Receptionist (
    id int primary key auto_increment,
    people_id int,
    foreign key (people_id) references People(id)
);

create table Veterinary (
    id int primary key auto_increment,
    people_id int,
    foreign key (people_id) references People(id)
);

create table Costumer (
    id int primary key auto_increment,
    people_id int,
    foreign key (people_id) references People(id)
);

-- Pet table
create table Pet (
    id int primary key auto_increment,
    name varchar(100),
    specie varchar(50),
    race varchar(100),
    age int,
    date_birth date,
    microchip_tattoo varchar(45),
    photo text,
    costumer_id int,
    foreign key (costumer_id) references Costumer(id)
);

-- MedicalHistory table
create table MedicalHistory (
    id int primary key auto_increment,
    pet_id int,
    allergies text,
    pre_conditions text,
    weight varchar(45),
    foreign key (pet_id) references Pet(id)
);

-- MedicalConsult table
create table MedicalConsult (
    id int primary key auto_increment,
    pet_id int,
    date date,
    time time,
    reason text,
    diagnostic text,
    recommendations text,
    state varchar(45),
    veterinary_id int,
    foreign key (pet_id) references Pet(id),
    foreign key (veterinary_id) references Veterinary(id)
);

-- Vaccine table
create table Vaccine (
    id int primary key auto_increment,
    pet_id int,
    name varchar(100),
    lot varchar(50),
    date_application date,
    next_dose date,
    foreign key (pet_id) references Pet(id)
);

-- Inventory table
create table Inventory (
    id int primary key auto_increment,
    name varchar(100),
    type varchar(50),
    manufacturer varchar(100),
    stock int,
    expirationDate date,
    supplier_id int,
    foreign key (supplier_id) references Supplier(id)
);

-- supplier table
create table Supplier (
    id int primary key auto_increment,
    name varchar(45),
    contact varchar(45),
    phone varchar(45),
    email varchar(45)
);

-- InventoryConsult relationship
create table InventoryConsult (
    id int primary key auto_increment,
    medicalConsult_id int,
    inventory_id int,
    quantity int,
    foreign key (medicalConsult_id) references MedicalConsult(id),
    foreign key (inventory_id) references Inventory(id)
);

-- Procedures table
create table Procedures (
    id int primary key auto_increment,
    medicalConsult_id int,
    description text,
    typeProcedures_id int,
    foreign key (medicalConsult_id) references MedicalConsult(id),
    foreign key (typeProcedures_id) references TypeProcedures(id)
);

-- TypeProcedures table
create table TypeProcedures (
    id int primary key auto_increment,
    name varchar(100),
    price decimal(10,2)
);

-- Invoice table
create table Invoice (
    id int primary key auto_increment,
    costumer_id int,
    date date,
    total decimal(10,2),
    tax decimal(10,2),
    cufe varchar(100),
    qr text,
    foreign key (costumer_id) references Costumer(id)
);

-- InvoiceDetails table
create table InvoiceDetails (
    id int primary key auto_increment,
    invoice_id int,
    description text,
    quantity int,
    unitValue decimal(10,2),
    subtotal decimal(10,2),
    inventory_id int,
    foreign key (invoice_id) references Invoice(id),
    foreign key (inventory_id) references Inventory(id)
);
