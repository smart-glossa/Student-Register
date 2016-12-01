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

CREATE TABLE `studentclass` (
  `classId` int(11) NOT NULL default '0',
  `sId` int(11) default NULL,
  `className` varchar(50) default NULL,
  `Duration` varchar(50) default NULL,
  PRIMARY KEY  (`classId`),
  KEY `sId` (`sId`),
  CONSTRAINT `studentclass_ibfk_1` FOREIGN KEY (`sId`) REFERENCES `studentdetails` (`sId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

table-3

CREATE TABLE `attendence` (
  `aId` int(11) NOT NULL,
  `classId` int(11) default NULL,
  `date` varchar(50) default NULL,
  `attendence` varchar(50) default NULL,
  PRIMARY KEY  (`aId`),
  KEY `classId` (`classId`),
  CONSTRAINT `attendence_ibfk_1` FOREIGN KEY (`classId`) REFERENCES `studentclass` (`classId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
