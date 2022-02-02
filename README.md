# DFESW7---FINAL-PROJECT
Final project for cohort DESFW7 for QA's Software Development boot camp

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
Surprisingly, the challnges I described above are the parts of the project that went the smoothest for me. Being able to access the QA community website in order to re familiarise myself with the concepts proved incredibly successful and led to me being able to complete CRUD functionality and Postman communication tests being completed within the same day. This free'd up a large amount of time that I had allocated to myself in order to achieve this task so I was able to implement the stretch goal of adding a custom exception to my code. I also feel that my Jira board was incredibly useful, by being able to track tasks individually I was able to build my project in small chunks which stopped me overwhelming myself by setting unreasonable goals. (Finish when testing is done)


## What didn't go as planned
The biggest problem I encountered was getting data to persist within MySQL. Although I was able to use Postman for my CRUD functionality I was unable to get the data to then persist outside of that in the MySQL schema. I managed to fix this by creating a new table from within my IDE to MySQL after that was able to successfully get the data to persist. I also had a smaller problem where instead of storing my data within a JPA repository, I had coded it to store within an array list but this was fairly simple problem to fix.

## Possible improvements for future revisions of the project

## Postman screenshots and API output
Within my project I abstracted my CRUD functionality by using both a service and a controller class


### Service class methods

#### Create - addGame()

![image](https://user-images.githubusercontent.com/92368003/152183282-8f8507f4-e23b-4366-a5ce-9f044cf178ef.png)

This piece of code takes in a value of the entity game and then returns value and saves it to the repository using a depency injection of my repository interface.

#### Read - getAllGames()

![image](https://user-images.githubusercontent.com/92368003/152183879-f43a6c18-aef6-4ee3-b696-54bfe8e2e737.png)

The above creates a list within the IDE then uses a dependency injection to return all of entities within the table.

#### Update - updateGames()

![image](https://user-images.githubusercontent.com/92368003/152184613-74eb4baa-4c27-44e1-9d68-87e96f74ea97.png)

Creates a variable of "update" which grabs the entity that contains the ID inputted. Using this variable we then update the attributes for the entity using "update.setX(newGame.getX())". After this new information is saved to the value "newGame" it is then retuned back to the repository.

#### Delete - removeGame()

![image](https://user-images.githubusercontent.com/92368003/152186883-4330a1a6-cbe3-4dd2-8b87-ad840a58f97b.png)

Delete method is set as a boolean so that Postman will return a true if the entity has been deleted properly. The repository deletes by the ID given and then a variable of "exists" is created which checks the repository for the ID that has been deleted. If the ID doesn't exists, it then returns true if the ID no longer exists.

### Controller Class Methods

![image](https://user-images.githubusercontent.com/92368003/152187660-7e6c6582-58d7-49a0-8c3f-25a9581f5b1b.png)

The controller class is given the @RestController bean in order to allow @RequestMapping beans within to function properly

![image](https://user-images.githubusercontent.com/92368003/152188997-7341a329-fab8-4bf7-8da6-04328fc4c21c.png)

For expediencies sake the above methods correlate the CRUD functionality described in the Service Class Methods section, but the logic is abstracted away and using the instance of the service class allows us to call those methods into our controller class. As well the @RequestMapping assigned to each of the methods allows us to use Postman to set HTML CRUD requests using the aissgned paths.



#### 




## Database screenshots

## Test coverage screenshots

## Jira board
[Final Project Jira board](https://dwc342.atlassian.net/jira/software/projects/D7FP/boards/3)
