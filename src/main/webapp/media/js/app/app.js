var blog = angular
    .module('blog', [
        'ui.router',
        'ui.bootstrap',
        'ngResource',
        'summernote',
        'blog.controllers',
        'blog.services',
        'blog.directives',
        'blog.filters',
        'blog.utils'
    ])
    .constant('appConfig', {
        app: {
            commonDateFormat: 'dd.MM.yyyy',
            commonDateTimeFormat: 'dd.MM.yyyy HH:mm:ss',
            commonTimeFormat: 'HH:mm'
        },
        dictionaries: {

        },

        server: {
            contextPath: contextPath,
            pageNotFoundUrl: '/404'
        }
    }).run(['$rootScope', '$state', '$stateParams', 'appConfig', 'utils',
        function ($rootScope, $state, $stateParams, appConfig, utils) {
            //Application configuration
            angular.extend($rootScope, appConfig, {
                showAjaxLoader: false,
                utils: utils
            });
            $rootScope.$state = $state;
            $rootScope.$stateParams = $stateParams;
        }
    ]);

/*
 * Initialize controllers module
 */
var blogControllers = angular.module('blog.controllers', ['ui.router', 'ui.bootstrap', 'ngResource']);

/*
 * Initialize services
 */
var blogServices = angular.module('blog.services', []);

/*
 * Initialize directives
 */
var blogDirectives = angular.module('blog.directives', []);

/*
 * Initialize filters
 */
var blogFilters = angular.module('blog.filters',[]);