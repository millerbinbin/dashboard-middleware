(function(root, $http) {
    var api = {};
    api.statUri = "api/stat";
    api.query = function(query, func1, func2) {
        var paramStr = "";
        for(var i in query) {
            query[i] ? paramStr += "&" + i + "=" + encodeURIComponent(query[i]) : null;
        }
        paramStr = "/?" + paramStr.substr(1);
        $http.get(api.statUri + paramStr).then(function(response) {
            func1(response.data);
        }, function(response) {
            if(func2) func2(response);
        });
    };
    api.cols = function(query, func1, func2) {
        $http.get(api.statUri + "/cols").then(function(response) {
            func1(response.body);
        }, function(response) {
            if(func2) func2(response);
        });
    };
    api.categories = function(query, func1, func2) {
        $http.get(api.statUri + "/categories").then(function(response) {
            console.log(response);
            func1(response.body);
        }, function(response) {
            if(func2) func2(response);
        });
    };
    root.StatApi = api;
})(window, Vue.http);