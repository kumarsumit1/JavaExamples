Conway's law

```
Any organization that designs a system (defined broadly) will produce a design whose structure is a copy of the organization's communication structure
```

## System Design 

https://www.youtube.com/watch?v=REB_eGHK_P4


## OS hardening
https://www.youtube.com/watch?v=Gnv0MG1vLvU

#### Basics of the CIS Hardening Guidelines
https://blog.rsisecurity.com/basics-of-the-cis-hardening-guidelines/

Implementation guide by CIS and STIG 

    Preparations and Installations
    Service Packs and Hot Fixes
    User Account Policies 
    User Rights Assignment
    Security Settings
    Network Access Controls
    Network Security Settings
    Active Directory Domain Member Security Settings
    Audit Policy Settings
    Event Log Settings
    Linux Subsystem
    Additional Security Protection
    Additional Steps
    Physical Security



Some specific tweak examples 
- BIOS Protection
- Disk Encryption
- Lock boot directory / disable USB
- Lock cron 
- use SELinux
- 
- Disable unusable service and ports , ( Core Os has done this in Docker )
- update the repository and softwares
- Disable guest login , follow the principle of least priviledge access.
- Get you system audited by third party for security flaws
- Create mount points for /tmp, /var , /home
- Secure passwords only, 
- Allowing access only using specific network, SSH tunnel or whitelisted IP 
- Failed notification alert
- Firewall
- Login to server using authentication key pair
- 
- Cloud AMI hardeinig ?

A basic checklist on OS hardening :
https://security.utexas.edu/os-hardening-checklist


A implemention of checklist that can be run on any os to check its compliance :
https://github.com/docker/docker-bench-security


Ubuntu hardening
https://www.youtube.com/watch?v=wyEX0eyoK88


## Network Stack 
- Network Firewall
- 

https://www.youtube.com/watch?v=gj4CD73Wmns

https://www.youtube.com/watch?v=8toveAOL5eA


## Container security
https://www.youtube.com/watch?v=pTqg59_NB30

- prefer on core os ( use mininal os images )
- scan the image before using
- restrict root user login or removie it altogether
- 


https://github.com/quay/clair

https://quay.io/


Data Swamp :


## Multi-tenent architecture 
https://www.youtube.com/watch?v=0N4KknY_zdU

A model where any tenent can be served by any compute node.
They enable 
- horizonatal auto-scaling
- enhance resiliance
- zero downtime upgrades


Considerations for building low latency and highly available applications
- Introduce redundancy to reduce latency and increase availability
- Harness CQRS to mitigate PACELC
- Cache aggresively, but invalidate intelligently


## Lambda vs Kappa

https://www.ericsson.com/en/blog/2015/11/data-processing-architectures--lambda-and-kappa

https://hazelcast.com/glossary/kappa-architecture/

https://www.talend.com/blog/2017/08/28/lambda-kappa-real-time-big-data-architectures/


https://www.youtube.com/watch?v=4haHum0b7Ls

Lambda architechture

Kappa architechture
In Kappa everything is a stream.
