/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : platform

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2020-04-15 03:18:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `device`
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '设备ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备名称',
  `price` int NOT NULL COMMENT '设备价格',
  `level` int NOT NULL COMMENT '二级类别',
  `buy_date` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '购买日期',
  `status` tinyint NOT NULL COMMENT '设备状态',
  `user` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '使用者',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES ('1', '苹果笔记本电脑', '8000', '1', '2020-04-15 03:15:22', '1', ' ', ' 要自由工作、要尽情创意，你需要一部强劲的新一代笔记本电脑，灵活多变，性能卓越，外形时尚。每一部 Mac，都是为您倾力打造的精心之作。');
INSERT INTO `device` VALUES ('2', '戴尔液晶显示屏', '5000', '2', '2020-04-15 03:09:57', '1', ' ', ' ');
INSERT INTO `device` VALUES ('3', 'Cherry机械键盘-X1', '805', '6', '2020-04-15 03:09:57', '1', ' ', ' ');
INSERT INTO `device` VALUES ('4', 'Dell高清显示屏-S系列', '2999', '2', '2020-04-15 03:09:58', '1', ' ', ' ');
INSERT INTO `device` VALUES ('5', '华硕笔记本-Air系列', '4500', '1', '2020-04-15 03:09:58', '1', ' ', ' ');
INSERT INTO `device` VALUES ('6', '小米笔记本-Pro', '5999', '1', '2020-04-15 03:10:01', '1', ' ', ' ');
INSERT INTO `device` VALUES ('7', '<<三体之死神永生>>', '49', '9', '2020-04-15 03:09:55', '1', ' ', ' ');
INSERT INTO `device` VALUES ('8', '<<C++入门其实很简单>>', '89', '9', '2020-04-15 03:09:55', '1', ' ', ' ');
INSERT INTO `device` VALUES ('9', '公牛插线板-10孔', '49', '7', '2020-04-15 03:09:54', '1', ' ', ' ');
INSERT INTO `device` VALUES ('10', '公牛插线板-4孔', '29', '7', '2020-04-15 03:09:53', '1', ' ', ' ');
INSERT INTO `device` VALUES ('11', '米家智能插线板-6孔', '49', '7', '2020-04-15 03:09:52', '1', ' ', ' ');

-- ----------------------------
-- Table structure for `first_type`
-- ----------------------------
DROP TABLE IF EXISTS `first_type`;
CREATE TABLE `first_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of first_type
-- ----------------------------
INSERT INTO `first_type` VALUES ('1', '办公设备');
INSERT INTO `first_type` VALUES ('2', '机械设备');
INSERT INTO `first_type` VALUES ('3', '其他设备');

-- ----------------------------
-- Table structure for `return_device`
-- ----------------------------
DROP TABLE IF EXISTS `return_device`;
CREATE TABLE `return_device` (
  `id` int NOT NULL AUTO_INCREMENT,
  `use_id` int NOT NULL,
  `return_date` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `user` varchar(50) NOT NULL,
  `remark` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of return_device
-- ----------------------------

-- ----------------------------
-- Table structure for `second_type`
-- ----------------------------
DROP TABLE IF EXISTS `second_type`;
CREATE TABLE `second_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `first_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of second_type
-- ----------------------------
INSERT INTO `second_type` VALUES ('1', '笔记本电脑', '1');
INSERT INTO `second_type` VALUES ('2', '显示器', '1');
INSERT INTO `second_type` VALUES ('3', '机械硬盘', '1');
INSERT INTO `second_type` VALUES ('4', '有线鼠标', '1');
INSERT INTO `second_type` VALUES ('5', '蓝牙鼠标', '1');
INSERT INTO `second_type` VALUES ('6', '机械键盘', '1');
INSERT INTO `second_type` VALUES ('7', '电线插排', '2');
INSERT INTO `second_type` VALUES ('8', '检测仪器', '2');
INSERT INTO `second_type` VALUES ('9', '文化书籍', '3');
INSERT INTO `second_type` VALUES ('10', '陈列品', '3');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(50) NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `position` varchar(50) NOT NULL,
  `role` tinyint(1) NOT NULL DEFAULT '0',
  `remark` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'djh', '123456', '普通职位', '0', '第一个用户');
INSERT INTO `user` VALUES ('2', 'admin', '654321', '管理员', '1', '管理员用户');

-- ----------------------------
-- Table structure for `use_device`
-- ----------------------------
DROP TABLE IF EXISTS `use_device`;
CREATE TABLE `use_device` (
  `id` int NOT NULL AUTO_INCREMENT,
  `device_id` int NOT NULL,
  `use_date` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `user` varchar(50) NOT NULL,
  `remark` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of use_device
-- ----------------------------
