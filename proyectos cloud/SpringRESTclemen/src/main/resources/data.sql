DROP TABLE IF EXISTS Cliente;

CREATE TABLE Cliente (
  id INT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  apellidos VARCHAR(50) NOT NULL,
  fecha DATE NULL,
  dni VARCHAR(50) NOT NULL
);

INSERT INTO Cliente (id, nombre, apellidos, fecha, dni) VALUES (1, 'Mariano', 'LDM', '2020-03-17','9999999');
INSERT INTO Cliente (id, nombre, apellidos, fecha, dni) VALUES (2, 'Jose', 'Perez', '2021-06-11','2222222');
INSERT INTO Cliente (id, nombre, apellidos, fecha, dni) VALUES (3, 'Fernan', 'Garcia', '2022-05-13','3333333');
INSERT INTO Cliente (id, nombre, apellidos, fecha, dni) VALUES (4, 'Laura', 'Panadero', '2023-01-14','1111111');
INSERT INTO Cliente (id, nombre, apellidos, fecha, dni) VALUES (5, 'Rosa', 'Lopez', '2024-02-15','4444444');
INSERT INTO Cliente (id, nombre, apellidos, fecha, dni) VALUES (6, 'Lucia', 'Fernandez', '2025-03-18','5555555');

