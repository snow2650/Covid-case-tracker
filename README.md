# COVID-19 Case Tracker

## An App for Mapping the confirmed cases

Since the pandemic happened, the government tried to track those cases to stop the influence.
This app provides **a platform for collecting and mapping** the show-up cases.
It aims to help to determine which areas should be alarmed and sanitized. 

Three *features* of this tracker:
- A virtualized map with each case have its location, time(date) and ID
- The record can be saved and recall
- The record is Searchable by location, time or ID

User Stories
- As a user, I want to be able to add cases I received.
- As a user, I want to be able to view the cases I added.
- As a user, I want to be able to remove the cases.
- As a user, I want to be able to search the certain case by location, time or ID.

New features:
- The user has ability to save the state of the application
- The user can reload that state from file and resume exactly where they left off at some earlier time

Phase 4: Task 2
I choose to test my model package is robust. 
The sliders are not user-friendly as I thought, even they can reduce the error from 
manually filling in. Therefore, I decided to set Exceptions for Condition class in
order to fit the future design.


Phase 4: Task 3
Each case has a basic data structure, location,time and ID, which is also a list of CaseInfo with a name.

Record and CaseInfo implement Writable(Interface). Then Writable(Interface) will transfer them to JSON.

Condition uses CaseInfoList, CaseInfo, and Record to check the constraint of the data.Then it extendsCaseFrame. 

CaseInfoList is used for searching the data,so it would use Record to find the specific data. 

CaseTracker is in charge of saving ang loading files.It would read the file from Record.

If I have more time: 
1. Some functions cannot show on GUI, such as message.
2. Some codes repeat too much and should use composited pattern
3. The filter function should also change the spot color of each condition(location, time and ID) for easy reading
4. Cases have no order; therefore it can be store in the form of HashMap.
