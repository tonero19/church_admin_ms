CREATE TABLE IF NOT EXISTS church_detail (
    id int auto_increment primary key,
    `name` varchar(512) not null,
    `type` varchar(128) null,
    street varchar(256) not null,
    `number` varchar(16) not null,
    post_code varchar(32) not null,
    city varchar(128) not null,
    `state` varchar(128) null,
    country varchar(128) not null,
    `created_at` date not null,
    `created_by` varchar(256) null,
    `updated_at` date DEFAULT NULL,
    `updated_by` varchar(256) NULL
);
