angular.module("AppMod", ["ngRoute"])

	.controller("AppCtrl", ['$http','$routeParams',function($http,$routeParams) {
		var self = this;
		self.id = $routeParams.studentId;
		
		$http.get('http://localhost:8080/student')
			.then(function(resp){
				self.students = resp.data;
			},function(err) {

			});

		$http.get('http://localhost:8080/student/'+self.id)
			.then(function(resp){
				self.studentDetail = resp.data;
			},function(err){

			});
			

	}])
	.config(['$routeProvider', function($routeProvider) {

		$routeProvider
		.when('/', {
			templateUrl: 'views/home.view.html'

		}).when('/student', {
			templateUrl: 'views/student.view.html',
			controller: 'AppCtrl',
			controllerAs: 'ctrl'

		}).when('/about', {
			templateUrl: 'views/about.view.html'

		}).when('/student/:studentId', {
			templateUrl: 'views/studentDetail.view.html',
			controller: 'AppCtrl',
			controllerAs: 'ctrl'

		}).otherwise({redirectTo: '/'});

	}]); // end config
