#Glue

Serverless Queries
Event trigger ETL jobs

One of the most useful things about Glue is that its default timeout is two days — unlike Lambda’s max of 15 minutes. 

Glue Intro
https://www.youtube.com/watch?v=Qpv7BzOM-UI

# Terminology

## Data Catalog  
	The data catalog holds the metadata and the structure of the data.

  Persistent metadata store in AWS Glue,It contains 
  Table definition
  Job Definition
  
  Each AWS account has one Data Catalog per region. 

- Database
	It is used to create or access the database for the sources and targets.

- Table 
	Create one or more tables in the database that can be used by the source and target.
	a Glue table tells you where the data is located and what data fields and types you should find there. 
	Glue tables can describe file-based data stored in S3, such as Parquet, CSV, or JSON, as well as data in traditional datastores like RDS tables. 
	The latter sources need to be connected and crawled in order to be accessible.

- Connection
	create a verified link between Glue and RDS (Postgres, MySQL, etc), Redshift, or JDBC instances, and allow Glue to access the data stored there.

- Classifier
  AWS provides Classifier for common types such as 
  CSV
  JSON
  Parquet
  XML
  AVRO
  
  It also provides classifier for common data bases using JDBC connection
  Custom classifier can be written in grok pattern or row tab in an XML document


- Crawler
	A crawler is used to retrieve data from the source using built-in or custom classifiers. 
	It creates/uses metadata tables that are pre-defined in the data catalog.

## ETL

Job
	A job is business logic that carries out an ETL task. Internally, Apache Spark with python or scala language writes this business logic.


Trigger 
	A trigger starts the ETL job execution on-demand or at a specific time.
	
	
Development Endpoint
	It creates a development environment where the ETL job script can be tested, developed, and debugged.


Notebook Server 
   This is basically like jypyter which uses development endpoint to run Spark jobs in UI	



Data Store 

Data Source

Data Target



Spark Glue job development in VS Code
https://www.youtube.com/watch?v=EzQArFt_On4


https://towardsdatascience.com/aws-glue-101-all-you-need-to-know-with-a-real-world-example-f34af17b782f


# Local setup on VS Code and docker 

https://github.com/ozbe/aws-glue-libs-vscode-remote-container



------------------------
https://www.factspan.com/set-up-a-development-environment-for-pyspark/

https://medium.com/dataengineerbr/how-to-run-aws-glue-jobs-on-your-own-computer-using-docker-vscode-and-jupyter-notebook-780c9305d804


Metrices 
https://www.mikulskibartosz.name/send-metrics-to-aws-cloudwatch-from-Python/

https://stackify.com/custom-metrics-aws-lambda/



