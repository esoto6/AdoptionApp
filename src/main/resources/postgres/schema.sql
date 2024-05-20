DROP ROLE IF EXISTS larku;
CREATE USER larku password 'larku' CREATEDB CREATEROLE;

ALTER ROLE larku WITH LOGIN;
ALTER ROLE larku INHERIT;

ALTER DATABASE adoption_jdbc OWNER TO larku;

SET ROLE larku;

DROP TABLE IF EXISTS ADOPTERS;
DROP TABLE IF EXISTS ANIMALS;

CREATE TABLE ADOPTERS
(
    id           SERIAL PRIMARY KEY NOT NULL,
    name         varchar(255),
    phoneNumber  varchar(255),
    email        varchar(255),
    is18         BOOLEAN            NOT NULL,
    dateCreated  DATE,
    dateModified DATE
);

CREATE TABLE ANIMALS
(
    id          SERIAL PRIMARY KEY NOT NULL,
    name        varchar(255),
    type        varchar(255),
    dob         DATE,
    breed       varchar(255),
    adoptedDate DATE,
    adopter     integer,
    foreign key (adopter) references ADOPTERS (id)
);

CREATE UNIQUE INDEX idx_adopter_id ON ADOPTERS (id ASC);
CREATE UNIQUE INDEX idx_animal_id ON ANIMALS (id ASC);

-- Insert Adopters Data
INSERT INTO ADOPTERS(name, phoneNumber, email, is18, dateCreated, dateModified)
VALUES ('Edwin Soto', '111-111-1111', 'edwin.soto@email.com', true, now(), null);
INSERT INTO ADOPTERS(name, phoneNumber, email, is18, dateCreated, dateModified)
VALUES ('Spouse Soto', '222-222-2222', 'spouse.soto@email.com', true, now(), null);
INSERT INTO ADOPTERS(name, phoneNumber, email, is18, dateCreated, dateModified)
VALUES ('Kido One Soto', '333-333-3333', 'kido1.soto@email.com', false, now(), null);
INSERT INTO ADOPTERS(name, phoneNumber, email, is18, dateCreated, dateModified)
VALUES ('Kido Two Soto', '444-444-4444', 'kido2.soto@email.com', false, now(), null);
INSERT INTO ADOPTERS(name, phoneNumber, email, is18, dateCreated, dateModified)
VALUES ('Kido Three Soto', '555-555-5555', 'kido3.soto@email.com', false, now(), null);

-- Insert Animals Data
INSERT INTO ANIMALS(name, type, dob, breed, adopter, adoptedDate)
VALUES ('Fred', 'CAT', '2024-01-23', 'Siamese', null, null);
INSERT INTO ANIMALS(name, type, dob, breed, adopter, adoptedDate)
VALUES ('Fido', 'CAT', '2023-07-29', 'persian', null, null);
INSERT INTO ANIMALS(name, type, dob, breed, adopter, adoptedDate)
VALUES ('Gracie', 'DOG', '2022-01-23', 'Terrier Mix', null, null);
INSERT INTO ANIMALS(name, type, dob, breed, adopter, adoptedDate)
VALUES ('Spot', 'DOG', '2023-12-24', 'German Malinois', null, null);
INSERT INTO ANIMALS(name, type, dob, breed, adopter, adoptedDate)
VALUES ('Slimy', 'TURTLE', '2022-03-23', 'Yellow Belly Slider', null, null);