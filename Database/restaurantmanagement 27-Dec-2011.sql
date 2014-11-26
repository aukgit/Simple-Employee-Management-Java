/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50141
Source Host           : localhost:3306
Source Database       : restaurantmanagement

Target Server Type    : MYSQL
Target Server Version : 50141
File Encoding         : 65001

Date: 2011-12-27 03:56:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin` varchar(20) NOT NULL,
  `admin_name` varchar(80) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `password_hint` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`admin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('auk', 'Alim Ul Karim', '', 'guess');

-- ----------------------------
-- Table structure for `attendance`
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance` (
  `attendance_id` bigint(255) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `working_hours` double DEFAULT NULL,
  `working_date` date DEFAULT NULL,
  `should_start` timestamp NULL DEFAULT NULL,
  `should_end` timestamp NULL DEFAULT NULL,
  `login_time` timestamp NULL DEFAULT NULL,
  `logout_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`attendance_id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES ('1', '4', null, '2011-12-13', '2011-12-27 02:42:53', '2011-12-27 05:42:57', '2011-12-27 02:43:06', '2011-12-27 04:43:14');
INSERT INTO `attendance` VALUES ('2', '2', null, null, null, null, null, null);
INSERT INTO `attendance` VALUES ('3', '5', null, null, null, null, null, null);
INSERT INTO `attendance` VALUES ('4', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `buffet_items`
-- ----------------------------
DROP TABLE IF EXISTS `buffet_items`;
CREATE TABLE `buffet_items` (
  `buffet_items_id` int(11) NOT NULL AUTO_INCREMENT,
  `food_id` bigint(255) DEFAULT NULL,
  `item_name` varchar(250) DEFAULT NULL,
  `image_exist` bit(1) DEFAULT NULL,
  PRIMARY KEY (`buffet_items_id`),
  KEY `food_id` (`food_id`),
  CONSTRAINT `FK_buffet_items_food_id` FOREIGN KEY (`food_id`) REFERENCES `food` (`food_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of buffet_items
-- ----------------------------
INSERT INTO `buffet_items` VALUES ('1', '46', 'Desert1', null);
INSERT INTO `buffet_items` VALUES ('2', '1', 'Desert2', null);
INSERT INTO `buffet_items` VALUES ('3', '1', 'Desert3', null);
INSERT INTO `buffet_items` VALUES ('4', '3', 'WDWF#qdwwqddqwdqq', '');
INSERT INTO `buffet_items` VALUES ('5', '5', 'dwqweffwe', '');
INSERT INTO `buffet_items` VALUES ('6', '5', 'qdwqdqwd', '');
INSERT INTO `buffet_items` VALUES ('7', '2', 'Deser5', '');
INSERT INTO `buffet_items` VALUES ('8', '1', 'wefwfewfe', '');
INSERT INTO `buffet_items` VALUES ('9', '44', 'dwq', null);
INSERT INTO `buffet_items` VALUES ('10', '1', 'qwdf', null);
INSERT INTO `buffet_items` VALUES ('11', null, 'efwewf', '');
INSERT INTO `buffet_items` VALUES ('12', '45', 'des4', null);
INSERT INTO `buffet_items` VALUES ('13', '2', null, null);
INSERT INTO `buffet_items` VALUES ('14', '6', 'wfe11111', null);
INSERT INTO `buffet_items` VALUES ('15', '6', 'wfewefwfe6', null);
INSERT INTO `buffet_items` VALUES ('16', '6', 'qw22222', null);
INSERT INTO `buffet_items` VALUES ('17', '3', 'Des2', null);
INSERT INTO `buffet_items` VALUES ('18', '31', 'dwfqwqdwqd', null);
INSERT INTO `buffet_items` VALUES ('19', '1', 'qwdfewfewf', null);

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(120) DEFAULT NULL,
  `employee_category_id` int(11) DEFAULT NULL,
  `start_working_date` date DEFAULT NULL,
  `resign_date` date DEFAULT NULL,
  `on_duty` bit(1) DEFAULT NULL,
  `exceptional_working_hour` double DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `employee_category_id` (`employee_category_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`employee_category_id`) REFERENCES `employee_category` (`employee_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'Earl', '1', null, null, '', '123');
INSERT INTO `employee` VALUES ('2', 'Batman', '2', '2008-12-23', null, null, null);
INSERT INTO `employee` VALUES ('3', 'Earl2', '6', null, null, null, null);
INSERT INTO `employee` VALUES ('4', 'Batman', '2', '2008-12-23', null, null, null);
INSERT INTO `employee` VALUES ('5', 'Earl', '1', null, null, '', '123');

-- ----------------------------
-- Table structure for `employee_category`
-- ----------------------------
DROP TABLE IF EXISTS `employee_category`;
CREATE TABLE `employee_category` (
  `employee_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_category_name` varchar(200) DEFAULT NULL,
  `salary` decimal(10,0) DEFAULT NULL,
  `working_hours` double DEFAULT NULL,
  `weekend` int(11) DEFAULT NULL,
  PRIMARY KEY (`employee_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of employee_category
-- ----------------------------
INSERT INTO `employee_category` VALUES ('1', 'Grade A', '20000', '8', '2');
INSERT INTO `employee_category` VALUES ('2', 'Grade B', '15000', '7', '2');
INSERT INTO `employee_category` VALUES ('3', 'Grade C', '12000', '6', '2');
INSERT INTO `employee_category` VALUES ('4', 'Chef', '22000', '10', '2');
INSERT INTO `employee_category` VALUES ('5', 'Sue Chef', '25000', '12', '1');
INSERT INTO `employee_category` VALUES ('6', 'Sue Chef', '25000', '12', '1');

-- ----------------------------
-- Table structure for `food`
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `food_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `food_category_id` int(11) DEFAULT NULL,
  `food_name` varchar(200) DEFAULT NULL,
  `food_short_name` varchar(10) DEFAULT NULL,
  `making_cost` decimal(10,0) NOT NULL,
  `selling_cost` decimal(10,0) NOT NULL,
  PRIMARY KEY (`food_id`),
  KEY `food_category_id` (`food_category_id`),
  KEY `food_id` (`food_id`) USING BTREE,
  CONSTRAINT `FK_food_food_category_id` FOREIGN KEY (`food_category_id`) REFERENCES `food_category` (`food_category_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES ('1', '2', 'Buffet Breakfast', 'Buffet Bre', '200', '300');
INSERT INTO `food` VALUES ('2', '2', 'Buffet Lunch', 'Buffet Lun', '250', '400');
INSERT INTO `food` VALUES ('3', '2', 'Buffet Dinner', 'Buffet Din', '280', '450');
INSERT INTO `food` VALUES ('4', '2', 'hello', 'short', '242', '0');
INSERT INTO `food` VALUES ('5', '2', 'hello', 'short', '242', '23');
INSERT INTO `food` VALUES ('6', '2', 'hello', 'short', '242', '23');
INSERT INTO `food` VALUES ('7', '2', 'hello', 'short', '242', '23');
INSERT INTO `food` VALUES ('8', '2', 'hello', 'short', '242', '23');
INSERT INTO `food` VALUES ('9', '2', 'hello', 'short', '242', '23');
INSERT INTO `food` VALUES ('10', '2', 'hello', 'short', '242', '23');
INSERT INTO `food` VALUES ('11', '2', 'hello', 'short', '242', '23');
INSERT INTO `food` VALUES ('12', '2', 'hello', 'short', '242', '23');
INSERT INTO `food` VALUES ('13', '2', 'hello', 'short', '242', '23');
INSERT INTO `food` VALUES ('14', '2', 'hello', 'short', '242', '23');
INSERT INTO `food` VALUES ('15', null, 'lkjlasd', 'fwe', '321', '23');
INSERT INTO `food` VALUES ('16', null, 'new food 2', 'ads', '32', '23');
INSERT INTO `food` VALUES ('17', null, 'qwfe', 'dqw', '3', '23');
INSERT INTO `food` VALUES ('19', null, 'asdqdw', 'wefwef', '213', '34');
INSERT INTO `food` VALUES ('20', null, 'dqqw', 'fewwfe', '213', '324');
INSERT INTO `food` VALUES ('21', null, 'qwdqwd', 'fewwef', '213', '213');
INSERT INTO `food` VALUES ('22', '2', 'wefwef', 'qwdqwd', '23', '321');
INSERT INTO `food` VALUES ('23', null, 'fwewefwf', '32r', '23', '0');
INSERT INTO `food` VALUES ('24', '1', 'Hello', null, '23', '2');
INSERT INTO `food` VALUES ('27', '2', 'qwd', 'dwq', '0', '0');
INSERT INTO `food` VALUES ('28', '2', 'take new again', null, '0', '0');
INSERT INTO `food` VALUES ('29', '1', 'Hello2', null, '0', '0');
INSERT INTO `food` VALUES ('30', '1', 'hello3', 'hellokowd', '0', '0');
INSERT INTO `food` VALUES ('31', '2', 'Buffet Dinner', 'Buffet Din', '280', '450');
INSERT INTO `food` VALUES ('44', '2', 'wefwef', 'qwdqwd', '23', '321');
INSERT INTO `food` VALUES ('45', '2', 'hello', 'short', '242', '23');
INSERT INTO `food` VALUES ('46', '2', 'hello', 'short', '242', '23');

-- ----------------------------
-- Table structure for `food_category`
-- ----------------------------
DROP TABLE IF EXISTS `food_category`;
CREATE TABLE `food_category` (
  `food_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `food_category_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`food_category_id`),
  KEY `food_category_id` (`food_category_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of food_category
-- ----------------------------
INSERT INTO `food_category` VALUES ('1', 'Simple');
INSERT INTO `food_category` VALUES ('2', 'Buffet');

-- ----------------------------
-- Table structure for `invoice`
-- ----------------------------
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice` (
  `invoice_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `invoice_name` varchar(80) DEFAULT NULL,
  `invoice_table` int(11) DEFAULT NULL,
  `dated` datetime NOT NULL,
  `items_buy` int(11) DEFAULT NULL,
  `payment_amount` decimal(10,0) DEFAULT NULL,
  `due_amount` decimal(10,0) DEFAULT NULL,
  `disount_amount` decimal(10,0) DEFAULT NULL,
  `discount` varchar(20) DEFAULT NULL COMMENT 'like 15% or 250 BDT',
  `paid_amount` decimal(10,0) NOT NULL,
  `comments` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`invoice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of invoice
-- ----------------------------

-- ----------------------------
-- Table structure for `invoice_items`
-- ----------------------------
DROP TABLE IF EXISTS `invoice_items`;
CREATE TABLE `invoice_items` (
  `invoice_items_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `invoice_id` bigint(20) NOT NULL,
  `food_name` varchar(200) DEFAULT NULL,
  `food_category_id` int(11) DEFAULT NULL,
  `selling_price` decimal(10,0) DEFAULT NULL,
  `making_price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`invoice_items_id`),
  KEY `invoice_id` (`invoice_id`),
  CONSTRAINT `invoice_items_ibfk_1` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`invoice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of invoice_items
-- ----------------------------

-- ----------------------------
-- Table structure for `payroll`
-- ----------------------------
DROP TABLE IF EXISTS `payroll`;
CREATE TABLE `payroll` (
  `payroll_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `payment_amount` decimal(10,0) DEFAULT NULL,
  `paid_amount` decimal(10,0) DEFAULT NULL,
  `reduce_amount` decimal(10,0) DEFAULT NULL,
  `bonus_amount` decimal(10,0) DEFAULT NULL,
  `payment_date` date DEFAULT NULL,
  `date_for_paying_month` date DEFAULT NULL,
  `total_absense` int(11) DEFAULT NULL,
  `total_lates` int(11) DEFAULT NULL,
  `is_advance` bit(1) DEFAULT NULL,
  `comments` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`payroll_id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `payroll_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of payroll
-- ----------------------------
INSERT INTO `payroll` VALUES ('1', null, null, null, null, null, '2008-12-01', null, null, null, null, null);

-- ----------------------------
-- Table structure for `restaurant_table`
-- ----------------------------
DROP TABLE IF EXISTS `restaurant_table`;
CREATE TABLE `restaurant_table` (
  `restaurant_table_id` int(11) NOT NULL,
  `is_reserved` bit(1) DEFAULT NULL,
  PRIMARY KEY (`restaurant_table_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of restaurant_table
-- ----------------------------

-- ----------------------------
-- Table structure for `stock_food`
-- ----------------------------
DROP TABLE IF EXISTS `stock_food`;
CREATE TABLE `stock_food` (
  `stock_food_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `food_id` bigint(20) DEFAULT NULL,
  `food_name` varchar(200) DEFAULT NULL,
  `stock_amount` int(11) DEFAULT NULL,
  `per_selling_cost` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`stock_food_id`),
  KEY `food_id` (`food_id`),
  CONSTRAINT `stock_food_ibfk_1` FOREIGN KEY (`food_id`) REFERENCES `food` (`food_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of stock_food
-- ----------------------------

-- ----------------------------
-- View structure for `payroll_view`
-- ----------------------------
DROP VIEW IF EXISTS `payroll_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `payroll_view` AS select `employee`.`employee_id` AS `employee_id`,`employee_category`.`employee_category_name` AS `employee_category_name`,`employee`.`employee_name` AS `employee_name`,`employee_category`.`salary` AS `salary`,`employee_category`.`working_hours` AS `working_hours`,`employee_category`.`weekend` AS `weekend`,`employee`.`employee_category_id` AS `employee_category_id`,`employee`.`start_working_date` AS `start_working_date`,`employee`.`exceptional_working_hour` AS `exceptional_working_hour`,`attendance`.`working_date` AS `working_date`,`attendance`.`should_start` AS `should_start`,`attendance`.`should_end` AS `should_end`,`attendance`.`login_time` AS `login_time`,`attendance`.`logout_time` AS `logout_time`,year(`attendance`.`working_date`) AS `Year_`,month(`attendance`.`working_date`) AS `Month_`,timestampdiff(MINUTE,`attendance`.`login_time`,`attendance`.`logout_time`) AS `Worked_Duration_In_Minutes`,timestampdiff(MINUTE,`attendance`.`should_start`,`attendance`.`should_end`) AS `Should_Worked_Duration_In_Minutes` from ((`employee_category` join `employee` on((`employee_category`.`employee_category_id` = `employee`.`employee_category_id`))) join `attendance` on((`employee`.`employee_id` = `attendance`.`employee_id`))) ;

-- ----------------------------
-- View structure for `payroll_view2`
-- ----------------------------
DROP VIEW IF EXISTS `payroll_view2`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `payroll_view2` AS select `payroll_view`.`employee_id` AS `employee_id`,`payroll_view`.`employee_category_name` AS `employee_category_name`,`payroll_view`.`employee_name` AS `employee_name`,`payroll_view`.`salary` AS `salary`,`payroll_view`.`working_hours` AS `working_hours`,`payroll_view`.`weekend` AS `weekend`,`payroll_view`.`employee_category_id` AS `employee_category_id`,`payroll_view`.`start_working_date` AS `start_working_date`,`payroll_view`.`exceptional_working_hour` AS `exceptional_working_hour`,`payroll_view`.`working_date` AS `working_date`,`payroll_view`.`should_start` AS `should_start`,`payroll_view`.`should_end` AS `should_end`,`payroll_view`.`login_time` AS `login_time`,`payroll_view`.`logout_time` AS `logout_time`,`payroll_view`.`Year_` AS `Year_`,`payroll_view`.`Month_` AS `Month_`,`payroll_view`.`Worked_Duration_In_Minutes` AS `Worked_Duration_In_Minutes`,`payroll_view`.`Should_Worked_Duration_In_Minutes` AS `Should_Worked_Duration_In_Minutes`,(`payroll_view`.`Should_Worked_Duration_In_Minutes` - `payroll_view`.`Worked_Duration_In_Minutes`) AS `Difference` from `payroll_view` ;
