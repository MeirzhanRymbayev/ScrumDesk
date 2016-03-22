'use strict';
App.factory('TaskService', ['$http', '$q', function ($http, $q) {

    return {
        fetchAllTasks : function(){
            return $http.get('http://localhost:8081/task/')
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse) {
                        console.log('Error while fetching tasks');
                        return $q.reject(errResponse);
                    }
                );
        },
        
        updateTask : function(task, id){
            return $http.post('http://localhost:8081/task/'+id, task)
                .then(
                    function(response) {
                        return response.data;
                    }, 
                    function(errResponse) {
                        console.log('Error while updating task');
                        return $q.reject(errResponse);
                    }
                );
        }
    };

}]);