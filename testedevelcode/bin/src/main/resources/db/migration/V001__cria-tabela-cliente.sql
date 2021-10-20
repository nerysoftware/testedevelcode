CREATE TABLE usuario (
  Id int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(255) DEFAULT NULL,
  datanascimento varchar(255) DEFAULT NULL,
  foto varchar(255) DEFAULT NULL,
  PRIMARY KEY (Id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
