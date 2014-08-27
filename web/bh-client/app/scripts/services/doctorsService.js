/**
 * Created by CosminS on 3/25/14.
 */
'use strict';

bhApp.factory('DoctorsFactory', function($resource){
    return $resource('http://localhost:8080/bh-rest-loader/rest/doctors/getDoctors',{
        }
    );
});