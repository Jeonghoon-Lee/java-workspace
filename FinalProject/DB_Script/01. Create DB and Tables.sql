/**
 * IPD-16 420-P24-AB Java III  - FINAL PROJECT
 *
 * Create LibraryJH database and tables
 *	Script Date: July 16, 2019
 *  Developed by: Jeonghoon Lee
 */

-- Create database
create database LibraryJH
;
 
-- Switch to the LibraryNORJ database
use LibraryJH
;

-- 1. Accounts Table
drop table if exists Accounts
;

create table Accounts (
	AccountId int not null auto_increment,
    Password char(32) not null,
    AccountTypeId int not null,		-- foreign key (AccountTypeId in AccountTypes table)
    AccountStatusId int not null,	-- foreign key (AccountStatusId in AccountStatus table)
    UserId int  null,				-- foreign key (UserId in Users table)
    
    constraint pk_Accounts primary key clustered (AccountId asc)
)
;

-- 2. AccountTypes Table
drop table if exists AccountTypes
;

create table AccountTypes (
	AccountTypeId int not null auto_increment,
    AccountTypeDescrip varchar(32) not null,
    
    constraint pk_AccountTypes primary key clustered (AccountTypeId asc)
)
;

-- 3. AccountStatus Table
drop table if exists AccountStatus
;

create table AccountStatus (
	AccountStatusId int not null auto_increment,
    AccountStatusDescrip varchar(32) not null,
    
    constraint pk_AccountStatus primary key clustered (AccountStatusId asc)
)
;

-- 4. Users table
drop table if exists Users
;

create table Users (
    UserId int not null auto_increment,
    UserFirstName varchar(20) not null,
    UserLastName varchar(20) not null,
    UserEmail varchar(40) null,
    UserRegisteredDate date not null,
    UserLastLoginTime datetime null,
    
    constraint pk_Users primary key clustered (UserId asc)
)
;

-- 5. Books table
drop table if exists Books
;

create table Books
(
	ISBN varchar(20) not null,
	Title varchar(80) not null,
    Subject varchar(255) not null,
    Publisher varchar(30) not null,
    AuthorId int not null,			-- foreign key (AuthorId in Authors Table)
    LanguageId int not null, 		-- foreign key (LanguageId in Languages Table)

	constraint pk_Books primary key clustered (ISBN asc)
)
;

-- 6. Authors table
drop table if exists Authors
;

create table Authors
(
	AuthorId int not null auto_increment,
	AuthorFirstName varchar(30) not null,
    AuthorLastName varchar(20) not null,

	constraint pk_Authors primary key clustered (AuthorId asc)
)
;

-- 7. Languages table
drop table if exists Languages
;

create table Languages
(
	LanguageId int not null auto_increment,
	LanguageDescrip varchar(30) not null,

	constraint pk_Languages primary key clustered (LanguageId asc)
)
;

-- 8. BookItems
drop table if exists BookItems
;

create table BookItems
(
	ISBN varchar(20) not null,		-- foreign key (ISBN in Books table)
	CopyNo int not null,
    BookStatusId int not null,		-- foreign key (BookStatusId in BookStatus table)
    
    constraint pk_BookItems primary key clustered (CopyNo asc, ISBN asc)
)
;

-- 9. BookStatus table
drop table if exists BookStatus
;

create table BookStatus
(
	BookStatusId int not null auto_increment,
	BookStatusDescrip varchar(30) not null,

	constraint pk_BookStatus primary key clustered (BookStatusId asc)
)
;

-- 10. BookLending table
drop table if exists BookLendings
;

create table BookLendings
(
	BookLendingId int not null auto_increment,
	ISBN varchar(20) not null,	-- foreign key (ISBN in BookItems)
    CopyNo int not null,		-- foreign key (CopyNo in BookItems)
	UserId int not null,		-- foreign key (UserId in Users)
	BorrowedDate datetime not null,
	DueDate date not null,
	ReturnDate datetime null,
	FineAssessed decimal (5,2) null,
	FinePaid decimal (5,2) null,
	FineWaived decimal (5,2) null,

	constraint pk_Loans primary key clustered (BookLendingId asc)   
)
;

-- 11. Reservations table
drop table if exists BookReservations
;

create table BookReservations
(
	BookReservId int not null auto_increment, 
	ISBN varchar(20) not null,		-- foreign Key (ISBN in BookItems table)
    CopyNo int not null,			-- foreign key (CopyNo int BookItems table)
	UserID int not null,			-- foreign key (UserID in Users table)
	BookReservDate datetime not null,
	ProcessedDate datetime null,
	BookReservStatusId int not null,	-- foreign key (BookReservStatusId in BookReservationStatus table)

	constraint pk_BookReservations primary key clustered (BookReservIaccountsd asc)   
)
;

-- 12. BookStatus table
drop table if exists BookReservationStatus
;

create table BookReservationStatus
(
	BookReservStatusId int not null auto_increment,
	BookReservStatusDescrip varchar(20) not null,

	constraint pk_BookReservStatus primary key clustered (BookReservStatusId asc)
)
;


