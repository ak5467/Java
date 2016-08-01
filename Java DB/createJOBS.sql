DROP DATABASE IF EXISTS jobs;

create database jobs;
use jobs;

create table STATE (
statecode   char(2),
description varchar(30) NOT NULL,
constraint state_statecode_pk primary key (statecode));

create table QUARTER (
qtrcode     varchar(5),
location    char(2),
minsal      float(6,2) NOT NULL,
minhrs      int(2)   NOT NULL,
constraint quarter_qtrcode_pk primary key (qtrcode),
constraint quarter_location_fk foreign key (location) references STATE
(statecode));

create table EMPLOYER (
companyname     varchar(30) NOT NULL,
division        varchar(30) NOT NULL,
address         varchar(30),
city            varchar(20),
statecode       char(2) not null,
zipcode         int(5),
constraint employer_coname_div_pk PRIMARY KEY (companyname, division),
constraint employer_statecode_fk foreign key (statecode) references STATE(statecode));

create table INTERVIEW (
interviewID   int ,
interviewdate date,
companyname   varchar(30) NOT NULL,
division      varchar(30) NOT NULL,
qtrcode       varchar(5),
salaryoffered float(8,2),
minhrsoffered int(2),
listing       char,
jobdesc       varchar(255),
constraint interview_interviewID_pk primary key (interviewID),
constraint interview_employer_fk foreign key (companyname, division) references EMPLOYER(companyname, division),
constraint interview_qtrcode_fk foreign key (qtrcode) references QUARTER(qtrcode));

insert into STATE(description,statecode) values('ALABAMA','AL');
insert into STATE(description,statecode) values('ALASKA','AK');
insert into STATE(description,statecode) values('AMERICAN SAMOA','AS');
insert into STATE(description,statecode) values('ARIZONA','AZ');
insert into STATE(description,statecode) values('ARKANSAS','AR');
insert into STATE(description,statecode) values('CALIFORNIA','CA');
insert into STATE(description,statecode) values('COLORADO','CO');
insert into STATE(description,statecode) values('CONNECTICUT','CT');
insert into STATE(description,statecode) values('DELAWARE','DE');
insert into STATE(description,statecode) values('DISTRICT OF COLUMBIA','DC');
insert into STATE(description,statecode) values('FEDERATED STATES OF MICRONESIA','FM');
insert into STATE(description,statecode) values('FLORIDA','FL');
insert into STATE(description,statecode) values('GEORGIA','GA');
insert into STATE(description,statecode) values('GUAM','GU');
insert into STATE(description,statecode) values('HAWAII','HI');
insert into STATE(description,statecode) values('IDAHO','ID');
insert into STATE(description,statecode) values('ILLINOIS','IL');
insert into STATE(description,statecode) values('INDIANA','IN');
insert into STATE(description,statecode) values('IOWA','IA');
insert into STATE(description,statecode) values('KANSAS','KS');
insert into STATE(description,statecode) values('KENTUCKY','KY');
insert into STATE(description,statecode) values('LOUISIANA','LA');
insert into STATE(description,statecode) values('MAINE','ME');
insert into STATE(description,statecode) values('MARSHALL ISLANDS','MH');
insert into STATE(description,statecode) values('MARYLAND','MD');
insert into STATE(description,statecode) values('MASSACHUSETTS','MA');
insert into STATE(description,statecode) values('MICHIGAN','MI');
insert into STATE(description,statecode) values('MINNESOTA','MN');
insert into STATE(description,statecode) values('MISSISSIPPI','MS');
insert into STATE(description,statecode) values('MISSOURI','MO');
insert into STATE(description,statecode) values('MONTANA','MT');
insert into STATE(description,statecode) values('NEBRASKA','NE');
insert into STATE(description,statecode) values('NEVADA','NV');
insert into STATE(description,statecode) values('NEW HAMPSHIRE','NH');
insert into STATE(description,statecode) values('NEW JERSEY','NJ');
insert into STATE(description,statecode) values('NEW MEXICO','NM');
insert into STATE(description,statecode) values('NEW YORK','NY');
insert into STATE(description,statecode) values('NORTH CAROLINA','NC');
insert into STATE(description,statecode) values('NORTH DAKOTA','ND');
insert into STATE(description,statecode) values('NORTHERN MARIANA ISLANDS','MP');
insert into STATE(description,statecode) values('OHIO','OH');
insert into STATE(description,statecode) values('OKLAHOMA','OK');
insert into STATE(description,statecode) values('OREGON','OR');
insert into STATE(description,statecode) values('PALAU','PW');
insert into STATE(description,statecode) values('PENNSYLVANIA','PA');
insert into STATE(description,statecode) values('PUERTO RICO','PR');
insert into STATE(description,statecode) values('RHODE ISLAND','RI');
insert into STATE(description,statecode) values('SOUTH CAROLINA','SC');
insert into STATE(description,statecode) values('SOUTH DAKOTA','SD');
insert into STATE(description,statecode) values('TENNESSEE','TN');
insert into STATE(description,statecode) values('TEXAS','TX');
insert into STATE(description,statecode) values('UTAH','UT');
insert into STATE(description,statecode) values('VERMONT','VT');
insert into STATE(description,statecode) values('VIRGIN ISLANDS','VI');
insert into STATE(description,statecode) values('VIRGINIA','VA');
insert into STATE(description,statecode) values('WASHINGTON','WA');
insert into STATE(description,statecode) values('WEST VIRGINIA','WV');
insert into STATE(description,statecode) values('WISCONSIN','WI');
insert into STATE(description, statecode) values('WYOMING','WY');

insert into QUARTER values('19951', 'NY', 11.00,40);
insert into QUARTER values('19953', 'CA', 11.50,30);
insert into QUARTER values('19961', 'NY', 12.00,30);
insert into QUARTER values('19963', 'MA', 12.75,40);
insert into QUARTER values('19964', 'NY', 13.50,40);


insert into EMPLOYER values('Acme Information Source', 'Customer Support', '132 Commerical Way', 'Cleveland','OH',44234);
insert into EMPLOYER values('Ajax Software, Inc.', 'RandD', '2421 West Industrial Way', 'Berkeley','CA',94710);
insert into EMPLOYER values('Ajax Software, Inc.', 'Production', '2421 West Industrial Way', 'Berkeley','CA',94710);
insert into EMPLOYER values('Bay Software Inc.', 'Production', '4223 Halster Way', 'Berkeley','CA',94710);
insert into EMPLOYER values('Bay Software Inc.', 'RandD', '4223 Halster Way', 'Berkeley','CA',94710);
insert into EMPLOYER values('Braddock Information Assoc.', 'Payroll', '1 Washington Complex','Boston','MA',02101); 
insert into EMPLOYER values('Yankee Software', 'Development', '1 Braddock Circle','Kenmore','NY',14223);
insert into EMPLOYER values('Yankee Software', 'RandD', '1 Braddock Circle','Kenmore','NY',14223);
insert into EMPLOYER values('Yankee Software', 'Management', '1 Braddock Circle','Kenmore','NY',14223);
insert into EMPLOYER values('Buffalo Software Assoc.','Payroll','45511 Delaware Ave.','Buffalo','NY',14221);
insert into EMPLOYER values('Cameron Industries', 'Management', '3112 West Helm Street', 'Kingwood','TX',77339);
insert into EMPLOYER values('Cameron Industries', 'Customer Support', '3112 West Helm Street', 'Kingwood','TX',77339);
insert into EMPLOYER values('CCC Software', 'Production', '41 Golem Terrace', 'New York', 'NY',10012);
insert into EMPLOYER values('DC Security Applications','RandD','1602 Jackson Ave.','Arlington','VA',22202);
insert into EMPLOYER values('Davis-Klein Software', 'RandD', '8871 West Grange Drive', 'Cairo', 'NY',12413);
insert into EMPLOYER values('Jersey Computer Services','Customer Support','44 WhiteStallion Pike','Lindenwold','NJ',08021);
insert into EMPLOYER values('Flordia Software Designs', 'Development', '45A Sturgeon Dr., Bldg. 5', 'Ft. Pierce', 'FL',34951);
insert into EMPLOYER values('Flordia Software Designs', 'RandD', '45A Sturgeon Dr., Bldg. 5', 'Ft. Pierce', 'FL',34951);
insert into EMPLOYER values('Focused Applications, Inc.','Production','776 West Ninth St.','Myrtle Beach','SC', 29579);
insert into EMPLOYER values('Georgia Software Design','RandD','6665 Peachtree Lane','Atlanta','GA',30328);
insert into EMPLOYER values('ApplDesign','RandD','3 Mapleview Drive','Huntsville','AL',35803);
insert into EMPLOYER values('Long Island Apps, Inc.','Development','67 Merrifield Ave.','Oceanside','NY',11572);
insert into EMPLOYER values('Manhattan-Made Software','Customer Support','35 West 9th St.','New York','NY',10012);
insert into EMPLOYER values('Manhattan-Made Software','Payroll','35 West 9th St.','New York','NY',10012);
insert into EMPLOYER values('Michigan Application Design','Development','5531 E. Lansing Ave.','Ypsilanti','MI',48197);
insert into EMPLOYER values('Midtown Software Development','Customer Support','7554 West 9th St.','New York','NY',10003);
insert into EMPLOYER values('Mountainside Magic Software','Customer Support','4 Rocky Way','Colorado Springs','CO',80941);
insert into EMPLOYER values('Mountainside Magic Software','Management','4 Rocky Way','Colorado Springs','CO',80941);
insert into EMPLOYER values('Nantucket Applications, Inc.','RandD','45521 Pilgrim Circle','Nantucket','MA',02554);
insert into EMPLOYER values('PennState Programming, Inc.','Management','3 Carnegie Circle','Pittsburgh','PA',15108);
insert into EMPLOYER values('PSWD, Inc.','Management','15 Carnegie Circle','Pittsburgh','PA',15108);
insert into EMPLOYER values('Rochester Software Design','Development','16 Broad Street','Rochester','NY',14621);
insert into EMPLOYER values('Rochester Application Software','Production','16 Broad Street','Rochester','NY',14621);
insert into EMPLOYER values('Sandy Hook Software','Development','5665 MassPike Circle','Sandy Hook','CT',06482);
insert into EMPLOYER values('Vegas Programming and Design','Development','3 Desert Trail','Las Vegas','NV',89117);
insert into EMPLOYER values('Virginia Software Industries','Production','3 Confederate Ave.','Roanoke','VA',24010);
insert into EMPLOYER values('Western New York Applications','RandD','44 Rockman Blvd.','Rochester','NY',14623);

insert into INTERVIEW values(01,'1995-06-01','Acme Information Source', 'Customer Support', '19951',12,40,'y','Job Desc');
insert into INTERVIEW values(02,'1995-06-01','Braddock Information Assoc.', 'Payroll', '19951',10.75,40,'n','Job Desc');
insert into INTERVIEW values(03,'1995-06-30','Ajax Software, Inc.', 'Production', '19951',11,40,'y','Job Desc');
insert into INTERVIEW values(04,'1995-06-30','Ajax Software, Inc.', 'RandD', '19951',11.5,40,'y','Job Desc');
insert into INTERVIEW values(05,'1995-07-01','Bay Software Inc.', 'Production', '19951',11.75,20,'y','Job Desc');
insert into INTERVIEW values(06,'1995-08-01','Vegas Programming and Design', 'Development', '19951',11,40,'n','Job Desc');
insert into INTERVIEW values(07,'1995-08-01','Mountainside Magic Software', 'Management', '19951',11.5,20,'y','Job Desc');
insert into INTERVIEW values(08,'1995-08-02','Mountainside Magic Software', 'Customer Support', '19951',10.75,40,'y','Job Desc');
insert into INTERVIEW values(09,'1995-12-01','Cameron Industries', 'Management', '19953',13.25,35,'n','Job Desc');
insert into INTERVIEW values(10,'1995-12-02','Cameron Industries', 'Customer Support', '19953',13,35,'n','Job Desc');
insert into INTERVIEW values(11,'1995-12-04','CCC Software', 'Production', '19953',11.5,40,'n','Job Desc');
insert into INTERVIEW values(12,'1996-01-21','DC Security Applications', 'RandD', '19953',11.5,30,'n','Job Desc');
insert into INTERVIEW values(13,'1996-02-01','Davis-Klein Software', 'RandD', '19953',11.25,20,'n','Job Desc');
insert into INTERVIEW values(14,'1996-02-02','Flordia Software Designs', 'RandD', '19953',11.75,30,'n','Job Desc');
insert into INTERVIEW values(15,'1996-07-01','Rochester Software Design', 'Development', '19961',12,30,'n','Job Desc');
insert into INTERVIEW values(16,'1996-07-01','Focused Applications, Inc.', 'Production', '19961',12,30,'y','Job Desc');
insert into INTERVIEW values(17,'1996-08-01','Georgia Software Design', 'RandD', '19961',11.75,40,'y','Job Desc');
insert into INTERVIEW values(18,'1996-08-08','ApplDesign', 'RandD', '19961',11.5,30,'y','Job Desc');
insert into INTERVIEW values(19,'1996-08-11','Long Island Apps, Inc.', 'Development', '19961',12.25,40,'y','Job Desc');
insert into INTERVIEW values(20,'1997-01-01','Jersey Computer Services', 'Customer Support', '19963',12.5,35,'n','Job Desc');
insert into INTERVIEW values(21,'1997-01-01','Flordia Software Designs', 'Development', '19963',12.75,30,'n','Job Desc');
insert into INTERVIEW values(22,'1997-01-31','Manhattan-Made Software', 'Customer Support', '19963',12.5,40,'y','Job Desc');
insert into INTERVIEW values(23,'1997-02-01','Manhattan-Made Software', 'Payroll', '19963',13.25,40,'y','Job Desc');
insert into INTERVIEW values(24,'1997-03-24','Nantucket Applications, Inc.', 'RandD', '19964',13,40,'y','Job Desc');
insert into INTERVIEW values(25,'1997-03-31','PennState Programming, Inc.', 'Management', '19964',13,40,'y','Job Desc');
insert into INTERVIEW values(26,'1997-04-20','Sandy Hook Software', 'Development', '19964',12.75,35,'n','Job Desc');
insert into INTERVIEW values(27,'1997-04-22','Buffalo Software Assoc.', 'Payroll', '19964',12.75,35,'y','Job Desc');
insert into INTERVIEW values(28,'1997-05-01','Virginia Software Industries', 'Production', '19964',13.75,40,'n','Job Desc');
