'use strict';
App.controller('AppController', ['$scope', 'TaskService', function($scope, TaskService){

    var self = this;
    self.notreadytasks=[];
    self.readytasks=[];
    self.task = {id: null, text: '', status: ''};

    self.fetchAllTasks = function(){
        TaskService.fetchAllTasks()
            .then(
                function(d){
                    self.notreadytasks = d;
                },
                function(errResponse){
                    console.log('Error while fetching tasks')
                }
            );
    };

    self.updateTask = function(task, id){
        TaskService.updateTask(task, id)
            .then(
                self.fetchAllTasks
                ,
                function(errResponse){
                    console.log('Error while updating task')
                }
            );
    };

    self.fetchAllTasks();



}]);