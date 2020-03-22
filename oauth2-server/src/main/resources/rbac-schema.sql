CREATE TABLE `rbac_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父权限',
  `name` varchar(64) NOT NULL COMMENT '权限名称',
  `enname` varchar(64) NOT NULL COMMENT '权限英文名称',
  `url` varchar(255) NOT NULL COMMENT '授权路径',
  `description` varchar(200) DEFAULT NULL COMMENT '备注',
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

CREATE TABLE `rbac_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父角色',
  `name` varchar(64) NOT NULL COMMENT '角色名称',
  `enname` varchar(64) NOT NULL COMMENT '角色英文名称',
  `description` varchar(200) DEFAULT NULL COMMENT '备注',
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

CREATE TABLE `rbac_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL COMMENT '角色 ID',
  `permission_id` bigint(20) NOT NULL COMMENT '权限 ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';

CREATE TABLE `rbac_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码，加密存储',
  `phone` varchar(20) DEFAULT NULL COMMENT '注册手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '注册邮箱',
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE,
  UNIQUE KEY `phone` (`phone`) USING BTREE,
  UNIQUE KEY `email` (`email`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

CREATE TABLE `rbac_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户 ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色 ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- 0.4.2-SNAPSHOT
INSERT INTO `rbac_permission`(`id`, `parent_id`, `name`, `enname`, `url`, `description`, `created`, `updated`) VALUES (1, 0, '测试权限-morning', 'oauth2client:hello:morning', '/oauth2client/hello/morning', NULL, now(), now());
INSERT INTO `rbac_permission`(`id`, `parent_id`, `name`, `enname`, `url`, `description`, `created`, `updated`) VALUES (2, 0, '测试权限-afternoon', 'oauth2client:hello:afternoon', '/oauth2client/hello/afternoon', NULL, now(), now());
INSERT INTO `rbac_permission`(`id`, `parent_id`, `name`, `enname`, `url`, `description`, `created`, `updated`) VALUES (3, 0, '测试权限-night', 'oauth2client:hello:night', '/oauth2client/hello/night', NULL, now(), now());

INSERT INTO `rbac_role`(`id`, `parent_id`, `name`, `enname`, `description`, `created`, `updated`) VALUES (1, 0, '测试角色', 'oauth2client', NULL, now(), now());

INSERT INTO `rbac_role_permission`(`id`, `role_id`, `permission_id`) VALUES (1, 1, 1);
INSERT INTO `rbac_role_permission`(`id`, `role_id`, `permission_id`) VALUES (2, 1, 2);
/*INSERT INTO `rbac_role_permission`(`id`, `role_id`, `permission_id`) VALUES (3, 1, 3);*/

INSERT INTO `rbac_user`(`id`, `username`, `password`, `phone`, `email`, `created`, `updated`) VALUES (1, 'admin', '$2a$10$OZjuEUV1.se6xxp50Fj47Ov56Aex5wSK9hVGcNxaX00VThBaQvJ6u', '15888888888', 'admin@163.com', now(), now());

INSERT INTO `rbac_user_role`(`id`, `user_id`, `role_id`) VALUES (1, 1, 1);
