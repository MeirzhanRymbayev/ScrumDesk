'use strict';
App.factory('TaskService', ['$http', '$q', function ($http, $q) {

    return {
        fetchAllTasks: function () {
            return $http.get('http://localhost:8081/task/')
                .then(
                    function (response) {
                        return response.data;
                    },
                    function (errResponse) {
                        console.log('Error while fetching tasks');
                        return $q.reject(errResponse);
                    }
                );
        },

        updateTask: function (task, id) {
            return $http.put('http://localhost:8081/task/' + id, task)
                .then(
                    function (response) {
                        return response.data;
                    },
                    function (errResponse) {
                        console.log('Error while updating task');
                        return $q.reject(errResponse);
                    }
                );
        },

        replaceTask : function (id, arrayfrom, arrayto, status, task) {
            for (var i = 0; i < arrayfrom.length; i++) {
                if (arrayfrom[i].id == id) {
                    task.status = status;
                    arrayto.push(task);
                    arrayfrom.splice(i, 1);   //The array.splice(index, howmany, item, ...) adds/removes items to/from array, and returns the removed item(s)
                }
            }

            this.updateTask(task, id); // update task in back-end
        }


    };

}]);