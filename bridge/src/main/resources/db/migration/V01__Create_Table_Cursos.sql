CREATE TABLE `tb_cursos` (
  `id_curso` bigint NOT NULL AUTO_INCREMENT,
  `area_interesse` int NOT NULL,
  `duracao` varchar(30) DEFAULT NULL,
  `escolaridade_minima` varchar(100) DEFAULT NULL,
  `link_cadastro` varchar(150) DEFAULT NULL,
  `nome_curso` varchar(100) DEFAULT NULL,
  `sobre_curso` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_curso`)
)