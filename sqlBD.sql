

INSERT INTO `coronaticket`.`usuario`
(`usu_nick`,
`usu_nombre`,
`usu_apellido`,
`usu_mail`,
`usu_nacimiento`)
VALUES
('ju0wi', 'Pablo', 'Peculio', 'pablopeculio@cras-dev.com', DATE('2001-07-13'));

SELECT * FROM usuario;

DELETE FROM usuario WHERE usu_id = 1;