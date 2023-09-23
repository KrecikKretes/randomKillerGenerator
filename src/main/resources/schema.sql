DROP TABLE IF EXISTS KILLERS;
DROP TABLE IF EXISTS MAPS;

CREATE TABLE KILLERS(
                     id BIGINT AUTO_INCREMENT PRIMARY KEY ,
                     name VARCHAR(50) NOT NULL ,
                     file VARCHAR(250) NOT NULL
);

CREATE TABLE MAPS(
                    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
                    name VARCHAR(50) NOT NULL ,
                    file VARCHAR(250) NOT NULL
);