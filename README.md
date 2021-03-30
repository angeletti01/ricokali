# Family Pets

## Description
Family-Pets is a web application that brings pet buyers and pet breeders together to conduct business. It is an online marketplace that allows pet buyers to make requests for breeders to accept and breed the specified breed. Buyers and breeders are able to view the different requests on the site and manage their own information.

## Project goal
Our goal is to disrupt the pet farming bussiness. Our research shows concerns of the breeding environment of those large pet farms as well as the concern of over breeding. Our research also shows rising demand of family bred pets. That's why we invented this on-demand pet breeding marketplace - Family Pets.

## Contributors
-Rico-kali Hayes
-Hon Pan Loi
-James Olas
-Micheal Ball

## My roles in this project
All contributors are involed with basically everything. We spread the work almost evenly. Also, a lot of work were done through peer programming.

## Project Management
Database design and construct
Version control
Front end design and implementation
Back end implementation
Database connectivity
Test case writing
QA
Debug
Project presentation

## User stories/ features
Buyer logs in.
Buyer views customer information.
Buyer changes customer information.
Buyer submits request for breed.
Buyer makes change to pending request.
Buyer views pending requests.
Buyer views resolved requests.
Buyer logs out.
Breeder logs in.
Breeder views breeder information.
Breeder changes breeder information.
Breeder views pending requests.
Breeder views resolved requests.
Breeder accepts pending requests.
Breeder logs out.
Buyer and breeder can chat through a request.

## Future Development
Breeder uploads photo of the babies.
Buyer views uploaded photo.

## Technologies Used/ Environment
Log4j - 1.2.17
JUnit - 5.4.2
Mokito - 3.7.7
Java - 8
Spring Tool Suite - 4.8.1.Release
Dbeaver - 7.3.4
Git Bash - 2.25.1
AWS-java-sdk - 1.11.327
AWS EC2 - Linux
AWS RDS
AWS S3
AJAX
Tomcat 9.0.43
Angular 11
Node.js 6.14.11
Visual Studio Code
Spring Framework / Spring boot
Language used - Java 8, SQL, XML, JavaScript, HTML, CSS, TypeScript

## Getting Started
Download and install development tools. (Spring Tool Suite, Dbeaver, Gitbash, Tomcat 8.5, VS code, Node.js)
Open Git bash on the location that you want your BACK end project folder to be.
In the Git bash CLI, enter the command 'git clone https://github.com/angeletti01/ricokali/edit/projects.git'.
You should see the project folder is created on your computer.
Open Dbeaver.
Create a new connection with local client PostgreSQL 12.
Create a new schema called 'familypets'
Right Click on the 'familypets' schema. -> Tools -> Restore.
Select the backup file at FamilyPets/dump-postgres-202103262130.sql .
Click on local client and select PostgreSQL 12.
Click 'start'.
The tables with some dummy data should be created
Open Spring Tool Suite with the workspace of your choice.
File -> Import -> Maven -> Existing Maven Projects.
Navigate to the folder 'FamilyPets' where the pom.xml is located and click finish.
You should see a project named 'FamilyPets' get imported.
Add your 'DBURL', 'DBUSERNAME', 'DBPASSWORD' to your system environment variable.
Right click on the project -> Run as -> Spring boot project.
If successful, the back end should be running on your local host 8080.
Open Git bash on the location that you want your FRONT end project folder to be.
In the Git bash CLI, enter the command 'git clone https://github.com/angeletti01/ricokali/edit/projects.git'.
You should see the front end project folder is created on your computer.
Goes inside the 'FamilyPets' folder.
Open a terminal of your choice.
Enter the command 'ng serve -o'.
If successful, the front end should be running on your browser in http://localhost:4200/.
You should be able to login with 123@gmail.com and password 123.





