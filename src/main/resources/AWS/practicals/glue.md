#Glue

Serverless Queries
Event trigger ETL jobs

Glue Intro
https://www.youtube.com/watch?v=Qpv7BzOM-UI

# Terminology

Data Catalog  
  Persistent metadata store in AWS Glue,It contains 
  Table definition
  Job Definition
  
  Each AWS account has one Data Catalog per region. 
  

Classifier
  AWS provides Classifier for common types such as 
  CSV
  JSON
  Parquet
  XML
  AVRO
  
  It also provides classifier for common data bases using JDBC connection
  Custom classifier can be written in grok pattern or row tab in an XML document


Connection

Crawler

Job

Database

Data Store

Data Source

Data Target

Development Endpoint


Notebook Server 
   This is basically like jypyter which uses development endpoint to run Spark jobs in UI

Spark Glue job development in VS Code
https://www.youtube.com/watch?v=EzQArFt_On4