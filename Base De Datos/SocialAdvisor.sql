CREATE TABLE Comercio(
	ID_Comercio INTEGER PRIMARY KEY NOT NULL,
	Nombre_Comercio VARCHAR NOT NULL,
	Telefono_Comercio VARCHAR(9),
	Movil_Comercio VARCHAR(9),
	Facebook_Comercio VARCHAR,
	Messenger_Comercio VARCHAR,
	SitioWeb_Comercio VARCHAR,
	Descripcion_Comercio VARCHAR,
	ID_TipoComercio INTEGER,
	ID_Municipio INTEGER,
	ID_Capacidad INTEGER
);
CREATE TABLE Departamento(
	ID_Departamento INTEGER PRIMARY KEY NOT NULL,
	Nombre_Departamento VARCHAR NOT NULL
);
CREATE TABLE Capacidad_Comercio(
	ID_Capacidad_Comercio INTEGER PRIMARY KEY NOT NULL,
	Cantidad_Servidores INTEGER NOT NULL,
	Cantidad_MAX_Clientes_Cola INTEGER
);
CREATE TABLE Tipo_Comercio(
	ID_Tipo_Comercio INTEGER PRIMARY KEY NOT NULL,
	Nombre_Tipo_Comercio VARCHAR
);

CREATE TABLE Municipio(
	ID_Municipio INTEGER PRIMARY KEY NOT NULL,
	Nombre_Municipio VARCHAR NOT NULL,
	ID_Departamento INTEGER NOT NULL
);
CREATE TABLE Cliente(
	ID_Cliente INTEGER PRIMARY KEY NOT NULL,
	Contrasenia_Cliente VARCHAR NOT NULL,
	Telefono_Cliente VARCHAR,
	CorreoElectronico_Cliente VARCHAR NOT NULL,
	ID_Municipio INTEGER NOT NULL
);

CREATE TABLE Cita(
	ID_Cita INTEGER PRIMARY KEY NOT NULL,
	ID_Comercio INTEGER NOT NULL,
	ID_Horario INTEGER NOT NULL,
	ID_Cliente INTEGER NOT NULL,
	ID_Estado_Cita INTEGER NOT NULL
);

CREATE TABLE Horario(
	ID_Horario INTEGER PRIMARY KEY NOT NULL,
	Hora_Inicio TIMESTAMP NOT NULL,
	Hora_Final TIMESTAMP,
	Fecha_Inicio DATE NOT NULL,
	Fecha_Final DATE
);

CREATE TABLE Estado_Cita(
	ID_Estado_Cita INTEGER PRIMARY KEY NOT NULL,
	Nombre_Estado VARCHAR,
	Valor_Estado BOOLEAN NOT NULL
);

CREATE TABLE Tipo_Servicio(
	ID_Tipo_Servicio INTEGER PRIMARY KEY NOT NULL,
	Nombre_Tipo_Servicio VARCHAR NOT NULL
);

CREATE TABLE Comercio_X_TipoServicio(
	ID_Comercio INTEGER NOT NULL,
	ID_TipoServicio INTEGER NOT NULL
);

CREATE TABLE Horario_X_Comercio(
	ID_HORARIO INTEGER NOT NULL,
	ID_Comercio INTEGER NOT NULL
);

CREATE TABLE Normativa(
	ID_Normativa INTEGER PRIMARY KEY NOT NULL,
	Descripcion_Normativa VARCHAR NOT NULL,
	Adjunto_Normativa VARCHAR NOT NULL,
	ID_Tipo_Normativa INTEGER NOT NULL,
	Fecha_De_Publicacion_Normativa DATE NOT NULL
);

CREATE TABLE Tipo_Normativa(
	ID_Normativa INTEGER PRIMARY KEY NOT NULL,
	Nombre_Tipo_Normativa VARCHAR NOT NULL
);

CREATE TABLE Comercio_X_Normativa(
	ID_Normativa INTEGER NOT NULL,
	ID_Comercio INTEGER NOT NULL
);

CREATE TABLE Cola(
	ID_Cola INTEGER NOT NULL PRIMARY KEY,
	Tiempo_esperado TIMESTAMP NOT NULL,
	ID_Comercio INTEGER NOT NULL,
	ID_Tipo_Cola INTEGER NOT NULL,
	ID_Tipo_Servicio INTEGER NOT NULL
);

CREATE TABLE Tipo_Cola(
	ID_Tipo_Cola INTEGER NOT NULL PRIMARY KEY,
	Nombre_Tipo_Cola VARCHAR NOT NULL,
	Valor_Tipo_Cola BOOLEAN NOT NULL
);

CREATE TABLE Cliente_X_Cola(
	ID_Cliente INTEGER NOT NULL,
	ID_Cola INTEGER NOT NULL
);

ALTER TABLE Municipio ADD FOREIGN KEY (ID_Departamento) REFERENCES Departamento(ID_Departamento);

ALTER TABLE Comercio ADD FOREIGN KEY (ID_TipoComercio) REFERENCES Tipo_Comercio(ID_Tipo_Comercio);
ALTER TABLE Comercio ADD FOREIGN KEY (ID_Municipio) REFERENCES Municipio(ID_Municipio);
ALTER TABLE Comercio ADD FOREIGN KEY (ID_Capacidad) REFERENCES Capacidad_Comercio(ID_Capacidad_Comercio);

ALTER TABLE Cliente ADD FOREIGN KEY (ID_Municipio) REFERENCES Municipio(ID_Municipio);

ALTER TABLE Cita ADD FOREIGN KEY (ID_Comercio) REFERENCES Comercio(ID_Comercio);
ALTER TABLE Cita ADD FOREIGN KEY (ID_Horario) REFERENCES Horario(ID_Horario);
ALTER TABLE Cita ADD FOREIGN KEY (ID_Cliente) REFERENCES Cliente(ID_Cliente);
ALTER TABLE Cita ADD FOREIGN KEY (ID_Estado_Cita) REFERENCES Estado_Cita(ID_Estado_Cita);

ALTER TABLE Cola ADD FOREIGN KEY (ID_Comercio) REFERENCES Comercio(ID_Comercio);
ALTER TABLE Cola ADD FOREIGN KEY (ID_Tipo_Cola) REFERENCES Tipo_Cola(ID_Tipo_Cola);
ALTER TABLE Cola ADD FOREIGN KEY (ID_Tipo_Servicio) REFERENCES Tipo_Servicio(ID_Tipo_Servicio);

ALTER TABLE Normativa ADD FOREIGN KEY (ID_Tipo_Normativa) REFERENCES Tipo_Normativa(ID_Normativa);

ALTER TABLE Comercio_X_TipoServicio ADD FOREIGN KEY (ID_Comercio) REFERENCES Comercio(ID_Comercio);
ALTER TABLE Comercio_X_TipoServicio ADD FOREIGN KEY (ID_TipoServicio) REFERENCES Tipo_Servicio(ID_Tipo_Servicio);

ALTER TABLE Horario_X_Comercio ADD FOREIGN KEY (ID_Horario) REFERENCES Horario(ID_Horario);
ALTER TABLE Horario_X_Comercio ADD FOREIGN KEY (ID_Comercio) REFERENCES Comercio(ID_Comercio);

ALTER TABLE Cliente_X_Cola ADD FOREIGN KEY (ID_Cliente) REFERENCES Cliente(ID_Cliente);
ALTER TABLE Cliente_X_Cola ADD FOREIGN KEY (ID_Cola) REFERENCES Cola(ID_Cola);

ALTER TABLE Comercio_X_Normativa ADD FOREIGN KEY (ID_Normativa) REFERENCES Normativa(ID_Normativa);
ALTER TABLE Comercio_X_Normativa ADD FOREIGN KEY (ID_Comercio) REFERENCES Comercio(ID_Comercio);
