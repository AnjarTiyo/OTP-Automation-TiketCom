# Handling OTP Authentication with SMS using TWILIO API

## Description

Here I show how to handle OTP authentication Automation. So, this is scenario where user want to login to [tiket.com](https://www.tiket.com/) using his phone number. But user is prompted to enter OTP sent to his phone number to complete login process. Below is scenario written in BDD style:

```
Feature: Login with OTP

  As an Registered User,
  I want to __login with my credentials__
  In order to **access logged in user feature**

  Scenario: Verify OTP Login functionality
    Given User already on Login Page
    When User enter registered phone number
    And User input OTP
    Then User is logged in
```

I use Twilio SMS API to process SMS and extract OTP Code to complete login flow.


## Pre-requisite

1. Java IDE, I use Intelij
2. An [Twilio](https://www.twilio.com/) Account and buy a phone number. There is free trial.
3. An [Tiket.com](https://www.tiket.com/) account

## How to Use

1. Clone this repo
```
git clone https://github.com/AnjarTiyo/OTP-Automation-Tiket.git
```

2. Set your Twilio Account SID to environment variable
Please follow instruction **[here](https://www.twilio.com/blog/2017/01/how-to-set-environment-variables.html)**

3. Open project on your favourite IDE

4. Modify 'REGISTERED_USER_PHONE_NUMBER' to your TWILIO number on:
```
src/test/java/com/tiket/model/UserData.java
```

5. Run Test 
```
mvn verify
```

## Environment

### Tiket.com 
tiket.com is the pioneer of online travel agents (OTA) in Indonesia established in 2011. In 2017, tiket.com became an affiliated company of Blibli and by 2021 became a consolidating subsidiary of Blibli. tiket.com is one of the largest and most comprehensive online travel companies in Indonesia providing flight, train, accommodation booking, event ticketing, car rental, and other travel essentials. Our mission is to accommodate the best access for online travel booking through the web and mobile application. 

### Twilio
We’re the customer layer for the internet, powering the most engaging interactions companies build for their customers. We provide simple tools that solve hard problems, delivered as a developer-first cloud platform with global reach and no shenanigans pricing. 

## Author
Anjar Tiyo Saputro
anjar.jog@gmail.com

[LinkedIn](https://www.linkedin.com/in/anjartiyo/)
