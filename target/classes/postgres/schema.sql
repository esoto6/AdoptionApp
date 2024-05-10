SET ROLE larku;

DROP TABLE IF EXISTS ADOPTERS;
DROP TABLE IF EXISTS ANIMALS;

CREATE TABLE ADOPTERS
(
    id SERIAL PRIMARY KEY NOT NULL,
    name varchar(255),
    phoneNumber varchar(255),
    email varchar(255),
    is18 BOOLEAN NOT NULL,
    dateCreated DATE,
    dateModified DATE
);

CREATE TABLE ANIMALS
(
    id SERIAL PRIMARY KEY NOT NULL,
    name varchar(255),
    type varchar(255),
    dob DATE,
    breed varchar(255),
    adoptedDate DATE,
    adopter integer,
    foreign key (adopter) references ADOPTERS(id)
);

CREATE UNIQUE INDEX idx_adopter_id ON ADOPTERS (id ASC);
CREATE UNIQUE INDEX idx_animal_id ON ANIMALS (id ASC);



INSERT INTO ADOPTERS(id, name, phoneNumber, email, is18, dateCreated, dateModified) VALUES (1, 'Edwin Soto', '111-111-1111', 'edwin.soto@email.com', true, now(), null);
INSERT INTO ADOPTERS(id, name, phoneNumber, email, is18, dateCreated, dateModified) VALUES (2, 'Spouse Soto', '222-222-2222', 'mackenzie.soto@email.com', true, now(), null);
INSERT INTO ADOPTERS(id, name, phoneNumber, email, is18, dateCreated, dateModified) VALUES (3, 'Kido One Soto', '333-333-3333', 'liam.soto@email.com', false, now(), null);
INSERT INTO ADOPTERS(id, name, phoneNumber, email, is18, dateCreated, dateModified) VALUES (4, 'Kido Two Soto', '444-444-4444', 'leila.soto@email.com', false, now(), null);
INSERT INTO ADOPTERS(id, name, phoneNumber, email, is18, dateCreated, dateModified) VALUES (5, 'Kido Three Soto', '555-555-5555', 'levi.soto@email.com', false, now(), null);





INSERT INTO ANIMALS(id, name, type, dob, breed, adopter, adoptedDate) VALUES (1,'Fred', 'CAT', '2024-01-23', 'Siamese', null, null);
INSERT INTO ANIMALS(id, name, type, dob, breed, adopter, adoptedDate) VALUES  (2, 'CAT', 'Fido', '2023-07-29', 'persian', null, null);
INSERT INTO ANIMALS(id, name, type, dob, breed, adopter, adoptedDate) VALUES (3, 'DOG', 'Gracie', '2022-01-23', 'Terrier Mix', null, null);
INSERT INTO ANIMALS(id, name, type, dob, breed, adopter, adoptedDate) VALUES (4, 'DOG','Spot', '2023-12-24',  'German Malinois', null, null);
INSERT INTO ANIMALS(id, name, type, dob, breed, adopter, adoptedDate) VALUES (5, 'TURTLE', 'Slimy', '2022-03-23',  'Yellow Belly Slider', null, null);