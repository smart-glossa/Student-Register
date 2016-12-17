# Student-Register
database name:student
CREATE TABLE `studentdetails` (
  `sId` int(11) NOT NULL,
  `studentName` varchar(50) default NULL,
  `Address` varchar(100) default NULL,
  `contactNumber` varchar(50) default NULL,
  `Gender` varchar(20) default NULL,
  `DOB` varchar(50) default NULL,
  `joinDate` varchar(50) default NULL,
  PRIMARY KEY  (`sId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

table-2
CREATE TABLE `course` (
  `courseId` int(11) NOT NULL,
  `name` varchar(50) default NULL,
  `duration` varchar(50) default NULL,
  PRIMARY KEY  (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

table-3

CREATE TABLE `studentcourse` (
  `sId` int(11) default NULL,
  `courseId` int(11) default NULL,
  KEY `sId` (`sId`),
  KEY `courseId` (`courseId`),
  CONSTRAINT `studentcourse_ibfk_1` FOREIGN KEY (`sId`) REFERENCES `studentdetails` (`sId`),
  CONSTRAINT `studentcourse_ibfk_2` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1


table-4 ;
CREATE TABLE `attendance` (
  `sId` int(11) default NULL,
  `courseId` int(11) default NULL,
  `date` varchar(50) default NULL,
  `presents` tinyint(1) default NULL,
  KEY `sId` (`sId`),
  KEY `courseId` (`courseId`),
  CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`sId`) REFERENCES `studentdetails` (`sId`),
  CONSTRAINT `attendance_ibfk_2` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
