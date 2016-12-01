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
