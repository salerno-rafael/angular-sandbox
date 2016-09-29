 (function(){
 	var crudApp = angular.module('crudApp',[]);

	 crudApp.controller('DbController', function($scope,$http) {
	 
	 	getInfo();
	 	  function getInfo(){
			$http.get('http://localhost:8080/list').success(function(data){
				$scope.details = data;

			});
		}
		
	// Setting default value of gender
	$scope.empInfo = {'gender' : 'male'};
	// Enabling show_form variable to enable Add employee button
	$scope.show_form = true;
	// Function to add toggle behaviour to form
	$scope.formToggle =function(){
	$('#empForm').slideToggle();
	$('#editForm').css('display', 'none');
}

	$scope.insertInfo = function(info){
		$http.post('http://localhost:8080/insert',{"emp_name":info.name,"emp_email":info.email,"emp_address":info.address,"emp_gender":info.gender}).success(function(data){
			if (data == true) {
				getInfo();

				$('#empForm').css('display', 'none');
				}
			});
	}

	$scope.currentUser = {};
	
	$scope.editInfo = function(info){
		$scope.currentUser = info;
		$('#empForm').slideUp();
		$('#editForm').slideToggle();
	}

	$scope.UpdateInfo = function(info){
		$http.post('http://localhost:8080/update',{"id":info.emp_id,"name":info.emp_name,"email":info.emp_email,"address":info.emp_address,"gender":info.emp_gender}).success(function(data){
		$scope.show_form = true;
		if (data == true) {
		getInfo();
		}
		});
	}

	$scope.deleteInfo = function(info){
		$http.post('http://localhost:8080/delete',{"del_id":info.emp_id}).success(function(data){
		if (data == true) {
		getInfo();
		}
		});
	}

$scope.updateMsg = function(emp_id){
$('#editForm').css('display', 'none');
}

	});
})();



