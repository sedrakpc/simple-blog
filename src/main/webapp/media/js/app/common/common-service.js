angular.module('blog.services')
.factory("User", function ($resource) {
    return $resource("/rest/user/:id", {id: "@id"}, {
        update: {
            method: 'PUT'
        }
    });
})
.factory("Notification", function ($resource) {
    return $resource("/rest/notification/:id", {id: "@id"}, {
        markAsRead: {
            method: 'POST',
            url:    '/rest/notification/markAsRead/:id'
        }
    });
});