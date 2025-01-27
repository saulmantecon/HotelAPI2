DROP DATABASE IF EXISTS hotelesapi;
create database hotelesapi;
use hotelesapi;
CREATE TABLE hoteles
(
    id_hotel     INT     NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre      varchar(20) unique,
    descripcion varchar(100),
    categoria   varchar(20),
    piscina     boolean not null,
    localidad   varchar(20)

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  AUTO_INCREMENT = 1;

CREATE TABLE habitaciones
(
    id_habitacion int     not null auto_increment primary key,
    tamano       int     not null,
    precio_noche  double  not null,
    desayuno     boolean not null,
    ocupada      boolean not null,
    id_hotel      int,
    foreign key (id_hotel) references hoteles (id_hotel)

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  AUTO_INCREMENT = 1;

CREATE TABLE users
(
    id_user bigint not null auto_increment primary key,
    username   varchar(50) unique,
    pwd    varchar(50)

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  AUTO_INCREMENT = 1;