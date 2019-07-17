/**
 * IPD-16 420-P24-AB Java III  - FINAL PROJECT
 *
 * Populate views
 *	Script Date: July 16, 2019
 *  Developed by: Jeonghoon Lee
 */

-- Switch to the LibraryNORJ database
use LibraryJH
;

drop view if exists UsersView
;

create view UsersView
as
select 
	A.AccountId, A.Password, ACS.AccountStatusDescrip, ACT.AccountTypeDescrip,
    U.UserId, U.UserFirstName, U.UserLastName, U.UserEmail, 
    U.UserRegisteredDate, U.UserLastLoginTime
    
from Accounts as A
	left join AccountStatus as ACS
		on A.AccountStatusId = ACS.AccountStatusId
	left join AccountTypes as ACT
		on A.AccountTypeId = ACT.AccountTypeId
	left join Users as U
		on A.UserId = U.UserId
;
		