'use strict';

bhApp.controller('UsersCtrl', ['$scope', 'UsersFactory', function($scope, UsersFactory) {
    // Instantiate an object to store your scope data in (Best Practices)
    $scope.data = {};
    $scope.data.users = [];

    UsersFactory.get(function(response) {
      // Assign the response INSIDE the callback
      console.log(response);
      $scope.data.users = response ? response.list : [];
    });

    //UsersFactory.put(function(response))
  }]);
