angular.module('blog.utils', [])
.factory('utils', ['$rootScope', '$sce', '$filter', '$location', function($rootScope, $sce, $filter, $location) {
    var utils = {
        getParameterByName: function (name) {
            //Some magic code below :)
            name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
            var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
                results = regex.exec(location.hash);
            return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
        },
        redirectToUrl: function (url) {
            if(!url) {
                url = $rootScope.server.pageNotFoundUrl;
            }
            window.location.href = url;
        },
        showAjaxLoader: function () {
            $rootScope.showAjaxLoader = true;
        },
        hideAjaxLoader: function () {
            $rootScope.showAjaxLoader = false;
        },
        getImageUrl: function (id) {
            return $sce.trustAsResourceUrl($rootScope.server.contextPath + "getFile?id=" + id);
        }
    };
    return utils;
}]);