var app = {};

app.user_col = [{
    type: 'selection',
    width: 60,
    align: 'center'
}, {
	title: '姓名',
	key: 'name',
	sortable: true,
	render: function(row, column, index) {
	    console.log(row.name);
	    return '<p-icon type="person">'+ row.name +'</p-icon>';
	}
}, {
	title: '年龄',
	key: 'age',
    sortable: true
}, {
	title: '地址',
	key: 'addr',
	sortable: true
}, {
	title: '操作',
	key: 'action',
	render: function(row, column, index) {
		var path = "/edit?id=" + row.id;
		return '<p-button type="text" size="small" v-link="\'' + path + '\'">编辑</p-button>' +
			'<p-poptip confirm title="您确认删除这条内容吗？"  @on-ok="deleteOne(' + row.id + ')">' +
			'<p-button type="error" size="small">删除</p-button></p-poptip>';
	}
}];

app.list = {
	template: "#list",
	route: {
		data: function(transition) {
			var q = this.$route.query; //获取url里面的路由查询对象"page=1&pageSize=10"==>>{page:"1",pageSize:"10"}
			this.query.age = q.age ? q.age * 1 : "";
			this.query.name = q.name ? q.name : "";
			this.query.addr = q.addr ? q.addr : "";
			this.query.pageSize = q.pageSize ? q.pageSize * 1 : 10;
			this.query.page = q.page ? q.page * 1 : 1;
			this.loadData();
		}
	},
	data: function() {
		return {
		    selected: [],
			columns: app.user_col,
			query: { //分页查询
				age: 1,
				name: "",
				addr: "",
				pageSize: 10, //每页显示多少条
				page: 1
			},
			ruleValidate: { //表单验证器
				age: [{
					pattern: /^[1-9]\d*$/, //年龄只能是数字
					message: '请输入数字' //验证失败提示信息
				}],
			},
			page: { //分页
				totalElements: 0,
				content: [],
				totalPage: 0
			}
		}
	},
	methods: {
		loadData: function() {
			UserApi.query(this.query, function(data) { //请见user-api.js
				this.page.content = data.content; //获取本页list内容
				this.page.totalElements = data.totalElements; //获取共计有多少条记录
				this.page.totalPage = data.totalPage; //获取有多少页
			}.bind(this)); //bind是改变当前函数内部this的指向，将传递给UserApi.query的第二个参数;回调函数的内部this改成本 vue实例的this
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
		deleteOne: function(id) {
			UserApi.deleteUser(id, function(data) {
				this.$Message.success('删除成功！'); //成功提示信息
				this.loadData();
			}.bind(this), function(data) {
				this.$Message.error(data.data.msg); //失败提示信息
			}.bind(this));
		},
        getSelected: function(selected) {
          this.selected = selected;
        }
	}
};

app.edit = {
	template: "#edit",
	route: {
		data: function(transition) {
			var q = this.$route.query;
			this.user.id = q.id ? q.id : "";
			this.getUser();
		}
	},
	data: function() {
		return {
			user: {
				id: "",
				name: '',
				age: 1,
				addr: ""
			},
			ruleValidate: { //表单验证器
				name: [{
					required: true,
					message: '姓名不能为空',
				}],

				addr: [{
					required: true,
					message: '姓名不能为空',
				}]
			}
		}
	},
	methods: {
		getUser: function() {
			UserApi.queryUser(this.user.id, function(data) {
				this.user = data;
			}.bind(this));
		},
		save: function() {
			this.$refs.user.validate(function(valid) {
				if(valid) {
					UserApi.updateUser(this.user, function(data) {
						this.$Message.success('提交成功!');
						this.goback();
					}.bind(this), function(data) {
						for(var i in data.data.errors) {
							var row = data.data.errors[i];
							this.$refs.user.setError(row.field, row.msg);
						}
					}.bind(this));

				}
			}.bind(this));
		},
		goback: function() {
			history.back(-1);
		}
	}
}