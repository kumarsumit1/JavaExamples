

# Install aws-azure-login

Federated Login details such a access key id , secret key , and session token 
https://github.com/sportradar/aws-azure-login

You can install this pluggin directly from your git bash with:

	npm install -g aws-azure-login
	
	aws-azure-login --help
	
	#configure the profile
	aws-azure-login --configure --profile devprofile
	
	#Now loging using chromium
	aws-azure-login --mode=gui --profile devprofile



# Install aws cli 
https://blog.gruntwork.io/authenticating-to-aws-with-the-credentials-file-d16c0fbcbf9e

   All the configuration is stored in folder .aws , it has two files "config", "credential" 

	aws ec2 describe-instances --region=us-west-1 --profile devprofile
	
	aws s3 ls 

	To removie profile keyword use env varialbe 

	export AWS_DEFAULT_PROFILE=devprofile
	OR
	export AWS_PROFILE=devprofile
	
	Powershell :
	$Env:AWS_DEFAULT_PROFILE="devprofile"


Note : 
	for "logging out" delete the credential file entry 
	for getting account details use aws cloud cli :
		$aws sts get-caller-identity
		
	If you are getting SSL error try to reconfigure your credentials 
		aws configure


# Terraform 
https://dzone.com/articles/terraform-cli-cheat-sheet

terraform remote config -backend=s3 -backend-config='profile=devprofile' ...

terraform init -backend-config=init/dev.tfvars 

terraform plan -target=aws_athena_named_query.varName -var-file=vars/dev.tfvars



Note :
    For getting account details 
		data "aws_caller_identity" "current" {}

# Lambda 

Install SAM Cli
https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-install-windows.html

https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-reference.html

VS code 

https://docs.aws.amazon.com/toolkit-for-vscode/latest/userguide/serverless-apps.html

https://www.youtube.com/watch?v=bih5b3C1nqc --> simple and effective


https://www.youtube.com/watch?v=MipjLaTp5nA


More detailed 
https://www.youtube.com/watch?v=4xNw2wWLHdY

In local mode, debug , shows how to generate dummy event msg 
https://www.youtube.com/watch?v=X7Ji2UwRCKI

simple and quick
https://www.youtube.com/watch?v=DA3hlLxTl-8

## sam local docker image development 

https://aws.amazon.com/blogs/compute/using-container-image-support-for-aws-lambda-with-aws-sam/

Ideal way to wrtie code
https://stackoverflow.com/questions/60334350/sam-build-use-container-failed-but-sam-build-is-success

List of policy 
https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-policy-template-list.html

pip3 install aws-sam-cli

setup locally 

https://www.sqlshack.com/set-up-a-local-serverless-environment-using-the-aws-sam-cli/

sam init --runtime python3.7 --name sam-app --config-file testconfig.toml

sam build

sam local invoke


Debug in vscode 

https://www.moesif.com/blog/technical/serverless/debug-lambda-functions-locally-with-the-sam-cli-and-vscode/

------- TODO --------------
sam local start-api --docker-network host  
sam build && sam local invoke --debug --docker-network host -e events/event.json

sam local start-api \
-t template.yaml \
--region us-east-1 \
--env-vars .envs.json \
--parameter-overrides Environment=sandbox \
--container-host XXX.XXX.XXX.XXX \
--container-host-interface XXX.XXX.XXX.XXX \
--warm-containers LAZY \
--skip-pull-image

https://stackoverflow.com/questions/61505293/aws-lambda-invoking-locally-a-python-lambda-function-with-access-to-s3
---------------------------

Note: 
	Check if Properties type in template.yaml is 
      PackageType: Image
	  
	And is should contian docker metadata 
	Metadata:
      DockerTag: python3.7-v1
      DockerContext: ./hello_world
      Dockerfile: Dockerfile


## sam local generate-event

Local event message generation for testing 

```
sam local generate-event [OPTIONS] COMMAND [ARGS]...
```

https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/sam-cli-command-reference-sam-local-generate-event.html

https://stackoverflow.com/questions/60750054/aws-lambda-how-to-know-the-event-format-from-aws-services


## sam invoke 

SAM applications can be invoked by API Gateway and direct lambda handler

Go to launch.json of vs code setting and it should have lambada event jsons 

		"payload": {
                    "json": {
                     "var":"lamba local payload"
                    }
                }

One can manually add invoking messages too.
Various options mentioned here :
https://docs.aws.amazon.com/toolkit-for-vscode/latest/userguide/serverless-apps-run-debug-no-template.html



## s3 aws cli 
https://kumargaurav1247.medium.com/aws-s3-cli-commands-f367d0e10f4b#

Size of bucket 
aws s3 ls --summarize --human-readable --recursive s3://test-bucket/

copy file to local 
aws s3 cp s3://test-bucket/ . --recursive

Copy to remote 
aws s3 cp . s3://test-bucket/ --recursive

### cross-account access to objects that are in Amazon S3 buckets
https://www.youtube.com/watch?v=sfQ8tBuxfRY

https://aws.amazon.com/premiumsupport/knowledge-center/cross-account-access-s3/


Bucket Policy to be added to bucket, we can give user name instead of "root" :

{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Principal": {
                "AWS": "arn:aws:iam::<account_from_where_objects_needs_to_be_accessed>:root"
            },
            "Action": [
				"s3:ListBucket",
                "s3:GetObject",
                "s3:GetObjectTagging",
                "s3:PutObject",
				"s3:PutObjectAcl" ,
                "s3:PutObjectTagging"
            ],
            "Resource": [
			"arn:aws:s3:::test-bucket-1-2-3-4-5-6-7/*",
			"arn:aws:s3:::test-bucket-1-2-3-4-5-6-7"
			]
        }
    ]
}



Note: 

1. The "s3:PutObjectAcl" permission is required for users that must specify an object access control list (ACL) during upload. Without this permission, users get an Access Denied error when they upload an object with an ACL (such as the bucket-owner-full control ACL). For more : https://aws.amazon.com/premiumsupport/knowledge-center/s3-cross-account-upload-access/ 

https://docs.aws.amazon.com/AmazonS3/latest/userguide/example-walkthroughs-managing-access-example2.html

2. For getting account id of any login to aws cli and execute the command :
	
	aws sts get-caller-identity
	
	where STS stands for Security Token Service
	
3. After applying policy , these buckets can be accessed using AWS CLI 	