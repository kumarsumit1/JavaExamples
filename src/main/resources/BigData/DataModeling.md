Types of Schema

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




## SCD: Slowly changing dimensions



## Special Data Types 
Geospatial
Temporal --> alternative SCD
Time series -->