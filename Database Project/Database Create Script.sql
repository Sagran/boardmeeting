-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema boardmeeting
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema boardmeeting
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `boardmeeting` DEFAULT CHARACTER SET utf8 ;
USE `boardmeeting` ;

-- -----------------------------------------------------
-- Table `boardmeeting`.`USER_LOGIN`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boardmeeting`.`USER_LOGIN` (
  `USER_LOGIN_ID` INT NOT NULL AUTO_INCREMENT,
  `USER_NAME` VARCHAR(45) NOT NULL,
  `PASSWORD` VARCHAR(45) NOT NULL,
  `CREATED_BY` VARCHAR(45) NULL,
  `CREATED_TIME` DATETIME NULL,
  `LAST_UPDT_BY` VARCHAR(45) NULL,
  `LAST_UPDT_TIME` DATETIME NULL,
  PRIMARY KEY (`USER_LOGIN_ID`),
  UNIQUE INDEX `USER_NAME_UNIQUE` (`USER_NAME` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boardmeeting`.`USER_LOGIN_HISTORY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boardmeeting`.`USER_LOGIN_HISTORY` (
  `USER_LOGIN_HISTORY_ID` INT NOT NULL AUTO_INCREMENT,
  `USER_LOGIN_ID` INT NOT NULL,
  `USER_NAME` VARCHAR(45) NOT NULL,
  `PASSWORD` VARCHAR(45) NOT NULL,
  `CREATED_BY` VARCHAR(45) NULL,
  `CREATED_TIME` DATETIME NULL,
  `LAST_UPDT_BY` VARCHAR(45) NULL,
  `LAST_UPDT_TIME` DATETIME NULL,
  PRIMARY KEY (`USER_LOGIN_HISTORY_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boardmeeting`.`COMMON_LOOKUP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boardmeeting`.`COMMON_LOOKUP` (
  `LOOKUP_ID` INT NOT NULL AUTO_INCREMENT,
  `LOOKUP_NAME` VARCHAR(45) NULL,
  `CREATED_BY` VARCHAR(45) NULL,
  `CREATED_TIME` DATETIME NULL,
  `LAST_UPDT_BY` VARCHAR(45) NULL,
  `LAST_UPDT_TIME` DATETIME NULL,
  PRIMARY KEY (`LOOKUP_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boardmeeting`.`COMMON_LOOKUP_VALUE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boardmeeting`.`COMMON_LOOKUP_VALUE` (
  `LOOKUP_VALUE_ID` INT NOT NULL AUTO_INCREMENT,
  `LOOKUP_CODE_ID` INT NOT NULL,
  `LOOKUP_VALUE` VARCHAR(45) NOT NULL,
  `LANG` VARCHAR(45) NULL,
  `CREATED_BY` VARCHAR(45) NULL,
  `CREATED_TIME` DATETIME NULL,
  `LAST_UPDT_BY` VARCHAR(45) NULL,
  `LAST_UPDT_TIME` DATETIME NULL,
  PRIMARY KEY (`LOOKUP_VALUE_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boardmeeting`.`AGENDA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boardmeeting`.`AGENDA` (
  `AGENDA_ID` INT NOT NULL AUTO_INCREMENT,
  `AGENDA_TYPE` INT NOT NULL,
  `SUBJECT` VARCHAR(500) NOT NULL,
  `ISSUE_OF_CONSIDERATION` VARCHAR(500) NULL,
  `BACKGROUND` VARCHAR(2000) NULL,
  `SUBMISSION` VARCHAR(1000) NULL,
  `ATTACHMENT` INT NULL,
  `APPROVAL_STATUS` INT NULL,
  `CREATED_BY` VARCHAR(45) NULL,
  `CREATED_TIME` DATETIME NULL,
  `LAST_UPDT_BY` VARCHAR(45) NULL,
  `LAST_UPDT_TIME` DATETIME NULL,
  PRIMARY KEY (`AGENDA_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boardmeeting`.`DEPARTMENT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boardmeeting`.`DEPARTMENT` (
  `DEPT_ID` INT NOT NULL AUTO_INCREMENT,
  `DEPT_NAME` VARCHAR(100) NOT NULL,
  `CREATED_BY` VARCHAR(45) NULL,
  `CREATED_TIME` DATETIME NULL,
  `LAST_UPDT_BY` VARCHAR(45) NULL,
  `LAST_UPDT_TIME` DATETIME NULL,
  PRIMARY KEY (`DEPT_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boardmeeting`.`AGENDA_FOR_DEPARTMENTS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boardmeeting`.`AGENDA_FOR_DEPARTMENTS` (
  `AGENDA_ID` INT NOT NULL,
  `DEPT_ID` INT NOT NULL,
  PRIMARY KEY (`AGENDA_ID`, `DEPT_ID`),
  INDEX `fk_AGENDA_has_DEPARTMENT_DEPARTMENT1_idx` (`DEPT_ID` ASC) VISIBLE,
  INDEX `fk_AGENDA_has_DEPARTMENT_AGENDA_idx` (`AGENDA_ID` ASC) VISIBLE,
  CONSTRAINT `fk_AGENDA_has_DEPARTMENT_AGENDA`
    FOREIGN KEY (`AGENDA_ID`)
    REFERENCES `boardmeeting`.`AGENDA` (`AGENDA_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AGENDA_has_DEPARTMENT_DEPARTMENT1`
    FOREIGN KEY (`DEPT_ID`)
    REFERENCES `boardmeeting`.`DEPARTMENT` (`DEPT_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boardmeeting`.`ATTACHMENT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boardmeeting`.`ATTACHMENT` (
  `ATTACHMENT_ID` INT NOT NULL AUTO_INCREMENT,
  `ATTACHMENT_NAME` VARCHAR(200) NOT NULL,
  `ATTACHMENT_LOCATION` VARCHAR(1000) NOT NULL,
  `CREATED_BY` VARCHAR(45) NULL,
  `CREATED_TIME` DATETIME NULL,
  `LAST_UPDT_BY` VARCHAR(45) NULL,
  `LAST_UPDT_TIME` DATETIME NULL,
  PRIMARY KEY (`ATTACHMENT_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boardmeeting`.`AGENDA_HAS_ATTACHMENTS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boardmeeting`.`AGENDA_HAS_ATTACHMENTS` (
  `AGENDA_ID` INT NOT NULL,
  `ATTACHMENT_ID` INT NOT NULL,
  PRIMARY KEY (`AGENDA_ID`, `ATTACHMENT_ID`),
  INDEX `fk_AGENDA_has_ATTACHMENT_ATTACHMENT1_idx` (`ATTACHMENT_ID` ASC) VISIBLE,
  INDEX `fk_AGENDA_has_ATTACHMENT_AGENDA1_idx` (`AGENDA_ID` ASC) VISIBLE,
  CONSTRAINT `fk_AGENDA_has_ATTACHMENT_AGENDA1`
    FOREIGN KEY (`AGENDA_ID`)
    REFERENCES `boardmeeting`.`AGENDA` (`AGENDA_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AGENDA_has_ATTACHMENT_ATTACHMENT1`
    FOREIGN KEY (`ATTACHMENT_ID`)
    REFERENCES `boardmeeting`.`ATTACHMENT` (`ATTACHMENT_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boardmeeting`.`AGENDA_HISTORY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boardmeeting`.`AGENDA_HISTORY` (
  `AGENDA_HISTORY_ID` INT NOT NULL,
  `AGENDA_ID` INT NOT NULL,
  `AGENDA_TYPE` INT NOT NULL,
  `SUBJECT` VARCHAR(500) NOT NULL,
  `ISSUE_OF_CONSIDERATION` VARCHAR(500) NULL,
  `BACKGROUND` VARCHAR(2000) NULL,
  `SUBMISSION` VARCHAR(1000) NULL,
  `ATTACHMENT` INT NULL,
  `CREATED_BY` VARCHAR(45) NULL,
  `CREATED_TIME` DATETIME NULL,
  `LAST_UPDT_BY` VARCHAR(45) NULL,
  `LAST_UPDT_TIME` DATETIME NULL,
  PRIMARY KEY (`AGENDA_HISTORY_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boardmeeting`.`COMMON_LOOKUP_CODE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boardmeeting`.`COMMON_LOOKUP_CODE` (
  `LOOKUP_CODE_ID` INT NOT NULL AUTO_INCREMENT,
  `COMMON_LOOKUP_ID` INT NOT NULL,
  `LOOKUP_CODE_NAME` VARCHAR(45) NOT NULL,
  `CREATED_BY` VARCHAR(45) NULL,
  `CREATED_TIME` DATETIME NULL,
  `LAST_UPDT_BY` VARCHAR(45) NULL,
  `LAST_UPDT_TIME` DATETIME NULL,
  PRIMARY KEY (`LOOKUP_CODE_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boardmeeting`.`ROLE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boardmeeting`.`ROLE` (
  `ROLE_ID` INT NOT NULL AUTO_INCREMENT,
  `ROLE_NAME` VARCHAR(45) NULL,
  PRIMARY KEY (`ROLE_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boardmeeting`.`PRIVILAGES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boardmeeting`.`PRIVILAGES` (
  `PRIVILAGE_ID` INT NOT NULL AUTO_INCREMENT,
  `PRIVILAGE_NAME` VARCHAR(45) NULL,
  PRIMARY KEY (`PRIVILAGE_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boardmeeting`.`ROLE_HAS_PRIVILAGES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boardmeeting`.`ROLE_HAS_PRIVILAGES` (
  `ROLE_ID` INT NOT NULL,
  `PRIVILAGE_ID` INT NOT NULL,
  PRIMARY KEY (`ROLE_ID`, `PRIVILAGE_ID`),
  INDEX `fk_ROLE_has_PRIVILEGES_PRIVILEGES1_idx` (`PRIVILAGE_ID` ASC) VISIBLE,
  INDEX `fk_ROLE_has_PRIVILEGES_ROLE1_idx` (`ROLE_ID` ASC) VISIBLE,
  CONSTRAINT `fk_ROLE_has_PRIVILEGES_ROLE1`
    FOREIGN KEY (`ROLE_ID`)
    REFERENCES `boardmeeting`.`ROLE` (`ROLE_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ROLE_has_PRIVILEGES_PRIVILEGES1`
    FOREIGN KEY (`PRIVILAGE_ID`)
    REFERENCES `boardmeeting`.`PRIVILAGES` (`PRIVILAGE_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boardmeeting`.`USER_INFORMATION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boardmeeting`.`USER_INFORMATION` (
  `USER_ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(100) NOT NULL,
  `DEPT_ID` INT NULL,
  `USER_LOGIN_ID` INT NULL,
  PRIMARY KEY (`USER_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boardmeeting`.`USER_HAS_ROLES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boardmeeting`.`USER_HAS_ROLES` (
  `USER_ID` INT NOT NULL,
  `ROLE_ID` INT NOT NULL,
  PRIMARY KEY (`USER_ID`, `ROLE_ID`),
  INDEX `fk_USER_INFORMATION_has_ROLE_ROLE1_idx` (`ROLE_ID` ASC) VISIBLE,
  INDEX `fk_USER_INFORMATION_has_ROLE_USER_INFORMATION1_idx` (`USER_ID` ASC) VISIBLE,
  CONSTRAINT `fk_USER_INFORMATION_has_ROLE_USER_INFORMATION1`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `boardmeeting`.`USER_INFORMATION` (`USER_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_USER_INFORMATION_has_ROLE_ROLE1`
    FOREIGN KEY (`ROLE_ID`)
    REFERENCES `boardmeeting`.`ROLE` (`ROLE_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boardmeeting`.`USER_INFORMATION_HISTORY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boardmeeting`.`USER_INFORMATION_HISTORY` (
  `USER_ID_HISTORY` INT NOT NULL AUTO_INCREMENT,
  `USER_ID` INT NOT NULL,
  `NAME` VARCHAR(100) NOT NULL,
  `DEPT_ID` INT NULL,
  `USER_LOGIN_ID` INT NULL,
  PRIMARY KEY (`USER_ID_HISTORY`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boardmeeting`.`BOARD_MEETING`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boardmeeting`.`BOARD_MEETING` (
  `BOARD_MEETING_ID` INT NOT NULL AUTO_INCREMENT,
  `BOARD_MEETING_SUBJECT` VARCHAR(200) NULL,
  `BOARD_MEETING_CONTENT` VARCHAR(2000) NULL,
  `BOARD_MEETING_DATE` DATETIME NULL,
  `BOARD_MEETING_COMMENT` VARCHAR(1000) NULL,
  `CREATED_BY` VARCHAR(45) NULL,
  `CREATED_TIME` DATETIME NULL,
  `LAST_UPDT_BY` VARCHAR(45) NULL,
  `LAST_UPDT_TIME` DATETIME NULL,
  PRIMARY KEY (`BOARD_MEETING_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boardmeeting`.`BOARD_MEETING_AGENDAS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boardmeeting`.`BOARD_MEETING_AGENDAS` (
  `BOARD_MEETING_ID` INT NOT NULL,
  `AGENDA_ID` INT NOT NULL,
  PRIMARY KEY (`BOARD_MEETING_ID`, `AGENDA_ID`),
  INDEX `fk_AGENDA_has_BoardMeeting_BoardMeeting1_idx` (`BOARD_MEETING_ID` ASC) VISIBLE,
  INDEX `fk_AGENDA_has_BoardMeeting_AGENDA1_idx` (`AGENDA_ID` ASC) VISIBLE,
  CONSTRAINT `fk_AGENDA_has_BoardMeeting_AGENDA1`
    FOREIGN KEY (`AGENDA_ID`)
    REFERENCES `boardmeeting`.`AGENDA` (`AGENDA_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AGENDA_has_BoardMeeting_BoardMeeting1`
    FOREIGN KEY (`BOARD_MEETING_ID`)
    REFERENCES `boardmeeting`.`BOARD_MEETING` (`BOARD_MEETING_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
