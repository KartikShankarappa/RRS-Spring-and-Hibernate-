(function () {
	'use strict';

	angular
	.module('rrsApp')
	.controller('HomeController', HomeController);

	HomeController.inject = ['$rootScope', '$location', 'loginService', '$scope', '$cookieStore'];

	function HomeController ($rootScope, $location, loginService, $scope, $cookieStore) {
		var homeVm = this;
		homeVm.hasloggedIn = false;
		console.log("Inside Home Controller");
		
		if($cookieStore.get('userName') != null) {
			homeVm.hasloggedIn = true;
		}

		$scope.isCollapsed = true;

		$rootScope.$on('loginEvent', function(event, args) {
			homeVm.hasloggedIn = args;
		});

		homeVm.logout = logout;

		function logout() {

			console.log("Logout Credentials is: ");
			console.log($cookieStore.get('userCredentials'));
//			console.log($rootScope.userCredentials);
//			loginService.logoutUser($rootScope.userCredentials)
//				.then(successFn, errorFn);
			
			loginService.logoutUser($cookieStore.get('userCredentials'))
			.then(successFn, errorFn);

			function successFn(response) {
				homeVm.hasloggedIn = false;
//				$rootScope.userCredentials = null;
//				$rootScope.username = null;
//				$rootScope.token = null;
//				console.log("The credentials after logout is: " + $rootScope.userCredentials);
//				console.log("The username after logout is: " + $rootScope.username);
//				console.log("The token after logout is: " + $rootScope.token);
				
				$cookieStore.remove('userCredentials');
				$cookieStore.remove('userName');
				$cookieStore.remove('token');
				
				console.log("The credentials after logout is: " + $cookieStore.get('userCredentials'));
				console.log("The username after logout is: " + $cookieStore.get('userName'));
				console.log("The token after logout is: " + $cookieStore.get('token'));
				

				$scope.isCollapsed = !$scope.isCollapsed;

				$location.path('/home');
			}

			function errorFn(error) {
				console.log("Logout did not happen");
				console.log(error);
			}
		}


	}

})();