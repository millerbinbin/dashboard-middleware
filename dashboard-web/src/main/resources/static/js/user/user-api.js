(function(root, $http) {
    var api = {};
    api.userUri = "api/users";
    api.query = function(query, func1, func2) {
        var paramStr = "";
        for(var i in query) {
            query[i] ? paramStr += "&" + i + "=" + encodeURIComponent(query[i]) : null;
        }
        paramStr = "/?" + paramStr.substr(1);
        $http.get(api.userUri + paramStr).then(function(response) {
            func1(response.data);
        }, function(response) {
            if(func2) func2(response);
        });
    };
    api.queryUser = function(query, func1, func2) {

        $http.get(api.userUri +"/"+ query).then(function(response) {
            func1(response.data);
        }, function(response) {
            if(func2) func2(response);
        });
    };
    api.updateUser = function(query, func1, func2) {

      $http.put(api.userUri, query).then(function(response) {
            func1(response.data);
        }, function(response) {
            if(func2) func2(response);
        });
    };
    api.deleteUser = function(id, func1, func2) {
        paramStr = "/" +id;
       $http.delete(api.userUri+paramStr).then(function(response) {
            func1(response.data);
        }, function(response) {
            if(func2) func2(response);
        });
    };
    api.addUser = function(query, func1, func2) {
        $http.post(api.userUri, query).then(function(response) {
                func1(response.data);
            }, function(response) {
                if(func2) func2(response);
            });
    }
    root.UserApi = api;
})(window, Vue.http);