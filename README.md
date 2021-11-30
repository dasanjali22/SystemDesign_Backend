# wellbeing

Well Being System

## Deployment Details
1. Getting started with AWS
We have created AWS account with Free Tier.
2. Getting started with Elastic Beanstalk
From AWS Administration Console, select Elastic Beanstalk. Click on Make Application. Next, give an application title and select the suitable platform title. For Spring Boot, it’s Java.
3.We have uploaded our application war file. As we have Gradle, we build a jar using below command
 ->./gradlew war and  
 ->./gradlew bootWar 
 which created a snapshot war file in our build/libs/ folder.
4.Than we have uploaded war file, Elastic Beanstalk will create the environment to run your code.
By default, code throw a warning since Elastic Beanstalk runs on port 5000 while Spring Boot’s embedded Tomcat runs on 8080.
5.To fix this, we went into the Configuration tab and select Software category. Under Environment properties, add SERVER_PORT with value 5000. Click on Apply.
6.After click on Apply, Elastic Beanstalk  updated in our environment.
7.Once the environment was updated, we have launched our application. We Replace localhost:8080 with the AWS url. 
http://wellbeing-env.eba-tgcii7hq.ap-south-1.elasticbeanstalk.com/swagger-ui/#

## Description

Your Wellbeing is a web-based application which is an easy way to access gym, purchase memberships and book services.
The users are customers who can register themselves in the system and book an appointment for the types of services offered.
The system offers 3 types of Services, consulting a doctor, consulting a dietician, and booking a yoga or a gym trainer.
The System has various membership plans for the customers.
A user with a platinum plan need not pay for any of the services he has to book until his membership expires.
A user with gold must pay for the dietician and the user with a silver membership has free access only to the gym, he must pay for the other two services.
A user with a membership, books one or many services with his membership and proceed to payment if is required to pay for any of the service that doesn’t include in the membership, else he is notified with an email that his appointment is confirmed.
A user with no membership can either purchase a membership or choose to pay for the service and exit, he is also sent a payment notification.


## Authors and acknowledgment

Anjali Keshav Das- 21124701
Sai Anushka Sallagundala Vasu Deva Rao- 21107831
Dinesh Devarajan-21030472
Sai Rohit Voleti-21084742
Sai Subhiksha Venkateswaralu-200080508


## Stripe

Test Credit Card Number 4242 4242 4242 4242.
This is not a real credit card number. It is one of the several Stripe testing cards available. These cards only work in testing mode.






I

