# Sqoop
List of Sqoop Tools are :
```
$ sqoop help
usage: sqoop COMMAND [ARGS]

Available commands:
  codegen            Generate code to interact with database records
  create-hive-table  Import a table definition into Hive
  eval               Evaluate a SQL statement and display the results
  export             Export an HDFS directory to a database table
  help               List available commands
  import             Import a table from a database to HDFS
  import-all-tables  Import tables from a database to HDFS
  import-mainframe   Import mainframe datasets to HDFS
  list-databases     List available databases on a server
  list-tables        List available tables in a database
  version            Display version information
 ``` 
  

## Syntax structure
$ sqoop help import \
usage: sqoop import [GENERIC-ARGS] [TOOL-ARGS]

***Note that generic Hadoop arguments are preceeded by a single dash character (-), whereas tool-specific arguments start with two dashes (--), unless they are single character arguments such as -P.***
```
Generic options supported are 
-conf <configuration file>     					specify an application configuration file 
-D <property=value>            					use value for given property 
-fs <local|namenode:port>      					specify a namenode 
-jt <local|jobtracker:port>    					specify a job tracker  
-files <comma separated list of files>    		specify comma separated files to be copied to the map reduce cluster  
-libjars <comma separated list of jars>    		specify comma separated jar files to include in the classpath.  
-archives <comma separated list of archives>    specify comma separated archives to be unarchived on the compute machines. 

Common arguments:  
--connect <jdbc-uri>     						Specify JDBC connect string  
--connect-manager <class-name>     				Specify connection manager class to use  
--driver <class-name>    						Manually specify JDBC driver class to use  
--hadoop-mapred-home `<dir>`      				Override $HADOOP_MAPRED_HOME  
--help                   						Print usage instructions  
--password-file          						Set path for file containing authentication password  
-P                       						Read password from console  
--password <password>    						Set authentication password  
--username <username>    						Set authentication username  
--verbose                						Print more information while working
```
The -conf, -D, -fs and -jt arguments control the configuration and Hadoop server settings. ***For example, the -D mapred.job.name=<job_name> can be used to set the name of the MR job that Sqoop launches***, if not specified, the name defaults to the jar name for the job - which is derived from the used table name. 

***You must supply the generic arguments -conf, -D, and so on after the tool name but before any tool-specific arguments (such as --connect).***

##### Using Options Files to Pass Arguments

```
sqoop  
--options-file $conf_param_file  
--query 'select xxx ,  
yy   
from SCHEMA_NAME.TABLE_NAME  
where  $CONDITIONS'  
--hive-import  
--hive-overwrite  
--hive-table HIVE_TABLE -verbose -m 6  
--split-by COLUMN_NAME  
--null-string "<NULL>"  
--null-non-string 0  
--target-dir /path
```
If you are issuing the query wrapped with double quotes ("), you will have to use \$CONDITIONS instead of just $CONDITIONS to disallow your shell from treating it as a shell variable.

$conf_param_file

```
#
# Options file for Sqoop import
#

# Specifies the tool being invoked
import

# Connect parameter and value
--connect
jdbc:oracle:thin:@server:1521/dbname 

# Username parameter and value
--username
READ_ONLY_USER
--password
READ_ONLY_USER
#
# Remaining options should be specified in the command line.
#
```

### Secure way of supplying password to the database.
Save the password in a file on the users home directory with 400 permissions and specify the path to that file using the --password-file argument

```
$ sqoop import --connect jdbc:mysql://database.example.com/employees \
    --username venkatesh --password-file ${user.home}/.password
```

Hadoop 2.6.0 provides an API to separate password storage from applications. This API is called the credential provided API and there is a new credential command line tool to manage passwords and their aliases.One new option has been introduced to provide the alias on the command line instead of the actual password (--password-alias).
```
$ sqoop import --connect jdbc:mysql://database.example.com/employees \
    --username dbuser --password-alias mydb.password.alias
```
the alias can be saved in the file provided with --password-file option. Along with this, the Sqoop configuration parameter org.apache.sqoop.credentials.loader.class should be set to the classname that provides the alias resolution: org.apache.sqoop.util.password.CredentialProviderPasswordLoader
```
$ sqoop import --connect jdbc:mysql://database.example.com/employees \
    --username dbuser --password-file ${user.home}/.password-alias
```	

##### What is split by and boundary query in Sqoop
The degree of parallelism is controlled by -m <n> or --num-mappers <n>. By default value of --num-mappers is 4.
Second, --split-by <column-name>, will split your task on the basis of column-name.
Third, it is used internally by sqoop to achieve this splitting task.

--split-by : It is used to specify the column of the table used to generate splits for imports. This means that it specifies which column will be used to create the split while importing the data into your cluster. It can be used to enhance the import performance by achieving greater parallelism. Sqoop creates splits based on values in a particular column of the table which is specified by --split-by by the user through the import command. If it is not available, the primary key of the input table is used to create the splits.

Reason to use : Sometimes the primary key doesn't have an even distribution of values between the min and max values(which is used to create the splits if --split-by is not available). In such a situation you can specify some other column which has proper distribution of data to create splits for efficient imports.

--boundary-query : By default sqoop will use query select min(<split-by>), max(<split-by>) from <table name> to find out boundaries for creating splits. In some cases this query is not the most optimal so you can specify any arbitrary query returning two numeric columns using --boundary-query argument.
Reason to use : If --split-by is not giving you the optimal performance you can use this to improve the performance even further.

Note :
ERROR tool.ImportTool: Import failed: No primary key could be found for table students. Please specify one with --split-by or perform a sequential import with '-m 1'.


#### Free form query
When importing a free-form query, you must specify a destination directory with --target-dir



#### Difference between --append and --incremental append in sqoop

Append data to an existing dataset in HDFS

--append\
--where "dpt_id >10"

is same as
ONLY appends the data to existing data-sets, can also append duplicates 
***NOTE: this will NOT overwrite the data but will append***

--incremental append\
--check-column dpt_id\
--last-value 10

it Appends the new data and Updates the existing data with new rows but - NO duplicates -\
***NOTE: this will not overwrite the data but will update OR append***

--incremental lastmodified\
--check-column lastupdated\
--last-value 20160802000000

Sqoop supports two types of incremental imports: append and lastmodified.

You can use the --incremental argument to specify the type of incremental import to perform.

append:

    You should specify append mode when importing a table where new rows are continually being added with increasing row id values.
    You specify the column containing the row’s id with --check-column.
    Sqoop imports rows where the check column has a value greater than the one specified with --last-value.
	
NOTE: This does ***not track updated records or deleted records*** as only rows greater than "last-value" will be considered.
	

lastmodified:

    An alternate table update strategy supported by Sqoop is called lastmodified mode. You should use this when rows of the source table may be updated, and each such update will set the value of a last-modified column to the current timestamp.
    Rows where the check column holds a timestamp more recent than the timestamp specified with --last-value are imported.
    When running a subsequent import, you should specify --last-value in this way to ensure you import only the new or updated data.
    This is handled automatically by creating an incremental import as a saved job, which is the preferred mechanism for performing a recurring incremental import.
NOTE: This does ***not track deleted records*** as only rows greater than "last-value" will be considered.

### Can procedure be called using Sqoop

Yes, for exporting data Procedures can be called but with following conditions.

*The --export-dir argument and one of --table OR --call are required. These specify the table to populate in the database (or the stored procedure to call), and the directory in HDFS that contains the source data.*

```
--table <table-name> 		Table to populate
--call <stored-proc-name> 	Stored Procedure to call 
```

An export that calls a stored procedure named barproc for every record in /results/bar_data would look like:
```
$ sqoop export --connect jdbc:mysql://db.example.com/foo --call barproc \
    --export-dir /results/bar_data
	
```	

### target-dir vs warehouse-dir
--target-dir is incompatible with --warehouse-dir. If the destination directory already exists in HDFS, Sqoop will refuse to import. If we use the –append argument, Sqoop will import data to a temporary directory and then rename the files into normal target directory in a manner that, it does not conflict with existing file names in that directory.
	
### Controlling type mapping

Sqoop is preconfigured to map most SQL types to appropriate Java or Hive representatives. However the default mapping might not be suitable for everyone and might be overridden by --map-column-java (for changing mapping to Java) or --map-column-hive (for changing Hive mapping).	

Use URL encoded keys and values, for example, use DECIMAL(1%2C%201) instead of DECIMAL(1, 1) for --map-column-hive

### Handling null, newline character

The --null-string and --null-non-string arguments are optional.\ If not specified, then the string "null" will be used.

Sqoop will by default import NULL values as string null. Hive is however using string \N to denote NULL values and therefore predicates dealing with NULL (like IS NULL) will not work correctly.You should append parameters --null-string and --null-non-string in case of import job ***or --input-null-string and --input-null-non-string in case of an export job*** if you wish to properly preserve NULL values.
```
$ sqoop import  ... --null-string '\\N' --null-non-string '\\N'
```

The default delimiters are a comma (,) for fields, a newline (\n) for records, no quote character, and no escape character.When importing to delimited files, the choice of delimiter is important.

If you do not set any delimiters and do use --hive-import, the field delimiter will be set to ^A and the record delimiter will be set to \n to be consistent with Hive’s defaults.

 For example, the string "Hello, pleased to meet you" should not be imported with the end-of-field delimiter set to a comma.
```
Argument 							Description
--enclosed-by <char> 				Sets a required field enclosing character
--escaped-by <char> 				Sets the escape character
--fields-terminated-by <char> 		Sets the field separator character
--lines-terminated-by <char> 		Sets the end-of-line character
--mysql-delimiters 					Uses MySQL’s default delimiter set: fields: , lines: \n escaped-by: \ optionally-enclosed-by: '
--optionally-enclosed-by <char> 	Sets a field enclosing character 
```

NOTE :  choose unambiguous field and record-terminating delimiters without the help of escaping and enclosing characters when working with Hive; this is due to limitations of Hive’s input parsing abilities.


### Hive import 

If you do not set any delimiters and do use --hive-import, the field delimiter will be set to ^A(\001) and the record delimiter will be set to \n to be consistent with Hive’s defaults.

However lets say if set --mysql-delimiters then the table definition changes accordingly.

Also, If you do use --escaped-by, --enclosed-by, or --optionally-enclosed-by when importing data into Hive, Sqoop will print the following warning message.
```
 Hive does not support escape characters in fields; parse errors in Hive may result from using --escaped-by. Hive does not support quoted strings; parse errors in Hive may result from using --enclosed-by.
```

Hive will have problems using Sqoop-imported data if your database’s rows contain string fields that have Hive’s default row delimiters (\n and \r characters) or column delimiters (\01 characters) present in them. You can use the --hive-drop-import-delims option to drop those characters on import to give Hive-compatible text data. Alternatively, you can use the --hive-delims-replacement option to replace those characters with a user-defined string on import to give Hive-compatible text data. These options should only be used if you use Hive’s default delimiters and should not be used if different delimiters are specified.

```
--hive-drop-import-delims 	Drops \n, \r, and \01 from string fields when importing to Hive.
--hive-delims-replacement 	Replace \n, \r, and \01 from string fields with user defined string when importing to Hive. 
```
	
Hive can put data into partitions for more efficient query performance. You can tell a Sqoop job to import data for Hive into a particular partition by specifying the --hive-partition-key and --hive-partition-value arguments. ***The partition value must be a string.***	

```
 $SQOOP_HOME/bin/sqoop import \
 --connect jdbc:mysql://quickstart.cloudera:3306/retail_db \
 --username root \
 --password cloudera \
 --hive-import --table students \
 --hive-table "DEMO2" --columns stid,firstname \
 --hive-partition-key 'COUNTRY' \
 --hive-partition-value 'INDIA' \
 --m 1 --verbose \
 --delete-target-dir
 ```

### Hive Export
The --input-null-string and --input-null-non-string arguments are optional. If --input-null-string is not specified, then the string "null" will be interpreted as null for string-type columns. If --input-null-non-string is not specified, then both the string "null" and the empty string will be interpreted as null for non-string columns. Note that, the empty string will be always interpreted as null for non-string columns, in addition to other string if specified by --input-null-non-string.

Since Sqoop breaks down export process into multiple transactions, it is possible that a failed export job may result in partial data being committed to the database. This can further lead to subsequent jobs failing due to insert collisions in some cases, or lead to duplicated data in others. You can overcome this problem by specifying a ***staging table*** via the --staging-table option which acts as an auxiliary table that is used to stage exported data. The staged data is finally moved to the destination table in a single transaction.

***In order to use the staging facility***, you must create the staging table prior to running the export job. This table must be structurally identical to the target table. This table should either be empty before the export job runs, or the --clear-staging-table option must be specified. If the staging table contains data and the --clear-staging-table option is specified, Sqoop will delete all of the data before starting the export job.

```
--staging-table <staging-table-name> 	The table in which data will be staged before being inserted into the destination table.
--clear-staging-table 					Indicates that any data present in the staging table can be deleted. 
```	

If an UPDATE statement modifies no rows, this is not considered an error; the export will silently continue. 
Likewise, if the column specified with --update-key does not uniquely identify rows and multiple rows are updated by a single statement, this condition is also undetected.

Use --update-mode argument with allowinsert mode if you want to update rows if they exist in the database already or insert rows if they do not exist yet.
```
--update-key <col-name> 	Anchor column to use for updates. Use a comma separated list of columns if there are more than one column.
--update-mode <mode> 		Specify how updates are performed when new rows are found with non-matching keys in database.
							Legal values for mode include updateonly (default) and allowinsert. 
```
	
https://medium.com/datadriveninvestor/incremental-data-load-using-apache-sqoop-3c259308f65c


https://medium.freecodecamp.org/an-in-depth-introduction-to-sqoop-architecture-ad4ae0532583