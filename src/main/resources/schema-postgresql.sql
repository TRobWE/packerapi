DROP TABLE IF EXISTS agendas;

CREATE TABLE agenda (
  id SERIAL PRIMARY KEY ,
  name varchar(100) NOT NULL,
  agenda varchar(300) NOT NULL,
  complete BOOL NOT NULL DEFAULT '0'
)