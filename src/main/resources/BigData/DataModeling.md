# Choosing the right Database:

https://www.youtube.com/watch?v=Rk0h7Jd1WGQ

https://www.youtube.com/watch?v=KWOSGVtHWqA

Introduction of NO SQL 
https://www.youtube.com/watch?v=qI_g07C_Q5I


Intro to cassandra
https://www.youtube.com/watch?v=B_HTdrTgGNs


Comparing Cassandra with other NO SQL DB, feature wise .
https://www.youtube.com/watch?v=G8xHwnCevYo

Basic intro of most  NO SQL DB
https://www.youtube.com/watch?v=K4Ve9BvUJBk


Distributed Systems in One Lesson
https://www.youtube.com/watch?v=Y6Ev8GIlbxc


### CAP Theorem

https://medium.com/swlh/cap-theorem-in-distributed-systems-edd967e7bdf4

### PACELC (pass-elk) theorem
It highlights how CAP theorm only talks about failures .

A more complete portrayal of the space of potential consistency tradeoffs for DDBSs can be achieved by rewriting CAP 
as PACELC (pronounced “pass-elk”): if there is a partition (P), how does the system trade off availability and
consistency (A and C); else (E), when the system is running normally in the absence of partitions, how does the 
system trade off latency (L) and consistency (C)? 

https://www.cs.umd.edu/~abadi/papers/abadi-pacelc.pdf

## SCD: Slowly changing dimensions

https://github.com/cartershanklin/hive-scd-examples

## CDC 
The ability to capture only the changed source data and to move it from a source to a target system(s) is known as Change Data Capture (CDC).

## SCD VS CDC
CDC is used to extract
SCD is used to update

## Types of Schema

### 3NF
- first normal form, ensures that every column attribute only holds one value.
- second normal form, ensures that every column is dependent on the primary key, or more specifically that the table serves a single purpose.
- third normal form, ensures that non-key attributes are dependent on nothing but the primary key. The more technical explanation involves "transitive dependencies" .

normalization helps ensure:

    Data is not unnecessarily repeated within a database.
    Inserts, modifications, and deletions only have to happen once in a database.

Link : https://dzone.com/articles/third-normal-form-star-schema-and-a-performance-ce

### Star Schema
https://www.youtube.com/watch?v=KUwOcip7Zzc

Link : https://docs.oracle.com/cd/B10500_01/server.920/a96520/schemas.htm

### Snowflake Schema








## Special Data Types 

###Geospatial
Types of geoSpatial objects
    Point
    LineString
    Polygon
    MultiPoint
    MultiLineString
    MultiPolygon
    GeometryCollection


To generate GeoJson http://geojson.io/ , 

GeoSpatial operations
  - nearSphere
  - geoWithin
  - geoIntersects
  
https://www.youtube.com/watch?v=V8LNyiBACLo



Temporal -->a temporal database can establish at what times certain entries are accurate. alternative SCD
Time series -->


# NoSQL

Types of NoSQL DB
1. Key Value
2. Document
3. Column Family
4. Graph