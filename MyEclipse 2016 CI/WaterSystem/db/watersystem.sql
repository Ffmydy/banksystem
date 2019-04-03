/*
 Navicat Premium Data Transfer

 Source Server         : myconn
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : watersystem

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 03/04/2019 19:09:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for boss
-- ----------------------------
DROP TABLE IF EXISTS `boss`;
CREATE TABLE `boss`  (
  `boss_number` int(11) NOT NULL,
  `boss_numbe` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `boss_age` int(2) DEFAULT NULL,
  `boss_sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `boss_phonenumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `boss_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `boss_photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`boss_number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for entrusted_unit
-- ----------------------------
DROP TABLE IF EXISTS `entrusted_unit`;
CREATE TABLE `entrusted_unit`  (
  `unit_number` int(11) NOT NULL,
  `unit_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `unit_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `unit_phonenumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `boss_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`unit_number`) USING BTREE,
  INDEX `boss_number`(`boss_number`) USING BTREE,
  CONSTRAINT `boss_number` FOREIGN KEY (`boss_number`) REFERENCES `boss` (`boss_number`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for irrigation _water_ requirement
-- ----------------------------
DROP TABLE IF EXISTS `irrigation _water_ requirement`;
CREATE TABLE `irrigation _water_ requirement`  (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `year` year(4) DEFAULT NULL,
  `month` int(2) DEFAULT NULL,
  `water_requirement` double(255, 2) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of irrigation _water_ requirement
-- ----------------------------
INSERT INTO `irrigation _water_ requirement` VALUES (1, 1960, 1, 0.00);
INSERT INTO `irrigation _water_ requirement` VALUES (2, 1960, 2, 0.00);
INSERT INTO `irrigation _water_ requirement` VALUES (3, 1960, 3, 0.00);
INSERT INTO `irrigation _water_ requirement` VALUES (4, 1960, 4, 32.00);
INSERT INTO `irrigation _water_ requirement` VALUES (5, 1960, 5, 48.00);
INSERT INTO `irrigation _water_ requirement` VALUES (6, 1960, 6, 40.00);
INSERT INTO `irrigation _water_ requirement` VALUES (7, 1960, 7, 4.00);
INSERT INTO `irrigation _water_ requirement` VALUES (8, 1960, 8, 0.00);
INSERT INTO `irrigation _water_ requirement` VALUES (9, 1960, 9, 36.00);
INSERT INTO `irrigation _water_ requirement` VALUES (10, 1960, 10, 0.00);
INSERT INTO `irrigation _water_ requirement` VALUES (11, 1960, 11, 0.00);
INSERT INTO `irrigation _water_ requirement` VALUES (12, 1960, 12, 28.00);
INSERT INTO `irrigation _water_ requirement` VALUES (13, 1961, 1, 0.00);

-- ----------------------------
-- Table structure for manage
-- ----------------------------
DROP TABLE IF EXISTS `manage`;
CREATE TABLE `manage`  (
  `manage_number` int(11) NOT NULL AUTO_INCREMENT,
  `manage_phonenumber` varchar(20) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL,
  `manage_password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `manage_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `manage_sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `manage_age` int(2) DEFAULT NULL,
  `manage_photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`manage_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of manage
-- ----------------------------
INSERT INTO `manage` VALUES (1, '18637197687', '123456', '杜玉', '男', 24, NULL);

-- ----------------------------
-- Table structure for reservoir_water_evaporation
-- ----------------------------
DROP TABLE IF EXISTS `reservoir_water_evaporation`;
CREATE TABLE `reservoir_water_evaporation`  (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `year` year(4) DEFAULT NULL,
  `month` int(2) DEFAULT NULL,
  `water_evaporation` double(255, 1) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of reservoir_water_evaporation
-- ----------------------------
INSERT INTO `reservoir_water_evaporation` VALUES (1, 1960, 1, 9.9);
INSERT INTO `reservoir_water_evaporation` VALUES (2, 1960, 2, 19.9);
INSERT INTO `reservoir_water_evaporation` VALUES (3, 1960, 3, 46.0);
INSERT INTO `reservoir_water_evaporation` VALUES (4, 1960, 4, 73.9);
INSERT INTO `reservoir_water_evaporation` VALUES (5, 1960, 5, 90.8);
INSERT INTO `reservoir_water_evaporation` VALUES (6, 1960, 6, 79.9);
INSERT INTO `reservoir_water_evaporation` VALUES (7, 1960, 7, 83.4);
INSERT INTO `reservoir_water_evaporation` VALUES (8, 1960, 8, 76.6);
INSERT INTO `reservoir_water_evaporation` VALUES (9, 1960, 9, 73.6);
INSERT INTO `reservoir_water_evaporation` VALUES (10, 1960, 10, 59.1);
INSERT INTO `reservoir_water_evaporation` VALUES (11, 1960, 11, 37.7);
INSERT INTO `reservoir_water_evaporation` VALUES (12, 1960, 12, 20.9);
INSERT INTO `reservoir_water_evaporation` VALUES (13, 1961, 1, 17.2);

-- ----------------------------
-- Table structure for water_test_report
-- ----------------------------
DROP TABLE IF EXISTS `water_test_report`;
CREATE TABLE `water_test_report`  (
  `Item_number` int(11) NOT NULL,
  `Item_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Item_concentration` double(10, 2) DEFAULT NULL,
  `water_level` int(2) DEFAULT NULL COMMENT '(0-5)依次基本越高，水质越差',
  `detection_time` datetime DEFAULT NULL,
  `unit_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`Item_number`) USING BTREE,
  INDEX `unit_number`(`unit_number`) USING BTREE,
  CONSTRAINT `unit_number` FOREIGN KEY (`unit_number`) REFERENCES `entrusted_unit` (`unit_number`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- View structure for count_month_evaporation
-- ----------------------------
DROP VIEW IF EXISTS `count_month_evaporation`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `count_month_evaporation` AS select `reservoir_water_evaporation`.`month` AS `month`,sum(`reservoir_water_evaporation`.`water_evaporation`) AS `month_water_evaporation`,cast(avg(`reservoir_water_evaporation`.`water_evaporation`) as decimal(10,1)) AS `month_average_water_evaporation` from `reservoir_water_evaporation` group by `reservoir_water_evaporation`.`month`;

-- ----------------------------
-- View structure for count_month_requirement
-- ----------------------------
DROP VIEW IF EXISTS `count_month_requirement`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `count_month_requirement` AS select `irrigation _water_ requirement`.`month` AS `month`,sum(`irrigation _water_ requirement`.`water_requirement`) AS `month_water_requirement`,cast(avg(`irrigation _water_ requirement`.`water_requirement`) as decimal(10,2)) AS `month_average_water_requirement` from `irrigation _water_ requirement` group by `irrigation _water_ requirement`.`month`;

-- ----------------------------
-- View structure for count_year_evaporation
-- ----------------------------
DROP VIEW IF EXISTS `count_year_evaporation`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `count_year_evaporation` AS select `reservoir_water_evaporation`.`year` AS `year`,sum(`reservoir_water_evaporation`.`water_evaporation`) AS `year_water_evaporation`,cast(avg(`reservoir_water_evaporation`.`water_evaporation`) as decimal(10,1)) AS `year_average_water_evaporation` from `reservoir_water_evaporation` group by `reservoir_water_evaporation`.`year`;

-- ----------------------------
-- View structure for count_year_requirement
-- ----------------------------
DROP VIEW IF EXISTS `count_year_requirement`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `count_year_requirement` AS select `irrigation _water_ requirement`.`year` AS `year`,sum(`irrigation _water_ requirement`.`water_requirement`) AS `year_water_requirement`,cast(avg(`irrigation _water_ requirement`.`water_requirement`) as decimal(10,2)) AS `year_average_water_requirement` from `irrigation _water_ requirement` group by `irrigation _water_ requirement`.`year`;

SET FOREIGN_KEY_CHECKS = 1;
