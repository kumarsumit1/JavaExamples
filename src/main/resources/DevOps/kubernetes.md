


https://www.youtube.com/playlist?list=PLp_fsLj4v7gTA8n2UngXfOc_5puPPmFdK
And its examples on katacoda:
https://www.katacoda.com/ranand12/scenarios/podsinplainenglish




# Translate a Docker Compose File to Kubernetes Resources

https://kubernetes.io/docs/tasks/configure-pod-container/translate-compose-kubernetes/
https://kompose.io/

Or one can directly deploy to Kubernetes from docker using docker-compose
https://www.docker.com/blog/simplifying-kubernetes-with-docker-compose-and-friends/


#Commands


## objects 
pods
secret
services
namespaces
deployments
daemonsets


kubectl get nodes

kubectl 

kubectl get pods 

kubectl get replicaset

kubectl get deployments 

kubectl rollout history <name of deployment> 

kubectl rollout history <name of deployment>  --revision 1

kubectl describe deployments <name of deployment>

kubectl get secret

kubectl create secret generic firstsecret --fromm-litral 

kubectl create configmap .... 117



## Run
	docker run --name webservice nginx

	kubectl run webservice --image nginx

## exec 

    docker exec -it webservice bash
	
	kubectl exec -it webservice -- bash 
	
## rm 
    docker container stop webservice
	docker container rm webservice
	
	kubectl delete pod webservice
	
	
## apply

   kubectl apply -f pods.yaml

   kubectl delete -f pods.yaml


   

	