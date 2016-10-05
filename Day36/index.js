angular.module("AppMod", [])
.controller("AppCtrl",['$http',function($http){
	self.about = "AppMod";
	

 $http.get("http://localhost:8080/student")
 	.then(function(resp) {
 		
	self.students = resp.data;
	// console.log(self.student)
	console.log(students)
}, function(err) {
});
 	self.reload = function () {
		window.location.reload();
 
}
}])
