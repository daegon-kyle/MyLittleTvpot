-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema MyLittlePot
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema MyLittlePot
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `MyLittlePot` DEFAULT CHARACTER SET utf8 ;
USE `MyLittlePot` ;

-- -----------------------------------------------------
-- Table `MyLittlePot`.`clip`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyLittlePot`.`clip` (
  `id` VARCHAR(40) NOT NULL,
  `vid` VARCHAR(23) NOT NULL,
  `ownerName` VARCHAR(40) NOT NULL,
  `thumbUrl` VARCHAR(225) NULL DEFAULT NULL,
  `title` VARCHAR(255) NULL DEFAULT NULL,
  `numOfLike` INT(11) NULL DEFAULT '0',
  `playTime` INT(11) NULL DEFAULT '0',
  `numOfPlay` INT(11) NULL DEFAULT '0',
  `regDttm` DATETIME NOT NULL,
  PRIMARY KEY (`id`, `vid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `MyLittlePot`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyLittlePot`.`user` (
  `id` VARCHAR(40) NOT NULL,
  `password` VARCHAR(40) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `MyLittlePot`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyLittlePot`.`comment` (
  `id` VARCHAR(45) NOT NULL,
  `clip_id` VARCHAR(40) NOT NULL,
  `clip_vid` VARCHAR(23) NOT NULL,
  `user_id` VARCHAR(40) NOT NULL,
  `content` VARCHAR(600) NULL DEFAULT NULL,
  `regDttm` DATETIME NULL DEFAULT NULL,
  `availability` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comment_clip1_idx` (`clip_id` ASC, `clip_vid` ASC),
  INDEX `fk_comment_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_comment_clip1`
    FOREIGN KEY (`clip_id` , `clip_vid`)
    REFERENCES `MyLittlePot`.`clip` (`id` , `vid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `MyLittlePot`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `MyLittlePot`.`favorite`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyLittlePot`.`favorite` (
  `id` VARCHAR(100) NOT NULL,
  `clip_id` VARCHAR(45) NOT NULL,
  `clip_vid` VARCHAR(23) NOT NULL,
  `user_id` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_favorite_user1_idx` (`user_id` ASC),
  INDEX `fk_favorite_clip1_idx` (`clip_id` ASC, `clip_vid` ASC),
  CONSTRAINT `fk_favorite_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `MyLittlePot`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_favorite_clip1`
    FOREIGN KEY (`clip_id` , `clip_vid`)
    REFERENCES `MyLittlePot`.`clip` (`id` , `vid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
