CREATE TABLE cliente (
  id int(11) NOT NULL AUTO_INCREMENT,
  cpf_cnpj varchar(255) DEFAULT NULL,
  credito double DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  endereco varchar(255) DEFAULT NULL,
  nome varchar(255) DEFAULT NULL,
  tel_cel varchar(255) DEFAULT NULL,
  tel_fixo varchar(255) DEFAULT NULL,
  avatar varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ;