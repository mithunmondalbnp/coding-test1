angular.module('shipmentCreation', []).
controller('shipmentCreationController', function($scope, $timeout, $http) {
    console.log("Inside recipe manager controller");
       $scope.widgetForm = {};
       $scope.id = null;
       
       $scope.saveWidget = function() {
       $scope.widgetForm.productionDate = $("#productionDate").val();
       $http({
		  method  : 'POST',
		  url     : 'widget',
		  data    : $scope.widgetForm,
	  	})
	    .success(function(data){
	    	$scope.widgetForm = data;
	    	setTimeout(function() {
                toastr.options = {
                    closeButton: true,
                    progressBar: true,
                    showMethod: 'slideDown',
                    timeOut: 4000
                };
                if($scope.widgetForm.messageType == "Success"){
                	toastr.success($scope.widgetForm.successOrErrorMessage);
                }else{
                	toastr.error($scope.widgetForm.successOrErrorMessage);
                }
            }, 1300);
	    });
      };
      
      $scope.getWidget = function() {
    	$scope.id = $("#recipes").val();
        $http({
   		  method  : 'GET',
   		  url     : 'widget/' + $scope.id,
   	  	})
   	    .success(function(data){
   	    	$scope.widgetForm = data;
   	    });
      };
      
      $scope.deleteWidget = function() {
    	  $scope.id = $("#recipes").val();
    	  if($scope.id == ""){
    		  toastr.options = {
                      closeButton: true,
                      progressBar: true,
                      showMethod: 'slideDown',
                      timeOut: 4000
                  };
    		  	toastr.error("Please select a widget");
    	  }else{
	      $http({
	 		  method  : 'DELETE',
	 		  url     : 'widget/' + $scope.id,
	 	  	})
	 	    .success(function(data){
	 	    	$scope.widgetForm = data;
	 	    	toastr.options = {
	                    closeButton: true,
	                    progressBar: true,
	                    showMethod: 'slideDown',
	                    timeOut: 4000
	                };
	                if($scope.widgetForm.messageType == "Success"){
	                	toastr.success($scope.widgetForm.successOrErrorMessage);
	                }else{
	                	toastr.error($scope.widgetForm.successOrErrorMessage);
	                }
	 	    });
      	  }
	  };
});