DROP DATABASE IF EXISTS hotelesapi;
create database hotelesapi;
use hotelesapi;
CREATE TABLE hoteles(
                        id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        nombre varchar(20) unique,
                        descripcion varchar(100),
                        categoria varchar(20),
                        piscina boolean not null,
                        localidad varchar(20)

) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

CREATE TABLE habitaciones(
                             id int not null auto_increment primary key,
                             tamano int not null,
                             precioNoche double not null,
                             desayuno boolean not null,
                             ocupada boolean not null,
                             idHotel int,
                             foreign key (idHotel) references hoteles(id)

)ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;