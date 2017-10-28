var app = {};

import ECharts from 'vue-echarts/components/ECharts.vue'

app.list = {
	template: "#list",
	route: {
		data: function(transition) {
			this.page.cols = [{
						title: 'x',
						key: 'x'
					}];
			this.getCols();
			var q = this.$route.query; //获取url里面的路由查询对象"page=1&pageSize=10"==>>{page:"1",pageSize:"10"}
			this.query.pageSize = q.pageSize ? q.pageSize * 1 : 10;
			this.query.page = q.page ? q.page * 1 : 1;
			this.loadData();
		}
	},
	data: function() {
		return {
		    selected: [],
			//columns: app.user_col,
			query: { //分页查询
				age: 1,
				name: "",
				addr: "",
				pageSize: 10, //每页显示多少条
				page: 1
			},
			page: { //分页
				totalElements: 0,
				content: [],
				cols: [],
				totalPage: 0
			}
		}
	},
	methods: {
		loadData: function() {
			StatApi.query(this.query, function(data) { //请见user-api.js
				this.page.content = data.content; //获取本页list内容
				this.page.totalElements = data.totalElements; //获取共计有多少条记录
				this.page.totalPage = data.totalPage; //获取有多少页
			}.bind(this)); //bind是改变当前函数内部this的指向，将传递给UserApi.query的第二个参数;回调函数的内部this改成本 vue实例的this
		},
		getCols: function() {
			StatApi.cols(this.query, function(data) { 
				this.page.cols = jQuery.parseJSON(data); 
			}.bind(this)); 
		},
		search: function(i) {
			this.query.page = i ? i : 1;
			var goRouter = PopDesign.assist.isGoRouter(this.query); //获取是否应该走路由的策略，false不走；true走起
			if(goRouter) {
				this.$router.go({
					path: PopDesign.assist.getRouterPath(), //获取当前路由地址
					query: PopDesign.assist.filterEmptyQuery(this.query) //整理当前的查询对象query，把为空的查询对象过滤掉
				});
			} else {
				this.loadData();
			}
		},
        getSelected: function(selected) {
          this.selected = selected;
        }
	}
};