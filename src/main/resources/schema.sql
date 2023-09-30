CREATE TABLE IF NOT EXISTS KILLERS(
                     id BIGINT PRIMARY KEY AUTO_INCREMENT,
                     name VARCHAR(50) NOT NULL ,
                     file VARCHAR(250) NOT NULL
);

CREATE TABLE IF NOT EXISTS MAPS(
                    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
                    name VARCHAR(50) NOT NULL ,
                    file VARCHAR(250) NOT NULL
);

CREATE TABLE IF NOT EXISTS TEAMS(
                     id BIGINT AUTO_INCREMENT PRIMARY KEY ,
                     name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS MATCHES(
                      id BIGINT AUTO_INCREMENT PRIMARY KEY ,
                      team1 VARCHAR(50) NOT NULL ,
                      team2 VARCHAR(50) NOT NULL ,
                      killer VARCHAR(50),
                      map VARCHAR(50),
                      addon VARCHAR(50),
                      result VARCHAR(50),
                      point1 int,
                      point2 int
);