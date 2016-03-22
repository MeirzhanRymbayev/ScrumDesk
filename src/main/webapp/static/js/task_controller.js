'use strict';
App.controller('AppController', ['$scope', 'TaskService', function($scope, TaskService){

    var self = this;
    self.alltasks = [];
    self.notreadytasks=[];
    self.inprogresstasks=[];
    self.readytasks=[];
    self.task = {id: null, text: '', status: ''};

    self.fetchAllTasks = function(){
        TaskService.fetchAllTasks()
            .then(
                function(response){
                    self.alltasks = response;
                    console.log('Data from server was loaded')
                },
                function(errResponse){
                    console.log('Error while fetching tasks')
                }
            )
            .then(
                self.distributeTasks,
                function(errResponse){
                    console.log('Error while distributing tasks')
                }
            )
            .then(
                self.arraysLength,
                function(errResponse){
                    console.log('Error while define arrays length')
                }
            );
    };

    self.distributeTasks = function(){
                    for(var i = 0; i < self.alltasks.length; i++) {
                        var currenttask = self.alltasks[i];
                        if (currenttask.status == 'to do') {
                            self.task = angular.copy(currenttask);
                            self.notreadytasks.push(self.task);

                        }
                        else if (currenttask.status == 'in progress') {
                            self.task = angular.copy(currenttask);
                            self.inprogresstasks.push(self.task);
                            //console.log('INPROGRESS task: ' + currenttask.text)
                        } else if (currenttask.status == 'done') {
                            self.task = angular.copy(currenttask);
                            self.readytasks.push(self.task);
                        }
                    }
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

    self.arraysLength = function(){
      console.log('self.alltasks.length = ' + self.alltasks.length)
      console.log('self.notreadytasks.length = ' + self.notreadytasks.length)
      console.log('self.inprogresstasks.length = ' + self.inprogresstasks.length)
      console.log('self.readytasks.length = ' + self.readytasks.length)
    };

    self.fetchAllTasks();

    //self.arraysLength();

    //self.distributeTasks();

    self.replace = function(id){
        for(var i = 0; self.notreadytasks.length; i++){
            self.task = self.notreadytasks[i].id;
            if(self.task == id){
                self.readytasks.push(self.task);
                self.notreadytasks.splice(i, 1);
                fetchAllTasks();
            }
        }
    };



}]);