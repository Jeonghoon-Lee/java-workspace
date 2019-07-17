/**
 * IPD-16 420-P24-AB Java III  - FINAL PROJECT
 *
 * apply data integrity
 *	Script Date: July 16, 2019
 *  Developed by: Jeonghoon Lee
 */

-- Switch to the LibraryNORJ database
use LibraryJH
;


/**
 * Add foreign key constraint
 */
 
-- For Accounts table
-- Between Accounts and AccountTypes table
alter table Accounts
	add constraint fk_Accounts_AccountTypes foreign key (AccountTypeId)
		references AccountTypes (AccountTypeId)
;

-- Between Accounts and AccountStatus table
alter table Accounts
	add constraint fk_Accounts_AccountStatus foreign key (AccountStatusId)
		references AccountStatus (AccountStatusId)
;

-- Between Accounts and Users table
alter table Accounts
	add constraint fk_Accounts_Users foreign key (UserId)
		references Users (UserId)
;

-- For Books table
-- Between Books and Authors table
alter table Books
	add constraint fk_Books_Authors foreign key (AuthorId)
		references Authors (AuthorId)
;

-- Between Books and Languages table
alter table Books
	add constraint fk_Books_Languages foreign key (LanguageId)
		references Languages (LanguageId)
;

-- For BookItems table
-- Between BookItems and Books table
alter table BookItems
	add constraint fk_BookItems_Books foreign key (ISBN)
		references Books (ISBN)
;

-- Between BookItems and BookStatus table
alter table BookItems
	add constraint fk_BookItems_BookStatus foreign key (BookStatusId)
		references BookStatus (BookStatusId)
;

-- For BookLendings table
-- Between BookLendings and BookItems table
alter table BookLendings
	add constraint fk_BookLendings_BookItems foreign key (ISBN, CopyNo)
		references BookItems (ISBN, CopyNo)
;

-- Between BookLendings and Users table
alter table BookLendings
	add constraint fk_BookLendings_Users foreign key (UserId)
		references Users (UserId)
;

-- For BookReservations table
-- Between BookReservations and BookItems table
alter table BookReservations
	add constraint fk_BookReservations_BookItems foreign key (ISBN, CopyNo)
		references BookItems (ISBN, CopyNo)
;

-- Between BookReservations and Users table
alter table BookReservations
	add constraint fk_BookReservations_Users foreign key (UserId)
		references Users (UserId)
;

-- Between BookReservations and BookReservationStatus table
alter table BookReservations
	add constraint fk_BookReservations_ReservStatus foreign key (BookReservStatusId)
		references BookReservationStatus (BookReservStatusId)
;
