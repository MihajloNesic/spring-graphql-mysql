CREATE TABLE `language` (
   id                   int NOT NULL AUTO_INCREMENT,
   name                 varchar(128) NOT NULL,
   code                 varchar(200) NOT NULL,
   color                varchar(7) NOT NULL,
   language_type_id     int NOT NULL,
   primary key (id)
);

CREATE TABLE `language_type` (
   id                   int NOT NULL AUTO_INCREMENT,
   `type`               varchar(25) NOT NULL,
   PRIMARY KEY (id)
);

ALTER TABLE `language` ADD CONSTRAINT FK_LANGUAGE_TYPE FOREIGN KEY (language_type_id)
      REFERENCES language_type (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

INSERT INTO `language_type` (`id`, `type`) VALUES
(1, 'PROGRAMMING'),
(2, 'DATA'),
(3, 'MARKUP');

INSERT INTO `language` (`id`, `name`, `code`, `color`, `language_type_id`) VALUES
(1, 'Java', 'java', 'B07219', 1),
(2, 'PHP', 'php', '4F5D95', 1),
(3, 'C#', 'csharp', '178600', 1),
(4, 'CSS', 'css', '563D7C', 3),
(5, 'HTML', 'html', 'E34C26', 3),
(6, 'TeX', 'tex', '3D6117', 3),
(7, 'SQL', 'sql', 'CCCCCC', 2);