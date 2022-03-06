-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 06, 2022 at 03:34 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jalan_catatan`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_catatan`
--

CREATE TABLE `tb_catatan` (
  `no_catatan` varchar(8) NOT NULL,
  `nik` int(8) NOT NULL,
  `tgl_catatan` date NOT NULL,
  `jam` time NOT NULL,
  `lokasi` text NOT NULL,
  `suhu_tubuh` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tb_pengguna`
--

CREATE TABLE `tb_pengguna` (
  `nik` int(8) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `alamat` varchar(25) NOT NULL,
  `jenkel` enum('Laki - Laki','Perempuan') NOT NULL,
  `tipe` enum('Admin','Pengguna') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pengguna`
--

INSERT INTO `tb_pengguna` (`nik`, `nama`, `alamat`, `jenkel`, `tipe`) VALUES
(912, 'aka', 'pas', 'Perempuan', 'Pengguna'),
(1122, 'fariz', 'pasuruan', 'Perempuan', 'Pengguna'),
(1234, 'riz', 'pas', 'Laki - Laki', 'Pengguna'),
(1432, 'izo', 'pas', 'Laki - Laki', 'Pengguna');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_catatan`
--
ALTER TABLE `tb_catatan`
  ADD PRIMARY KEY (`no_catatan`),
  ADD KEY `nik` (`nik`);

--
-- Indexes for table `tb_pengguna`
--
ALTER TABLE `tb_pengguna`
  ADD PRIMARY KEY (`nik`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
