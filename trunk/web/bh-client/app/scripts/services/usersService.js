'use strict';

bhApp.factory('UsersFactory', function($resource){
	return $resource('http://localhost:8080/bh-rest-loader/rest/users/getUsers',{
  }
);
});