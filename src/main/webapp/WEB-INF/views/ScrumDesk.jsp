<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>ScrumDesk application</title>
</head>
<body ng-app="myApp" class="ng-cloak">
<div ng-controller="AppController as ctrl">
    <h2>Hello World!</h2>

    <form action="/task/">
        <table>
            <tr>
                <td>----------To Do--------------<br/>
            <tr ng-repeat="task in ctrl.notreadytasks">
                <td><span ng-bind="task.id"></span></td>
                <td><span ng-bind="task.text"></span></td>
                <td><span ng-bind="task.status"></span></td>
                <td>
                    <button type="button" ng-click="ctrl.replace(task.id)">Replace</button>
                </td>
            </tr>
            </td>

            <td>-------In progress-----------<br/>
                <tr ng-repeat="task in ctrl.readytasks">
                    <td><span ng-bind="task.id"></span></td>
                    <td><span ng-bind="task.tasktext"></span></td>
                    <td><span ng-bind="task.taskstatus"></span></td>
                    <td>
                        <button type="button" ng-click="ctrl.replace(task.id)">Replace</button>
                    </td>
                </tr>
            </td>

            </tr>
        </table>
        <input type="submit">
    </form>
</div>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <script src="<c:url value='/static/js/app.js' />"></script>
    <script src="<c:url value='/static/js/task_service.js' />"></script>
    <script src="<c:url value='/static/js/task_controller.js' />"></script>
</body>
</html>
