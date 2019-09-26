INSERT INTO `usuarios` (vusername, vpassword, nusuario_activo,vemail) VALUES ('admin','$2a$10$Fxm6q26fOKOQOh/GbXw03uL6XyiQd3157s9JhWlzQ6S911BUFLLCy',1,'admin@aevent.com');
INSERT INTO `usuarios` (vusername, vpassword, nusuario_activo,vemail) VALUES ('user_pres','$2a$10$eKmvl/ZziTfER4TDMY/QVe51oNvqNlDF7Olk3mDRJaSCVIy0u8fhG',1,'presidente@aevent.com');
INSERT INTO `usuarios` (vusername, vpassword, nusuario_activo,vemail) VALUES ('user_orga','$2a$10$wXn0WmXu5xkb18RsLpJF9uEv4Afk4EoBRGt2Vo4MToJ4lYx9XNJSW',1,'organizator@aevent.com');
INSERT INTO `usuarios` (vusername, vpassword, nusuario_activo,vemail) VALUES ('user_eval','$2a$10$Fy6bJZM3fyag2OVAQcuTwuQSM1tc74dr8om6LNKe5xtJIc.i46r5y',1,'evaluator@aevent.com');

INSERT INTO `personas` (vapellidomat, vapellidopat, vdni, vnombre, nusuarioid) VALUES ( 'Doe','Towers', 43110193, 'Luis', 1);
INSERT INTO `personas` (vapellidomat, vapellidopat, vdni, vnombre, nusuarioid) VALUES ( 'Jhon','Diane', 51231233, 'Jean', 2);
INSERT INTO `personas` (vapellidomat, vapellidopat, vdni, vnombre, nusuarioid) VALUES ( 'Crux','Ophelia', 12331233, 'Patrick', 3);
INSERT INTO `personas` (vapellidomat, vapellidopat, vdni, vnombre, nusuarioid) VALUES ( 'Thrown','Rex', 54542525, 'Ray', 4);

INSERT INTO `roles` (NROL_ACTIVO,VDESCRIPCION) VALUES (1,'ROLE_ADMIN');
INSERT INTO `roles` (NROL_ACTIVO,VDESCRIPCION) VALUES (1,'ROLE_PRESIDENT');
INSERT INTO `roles` (NROL_ACTIVO,VDESCRIPCION) VALUES (1,'ROLE_ORGANIZER');
INSERT INTO `roles` (NROL_ACTIVO,VDESCRIPCION) VALUES (1,'ROLE_EVALUATOR');
INSERT INTO `roles` (NROL_ACTIVO,VDESCRIPCION) VALUES (1,'ROLE_USER');

INSERT INTO `usuarios_roles` (nid_usuario, nid_rol) VALUES (1, 1);
INSERT INTO `usuarios_roles` (nid_usuario, nid_rol) VALUES (2, 2);
INSERT INTO `usuarios_roles` (nid_usuario, nid_rol) VALUES (3, 3);
INSERT INTO `usuarios_roles` (nid_usuario, nid_rol) VALUES (4, 4);
