

system policy --> rules --> approval 
// approve the current request, since this does not resolve to a user or group, approvers are not set
 current.comments.setJournalEntry("Request automatically approved for total price <= $1000","system");
----------------




For sample bootstrap code :
https://getbootstrap.com/ ( document section )

--------------------------- Service Now -------------------------------------
https://docs.servicenow.com/bundle/newyork-it-service-management/page/product/service-catalog-management/concept/c_ServiceCatalogManagement.html
Components :
 catalog
 workflow attached with Catalog item
 Workflow Dashboard
 Workflow using Automated Testing Framework ( ATF )
 Orchestration ( And difference between Workflow vs Orchestration )
 
 Choosing between workflow and execution plan ?
 Glide records
 Dump data to staging table and generate the flow
 Rest API Explorer ( from Service Now )
 
 Update Set ( for moving the artifact from dev to prod )
 Reports/ Dashboard
 
 Paris
ServiceNow Developer 
 
https://www.youtube.com/playlist?list=PLzTvAeLiW8AfXEIFrUp-22z512aXxr2Ss 
 
 
https://www.edureka.co/blog/servicenow-developer-instance/ 
 
 
How to enable workflow debug:
https://community.servicenow.com/community?id=community_question&sys_id=f83fc7e1dbdcdbc01dcaf3231f96191c 

System Definition : Has three modules detailing the information of relational table storing the information of servicenow
		Tables
		Tables and Columns
		Table rotations




----------------------------------------------------------------------------------------


Rest API ServiceNow Integration 
https://www.youtube.com/watch?v=tVxyRmS3flA

Workflow ServiceNow
https://www.youtube.com/watch?v=I2ZNCob4-3c

Design Form
Layout Form
Layout List
Show Form
Show List
Show Schema Map
Add to Service Catalog
Explore REST API


Database View -- Joining Tables u_vms_test_join  u_vms_test_join_list.do

snow to jira intergration :
https://www.youtube.com/watch?v=vv_oHjywUxg&feature=youtu.be

----------------- Cloud Integration -------------------------
AWS Management from ServiceNow
https://www.youtube.com/watch?v=yGw9tFuAhHI 

Self Service of IAM using Service Now
https://www.youtube.com/watch?v=9ohaJugpE1Y 



---------------------- Glide records -----------------------------

https://pishchulin.medium.com/react-application-in-servicenow-8bdbb1e69c0c

https://pishchulin.medium.com/web-applications-in-servicenow-e4f3421560b

https://community.servicenow.com/community?id=community_question&sys_id=7a3b0bffdb221f40a8562926ca96198d


https://community.servicenow.com/community?id=community_question&sys_id=680e0baddb9cdbc01dcaf3231f9619ff


Add Query has two variant 
		addQuery(String name, Object value)
		addQuery(String name, String operator, Object value)  where operator can be : CONTAINS,<,>,STARTSWITH,IN etc

https://developer.servicenow.com/dev.do#!/reference/api/orlando/server/no-namespace/c_GlideRecordScopedAPI

Quering service tables ( something like schema based DB tables ) 
https://docs.servicenow.com/bundle/paris-application-development/page/script/server-scripting/concept/c_UsingGlideRecordToQueryTables.html




------------------- Service Portal ---------------------------


Go to portals 
vm 
vms_index
Vul-Test-Widget



To delete Vulnerability Management System	vms

https://community.servicenow.com/community?id=community_question&sys_id=7c0e59dcdb3d3b4023f4a345ca961952


https://www.youtube.com/watch?v=U_c0i-QuPnM  --1 hr


https://www.youtube.com/watch?v=UyHvp_t6mKQ  --creating sp 


https://www.youtube.com/watch?v=zQgtFsCP8Bw 


Widgets --->
https://www.youtube.com/watch?v=sr_gqqxllRM

https://www.youtube.com/watch?v=s9vX4lTz06Q


commonly used variables :
input
data
tablename_list.do


Search :
vms_text_search

Vul-Search-Widget


----------  Ctatalog ----------------------------
catalog 
   category
   
ctalog items 

   





------------------------------------------------
Widget - 
----------------------------------------------------
1. Homepage Search


2. Icon Link



3. simple List


4. recent and popular items 
--------------------------------------------------
1. Breadcrumbs



2. TypeHead Search:
    configure "Contextual Search Sources" --> Go to main page and click on "Search Sources" and add or modify the content.



3. Search Page

4. Search Nav 

---------- Checking tables --------------------
 <tablename>_list.do : Opens table in list format 

-------------- Running Script ----------------------------------------
Search for Scripts-Background or sys.scripts.do

https://www.youtube.com/playlist?list=PLzTvAeLiW8AfXEIFrUp-22z512aXxr2Ss

https://www.youtube.com/playlist?list=PL3rNcyAiDYK2_87aRvXEmAyD8M9DARVGK

------------------------ Error Handlin --------------------------------

The following are one which works at server side and its functions:-


    gs.log("test");writes to the database and the log file


    gs.print("test"); writes to the text log on the file system but not to the sys_log table in the database


    gs.addInfoMessage("test")it displays "test" on the top of the screen

Go to System log to see its output

The following are one which works at Client scripting and its functions:-


    alert("test") — it pop up a window with "test" and an Ok button.


    confirm("test") it pop up a window with "test" and along with Ok & Cancel button.


    To show an error message in specific field g_form.showErrorBox('YOUR FIELD NAME','test');


    To hide an error box which is visible in specific field, g_form.hideErrorBox('YOUR FIELD NAME');

	


------------------- Script includes  -------------------
Write common functionality in one JS script and call it as functions or import function
https://www.youtube.com/watch?v=YjOPtukSHEU&list						
						


------------------------ Domain Seperation --------------------------

https://www.youtube.com/watch?v=umLVsMQYZwo

https://www.youtube.com/watch?v=o-g5iBd5Iyc

https://www.youtube.com/watch?v=iEo19LAJDRw

gs.log(gs.getUser().getDomainID());
gs.info('Domain ID is ==' + gs.getUser().getRecord().getValue('sys_domain'));

Another way :

var user = new GlideRecord('sys_user');
user.get(gs.getUserID());
gs.info('Domain ID is ==' + user.sys_domain);
gs.log(user.sys_domain_path);
gs.log(JSON.stringify(user));						