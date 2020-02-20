# [AWS Service catalog](https://www.parkmycloud.com/aws-services-list/)

## Serverless

### Lambda :
    Lets you run code without provisioning or managing servers
    You can run code for virtually any type of application or backend service – all with zero administration.
    Upload your code and Lambda takes care of everything required to run and scale your code with high availability. 

### ECS :
    Amazon ECS (which stands for Elastic Container Service) lets you run Docker containers without having to manage the orchestration of those containers. With ECS, you can deploy your containers on EC2 servers or in a serverless mode, which Amazon calls Fargate. Both deployment types handle the orchestration and underlying server management for you, so you can just schedule and deploy your containers.    
### Athena : 
    An interactive query service that makes it easy to analyze data in Amazon S3 using standard SQL.
    Athena is serverless so there is no infrastructure to manage

### Glue :
    Extract, transform, and load (ETL) service that makes it easy for customers to prepare and load their data for analytics
    You can create and run an ETL job with a few clicks in the AWS Management Console. You simply point AWS Glue to your data stored on AWS, and AWS Glue discovers your data and stores the associated metadata (e.g. table definition and schema) in the AWS Glue Data Catalog

## Cluster/Compute

### EMR :
    Provides a managed Hadoop framework that makes it easy, fast, and cost-effective to process vast amounts of data across dynamically scalable Amazon EC2 instances. Run and Scale Apache Spark, Hadoop, HBase, Presto, Hive, and other Big Data Frameworks


## Databases

### Amazon RDS 

    Makes it easy to set up, operate, and scale a relational database in the cloud.
    Provides cost-efficient and resizable capacity while automating time-consuming administration tasks such as hardware provisioning, database setup, patching and backups. 

### Amazon Aurora

    A MySQL and PostgreSQL-compatible relational database built for the cloud, that combines the performance and availability of traditional enterprise databases with the simplicity and cost-effectiveness of open source databases
    Provides the security, availability, and reliability of commercial databases at 1/10th the cost.
    Fully managed by Amazon Relational Database Service (RDS), which automates time-consuming administration tasks like hardware provisioning, database setup, patching, and backups.

### Dynamo DB :
    A key-value and document database that delivers single-digit millisecond performance at any scale.
    It’s a fully managed, multiregion, multimaster database with built-in security, backup and restore, and in-memory caching for internet-scale applications.
    Supports some of the world’s largest scale applications by providing consistent, single-digit millisecond response times at any scale. 

## Messaging/Queing/Notification Platforms

### Amazon Kinesis

    Makes it easy to collect, process, and analyze real-time, streaming data so you can get timely insights and react quickly to new information
    Offers key capabilities to cost-effectively process streaming data at any scale, along with the flexibility to choose the tools that best suit the requirements of your application
    You can ingest real-time data such as video, audio, application logs, website clickstreams, and IoT telemetry data for machine learning, analytics, and other applications. 

### Amazon Simple Queue Service (SQS)

    Message queuing service that enables you to decouple and scale microservices, distributed systems, and serverless applications.
    Eliminates the complexity and overhead associated with managing and operating message oriented middleware, and empowers developers to focus on differentiating work.
    Using SQS, you can send, store, and receive messages between software components at any volume, without losing messages or requiring other services to be available

### Amazon Simple Notification Service (SNS) 

    Durable, secure, fully managed pub/sub messaging service that enables you to decouple microservices, distributed systems, and serverless applications
    Provides topics for high-throughput, push-based, many-to-many messaging

### Amazon MQ 

    Managed message broker service for Apache ActiveMQ that makes it easy to set up and operate message brokers in the cloud.
    Reduces your operational load by managing the provisioning, setup, and maintenance of ActiveMQ, a popular open-source message broker

## Application Integration

### Amazon API Gateway

    Makes it easy for developers to create, publish, maintain, monitor, and secure APIs at any scale.
    Handles all the tasks involved in accepting and processing up to hundreds of thousands of concurrent API calls, including traffic management, authorization and access control, monitoring, and API version management