CREATE TABLE cliente (
  Id int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(255) DEFAULT NULL,
  endereco varchar(255) DEFAULT NULL,
  telefone varchar(255) DEFAULT NULL,
  PRIMARY KEY (Id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
