--  用户表
DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id                      VARCHAR(32) PRIMARY KEY COMMENT '用户id',
    username                VARCHAR(100) NOT NULL COMMENT '用户名',
    password                VARCHAR(100) NOT NULL COMMENT '用户密码密文',
    name                    VARCHAR(200) COMMENT '用户姓名',
    mobile                  VARCHAR(20) COMMENT '用户手机',
    description             VARCHAR(500) COMMENT '简介',
    deleted                 VARCHAR(1)   NOT NULL DEFAULT 'N' COMMENT '是否已删除Y：已删除，N：未删除',
    enabled                 BOOLEAN COMMENT '是否有效用户',
    account_non_expired     BOOLEAN COMMENT '账号是否未过期',
    credentials_non_expired BOOLEAN COMMENT '密码是否未过期',
    account_non_locked      BOOLEAN COMMENT '是否未锁定',
    login_time              DATETIME     NOT NULL DEFAULT now() COMMENT '上次登录时间',
    created_time            DATETIME     NOT NULL DEFAULT now() COMMENT '创建时间',
    updated_time            DATETIME     NOT NULL DEFAULT now() COMMENT '更新时间',
    created_by              VARCHAR(100) NOT NULL DEFAULT 'DEFAULT' COMMENT '创建人',
    updated_by              VARCHAR(100) NOT NULL DEFAULT 'DEFAULT' COMMENT '更新人'
) COMMENT '用户表';

--  角色表
DROP TABLE IF EXISTS roles;
CREATE TABLE roles
(
    id           VARCHAR(32) PRIMARY KEY COMMENT '角色id',
    code         VARCHAR(100) NOT NULL COMMENT '角色code',
    name         VARCHAR(200) COMMENT '角色名称',
    description  VARCHAR(500) COMMENT '简介',
    created_time DATETIME     NOT NULL DEFAULT now() COMMENT '创建时间',
    updated_time DATETIME     NOT NULL DEFAULT now() COMMENT '更新时间',
    created_by   VARCHAR(100) NOT NULL COMMENT '创建人',
    updated_by   VARCHAR(100) NOT NULL COMMENT '更新人'
) COMMENT '角色表';

-- 用户角色表
DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role
(
    id           VARCHAR(32) PRIMARY KEY COMMENT '关系id',
    user_id      VARCHAR(32)  NOT NULL COMMENT '用户id',
    role_id      VARCHAR(32)  NOT NULL COMMENT '角色id',
    created_time DATETIME     NOT NULL DEFAULT now() COMMENT '创建时间',
    updated_time DATETIME     NOT NULL DEFAULT now() COMMENT '更新时间',
    created_by   VARCHAR(100) NOT NULL COMMENT '创建人',
    updated_by   VARCHAR(100) NOT NULL COMMENT '更新人'
) COMMENT '用户角色表';

-- 菜单表
DROP TABLE IF EXISTS menus;
CREATE TABLE menus
(
    id           VARCHAR(32) PRIMARY KEY COMMENT 'id',
    parent_id    VARCHAR(32)  NOT NULL COMMENT '父菜单id',
    type         VARCHAR(100) COMMENT '菜单类型',
    href         VARCHAR(200) COMMENT '菜单路径',
    icon         VARCHAR(200) COMMENT '菜单图标',
    name         VARCHAR(200) COMMENT '菜单名称',
    description  VARCHAR(500) COMMENT '描述',
    sort         VARCHAR(2)   COMMENT '序号',
    created_time DATETIME     NOT NULL DEFAULT now() COMMENT '创建时间',
    updated_time DATETIME     NOT NULL DEFAULT now() COMMENT '更新时间',
    created_by   VARCHAR(100) NOT NULL COMMENT '创建人',
    updated_by   VARCHAR(100) NOT NULL COMMENT '更新人'
) COMMENT '菜单表';

-- 角色菜单表
DROP TABLE IF EXISTS role_menu;
CREATE TABLE role_menu
(
    id           VARCHAR(32) PRIMARY KEY COMMENT 'id',
    menu_id      VARCHAR(32)  NOT NULL COMMENT '菜单id',
    role_id      VARCHAR(32)  NOT NULL COMMENT '角色id',
    created_time DATETIME     NOT NULL DEFAULT now() COMMENT '创建时间',
    updated_time DATETIME     NOT NULL DEFAULT now() COMMENT '更新时间',
    created_by   VARCHAR(100) NOT NULL COMMENT '创建人',
    updated_by   VARCHAR(100) NOT NULL COMMENT '更新人'
) COMMENT '角色菜单表';