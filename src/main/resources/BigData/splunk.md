Download the universal forwarder image to your local Docker engine:


$ docker pull splunk/splunk:latest
Use the following command to start a single instance of the Splunk Universal Forwarder:

docker run -d -p 8000:8000 -p 8089:8089 -e "SPLUNK_START_ARGS=--accept-license" -e "SPLUNK_PASSWORD=test@123" --name splunk splunk/splunk:latest

For more information : https://splunk.github.io/docker-splunk/ADVANCED.html

http://localhost:8000/



Administer Splunk Enterprise Docker containers
You can use the following Docker commands to manage containers.

To see a list of example commands and environment variables for running Splunk Enterprise in a container, run:
	docker run -it splunk/splunk help

To see a list of your running containers, run:
	docker ps

To stop your Splunk Enterprise container, run:
	docker container stop <container_id>

To restart a stopped container, run:
	docker container start <container_id>

To access a running Splunk Enterprise container to perform administrative tasks, such as modifying configuration files, run:
	docker exec -it <container_id> bash
	
	
Splunk setup 

https://towardsdatascience.com/explore-and-get-value-out-of-your-raw-data-an-introduction-to-splunk-e5cb94c0855e

https://hurricanelabs.com/splunk-tutorials/splunk-tutorial-cruding-a-kv-store-in-splunk-using-python/  --> start from here 

https://community.splunk.com/t5/Developing-for-Splunk-Enterprise/How-to-create-a-KVStore-using-Python-SDK-w-SPL-commands/m-p/461462#M3924


https://holdmybeersecurity.com/2020/12/31/create-a-custom-splunk-search-commands-with-python3/


https://docs.splunk.com/DocumentationStatic/PythonSDK/1.1/client.html

Batch save 

https://stackoverflow.com/questions/59901155/splunk-load-csv-from-gcp-into-a-kvstore-lookup-using-the-python-sdk

https://github.com/splunk/splunk-sdk-python/blob/master/tests/test_kvstore_batch.py


https://blog.agood.cloud/posts/2020/06/14/adding-thehive-case-data-to-splunk/


Export data from splunk :
https://stackoverflow.com/questions/62312428/python-json-data-from-splunk

Hunk 	
	
https://www.youtube.com/watch?v=qtA6TmOpgUU 	


Splunk Analytics for Hadoop
https://docs.splunk.com/Documentation/Splunk/8.2.2/HadoopAnalytics/MeetSplunkAnalyticsforHadoop


------------ Curl ------------------------------
Issue call, get SID , output_mode= (atom | csv | json | json_cols | json_rows | raw | xml)
curl -k -u USERMNAME https://MY_SPLUNK_HOST:8089/services/search/jobs/ -d search="search index=MY_INDEX earliest=-15m"

curl -k -u admin:test@123 https://127.0.0.1:8089/services/search/jobs/ -d search="search index=main  sourcetype=access_combined earliest=-750d"

check status
curl -u USERMNAME -k https://MY_SPLUNK_HOST:8089/services/search/jobs/160.obfuscated

curl -u admin:test@123 -k https://127.0.0.1:8089/services/search/jobs/1636368195.20

Get result 
curl -u USERMNAME -k https://MY_SPLUNK_HOST:8089/services/search/jobs/160.obfuscated/results/ --get -d output_mode=json

curl -u admin:test@123 -k https://127.0.0.1:8089/services/search/jobs/1636368195.20/results/ --get -d output_mode=json


------------  Export -------------------------
To see various kind of sourcetype in main index
	
	index="main" | stats count by sourcetype
	
	index="main"  sourcetype=access_combined


source="access.log" host="5014da377cb1" sourcetype="access_combined"

source="access.log" host="9fbedc42858a" sourcetype="access_combined" | sort _time desc


curl -k -u USERMNAME https://MY_SPLUNK_HOST:8089/services/search/jobs/ -d search="search index=MY_INDEX earliest=-15m"

batch calculation logic :
https://github.com/dstaulcu/SplunkTools/blob/master/Splunk-SearchLargeJobs-Example.ps1




------------------ Import ------------------------
Universal Forwarder :
splunk add on :
Script : 
Event collector:


Oneshot upload 

https://docs.splunk.com/Documentation/Splunk/6.3.3/RESTREF/RESTinput#data.2Finputs.2Foneshot