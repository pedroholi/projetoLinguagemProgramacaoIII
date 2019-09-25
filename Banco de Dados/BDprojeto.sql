-- MySQL Script generated by MySQL Workbench
-- Sun Sep 15 21:16:25 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema projeto
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema projeto
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `projeto` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `projeto`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nomeCliente` VARCHAR(100) NOT NULL,
  `rgCliente` VARCHAR(12) NOT NULL,
  `cpfCliente` VARCHAR(14) NOT NULL,
  `emailCliente` VARCHAR(50) NULL DEFAULT NULL,
  `sexoCliente` VARCHAR(2) NULL DEFAULT NULL,
  `dataNascCliente` DATE NOT NULL,
  `telefoneCliente` VARCHAR(15) NULL DEFAULT NULL,
  `celularCliente` VARCHAR(15) NULL DEFAULT NULL,
  `obsCliente` VARCHAR(200) NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`fornecedor` (
  `idFornecedor` INT NOT NULL AUTO_INCREMENT,
  `nomeFantasiaFornecedor` VARCHAR(100) NOT NULL,
  `cnpjFornecedor` VARCHAR(18) NULL,
  `contatoFornecedor` VARCHAR(100) NULL,
  `telefoneFornecedor` VARCHAR(15) NOT NULL,
  `razaoSocialFornecedor` VARCHAR(100) NULL,
  `celularFornecedor` VARCHAR(15) NULL,
  `emailFornecedor` VARCHAR(50) NOT NULL,
  `tipoFornecedor` VARCHAR(10) NULL,
  `ieFornecedor` VARCHAR(20) NULL,
  `cpfFornecedor` VARCHAR(14) NULL,
  PRIMARY KEY (`idFornecedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cargo` (
  `idCargo` INT NOT NULL AUTO_INCREMENT,
  `nomeCargo` VARCHAR(45) NULL,
  PRIMARY KEY (`idCargo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`departamento` (
  `idDepartamento` INT NOT NULL AUTO_INCREMENT,
  `nomeDepartamento` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDepartamento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`funcionario` (
  `idFuncionario` INT NOT NULL AUTO_INCREMENT,
  `nomeFuncionario` VARCHAR(100) NOT NULL,
  `rgFuncionario` VARCHAR(12) NOT NULL,
  `cpfFuncionario` VARCHAR(14) NOT NULL,
  `ctFuncionario` VARCHAR(20) NOT NULL,
  `emailFuncionario` VARCHAR(50) NULL,
  `sexoFuncionario` VARCHAR(1) NULL,
  `dataNascFuncionario` DATE NOT NULL,
  `telefoneFuncionario` VARCHAR(15) NULL,
  `celularFuncionario` VARCHAR(15) NOT NULL,
  `salarioFuncionario` DOUBLE NOT NULL,
  `dataAdmissaoFuncionario` DATE NOT NULL,
  `pisFuncionario` INT NOT NULL,
  `estadoCivilFuncionario` VARCHAR(10) NOT NULL,
  `formacaoEscolarFuncionario` VARCHAR(15) NOT NULL,
  `idCargoFuncionario` INT NOT NULL,
  `idDepartamentoFuncionario` INT NOT NULL,
  `qtdDependentesFuncionario` INT NOT NULL,
  PRIMARY KEY (`idFuncionario`),
  INDEX `fk_funcionario_cargo1_idx` (`idCargoFuncionario` ASC) VISIBLE,
  INDEX `fk_funcionario_departamento1_idx` (`idDepartamentoFuncionario` ASC) VISIBLE,
  CONSTRAINT `fk_funcionario_cargo1`
    FOREIGN KEY (`idCargoFuncionario`)
    REFERENCES `mydb`.`cargo` (`idCargo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcionario_departamento1`
    FOREIGN KEY (`idDepartamentoFuncionario`)
    REFERENCES `mydb`.`departamento` (`idDepartamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto`.`cidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`cidade` (
  `idCidade` INT NOT NULL AUTO_INCREMENT,
  `nomeCidade` VARCHAR(100) NOT NULL,
  `ufCidade` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`idCidade`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`endereco` (
  `idEndereco` INT NOT NULL AUTO_INCREMENT,
  `ruaEndereco` VARCHAR(150) NOT NULL,
  `bairroEndereco` VARCHAR(50) NOT NULL,
  `cepEndereco` VARCHAR(10) NOT NULL,
  `numEndereco` INT NULL,
  `referenciaEndereco` VARCHAR(200) NULL,
  `idClienteEndereco` INT(11) NULL,
  `idFornecedorEndereco` INT NULL,
  `idFuncionarioEndereco` INT NULL,
  `complementoEndereco` VARCHAR(10) NULL,
  `idCidadeEndereco` INT(11) NOT NULL,
  PRIMARY KEY (`idEndereco`),
  INDEX `fk_Endereco_cliente1_idx` (`idClienteEndereco` ASC) VISIBLE,
  INDEX `fk_endereco_fornecedor1_idx` (`idFornecedorEndereco` ASC) VISIBLE,
  INDEX `fk_endereco_funcionario1_idx` (`idFuncionarioEndereco` ASC) VISIBLE,
  INDEX `fk_endereco_cidade1_idx` (`idCidadeEndereco` ASC) VISIBLE,
  CONSTRAINT `fk_Endereco_cliente1`
    FOREIGN KEY (`idClienteEndereco`)
    REFERENCES `projeto`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_endereco_fornecedor1`
    FOREIGN KEY (`idFornecedorEndereco`)
    REFERENCES `mydb`.`fornecedor` (`idFornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_endereco_funcionario1`
    FOREIGN KEY (`idFuncionarioEndereco`)
    REFERENCES `mydb`.`funcionario` (`idFuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_endereco_cidade1`
    FOREIGN KEY (`idCidadeEndereco`)
    REFERENCES `projeto`.`cidade` (`idCidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`marca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`marca` (
  `idMarca` INT NOT NULL AUTO_INCREMENT,
  `nomeMarca` VARCHAR(45) NULL,
  PRIMARY KEY (`idMarca`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`modulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`modulo` (
  `idModulo` INT NOT NULL,
  `nomeModulo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idModulo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto`.`tipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`tipo` (
  `idTipo` INT NOT NULL AUTO_INCREMENT,
  `nomeTipo` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idTipo`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `projeto`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`produto` (
  `idProduto` INT NOT NULL AUTO_INCREMENT,
  `nomeProduto` VARCHAR(100) NOT NULL,
  `dataCadProduto` DATE NOT NULL,
  `unidCompraProduto` VARCHAR(20) NOT NULL,
  `unidVendaProduto` VARCHAR(20) NOT NULL,
  `pesoProduto` DOUBLE NOT NULL,
  `percVendaProduto` DOUBLE NOT NULL,
  `descricaoProduto` VARCHAR(200) NOT NULL,
  `idMarcaProduto` INT NOT NULL,
  `idTipoProduto` INT(11) NOT NULL,
  `modeloProduto` VARCHAR(45) NULL,
  `codigoBarrasProduto` INT NOT NULL,
  `dataVencimentoProduto` DATE NULL,
  PRIMARY KEY (`idProduto`),
  INDEX `fk_produto_marca_idx` (`idMarcaProduto` ASC) VISIBLE,
  INDEX `fk_produto_tipo1_idx` (`idTipoProduto` ASC) VISIBLE,
  CONSTRAINT `fk_produto_marca`
    FOREIGN KEY (`idMarcaProduto`)
    REFERENCES `mydb`.`marca` (`idMarca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_tipo1`
    FOREIGN KEY (`idTipoProduto`)
    REFERENCES `projeto`.`tipo` (`idTipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `projeto`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`usuario` (
  `idUsuario` INT NOT NULL,
  `senhaUsuario` VARCHAR(20) NOT NULL,
  `idFuncionarioUsuario` INT NOT NULL,
  PRIMARY KEY (`idUsuario`),
  INDEX `fk_usuario_funcionario1_idx` (`idFuncionarioUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_funcionario1`
    FOREIGN KEY (`idFuncionarioUsuario`)
    REFERENCES `mydb`.`funcionario` (`idFuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`saida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`saida` (
  `idsaida` INT NOT NULL AUTO_INCREMENT,
  `qtdSaida` VARCHAR(45) NULL,
  `dataSaida` VARCHAR(45) NULL,
  `idProdutoSaida` INT(11) NOT NULL,
  `idUsuarioSaida` INT(11) NOT NULL,
  PRIMARY KEY (`idsaida`),
  INDEX `fk_saida_produto1_idx` (`idProdutoSaida` ASC) VISIBLE,
  INDEX `fk_saida_usuario1_idx` (`idUsuarioSaida` ASC) VISIBLE,
  CONSTRAINT `fk_saida_produto1`
    FOREIGN KEY (`idProdutoSaida`)
    REFERENCES `projeto`.`produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_saida_usuario1`
    FOREIGN KEY (`idUsuarioSaida`)
    REFERENCES `projeto`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`venda` (
  `idVenda` INT(11) NOT NULL AUTO_INCREMENT,
  `dataVenda` VARCHAR(10) NOT NULL,
  `valorTotalVenda` VARCHAR(45) NULL DEFAULT NULL,
  `descontoVenda` DOUBLE NULL DEFAULT NULL,
  `tipoPagamentoVenda` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idVenda`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`vendaproduto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`vendaproduto` (
  `idVenda` INT(11) NOT NULL,
  `idProduto` INT(11) NOT NULL,
  `quantidade` INT NULL,
  `idVendaProduto` INT NOT NULL AUTO_INCREMENT,
  INDEX `fk_vendaproduto_venda1_idx` (`idVenda` ASC) VISIBLE,
  INDEX `fk_vendaproduto_produto1_idx` (`idProduto` ASC) VISIBLE,
  PRIMARY KEY (`idVendaProduto`),
  CONSTRAINT `fk_vendaproduto_venda1`
    FOREIGN KEY (`idVenda`)
    REFERENCES `projeto`.`venda` (`idVenda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vendaproduto_produto1`
    FOREIGN KEY (`idProduto`)
    REFERENCES `projeto`.`produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`permissao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`permissao` (
  `idPermissao` INT NOT NULL AUTO_INCREMENT,
  `idModuloPermissao` INT NOT NULL,
  `idUsuarioPermissao` INT NOT NULL,
  `permissao` INT NULL,
  PRIMARY KEY (`idPermissao`),
  INDEX `fk_permissao_modulo1_idx` (`idModuloPermissao` ASC) VISIBLE,
  INDEX `fk_permissao_usuario1_idx` (`idUsuarioPermissao` ASC) VISIBLE,
  CONSTRAINT `fk_permissao_modulo1`
    FOREIGN KEY (`idModuloPermissao`)
    REFERENCES `mydb`.`modulo` (`idModulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_permissao_usuario1`
    FOREIGN KEY (`idUsuarioPermissao`)
    REFERENCES `projeto`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `projeto` ;

-- -----------------------------------------------------
-- Table `projeto`.`entrada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`entrada` (
  `idEntrada` INT(11) NOT NULL AUTO_INCREMENT,
  `idProdutoEntrada` INT(11) NOT NULL,
  `quantEntrada` INT(11) NOT NULL,
  `dataEntrada` VARCHAR(10) NOT NULL,
  `valorCompraEntrada` DOUBLE NULL DEFAULT NULL,
  `idFornecedorEntrada` INT NOT NULL,
  `idProdutoEntrada` INT(11) NOT NULL,
  `idUsuarioEntrada` INT(11) NOT NULL,
  PRIMARY KEY (`idEntrada`, `idProdutoEntrada`),
  INDEX `fk_entrada_fornecedor1_idx` (`idFornecedorEntrada` ASC) VISIBLE,
  INDEX `fk_entrada_produto1_idx` (`idProdutoEntrada` ASC) VISIBLE,
  INDEX `fk_entrada_usuario1_idx` (`idUsuarioEntrada` ASC) VISIBLE,
  CONSTRAINT `fk_entrada_fornecedor1`
    FOREIGN KEY (`idFornecedorEntrada`)
    REFERENCES `mydb`.`fornecedor` (`idFornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_entrada_produto1`
    FOREIGN KEY (`idProdutoEntrada`)
    REFERENCES `projeto`.`produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_entrada_usuario1`
    FOREIGN KEY (`idUsuarioEntrada`)
    REFERENCES `projeto`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
