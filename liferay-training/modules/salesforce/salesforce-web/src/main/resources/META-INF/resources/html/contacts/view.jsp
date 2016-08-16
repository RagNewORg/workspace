<%@ include file="/init.jsp"%>
<liferay-portlet:resourceURL var="ajaxCallResourceURL"
	id='${portletNamespace}egf' />
<div id='mainContactsDiv'>
	<div id='messageDiv' style="font: normal 11px/13px tahoma,arial,verdana,sans-serif;padding: 3px 6px 10px 6px">
		Show All<a href="#" onclick="showAllContacts();return false;">
			Contacts</a>
	</div>
	
	<div id="${portletNamespace}contactsDIV"></div>
</div>
<script>

	

	Ext.require([
             'Ext.form.*',
             'Ext.data.*',
	             'Ext.chart.*',
             'Ext.grid.Panel',
             'Ext.layout.container.Column'
         ]);
         
		function showAllContacts(){
			store1.clearFilter();
			document.getElementById("messageDiv").style.display = 'none';
		}
	
		function filterContactByAccount(acId){
			 store1.clearFilter();
		     store1.filter('accountId',acId);
		     document.getElementById("messageDiv").style.display = 'block';
		}
		
		var store1 = null;

         function ${portletNamespace}renderContactsDashboard ( contactsDiv){
        	 console.log('executingCon-' + '<%= ajaxCallResourceURL.toString() %>');
        	 console.log('executingCon-' + '${portletNamespace}renderDashboard');
        	 var filterAccountId = null;
        	 document.getElementById("messageDiv").style.display = 'none';
        	 Liferay.on(
        				"SalesforceAccountClickEvent",
        				function(data) {
        					var acId = data.accountId;
        					var accountName = data.accountName;
        					filterAccountId = acId;
        					filterContactByAccount(acId);
        				}
        	 );
        	
        	 store1 = new Ext.data.Store({
  		        // load using HTTP
  		        type: 'json',
  		        fields: [
  		            {name: 'name', mapping: 'Name'},
                    {name: 'title', mapping: 'Title'},
                    {name: 'email', mapping: 'Email'},
                    {name: 'phone', mapping: 'MobilePhone'},
                    {name: 'department', mapping: 'Department'},
                    {name: 'accountId', mapping: 'AccountId'},
                    {name: 'contactId', mapping: 'id'}
  		        ],
	  		    proxy     : {
	  	            type   : 'ajax',
	  	            url    : '<%=ajaxCallResourceURL.toString()%>',
	  	          	extraParams: {
	  	          		<portlet:namespace />type: 'contacts'
	  	        	},
	  	            reader : {
	  	                type : 'json'
	  	            }
	  	        },
  		        listeners: {
  		          'load': function() {
  		              // console.log(this)
  		           }
  		        }
  	
  	        });
  	        store1.load();
         	showAllContacts();
           var contactsGrid = Ext.create('Ext.grid.Panel', {
        	        title: 'Salesforce Contacts',
        	        store: store1,
        	        height: 300,
        	        columns: [{
        	            text: 'Name',
        	            dataIndex: 'name',  
        	            autoSizeColumn: true
        	        }, {
        	            text: 'Title',
        	            dataIndex: 'title',
        	            flex: 1
        	        }, {
        	            text: 'Email',
        	            dataIndex: 'email',
        	            autoSizeColumn: true,
        	            width: 200
        	        }, {
        	            text: 'Phone',
        	            dataIndex: 'phone'
        	        }, {
        	            text: 'Department',
        	            dataIndex: 'department'
        	        }
        	        ],
        	        renderTo: contactsDiv
        	 });
        	
			
         }
</script>


<script type="text/javascript">
Ext.onReady(function(){
	${portletNamespace}renderContactsDashboard('${portletNamespace}contactsDIV');
});
</script>

