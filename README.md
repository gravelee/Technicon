# Technicon
Java Bootcamp: Team Final Project

This is the Technicon java application and comes under the 
open source GNU General Public License v3.0. If you are not 
familiar with the license please read here :

https://www.gnu.org/licenses/gpl-3.0.en.html

The application will be used from a Renovation Contractor 
Agency and its customers. It will be the building block to 
add new data to the company's database like users of the 
application ( administrators or regular users: "owners"), 
properties owned by the users and repairs. The different
user types will be able to perform some services. (There 
will be proper validation for our new data). 


--The REGULAR USERS will be able to :

Search properties based on property id and owners vat number.
They can also search property repairs based on the date of the
scheduled repair or based on a range of dates that will
represent the expected sechedule repair date. Property repairs
can also be searched based on the owners vat number.


--The ADMINISTRATORS will be able to :

Do everything a regular user can do ( search properties and 
repairs based on the same search keys). Can also search for 
users based on vat number or email. They can also add or
remove users, properties and repairs to the database. (We 
check if the data of the new entities are legit and not faul)

They will also be able to change the state (attributes) of :

ENTITY_TO_BE_CHANGED    KEY_ATTRIBUTE

    Users            ...address, email, password.
    
    Properties       ...address, year of construction, 
                        property type and owners vat number.
                       
    Property Repairs ...date, summary, repair type, repair 
                        status, cost, owner vat number, property 
                        id, description.
    
This is the basic functionality or our application so far.


INSTALATION

Now in order to clone the project and run it you need to do a 
couple of things first.


   We firstly use java 17 to run the application.
   
   We used the Eclipse IDE to implement this app.
   
   There is no difference in cloning or creating a new project
   on your IDE ( from the .git repo we deleted all the config 
   files).
   
   We kept the pom.xml file cause we used some maven dependencies 
   for the mySQL connection and for the hibernate framework. The 
   persistance.xml file is there to see the way we connect the
   database with the hibernate framework.
   
   If you use ecpipse to run the project you need to go to right
   click on the project explorer, import, git/smart import. There
   you will add the projects url : 
   
   https://github.com/gravelee/technicon
   
   Then click next and finish and there you go. If you handle 
   through github you need to copy paste the projects files to your 
   IDEs project folder.


That is it! Thank you for using Technicon application.



