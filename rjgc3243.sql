/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : rjgc3243

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 25/11/2019 23:39:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_car
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sum` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_car
-- ----------------------------
INSERT INTO `t_car` VALUES (1, 'Car_002', 900);
INSERT INTO `t_car` VALUES (2, 'Car_001', 1000);
INSERT INTO `t_car` VALUES (3, 'Car_003', 800);

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` bigint(100) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `adr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sum` int(20) NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  `oversum` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (20191125001, '李', '17845336722', '广东省广州市', 'Car_004', 400, '2020-01-30', 60);
INSERT INTO `t_order` VALUES (20191125002, '胡', '18923557544', '广东省中山市', 'Car_007', 300, '2020-02-04', 80);
INSERT INTO `t_order` VALUES (20191125003, '刘', '16736552866', '广东省广州市', 'Car_005', 600, '2020-02-02', 200);
INSERT INTO `t_order` VALUES (20191126001, '张', '18939772532', '广东省深圳市', 'Car_011', 1000, '2020-01-28', 100);
INSERT INTO `t_order` VALUES (20191126002, '赵', '17927664352', '广东省深圳市', 'Car_014', 200, '2020-02-12', 100);
INSERT INTO `t_order` VALUES (20191127001, '周', '18923497544', '广东省广州市', 'Car_007', 2000, '2020-01-29', 90);

-- ----------------------------
-- Table structure for t_part
-- ----------------------------
DROP TABLE IF EXISTS `t_part`;
CREATE TABLE `t_part`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `pname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sum` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_part
-- ----------------------------
INSERT INTO `t_part` VALUES (1, '车门', 'PA20001', 1000);
INSERT INTO `t_part` VALUES (2, '保险杠', 'PA20002', 1200);
INSERT INTO `t_part` VALUES (3, '机油泵', 'PA20003', 1300);
INSERT INTO `t_part` VALUES (4, '刹车盘', 'PA20004', 2000);
INSERT INTO `t_part` VALUES (5, '排气管', 'PA20005', 900);
INSERT INTO `t_part` VALUES (6, '方向盘', 'PA20006', 2000);
INSERT INTO `t_part` VALUES (7, '轮胎', 'PA20007', 3000);
INSERT INTO `t_part` VALUES (8, '凸轮轴', 'PA20008', 900);
INSERT INTO `t_part` VALUES (9, '安全气囊', 'PA20009', 1500);

-- ----------------------------
-- Table structure for t_part_need
-- ----------------------------
DROP TABLE IF EXISTS `t_part_need`;
CREATE TABLE `t_part_need`  (
  `id` bigint(100) NOT NULL AUTO_INCREMENT,
  `pid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sum` int(20) NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_part_need
-- ----------------------------
INSERT INTO `t_part_need` VALUES (1, 'PA20001', 900, '2020-01-15');
INSERT INTO `t_part_need` VALUES (2, 'PA20002', 1000, '2020-01-13');
INSERT INTO `t_part_need` VALUES (3, 'PA20003', 1200, '2020-02-04');
INSERT INTO `t_part_need` VALUES (4, 'PA20007', 900, '2020-01-22');
INSERT INTO `t_part_need` VALUES (5, 'PA20009', 1000, '2020-02-06');

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product`  (
  `id` bigint(100) NOT NULL,
  `model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sum` int(20) NULL DEFAULT NULL,
  `oversum` int(20) NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES (20191125001, 'Car_004', 400, 60, '2020-01-30');
INSERT INTO `t_product` VALUES (20191125002, 'Car_007', 300, 80, '2020-02-04');
INSERT INTO `t_product` VALUES (20191125003, 'Car_005', 600, 200, '2020-02-02');
INSERT INTO `t_product` VALUES (20191126001, 'Car_011', 1000, 100, '2020-01-28');
INSERT INTO `t_product` VALUES (20191126002, 'Car_014', 200, 100, '2020-02-12');
INSERT INTO `t_product` VALUES (20191127001, 'Car_007', 2000, 90, '2020-01-29');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `fid` int(20) NOT NULL AUTO_INCREMENT,
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `role` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`fid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'Sale', '123', 1);
INSERT INTO `t_user` VALUES (2, 'Product', '123', 2);
INSERT INTO `t_user` VALUES (3, 'Store', '123', 3);

SET FOREIGN_KEY_CHECKS = 1;
