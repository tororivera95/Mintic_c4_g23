/* Populate tabla clientes */

INSERT INTO regiones (id, region_nombre) VALUES (1, 'Sudamérica');
INSERT INTO regiones (id, region_nombre) VALUES (2, 'Centroamérica');
INSERT INTO regiones (id, region_nombre) VALUES (3, 'Norteamérica');
INSERT INTO regiones (id, region_nombre) VALUES (4, 'Europa');
INSERT INTO regiones (id, region_nombre) VALUES (5, 'Asia');
INSERT INTO regiones (id, region_nombre) VALUES (6, 'Africa');
INSERT INTO regiones (id, region_nombre) VALUES (7, 'Oceanía');
INSERT INTO regiones (id, region_nombre) VALUES (8, 'Antártida');

INSERT INTO clientes (region_id, nom_cliente, apelli_cliente, email_cliente, create_at) VALUES(1, 'Andrés', 'Guzmán', 'profesor@bolsadeideas.com', '2018-01-01');
INSERT INTO clientes (region_id, nom_cliente, apelli_cliente, email_cliente, create_at) VALUES(2, 'Mr. John', 'Doe', 'john.doe@gmail.com', '2018-01-02');
INSERT INTO clientes (region_id, nom_cliente, apelli_cliente, email_cliente, create_at) VALUES(4, 'Linus', 'Torvalds', 'linus.torvalds@gmail.com', '2018-01-03');
INSERT INTO clientes (region_id, nom_cliente, apelli_cliente, email_cliente, create_at) VALUES(4, 'Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2018-01-04');
INSERT INTO clientes (region_id, nom_cliente, apelli_cliente, email_cliente, create_at) VALUES(4, 'Erich', 'Gamma', 'erich.gamma@gmail.com', '2018-02-01');
INSERT INTO clientes (region_id, nom_cliente, apelli_cliente, email_cliente, create_at) VALUES(3, 'Richard', 'Helm', 'richard.helm@gmail.com', '2018-02-10');
INSERT INTO clientes (region_id, nom_cliente, apelli_cliente, email_cliente, create_at) VALUES(3, 'Ralph', 'Johnson', 'ralph.johnson@gmail.com', '2018-02-18');
INSERT INTO clientes (region_id, nom_cliente, apelli_cliente, email_cliente, create_at) VALUES(3, 'John', 'Vlissides', 'john.vlissides@gmail.com', '2018-02-28');
INSERT INTO clientes (region_id, nom_cliente, apelli_cliente, email_cliente, create_at) VALUES(3, 'Dr. James', 'Gosling', 'james.gosling@gmail.com', '2018-03-03');
INSERT INTO clientes (region_id, nom_cliente, apelli_cliente, email_cliente, create_at) VALUES(5, 'Magma', 'Lee', 'magma.lee@gmail.com', '2018-03-04');
INSERT INTO clientes (region_id, nom_cliente, apelli_cliente, email_cliente, create_at) VALUES(6, 'Tornado', 'Roe', 'tornado.roe@gmail.com', '2018-03-05');
INSERT INTO clientes (region_id, nom_cliente, apelli_cliente, email_cliente, create_at) VALUES(7, 'Jade', 'Doe', 'jane.doe@gmail.com', '2018-03-06');

INSERT INTO usuarios (username, password, enabled, nom_usuario, apell_usuario, email_usuario) VALUES ('andres','$2a$10$WtcsojMuqF4Q3F.LuTRrt.fR1A1wuBdp3cOxBaGRd6ZmQlISwzMk2',true, 'Andres', 'Guzman','profesor@gmail.com');
INSERT INTO usuarios (username, password, enabled, nom_usuario, apell_usuario, email_usuario) VALUES ('admin','$2a$10$vhlg9fXuFn75IRQowmNe9uaiAhqn3NJQJtKfiDIAnoFquNUf/FNQa',true, 'John', 'Doe','jhon.doe@gmail.com');

INSERT INTO roles (id,nom_Rol) VALUES (1,'ROLE_USER');
INSERT INTO roles (id,nom_Rol) VALUES (2,'ROLE_ADMIN');

INSERT INTO usuario_roles (usuario_id, roles_id) VALUES (1, 1);
INSERT INTO usuario_roles (usuario_id, roles_id) VALUES (2, 2);
INSERT INTO usuario_roles (usuario_id, roles_id) VALUES (2, 1);

