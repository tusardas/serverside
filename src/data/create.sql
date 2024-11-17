CREATE TABLE `user` (
  `email` varchar(255) COLLATE latin1_bin NOT NULL,
  `password` longtext COLLATE latin1_bin NOT NULL,
  `first_name` varchar(255) COLLATE latin1_bin DEFAULT '',
  `last_name` varchar(255) COLLATE latin1_bin DEFAULT '',
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

INSERT INTO `user` (`email`, `password`, `first_name`, `last_name`, `id`) VALUES ('test@post.com', 'xxxxxxxx', 'test', 'test', 1);

CREATE TABLE `post` (
  `id` bigint NOT NULL,
  `body` longtext CHARACTER SET latin1 COLLATE latin1_bin,
  `date_created` datetime NOT NULL,
  `last_updated` datetime DEFAULT NULL,
  `title` varchar(255) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

INSERT INTO `post` (`id`, `body`, `date_created`, `last_updated`, `title`) VALUES (1, 'This is body of post1', '2024-10-05 18:25:29', NULL, 'This is title of post1');
INSERT INTO `post` (`id`, `body`, `date_created`, `last_updated`, `title`) VALUES (2, 'This is body of post2', '2024-10-05 18:25:29', NULL, 'This is title of post2');
