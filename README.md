# DFESW7---FINAL-PROJECT
Final project for cohort DFESW7 for QA's Software Development boot camp

## Why are we doing this?
For the final project of our DfE Software Development bootcamp we were tasked with creating a fully functioning API.

This API must include:
* Full CRUD functionality
* Sensible back-end package structure
* Unit and integration testing
* Reasonable test coverage of the API (60% minimum - 80% as a stretch goal)
* A GitHub Repository utilising a consistent feature-branch model
* The API compiled into a .jar file present in the root folder

Precise documentation of this project is also a requirement, of which this README is a part of.

### Resources used
* Java
* Spring Boot
* MySQL
* Maven
* Postman
* Jira
* GitBash
* GitHub
* Junit

### My Project - Video game repository
For my final project I decided to create a video games database. I decided on this topic because I have an active interest in gaming
so populating the database would be easy as I have a knowledge base of the subject. Each video game entity requires the following fields:
* An auto-generated ID
* A title
* A developer name
* A publisher name
* Original release date
* Platform (Console, PC) it is available on

I took some inspiration from the website GiantBomb.com which aside from being a news aggregator also acts as an encyclopedia of video games. 
I have used JPA for the repository and the data then persists inside of MySQL. I have used Postman to test my CRUD functioality and will be using
H2 as on-memory database for testing purposes


## How I expected the challenge to go.
I expected the challenge to be tough. In previous weeks I had struggled to grasp the importance of CRUD functionality and sending requests via Postman so
I was initally hesitant as the project spec revolved heavily around those concepts. As well, as I hadn't used MySQL much I was concerned that there would be gaps in
my knowledge that might potentially form a large blocker. However, I believed that if I was able to overcome these hurdles the rest of the project would run smoothly as the documentation side of things was something I felt comfortable with. I was also confident in my skills using Jira, GitBash, and GitHub. As I was comfortable using the aforementioned resources I felt optimistic about my ability to modularise my workflow, so I didn't overburden myself by trying to build too much code at the same time. I felt the best way to do this was to document alongside my coding, whilst also working through concepts I didn't understand well using the documents given to me by QA to reinforce my knowledge.

## What went well?
Surprisingly, the challnges I described above are the parts of the project that went the smoothest for me. Being able to access the QA community website in order to re familiarise myself with the concepts proved incredibly successful and led to me being able to complete CRUD functionality and Postman communication tests being completed within the same day. This free'd up a large amount of time that I had allocated to myself in order to achieve this task so I was able to implement the stretch goal of adding a custom exception to my code. I also feel that my Jira board was incredibly useful, by being able to track tasks individually I was able to build my project in small chunks which stopped me overwhelming myself by setting unreasonable goals. The majority of Testing went well, and I was able to achieve over 80% coverage of main.


## What didn't go as planned
The biggest problem I encountered was getting data to persist within MySQL. Although I was able to use Postman for my CRUD functionality I was unable to get the data to then persist outside of that in the MySQL schema. I managed to fix this by creating a new table from within my IDE to MySQL after that was able to successfully get the data to persist. I also had a smaller problem where instead of storing my data within a JPA repository, I had coded it to store within an array list but this was fairly simple problem to fix. Unfortunately, I also was accidentally doing test coverage on production instead of dev, which let to some compilation errors lkater when trying to package my app with Maven. To fix this, I checked for any persistant data in MySQL that was causing testing errors, used Postman to delete it, and then was able to succesfully package my app.

## Possible improvements for future revisions of the project

## Postman screenshots and API output
Within my project I abstracted my CRUD functionality by using both a service and a controller class. In the following I will show the methods as they can be seen within the server class and then how they are abstracted into the controller class. As well, I will show Postman using this CRUD functionality.

### Create - addGame()

![image](https://user-images.githubusercontent.com/92368003/152183282-8f8507f4-e23b-4366-a5ce-9f044cf178ef.png)

This piece of code takes in a value of the entity game and then returns value and saves it to the repository using a depency injection of my repository interface.

![image](https://user-images.githubusercontent.com/92368003/152239809-5e9c5e76-24a2-41ba-8855-913152b2a833.png)

Abstraction to the controller class.

![image](https://user-images.githubusercontent.com/92368003/152240121-80d8b22f-be7e-4c36-ab00-524c210cef3e.png)

Postman displaying the Post request that has inputted data that matches the attributes of the entity class present within the project.

### Read - getAllGames()

![image](https://user-images.githubusercontent.com/92368003/152183879-f43a6c18-aef6-4ee3-b696-54bfe8e2e737.png)

The above creates a list within the IDE then uses a dependency injection to return all of entities within the table.

![image](https://user-images.githubusercontent.com/92368003/152240691-8d3284d2-33de-427d-95b5-919d53138e1a.png)

Abstracted method in controller class.

![image](https://user-images.githubusercontent.com/92368003/152240832-316db604-85ca-497a-9a68-2225fec987b9.png)

Get request within Postman, displaying all entities within the database

### Update - updateGames()

![image](https://user-images.githubusercontent.com/92368003/152184613-74eb4baa-4c27-44e1-9d68-87e96f74ea97.png)

Creates a variable of "update" which grabs the entity that contains the ID inputted. Using this variable we then update the attributes for the entity using "update.setX(newGame.getX())". After this new information is saved to the value "newGame" it is then retuned back to the repository.

![image](https://user-images.githubusercontent.com/92368003/152240975-b3a950e5-7629-4edb-b6e2-0dca9ab02c9e.png)

Abstracted method in controller class

![image](https://user-images.githubusercontent.com/92368003/152241275-f566ec79-65b7-4325-80b2-67e74dae4653.png)

As can be seen in the above image, the attributes can be changed by the update request, which will then relate to the tables in MySQL they relate to. The ID does not change as it is automatically generated, and allows us to see that the specific data we are changing is accurate to the ID we input.


### Delete - removeGame()

![image](https://user-images.githubusercontent.com/92368003/152186883-4330a1a6-cbe3-4dd2-8b87-ad840a58f97b.png)

Delete method is set as a boolean so that Postman will return a true if the entity has been deleted properly. The repository deletes by the ID given and then a variable of "exists" is created which checks the repository for the ID that has been deleted. If the ID doesn't exists, it then returns true if the ID no longer exists.

![image](https://user-images.githubusercontent.com/92368003/152243051-2db00070-b7bb-4071-ad8a-352957706d48.png)

Abstracted method in the controller class

![image](https://user-images.githubusercontent.com/92368003/152243141-0627505f-a78b-4a8a-94ab-525e05a40755.png)

As mentioned above, as the ID no longer exists the boolean in the method returns true.

## Database screenshots

![image](https://user-images.githubusercontent.com/92368003/152246993-49e87ae1-8e56-4228-946e-0242f34ea3a0.png)

The above image is for posterity, to show the database is empty before I demonstrate that the data posted by my CRUD functionality persists within MySQL.

### Create

![image](https://user-images.githubusercontent.com/92368003/152247821-7e39556c-0faf-4fd6-aff6-ffb1d2cf8d09.png)

Post request in Postman.

![image](https://user-images.githubusercontent.com/92368003/152247878-20947942-1740-4ff8-884b-a56ed17ea212.png)

Data persisting within MySQL.

### Read

![image](https://user-images.githubusercontent.com/92368003/152248825-4b19f18a-53fb-4d00-9213-fbe055b86b06.png)

Added new entities in Postman for the purpose of showing a Get request

![image](https://user-images.githubusercontent.com/92368003/152248951-ee2d3aae-373e-4e09-baf0-31fea9d2039a.png)

Then the resulting entities persisting within MySQL

### Update

![image](https://user-images.githubusercontent.com/92368003/152249669-8f2518ec-578d-432f-88a8-3662c4043520.png)

Update done by utilising a Post request in Postman, changing the entitiy related to ID 7

![image](https://user-images.githubusercontent.com/92368003/152249755-9f44e03e-8460-4420-906f-969408f887f0.png)

Update persisting within MySQL, which shows that only the data related to ID 7 has been changed, whilst the previous data persists.

### Delete

![image](https://user-images.githubusercontent.com/92368003/152249944-9c67169e-df7f-4e55-b8b4-e35e83a280fd.png)

Delete request within Postman, deleting entity of ID 7 that was updated in the previous section

![image](https://user-images.githubusercontent.com/92368003/152250081-38db066f-4f93-47e1-8fa8-a117de00b330.png)

Delete persisting with MySQL, entity of ID 7 has been deleted
-

## Test coverage screenshots

## Jira board
[Final Project Jira board](https://dwc342.atlassian.net/jira/software/projects/D7FP/boards/3)
