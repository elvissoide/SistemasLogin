CREATE DATABASE ejercicio1;
USE ejercicio1;
CREATE TABLE usuarios (
	idusuarios INT PRIMARY KEY,
	nombreusuarios VARCHAR(45) NOT NULL,
	apellidousuarios VARCHAR(45) NOT NULL,
	celularusuarios VARCHAR(10),
	correousuarios VARCHAR(45)
);
INSERT INTO usuarios VALUES 
(1723284053,'Alexis','Chasi','0969093153','alexis.chasi@epn.edu.ec'),
(1750734129,'Elvis','Guanoluisa','0988815272','elviserock@gmail.com'),
(1751361245,'Roberto','Shiao','0960','roberto.shiao@epn.edu.ec');