DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id唯一标识',
  `name` varchar(50) NOT NULL COMMENT '角色名称',
  `is_using` int(11) DEFAULT '1' COMMENT '是否启用（0：不启用 1：启用）默认1',
  `flag` varchar(255) DEFAULT NULL COMMENT '预留字段',
  `create_time` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(50) DEFAULT NULL COMMENT '修改时间',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', '超级管理员', '1', null, null, null, null, null);
INSERT INTO `tb_role` VALUES ('4', '管理员', '1', null, null, null, null, null);