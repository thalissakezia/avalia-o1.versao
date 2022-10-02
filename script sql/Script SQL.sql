CREATE SCHEMA `alfabetizar` DEFAULT CHARACTER SET utf8 ;
Use `alfabetizar`;
CREATE TABLE `alfabetizar`.`jogo` (
  `id_jogo` INT NOT NULL,
  `palavras` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_jogo`));
INSERT INTO `alfabetizar`.`jogo` (`id_jogo`, `palavras`) VALUES ('1', 'Pato, Casa, Taça');
SELECT * FROM alfabetizar.jogo;
CREATE TABLE `alfabetizar`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nome_sobrenome` VARCHAR(255) NOT NULL,
  `login` VARCHAR(255) NOT NULL,
  `senha` VARCHAR(255) NOT NULL,
  `id_jogo` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id_usuario`),
  INDEX `id_jogo_FK_idx` (`id_jogo` ASC),
  CONSTRAINT `id_jogo_FK`
    FOREIGN KEY (`id_jogo`)
    REFERENCES `alfabetizar`.`jogo` (`id_jogo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
SELECT * FROM alfabetizar.usuario;


