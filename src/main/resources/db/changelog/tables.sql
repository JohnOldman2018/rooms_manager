--liquibase formatted sql
--changeset author:zhan logicalFilePath:create_table_country
CREATE TABLE country (
    code VARCHAR(2) PRIMARY KEY,
    name VARCHAR(70) NOT NULL
);
--rollback drop table country
--changeset author:zhan logicalFilePath:create_table_room
CREATE TABLE room (
    id BIGINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
    room_name VARCHAR(150) NOT NULL,
    country_code VARCHAR(2) NOT NULL,
    light_is_on TINYINT(0) NOT NULL,
    PRIMARY KEY (id)
);
--rollback drop table room
