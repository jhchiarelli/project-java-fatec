-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.24-log

CREATE DATABASE IF NOT EXISTS trabalhoPoo;
USE trabalhoPoo;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `trabalhoPoo`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `comentario`
--

DROP TABLE IF EXISTS `comentario`;
CREATE TABLE `comentario` (
  `idComentario` int(11) NOT NULL,
  `filme` int(11) NOT NULL,
  `comentario` varchar(200) DEFAULT NULL,
  `nota` double DEFAULT NULL,
  `usuario` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `comentario`
--

INSERT INTO `comentario` (`idComentario`, `filme`, `comentario`, `nota`, `usuario`) VALUES
(1, 1, 'Filme muito engraçado, bem feito.', 7.55, 'JHChiarelli'),
(2, 2, 'Muito lento', 8, 'o Filme'),
(3, 3, 'Muito exibido', 6, 'Robin');

-- --------------------------------------------------------

--
-- Estrutura para tabela `filme`
--
DROP TABLE IF EXISTS `filme`;
CREATE TABLE `filme` (
  `idFilme` int(11) NOT NULL,
  `titulo` varchar(30) DEFAULT NULL,
  `genero` int(11) NOT NULL,
  `ano` varchar(4) DEFAULT NULL,
  `diretor` varchar(80) DEFAULT NULL,
  `pais` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `filme`
--

INSERT INTO `filme` (`idFilme`, `titulo`, `genero`, `ano`, `diretor`, `pais`) VALUES
(1, 'O Máscara', 1, '2001', 'Jin Carey', 'USA'),
(2, 'The Flash Novo', 5, '2016', 'Batoré', 'Brasil'),
(3, 'O Batman', 3, '1991', 'Mussum', 'Brasil'),
(4, 'Fred Cruguer', 6, '2001', 'Silvio', 'Paragua');

-- --------------------------------------------------------

--
-- Estrutura para tabela `genero`
--
DROP TABLE IF EXISTS `genero`;
CREATE TABLE `genero` (
  `idGenero` int(11) NOT NULL,
  `descricao` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `genero`
--

INSERT INTO `genero` (`idGenero`, `descricao`) VALUES
(1, 'Comédia'),
(2, 'Romance'),
(3, 'Drama'),
(4, 'Ação'),
(5, 'Aventura'),
(6, 'Terror');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `comentario`
--
ALTER TABLE `comentario`
  ADD PRIMARY KEY (`idComentario`),
  ADD KEY `filme` (`filme`);

--
-- Índices de tabela `filme`
--
ALTER TABLE `filme`
  ADD PRIMARY KEY (`idFilme`),
  ADD KEY `genero` (`genero`);

--
-- Índices de tabela `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`idGenero`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `comentario`
--
ALTER TABLE `comentario`
  MODIFY `idComentario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `filme`
--
ALTER TABLE `filme`
  MODIFY `idFilme` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `genero`
--
ALTER TABLE `genero`
  MODIFY `idGenero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `comentario`
--
ALTER TABLE `comentario`
  ADD CONSTRAINT `comentario_ibfk_1` FOREIGN KEY (`filme`) REFERENCES `filme` (`idFilme`);

--
-- Restrições para tabelas `filme`
--
ALTER TABLE `filme`
  ADD CONSTRAINT `filme_ibfk_1` FOREIGN KEY (`genero`) REFERENCES `genero` (`idGenero`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
