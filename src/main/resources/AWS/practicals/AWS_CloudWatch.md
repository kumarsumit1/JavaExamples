#cloudwatch 

https://www.youtube.com/watch?v=guE3pdbMSgI


https://www.youtube.com/watch?v=G4_ay2_h9GI --Intro

https://www.youtube.com/watch?v=mcV1idfCXOo -- Alert

Two types of monitoring 
	Basic monitoring :
		Its free
		A dealy of 5 mins
	
	Detailed monitoring :
		Paid
		A delay 
		
		
		
		

# Graph/Dashboard from metrices 

https://www.youtube.com/watch?v=9yqTcgt6LYU


Create metrics filter :
https://www.youtube.com/watch?v=I_VjSvSSoF4

https://www.youtube.com/watch?v=kdyURQfLncY  --> documentation guide 



# Rules
CloudWatch Events Event Examples From Supported Services

https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/EventTypes.html

{
  "source": [
    "aws.glue"
  ],
  "detail-type":[
    "Glue Job State Change"
  ],
  "detail": {
    "state": [
      "SUCCEEDED"
    ],
    "jobName": [
        "GlueJobName"
    ]
  }
}

		