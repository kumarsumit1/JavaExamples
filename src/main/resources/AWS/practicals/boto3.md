

#Client vs resources 

https://stackoverflow.com/questions/42809096/difference-in-boto3-between-resource-client-and-session

https://www.learnaws.org/2021/02/24/boto3-resource-client/ 


https://realpython.com/lessons/clients-and-resources/ 


Client apis can be accessed from resources itselef by calling meta.client on top of it .
s3_resource.meta.client 