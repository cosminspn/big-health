/**
 * Created by CosminS on 3/25/14.
 */
'use strict';

bhApp.controller('DoctorsCtrl', ['$scope', 'DoctorsFactory', function($scope, DoctorsFactory) {
    // Instantiate an object to store your scope data in (Best Practices)
    $scope.data = {};
    $scope.data.doctors = [];

    DoctorsFactory.get(function(response) {
        // Assign the response INSIDE the callback
        console.log(response);
        $scope.data.doctors = response ? response.list : [];
    });
}]);