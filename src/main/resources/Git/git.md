git config --global --list

--> list all the configuration at global level

git config --list 

--> list config at local level

all the global configuration are stored in .gitconfig

--> list local branches
$ git branch
* master

--> -a shows all local and remote branches
$ git branch -a
* master
  remotes/origin/HEAD -> origin/master
  remotes/origin/master

--> -r shows only remote branches.
$ git branch -r
  origin/HEAD -> origin/master
  origin/master

--> disable askPass logon screen

$ git config --global core.askPass ""


1) Clone needed repository
git clone --depth 1 -b release/0.1.1 https://github.com/Teradata/kylo.git

2) Create a new branch. It will contain the latest files of your master branch repository

$ git branch new_branch

3) Change git branch to the new_branch

$ git checkout new_branch

4) Do coding, commits, as usual…

$ git add .
$ git commit -m “Initial commit”
$ git push (pushes commits only to “new_branch”)

5) When job is finished on this branch, merge with “master” branch:
$ git fetch origin master
$ git merge master (resolve any merge conflicts if there are any)
$ git checkout master (goes to master branch)
$ git merge development (merges files in localhost. Master shouldn’t have any  commits ahead, otherwise there will be a need for pull and merging code by hands!)
$ git push (pushes all “new_branch” commits to both branches - “master” and “new_branch”)

6) One last command to delete the branch.

$ git branch -d “new_branch”

To delete Test_Branch from remote as well, execute:

git push origin --delete “new_branch”


NOTE : 
1. merge master into the development first so that if there are any conflicts, I can resolve in the development branch itself and my master remains clean.

2. If you want to keep track of who did the merge and when, you can use --no-ff flag while merging to do so. This is generally useful only when merging development into the master (last step), because you might need to merge master into development (first step) multiple times in your workflow, and creating a commit node for these might not be very useful.

git merge --no-ff development

# Use of "stash"

command that allows you to store the modifications you’ve made in our working directory and go back to a clean working directory.

Git stash save : saves the changes to the stash
Git stash list : list the stash points
Git stash pop  : merges the changes from stash to workbook and also deletes the point from Stash list
Git stash show : command shows the summary of the stash diffs. The above command considers only the latest stash.



Introduction to Git - Core Concepts  https://www.youtube.com/watch?v=uR6G2v_WsRA
Introduction to Git - Branching and Merging    https://www.youtube.com/watch?v=FyAAIHHClqI
Introduction to Git - Remotes  https://www.youtube.com/watch?v=Gg4bLk8cGNo





------------------------------------------------
Jenkins project type

Freestyle project or Maven project


Build triggers ( periodically, poll etc)


The project are normally downloaded in jenkins/jobs/ folder

Enforcing quality ( All this comes in post build steps )

checkstyle plugin -->  got to configure and then to build settings and then in advanced section set the threshold
                        like more than 100 warning in total should fail the buil , or mark it unstable etc
PMD  --> similar approach

FindBugs --> 	similar approach


Artifect publishing to Maven or nexus


Deploying the artifect to Tomcat  ( this comes in post build actions )
 1. add a role as manager-script in tomcat with some user that we will use in Jenkins
 2. add deploy plugin
 
 
Configure Global Security ( a plugin by default installed )
--> Integrate with LDAP
-->  Authorization has options like logged in user can do anything, matrix based security , project based matrix authorization strategy

