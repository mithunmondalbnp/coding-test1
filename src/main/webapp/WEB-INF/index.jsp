<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shipment Creation</title>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <!-- Toastr style -->
    <link href="resources/css/plugins/toastr/toastr.min.css" rel="stylesheet">
    <!-- Gritter -->
    <link href="resources/js/plugins/gritter/jquery.gritter.css" rel="stylesheet">
    <link href="resources/css/animate.css" rel="stylesheet">
    <link href="resources/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="resources/css/datepickerNew.css">
    
    <link href="resources/css/plugins/dataTables/dataTables.responsive.css" rel="stylesheet">
	<link href="resources/css/plugins/dataTables/dataTables.tableTools.min.css" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
    <script type="text/javascript" src="resources/app.js"></script>
</head>
<style>
	td.details-control {
	    background: url('../resources/details_open.png') no-repeat center center;
	    cursor: pointer;
	}
	tr.shown td.details-control {
	    background: url('../resources/details_close.png') no-repeat center center;
	}
</style>
<body ng-app="shipmentCreation" ng-controller="shipmentCreationController" style="background-color: #f5f5f5;">
    <div id="wrapper">
        <div id="viewRecipe" class="row">
            <div class="col-lg-12">
                <div class="wrapper wrapper-content">
                    
                    <div class="row">
                    	<div class="col-lg-12">
                    		<center><h1>Widget Creation</h1></center>
			                    <div class="ibox float-e-margins">
		                        <!-- <div class="ibox-title">
		                            <h5>Add Widget</h5>
		                        </div> -->
		                        <div class="ibox-content">
		                            <form class="form-horizontal">
		                            	<input type="hidden" ng-model="widgetForm.widgetId">
		                                <div class="form-group"><label class="col-lg-2 control-label">Serial Number</label>
		                                    <div class="col-lg-3">
		                                    	<input type="text" placeholder="Serial Number" class="form-control" ng-model= "widgetForm.serialNumber">
		                                    </div>
		                                </div>
		                                <div class="form-group"><label class="col-lg-2 control-label">Color</label>
		                                    <div class="col-lg-3">
		                                    	<input type="text" placeholder="Color" class="form-control" ng-model= "widgetForm.color">
		                                    </div>
		                                </div>
		                                <div class="form-group"><label class="col-lg-2 control-label">Production Date</label>
		                                    <div class="col-lg-3">
		                                    	<input type="text" placeholder="Production Date" class="form-control" id="productionDate">
		                                    </div>
		                                </div>
		                                <div class="form-group">
		                                    <div class="col-lg-offset-2 col-lg-10">
		                                        <center><button class="btn btn-sm btn-white" type="button" ng-click="saveWidget()">Add Widget</button></center>
		                                    </div>
		                                </div>
		                            </form>
		                        </div>
		                    </div>
		                </div>
                    </div>
                    
                    <div class="row">
			            <div class="col-lg-12">
			            	<center><h1>View Created Widget</h1></center>
			            	<div class="ibox float-e-margins">
		                        <!-- <div class="ibox-title">
		                            <h5>View Widget</h5>
		                        </div> -->
				                <div class="ibox-content">
					                <table class="table table-striped table-bordered table-hover" id="WidgetTable">
						                <thead>
							                <tr>
							                	<th>Serial Number</th>
							                    <th>Color</th>
							                    <th>Production Date</th>
							                </tr>
						                </thead>
					                </table>
				                </div>
					        </div>
					    </div>
                	</div>
                	
                	<div class="row">
			            <div class="col-lg-12">
			            	<center><h1>Shipment Creation</h1></center>
			            	<div class="ibox float-e-margins">
		                        <!-- <div class="ibox-title">
		                            <h5>View Shipment</h5>
		                        </div> -->
				                <div class="ibox-content" id="addShipmentForm">
				                	<form class="form-horizontal">
					                	<input type="hidden" id="shipmentId">
					                	<select multiple="multiple" id="shipmenList"></select>
		                                <div class="form-group"><label class="col-lg-2 control-label">Shipment Name</label>
		                                    <div class="col-lg-8">
		                                    	<input type="text" placeholder="Shipment Name" class="form-control" id="shipmentName">
		                                    </div>
		                                </div>
		                                <br/>
						                <table class="table table-striped table-bordered table-hover" id="WidgetTable1">
							                <thead>
								                <tr>
								                	<th>Select</th>
								                	<th>Serial Number</th>
								                    <th>Color</th>
								                    <th>Production Date</th>
								                </tr>
							                </thead>
						                </table>
						                <br/>
						                <div class="form-group">
		                                    <div class="col-lg-offset-2 col-lg-10">
		                                    	<center><button class="btn btn-sm btn-white" type="submit" id="addShipment">Add Shipment</button></center>
		                                    </div>
		                                </div>
		                            </form>
				                </div>
					        </div>
					    </div>
                	</div>
                	
                	<div class="row">
			            <div class="col-lg-12">
			            	<center><h1>View Created Shipment</h1></center>
			            	<div class="ibox float-e-margins">
		                        <!-- <div class="ibox-title">
		                            <h5>View Shipment</h5>
		                        </div> -->
				                <div class="ibox-content">
					                <table class="table table-striped table-bordered table-hover" id="ShipmentTable">
						                <thead>
							                <tr>
							                	<th>Shipment Name</th>
							                    <th>Widgets</th>
							                    <th>Created On</th>
							                </tr>
						                </thead>
					                </table>
				                </div>
					        </div>
					    </div>
                	</div>
                
            </div>
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="resources/js/jquery-2.1.1.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="resources/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <!-- Flot -->
    <script src="resources/js/plugins/flot/jquery.flot.js"></script>
    <script src="resources/js/plugins/flot/jquery.flot.tooltip.min.js"></script>
    <script src="resources/js/plugins/flot/jquery.flot.spline.js"></script>
    <script src="resources/js/plugins/flot/jquery.flot.resize.js"></script>
    <script src="resources/js/plugins/flot/jquery.flot.pie.js"></script>

    <!-- Peity -->
    <script src="resources/js/plugins/peity/jquery.peity.min.js"></script>
    <script src="resourcesjs/demo/peity-demo.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="resources/js/inspinia.js"></script>
    <script src="resources/js/plugins/pace/pace.min.js"></script>

    <!-- jQuery UI -->
    <script src="resourcesjs/plugins/jquery-ui/jquery-ui.min.js"></script>

    <!-- Toastr -->
    <script src="resources/js/plugins/toastr/toastr.min.js"></script>
    
    <script src="resources/js/bootstrap-datepickerNew.js"></script>
    
    <!-- Data Tables Js-->
	<script src="resources/js/plugins/dataTables/jquery.dataTables.js"></script>
	<script src="resources/js/plugins/dataTables/dataTables.bootstrap.js"></script>
	<script src="resources/js/plugins/dataTables/dataTables.responsive.js"></script>
	<script src="resources/js/plugins/dataTables/dataTables.tableTools.min.js"></script>
	<script type="text/javascript" src="resources/shipment.js"></script>
    <script>
        $(document).ready(function() {
        	$("#getWidget").hide();
        	$("#shipmenList").hide();
        	$( "#recipes" ).change(function() {
        		$("#getRecipe").click();
        	});
        	$('#productionDate').datepicker({
                format: "dd-mm-yyyy"
            });
        	getWidget();
        	getWidget1();
        	getShipment();
        });
    </script>
</body>
</html>
