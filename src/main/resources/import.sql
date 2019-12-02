INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo, nombre_completo,modo_inicio_sesion,fecha_creacion,eval_sin_leer) VALUES ('admin','$2a$10$Fxm6q26fOKOQOh/GbXw03uL6XyiQd3157s9JhWlzQ6S911BUFLLCy',1,'admin@aevent.com', 'Doe Towers Luis',0,'2019-07-12',0);
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo, nombre_completo,modo_inicio_sesion,fecha_creacion,eval_sin_leer) VALUES ('user_pres','$2a$10$eKmvl/ZziTfER4TDMY/QVe51oNvqNlDF7Olk3mDRJaSCVIy0u8fhG',1,'presidente@aevent.com', 'Jhon Diane Jean',0,'2019-07-12',0);
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo, nombre_completo,modo_inicio_sesion,fecha_creacion,eval_sin_leer) VALUES ('user_orga','$2a$10$wXn0WmXu5xkb18RsLpJF9uEv4Afk4EoBRGt2Vo4MToJ4lYx9XNJSW',1,'organizator@aevent.com', 'Crux Ophelia Patrick',0,'2019-07-12',0);
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo, nombre_completo,modo_inicio_sesion,fecha_creacion,eval_sin_leer) VALUES ('user_eval','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'evaluator@aevent.com', 'Thrown Rex Ray',0,'2019-07-12',0);
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo, nombre_completo,modo_inicio_sesion,fecha_creacion,eval_sin_leer) VALUES ('user_basic1','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic1@aevent.com', 'Caryr Michael Tom',0,'2019-07-12',0);
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo, nombre_completo,modo_inicio_sesion,fecha_creacion,eval_sin_leer) VALUES ('user_basic2','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic2@aevent.com', 'Mcketon Gen Grey',0,'2019-07-12',0);
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo, nombre_completo,modo_inicio_sesion,fecha_creacion,eval_sin_leer) VALUES ('user_basic3','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic3@aevent.com', 'Tonic Ten Roxxana',0,'2019-07-12',0);
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo, nombre_completo,modo_inicio_sesion,fecha_creacion,eval_sin_leer) VALUES ('user_basic4','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic4@aevent.com', 'Appleton Ren Tricia',0,'2019-07-12',0);
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo, nombre_completo,modo_inicio_sesion,fecha_creacion,eval_sin_leer) VALUES ('user_basic5','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic5@aevent.com', 'Cartavio Reo Caroline',0,'2019-07-12',0);
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo, nombre_completo,modo_inicio_sesion,fecha_creacion,eval_sin_leer) VALUES ('user_basic6','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic6@aevent.com', 'Gtew Blen Esperanza',0,'2019-07-12',0);
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo, nombre_completo,modo_inicio_sesion,fecha_creacion,eval_sin_leer) VALUES ('user_basic7','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic7@aevent.com', 'Opress Qwerty Trevor',0,'2019-07-12',0);

INSERT INTO `persona` (apellido_mat, apellido_pat, nombre, id_usuario) VALUES ( 'Doe','Towers', 'Luis', 1);
INSERT INTO `persona` (apellido_mat, apellido_pat, nombre, id_usuario) VALUES ( 'Jhon','Diane', 'Jean', 2);
INSERT INTO `persona` (apellido_mat, apellido_pat, nombre, id_usuario) VALUES ( 'Crux','Ophelia', 'Patrick', 3);
INSERT INTO `persona` (apellido_mat, apellido_pat, nombre, id_usuario) VALUES ( 'Thrown','Rex', 'Ray', 4);
INSERT INTO `persona` (apellido_mat, apellido_pat, nombre, id_usuario) VALUES ( 'Caryr','Michael', 'Tom', 5);
INSERT INTO `persona` (apellido_mat, apellido_pat, nombre, id_usuario) VALUES ( 'Mcketon','Gen', 'Grey', 6);
INSERT INTO `persona` (apellido_mat, apellido_pat, nombre, id_usuario) VALUES ( 'Tonic','Ten', 'Roxxana', 7);
INSERT INTO `persona` (apellido_mat, apellido_pat, nombre, id_usuario) VALUES ( 'Appleton','Ren', 'Tricia', 8);
INSERT INTO `persona` (apellido_mat, apellido_pat, nombre, id_usuario) VALUES ( 'Cartavio','Reo', 'Caroline', 9);
INSERT INTO `persona` (apellido_mat, apellido_pat, nombre, id_usuario) VALUES ( 'Gtew','Blen', 'Esperanza', 10);
INSERT INTO `persona` (apellido_mat, apellido_pat, nombre, id_usuario) VALUES ( 'Opress','Qwerty', 'Trevor', 11);

INSERT INTO `role` (rol_activo,descripcion) VALUES (1,'ROLE_ADMIN');
INSERT INTO `role` (rol_activo,descripcion) VALUES (1,'ROLE_ORGANIZER');
INSERT INTO `role` (rol_activo,descripcion) VALUES (1,'ROLE_DEFAULT');

INSERT INTO `usuario_role` (id_usuario, id_rol) VALUES (1, 1);
INSERT INTO `usuario_role` (id_usuario, id_rol) VALUES (2, 3);
INSERT INTO `usuario_role` (id_usuario, id_rol) VALUES (3, 2);
INSERT INTO `usuario_role` (id_usuario, id_rol) VALUES (4, 3);
INSERT INTO `usuario_role` (id_usuario, id_rol) VALUES (5, 3);
INSERT INTO `usuario_role` (id_usuario, id_rol) VALUES (6, 3);
INSERT INTO `usuario_role` (id_usuario, id_rol) VALUES (7, 3);
INSERT INTO `usuario_role` (id_usuario, id_rol) VALUES (8, 3);
INSERT INTO `usuario_role` (id_usuario, id_rol) VALUES (9, 3);
INSERT INTO `usuario_role` (id_usuario, id_rol) VALUES (10, 3);
INSERT INTO `usuario_role` (id_usuario, id_rol) VALUES (11, 3);

INSERT INTO `categoria` (cod_categoria, descripcion,estado) VALUES ('00000001', 'INTELIGENCIA ARTIFICIAL',1);
INSERT INTO `categoria` (cod_categoria, descripcion,estado) VALUES ('00000002', 'VIDEOJUEGOS',1);
INSERT INTO `categoria` (cod_categoria, descripcion,estado) VALUES ('00000003', 'TRANSFORMACIÓN DIGITAL',1);
INSERT INTO `categoria` (cod_categoria, descripcion,estado) VALUES ('00000004', 'INTERNET DE LAS COSAS',1);
INSERT INTO `categoria` (cod_categoria, descripcion,estado) VALUES ('00000005', 'DESIGN THINKING',1);

INSERT INTO `parametro` (DESCRIPCION,DESCRIPCION_CORTA, ACTIVO) VALUES ('Pregunta abierta','TIPO_PREGUNTA' , TRUE);

INSERT INTO `tipoevento` ( descripcion, estado) VALUES("CHARLA",1);
INSERT INTO `tipoevento` ( descripcion, estado) VALUES("TALLER",1);
INSERT INTO `tipoevento` ( descripcion, estado) VALUES("WORKSHOP",1);
INSERT INTO `tipoevento` ( descripcion, estado) VALUES("SEMINARIO",1);
INSERT INTO `tipoevento` ( descripcion, estado) VALUES("OTROS",1);

INSERT INTO `lugar` (descripcion, estado) VALUES("CENTRO DE CONVENCIONES AEVENT", 1);

INSERT INTO `tipo_criterio` (descripcion, estado) VALUES ('Pregunta abierta', 1);

///////Email de aplicativo
INSERT INTO `email` (direccion,pass) VALUES ("aeventmailing@gmail.com","amuaawbbmtsidmho");
///////TRIGGERS

CREATE TRIGGER `UPDATE_PASSWORD` BEFORE UPDATE ON `usuario` FOR EACH ROW BEGIN DECLARE PASSWORD_OLD VARCHAR(60); SELECT CONTRASENA INTO PASSWORD_OLD  FROM usuario US WHERE NEW.ID_USUARIO=US.ID_USUARIO; IF NEW.CONTRASENA IS NULL OR NEW.CONTRASENA = "" THEN SET NEW.CONTRASENA = PASSWORD_OLD; END IF; END;