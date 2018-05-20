CREATE TABLE admin(
	admin_id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(32),
	PASSWORD VARCHAR(32) COMMENT 'md5加密',
	phone VARCHAR(11) COMMENT '联系电话',
	email VARCHAR(32) COMMENT '邮箱'
);

CREATE TABLE news(
	news_id INT PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(64),
	published_time TIMESTAMP DEFAULT NOW() COMMENT '上传时间',
	content_url VARCHAR(255) COMMENT '内容的url',
	visits INT COMMENT'访问次数',
	admin_id INT COMMENT '作者id',
	top BIT(1) COMMENT '是否置顶',
	foreign key(admin_id) references admin(admin_id) on delete cascade on update cascade
);

CREATE TABLE attachment(
	attachment_id INT PRIMARY KEY AUTO_INCREMENT,
	news_id INT COMMENT '所属新闻',
	file_path VARCHAR(128) COMMENT '文件路径',
	file_name VARCHAR(128) COMMENT '后端存储文件名',
	show_name VARCHAR(128) COMMENT '前端显示文件名',
	published_time TIMESTAMP COMMENT '上传时间',
	download_url VARCHAR(255) COMMENT '下载链接',
	foreign key(news_id) references news(news_id) on delete cascade on update cascade
);













