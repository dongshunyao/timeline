/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : timeline

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 01/06/2020 23:08:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for group_apply
-- ----------------------------
DROP TABLE IF EXISTS `group_apply`;
CREATE TABLE `group_apply`  (
  `gid` int(0) NOT NULL,
  `uid` int(0) NOT NULL,
  PRIMARY KEY (`gid`, `uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group_apply
-- ----------------------------
INSERT INTO `group_apply` VALUES (1, 4);
INSERT INTO `group_apply` VALUES (1, 5);
INSERT INTO `group_apply` VALUES (1, 6);
INSERT INTO `group_apply` VALUES (2, 7);
INSERT INTO `group_apply` VALUES (2, 8);

-- ----------------------------
-- Table structure for group_info
-- ----------------------------
DROP TABLE IF EXISTS `group_info`;
CREATE TABLE `group_info`  (
  `gid` int(0) NOT NULL AUTO_INCREMENT,
  `muid` int(0) NULL DEFAULT NULL,
  `gname` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`gid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group_info
-- ----------------------------
INSERT INTO `group_info` VALUES (1, 1, '组1');
INSERT INTO `group_info` VALUES (2, 2, '组2');

-- ----------------------------
-- Table structure for group_member
-- ----------------------------
DROP TABLE IF EXISTS `group_member`;
CREATE TABLE `group_member`  (
  `gid` int(0) NOT NULL,
  `uid` int(0) NOT NULL,
  PRIMARY KEY (`gid`, `uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group_member
-- ----------------------------
INSERT INTO `group_member` VALUES (1, 1);
INSERT INTO `group_member` VALUES (1, 2);
INSERT INTO `group_member` VALUES (1, 3);
INSERT INTO `group_member` VALUES (2, 1);
INSERT INTO `group_member` VALUES (2, 2);
INSERT INTO `group_member` VALUES (2, 3);

-- ----------------------------
-- Table structure for record_body
-- ----------------------------
DROP TABLE IF EXISTS `record_body`;
CREATE TABLE `record_body`  (
  `rid` int(0) NOT NULL AUTO_INCREMENT,
  `uid` int(0) NULL DEFAULT NULL,
  `title` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `time` bigint(0) NULL DEFAULT NULL,
  `detail` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record_body
-- ----------------------------
INSERT INTO `record_body` VALUES (1, 1, '记录1', 1591023065, '这是记录1');
INSERT INTO `record_body` VALUES (2, 1, '记录2', 1591023095, '这是记录2');

-- ----------------------------
-- Table structure for record_pic
-- ----------------------------
DROP TABLE IF EXISTS `record_pic`;
CREATE TABLE `record_pic`  (
  `rid` int(0) NOT NULL,
  `picid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `pos` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`rid`, `picid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record_pic
-- ----------------------------
INSERT INTO `record_pic` VALUES (2, '1_AAAA', 1);
INSERT INTO `record_pic` VALUES (2, '1_BBBB', 2);

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task`  (
  `tid` int(0) NOT NULL AUTO_INCREMENT,
  `uid` int(0) NULL DEFAULT NULL,
  `gid` int(0) NULL DEFAULT NULL,
  `title` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `begin` bigint(0) NULL DEFAULT NULL,
  `end` bigint(0) NULL DEFAULT NULL,
  `detail` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `repeat` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES (1, 1, -1, '事件1', 1591023065, 1591025065, '事件1描述', 0);
INSERT INTO `task` VALUES (2, 1, -1, '事件2', 1591027200, 1591028200, '事件2描述', 1);
INSERT INTO `task` VALUES (3, 1, -1, '事件3', 1591113600, 1591114600, '事件3描述', 2);
INSERT INTO `task` VALUES (4, 2, -1, '事件4', 1591200000, 1591201000, '事件4描述', 0);
INSERT INTO `task` VALUES (5, -1, 1, '组事件1', 1591286400, 1591287400, '组事件1描述', 0);
INSERT INTO `task` VALUES (6, -1, 2, '组事件2', 1591372800, 1591373800, '组事件2描述', 0);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `uid` int(0) NOT NULL,
  `nickname` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `regtime` bigint(0) NULL DEFAULT NULL,
  `isVIP` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, '小1', 1591022112, 0);
INSERT INTO `user_info` VALUES (2, '小2', 1591022112, 1);
INSERT INTO `user_info` VALUES (3, '小3', 1591022112, 0);
INSERT INTO `user_info` VALUES (4, '小4', 1591022112, 0);
INSERT INTO `user_info` VALUES (5, '小5', 1591022112, 0);
INSERT INTO `user_info` VALUES (6, '小6', 1591022112, 0);
INSERT INTO `user_info` VALUES (7, '小7', 1591022112, 0);
INSERT INTO `user_info` VALUES (8, '小8', 1591022112, 0);
INSERT INTO `user_info` VALUES (9, '小9', 1591022112, 0);
INSERT INTO `user_info` VALUES (10, '小10', 1591022112, 0);

-- ----------------------------
-- Table structure for user_login
-- ----------------------------
DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login`  (
  `uid` int(0) NOT NULL,
  `token` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_login
-- ----------------------------

-- ----------------------------
-- Table structure for user_reg
-- ----------------------------
DROP TABLE IF EXISTS `user_reg`;
CREATE TABLE `user_reg`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT,
  `qqid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `wechatid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pwd` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_reg
-- ----------------------------
INSERT INTO `user_reg` VALUES (1, NULL, NULL, '13000000001', '111111');
INSERT INTO `user_reg` VALUES (2, NULL, NULL, '13000000002', '222222');
INSERT INTO `user_reg` VALUES (3, NULL, NULL, '13000000003', '333333');
INSERT INTO `user_reg` VALUES (4, NULL, NULL, '13000000004', '444444');
INSERT INTO `user_reg` VALUES (5, NULL, NULL, '13000000005', '555555');
INSERT INTO `user_reg` VALUES (6, NULL, NULL, '13000000006', '666666');
INSERT INTO `user_reg` VALUES (7, NULL, NULL, '13000000007', '777777');
INSERT INTO `user_reg` VALUES (8, NULL, NULL, '13000000008', '888888');
INSERT INTO `user_reg` VALUES (9, NULL, NULL, '13000000009', '999999');
INSERT INTO `user_reg` VALUES (10, NULL, NULL, '13000000010', '000000');

SET FOREIGN_KEY_CHECKS = 1;
