INSERT INTO clientes (nom_cliente, apelli_cliente, email_cliente, create_at) VALUES('Andres', 'Guzman', 'AndresGuzman@hotmail.com', '2013-01-01');
INSERT INTO clientes (nom_cliente, apelli_cliente, email_cliente, create_at) VALUES('Laura', 'Giraldo', 'LauraGiraldo@hotmail.com', '2014-12-01');
INSERT INTO clientes (nom_cliente, apelli_cliente, email_cliente, create_at) VALUES('Lorena', 'Lopez', 'Lore123@hotmail.com', '2011-11-11');
INSERT INTO clientes (nom_cliente, apelli_cliente, email_cliente, create_at) VALUES('Gilberto', 'Lorenzo', 'GilberLo32@hotmail.com', '2000-10-01');
INSERT INTO clientes (nom_cliente, apelli_cliente, email_cliente, create_at) VALUES('Claudia', 'Perez', 'Clau@hotmail.com', '2011-11-11');
INSERT INTO clientes (nom_cliente, apelli_cliente, email_cliente, create_at) VALUES('Bety', 'Arcila', 'BetyArcila4564@hotmail.com', '2004-04-05');
INSERT INTO clientes (nom_cliente, apelli_cliente, email_cliente, create_at) VALUES('Alejandro', 'Florez', 'florezAlejo@hotmail.com', '2005-02-02');
INSERT INTO clientes (nom_cliente, apelli_cliente, email_cliente, create_at) VALUES('Pedro', 'Salas', 'SalasPedrito@gmail.com', '2009-11-01');
INSERT INTO clientes (nom_cliente, apelli_cliente, email_cliente, create_at) VALUES('Catherine', 'Ramirez', 'kateRami@yahoo.com', '2020-11-11');
INSERT INTO clientes (nom_cliente, apelli_cliente, email_cliente, create_at) VALUES('Camilo', 'Hernandez', 'HernanCami@gmail.com', '2018-06-04');

INSERT INTO roles (id,nom_Rol) VALUES (1,'ROLE_USER');
INSERT INTO roles (id,nom_Rol) VALUES (2,'ROLE_ADMIN');

INSERT INTO usuarios (username, password, enabled, nom_usuario, apell_usuario, email_usuario) VALUES ('andres','$2a$10$WtcsojMuqF4Q3F.LuTRrt.fR1A1wuBdp3cOxBaGRd6ZmQlISwzMk2',true, 'Andres', 'Guzman','profesor@gmail.com');
INSERT INTO usuarios (username, password, enabled, nom_usuario, apell_usuario, email_usuario) VALUES ('admin','$2a$10$vhlg9fXuFn75IRQowmNe9uaiAhqn3NJQJtKfiDIAnoFquNUf/FNQa',true, 'John', 'Doe','jhon.doe@gmail.com');

INSERT INTO usuario_roles (usuario_id, roles_id) VALUES (1, 1);
INSERT INTO usuario_roles (usuario_id, roles_id) VALUES (2, 2);
INSERT INTO usuario_roles (usuario_id, roles_id) VALUES (2, 1);