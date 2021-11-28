# wellbeing

Well Being System

## Description
Your Wellbeing is a web-based application which is an easy way to access gym, purchase memberships and book services.
The users are customers who can register themselves in the system and book an appointment for the types of services offered.
The system offers 3 types of Services, consulting a doctor, consulting a dietician, and booking a yoga or a gym trainer.
The System has various membership plans for the customers.
A user with a platinum plan need not pay for any of the services he has to book until his membership expires.
A user with gold must pay for the dietician and the user with a silver membership has free access only to the gym, he must pay for the other two services.
A user with a membership, books one or many services with his membership and proceed to payment if is required to pay for any of the service that doesn’t include in the membership, else he is notified with an email that his appointment is confirmed.
A user with no membership can either purchase a membership or choose to pay for the service and exit, he is also sent a payment notification.


#Buisness Logic

We developed a system that can help customers to register themselves to the system, purchase desirable gym memberships and book slots for available services which includes Consulting a doctor, consulting a dietician and booking a trainer which can either be a gym or a yoga trainer.
The system also maintains track of all the members and their memberships.
To achieve this solution, we as a team decided to build web services in java using Spring boot and developed UI using Angular.
Our project will be deployed on AWS Bean Stalk. The web application uses H2 DB to store/retrieve data. 
Service interaction is done by using REST APIS. GitHub is used to manage and share our codes. Our project is tracked in JIRA using the Kanban Board.

#Modules

#Registration

User should be able to enter their details and setup an account.
In this module a new user enters in all their information and clicks submit.
The data is then validated to check whether there is no existing user with those credentials.
A verification email is sent to the user post registration to verify the registration.
If User is already a member, they don’t need to sign up
System accepts credentials and generates an account with unique ID.

#Log in
Log in screen allows the user to login the system successfully
System authenticates the credentials using JWT

#Booking
Associates every online booking with an account
User should be able to check for availability of the most appreciate service and book that service.
A user can book the slot (i.e date and time) for the training session.
User can book multiple slots for the training sessions.
Booking confirmation is sent to the user’s, specified contact details
Cancel booking will also be an option for the user.


#Mmembership
User should be able to select the desired membership by their convenience
The associate can upgrade their membership.
There are three members, namely:
Platinum - All services are free
GOLD - Can access dietetic and gym services for free
SILVER - Access to "Gym" service only
Depending on the user's needs, the user can purchase one of these memberships.
If a user does not want to buy a membership, they can also make individual bookings and access all the services.


#Feedback
User should be able to provide feedback for the service.
The provided feedback is shown to the employee.

#Payment
User can make payment for their service.
User’s payment details are validated.
User can also make the payment for their preferred membership.
Email confirmation to be sent after making a payment for the desired service.



## Authors and acknowledgment
Anjali Keshav Das- 21124701
Sai Anushka Sallagundala Vasudeva Rao-
Dinesh Devarajan-21030472
Sai Rohit Voleti-21084742
Sai Subhiksha Venkateswaralu-200080508


##Stripe
use test credit cards offered by stripe
4242 4242 4242 4242 is not a real credit card number. It is one of the several Stripe testing cards available online. These cards only work in testing mode.






I

