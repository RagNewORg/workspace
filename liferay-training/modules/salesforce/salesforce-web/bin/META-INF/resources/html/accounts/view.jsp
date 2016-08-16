<%@ include file="/init.jsp"%>
<liferay-portlet:resourceURL var="ajaxCallResourceURL" id='${portletNamespace}abc'/>

<div id="${portletNamespace}accountsDIV"></div>

<div align="center" id="${portletNamespace}industryChartDIV"></div>
<script>
Ext.require([
             'Ext.form.*',
             'Ext.data.*',
             'Ext.chart.*',
             'Ext.grid.Panel',
             'Ext.layout.container.Column'
         ]);
         
         

         function ${portletNamespace}_renderDashboard ( divId, chartsDiv){
        	 console.log('executing-' + '<%=ajaxCallResourceURL.toString()%>');
        	 var store2 = new Ext.data.Store({
  		        // load using HTTP
  		        //url: 'http://localhost:8080/salesforce-portlet/js/ext-4.2/sample-data.json',
  		        //root: 'someObj',
  				type: 'json',
  		        fields: [
  		            {name: 'name', mapping: 'Name'},
                    {name: 'numberOfEmployees', mapping: 'NumberOfEmployees'},
                    {name: 'type', mapping: 'type'},
                    {name: 'industry', mapping: 'Industry'},
                    {name: 'billingState', mapping: 'BillingState'},
                    {name: 'billingCity', mapping: 'BillingCity'},
                    {name: 'rating', mapping: 'Rating'},
                    {name: 'desc', mapping: 'description'},
                    {name: 'accountId', mapping: 'id'}
  		        ],
	  		    proxy     : {
	  	            type   : 'ajax',
	  	            url    : '<%= ajaxCallResourceURL.toString() %>',
	  	          	extraParams: {
		  	          <portlet:namespace />type:  'accounts'
	  	        	},
	  	            reader : {
	  	                type : 'json'
	  	            }
	  	        },
  		        listeners: {
  		          'load': function() {
  		               //console.log(this)
  		           }
  		        }
  	
  	        });
  	        store2.load();
         	
        	 Ext.create('Ext.grid.Panel', {
        	        title: 'Salesforce Accounts',
        	        height: 300,
        	        store: store2,
        	        columns: [{
        	            text: 'Name',
        	            dataIndex: 'name',  
        	            width: 200, 
        	            autoSizeColumn: true
        	        }, {
        	            text: 'Industry',
        	            dataIndex: 'industry',
        	            flex: 1
        	        }, {
        	            text: 'City',
        	            dataIndex: 'billingCity'
        	        }, {
        	            text: 'State',
        	            dataIndex: 'billingState'
        	        }, {
        	            text: 'Rating',
        	            dataIndex: 'rating',
        	            hidden: true
        	        }, {
        	            text: 'Employees',
        	            dataIndex: 'numberOfEmployees'
        	        }
        	        ],
        	        listeners: {
        	          'itemclick': function( grid, record, item, index, e, eOpts ) {
      		       		console.log('Selected Record', 'Name : ' + record.get('accountId'));
      		       		Liferay.fire(
	      		  			"SalesforceAccountClickEvent",
	      		  			{
	      		  				"accountId" : record.get('accountId'),
	      		  				"accountName" : record.get('name')
	      		  			}
      		  			);
      		       	  }
        	        },
        	        renderTo: divId
        	 });
        	 /*
        	 Ext.create('Ext.chart.Chart', {
        	        renderTo: chartsDiv,
        	        width: 500,
        	        height: 350,
        	        animate: true,
        	        store: store1,
        	        series: [{
        	            type: 'pie',
        	            angleField: 'data',
        	            showInLegend: true,
        	            tips: {
        	                trackMouse: true,
        	                width: 140,
        	                height: 28
        	            },
        	            highlight: {
        	                segment: {
        	                    margin: 20
        	                }
        	            },
        	            label: {
        	                field: 'industry',
        	                display: 'rotate',
        	                contrast: true,
        	                font: '18px Arial'
        	            }
        	        }]
        	    });*/
			
         }
</script>


<script type="text/javascript">
Ext.onReady(function(){
	${portletNamespace}_renderDashboard('${portletNamespace}accountsDIV', '${portletNamespace}industryChartDIV');
});
</script>

