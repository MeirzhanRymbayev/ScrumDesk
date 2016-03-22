<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ScrumDesk application</title>
</head>
<body ng-app="myApp" class="ng-cloak">
<div ng-controller="AppController as ctrl">
    <h2>Hello World!</h2>

    <form action="/task/">
        <table border="1">
            <thead>
            <tr>
                <th>----------To Do--------------</th>
                <th>---------In progress---------</th>
                <th>-----------Done--------------</th>
            </tr>
            </thead>

            <tr>
                <td>
                    <div ng-repeat="task in ctrl.notreadytasks">
                        <p ng-bind="task.id"></p>
                        <p ng-bind="task.text"></p>
                        <p ng-bind="task.status"></p>
                        <button type="button" ng-click="ctrl.replace(task.id)">Replace</button>
                    </div>
                </td>

                <td>
                    <div ng-repeat="task in ctrl.inprogresstasks">
                        <p ng-bind="task.id"></p>
                        <p ng-bind="task.text"></p>
                        <p ng-bind="task.status"></p>
                        <button type="button" ng-click="ctrl.replace(task.id)">Replace</button>
                    </div>
                </td>

                <td>
                    <div ng-repeat="task in ctrl.readytasks">
                        <p ng-bind="task.id"></p>
                        <p ng-bind="task.text"></p>
                        <p ng-bind="task.status"></p>
                        <button type="button" ng-click="ctrl.replace(task.id)">Replace</button>
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="<c:url value='/static/js/app.js' />"></script>
<script src="<c:url value='/static/js/task_service.js' />"></script>
<script src="<c:url value='/static/js/task_controller.js' />"></script>
</body>
</html>
