angular.module('blog.controllers')
.config([
    '$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('articles', {
                url: '/articles',
                templateUrl: './media/html/articles.html',
                controller: 'articlesController'
            })
            .state('create', {
                url: '/create',
                templateUrl: './media/html/create.html',
                controller: 'createController'
            });
        $urlRouterProvider.otherwise('/articles');
    }
])
.controller('mainController', [
    '$rootScope', '$scope', '$log', '$filter', '$state', 'utils',
    function ($rootScope, $scope, $log, $filter, $state, utils) {

        /*$scope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams) {
            utils.showAjaxLoader();
        });
        $scope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams) {
            utils.hideAjaxLoader();
        });*/
    }
])
.controller('articlesController', [
    '$rootScope', '$scope', '$log', '$filter', '$state', 'utils',
    function ($rootScope, $scope, $log, $filter, $state, utils) {

    }
])
.controller('createController', [
    '$rootScope', '$scope', '$log', '$filter', '$state', 'utils',
    function ($rootScope, $scope, $log, $filter, $state, utils) {
        $scope.post = {};
    }
]);