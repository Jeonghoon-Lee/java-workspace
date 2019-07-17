/**
 * IPD-16 420-P24-AB Java III  - FINAL PROJECT
 *
 * Populate tables
 *	Script Date: July 16, 2019
 *  Developed by: Jeonghoon Lee
 */

-- Switch to the LibraryNORJ database
use LibraryJH
;


-- 1. Insert data into AccountTypes table
insert into AccountTypes (AccountTypeDescrip)
	values ('Admin'),
		('Librarian'),
		('Member')
;

-- 2. Insert data into AccountStatus table
insert into AccountStatus (AccountStatusDescrip)
	values ('Active'),
		('Closed'),
		('Canceled'),
        ('Blacklisted'),
        ('None')
;

-- 3. Insert data into Languages table
insert into Languages (LanguageDescrip)
	values ('English'),
		('French'),
		('Arabic'),
		('Chinese'),
		('Korean'),
		('Russian'),
		('Spanish')
;

-- 4. Insert data into BookStatus table
insert into BookStatus (BookStatusDescrip)
	values ('Available'),
		('Reserved'),
		('Loaned'),
        ('Lost')
;

-- 5. Insert data into BookReservationStatus table
insert into BookReservationStatus (BookReservStatusDescrip)
	values ('Waiting'),
		('Pending'),
		('Completed'),
        ('Canceled'),
        ('None')
;
