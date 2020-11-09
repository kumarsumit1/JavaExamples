
Git is a "three Tree structure" i.e 
repository
staging index
working directory



-------------------  UNDO Changes ----------------------------------
# Undo Working directory changes

git checkout -- <File.name>

git checkout -- .   #Undos all the changes in the workspace

The above command will fetch the file from current branch and overwrite in current folder

git checkout <branch> <file.name>

this will overwrite taking file from named branch to current workspace


# Unstage Files

git reset HEAD <fileName>

Undo changes to previous commit point 

# Ammend Commits

git commit --ammend -m "New commit message"

It megers the current commit with previous one. And in the process it deletes the previous SHA and creates a new one. So in total we still have one commit 

note : One can use it to "even" change a commit message using above command  

# Retrive old commits

it needs to be noted that git commits records in chains, so in order to undo a commit its better to make new commit that has changes undoing the previous commit

git checkout <commit SHA> -- <fileName>

This will checkout the changes of that commit point in current workspace 

Now make changes and commit them again


# Revert changes 

git revert SHA 

reverts commit point to previous commit point by creating a new commit undoing the previous changes.


Note : In all these methods a new commit point gets created with reverted changes 


--------------------------------------------------------
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
Git stash show : command shows the summary of the stash diffs. The above command considers only the latest stash.
Git stash pop  : merges the changes from stash to workbook and also deletes the point from Stash list
Git stash apply: merges the changes from stash to workbook but do not delete the point from stash. `git stash pop` is `git stash apply` && `git stash drop`

## To Fix merge issues while pulling from origin

git stash 
git pull origin master : 
git diff stash@{0}     : compare stash with working copy
git stash apply        : merges with working directory, perform manual merging
git add/commit/push  


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

