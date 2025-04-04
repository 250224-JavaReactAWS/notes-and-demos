# AWS Overview

## What is Cloud Computing?
Cloud computing is the on-demand delivery of compute power, database storage, applications and other IT resources through a cloud services platform via the Internet with pay-as-you-go pricing.

Cloud computing provides a simple way to access servers, storage, databases and a broad set of application services over the Internet.  

## 6 Advantages of Cloud Computing

1. Trade capital expense for variable expense.
2. Benefit from massive economies of scale.
3. Stop guessing about capacity.
4. Increase speed and agility.
5. Eliminate overhead cost of maintaining data centers
6. Go global in minutes.

### Trade capital expense for variable expense
Instead of having to invest heavily in data centers and servers before you know how you’re going to use them, you can pay only when you consume computing resources, and pay only for how much you consume.

### Benefit from massive economies of scale
By using cloud computing, you can achieve a lower variable cost than you can get on your own. Because usage from hundreds of thousands of customers is aggregated in the cloud, providers such as AWS can achieve higher economies of scale, which translates into lower pay as-you-go price.

### Stop guessing about capacity
Eliminate guessing on your infrastructure capacity needs. When you make a capacity decision prior to deploying an application, you often end up either sitting on expensive idle resources or dealing with limited capacity.

### Increase speed and agility
In a cloud computing environment, new IT resources are only a click away, which means that you reduce the time to make those resources available to your developers from weeks to just minutes.

### Eliminate overhead cost of maintaining data centers
Cloud computing lets you focus on your own customers, rather than on the heavy lifting of racking, stacking, and powering servers (infrastructure).

### Go global in minutes
Easily deploy your application in multiple regions around the world with just a few clicks. This means you can provide lower latency and a better experience for your customers at minimal cost.

## Paying for Cloud Services
AWS offers you a **pay-as-you-go** approach for pricing for over 160 cloud services.  With AWS you pay only for the individual services you need, for as long as you use them, and without requiring long-term contracts or complex licensing. 

* You can also use [AWS Billing and Cost Management](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/billing-what-is.html)


## 3 Models of Cloud Computing

### Infrastructure as a Service (IaaS)
Infrastructure as a Service (IaaS) is a self-service model for managing remote data center infrastructures.
AWS offers IaaS in the form of data centers.

### Platform as a Service (PaaS)
Platform as a Service (PaaS) allows organizations to build, run and manage applications without the IT infrastructure. This makes it easier and faster to develop, test and deploy applications. 

### Software as a Service (SaaS)
Software as a service (SaaS) replaces the traditional on-device software with software that is licensed on a subscription basis. It is centrally hosted in the cloud. A good example is Salesforce.com.


### Other Major Cloud Providers
* [Microsoft Azure](https://azure.microsoft.com/en-us/)
* [Google Cloud Platform (GCP)](https://cloud.google.com/gcp/?utm_source=google&utm_medium=cpc&utm_campaign=na-US-all-en-dr-bkws-all-all-trial-e-dr-1009135&utm_content=text-ad-lpsitelinkCCexp2-any-DEV_c-CRE_113120492887-ADGP_Hybrid+%7C+AW+SEM+%7C+BKWS+%7C+US+%7C+en+%7C+EXA+~+Google+Cloud+Platform-KWID_43700009942847400-kwd-26415313501&utm_term=KW_google%20cloud%20platform-ST_google+cloud+platform&&gclid=Cj0KCQjwoJX8BRCZARIsAEWBFMIKqoP4b6G-3OlpQkCrVvMoAvss3kNL_2joyIs7N42TL-2WZRBCUaoaApspEALw_wcB)

# RDS Overview

## What Is Amazon Relational Database Service (Amazon RDS)?
Amazon Relational Database Service (Amazon RDS) is a web service that makes it easier to set up, operate, and scale a relational database in the AWS Cloud. It provides cost-efficient, resizable capacity for an industry-standard relational database and manages common database administration tasks.
<br />

* RDS **automates** expensive and time consuming tasks such as managing backups, software patching, automatic failure detection, and recovery.  

* You can help control who can access your RDS databases by using **AWS Identity and Access Management (IAM)** to define users and permissions.  

* RDS is available on several **database instance types**.  **Instance types** comprise varying combinations of CPU, memory, storage, and networking capacity and give you the flexibility to choose the appropriate mix of resources for your database.
    * Examples of instance types include `T3`, `T2`, `M6g`, `M5`, etc...You can read more about instance types [here](https://aws.amazon.com/rds/instance-types/).  

* RDS is **free to try** and you will be charged based on how much computational power you use per month (pay-as-you-go).  

* RDS provides you with six familiar database engines to choose from, including Amazon Aurora, PostgreSQL, MySQL, MariaDB, Oracle Database, and SQL Server. 

## Why Use RDS?
It's important to distinguish AWS RDS from *other database solutions offered through AWS*.

* AWS offers 15 database engines including *relational, key-value, document, in-memory, graph, time series, and ledger databases*.  

* With **RDS**, you don’t need to worry about database management tasks such as server provisioning, patching, setup, configuration, backups, or recovery. The RDS manages this for you.  

* **RDS** is a **relational** database service, therefore it organizes data within tables in rows and columns.  Compare this to non-relational or NoSQL databases which use different mechanisms to store and retrieve data through key-value pairs, document models, etc.  


## Regions & Availability Zones
* An **AWS Region** is a highly available data center that houses Amazon cloud computing resources in different areas of the world (for example, North America, Europe, or Asia).  

* Each AWS Region contains multiple distinct locations called **Availability Zones**, or AZs.  

* Each Availability Zone is engineered to be isolated from failures in other Availability Zones. Each is engineered to provide inexpensive, low-latency network connectivity to other Availability Zones in the same AWS Region. 

* By launching instances in separate Availability Zones, you can protect your applications from the failure of a single location.  This makes AWS fault-tolerant.
    * **Fault-tolerance** defines the ability for a system to remain in operation even if some of the components used to build the system fail.

## Security
* A **security group** controls the access to a DB instance. It does so by allowing access to IP address ranges or Amazon EC2 instances that you specify.

* You can set security groups when configuring your RDS instance.  


## How to Interact with Amazon RDS
There are several ways that you can interact with Amazon RDS.
### 1. AWS Management Console
You can manage your DB instances from the console with no programming required. To access the Amazon RDS console, sign in to the AWS Management Console and open the Amazon RDS console at <a href="https://signin.aws.amazon.com/signin?redirect_uri=https%3A%2F%2Fconsole.aws.amazon.com%2Frds%2F%3Fstate%3DhashArgs%2523%26isauthcode%3Dtrue&client_id=arn%3Aaws%3Aiam%3A%3A015428540659%3Auser%2Frds&forceMobileApp=0">https://console.aws.amazon.com/rds/</a>

### 2. Command Line Interface
You can use the AWS Command Line Interface (AWS CLI) to access the Amazon RDS API interactively.  Install the AWS CLI [here](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-install.html).  To begin using the AWS CLI with RDS, view the [AWS CLI Command Reference](https://docs.aws.amazon.com/cli/latest/reference/rds/index.html).

### 3. Programatically Accessing Amazon RDS
While developing an application, developers may use the *AWS Software Development Kits (SDKs)* and utilize the [RDS Application Programming Interface (API)](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/ProgrammingGuide.html) to automate tasks for managing DB instances and other objects in Amazon RDS.