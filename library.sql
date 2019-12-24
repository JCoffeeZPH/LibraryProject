/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.7.23 : Database - book
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`book` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `book`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `book_num` int(3) NOT NULL,
  `book_name` varchar(20) NOT NULL,
  `book_writer` varchar(20) NOT NULL,
  `book_price` int(4) NOT NULL,
  `publish_time` varchar(20) NOT NULL,
  `publish_house` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`book_num`,`book_name`,`book_writer`,`book_price`,`publish_time`,`publish_house`) values (14,'Java核心技术卷I','霍斯特曼',100,'2018-6-6','机械工业出版社'),(10,'Java编程思想','Bruce',110,'2018-5-4','机械工业出版社'),(15,'深入理解java虚拟机','周志明',50,'2018-10-24','机械工业出版社'),(12,'重构改变代码的既有设计','Martin',55,'2018-10-15','人民邮电出版社'),(14,'java高并发编程详解','汪文君',75,'2018-9-6','机械工业出版社'),(16,'java网络编程','Elliotte',55,'2018-11-20','中国电力出版社'),(13,'Head First 设计模式','FreeMan',75,'2018-11-27','中国电力出版社'),(5,'数据结构与算法java语言描述','马克',65,'2018-4-15','机械工业出版社'),(27,'Head First AJAX','Riordan',55,'2018-12-1','中国电力出版社'),(0,'数据结构C语言版','严慧敏',45,'2018-9-28','清华大学出版社');

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `name` varchar(15) NOT NULL,
  `book_name` varchar(45) NOT NULL,
  `date` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `message` */

insert  into `message`(`name`,`book_name`,`date`) values ('阿斯蒂芬','Head First AJAX ','2018-12-11 19:57:27');

/*Table structure for table `reader` */

DROP TABLE IF EXISTS `reader`;

CREATE TABLE `reader` (
  `name` varchar(15) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `id` varchar(15) DEFAULT NULL,
  `sex` varchar(8) DEFAULT NULL,
  `telephone` int(15) DEFAULT NULL,
  `email` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `reader` */

insert  into `reader`(`name`,`password`,`id`,`sex`,`telephone`,`email`) values ('ForMe','ForMe=520','1','male',2147483647,'forme@qq.com'),('李白','123456','2','male',111111,'123466@qq.com'),('杜甫','456789','3','male',111121,'33036366@qq.com'),('admin','112322','4','female',115632,'1262466@qq.com'),('阿斯蒂芬','000000','5','male',1212121,'1023466@qq.com'),('白居易','5355','6','male',111121,'7853466@qq.com'),('杨万里','3265','7','male',1163121,'961466@qq.com'),('李清照','6297ddd','8','female',1961632,'79633466@qq.com'),('路远','123456','12','male',1236555555,'45623@qq.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
