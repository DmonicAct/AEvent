INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo) VALUES ('admin','$2a$10$Fxm6q26fOKOQOh/GbXw03uL6XyiQd3157s9JhWlzQ6S911BUFLLCy',1,'admin@aevent.com');
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo) VALUES ('user_pres','$2a$10$eKmvl/ZziTfER4TDMY/QVe51oNvqNlDF7Olk3mDRJaSCVIy0u8fhG',1,'presidente@aevent.com');
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo) VALUES ('user_orga','$2a$10$wXn0WmXu5xkb18RsLpJF9uEv4Afk4EoBRGt2Vo4MToJ4lYx9XNJSW',1,'organizator@aevent.com');
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo) VALUES ('user_eval','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'evaluator@aevent.com');
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo) VALUES ('user_basic1','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic1@aevent.com');
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo) VALUES ('user_basic2','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic2@aevent.com');
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo) VALUES ('user_basic3','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic3@aevent.com');
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo) VALUES ('user_basic4','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic4@aevent.com');
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo) VALUES ('user_basic5','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic5@aevent.com');
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo) VALUES ('user_basic6','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic6@aevent.com');
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo) VALUES ('user_basic7','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic7@aevent.com');

INSERT INTO `persona` (apellido_mat, apellido_pat, dni, nombre, id_usuario) VALUES ( 'Doe','Towers', 43110193, 'Luis', 1);
INSERT INTO `persona` (apellido_mat, apellido_pat, dni, nombre, id_usuario) VALUES ( 'Jhon','Diane', 51231233, 'Jean', 2);
INSERT INTO `persona` (apellido_mat, apellido_pat, dni, nombre, id_usuario) VALUES ( 'Crux','Ophelia', 12331233, 'Patrick', 3);
INSERT INTO `persona` (apellido_mat, apellido_pat, dni, nombre, id_usuario) VALUES ( 'Thrown','Rex', 54542525, 'Ray', 4);
INSERT INTO `persona` (apellido_mat, apellido_pat, dni, nombre, id_usuario) VALUES ( 'Caryr','Michael', 12312333, 'Tom', 5);
INSERT INTO `persona` (apellido_mat, apellido_pat, dni, nombre, id_usuario) VALUES ( 'Mcketon','Gen', 12311235, 'Grey', 6);
INSERT INTO `persona` (apellido_mat, apellido_pat, dni, nombre, id_usuario) VALUES ( 'Tonic','Ten', 23442516, 'Roxxana', 7);
INSERT INTO `persona` (apellido_mat, apellido_pat, dni, nombre, id_usuario) VALUES ( 'Appleton','Ren', 76558754, 'Tricia', 8);
INSERT INTO `persona` (apellido_mat, apellido_pat, dni, nombre, id_usuario) VALUES ( 'Cartavio','Reo', 32441254, 'Caroline', 9);
INSERT INTO `persona` (apellido_mat, apellido_pat, dni, nombre, id_usuario) VALUES ( 'Gtew','Blen', 45667843, 'Esperanza', 10);
INSERT INTO `persona` (apellido_mat, apellido_pat, dni, nombre, id_usuario) VALUES ( 'Opress','Qwerty', 23441234, 'Trevor', 11);

INSERT INTO `role` (rol_activo,descripcion) VALUES (1,'ROLE_ADMIN');
INSERT INTO `role` (rol_activo,descripcion) VALUES (1,'ROLE_PRESIDENT');
INSERT INTO `role` (rol_activo,descripcion) VALUES (1,'ROLE_ORGANIZER');
INSERT INTO `role` (rol_activo,descripcion) VALUES (1,'ROLE_EVALUATOR');
INSERT INTO `role` (rol_activo,descripcion) VALUES (1,'ROLE_USER');

INSERT INTO `usuario_role` (id_usuario, id_rol) VALUES (1, 1);
INSERT INTO `usuario_role` (id_usuario, id_rol) VALUES (2, 2);
INSERT INTO `usuario_role` (id_usuario, id_rol) VALUES (3, 3);
INSERT INTO `usuario_role` (id_usuario, id_rol) VALUES (4, 4);
INSERT INTO `usuario_role` (id_usuario, id_rol) VALUES (5, 5);
INSERT INTO `usuario_role` (id_usuario, id_rol) VALUES (6, 5);
INSERT INTO `usuario_role` (id_usuario, id_rol) VALUES (7, 5);
INSERT INTO `usuario_role` (id_usuario, id_rol) VALUES (8, 5);
INSERT INTO `usuario_role` (id_usuario, id_rol) VALUES (9, 5);
INSERT INTO `usuario_role` (id_usuario, id_rol) VALUES (10, 5);
INSERT INTO `usuario_role` (id_usuario, id_rol) VALUES (11, 5);

INSERT INTO `categoria` (cod_categoria, descripcion,estado) VALUES ('00000001', 'INTELIGENCIA ARTIFICIAL',1);
INSERT INTO `categoria` (cod_categoria, descripcion,estado) VALUES ('00000002', 'VIDEOJUEGOS',1);
INSERT INTO `categoria` (cod_categoria, descripcion,estado) VALUES ('00000003', 'TRANSFORMACION DIGITAL',1);
INSERT INTO `categoria` (cod_categoria, descripcion,estado) VALUES ('00000004', 'INTERNET DE LAS COSAS',1);
INSERT INTO `categoria` (cod_categoria, descripcion,estado) VALUES ('00000005', 'DESIGN THINKING',1);
INSERT INTO `categoria` (cod_categoria, descripcion,estado) VALUES ('00000006', 'CONSTRUCCION CIVIL',1);
INSERT INTO `categoria` (cod_categoria, descripcion,estado) VALUES ('00000007', 'EDUCACION',1);

INSERT INTO `parametro` (DESCRIPCION, ACTIVO) VALUES ('Pregunta abierta' , TRUE);
INSERT INTO `parametro` (DESCRIPCION, ACTIVO) VALUES ('Pregunta de opcion multiple' , TRUE);
INSERT INTO `parametro` (DESCRIPCION, ACTIVO) VALUES ('Pregunta de formulario' , TRUE);

INSERT INTO `tipoevento` ( descripcion, estado) VALUES("CHARLA",1);
INSERT INTO `tipoevento` ( descripcion, estado) VALUES("TALLER",1);
INSERT INTO `tipoevento` ( descripcion, estado) VALUES("WORKSHOP",1);
INSERT INTO `tipoevento` ( descripcion, estado) VALUES("SEMINARIO",1);

INSERT INTO `lugar` (descripcion, estado) VALUES("AUDITORIO DE CIENCIAS E INGENIERIA - PUCP", 1);
INSERT INTO `lugar` (descripcion, estado) VALUES("AUDITORIO DE DERECHO - PUCP", 1);
INSERT INTO `lugar` (descripcion, estado) VALUES("CENTRO DE CONVENCIONES AEVENT", 1);
INSERT INTO `lugar` (descripcion, estado) VALUES("CENTRO DE CONVENCIONES SAN MARCOS SE DEFIENDE", 1);


INSERT INTO `formulariocfp` (titulo) VALUES ("Formato de ponencia para charla magistral de software científico");

INSERT INTO `division` (descripcion, indice, id_formulariocfp) VALUES ('Estudios',1,1);
INSERT INTO `division` (descripcion, indice, id_formulariocfp) VALUES ('Experiencia Laboral',1,1);

INSERT INTO `seccion`  (descripcion,cantidad_preguntas,indice,tipo_seccion, id_division) VALUES ('FORMULARIO 1',1,1,'PREGUNTA ABIERTA',1);
INSERT INTO `seccion`  (descripcion,cantidad_preguntas,indice,tipo_seccion, id_division) VALUES ('FORMULARIO 2',1,1,'PREGUNTA ABIERTA',2);

INSERT INTO `pregunta` (descripcion, tipo_pregunta, id_seccion) VALUES ('Explique su grado de estudios', 'PREGUNTA ABIERTA', 1);
INSERT INTO `pregunta` (descripcion, tipo_pregunta, id_seccion) VALUES ('Detalle su labor como ponente', 'PREGUNTA ABIERTA', 2);

INSERT INTO `evento` ( capacidad,titulo, descripcion, fecha_fin, fecha_inicio, id_formulariocfp, id_organizador, id_tipo_evento,estado, id_presidente, id_lugar) VALUES (500, 'Charla magistral dirigida a desarrolladores de software de propósito cientÃífico','Charla magistral dirigida a desarrolladores de software de propósito científico', '2019-12-12', '2019-05-05', 1, 3, 1,0,2,1);

INSERT INTO `fase` (descripcion, fecha_fin, fecha_inicial, id_evento) VALUES ('Fase numero 1','2019-06-06', '2019-05-05',1);
INSERT INTO `fase` (descripcion, fecha_fin, fecha_inicial, id_evento) VALUES ('Fase numero 2','2019-12-12', '2019-06-06',1);

INSERT INTO `criterio` (descripcion, id_fase) VALUES ('Criterio 1-1',1);
INSERT INTO `criterio` (descripcion, id_fase) VALUES ('Criterio 1-2',1);
INSERT INTO `criterio` (descripcion, id_fase) VALUES ('Criterio 2-1',2);
INSERT INTO `criterio` (descripcion, id_fase) VALUES ('Criterio 2-2',2);
INSERT INTO `criterio` (descripcion, id_fase) VALUES ('Criterio 2-3',2);
