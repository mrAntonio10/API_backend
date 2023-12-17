INSERT INTO users (id, status, password, usertype, username)
VALUES
    (1, 1, 'contrasena', 2, 'kenzo'),
    (2, 1, 'contrasena', 1, 'Sara'),
    (3, 1, 'contrasena', 2, 'Bruno'),
    (4, 1, 'contrasena', 2, 'Hamed'),
    (5, 1, 'contrasena', 1, 'Ines');


INSERT INTO pets (id, birthdate, name, sex, id_user)
VALUES
    (1, '2017-01-01', 'Maggy', 1, 1),
    (2, '2017-02-01', 'Gunther', 2, 1),
    (3, '2017-03-01', 'Mila', 1, 2),
    (4, '2017-04-01', 'Pet4', 2, 3),
    (5, '2017-05-01', 'Ramona', 1, 4),
    (6, '2017-06-01', 'Pet6', 2, 4),
    (7, '2017-07-01', 'Male', 1, 5);


INSERT INTO registro (id, description, date, returndate, vetname, treatment, id_pet)
VALUES
    (1, 'Revision regular de la mascota', '2023-03-01', '2023-03-05', 'Dra. Gomez', 'Control regular', 1),
    (2, 'Revision de dientes y encias de la mascota', '2023-03-05', '2023-03-10', 'Dr. Ordonez', 'Examen dental', 5),
    (3, 'Inflamacion e irritacion en las orejas de la mascota.', '2023-03-10', '2023-03-15', 'Dr. Pinto', 'Síntomas de alergia', 3),
    (4, 'Ligeras fisuras en las piernas traseras de la mascota', '2023-03-15', '2023-03-20', 'Dr. Iwata', 'Evaluación de lesiones', 4),
    (5, 'Visita de seguimiento al progreso de bajada de peso.', '2023-03-20', '2023-03-25', 'Dra. Murillo', 'Manejo de peso', 2),
    (6, 'Granos e irritacion en la piel despues de comer manies.', '2023-03-25', '2023-03-30', 'Dr. Anderson', 'Problemas de piel', 6),
    (7, 'Desparacitacion interna y externa con medicamentos via oral.', '2023-03-30', '2023-04-04', 'Dra. Tanaka', 'Desparasitacion', 7),
    (8, 'Revision regular de la mascota', '2023-03-01', '2023-03-05', 'Dra. Gomez', 'Control regular', 1),
    (9, 'Revision de dientes y encias de la mascota', '2023-03-05', '2023-03-10', 'Dr. Ordonez', 'Examen dental', 5),
    (10, 'Inflamacion y ronchas alrededor del area de la cara de la mascota.', '2023-03-10', '2023-03-15', 'Dr. Pinto', 'Síntomas de alergia', 3),
    (11, 'Dolor muscular en las patas delanteras de la mascota. Sin dano a los huesos.', '2023-03-15', '2023-03-20', 'Dr. Iwata', 'Evaluación de lesiones', 4),
    (12, 'Prescripcion: comida dietetica', '2023-03-20', '2023-03-25', 'Dra. Murillo', 'Manejo de peso', 2),
    (13, 'Infeccion de oido detectado por rojez en la piel y olor en la cera.', '2023-03-25', '2023-03-30', 'Dr. Anderson', 'Problemas de oido', 6),
    (14, 'Prescripcion antibioticos y protector hepatico.', '2023-03-30', '2023-04-04', 'Dra. Tanaka', 'Problemas de estomago', 7);


select * from users;
select * from pets;
select * from registro;