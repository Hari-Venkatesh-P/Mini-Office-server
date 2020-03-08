-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 08, 2019 at 04:36 AM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `swingdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admincredentials`
--

DROP TABLE IF EXISTS `admincredentials`;
CREATE TABLE IF NOT EXISTS `admincredentials` (
  `adminid` varchar(10) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admincredentials`
--

INSERT INTO `admincredentials` (`adminid`, `password`) VALUES
('admin1', 'admin1');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `rno` varchar(15) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `dept` varchar(15) DEFAULT NULL,
  `cgpa` int(11) DEFAULT NULL,
  PRIMARY KEY (`rno`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`rno`, `name`, `year`, `dept`, `cgpa`) VALUES
('13005', 'Hari Venkatesh P', 3, 'CSE', 8),
('13006', 'Suresh S', 2, 'EEE', 9);

-- --------------------------------------------------------

--
-- Table structure for table `studentcredentials`
--

DROP TABLE IF EXISTS `studentcredentials`;
CREATE TABLE IF NOT EXISTS `studentcredentials` (
  `userid` varchar(15) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studentcredentials`
--

INSERT INTO `studentcredentials` (`userid`, `password`) VALUES
('13005', '13005'),
('13006', '13006');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
