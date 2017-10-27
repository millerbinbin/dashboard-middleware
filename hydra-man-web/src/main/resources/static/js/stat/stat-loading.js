
    Vue.filter('timestamp2datestr', VueMan.filters.timestamp2datestr);
    Vue.filter('timestamp2datetimestr', VueMan.filters.timestamp2datetimestr);
    Vue.directive('scroller', VueMan.directive.scroller);

    <!-- 加载进度条 -->
    var _loading = [];
    Vue.http.interceptors.push(function(request, next) {
        if (!request.hideLoading) {
            var tmp = new Vue();
            tmp["$Message"].config({
                top: 350
            });
            _loading.push(tmp["$Message"].loading('正在加载中...', 0));
        }
        request.url = request.url + (request.url.indexOf("?") == -1 ? "?" : "&") + "v=" + new Date().getTime();
        next(function(response) {
            response.data = typeof response.data == "string" ? response.data != "" ? jQuery.parseJSON(response.data) : '' : response.data;
            for (var i in _loading) {
                _loading[i]();
            }
            if (response.status == 500) {
                new Vue()["$Notice"].error({
                    title: '出了点小问题',
                    desc: "系统繁忙，请稍后再试"
                });
            } else if (response.status == 0) {
                new Vue()["$Notice"].error({
                    title: '出了点小问题',
                    desc: "您的网络连接失败"
                });
            }
        });
    });