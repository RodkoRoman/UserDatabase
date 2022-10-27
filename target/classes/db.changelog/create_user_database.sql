--liquibase formatted sql

--changeset dbms:postgresql
CREATE TABLE IF NOT EXISTS user_database.user
(
    id                          uuid PRIMARY KEY,
    surname                     varchar,
    name                        varchar,
    patronymic                  varchar,
    date_of_Birth               date,
    mail                        varchar,
    phone_number                varchar,
    address_photo               varchar
);