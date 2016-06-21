# SQL command to create the tables:

CREATE TABLE usuario (
      id NT NOT NULL AUTO_INCREMENT,
      login VARCHAR(20) NOT NULL,
      senha VARCHAR(20) NOT NULL,
      nome VARCHAR(50) NOT NULL,
      email VARCHAR(50) NOT NULL,
PRIMARY KEY(id));

CREATE TABLE papel (
      id INT NOT NULL,
      papel VARCHAR(20) NOT NULL,
PRIMARY KEY(id));

CREATE TABLE secao (
      id INT AUTO_INCREMENT NOT NULL,
      titulo VARCHAR(20) NOT NULL,
      descricao VARCHAR(100) NOT NULL,
PRIMARY KEY(id));

CREATE TABLE noticia (
      id INT AUTO_INCREMENT NOT NULL,
      titulo VARCHAR(50) NOT NULL,
      subtitulo VARCHAR(150) NOT NULL,
      texto VARCHAR(500) NOT NULL,
      id_autor INT NOT NULL,
      data_noticia TIMESTAMP NOT NULL,
      id_secao INT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (id_autor) REFERENCES usuario(id)
                     ON DELETE CASCADE,
FOREIGN KEY (id_secao) REFERENCES secao(id)
                     ON DELETE CASCADE);

CREATE TABLE comentario (
      id INT AUTO_INCREMENT NOT NULL,
      id_noticia INT NOT NULL,
      id_autor INT NOT NULL,
      texto VARCHAR(100) NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (id_autor) REFERENCES usuario(id)
                     ON DELETE CASCADE,
FOREIGN KEY (id_noticia) REFERENCES noticia(id)
                     ON DELETE CASCADE);

CREATE TABLE classificado (
      id INT AUTO_INCREMENT NOT NULL,
      titulo VARCHAR(50) NOT NULL,
      texto VARCHAR(250) NOT NULL,
      preco FLOAT NOT NULL,
      telefone VARCHAR(20) NOT NULL,
      melhor_oferta FLOAT,
      data_oferta TIMESTAMP,
      id_autor INT,
 PRIMARY KEY(id),
 FOREIGN KEY (id_autor) REFERENCES usuario(id)
                     ON DELETE SET NULL);
