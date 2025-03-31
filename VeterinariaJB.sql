drop database if exists veterinariajb;
create database veterinariajb;
use veterinariajb;

-- tabla de roles
create table role (
    id int primary key auto_increment,
    name varchar(50)
);

-- tabla personas
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

-- insertar roles 
insert into role (name) values ('admin'), ('receptionist'), ('veterinary'), ('costumer'); -- roles ya predeterminados

-- tabla para roles              ME TOCO CREARLAS PARA QUE FUNCIONE LAS VISTAS SE CONFUNDIA CON LA TABLA PEOPLE 
create table admin (
    id int primary key auto_increment,
    people_id int,
    foreign key (people_id) references people(id)
);
create table receptionist (
    id int primary key auto_increment,
    people_id int,
    foreign key (people_id) references people(id)
);
create table costumer (
    id int primary key auto_increment,
    people_id int,
    foreign key (people_id) references people(id)
);
create table veterinary (
    id int primary key auto_increment,
    people_id int,
    foreign key (people_id) references people(id)
);


-- tabla login
create table login (
    id int primary key auto_increment,
    user varchar(45),
    password varchar(255), 
    role_id int,
    foreign key (role_id) references role(id)
);

INSERT INTO login (user, password, role_id) VALUES ('Jaime', '123456', 1);
INSERT INTO login (user, password, role_id) VALUES ('Brayan', '123456', 1);
INSERT INTO login (user, password, role_id) VALUES ('Freiler', '123456', 2);
INSERT INTO login (user, password, role_id) VALUES ('Camilo', '123456', 3);
INSERT INTO login (user, password, role_id) VALUES ('Camilo', '123456', 3);

select * from login;
SELECT name FROM people WHERE role_id = 3;
-- tabla people

INSERT INTO people (name, identification, phone, email, role_id) 
VALUES 
('Carlos Ramírez', 'CC12345678', '3001234567', 'carlos.ramirez@example.com', 2),
('María López', 'CC87654321', '3107654321', 'maria.lopez@example.com', 2),
('Jaime Barrera', 'CC87654321', '3107654321', 'maria.lopez@example.com', 2),
('Pepe Gomez', 'CC872314321', '3107434321', 'pepe.lopez@example.com', 3),
('Erika Barrera', 'CC874354321', '31053454321', 'Erika.lopez@example.com', 3),
('Samuel Maldonado', 'CC873234321', '31034354321', 'samuel.lopez@example.com', 4);


insert into veterinary(people_id)
VALUES
(4),
(5);

-- tabla mascotas
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

INSERT INTO pet (name, specie, race, age, date_birth, sex, microchip_tattoo, photo, costumer_id) 
VALUES 
('Max', 'Perro', 'Labrador Retriever', 3, '2021-05-12', 'macho', '123456789ABC', 'data:image/webp;base64,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', 1),
('Luna', 'Gato', 'Persa', 2, '2022-08-20', 'hembra', '987654321XYZ', 'luna_photo.jpg', 2),
('Rocko', 'Perro', 'Pastor Aleman', 2, '2022-08-20', 'macho', '127654321XYZ', 'rocko_photo.jpg', 2);


-- tabla historial medico
create table medicalhistory (
    id int primary key auto_increment,
    pet_id int,
    allergies text,
    pre_conditions text,
    weight varchar(45),
    foreign key (pet_id) references pet(id)
);

INSERT INTO medicalhistory (pet_id, allergies, pre_conditions, weight) VALUES
(1, 'Ninguna', 'Sin condiciones preexistentes', '10.5 kg'),
(2, 'Cacahuates', 'Soplo cardíaco', '7.2 kg'),
(2, 'Hierba, Polvo', 'Artritis', '15.0 kg'),
(1, 'Pollo', 'Diabetes', '8.8 kg'),
(3, 'Ninguna', 'Fractura previa en la pierna', '12.3 kg');

select * from medicalhistory;

-- tabla consultas medicas
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

INSERT INTO medicalconsult (pet_id, date, time, reason, diagnostic, recommendations, state, veterinary_id)
VALUES 
(1, '2025-03-25', '10:30:00', 'Vacunación anual', 'N/A', 'Aplicar vacuna antirrábica', 'finalizada', 2),
(2, '2025-03-26', '15:00:00', 'Revisión de cojera', 'Esguince leve en pata trasera', 'Reposo y antiinflamatorio', 'finalizada', 1),
(3, '2025-03-27', '09:00:00', 'Pérdida de apetito', 'Gastroenteritis', 'Dieta blanda y seguimiento en 48 horas', 'en proceso', 1),
(1, '2025-03-25', '10:30:00', 'Vacunación anual', 'N/A', 'Aplicar vacuna antirrábica', 'finalizada', 2),
(2, '2025-03-26', '15:00:00', 'Revisión de cojera', 'Esguince leve en pata trasera', 'Reposo y antiinflamatorio', 'finalizada', 1),
(3, '2025-03-27', '09:00:00', 'Pérdida de apetito', 'Gastroenteritis', 'Dieta blanda y seguimiento en 48 horas', 'en proceso', 2);
INSERT INTO medicalconsult (pet_id, date, time, reason, diagnostic, recommendations, state, veterinary_id)
VALUES 
(1, '2025-03-25', '10:30:00', 'Vacunación anual', 'N/A', 'Aplicar vacuna antirrábica', 'finalizada', 2);

-- tabla vacunas
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

INSERT INTO vaccine (pet_id, name, lot, manufacturer, date_application, next_dose) VALUES
(1, 'Rabies', 'LOT12345', 'Pfizer', '2025-03-01', '2026-03-01'),
(2, 'Distemper', 'LOT67890', 'Merck', '2025-02-15', '2025-08-15'),
(1, 'Parvovirus', 'LOT54321', 'Zoetis', '2025-01-20', '2025-07-20'),
(3, 'Leptospirosis', 'LOT98765', 'Boehringer Ingelheim', '2025-03-10', '2025-09-10'),
(3, 'Hepatitis', 'LOT11223', 'Elanco', '2025-02-25', '2025-08-25');

-- tabla proveedores
create table supplier (
    id int primary key auto_increment,
    name varchar(45),
    contact varchar(45),
    phone varchar(45),
    email varchar(45),
    address varchar(255) 
);
INSERT INTO supplier (name, contact, phone, email, address) VALUES
('VetDistribuciones', 'Juan Pérez', '123-456-7890', 'contacto@vetdistribuciones.com', 'Calle 123, Bogotá'),
('AnimalCare S.A.', 'María Gómez', '987-654-3210', 'ventas@animalcare.com', 'Avenida 456, Medellín'),
('PetSolutions Ltda.', 'Carlos Ruiz', '555-123-4567', 'info@petsolutions.com', 'Carrera 789, Cali');

-- tabla inventario
create table inventory (
    id int primary key auto_increment,
    name varchar(100),
    type varchar(50),
    manufacturer varchar(100),
    stock int,
    price int,
    expirationdate date,
    supplier_id int,
    foreign key (supplier_id) references supplier(id)
);

INSERT INTO inventory (name, type, manufacturer, stock, price, expirationdate, supplier_id) VALUES
('Vacuna Antirrábica', 'Medicamento', 'LabVet', 50, 120000, '2026-08-15', 1),
('Desparasitante Canino', 'Medicamento', 'VetPharma', 30, 20000 ,'2025-12-10', 2),
('Alimento para Perros 10kg', 'Alimento', 'PetFood Co.', 20, 8000,'2025-11-30', 3),
('Antibiótico Felino', 'Medicamento', 'BioVet', 25, 40000,'2025-07-20', 1),
('Juguete para Gatos', 'Accesorio', 'HappyPets', 15, 4000 , 2024-12-11, 2),
('Collar Antipulgas', 'Accesorio', 'SafePet', 40, 10000, 2025-11-30, 3),
('Alimento para Gatos 5kg', 'Alimento', 'CatFood Inc.', 35, 9000, '2025-10-15', 1),
('Shampoo para Perros', 'Higiene', 'CleanPets', 18, 22000,'2026-02-05', 2);

-- tabla tipos de procedimientos
create table typeprocedures (
    id int primary key auto_increment,
    name varchar(100),
    price decimal(10,2)
);

-- tabla procedimientos
create table procedures (
    id int primary key auto_increment,
    medicalconsult_id int,
    description text,
    typeprocedures_id int,
    foreign key (medicalconsult_id) references medicalconsult(id),
    foreign key (typeprocedures_id) references typeprocedures(id)
);


INSERT INTO typeprocedures (name, price) VALUES
('Consulta general', 50000.00),
('Vacunación', 40000.00),
('Cirugía menor', 150000.00),
('Desparasitación', 30000.00),
('Limpieza dental', 70000.00);

INSERT INTO typeprocedures (name, price) VALUES
('Cirugía mayor', 300000.00),
('Esterilización', 200000.00),
('Radiografía', 120000.00),
('Ecografía', 110000.00),
('Análisis de sangre', 90000.00),
('Hospitalización', 250000.00),
('Tratamiento de heridas', 60000.00),
('Consulta de especialidad', 80000.00),
('Urgencias', 180000.00),
('Terapia física', 75000.00),
('Microchip e identificación', 50000.00),
('Baño y peluquería', 45000.00),
('Corte de uñas', 20000.00),
('Limpieza de oídos', 25000.00);

INSERT INTO procedures (medicalconsult_id, description, typeprocedures_id) VALUES
(1, 'Consulta de rutina y chequeo general', 1),
(2, 'Aplicación de vacuna antirrábica', 2),
(3, 'Extracción de espina clavada en la pata', 3),
(4, 'Administración de antiparasitarios orales', 4),
(5, 'Limpieza profunda de sarro en dientes', 5);

-- tabla factura
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