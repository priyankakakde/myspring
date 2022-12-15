sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"sap/m/MessageBox",
	"sap/m/MessageToast",
	"dorimon/util/service"
], function(Controller, MessageBox, MessageToast, Service){
	return Controller.extend("dorimon.controller.Main",{
		onInit: function(){
			var oModel = new sap.ui.model.json.JSONModel();
			oModel.setData({
				"vendor": {
							    "companyName": "SAP",
							    "contactPerson": "Sakshi",
							    "firstName": "Anjali",
							    "lastName": "Kumari",
							    "website": "www.sap.com",
							    "email": "anjali@sap.com",
							    "status": "A",
							    "regDate": new Date()
							},
				"vendorTab": []			
			});
			this.getView().setModel(oModel);
			this.fetchAndLoadData();
		},
		fetchAndLoadData: function(){
			//Step 1: get the local model access
			var oModel = this.getView().getModel();
			//Step 2: call microservice to load all vendors
			Service.callService("/vendor","GET").then(function(data){
				oModel.setProperty("/vendorTab", data);
				MessageToast.show(data.length.toString() + " Records were loaded");
			}).catch(function(oError){
				MessageBox.error("Data fetch failed");
			});
			
			
		},
		onDelete: function(){
			//Step 1: Get the table object
			//Step 2: Get all the selected records from the table
			//Step 3: Call service api to fire DELETE - Loop
			//Step 4: Handle response
		},
		onSave: function(){
			//Step 1: Access the data from the model - whatever changes user did
			//        will reflect inside model from UI
			var oModel = this.getView().getModel();
			var payload = oModel.getProperty("/vendor");
			var that = this;
			//Step 2: Use the service class object to POST Data
			Service.callService("/vendor", "POST", payload)
			//Step 3: We will display message to user
			.then(function(){
				MessageBox.confirm("Your Vendor is now saved");
				that.fetchAndLoadData().bind(that);
			})
			.catch(function(){
				MessageBox.error("The vendor creation failed");
			});
			
			
			
			//
		},
		onDelete: function(){
			//var aIndices = this.byId("table1").getSelectedIndices();
			var aItems = this.getView().byId('table1').getItems();
//var aSelectedItems = [];
//for (var i=0; i<aItems.length;i++) {
    // if (aItems[i].getSelected()) {
          //aSelectedItems.push(aItems[i]);
     //}
//}
 var table = this.getView().byId("table1"); 
 var rowItems = table.getSelectedItems();
for (var i = 0; i < rowItems.length; i++) 
{ var item = rowItems[i]; 
var context = item.getBindingContext(); 
var obj = context.getProperty(null, context); //alert(obj.Name);
var Cells = item.getCells(); 
// Get ID and Name var ID = Cells[0].getText(); 
//var Name = Cells[1].getValue(); alert("ID:" + ID); alert("Name:" + Name); 
}

		var a;
			Service.callService("/vendor", "POST", obj)
			//Step 3: We will display message to user
			.then(function(){
				MessageBox.confirm("Your Vendor is deleted");
				that.fetchAndLoadData().bind(that);
			})
			.catch(function(){
				MessageBox.error("The vendor creation failed");
			});
			
		}
	});
});