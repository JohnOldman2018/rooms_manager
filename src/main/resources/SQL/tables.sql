CREATE TABLE Countries (
    code VARCHAR (2) PRIMARY KEY,
    name VARCHAR (70) NOT NULL
);

CREATE TABLE Rooms (
    room_ID INTEGER (8) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    room_name VARCHAR (150) NOT NULL,
    country_code VARCHAR (150) NOT NULL,
    light_is_on BIT DEFAULT 0 NOT NULL   
);
