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
            .state('article', {
                url: '/article/:id',
                templateUrl: './media/html/article.html',
                controller: 'articleController'
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
    '$rootScope', '$scope', '$log', '$filter', '$state', 'utils', 'Article',
    function ($rootScope, $scope, $log, $filter, $state, utils, Article) {
        $scope.posts = [];
        utils.showAjaxLoader();
        Article.query(function(data) {
            $scope.posts = data;
            console.log(data);
            utils.hideAjaxLoader();
        });
    }
])
.controller('articleController', [
    '$rootScope', '$scope', '$log', '$filter', '$state', '$stateParams', 'utils', 'Article',
    function ($rootScope, $scope, $log, $filter, $state, $stateParams, utils, Article) {
        $(window).scrollTop(0);
        $scope.articleId = $stateParams.id;
        $scope.post;

        utils.showAjaxLoader();
        var article = new Article({id:$scope.articleId});
        article.$get({},function(data){
            $scope.post = data;
            utils.hideAjaxLoader();
        }, function(failedResponse){
            //on failure
        });
    }
])
.controller('createController', [
    '$rootScope', '$scope', '$log', '$filter', '$state', 'utils', 'Article', 'fileService',
    function ($rootScope, $scope, $log, $filter, $state, utils, Article, fileService) {
        $scope.editor;
        $scope.post = {};

        $scope.save = function() {
            utils.showAjaxLoader();
            var article = new Article($scope.post);
                article.$save({}, function (data) {
                    utils.hideAjaxLoader();
                    $state.go('article', {id:data.id});
                }, function (failedResponse) {
                    utils.hideAjaxLoader();
                    //on failure
                });
        };

        $scope.imageUpload = function(files) {
            utils.showAjaxLoader();
            fileService.uploadFile(files[0])
            .then(function (data) {
                var id = data.id;
                $scope.editor.summernote('insertImage', utils.getImageUrl(id), data.name);
                utils.hideAjaxLoader();
            }, function (error) {
                utils.hideAjaxLoader();
            });

        };
    }
]);