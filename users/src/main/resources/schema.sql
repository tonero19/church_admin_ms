CREATE TABLE IF NOT EXISTS `user` (
    id bigint auto_increment primary key,
    `church_id` varchar(128) null,
    `user_name` varchar(128) not null,
    `email` varchar(128) not null,
    `password` varchar(256) not null,
    constraint uk_user_email unique (email)
);

CREATE TABLE IF NOT EXISTS `role` (
    id bigint auto_increment primary key,
    role varchar(128) not null,
    `description` varchar(512) null,
    constraint role unique (role)
);


CREATE TABLE IF NOT EXISTS `user_role` (
    id bigint auto_increment primary key,
    `user_id` bigint not null,
    `role_id` bigint not null,
    constraint unique_user_role unique (user_id, role_id)
);
