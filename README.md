# **Demo Project for Document service**

This is a spring boot project to ingest the document filtered the uploaded document as per the user requirement.

## Clone the repository:

git clone https://github.com/dillip123-stack/demo_for_jk.git
cd demo_for_jk

## Set Up Your Environment

Open the project in your preferred IDE (IntelliJ IDEA, Eclipse, etc.)

### Update the database configuration in src/main/resources/application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/your_db_name
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password

## Build the Application

Run the following command from the project root directory to build the project:
**mvn clean install**

## Run the Application

After a successful build, run the Spring Boot application using:
**java -jar target/document-0.0.1-SNAPSHOT.jar**

## Features

1. Upload and ingest documents
2. Keyword-based question answering
3. Filter documents by metadata (author, type) with pagination and sorting

NOTE: You can also access swagger over url:http://localhost:8080/swagger-ui/index.html

# Test cases

### 1. Upload and Ingest Document

Description: Upload and ingest a document with metadata (title, author, type).

#### case1: upload docx file

Request curl: 
curl --location 'http://localhost:8080/documents/ingest?title=dillip&author=deepak&type=docx' \
--header 'accept: */*' \
--header 'Content-Type: application/json' \
--form 'file=@"postman-cloud:///1f012efb-cb0e-4a40-9fd7-59ce7a45aa33"'

Response:
{
"id": 23,
"title": "dillip",
"author": "deepak",
"type": "docx",
"content": "Dillip Giri | Software Engineer (Java Backend Developer)\nsdm.dillip@gmail.com                                                                  +91 6371684110\nSummary \nResults-driven Java Developer with over 4 years of experience in designing, developing, and implementing scalable enterprise applications. Proficient in Core Java, Spring Boot, Microservices, and Hibernate, with expertise in database-driven applications using MySQL and PostgreSQL. Adept at Agile methodologies, batch processing, and version control with Git. Strong problem-solving skills with a focus on performance optimization and maintainable code. Passionate about delivering innovative solutions across Financial, E-commerce, Digital Media, and Healthcare domains while collaborating in dynamic environments.\nEducation \nBachelors of Technology from Biju Pattanaik University of Technology, Rourkela, Odisha (06/2013 - 07/2017) with 8.0 CGPA.\nIntermediate of Science from RIST, Basta, Balasore, Odisha (05/2011 - 05/2013) with 66%.\nMatriculation from B. C. High School, Kasafal, Balasore, Odisha (05/2010 – 05/2011) with 56%.\nWork Experience\nSoftware Engineer – Aspida Technologies                                                                                                            03/2023 - 01/2025\nImplement innovative strategies, driving a 30% increase in client satisfaction through enhanced service delivery.\nDeveloped and managed a high-performance database, improving data retrieval time.\nWrote comprehensive unit test cases for key functionalities, boosting overall application reliability.\nCreated detailed API documentation that improved integration efficiency, reducing support requests by 25%.\nAlong with development, I have contributed to verification and validation for client UAT support.\n\nSoftware Engineer - Verve Digital Technologies Pvt. Ltd.                                                                                   01/2021 - 02/2023\nLeveraged expertise to develop innovative solutions, resulting increase in project efficiency.\nDeveloped a scalable application using Spring Boot Services, reducing deployment time and enhancing system performance.\nWrote comprehensive unit test cases for key functionalities, boosting overall application reliability.\nIdentified and fixed major bugs, leading to decrease in user-reported issues within one quarter.\n\n.Skills : \nJava, Spring boot, Microservices, MySQL, PostgreSQL, MongoDB, click house DB, Kafka, Junit, REST API, JSP, Servlet, Swagger, Jacoco, SonarQube, Hibernate, JPA, JDBC template, Agile methodologies\nTools: Eclipse, IntelliJ, STS, Postman, JIRA, Share point, Bit Bucket, Git, Pg Admin, MySQL Workbench, dbeaver \nProjects :\nMatter Web Site (Mar 2023 – Dec 2024)\nEnabled registration, update profile and login functionality, increasing user sign-ups.\nFacilitated prebooking for 40,000 users, increasing customer engagement by 25% and enhancing overall user satisfaction.\nImplemented a user-friendly booking system that allowed registered users to schedule test rides effortlessly.\nFacilitated registration for dealerships, enhancing user engagement and expanding market reach significantly.\nMatter Companion APP (Mar 2023 – Dec 2024)\nDeveloped APIs for user-friendly application allowing bike owners to access ride details, enhancing customer engagement.\nFacilitated a feature enabling users to track bike locations, achieving a satisfaction rate in user feedback surveys.\nEnabled remote lock and unlock capabilities, enhancing security response.\nImplemented vacation mode feature, resulting in reduction in user inquiries during peak holiday seasons.\nMatter Sales APP (July 2023 - Dec 2024)\nStreamlined dealer-side administration processes, reducing administrative errors.\nFacilitated access for dealer-side employees to track engagements, resulting in increase in customer interactions.\nHospital Management System (Apr 2022 - Feb 2023)\nStreamlined patient notes and transaction management, enhancing data accessibility for healthcare providers.\nImplemented a patient scheduling system that reduced appointment wait times, enhancing overall patient satisfaction.\nDeveloped a versatile clinic management system, enabling usage by individual clinics or as a centralized management hub.\nEngineered a multi-module healthcare application comprising Patient, Doctor, Medicos, Operation, Billing and Test.\nEmployment Website (Jan 2021 - Feb 2022)\nFacilitated job posting for recruiters, resulting in a 30% increase in candidate applications within six months.\nImplemented features for CV uploads, education details, and skills, attracting more recruiters to candidate profiles.\nDeveloped a project comprising three modules: Administration, Recruiter, and Candidate, enhancing workflow efficiency.\n\n\n",
"createdDate": "2025-04-08"
}

#### case2: Upload pdf file

Request curl: 
curl --location 'http://localhost:8080/documents/ingest?title=dillip&author=deepak&type=pdf' \
--header 'accept: */*' \
--header 'Content-Type: application/json' \
--form 'file=@"postman-cloud:///1f012efb-cb0e-4a40-9fd7-59ce7a45aa33"'

Response:
{
"id": 22,
"title": "dillip",
"author": "deepak",
"type": "docx",
"content": "Dillip Giri | Software Engineer (Java Backend Developer)\nsdm.dillip@gmail.com
+91 6371684110\nSummary \nResults-driven Java Developer with over 4 years of experience in designing, developing, and
implementing scalable enterprise applications. Proficient in Core Java, Spring Boot, Microservices, and Hibernate, with
expertise in database-driven applications using MySQL and PostgreSQL. Adept at Agile methodologies, batch processing,
and version control with Git. Strong problem-solving skills with a focus on performance optimization and maintainable
code. Passionate about delivering innovative solutions across Financial, E-commerce, Digital Media, and Healthcare
domains while collaborating in dynamic environments.\nEducation \nBachelors of Technology from Biju Pattanaik University
of Technology, Rourkela, Odisha (06/2013 - 07/2017) with 8.0 CGPA.\nIntermediate of Science from RIST, Basta, Balasore,
Odisha (05/2011 - 05/2013) with 66%.\nMatriculation from B. C. High School, Kasafal, Balasore, Odisha (05/2010 –
05/2011) with 56%.\nWork Experience\nSoftware Engineer – Aspida Technologies 03/2023 - 01/2025\nImplement innovative
strategies, driving a 30% increase in client satisfaction through enhanced service delivery.\nDeveloped and managed a
high-performance database, improving data retrieval time.\nWrote comprehensive unit test cases for key functionalities,
boosting overall application reliability.\nCreated detailed API documentation that improved integration efficiency,
reducing support requests by 25%.\nAlong with development, I have contributed to verification and validation for client
UAT support.\n\nSoftware Engineer - Verve Digital Technologies Pvt. Ltd. 01/2021 - 02/2023\nLeveraged expertise to
develop innovative solutions, resulting increase in project efficiency.\nDeveloped a scalable application using Spring
Boot Services, reducing deployment time and enhancing system performance.\nWrote comprehensive unit test cases for key
functionalities, boosting overall application reliability.\nIdentified and fixed major bugs, leading to decrease in
user-reported issues within one quarter.\n\n.Skills : \nJava, Spring boot, Microservices, MySQL, PostgreSQL, MongoDB,
click house DB, Kafka, Junit, REST API, JSP, Servlet, Swagger, Jacoco, SonarQube, Hibernate, JPA, JDBC template, Agile
methodologies\nTools: Eclipse, IntelliJ, STS, Postman, JIRA, Share point, Bit Bucket, Git, Pg Admin, MySQL Workbench,
dbeaver \nProjects :\nMatter Web Site (Mar 2023 – Dec 2024)\nEnabled registration, update profile and login
functionality, increasing user sign-ups.\nFacilitated prebooking for 40,000 users, increasing customer engagement by 25%
and enhancing overall user satisfaction.\nImplemented a user-friendly booking system that allowed registered users to
schedule test rides effortlessly.\nFacilitated registration for dealerships, enhancing user engagement and expanding
market reach significantly.\nMatter Companion APP (Mar 2023 – Dec 2024)\nDeveloped APIs for user-friendly application
allowing bike owners to access ride details, enhancing customer engagement.\nFacilitated a feature enabling users to
track bike locations, achieving a satisfaction rate in user feedback surveys.\nEnabled remote lock and unlock
capabilities, enhancing security response.\nImplemented vacation mode feature, resulting in reduction in user inquiries
during peak holiday seasons.\nMatter Sales APP (July 2023 - Dec 2024)\nStreamlined dealer-side administration processes,
reducing administrative errors.\nFacilitated access for dealer-side employees to track engagements, resulting in
increase in customer interactions.\nHospital Management System (Apr 2022 - Feb 2023)\nStreamlined patient notes and
transaction management, enhancing data accessibility for healthcare providers.\nImplemented a patient scheduling system
that reduced appointment wait times, enhancing overall patient satisfaction.\nDeveloped a versatile clinic management
system, enabling usage by individual clinics or as a centralized management hub.\nEngineered a multi-module healthcare
application comprising Patient, Doctor, Medicos, Operation, Billing and Test.\nEmployment Website (Jan 2021 - Feb 2022)
\nFacilitated job posting for recruiters, resulting in a 30% increase in candidate applications within six
months.\nImplemented features for CV uploads, education details, and skills, attracting more recruiters to candidate
profiles.\nDeveloped a project comprising three modules: Administration, Recruiter, and Candidate, enhancing workflow
efficiency.\n\n\n",
"createdDate": "2025-04-07"
}

#### case2: Upload pdf file

Request curl:
curl --location 'http://localhost:8080/documents/ingest?title=dillip&author=deepak&type=txt' \
--header 'accept: */*' \
--header 'Content-Type: application/json' \
--form 'file=@"/C:/Users/dilli/OneDrive/文档/new 9.txt"'

Response:
{
"id": 24,
"title": "dillip",
"author": "deepak",
"type": "txt",
"content": "Hello, my name is Dillip Giri, and I am a results-driven Java Developer with over four years of experience in designing and developing \r\nscalable enterprise applications. I specialize in Core Java, Spring Boot, Microservices, and Hibernate, with a strong background in \r\ndatabase-driven applications using MySQL and PostgreSQL. Currently, I am working at Aspida Technologies, where I have contributed to\r\n enhancing service delivery, improving system performance, and streamlining API integrations.\r\n\r\nThroughout my career, I have worked on various impactful projects. For instance, in the Matter Website, I developed key functionalities\r\n like user registration, profile updates, and dealership registrations, improving customer engagement. In the Matter Companion App, \r\n I built features such as ride tracking, remote locking, and vacation mode, enhancing user experience and security. Additionally, \r\n I worked on the Matter Sales App, optimizing dealer-side processes to improve customer interactions.\r\n\r\nI am passionate about building efficient, maintainable, and scalable applications, and\r\n I continuously strive to improve my skills while contributing to high-quality software solutions.\r\n \r\n \r\n Roles and Responsibility\r\n \r\n Designed and developed scalable, high-performance applications using Java, Spring Boot, and Microservices.\r\n Worked with MySQL, PostgreSQL, MongoDB, and ClickHouse DB to ensure efficient data storage and retrieval.\r\n Created RESTful APIs, integrated third-party APIs, and improved system responsiveness.\r\n Enhanced application performance by reducing response times and optimizing database queries.\r\n Wrote unit test cases (JUnit, Jacoco, SonarQube), ensuring high application reliability.\r\n Executed manual deployments across multiple environments, ensuring zero downtime.\r\n Worked in Agile environments using JIRA, collaborating with cross-functional teams for project execution.\r\n Implemented secure authentication and authorization mechanisms.\r\n Assisted in User Acceptance Testing (UAT), providing validation and verification support.",
"createdDate": "2025-04-08"
}


### 2. Keyword-Based Document Q&A

Description: Returns a list of documents relevant to the provided keyword.

#### case1: keyword found successfully in document

curl: curl -X 'POST' \
'http://localhost:8080/documents/qa?keyWord=dillip' \
-H 'accept: */*' \
-d ''

Response:
[
{
"id": 1,
"title": "dillip",
"author": "deepak",
"type": "pdf",
"content": "DILLIP GIRI\r\nSoftware engineer\r\nsdm.dillip@gmail.com 6371684110 Bangalore, 560037, Karnataka\r\nWORK EXPERIENCE\r\nSoftware engineer\r\nAspida Technologies\r\n1st March 2023 - 31st Jan 2025         White Field, Bangalore\r\nImplement innovative strategies at Aspida Technologies, driving a\r\n30% increase in client satisfaction through enhanced service\r\ndelivery.\r\nDeveloped and managed a high-performance database, improving\r\ndata retrieval time.\r\nWrote comprehensive unit test cases for key functionalities,\r\nboosting overall application reliability.\r\nCreated detailed API documentation that improved integration\r\nefficiency, reducing support requests by 25% in six months.\r\nAlong with development, I have contributed to verification and\r\nvalidation for client UAT support.\r\nExecuted manual deployments in five distinct environments,\r\nensuring a 100% success rate and zero downtime during transitions.\r\nImplemented and maintained connections to 10 third-party APIs,\r\nstreamlining data access and improving system responsiveness.\r\nSoftware engineer\r\nVerve Digital Technologies pvt. ltd.\r\n4th Jan 2021 - 03rd Feb 2023 Pune, Maharastra\r\nLeveraged expertise to develop innovative solutions, resulting\r\nincrease in project efficiency.\r\nDeveloped a scalable application using Spring Boot Services,\r\nreducing deployment time and enhancing system performance.\r\nWrote comprehensive unit test cases for key functionalities,\r\nboosting overall application reliability.\r\nIdentified and fixed major bugs, leading to decrease in user-\r\nreported issues within one quarter.\r\nPROJECTS\r\nMatter Website\r\nSoftware Engineer\r\nMar 2023 - Aug 2024\r\nEnabled registration, update profile and login functionality,\r\nincreasing user sign-ups.\r\nFacilitated prebooking for 40,000 users, increasing customer\r\nengagement by 25% and enhancing overall user satisfaction.\r\nFacilitated registration for dealerships, enhancing user\r\nengagement and expanding market reach significantly.\r\nCAREER OBJECTIVE\r\nResults-driven Java Developer with over\r\n4 years of experience in designing,\r\ndeveloping, and implementing scalable\r\nenterprise applications. Proficient in\r\nCore Java, Spring Boot, Microservices,\r\nand Hibernate, with expertise in\r\ndatabase-driven applications using\r\nMySQL and PostgreSQL. Adept at Agile\r\nmethodologies, batch processing, and\r\nversion control with Git. Strong\r\nproblem-solving skills with a focus on\r\nperformance optimization and\r\nmaintainable code. Passionate about\r\ndelivering innovative solutions across\r\nFinancial, E-commerce, Digital Media,\r\nand Healthcare domains while\r\ncollaborating in dynamic environments.\r\nEDUCATION\r\nBachelor of Technology\r\nCivil Engineering\r\nBCET\r\n2013 - 2017\r\nBalasore, Odisha\r\n8.1 CGPA\r\nIntermediate\r\nScience\r\nRIST\r\n2011 - 2013\r\nBasta, Odisha\r\n68%\r\nMatriculation\r\nB.C. High school\r\n2011 - 2011\r\nKasafal, Odisha\r\n56%\r\nSKILLS\r\nJava\r\nImplemented a user-friendly booking system that allowed\r\nregistered users to schedule test rides effortlessly.\r\nMatter Companion APP\r\nSoftware Engineer\r\nMar 2023 - Aug 2024\r\nDeveloped a user-friendly application allowing bike owners to\r\naccess ride details, enhancing customer engagement.\r\nDeveloped a feature enabling users to track bike locations,\r\nachieving a satisfaction rate in user feedback surveys.\r\nEngineered remote lock and unlock capabilities, enhancing\r\nsecurity response.\r\nImplemented vacation mode feature, resulting in reduction in\r\nuser inquiries during peak holiday seasons.\r\nMatter Sales App\r\nSoftware Engineer\r\nNov 2022 - Aug 2024\r\nStreamlined dealer-side administration processes, reducing\r\nadministrative errors.\r\nFacilitated access for dealer-side employees to track\r\nengagements, resulting in increase in customer interactions.\r\nHospital Management System\r\nSoftware Engineer\r\nApril 2022 - Feb 2023\r\nStreamlined patient notes and transaction management,\r\nenhancing data accessibility for healthcare providers.\r\nImplemented a patient scheduling system that reduced\r\nappointment wait times, enhancing overall patient satisfaction.\r\nDeveloped a versatile clinic management system, enabling usage\r\nby individual clinics or as a centralized management hub.\r\nEngineered a multi-module healthcare application comprising\r\nPatient, Doctor, Medicos, Operation, Billing and Test.\r\nEmployment Website\r\nSoftware Engineer\r\nJanuary 2021 - February 2022\r\nFacilitated job posting for recruiters, resulting in a 30% increase in\r\ncandidate applications within six months.\r\nImplemented features for CV uploads, education details, and skills,\r\nattracting more recruiters to candidate profiles.\r\nDeveloped a project comprising three modules: Administration,\r\nRecruiter, and Candidate, enhancing workflow efficiency.\r\nSpring MVC\r\nSpring Boot\r\nSpring Data\r\nSpring ORM\r\nHibernate (JPA)\r\nMicroservices architecture\r\nJDBC\r\nMySQL\r\nPostgreSQL\r\nAgile methodologies\r\nJIRA\r\nApache Tomcat\r\nGit\r\nGitHub\r\nKafka\r\nWebSocket\r\nRest API\r\nMongoDB\r\nClick house DB\r\nSwagger\r\nSonarQube\r\nJacoco\r\nJunit\r\n",
"createdDate": "2025-04-06"
},
{
"id": 22,
"title": "dillip",
"author": "deepak",
"type": "docx",
"content": "Dillip Giri | Software Engineer (Java Backend Developer)\nsdm.dillip@gmail.com +91 6371684110\nSummary \nResults-driven Java Developer with over 4 years of experience in designing, developing, and implementing scalable enterprise applications. Proficient in Core Java, Spring Boot, Microservices, and Hibernate, with expertise in database-driven applications using MySQL and PostgreSQL. Adept at Agile methodologies, batch processing, and version control with Git. Strong problem-solving skills with a focus on performance optimization and maintainable code. Passionate about delivering innovative solutions across Financial, E-commerce, Digital Media, and Healthcare domains while collaborating in dynamic environments.\nEducation \nBachelors of Technology from Biju Pattanaik University of Technology, Rourkela, Odisha (06/2013 - 07/2017) with 8.0 CGPA.\nIntermediate of Science from RIST, Basta, Balasore, Odisha (05/2011 - 05/2013) with 66%.\nMatriculation from B. C. High School, Kasafal, Balasore, Odisha (05/2010 – 05/2011) with 56%.\nWork Experience\nSoftware Engineer – Aspida Technologies                                                                                                            03/2023 - 01/2025\nImplement innovative strategies, driving a 30% increase in client satisfaction through enhanced service delivery.\nDeveloped and managed a high-performance database, improving data retrieval time.\nWrote comprehensive unit test cases for key functionalities, boosting overall application reliability.\nCreated detailed API documentation that improved integration efficiency, reducing support requests by 25%.\nAlong with development, I have contributed to verification and validation for client UAT support.\n\nSoftware Engineer - Verve Digital Technologies Pvt. Ltd. 01/2021 - 02/2023\nLeveraged expertise to develop innovative solutions, resulting increase in project efficiency.\nDeveloped a scalable application using Spring Boot Services, reducing deployment time and enhancing system performance.\nWrote comprehensive unit test cases for key functionalities, boosting overall application reliability.\nIdentified and fixed major bugs, leading to decrease in user-reported issues within one quarter.\n\n.Skills : \nJava, Spring boot, Microservices, MySQL, PostgreSQL, MongoDB, click house DB, Kafka, Junit, REST API, JSP, Servlet, Swagger, Jacoco, SonarQube, Hibernate, JPA, JDBC template, Agile methodologies\nTools: Eclipse, IntelliJ, STS, Postman, JIRA, Share point, Bit Bucket, Git, Pg Admin, MySQL Workbench, dbeaver \nProjects :\nMatter Web Site (Mar 2023 – Dec 2024)\nEnabled registration, update profile and login functionality, increasing user sign-ups.\nFacilitated prebooking for 40,000 users, increasing customer engagement by 25% and enhancing overall user satisfaction.\nImplemented a user-friendly booking system that allowed registered users to schedule test rides effortlessly.\nFacilitated registration for dealerships, enhancing user engagement and expanding market reach significantly.\nMatter Companion APP (Mar 2023 – Dec 2024)\nDeveloped APIs for user-friendly application allowing bike owners to access ride details, enhancing customer engagement.\nFacilitated a feature enabling users to track bike locations, achieving a satisfaction rate in user feedback surveys.\nEnabled remote lock and unlock capabilities, enhancing security response.\nImplemented vacation mode feature, resulting in reduction in user inquiries during peak holiday seasons.\nMatter Sales APP (July 2023 - Dec 2024)\nStreamlined dealer-side administration processes, reducing administrative errors.\nFacilitated access for dealer-side employees to track engagements, resulting in increase in customer interactions.\nHospital Management System (Apr 2022 - Feb 2023)\nStreamlined patient notes and transaction management, enhancing data accessibility for healthcare providers.\nImplemented a patient scheduling system that reduced appointment wait times, enhancing overall patient satisfaction.\nDeveloped a versatile clinic management system, enabling usage by individual clinics or as a centralized management hub.\nEngineered a multi-module healthcare application comprising Patient, Doctor, Medicos, Operation, Billing and Test.\nEmployment Website (Jan 2021 - Feb 2022)\nFacilitated job posting for recruiters, resulting in a 30% increase in candidate applications within six months.\nImplemented features for CV uploads, education details, and skills, attracting more recruiters to candidate profiles.\nDeveloped a project comprising three modules: Administration, Recruiter, and Candidate, enhancing workflow efficiency.\n\n\n",
"createdDate": "2025-04-07"
}
]

case2: for invalid keyword

curl:
curl -X 'POST' \
'http://localhost:8080/documents/qa?keyWord=t5' \
-H 'accept: */*' \
-d ''

response:
[] //emptyList

### 3. Filter Documents with Pagination and Sorting

Description: Returns a paginated and sorted list of documents based on filters.
#### case2: with default value 

curl:
curl -X 'GET' \
'http://localhost:8080/documents/filter?page=0&size=10&sortBy=title' \
-H 'accept: */*'

Response:
{
"content": [
{
"id": 20,
"title": "Broken",
"author": "None",
"type": "txt",
"content": "",
"createdDate": "2025-04-07"
},
{
"id": 22,
"title": "dillip",
"author": "deepak",
"type": "docx",
"content": "Dillip Giri | Software Engineer (Java Backend Developer)\nsdm.dillip@gmail.com                                                                  +91 6371684110\nSummary \nResults-driven Java Developer with over 4 years of experience in designing, developing, and implementing scalable enterprise applications. Proficient in Core Java, Spring Boot, Microservices, and Hibernate, with expertise in database-driven applications using MySQL and PostgreSQL. Adept at Agile methodologies, batch processing, and version control with Git. Strong problem-solving skills with a focus on performance optimization and maintainable code. Passionate about delivering innovative solutions across Financial, E-commerce, Digital Media, and Healthcare domains while collaborating in dynamic environments.\nEducation \nBachelors of Technology from Biju Pattanaik University of Technology, Rourkela, Odisha (06/2013 - 07/2017) with 8.0 CGPA.\nIntermediate of Science from RIST, Basta, Balasore, Odisha (05/2011 - 05/2013) with 66%.\nMatriculation from B. C. High School, Kasafal, Balasore, Odisha (05/2010 – 05/2011) with 56%.\nWork Experience\nSoftware Engineer – Aspida Technologies                                                                                                            03/2023 - 01/2025\nImplement innovative strategies, driving a 30% increase in client satisfaction through enhanced service delivery.\nDeveloped and managed a high-performance database, improving data retrieval time.\nWrote comprehensive unit test cases for key functionalities, boosting overall application reliability.\nCreated detailed API documentation that improved integration efficiency, reducing support requests by 25%.\nAlong with development, I have contributed to verification and validation for client UAT support.\n\nSoftware Engineer - Verve Digital Technologies Pvt. Ltd.                                                                                   01/2021 - 02/2023\nLeveraged expertise to develop innovative solutions, resulting increase in project efficiency.\nDeveloped a scalable application using Spring Boot Services, reducing deployment time and enhancing system performance.\nWrote comprehensive unit test cases for key functionalities, boosting overall application reliability.\nIdentified and fixed major bugs, leading to decrease in user-reported issues within one quarter.\n\n.Skills : \nJava, Spring boot, Microservices, MySQL, PostgreSQL, MongoDB, click house DB, Kafka, Junit, REST API, JSP, Servlet, Swagger, Jacoco, SonarQube, Hibernate, JPA, JDBC template, Agile methodologies\nTools: Eclipse, IntelliJ, STS, Postman, JIRA, Share point, Bit Bucket, Git, Pg Admin, MySQL Workbench, dbeaver \nProjects :\nMatter Web Site (Mar 2023 – Dec 2024)\nEnabled registration, update profile and login functionality, increasing user sign-ups.\nFacilitated prebooking for 40,000 users, increasing customer engagement by 25% and enhancing overall user satisfaction.\nImplemented a user-friendly booking system that allowed registered users to schedule test rides effortlessly.\nFacilitated registration for dealerships, enhancing user engagement and expanding market reach significantly.\nMatter Companion APP (Mar 2023 – Dec 2024)\nDeveloped APIs for user-friendly application allowing bike owners to access ride details, enhancing customer engagement.\nFacilitated a feature enabling users to track bike locations, achieving a satisfaction rate in user feedback surveys.\nEnabled remote lock and unlock capabilities, enhancing security response.\nImplemented vacation mode feature, resulting in reduction in user inquiries during peak holiday seasons.\nMatter Sales APP (July 2023 - Dec 2024)\nStreamlined dealer-side administration processes, reducing administrative errors.\nFacilitated access for dealer-side employees to track engagements, resulting in increase in customer interactions.\nHospital Management System (Apr 2022 - Feb 2023)\nStreamlined patient notes and transaction management, enhancing data accessibility for healthcare providers.\nImplemented a patient scheduling system that reduced appointment wait times, enhancing overall patient satisfaction.\nDeveloped a versatile clinic management system, enabling usage by individual clinics or as a centralized management hub.\nEngineered a multi-module healthcare application comprising Patient, Doctor, Medicos, Operation, Billing and Test.\nEmployment Website (Jan 2021 - Feb 2022)\nFacilitated job posting for recruiters, resulting in a 30% increase in candidate applications within six months.\nImplemented features for CV uploads, education details, and skills, attracting more recruiters to candidate profiles.\nDeveloped a project comprising three modules: Administration, Recruiter, and Candidate, enhancing workflow efficiency.\n\n\n",
"createdDate": "2025-04-07"
},
{
"id": 1,
"title": "dillip",
"author": "deepak",
"type": "pdf",
"content": "DILLIP GIRI\r\nSoftware engineer\r\nsdm.dillip@gmail.com 6371684110 Bangalore, 560037, Karnataka\r\nWORK EXPERIENCE\r\nSoftware engineer\r\nAspida Technologies\r\n1st March 2023 - 31st Jan 2025         White Field, Bangalore\r\nImplement innovative strategies at Aspida Technologies, driving a\r\n30% increase in client satisfaction through enhanced service\r\ndelivery.\r\nDeveloped and managed a high-performance database, improving\r\ndata retrieval time.\r\nWrote comprehensive unit test cases for key functionalities,\r\nboosting overall application reliability.\r\nCreated detailed API documentation that improved integration\r\nefficiency, reducing support requests by 25% in six months.\r\nAlong with development, I have contributed to verification and\r\nvalidation for client UAT support.\r\nExecuted manual deployments in five distinct environments,\r\nensuring a 100% success rate and zero downtime during transitions.\r\nImplemented and maintained connections to 10 third-party APIs,\r\nstreamlining data access and improving system responsiveness.\r\nSoftware engineer\r\nVerve Digital Technologies pvt. ltd.\r\n4th Jan 2021 - 03rd Feb 2023 Pune, Maharastra\r\nLeveraged expertise to develop innovative solutions, resulting\r\nincrease in project efficiency.\r\nDeveloped a scalable application using Spring Boot Services,\r\nreducing deployment time and enhancing system performance.\r\nWrote comprehensive unit test cases for key functionalities,\r\nboosting overall application reliability.\r\nIdentified and fixed major bugs, leading to decrease in user-\r\nreported issues within one quarter.\r\nPROJECTS\r\nMatter Website\r\nSoftware Engineer\r\nMar 2023 - Aug 2024\r\nEnabled registration, update profile and login functionality,\r\nincreasing user sign-ups.\r\nFacilitated prebooking for 40,000 users, increasing customer\r\nengagement by 25% and enhancing overall user satisfaction.\r\nFacilitated registration for dealerships, enhancing user\r\nengagement and expanding market reach significantly.\r\nCAREER OBJECTIVE\r\nResults-driven Java Developer with over\r\n4 years of experience in designing,\r\ndeveloping, and implementing scalable\r\nenterprise applications. Proficient in\r\nCore Java, Spring Boot, Microservices,\r\nand Hibernate, with expertise in\r\ndatabase-driven applications using\r\nMySQL and PostgreSQL. Adept at Agile\r\nmethodologies, batch processing, and\r\nversion control with Git. Strong\r\nproblem-solving skills with a focus on\r\nperformance optimization and\r\nmaintainable code. Passionate about\r\ndelivering innovative solutions across\r\nFinancial, E-commerce, Digital Media,\r\nand Healthcare domains while\r\ncollaborating in dynamic environments.\r\nEDUCATION\r\nBachelor of Technology\r\nCivil Engineering\r\nBCET\r\n2013 - 2017\r\nBalasore, Odisha\r\n8.1 CGPA\r\nIntermediate\r\nScience\r\nRIST\r\n2011 - 2013\r\nBasta, Odisha\r\n68%\r\nMatriculation\r\nB.C. High school\r\n2011 - 2011\r\nKasafal, Odisha\r\n56%\r\nSKILLS\r\nJava\r\nImplemented a user-friendly booking system that allowed\r\nregistered users to schedule test rides effortlessly.\r\nMatter Companion APP\r\nSoftware Engineer\r\nMar 2023 - Aug 2024\r\nDeveloped a user-friendly application allowing bike owners to\r\naccess ride details, enhancing customer engagement.\r\nDeveloped a feature enabling users to track bike locations,\r\nachieving a satisfaction rate in user feedback surveys.\r\nEngineered remote lock and unlock capabilities, enhancing\r\nsecurity response.\r\nImplemented vacation mode feature, resulting in reduction in\r\nuser inquiries during peak holiday seasons.\r\nMatter Sales App\r\nSoftware Engineer\r\nNov 2022 - Aug 2024\r\nStreamlined dealer-side administration processes, reducing\r\nadministrative errors.\r\nFacilitated access for dealer-side employees to track\r\nengagements, resulting in increase in customer interactions.\r\nHospital Management System\r\nSoftware Engineer\r\nApril 2022 - Feb 2023\r\nStreamlined patient notes and transaction management,\r\nenhancing data accessibility for healthcare providers.\r\nImplemented a patient scheduling system that reduced\r\nappointment wait times, enhancing overall patient satisfaction.\r\nDeveloped a versatile clinic management system, enabling usage\r\nby individual clinics or as a centralized management hub.\r\nEngineered a multi-module healthcare application comprising\r\nPatient, Doctor, Medicos, Operation, Billing and Test.\r\nEmployment Website\r\nSoftware Engineer\r\nJanuary 2021 - February 2022\r\nFacilitated job posting for recruiters, resulting in a 30% increase in\r\ncandidate applications within six months.\r\nImplemented features for CV uploads, education details, and skills,\r\nattracting more recruiters to candidate profiles.\r\nDeveloped a project comprising three modules: Administration,\r\nRecruiter, and Candidate, enhancing workflow efficiency.\r\nSpring MVC\r\nSpring Boot\r\nSpring Data\r\nSpring ORM\r\nHibernate (JPA)\r\nMicroservices architecture\r\nJDBC\r\nMySQL\r\nPostgreSQL\r\nAgile methodologies\r\nJIRA\r\nApache Tomcat\r\nGit\r\nGitHub\r\nKafka\r\nWebSocket\r\nRest API\r\nMongoDB\r\nClick house DB\r\nSwagger\r\nSonarQube\r\nJacoco\r\nJunit\r\n",
"createdDate": "2025-04-06"
},
{
"id": 7,
"title": "Sample Title",
"author": "Sample Author",
"type": "pdf",
"content": "test content",
"createdDate": "2025-04-07"
},
{
"id": 6,
"title": "Sample Title",
"author": "Sample Author",
"type": "pdf",
"content": "Test content",
"createdDate": "2025-04-07"
},
{
"id": 13,
"title": "Sample Title",
"author": "Sample Author",
"type": "pdf",
"content": "test content",
"createdDate": "2025-04-07"
},
{
"id": 15,
"title": "Sample Title",
"author": "Sample Author",
"type": "pdf",
"content": "test content",
"createdDate": "2025-04-07"
},
{
"id": 9,
"title": "Sample Title",
"author": "Sample Author",
"type": "pdf",
"content": "test content",
"createdDate": "2025-04-07"
},
{
"id": 11,
"title": "Sample Title",
"author": "Sample Author",
"type": "pdf",
"content": "test content",
"createdDate": "2025-04-07"
},
{
"id": 21,
"title": "Test Document",
"author": "John Doe",
"type": "txt",
"content": "Hello, this is a test document.",
"createdDate": "2025-04-07"
}
],
"pageable": {
"pageNumber": 0,
"pageSize": 10,
"sort": {
"empty": false,
"sorted": true,
"unsorted": false
},
"offset": 0,
"paged": true,
"unpaged": false
},
"last": false,
"totalElements": 21,
"totalPages": 3,
"first": true,
"size": 10,
"number": 0,
"sort": {
"empty": false,
"sorted": true,
"unsorted": false
},
"numberOfElements": 10,
"empty": false
}


#### case2: for valid input

curl:
curl -X 'GET' \
'http://localhost:8080/documents/filter?author=deepak&type=pdf&page=0&size=10&sortBy=title' \
-H 'accept: */*'

Response:
{
"content": [
{
"id": 1,
"title": "dillip",
"author": "deepak",
"type": "pdf",
"content": "DILLIP GIRI\r\nSoftware engineer\r\nsdm.dillip@gmail.com 6371684110 Bangalore, 560037, Karnataka\r\nWORK EXPERIENCE\r\nSoftware engineer\r\nAspida Technologies\r\n1st March 2023 - 31st Jan 2025         White Field, Bangalore\r\nImplement innovative strategies at Aspida Technologies, driving a\r\n30% increase in client satisfaction through enhanced service\r\ndelivery.\r\nDeveloped and managed a high-performance database, improving\r\ndata retrieval time.\r\nWrote comprehensive unit test cases for key functionalities,\r\nboosting overall application reliability.\r\nCreated detailed API documentation that improved integration\r\nefficiency, reducing support requests by 25% in six months.\r\nAlong with development, I have contributed to verification and\r\nvalidation for client UAT support.\r\nExecuted manual deployments in five distinct environments,\r\nensuring a 100% success rate and zero downtime during transitions.\r\nImplemented and maintained connections to 10 third-party APIs,\r\nstreamlining data access and improving system responsiveness.\r\nSoftware engineer\r\nVerve Digital Technologies pvt. ltd.\r\n4th Jan 2021 - 03rd Feb 2023 Pune, Maharastra\r\nLeveraged expertise to develop innovative solutions, resulting\r\nincrease in project efficiency.\r\nDeveloped a scalable application using Spring Boot Services,\r\nreducing deployment time and enhancing system performance.\r\nWrote comprehensive unit test cases for key functionalities,\r\nboosting overall application reliability.\r\nIdentified and fixed major bugs, leading to decrease in user-\r\nreported issues within one quarter.\r\nPROJECTS\r\nMatter Website\r\nSoftware Engineer\r\nMar 2023 - Aug 2024\r\nEnabled registration, update profile and login functionality,\r\nincreasing user sign-ups.\r\nFacilitated prebooking for 40,000 users, increasing customer\r\nengagement by 25% and enhancing overall user satisfaction.\r\nFacilitated registration for dealerships, enhancing user\r\nengagement and expanding market reach significantly.\r\nCAREER OBJECTIVE\r\nResults-driven Java Developer with over\r\n4 years of experience in designing,\r\ndeveloping, and implementing scalable\r\nenterprise applications. Proficient in\r\nCore Java, Spring Boot, Microservices,\r\nand Hibernate, with expertise in\r\ndatabase-driven applications using\r\nMySQL and PostgreSQL. Adept at Agile\r\nmethodologies, batch processing, and\r\nversion control with Git. Strong\r\nproblem-solving skills with a focus on\r\nperformance optimization and\r\nmaintainable code. Passionate about\r\ndelivering innovative solutions across\r\nFinancial, E-commerce, Digital Media,\r\nand Healthcare domains while\r\ncollaborating in dynamic environments.\r\nEDUCATION\r\nBachelor of Technology\r\nCivil Engineering\r\nBCET\r\n2013 - 2017\r\nBalasore, Odisha\r\n8.1 CGPA\r\nIntermediate\r\nScience\r\nRIST\r\n2011 - 2013\r\nBasta, Odisha\r\n68%\r\nMatriculation\r\nB.C. High school\r\n2011 - 2011\r\nKasafal, Odisha\r\n56%\r\nSKILLS\r\nJava\r\nImplemented a user-friendly booking system that allowed\r\nregistered users to schedule test rides effortlessly.\r\nMatter Companion APP\r\nSoftware Engineer\r\nMar 2023 - Aug 2024\r\nDeveloped a user-friendly application allowing bike owners to\r\naccess ride details, enhancing customer engagement.\r\nDeveloped a feature enabling users to track bike locations,\r\nachieving a satisfaction rate in user feedback surveys.\r\nEngineered remote lock and unlock capabilities, enhancing\r\nsecurity response.\r\nImplemented vacation mode feature, resulting in reduction in\r\nuser inquiries during peak holiday seasons.\r\nMatter Sales App\r\nSoftware Engineer\r\nNov 2022 - Aug 2024\r\nStreamlined dealer-side administration processes, reducing\r\nadministrative errors.\r\nFacilitated access for dealer-side employees to track\r\nengagements, resulting in increase in customer interactions.\r\nHospital Management System\r\nSoftware Engineer\r\nApril 2022 - Feb 2023\r\nStreamlined patient notes and transaction management,\r\nenhancing data accessibility for healthcare providers.\r\nImplemented a patient scheduling system that reduced\r\nappointment wait times, enhancing overall patient satisfaction.\r\nDeveloped a versatile clinic management system, enabling usage\r\nby individual clinics or as a centralized management hub.\r\nEngineered a multi-module healthcare application comprising\r\nPatient, Doctor, Medicos, Operation, Billing and Test.\r\nEmployment Website\r\nSoftware Engineer\r\nJanuary 2021 - February 2022\r\nFacilitated job posting for recruiters, resulting in a 30% increase in\r\ncandidate applications within six months.\r\nImplemented features for CV uploads, education details, and skills,\r\nattracting more recruiters to candidate profiles.\r\nDeveloped a project comprising three modules: Administration,\r\nRecruiter, and Candidate, enhancing workflow efficiency.\r\nSpring MVC\r\nSpring Boot\r\nSpring Data\r\nSpring ORM\r\nHibernate (JPA)\r\nMicroservices architecture\r\nJDBC\r\nMySQL\r\nPostgreSQL\r\nAgile methodologies\r\nJIRA\r\nApache Tomcat\r\nGit\r\nGitHub\r\nKafka\r\nWebSocket\r\nRest API\r\nMongoDB\r\nClick house DB\r\nSwagger\r\nSonarQube\r\nJacoco\r\nJunit\r\n",
"createdDate": "2025-04-06"
}
],
"pageable": {
"pageNumber": 0,
"pageSize": 10,
"sort": {
"empty": false,
"sorted": true,
"unsorted": false
},
"offset": 0,
"paged": true,
"unpaged": false
},
"totalElements": 1,
"totalPages": 1,
"last": true,
"size": 10,
"number": 0,
"sort": {
"empty": false,
"sorted": true,
"unsorted": false
},
"numberOfElements": 1,
"first": true,
"empty": false
}

#### case1: for invalid input

curl -X 'GET' \
'http://localhost:8080/documents/filter?author=manoj&type=pdf&page=0&size=10&sortBy=author' \
-H 'accept: */*'

Response:
{
"content": [],
"pageable": {
"pageNumber": 0,
"pageSize": 10,
"sort": {
"empty": false,
"sorted": true,
"unsorted": false
},
"offset": 0,
"paged": true,
"unpaged": false
},
"last": true,
"totalPages": 0,
"totalElements": 0,
"first": true,
"size": 10,
"number": 0,
"sort": {
"empty": false,
"sorted": true,
"unsorted": false
},
"numberOfElements": 0,
"empty": true
}

Above-mentioned are some test scenarios we can have more corner case scenarios.





