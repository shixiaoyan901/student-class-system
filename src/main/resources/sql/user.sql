/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50709
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2018-07-02 19:05:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123');
INSERT INTO `user` VALUES ('2', 'demo', '123');
INSERT INTO `user` VALUES ('3', 'iii', '454');
INSERT INTO `user` VALUES ('4', 'abc', '123');
INSERT INTO `user` VALUES ('20', 'ddd', '1241545');
INSERT INTO `user` VALUES ('21', 'dddd', '1241545');
INSERT INTO `user` VALUES ('22', 'yyy', '1212');
INSERT INTO `user` VALUES ('23', 'lll', '1212');
INSERT INTO `user` VALUES ('24', 'ppp', '41545');
INSERT INTO `user` VALUES ('25', 'www', '4454');
INSERT INTO `user` VALUES ('26', 'oo', '44');
INSERT INTO `user` VALUES ('27', 'ggg', '47887');
INSERT INTO `user` VALUES ('28', '大魔王', '1241545');
INSERT INTO `user` VALUES ('29', '大白菜', '1241545');
INSERT INTO `user` VALUES ('30', '大名', '1212');
INSERT INTO `user` VALUES ('31', '小明', '1212');
INSERT INTO `user` VALUES ('32', '三皇', '454');
INSERT INTO `user` VALUES ('33', '弟弟', '41545');
INSERT INTO `user` VALUES ('34', '明明', '4454');
INSERT INTO `user` VALUES ('35', '可积极', '44');
INSERT INTO `user` VALUES ('36', '埃及', '47887');
