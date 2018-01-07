# CSCI-6370-Database-Management-System
Database Systems (Fall 2017 CSCI 6370) - Term Project - UGA Cloud Services

Team Members: Chandana Marneni, Prasad Mate, Sharmin Pathan, Vibodh Fenani

Technologies Used: PostGres SQL, AWS, Spring boot, bootstrap

Problem Statement: 
Project includes database design (UML Class Diagram, 3NF/BCNF Normalization), population and Web-based application development. 
The Web development framework is Spring boot.

Project Idea:
UGA cloud services is an online portal where UGA students can have access to multiple cloud services
provided by UGA infrastructure. These services may be used by many stakeholders of the system for
myriad purposes. The designed system is a web portal for managing different service request and ensure
a smooth business.
Our system identifies three users viz., the student, the faculty and the resource Administrator. We assume
a set of services which are often required in academia for coursework or research purposes. The student
and faculty may request for a service, which needs to be approved by his/her own department head. On
approval from the department head, the request is fulfilled if the required resources for the requested
service are available. Resource admins job is to monitor the resources used and to increase the number
of resources on demand.

Content:
-------------------
The zip file named, 'CSCI 6370 Term Project' contains the following:

- Project 5.zip 						| contains source code of project 5
- Project_dump.sql					| SQL create and insert statements
- OnInsertTrigg On Resources table.sql		| Trigger 1	
- OnUpdateTrigg On Allocation table.sql		| Trigger 2
- UML Class diagram.png					| Class diagram
- Readme						| Readme
- Cloud Manager.pdf					| Original presentation


Before Execution :
-----------------------
-----> Option1 : Set up local database schema
-- Open Project_dump.sql file
-- Create new database DBMSPROJ5
-- Create new schema DBMS_FINAL_PROJV1
-- Create tables and insert sample data as given in Project_dump.sql
-- Load triggers using pgAdmin
-- In /src/main/resources/application.properties file, uncomment the commented code and fill in credentials for your postgres machine.

-----> Option2 : Connect to AWS host
-- put host name as  awsproj.cjq9bdulkcax.us-east-1.rds.amazonaws.com:5432
-- user name as rootAWS
-- password as password
-- Keep the original config intact


Execution Instructions:
-----------------------
- Import the project in eclipse or intelliJ workspace
- Write click on project workspace and run as a spring boot application
- On browser, type localhost:8080 
- Enter user_id and password for required user.

--Sample login creds:
-Faculty : (CX00527,PASSWORD1)
-Student : (CX20527,PASSWORD2)
-Rsr Manager: (AX00527,PASSWORD3)
