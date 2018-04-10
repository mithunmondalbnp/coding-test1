function getWidget(){
	if ($.fn.dataTable.isDataTable('#WidgetTable')) {
		var oTable = $('#WidgetTable').dataTable();
		oTable.fnDestroy();
	}
	//var rowCount = 0;
	//var columns = [ "serialNumber", "color", "productionDate" ];
	var dt = $('#WidgetTable').DataTable({
        responsive: true,
        "dom": 'T<"clear">lfrtip',
        /* "tableTools": {
            "sSwfPath": "js/plugins/dataTables/swf/copy_csv_xls_pdf.swf"
        } */
        "processing" : false,
		"serverSide" : false,
		"sort" : "position",
		"searching":true,
		"sPaginationType" : "full_numbers",
		"lengthChange" : false,
		"iDisplayLength" : 10,
		"bFilter" : true,
		"aaSorting": [[2,"desc"]],
		"ajax" : {
			"url" : "getWidgetList",
			"type" : 'POST',
			"data" : function(d) {
				/* d.start = d.start / d.length;
				d.sortDirection = d.order[0].dir;
				d.serialNumber = $("#serialNumber").val();
				d.fieldForSorting = columns[d.order[0].column] */
			}
		},
		"columnDefs" : [{
			"targets" : 0,
			"searchable" : true,
			'bSortable' : true,
			"data" : "serialNumber",
			"width" : "20%",
			"render" : function (data, type, full) {
				if (data == null || data == "") {
					return '-'
				}else{
					return data;
				}
			}
		},{
			"targets" : 1,
			"searchable" : true,
			'bSortable' : true,
			"data" : "color",
			"width" : "30%",
			"render" : function (data, type, full) {
				if (data == null || data == "") {
					return '<span>-<span>'
				}else{
					return data;
				}
			}
		},{
			"targets" : 2,
			"searchable" : true,
			'bSortable' : true,
			"data" : "productionDate",
			"width" : "50%",
			"render" : function (data, type, full) {
				if (data == null || data == "") {
					return '<span>-<span>'
				}else{
					return data;
				}
			}
		}]
    });
}

function getShipment(){
	if ($.fn.dataTable.isDataTable('#ShipmentTable')) {
		var oTable = $('#ShipmentTable').dataTable();
		oTable.fnDestroy();
	}
	//var rowCount = 0;
	//var columns = [ "serialNumber", "color", "productionDate" ];
	var dt = $('#ShipmentTable').DataTable({
        responsive: true,
        "dom": 'T<"clear">lfrtip',
        "processing" : false,
		"serverSide" : false,
		"sort" : "position",
		"searching":true,
		"sPaginationType" : "full_numbers",
		"lengthChange" : false,
		"iDisplayLength" : 10,
		"bFilter" : true,
		"aaSorting": [[2,"desc"]],
		"ajax" : {
			"url" : "getShipmentList",
			"type" : 'POST',
			"data" : function(d) {
				/* d.start = d.start / d.length;
				d.sortDirection = d.order[0].dir;
				d.serialNumber = $("#serialNumber").val();
				d.fieldForSorting = columns[d.order[0].column] */
			}
		},
		"columnDefs" : [{
			"targets" : 0,
			"searchable" : true,
			'bSortable' : true,
			"data" : "shipmentName",
			"width" : "20%",
			"render" : function (data, type, full) {
				if (data == null || data == "") {
					return '-'
				}else{
					return data;
				}
			}
		},{
			"targets" : 1,
			"searchable" : true,
			'bSortable' : true,
			"data" : "widgets",
			"width" : "30%",
			"render": function (data, type, row) {
                var ddl = "<select size='1' id='row-1-division' name='row-1-division'>";
                for (var i = 0; i < data.length; i++) {
                    ddl = ddl + "<option value='data[i].widgetId'>" + " Serial Number - "+data[i].serialNumber + " Color - "+ data[i].color + " Production Date - " + data[i].productionDate + "</option>".replace("data[i]", data.division);
                }
                ddl += "</select>";
                return ddl;
            }
		},{
			"targets" : 2,
			"searchable" : true,
			'bSortable' : true,
			"data" : "createdOn",
			"width" : "50%",
			"render" : function (data, type, full) {
				if (data == null || data == "") {
					return '<span>-<span>'
				}else{
					return data;
				}
			}
		}]
    });
}

function getWidget1(){
	if ($.fn.dataTable.isDataTable('#WidgetTable1')) {
		var oTable = $('#WidgetTable1').dataTable();
		oTable.fnDestroy();
	}
	//var rowCount = 0;
	//var columns = [ "serialNumber", "color", "productionDate" ];
	var dt = $('#WidgetTable1').DataTable({
        responsive: true,
        "dom": 'T<"clear">lfrtip',
        "processing" : false,
		"serverSide" : false,
		"sort" : "position",
		"searching":true,
		"sPaginationType" : "full_numbers",
		"lengthChange" : false,
		"iDisplayLength" : 10,
		"bFilter" : true,
		"aaSorting": [[3,"desc"]],
		"ajax" : {
			"url" : "getWidgetList",
			"type" : 'POST',
			"data" : function(d) {
				/* d.start = d.start / d.length;
				d.sortDirection = d.order[0].dir;
				d.serialNumber = $("#serialNumber").val();
				d.fieldForSorting = columns[d.order[0].column] */
			}
		},
		"columnDefs" : [{
          'targets': 0,
          "mData": "widgetId",
          'searchable': false,
          'orderable': false,
          'className': 'dt-body-center',
          'render': function (data, type, full, meta){
          return '<input type="checkbox" name="widgetList[]" value="' + data + '">'; 
          }
        },{
			"targets" : 1,
			"searchable" : true,
			'bSortable' : true,
			"data" : "serialNumber",
			"width" : "20%",
			"render" : function (data, type, full) {
				if (data == null || data == "") {
					return '-'
				}else{
					return data;
				}
			}
		},{
			"targets" : 2,
			"searchable" : true,
			'bSortable' : true,
			"data" : "color",
			"width" : "30%",
			"render" : function (data, type, full) {
				if (data == null || data == "") {
					return '<span>-<span>'
				}else{
					return data;
				}
			}
		},{
			"targets" : 3,
			"searchable" : true,
			'bSortable' : true,
			"data" : "productionDate",
			"width" : "40%",
			"render" : function (data, type, full) {
				if (data == null || data == "") {
					return '<span>-<span>'
				}else{
					return data;
				}
			}
		}]
    });
}
$('#addShipmentForm').on('submit', function(e){
   $('#shipmenList option').remove();
   var flag= false;
   $("input[name='widgetList[]']").each( function () {
	   if ($(this).prop('checked')==true){
		   flag = true;
	   }
   });
   $('.table-striped tr').each(function () {
        //processing this row
        //how to process each cell(table td) where there is checkbox
        $(this).find('td input:checked').each(function () {
        	 $('<option>').val(this.value).text(this.value).appendTo('#shipmenList').prop("selected", true);
        });
   });
   
   var widgetCount = $('select#shipmenList option').length;
   if(widgetCount < 1){
	   toastr.options = {
           closeButton: true,
           progressBar: true,
           showMethod: 'slideDown',
           timeOut: 4000
       };
	   toastr.error("Please select at least one widget");
	   $(":submit").removeAttr("disabled");
	   return false;
   }else if(widgetCount > 10){
	   toastr.options = {
           closeButton: true,
           progressBar: true,
           showMethod: 'slideDown',
           timeOut: 4000
       };
	   toastr.error("Widget count cannot be more than 10");
	   $(":submit").removeAttr("disabled");
	   return false;
   }else{
	    var shipmantName = $("#shipmentName").val();
	    if(shipmantName == ""){
	    	toastr.options = {
	           closeButton: true,
	           progressBar: true,
	           showMethod: 'slideDown',
	           timeOut: 4000
	       };
		   toastr.error("Please enter shipment name");
	    }else{
	    	var wedetsArrayList = [];
	    	$('#shipmenList > option').each(function() {
	    	    wedetsArrayList.push($(this).val());
	    	});
		    var obj = {
				"shipmentId" : $("#shipmentId").val(),
				"shipmentName" : $("#shipmentName").val(),
				"widgets" : wedetsArrayList
			};
			$.ajax({
				url : "shipment",
				data : JSON.stringify(obj),
				dataType:"json",
				type : 'POST',
				contentType : 'application/json',
				success : function(response) {
					toastr.options = {
			           closeButton: true,
			           progressBar: true,
			           showMethod: 'slideDown',
			           timeOut: 4000
			        };
					if(response.messageType == "Success"){
						toastr.success(response.successOrErrorMessage);
					}else{
						toastr.success(response.successOrErrorMessage);
					}
					getShipment();
				},
				error : function(response) {
					toastr.options = {
			           closeButton: true,
			           progressBar: true,
			           showMethod: 'slideDown',
			           timeOut: 4000
			        };
				    toastr.error(response);
					//alert("error" + response);
				}
			});
	    }
   }  
});