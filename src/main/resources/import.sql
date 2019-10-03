INSERT INTO `usuarios` (usuario, contrasena, usuario_activo,correo) VALUES ('admin','$2a$10$Fxm6q26fOKOQOh/GbXw03uL6XyiQd3157s9JhWlzQ6S911BUFLLCy',1,'admin@aevent.com');
INSERT INTO `usuarios` (usuario, contrasena, usuario_activo,correo) VALUES ('user_pres','$2a$10$eKmvl/ZziTfER4TDMY/QVe51oNvqNlDF7Olk3mDRJaSCVIy0u8fhG',1,'presidente@aevent.com');
INSERT INTO `usuarios` (usuario, contrasena, usuario_activo,correo) VALUES ('user_orga','$2a$10$wXn0WmXu5xkb18RsLpJF9uEv4Afk4EoBRGt2Vo4MToJ4lYx9XNJSW',1,'organizator@aevent.com');
INSERT INTO `usuarios` (usuario, contrasena, usuario_activo,correo) VALUES ('user_eval','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'evaluator@aevent.com');
INSERT INTO `usuarios` (usuario, contrasena, usuario_activo,correo) VALUES ('user_basic1','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic1@aevent.com');
INSERT INTO `usuarios` (usuario, contrasena, usuario_activo,correo) VALUES ('user_basic2','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic2@aevent.com');
INSERT INTO `usuarios` (usuario, contrasena, usuario_activo,correo) VALUES ('user_basic3','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic3@aevent.com');
INSERT INTO `usuarios` (usuario, contrasena, usuario_activo,correo) VALUES ('user_basic4','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic4@aevent.com');
INSERT INTO `usuarios` (usuario, contrasena, usuario_activo,correo) VALUES ('user_basic5','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic5@aevent.com');
INSERT INTO `usuarios` (usuario, contrasena, usuario_activo,correo) VALUES ('user_basic6','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic6@aevent.com');
INSERT INTO `usuarios` (usuario, contrasena, usuario_activo,correo) VALUES ('user_basic7','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic7@aevent.com');

INSERT INTO `personas` (apellido_mat, apellido_pat, dni, nombre, id_usuario) VALUES ( 'Doe','Towers', 43110193, 'Luis', 1);
INSERT INTO `personas` (apellido_mat, apellido_pat, dni, nombre, id_usuario) VALUES ( 'Jhon','Diane', 51231233, 'Jean', 2);
INSERT INTO `personas` (apellido_mat, apellido_pat, dni, nombre, id_usuario) VALUES ( 'Crux','Ophelia', 12331233, 'Patrick', 3);
INSERT INTO `personas` (apellido_mat, apellido_pat, dni, nombre, id_usuario) VALUES ( 'Thrown','Rex', 54542525, 'Ray', 4);
INSERT INTO `personas` (apellido_mat, apellido_pat, dni, nombre, id_usuario) VALUES ( 'Caryr','Michael', 12312333, 'Tom', 5);
INSERT INTO `personas` (apellido_mat, apellido_pat, dni, nombre, id_usuario) VALUES ( 'Mcketon','Gen', 12311235, 'Grey', 6);
INSERT INTO `personas` (apellido_mat, apellido_pat, dni, nombre, id_usuario) VALUES ( 'Tonic','Ten', 23442516, 'Roxxana', 7);
INSERT INTO `personas` (apellido_mat, apellido_pat, dni, nombre, id_usuario) VALUES ( 'Appleton','Ren', 76558754, 'Tricia', 8);
INSERT INTO `personas` (apellido_mat, apellido_pat, dni, nombre, id_usuario) VALUES ( 'Cartavio','Reo', 32441254, 'Caroline', 9);
INSERT INTO `personas` (apellido_mat, apellido_pat, dni, nombre, id_usuario) VALUES ( 'Gtew','Blen', 45667843, 'Esperanza', 10);
INSERT INTO `personas` (apellido_mat, apellido_pat, dni, nombre, id_usuario) VALUES ( 'Opress','Qwerty', 23441234, 'Trevor', 11);

INSERT INTO `roles` (id_rol,descripcion) VALUES (1,'ROLE_ADMIN');
INSERT INTO `roles` (id_rol,descripcion) VALUES (1,'ROLE_PRESIDENT');
INSERT INTO `roles` (id_rol,descripcion) VALUES (1,'ROLE_ORGANIZER');
INSERT INTO `roles` (id_rol,descripcion) VALUES (1,'ROLE_EVALUATOR');
INSERT INTO `roles` (id_rol,descripcion) VALUES (1,'ROLE_USER');

INSERT INTO `usuarios_roles` (id_usuario, id_rol) VALUES (1, 1);
INSERT INTO `usuarios_roles` (id_usuario, id_rol) VALUES (2, 2);
INSERT INTO `usuarios_roles` (id_usuario, id_rol) VALUES (3, 3);
INSERT INTO `usuarios_roles` (id_usuario, id_rol) VALUES (4, 4);
INSERT INTO `usuarios_roles` (id_usuario, id_rol) VALUES (5, 5);
INSERT INTO `usuarios_roles` (id_usuario, id_rol) VALUES (6, 5);
INSERT INTO `usuarios_roles` (id_usuario, id_rol) VALUES (7, 5);
INSERT INTO `usuarios_roles` (id_usuario, id_rol) VALUES (8, 5);
INSERT INTO `usuarios_roles` (id_usuario, id_rol) VALUES (9, 5);
INSERT INTO `usuarios_roles` (id_usuario, id_rol) VALUES (10, 5);
INSERT INTO `usuarios_roles` (id_usuario, id_rol) VALUES (11, 5);

INSERT INTO `categoria` (cod_categoria, descripcion) VALUES ('00000001', 'INTELIGENCIA ARTIFICIAL');
INSERT INTO `categoria` (cod_categoria, descripcion) VALUES ('00000002', 'VIDEOJUEGOS');
INSERT INTO `categoria` (cod_categoria, descripcion) VALUES ('00000003', 'TRANSFORMACION DIGITAL');
INSERT INTO `categoria` (cod_categoria, descripcion) VALUES ('00000004', 'INTERNET DE LAS COSAS');
INSERT INTO `categoria` (cod_categoria, descripcion) VALUES ('00000005', 'DESIGN THINKING');
INSERT INTO `categoria` (cod_categoria, descripcion) VALUES ('00000006', 'CONSTRUCCION CIVIL');
INSERT INTO `categoria` (cod_categoria, descripcion) VALUES ('00000007', 'EDUCACION');

INSERT INTO `parametro` (NOMBRE, ACTIVO) VALUES ('Pregunta abierta' , TRUE);
INSERT INTO `parametro` (NOMBRE, ACTIVO) VALUES ('Pregunta de opcion multiple' , TRUE);
INSERT INTO `parametro` (NOMBRE, ACTIVO) VALUES ('Pregunta de formulario' , TRUE);
