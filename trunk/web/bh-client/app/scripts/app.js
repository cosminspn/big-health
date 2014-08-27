'use strict';

var bhApp = angular.module('bhClientApp', [
  'ngCookies',
  'ngResource',
  'ngSanitize',
  'ngRoute'
]);

bhApp.config(function($routeProvider, $httpProvider) {
    $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];
        $httpProvider.defaults.withCredentials = true;
    $routeProvider.
      when('/users/getUsers', {
        templateUrl: 'views/usersView.html',
        controller: 'UsersCtrl'
      }).
       when('/doctors/getDoctors', {
        templateUrl: 'views/doctorsView.html',
        controller: 'DoctorsCtrl'
      }).
      otherwise({
        redirectTo: '/users/getUsers'
      });
  });

bhApp.controller('AppCtrl', ['$scope',  function($scope) {

}]);