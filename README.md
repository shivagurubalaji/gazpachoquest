[![Coverage Status](https://coveralls.io/repos/antoniomaria/gazpachoquest/badge.svg?branch=master)](https://coveralls.io/r/antoniomaria/gazpachoquest?branch=master)
[![Build Status](https://travis-ci.org/antoniomaria/gazpachoquest.svg?branch=master)](https://travis-ci.org/antoniomaria/gazpachoquest)


# GazpachoQuest a Survey Rest API Engine

GazpachoQuest is a Java Open Source Rest-Based survey engine. The main advantage over other alternatives is its loose coupled architecture based on
[Microservices Architecture](http://www.infoq.com/articles/microservices-intro) which ensures concern-separation.
This engine is intended to be consumed by rest clients in order to build different front-end (web apps, mobile apps etc). It provides all features than others survey engines have, among other technological features such as Role-Permission based access, HMac security layer (HMAC based), support for main databases (JPA based persistence layer) and swagger rest documentation api.

There is available a Vaadin web application as proof of concept of the engine.

A Karaf OSGI based port is coming up. Stay tune.

## Highligh features

* Multi-lingual questionnaires. 
* Conditions for questions depending on earlier answers (Skip Logic / Branching)
* Question and page randomization.
* Auto-numbering for questions.
* Reordering questions / page logic.
* Question Types
  * Multiple Choice List (Check Boxes) + Other. Vertically or Horizontally arranged.
  * Short /Long Text  Response + Other
  * Multiple Choice one selected at a time (Radio buttons). Vertically or Horizontally (scales) arranged.
  * Matrix or array of questions above listed.
* Smart language selector depending on Browser Preferred Language, or Respondent attributes.
* Anonymous and Not-Anonymous questionnaires.
* Possibility to show all questions in a single page, different pages or one question at a time for small displays.
* Role-Permission based Access-Rights management. 
* HMac based security.
* Import and export questionnaires definitions to XML.
* Instantly saved responses, thus participants can continue answering at a later time.
* Re-usable editable answer sets.


## Contributing

Contributions are welcome, in any form including code contributions, bug reports, feature suggestions, documentation, testing, and general feedback. Specially are frondend developers are really welcome either to improve the Vaadin proof of concept or in order to build a dashboard or administration tool. Issues can be submitted on the [Github page][1]. For further information, contact to: <mailto:antoniomariasanchez@gmail.com> or visit [wiki developer section](https://github.com/antoniomaria/gazpachoquest/wiki/Developers)


## Third party libraries and components

* [JPA Eclipse link](http://www.eclipse.org/eclipselink/jpa.php)
* [Dozer Java Bean mapper](http://dozer.sourceforge.net/)
* [Liquibase](http://www.liquibase.org/) 
* [Spring Data JPA](http://projects.spring.io/spring-data/)
* [JAX-RS (Apache CXF 3.x)](http://cxf.apache.org/)
* [Swagger 2.0](http://swagger.io/)
* [Java Security Shiro](http://shiro.apache.org/)
* [Vaadin 7 (CDI plugin)](https://vaadin.com/home)
* Java Authentication and Authorization Service, (JAAS)  
* [SL4J (Logback)](http://logback.qos.ch)
* [DBUnit](http://dbunit.sourceforge.net)
* [Spring-Test DBUnit](http://springtestdbunit.github.io/spring-test-dbunit/)
* [EasyMock](http://easymock.org/)

## Installation and local demo

HSQL database and Apache TomEE is used for local demo.

    git clone https://github.com/antoniomaria/gazpachoquest.git
    cd gazpachoquest
    mvn clean install -pl tomee-assembly -am
    cd tomee-assembly\target\assembly\bin
    startup.bat
    
To see the demo, navigate to

* [REST Gateway](http://localhost:8080/gazpachoquest-rest-web)
* [Questionnaires UI](http://localhost:8080)

See more details about local installation on [Installation Guide page](https://github.com/antoniomaria/gazpachoquest/wiki/Installing-Gazpachoquest-from-the-source).

### REST Gateway

This module exposes all the features that GazpachoQuest provides.

The credential for administrator account in form of apiKey:secret is:

    VECDUX8DGNXA4HF:9C52PBUXJG9238HRELRUX97CETUAQ4BV

To get respondents credential first is required to validate the invitation key in [Authentication Resource](http://gazpachoquest.rest.antoniomaria.eu.cloudbees.net/#!/auth/authenticate_get_0) 

### Questionnaires UI

This module holds all the active questionnaires/surveys ready to be fill out for respondents. They can be anonymous or tracked depending on the questionnaire settings.

**Anonymous and linear questionnaires invitation keys**

|                          |  No Randomization      |  Sections Randomization   |  Questions Randomization  |
|--------------------------|:----------------------:|:-------------------------:|:-------------------------:|
| **Section By Section**   |  PXLLBCJDX6            |  QT2SXREWAH               |  REGRW5X27C               |
| **Question by Question** |                        |                           |                           |
| **All in one page**      |  ZZC3XNHYVL            |                           |                           |

**Anonymous dynamic questionnaire depending on previous answers (skip-logic enabled)**

|                          |  No Randomization      | 
|--------------------------|:----------------------:|
| **Section By Section**   |  ZRHV75Z6CB            |
| **Question by Question** |                        | 

**Personal questionnaires invitation keys**

|                          |  No Randomization      |  Sections Randomization   |  Questions Randomization  |
|--------------------------|:----------------------:|:-------------------------:|:-------------------------:|
| **Section By Section**   |  2CNBSHKPBQ, DCLHXDRMLS|  D7QZ2CXZJW, ULQ6XWK8QR   |  SS5G7MV7NY,FSMSLM2A44    |
| **Question by Question** |                        |                           |                           |
| **All in one page**      |                        |                           |                           |


[1]: https://github.com/antoniomaria/gazpachoquest/issues
