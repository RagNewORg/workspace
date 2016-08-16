<%@ include file="/init.jsp"%>
<liferay-portlet:resourceURL var="ajaxCallResourceURL"
	id='${portletNamespace}Opps' />
<div id='mainOppsDiv'>
	<!-- <div id='oppsMessageDiv' style="font: normal 11px/13px tahoma,arial,verdana,sans-serif;padding: 3px 6px 10px 6px">
		Show All<a href="#" onclick="showAllOpps();return false;">
			Opportunities</a>
	</div> -->
	
	<div id="${portletNamespace}oppsGridDIV"></div>
	<br />
	<div id="${portletNamespace}oppsGraphDIV"></div>
</div>
<script>

		Ext.require([
             'Ext.form.*',
             'Ext.data.*',
	         'Ext.chart.*',
             'Ext.grid.Panel',
             'Ext.layout.container.Column'
         ]);
         
		function showAllOpps(){
			store3.clearFilter();
			//document.getElementById("oppsMessageDiv").style.display = 'none';
		}
	
		function filterOppsByAccount(acId){
			 store3.clearFilter();
		    // store3.filter('accountId',acId);
		    // document.getElementById("oppsMessageDiv").style.display = 'block';
		}
		
		var store3 = null;
		var graphStore = null;

        function ${portletNamespace}renderOppsDashboard(oppsDIV){
        	 console.log('executing-' + '<%= ajaxCallResourceURL.toString() %>');
        	 console.log('executing-' + '${portletNamespace}renderDashboard');
        	 var me = this;
        	 var filterAccountId = null;
        	// document.getElementById("oppsMessageDiv").style.display = 'none';
        	 Liferay.on(
        				"SalesforceAccountClickEvent",
        				function(data) {
        					var acId = data.accountId;
        					var accountName = data.accountName;
        					filterAccountId = acId;
        					filterOppsByAccount(acId);
        				}
        	 );
        	
        	 store3 = new Ext.data.Store({
  		        // load using HTTP
  		        type: 'json',
  		        fields: [
  		            {name: 'name', mapping: 'Name'},
                    {name: 'amount', mapping: 'Amount', type: 'int'},
                    {name: 'probability', mapping: 'Probability', type: 'int'},
                    {name: 'fiscalQuarter', mapping: 'FiscalQuarter'},
                    {name: 'fiscalYear', mapping: 'FiscalYear'},
                    {name: 'leadSource', mapping: 'LeadSource'},
                    {name: 'expectedRevenue', mapping: 'ExpectedRevenue', type: 'int'},
                    {name: 'oppId', mapping: 'id'}
  		        ],
	  		    proxy     : {
	  	            type   : 'ajax',
	  	            url    : '<%=ajaxCallResourceURL.toString()%>',
	  	          	extraParams: {
	  	          		<portlet:namespace />type: 'opps'
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
  	        store3.load();
  	        showAllOpps();
  	       
  	        graphStore = new Ext.data.Store({
		        // load using HTTP
		        type: 'json',
		        fields: [
		         {name: 'name', mapping: 'Name'},
                 {name: 'amount', mapping: 'Amount', type: 'int'},
                 {name: 'probability', mapping: 'Probability', type: 'int'},
                 {name: 'fiscalQuarter', mapping: 'FiscalQuarter'},
                 {name: 'fiscalYear', mapping: 'FiscalYear'},
                 {name: 'leadSource', mapping: 'LeadSource'},
                 {name: 'expectedRevenue', mapping: 'ExpectedRevenue', type: 'int'},
                 {name: 'oppId', mapping: 'id'}
		        ],
	  		    proxy     : {
	  	            type   : 'ajax',
	  	            url    : '<%=ajaxCallResourceURL.toString()%>',
	  	          	extraParams: {
	  	          		<portlet:namespace />type: 'opps'
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
  	        graphStore.load();
  	        graphStore.clearFilter();
  	       
  	       var oppsGrid = Ext.create('Ext.grid.Panel', {
        	        title: 'Salesforce Opportunites',
        	        store: store3,
        	        height: 300,
        	        columns: [{
        	            text: 'Name',
        	            dataIndex: 'name',  
        	            width: 200, 
        	            autoSizeColumn: true
        	        }, {
        	            text: 'Amount',
        	            renderer: Ext.util.Format.usMoney,
        	            dataIndex: 'amount',
        	            flex: 1
        	        }, {
        	            text: 'Probability',
        	            dataIndex: 'probability'
        	        }, {
        	            text: 'Expected Revenue',
        	            renderer: Ext.util.Format.usMoney,
        	            dataIndex: 'expectedRevenue'
        	        }],
        	        listeners: {
                        selectionchange: function(model, records) {
                            var fields;
                            if (records[0]) {
                                selectedRec = records[0];
                                updateBarGraph(selectedRec);
                            }
                        }
                    },
        	        renderTo: oppsGridDIV
        	 });
  	       
         
  	      
  	        var oppsGraph = new Ext.chart.Chart({
  	        renderTo: Ext.getBody(),
  	        width: '100%',
  	        height: 800,
  	        animate: true,
  	        store: graphStore,
  	        insetPadding: 40,
  	        legend: {
  	          position: 'right'  
  	        },
  	        items: [{
              type  : 'text',
              text  : 'Opportunity Amount vs. Expected Revenue',
              font  : '22px Helvetica',
              width : 100,
              height: 30,
              x : 40, //the sprite x position
              y : 12  //the sprite y position
            }],
  	        axes: [{
  	            type: 'Numeric',
  	            position: 'bottom',
  	            fields: ['amount', 'expectedRevenue'],
  	            minimum: 0,
  	            label: {
  	            	renderer: Ext.util.Format.usMoney
  	            },
  	            grid: true,
  	            title: 'Revenue'
  	        }, {
  	            type: 'Category',
  	            position: 'left',
  	            fields: ['name'],
  	            title: 'Opportunity'
  	        }],
  	        series: [{
  	            type: 'bar',
  	            axis: 'bottom',
  	            title: [ 'Amount', 'Expected Revenue' ],
  	            xField: 'name',
  	            yField: ['amount', 'expectedRevenue'],
  	            style: {
                  opacity: 0.80
                },
                highlight: {
                  fill: '#000',
                  'stroke-width': 2,
                  stroke: '#000'
                }
  	        }],
  	      	renderTo: oppsGraphDIV
  	    });
  	     
  	    updateBarGraph = function(rec) {
			graphStore.loadData([
		    {
		        'name': rec.get('name'),
		        'amount': rec.get('amount'),
		        'expectedRevenue': rec.get('expectedRevenue')
		    }]);
			oppsGraph.setHeight(200);
  	    }	
      }
      
</script>


<script type="text/javascript">
Ext.onReady(function(){
	${portletNamespace}renderOppsDashboard('${portletNamespace}oppsDIV');
});
</script>

