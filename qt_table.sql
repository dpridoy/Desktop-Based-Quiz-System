-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 04, 2015 at 07:36 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `question`
--

-- --------------------------------------------------------

--
-- Table structure for table `qt_table`
--

CREATE TABLE IF NOT EXISTS `qt_table` (
  `Q-No` int(3) NOT NULL,
  `Question` varchar(255) NOT NULL,
  `1st Op` varchar(50) NOT NULL,
  `2nd Op` varchar(50) NOT NULL,
  `3rd Op` varchar(50) NOT NULL,
  `4th Op` varchar(50) NOT NULL,
  `Ans` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `qt_table`
--

INSERT INTO `qt_table` (`Q-No`, `Question`, `1st Op`, `2nd Op`, `3rd Op`, `4th Op`, `Ans`) VALUES
(1, 'Which of the tool is used to compile java code?', 'java', 'javac', 'jar', 'javadoc', 'javac'),
(2, 'Which of the following tool used to execute java code?', 'rmic', 'javac', 'java', 'javadoc', 'java'),
(3, 'Java source code compile into ______.', '.exe', 'source code', '.obj', 'bytecode', '.obj'),
(4, 'jar stands for ______', 'Java Application Runner', 'Java Archive', 'Java Archive Runner', 'None of these', 'Java Archive'),
(5, 'Which of the following is not a keyword in java.', 'abstract', 'assert', 'boolean', 'finalize', 'finalize'),
(6, 'Which is a valid keyword in java?', 'interface', 'string', 'Float', 'unsigned', 'interface'),
(7, 'Which class cannot be a subclass in java', 'abstract class', 'parent class', 'Final class', 'None of above', 'Final class'),
(8, 'Can we declare abstract static method', 'Yes', 'No', 'None', 'Both', 'No'),
(9, 'Which is the valid declarations within an interface definition?', 'public double methoda();', 'public final double methoda();', 'static void methoda(double d1);', 'protected void methoda(double d1);', 'public double methoda();'),
(10, '_____ is the ability of an Java application to perform multiple tasks at the same time?', 'Multiprogramming', 'Multithreading', 'Multiprocessing', 'Multitasking', 'Multithreading');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `qt_table`
--
ALTER TABLE `qt_table`
 ADD PRIMARY KEY (`Q-No`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
