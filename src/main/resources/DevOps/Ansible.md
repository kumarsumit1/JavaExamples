#Ansible 

## Ansible Components 

https://blog.ssdnodes.com/blog/step-by-step-ansible-guide/
https://serversforhackers.com/c/an-ansible-tutorial
### Inventory
  An inventory file lists hosts wich you would like to manage and the groups they belong to.
  
### modules
Modules are the discrete units of code that can be used from the terminal or in a playbook task. They simplify Ansible tasks by installing software, copying files, using templates, and so on.

### Tasks 
When you dispatch a job from a control host to a managed host using an Ansible module, it is known as a task. Tasks can be implemented using ad-hoc commands or you can use an Ansible playbook  

### Play
An Ansible play is a set of tasks that are run on one or more managed hosts. A play may include one or many different tasks, and the most common way to execute a play is to use a playbook.

### Playbook
Ansible Playbooks are composed of one or more plays and offer more advanced functionality for sending tasks to managed host compared to running many ad-hoc commands.

### Roles
In Ansible, a role provides a mechanism to break a complicated playbook into multiple reusable components. Each component offers a small function that can be used independently within the playbook. 


## Ansible DSL

### Variables

### Conditionals

### Loops

### Tags

### templates

### Blocks


## Ansible Vault

control machine : local system on which anisble is installed

https://www.youtube.com/watch?v=MfoAb50Br94

Setup :

http://answersforaws.com/episodes/2-ansible-and-aws/


"terminal.integrated.shell.windows": "C:\\Windows\\System32\\bash.exe"


debug 
  msg :

Packtpub

https://www.youtube.com/watch?v=Tcu1wsX-skM

https://github.com/PacktPublishing/Mastering-Ansible


https://www.youtube.com/watch?v=tICdqqn7RG8

code at :

https://github.com/Datanexus/kafka-operations

5 part :

https://www.youtube.com/watch?v=icR-df2Olm8