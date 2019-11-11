INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo, nombre_completo,modo_inicio_sesion) VALUES ('admin','$2a$10$Fxm6q26fOKOQOh/GbXw03uL6XyiQd3157s9JhWlzQ6S911BUFLLCy',1,'admin@aevent.com', 'Doe Towers Luis',0);
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo, nombre_completo,modo_inicio_sesion) VALUES ('user_pres','$2a$10$eKmvl/ZziTfER4TDMY/QVe51oNvqNlDF7Olk3mDRJaSCVIy0u8fhG',1,'presidente@aevent.com', 'Jhon Diane Jean',0);
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo, nombre_completo,modo_inicio_sesion) VALUES ('user_orga','$2a$10$wXn0WmXu5xkb18RsLpJF9uEv4Afk4EoBRGt2Vo4MToJ4lYx9XNJSW',1,'organizator@aevent.com', 'Crux Ophelia Patrick',0);
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo, nombre_completo,modo_inicio_sesion) VALUES ('user_eval','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'evaluator@aevent.com', 'Thrown Rex Ray',0);
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo, nombre_completo,modo_inicio_sesion) VALUES ('user_basic1','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic1@aevent.com', 'Caryr Michael Tom',0);
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo, nombre_completo,modo_inicio_sesion) VALUES ('user_basic2','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic2@aevent.com', 'Mcketon Gen Grey',0);
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo, nombre_completo,modo_inicio_sesion) VALUES ('user_basic3','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic3@aevent.com', 'Tonic Ten Roxxana',0);
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo, nombre_completo,modo_inicio_sesion) VALUES ('user_basic4','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic4@aevent.com', 'Appleton Ren Tricia',0);
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo, nombre_completo,modo_inicio_sesion) VALUES ('user_basic5','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic5@aevent.com', 'Cartavio Reo Caroline',0);
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo, nombre_completo,modo_inicio_sesion) VALUES ('user_basic6','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic6@aevent.com', 'Gtew Blen Esperanza',0);
INSERT INTO `usuario` (usuario, contrasena, usuario_activo,correo, nombre_completo,modo_inicio_sesion) VALUES ('user_basic7','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'userbasic7@aevent.com', 'Opress Qwerty Trevor',0);

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
INSERT INTO `categoria` (cod_categoria, descripcion,estado) VALUES ('00000006', 'CONSTRUCCIÓN CIVIL',1);
INSERT INTO `categoria` (cod_categoria, descripcion,estado) VALUES ('00000007', 'EDUCACIIÓN',1);

INSERT INTO `parametro` (DESCRIPCION,DESCRIPCION_CORTA, ACTIVO) VALUES ('Pregunta abierta','TIPO_PREGUNTA' , TRUE);
INSERT INTO `parametro` (DESCRIPCION,DESCRIPCION_CORTA, ACTIVO) VALUES ('Pregunta de opción múltiple','TIPO_PREGUNTA' , TRUE);
INSERT INTO `parametro` (DESCRIPCION,DESCRIPCION_CORTA, ACTIVO) VALUES ('Pregunta de formulario','TIPO_PREGUNTA' , TRUE);
INSERT INTO `parametro` (DESCRIPCION,DESCRIPCION_CORTA, ACTIVO) VALUES ('Abierto','ESTADO_EVENTO',TRUE);
INSERT INTO `parametro` (DESCRIPCION,DESCRIPCION_CORTA, ACTIVO) VALUES ('Cancelado','ESTADO_EVENTO',TRUE);
INSERT INTO `parametro` (DESCRIPCION,DESCRIPCION_CORTA, ACTIVO) VALUES ('En Curso','ESTADO_EVENTO',TRUE);
INSERT INTO `parametro` (DESCRIPCION,DESCRIPCION_CORTA, ACTIVO) VALUES ('Borrador','ESTADO_EVENTO',TRUE);

INSERT INTO `tipoevento` ( descripcion, estado) VALUES("CHARLA",1);
INSERT INTO `tipoevento` ( descripcion, estado) VALUES("TALLER",1);
INSERT INTO `tipoevento` ( descripcion, estado) VALUES("WORKSHOP",1);
INSERT INTO `tipoevento` ( descripcion, estado) VALUES("SEMINARIO",1);
INSERT INTO `tipoevento` ( descripcion, estado) VALUES("OTROS",1);

INSERT INTO `lugar` (descripcion, estado) VALUES("AUDITORIO DE CIENCIAS E INGENIERÍA - PUCP", 1);
INSERT INTO `lugar` (descripcion, estado) VALUES("AUDITORIO DE DERECHO - PUCP", 1);
INSERT INTO `lugar` (descripcion, estado) VALUES("CENTRO DE CONVENCIONES AEVENT", 1);
INSERT INTO `lugar` (descripcion, estado) VALUES("CENTRO DE CONVENCIONES SAN MARCOS SE DEFIENDE", 1);


INSERT INTO `formulariocfp` (titulo) VALUES ("Formato de ponencia para charla magistral de software científico");
INSERT INTO `formulariocfp` (titulo) VALUES ("Formato de ponencia para charla de machine learning");
INSERT INTO `formulariocfp` (titulo) VALUES ("Formato de ponencia para charla de usabilidad de software");

INSERT INTO `division` (descripcion, indice, id_formulariocfp) VALUES ('Estudios',1,1);
INSERT INTO `division` (descripcion, indice, id_formulariocfp) VALUES ('Experiencia Laboral',1,1);

INSERT INTO `seccion`  (descripcion,cantidad_preguntas,indice,tipo_seccion, id_division) VALUES ('FORMULARIO 1',1,1,'PREGUNTA ABIERTA',1);
INSERT INTO `seccion`  (descripcion,cantidad_preguntas,indice,tipo_seccion, id_division) VALUES ('FORMULARIO 2',1,1,'PREGUNTA ABIERTA',2);

INSERT INTO `pregunta` (descripcion, tipo_pregunta, id_seccion) VALUES ('Explique su grado de estudios', 'PREGUNTA ABIERTA', 1);
INSERT INTO `pregunta` (descripcion, tipo_pregunta, id_seccion) VALUES ('Detalle su labor como ponente', 'PREGUNTA ABIERTA', 2);

INSERT INTO `evento` ( capacidad,titulo, descripcion, fecha_fin, fecha_inicio, id_organizador, id_tipo_evento,estado, id_presidente, id_lugar) VALUES (500, 'Charla magistral dirigida a desarrolladores de software de propÃ³sito científico','Charla magistral dirigida a desarrolladores de software de propï¿½sito cientï¿½fico', '2019-12-12', '2019-05-05', 3, 1,1,2,1);
INSERT INTO `evento` ( capacidad,titulo, descripcion, fecha_fin, fecha_inicio, id_organizador, id_tipo_evento,estado, id_presidente, id_lugar) VALUES (500, 'Mama, voy a ser dotero','Charla para jóvenes emprendedores +5k MMR', '2019-12-12', '2019-05-05', 3, 2,0,2,2);
INSERT INTO `evento` ( capacidad,titulo, descripcion, fecha_fin, fecha_inicio, id_organizador, id_tipo_evento,estado, id_presidente, id_lugar) VALUES (500, 'Marcha para que abran un Tambo en el congreso','Gran marcha nacional', '2019-12-12', '2019-05-05', 3, 3,0,2,1);
INSERT INTO `evento` ( capacidad,titulo, descripcion, fecha_fin, fecha_inicio, id_organizador, id_tipo_evento,estado, id_presidente, id_lugar) VALUES (500, 'IoT: Próximamente tu refrigeradora tendrï¿½ cerebro','La tecnologï¿½a en 2k19', '2019-12-12', '2019-05-05', 3, 1,0,2,1);


INSERT INTO `fase` (descripcion, fecha_fin, fecha_inicial, id_evento) VALUES ('Fase Recepción','2019-11-10', '2019-11-05',1);
INSERT INTO `fase` (descripcion, fecha_fin, fecha_inicial, id_evento) VALUES ('Fase Evaluación','2019-11-15', '2019-11-10',1);
INSERT INTO `fase` (descripcion, fecha_fin, fecha_inicial, id_evento) VALUES ('Fase Mejora','2019-11-20', '2019-11-15',1);

INSERT INTO `tipo_criterio` (descripcion, estado) VALUES ('Respuesta numérica', 1);
INSERT INTO `tipo_criterio` (descripcion, estado) VALUES ('Respuesta múltiple', 1);
INSERT INTO `tipo_criterio` (descripcion, estado) VALUES ('Pregunta de selección', 1);
INSERT INTO `tipo_criterio` (descripcion, estado) VALUES ('Pregunta cerrada', 1);
INSERT INTO `tipo_criterio` (descripcion, estado) VALUES ('Pregunta abierta', 1);

INSERT INTO `criterio` (descripcion, id_fase, id_tipo_criterio) VALUES ("Nivel de detalle de la temática",3,1);
INSERT INTO `criterio` (descripcion, id_fase, id_tipo_criterio) VALUES ("Grado de experiencia del ponente",1,1);
INSERT INTO `criterio` (descripcion, id_fase, id_tipo_criterio) VALUES ("Aspectos destacados de la propuesta",2,2);
INSERT INTO `criterio` (descripcion, id_fase, id_tipo_criterio) VALUES ("Cumple con los estándares del evento",1,4);
INSERT INTO `criterio` (descripcion, id_fase, id_tipo_criterio) VALUES ("Comentarios del evaluador",1,5);

INSERT INTO `opcion_respuesta_criterio` (descripcion, id_criterio) VALUES ("Buen resumen",3);
INSERT INTO `opcion_respuesta_criterio` (descripcion, id_criterio) VALUES ("Investigación exhaustiva",3);
INSERT INTO `opcion_respuesta_criterio` (descripcion, id_criterio) VALUES ("Tema interesante",3);

INSERT INTO `persona_comite` (id_evento, id_usuario) VALUES (1,3);
INSERT INTO `persona_comite` (id_evento, id_usuario) VALUES (1,5);
INSERT INTO `persona_comite` (id_evento, id_usuario) VALUES (1,6);
INSERT INTO `persona_comite` (id_evento, id_usuario) VALUES (1,2);

INSERT INTO `propuesta` (id_evento,id_postulante,fecha_postulacion,titulo) VALUES (1,1,'2019-01-01','Desarrollo de software');
INSERT INTO `propuesta` (id_evento,id_postulante,fecha_postulacion,titulo) VALUES (1,2,'2019-01-01','MPS');

INSERT INTO `documento` (nombredoc,extensiondoc,contenido,id_propuesta) VALUES ('archivo1','pdf',10,1);
INSERT INTO `documento` (nombredoc,extensiondoc,contenido,id_propuesta) VALUES ('archivo2','pdf',10,2);

INSERT INTO `evaluacion` (id_propuesta,id_evaluador,id_fase,estado,comentario_presidente,comentario_participante) VALUES (1,2,1,'ASIGNADO','','');
INSERT INTO `evaluacion` (id_propuesta,id_evaluador,id_fase,estado,comentario_presidente,comentario_participante) VALUES (1,3,1,'ASIGNADO','','');
INSERT INTO `evaluacion` (id_propuesta,id_evaluador,id_fase,estado,comentario_presidente,comentario_participante) VALUES (1,5,1,'ASIGNADO','','');
INSERT INTO `evaluacion` (id_propuesta,id_evaluador,id_fase,estado,comentario_presidente,comentario_participante) VALUES (2,3,1,'ASIGNADO','','');

INSERT INTO `respuesta_criterio` (desc_respuesta,criterio) VALUES ("2",1);
INSERT INTO `respuesta_criterio` (desc_respuesta,criterio) VALUES ("3",2);
INSERT INTO `respuesta_criterio` (desc_respuesta,criterio) VALUES ("Buen resumen",3);
INSERT INTO `respuesta_criterio` (desc_respuesta,criterio) VALUES ("Tema interesante",3);
INSERT INTO `respuesta_criterio` (desc_respuesta,criterio) VALUES ("5",4);
INSERT INTO `respuesta_criterio` (desc_respuesta,criterio) VALUES ("Se han realizado observaciones a la propuesta, enviar datos corregidos",5);

INSERT INTO `aevent`.`preferencia` (`id_preferencia`, `descripcion`, `id_propuesta`, `id_usuario`) VALUES ('1', 'Quiero Evaluar', '1', '4');
INSERT INTO `aevent`.`preferencia` (`id_preferencia`, `descripcion`, `id_propuesta`, `id_usuario`) VALUES ('2', 'Podria Evaluar', '2', '4');

///////TRIGGERS

CREATE TRIGGER `UPDATE_PASSWORD` BEFORE UPDATE ON `usuario` FOR EACH ROW BEGIN DECLARE PASSWORD_OLD VARCHAR(60); SELECT CONTRASENA INTO PASSWORD_OLD  FROM usuario US WHERE NEW.ID_USUARIO=US.ID_USUARIO; IF NEW.CONTRASENA IS NULL OR NEW.CONTRASENA = "" THEN SET NEW.CONTRASENA = PASSWORD_OLD; END IF; END;

