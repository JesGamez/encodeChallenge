create database encode;
use encode;

CREATE TABLE Suscripcion (
    IdAsociacion int  NOT NULL IDENTITY,
    IdSuscriptor int  NOT NULL,
    FechaAlta date  NOT NULL,
    FechaFin date  NOT NULL,
    MotivoFin varchar(90)  NOT NULL,
    CONSTRAINT Suscripcion_pk PRIMARY KEY  (IdAsociacion)
);

-- Table: Suscriptor
CREATE TABLE Suscriptor (
    IdSuscriptor int  NOT NULL IDENTITY,
    Nombre varchar(70)  NOT NULL,
    Apellido varchar(70)  NOT NULL,
    NumeroDocumento varchar(15)  NOT NULL,
    TipoDocumento varchar(15)  NOT NULL,
    Direccion varchar(70)  NOT NULL,
    Telefono char(9)  NOT NULL,
    Email varchar(70)  NOT NULL,
    NombreUsuario varchar(70)  NOT NULL,
    Password varchar(70)  NOT NULL,
    CONSTRAINT Suscriptor_pk PRIMARY KEY  (IdSuscriptor)
);

-- foreign keys
-- Reference: Suscripcion_Suscriptor (table: Suscripcion)
ALTER TABLE Suscripcion ADD CONSTRAINT Suscripcion_Suscriptor
    FOREIGN KEY (IdSuscriptor)
    REFERENCES Suscriptor (IdSuscriptor);

-- End of file.

INSERT INTO Suscriptor VALUES ('jesus','gamez','12345678','DNI','san jose','123456789','asd@gmail.com','jeshu123','123');

select * from Suscriptor
