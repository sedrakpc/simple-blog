angular.module('blog.services')
.factory("Article", function ($resource) {
    return $resource("/rest/article/:id", {id: "@id"}, {
        update: {
            method: 'PUT'
        }
    });
})
.service('fileService', function($http, $q, appConfig) {
    return {
        uploadFile: function(file) {
            var fd = new FormData();
            var uploadUrl = appConfig.server.contextPath + '/rest/article/file';
            var defer = $q.defer();
            fd.append('file', file);
            $http.post(uploadUrl, fd, {
                    transformRequest: angular.identity,
                    headers: {'Content-Type': undefined}
                })
                .success(function(data){
                    defer.resolve(data);
                })
                .error(function(error){
                    defer.resolve(error);
                });
            return defer.promise;
        }
    };
});