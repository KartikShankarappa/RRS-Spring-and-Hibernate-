(function() {
    'use strict';

    angular
        .module('rrsApp')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['loginService', '$location','adminAccessService', '$rootScope', '$timeout', '$cookieStore'];

    function LoginController(loginService, $location, adminAccessService, $rootScope, $timeout, $cookieStore) {
        var loginVm = this;
        loginVm.details = {};
        loginVm.errorShow = false;
        console.log("Inside Login controller");
        console.log(loginVm);

        loginVm.auhenticateUserCredentials = auhenticateUserCredentials;

        function auhenticateUserCredentials() {

            loginService.validateUser(loginVm.details)
                .then(successFn, errorFn);

            function successFn(response) {

                if(response.token !== null) {
                    loginVm.result = response;
                    adminAccessService.data = response;
//                    $rootScope.userCredentials = response;
//                    $rootScope.username = response.emailId;
//                    $rootScope.token = response.token;
                    
                    $cookieStore.put('userCredentials', response);
                    $cookieStore.put('userName', response.emailId);
                    $cookieStore.put('token', response.token);
                    
                    console.log("UserCredentials is : " + $cookieStore.get('userCredentials'));
                    console.log("UserName is : " + $cookieStore.get('userName'));
                    console.log("Token is : " + $cookieStore.get('token'));
                    
                    

//                    console.log("credentials is: ");
//                    console.log($rootScope.userCredentials);
//                    console.log("Username is: "+ $rootScope.username);
//                    console.log("Token is: "+ $rootScope.token);

                    $timeout(function(){
                        $rootScope.$broadcast('loginEvent', true);
                    }, 100);
                    console.log(response);

                    $location.path('/adminAccess');
                }
            }

            function errorFn(error) {
                console.log(error);
                loginVm.errorShow = true;
            }
        }




    }
})();