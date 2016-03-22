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
                    self.alltasks = [];
                    self.notreadytasks=[];
                    self.inprogresstasks=[];
                    self.readytasks=[];
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

    self.getTaskObject = function(id){
      for(var i = 0; i < self.alltasks.length; i++){
          if(self.alltasks[i].id === id) {
              self.task = angular.copy(self.alltasks[i]);
              break;
          }
      }
    };


    /***************************Status change methods****************************************************/

    self.makeNotReadyInProgress = function(id){
        self.getTaskObject(id);
        TaskService.replaceTask(id, self.notreadytasks, self.inprogresstasks, 'in progress', self.task);
        TaskService.fetchAllTasks();
    }

    self.makeNotReadyDone = function(id) {
        self.getTaskObject(id);
        TaskService.replaceTask(id, self.notreadytasks, self.readytasks, 'done', self.task);
        TaskService.fetchAllTasks();
    };

    self.makeInProgressToDo = function(id) {
        self.getTaskObject(id);
        TaskService.replaceTask(id, self.inprogresstasks, self.notreadytasks, 'to do', self.task);
        TaskService.fetchAllTasks();
    };

    self.makeInProgressDone = function(id) {
        self.getTaskObject(id);
        TaskService.replaceTask(id, self.inprogresstasks, self.readytasks, 'done', self.task);
        TaskService.fetchAllTasks();
    };

    self.makeDoneToDo = function(id) {
        self.getTaskObject(id);
        TaskService.replaceTask(id, self.readytasks, self.notreadytasks, 'to do', self.task);
        TaskService.fetchAllTasks();
    };

    self.makeDoneInProgress = function(id) {
        self.getTaskObject(id);
        TaskService.replaceTask(id, self.readytasks, self.inprogresstasks, 'in progress', self.task);
        TaskService.fetchAllTasks();
    };

    /****************************************************************************************************/

    self.fetchAllTasks();

    //self.arraysLength();

    //self.distributeTasks();





}]);