webpackJsonp([1],{"0dZ8":function(t,e,a){"use strict";var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{attrs:{id:"app"}},[a("v-app",[a("router-view")],1)],1)},r=[],i={render:s,staticRenderFns:r};e.a=i},"0fUs":function(module,__webpack_exports__,__webpack_require__){"use strict";function drawChart(t,e){setTimeout(function(){var a,s=document.getElementById(t);a=2===s.attributes.length?echarts.init(s):echarts.getInstanceByDom(s),a.setOption(e)},50)}function addDate(t,e){var a=new Date(t);a=a.valueOf(),a+=24*e*60*60*1e3,a=new Date(a);var s=a.getFullYear(),r=a.getMonth()+1,i=a.getDate(),o=s+"/";return o+=r>=10?r+"/":"0"+r+"/",o+=i>=10?i:"0"+i}function combineUrl(t,e){var a="";for(var s in e)e[s]&&(a+="&"+s+"="+encodeURIComponent(e[s]));return a="/?"+a.substr(1),t+a}var __WEBPACK_IMPORTED_MODULE_0_axios__=__webpack_require__("mtWM"),__WEBPACK_IMPORTED_MODULE_0_axios___default=__webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_axios__),echarts=__webpack_require__("XLwt"),serverUrl="/api",valueUrl=serverUrl+"/value",chartUrl=serverUrl+"/chart",chartOptionUrl=serverUrl+"/chartOption",defUrl=serverUrl+"/def";__webpack_exports__.a={data:function(){return{a1:null,chartId:"",sysDateBefore:"",sysDate:"",period:"",expand:"remove",dateCycleList:[{dateCycle:"日",id:1},{dateCycle:"周",id:2},{dateCycle:"月",id:3}],data:{},def:{},tip:"",headers:[{text:"Dessert (100g serving)",align:"left",sortable:!1,value:"name"},{text:"Calories",value:"calories",sortable:!1},{text:"Fat (g)",value:"fat",sortable:!1},{text:"Carbs (g)",value:"carbs",sortable:!1},{text:"Protein (g)",value:"protein",sortable:!1},{text:"Sodium (mg)",value:"sodium",sortable:!1},{text:"Calcium (%)",value:"calcium",sortable:!1},{text:"Iron (%)",value:"iron",sortable:!1}],items:[{value:!0,name:"全部仓库",calories:159,fat:6,carbs:24,protein:4,sodium:87,calcium:"14%",iron:"1%"},{value:!1,name:"上海1仓",calories:237,fat:9,carbs:37,protein:4.3,sodium:129,calcium:"8%",iron:"1%"},{value:!1,name:"上海2仓",calories:262,fat:16,carbs:23,protein:6,sodium:337,calcium:"6%",iron:"7%"},{value:!1,name:"上海3仓",calories:305,fat:3.7,carbs:67,protein:4.3,sodium:413,calcium:"3%",iron:"8%"}],metricId:null}},watch:{a1:function(t){this.changeChart(t)}},methods:{goBack:function(){this.$router.go(-1)},changeChart:function(t){"日"===t.dateCycle?(this.renderNumber(this.$route.params.id,"day",this.$store.state.warehouse,this.$store.state.sysDate),this.renderChart(this.$route.params.id,"day",this.$store.state.warehouse,this.$store.state.sysDate),this.period=this.$store.state.sysDate,this.tip=this.def.day):"周"===t.dateCycle?(this.renderNumber(this.$route.params.id,"week",this.$store.state.warehouse,this.$store.state.sysDate),this.renderChart(this.$route.params.id,"week",this.$store.state.warehouse,this.$store.state.sysDate),this.period=this.$store.state.sysWeek,this.tip=this.def.week):"月"===t.dateCycle&&(this.renderNumber(this.$route.params.id,"month",this.$store.state.warehouse,this.$store.state.sysDate),this.renderChart(this.$route.params.id,"month",this.$store.state.warehouse,this.$store.state.sysDate),this.period=this.$store.state.sysMonth,this.tip=this.def.month)},getDef:function(t){__WEBPACK_IMPORTED_MODULE_0_axios___default.a.get(defUrl+"/"+t).then(function(t){this.def=t.data,this.tip=this.def.day}.bind(this)).catch(function(t){console.log(t)})},renderNumber:function(t,e,a,s){if(void 0!==e){var r={metric:t,cycle:e,warehouse:a.id,sysdate:s},i=combineUrl(valueUrl,r);__WEBPACK_IMPORTED_MODULE_0_axios___default.a.get(i).then(function(t){this.data=t.data}.bind(this)).catch(function(t){console.log(t)})}},renderChart:function renderChart(metricId,dateCycle,warehouse,sysdate){var query={metric:metricId,cycle:dateCycle,warehouse:warehouse.id,sysdate:sysdate},url=combineUrl(chartUrl,query);__WEBPACK_IMPORTED_MODULE_0_axios___default.a.get(url).then(function(response){var data=response.data,query2={metric:metricId,cycle:dateCycle},url2=combineUrl(chartOptionUrl,query2);__WEBPACK_IMPORTED_MODULE_0_axios___default.a.get(url2).then(function(response2){var option=function(res,optionstr){return eval("("+optionstr+")")}(data,response2.data);drawChart(metricId,option)}).catch(function(t){console.log(t)})}).catch(function(t){console.log(t)})}},mounted:function(){this.sysDate=this.$store.state.sysDate,this.sysDateBefore=addDate(this.sysDate,-7);var t=this.$route.params.id;this.getDef(t),this.chartId=t,this.a1=this.dateCycleList[0]}}},"2hEF":function(t,e,a){"use strict";var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("v-container",{attrs:{"grid-list-xs":"","text-xs-left":"","pt-0":""}},[a("v-toolbar",{attrs:{fixed:""}},[a("v-layout",{attrs:{row:"",wrap:"","text-xs-center":""}},[a("v-flex",{staticStyle:{"font-size":"10px"},attrs:{xs5:"","offset-xs4":"",filter:"","text-xs-right":""}},[a("v-select",{staticStyle:{width:"90%"},attrs:{items:t.warehouseList,"item-text":"warehouseName","single-line":"",bottom:""},model:{value:t.warehouse,callback:function(e){t.warehouse=e},expression:"warehouse"}})],1),t._v(" "),a("v-flex",{attrs:{xs1:"","offset-xs2":""}},[a("v-btn",{attrs:{icon:""},on:{click:t.goSettings}},[a("i",{staticClass:"material-icons md-24 grey100"},[t._v("settings")])])],1)],1)],1),t._v(" "),a("v-layout",{staticStyle:{"padding-top":"50px","margin-left":"3px","margin-right":"3px"},attrs:{row:"",wrap:""}},[a("v-flex",{attrs:{xs6:"","user-tag":""}},[t._v(t._s(this.sysUser))]),t._v(" "),a("v-flex",{attrs:{xs6:"","date-tag":""}},[t._v("数据日期："+t._s(this.sysDate))])],1),t._v(" "),t.showComp?a("number-view"):t._e(),t._v(" "),t.showComp?a("chart-view"):t._e(),t._v(" "),this.$store.state.homepageFree.length>0?a("v-card",{staticClass:"circle-bar"},[a("i",{staticClass:"material-icons md-32 grey100",on:{click:t.goSettings}},[t._v("add_circle")])]):t._e(),t._v(" "),a("v-layout",{attrs:{row:"",wrap:"","text-xs-center":"","pt-2":""}},t._l(this.$store.state.homepageFree,function(e,s){return a("v-flex",{key:s,attrs:{"pa-2":"",xs4:""},on:{click:function(a){t.goDetails(e.id)}}},[a("v-card",[t._v(" "+t._s(e.metricName)+" ")])],1)}))],1)},r=[],i={render:s,staticRenderFns:r};e.a=i},"3VFh":function(t,e,a){"use strict";var s=(a("7+uW"),a("mtWM")),r=a.n(s);e.a={data:function(){return{desc:[]}},methods:{goBack:function(){this.$router.go(-1)},getDesc:function(){r.a.get("/api/def").then(function(t){this.desc=t.data}.bind(this)).catch(function(t){console.log(t)})}},mounted:function(){this.getDesc()}}},"6/jm":function(t,e,a){"use strict";var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("v-container",{attrs:{"grid-list-xs":"","text-xs-center":""}},[a("v-layout",{attrs:{row:"",wrap:""}},[a("v-flex",{attrs:{xs6:"","offset-xs3":""}},[a("v-avatar",{staticClass:"grey lighten-4 logo"},[a("img",{attrs:{src:"https://vuetifyjs.com/static/apple-touch-icon-180x180.png",alt:"avatar"}})])],1),t._v(" "),a("v-flex",{attrs:{xs6:"","offset-xs3":""}},[a("v-form",{ref:"form",model:{value:t.valid,callback:function(e){t.valid=e},expression:"valid"}},[a("v-text-field",{attrs:{label:"账号",rules:t.nameRules,required:""},model:{value:t.username,callback:function(e){t.username=e},expression:"username"}}),t._v(" "),a("v-text-field",{attrs:{label:"密码",rules:t.pwdRules,type:"password",required:""},model:{value:t.password,callback:function(e){t.password=e},expression:"password"}}),t._v(" "),a("v-alert",{directives:[{name:"show",rawName:"v-show",value:!t.verified,expression:"!verified"}],staticStyle:{"font-size":".625em"},attrs:{color:"error",icon:"warning",value:"true"}},[t._v("\n          "+t._s(t.errorMsg)+"\n        ")]),t._v(" "),a("v-layout",{attrs:{row:"",wrap:""}},[a("v-flex",{attrs:{xs6:""}},[a("v-checkbox",{attrs:{label:"记住密码"},model:{value:t.remPwd,callback:function(e){t.remPwd=e},expression:"remPwd"}})],1),t._v(" "),a("v-flex",{attrs:{xs6:""}},[a("v-checkbox",{attrs:{label:"自动登录"},model:{value:t.autoLogin,callback:function(e){t.autoLogin=e},expression:"autoLogin"}})],1)],1),t._v(" "),a("v-btn",{attrs:{color:"primary"},on:{click:t.submit}},[t._v("登录")])],1)],1)],1)],1)},r=[],i={render:s,staticRenderFns:r};e.a=i},"7zck":function(t,e){},FD8g:function(t,e){},GUTb:function(t,e,a){"use strict";e.a={components:{"number-view":{data:function(){return{numberComps:[]}},render:function(t){var e=[];return this.numberComps.map(function(a){e.push(t(a,{}))}),e.length%2==0?t("div",{class:{layout:!0,row:!0,wrap:!0}},e):(e.push(t("dummy-bar",{})),t("div",{class:{layout:!0,row:!0,wrap:!0}},e))},mounted:function(){var t=this;this.$store.state.homepageValues.forEach(function(e){t.numberComps.push(e.id+"-number")})}},"chart-view":{data:function(){return{chartComps:[]}},render:function(t){var e=[];return this.chartComps.map(function(a){e.push(t(a,{}))}),t("div",{class:{layout:!0,row:!0,wrap:!0,chart:!0}},e)},mounted:function(){var t=this;this.$store.state.homepageCharts.forEach(function(e){t.chartComps.push(e.id+"-chart")})}}},methods:{goSettings:function(){this.$router.push({path:"settings"})},goDetails:function(t){this.$router.push({path:"detail/"+t})}},watch:{warehouse:function(t){this.$store.commit("setWarehouse",t),this.showComp=!1,this.$nextTick(function(){this.showComp=!0})}},data:function(){return{warehouse:null,sysUser:"jd_user",sysDate:"2017/11/01",warehouseList:[],showComp:!0}},mounted:function(){this.sysDate=this.$store.state.sysDate,this.sysUser=this.$store.state.sysUser,this.warehouseList=this.$store.state.warehouseList,this.warehouse=this.$store.state.warehouse}}},Gf7d:function(t,e,a){"use strict";var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return t.data.value?a("v-container",{attrs:{"grid-list-xs":"","text-xs-left":""}},[a("v-toolbar",{attrs:{fixed:""}},[a("v-layout",{attrs:{row:"",wrap:"","text-xs-center":""}},[a("v-flex",{attrs:{xs1:"","topbar-left":""}},[a("v-btn",{attrs:{icon:""},on:{click:t.goBack}},[t._v("返回")])],1),t._v(" "),a("v-flex",{attrs:{xs6:"","offset-xs2":"","topbar-center":""}},[t._v("\n        "+t._s(t.data.value.f1)+"\n      ")])],1)],1),t._v(" "),a("v-layout",{staticStyle:{"padding-top":"40px","margin-left":"3px !important","margin-right":"3px !important"},attrs:{row:"",wrap:""}},[a("v-flex",{attrs:{xs12:""}},[a("v-layout",{attrs:{row:"",wrap:"","text-xs-left":""}},[a("v-flex",{attrs:{xs2:"",filter:""}},[a("v-select",{attrs:{items:t.dateCycleList,"item-text":"dateCycle","single-line":"",bottom:""},model:{value:t.a1,callback:function(e){t.a1=e},expression:"a1"}})],1),t._v(" "),a("v-flex",{attrs:{xs8:"","detail-info":""}},[a("span",[t._v(t._s(t.period))])]),t._v(" "),a("v-flex",{attrs:{xs2:"","text-xs-right":"","detail-info":""}},[a("span",{staticStyle:{"font-weight":"bold"}},[t._v(t._s(this.$store.state.warehouse.warehouseName))])])],1)],1)],1),t._v(" "),a("v-card",{staticClass:"chart"},[a("v-card",{staticClass:"chart-detail-header"},[a("v-layout",{attrs:{row:"",wrap:""}},[a("v-flex",{attrs:{xs4:""}},[a("v-layout",{attrs:{row:"",wrap:""}},[a("v-flex",{attrs:{xs8:"","chart-detail-func-name":""}},[t._v(t._s(t.data.value.f1))]),t._v(" "),a("v-flex",{attrs:{xs2:"","text-xs-right":""}},[a("v-tooltip",{attrs:{right:""}},[a("i",{staticClass:"material-icons md-16 yellow100",attrs:{slot:"activator"},slot:"activator"},[t._v("info")]),t._v(" "),a("span",[t._v(t._s(t.tip))])])],1),t._v(" "),a("v-flex",{attrs:{xs12:"","chart-detail-func-value":""}},[t._v(t._s(t.data.value.v1))]),t._v(" "),a("v-flex",{attrs:{xs9:""}},[a("div",{staticClass:"under-bar"})])],1)],1),t._v(" "),a("v-flex",{attrs:{xs5:""}},[a("v-layout",{staticStyle:{"padding-bottom":"6px","padding-top":"3px"},attrs:{row:"",wrap:""}},[a("v-flex",{attrs:{xs5:"","chart-detail-idx-name":""}},[a("span",[t._v(t._s(t.data.value.f4))])]),t._v(" "),a("v-flex",{attrs:{xs4:"","chart-detail-idx-value":""}},[t._v("\n              "+t._s(t.data.value.v4)+"   \n            ")]),t._v(" "),a("v-flex",{attrs:{xs3:"","text-xs-left":""}},[t.data.value.v2>0?a("div",{staticClass:"trending-up"}):0==t.data.value.v2?a("div",{staticClass:"trending-flat"}):t.data.value.v2<0?a("div",{staticClass:"trending-down"}):t._e()])],1),t._v(" "),a("v-layout",{attrs:{row:"",wrap:""}},[a("v-flex",{attrs:{xs5:"","chart-detail-idx-name":""}},[t._v("\n              "+t._s(t.data.value.f5)+"  \n            ")]),t._v(" "),a("v-flex",{attrs:{xs4:"","chart-detail-idx-value":""}},[t._v("\n              "+t._s(t.data.value.v5)+"\n            ")]),t._v(" "),a("v-flex",{attrs:{xs3:"","text-xs-left":""}},[t.data.value.v3>0?a("div",{staticClass:"trending-up"}):0==t.data.value.v3?a("div",{staticClass:"trending-flat"}):t.data.value.v3<0?a("div",{staticClass:"trending-down"}):t._e()])],1)],1),t._v(" "),a("v-flex",{attrs:{xs3:""}},[a("v-layout",{staticStyle:{"padding-bottom":"6px","padding-top":"3px"},attrs:{row:"",wrap:""}},[a("v-flex",{attrs:{xs5:"","chart-detail-idx-name":""}},[t._v("\n              "+t._s(t.data.value.f2)+"    \n            ")]),t._v(" "),a("v-flex",{attrs:{xs5:"","chart-detail-idx-value":""}},[t._v("\n              "+t._s(t.data.value.v2)+"%\n            ")]),t._v(" "),a("v-flex",{attrs:{xs2:"","text-xs-left":""}},[t.data.value.v2>0?a("div",{staticClass:"trending-up"}):0==t.data.value.v2?a("div",{staticClass:"trending-flat"}):t.data.value.v2<0?a("div",{staticClass:"trending-down"}):t._e()])],1),t._v(" "),a("v-layout",{attrs:{row:"",wrap:""}},[a("v-flex",{attrs:{xs5:"","chart-detail-idx-name":""}},[t._v("\n              "+t._s(t.data.value.f3)+"    \n            ")]),t._v(" "),a("v-flex",{attrs:{xs5:"","chart-detail-idx-value":""}},[t._v("\n              "+t._s(t.data.value.v3)+"%\n            ")]),t._v(" "),a("v-flex",{attrs:{xs2:"","text-xs-left":""}},[t.data.value.v3>0?a("div",{staticClass:"trending-up"}):0==t.data.value.v3?a("div",{staticClass:"trending-flat"}):t.data.value.v3<0?a("div",{staticClass:"trending-down"}):t._e()])],1)],1)],1)],1),t._v(" "),a("v-card",{staticClass:"chart-detail-body"},[a("div",{staticStyle:{width:"100%",height:"180px"},attrs:{id:t.chartId}})]),t._v(" "),a("v-card",{staticClass:"chart-detail-foot"},[a("v-layout",{attrs:{row:"",wrap:""}},[a("v-flex",{attrs:{xs8:"","offset-xs2":""}},[a("v-layout",{attrs:{row:"",wrap:""}},[a("v-flex",{attrs:{xs1:"","offset-xs2":"","cyan-bar":""}}),t._v(" "),a("v-flex",{attrs:{xs3:"","chart-legend":""}},[t._v(t._s(t.sysDate))]),t._v(" "),a("v-flex",{attrs:{xs1:"","offset-xs1":"","grey-bar":""}}),t._v(" "),a("v-flex",{attrs:{xs3:"","chart-legend":""}},[t._v(t._s(t.sysDateBefore))])],1)],1)],1)],1)],1),t._v(" "),a("v-card",{staticClass:"chart-detail-table"},[a("v-data-table",{attrs:{headers:t.headers,items:t.items,"hide-actions":"","item-key":"name"},scopedSlots:t._u([{key:"items",fn:function(e){return[1==e.item.value||"remove"==t.expand?a("tr",[a("td",[1==e.item.value?a("i",{staticClass:"material-icons md-8 yellow100",on:{click:function(e){"remove"==t.expand?t.expand="add":t.expand="remove"}}},[t._v("\n              "+t._s(t.expand)+"\n            ")]):t._e(),t._v("\n            "+t._s(e.item.name)+"\n          ")]),t._v(" "),a("td",{staticClass:"text-xs-right"},[t._v(t._s(e.item.calories))]),t._v(" "),a("td",{staticClass:"text-xs-right"},[t._v(t._s(e.item.fat))]),t._v(" "),a("td",{staticClass:"text-xs-right"},[t._v(t._s(e.item.carbs))]),t._v(" "),a("td",{staticClass:"text-xs-right"},[t._v(t._s(e.item.protein))]),t._v(" "),a("td",{staticClass:"text-xs-right"},[t._v(t._s(e.item.sodium))]),t._v(" "),a("td",{staticClass:"text-xs-right"},[t._v(t._s(e.item.calcium))]),t._v(" "),a("td",{staticClass:"text-xs-right"},[t._v(t._s(e.item.iron))])]):t._e()]}}])})],1)],1):t._e()},r=[],i={render:s,staticRenderFns:r};e.a=i},M93x:function(t,e,a){"use strict";function s(t){a("FD8g")}var r=a("xJD8"),i=a("0dZ8"),o=a("VU/8"),n=s,l=o(r.a,i.a,!1,n,null,null);e.a=l.exports},NHnr:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var s=a("7+uW"),r=a("NYxO"),i=a("M93x"),o=a("YaEn"),n=a("3EgV"),l=a.n(n),c=a("7zck");a.n(c);s.default.use(l.a),s.default.use(r.default),s.default.config.productionTip=!1;var u=new r.default.Store({state:{sysUser:"aa",sysDate:"2011/11/11",sysWeek:"2011 W33",sysMonth:"2011 M10",warehouse:"",warehouseList:[],dateCycleList:[],allMetrics:{},homepageValues:[],homepageCharts:[],homepageFree:[]},mutations:{setUser:function(t,e){t.sysUser=e},setDate:function(t,e){t.sysDate=e},setWeek:function(t,e){t.sysWeek=e},setMonth:function(t,e){t.sysMonth=e},setWarehouse:function(t,e){t.warehouse=e},setWarehouseList:function(t,e){t.warehouseList=e},setDateCycle:function(t,e){t.dateCycleList=e},addMetrics:function(t,e){t.allMetrics[e.metricName]=e},setHomepageValue:function(t,e){t.homepageValues=e},setHomepageChart:function(t,e){t.homepageCharts=e},setHomepageFree:function(t,e){t.homepageFree=e}},getters:{},actions:{}});new s.default({el:"#app",router:o.a,template:"<App/>",components:{App:i.a},store:u,mounted:function(){this.$router.push({name:"login"})}})},NkRg:function(t,e,a){"use strict";var s=a("hdrz"),r=a("V/mn"),i=a("VU/8"),o=i(s.a,r.a,!1,null,null,null);e.a=o.exports},"V/mn":function(t,e,a){"use strict";var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("v-container",{attrs:{"grid-list-xs":"","text-xs-left":"","pt-0":""}},[a("v-toolbar",{attrs:{fixed:""}},[a("v-layout",{attrs:{row:"",wrap:"","text-xs-center":""}},[a("v-flex",{attrs:{xs1:"","topbar-left":""}},[a("v-btn",{attrs:{icon:""},on:{click:t.goBack}},[t._v("返回")])],1),t._v(" "),a("v-flex",{attrs:{xs8:"","offset-xs1":"","topbar-center":""}},[t._v("\n        首页模块\n      ")]),t._v(" "),a("v-flex",{attrs:{xs1:"","offset-xs1":"","topbar-right":""}},[a("v-btn",{attrs:{icon:""},on:{click:t.showHelp}},[a("i",{staticClass:"material-icons md-24 grey100"},[t._v("help")])])],1)],1)],1),t._v(" "),a("main",{staticStyle:{"padding-top":"50px"}},[a("v-layout",{attrs:{row:"",wrap:"","text-xs-center":""}},[a("v-flex",{attrs:{xs8:"","offset-xs2":"",def:""}},[t._v("\n        你可以设计自己专属的DashBoard在下方添加并拖动整理您关心的数据\n      ")])],1),t._v(" "),a("v-tabs",{attrs:{dark:"",fixed:"",centered:""}},[a("v-tabs-bar",[a("v-tabs-slider"),t._v(" "),a("v-tabs-item",{attrs:{href:"#setting-values"}},[t._v("\n          数据框\n        ")]),t._v(" "),a("v-tabs-item",{attrs:{href:"#setting-charts"}},[t._v("\n          趋势图\n        ")]),t._v(" "),a("v-tabs-item",{attrs:{href:"#setting-layout"}},[t._v("\n          布局管理\n        ")])],1),t._v(" "),a("v-tabs-items",[a("v-tabs-content",{key:"setting-values",attrs:{id:"setting-values"}},[a("v-card",{attrs:{flat:""}},[a("v-list",{attrs:{"one-line":""}},[a("v-divider"),t._v(" "),t._l(t.metrics,function(e,s){return[a("v-list-tile",{key:e.id,attrs:{avatar:""}},[a("v-list-tile-action",[a("v-checkbox",{attrs:{disabled:-1==t.comp_value_option[e.metricName],"true-value":1,"false-value":0},on:{change:function(a){t.toggleValueOption(e)}},model:{value:t.comp_value_option[e.metricName],callback:function(a){t.$set(t.comp_value_option,e.metricName,a)},expression:"comp_value_option[metric.metricName]"}})],1),t._v(" "),a("v-list-tile-content",{on:{click:function(a){t.toggleValueOption(e,!0)}}},[a("v-list-tile-title",[t._v(t._s(e.metricName))])],1)],1),t._v(" "),s+1<t.metrics.length?a("v-divider",{key:e.id}):t._e()]})],2)],1)],1),t._v(" "),a("v-tabs-content",{key:"setting-charts",attrs:{id:"setting-charts"}},[a("v-card",{attrs:{flat:""}},[a("v-list",{attrs:{"one-line":""}},[a("v-divider"),t._v(" "),t._l(t.metrics,function(e,s){return[a("v-list-tile",{key:e.id,attrs:{avatar:""}},[a("v-list-tile-action",[a("v-checkbox",{attrs:{disabled:-1==t.comp_chart_option[e.metricName],"true-value":1,"false-value":0},on:{change:function(a){t.toggleChartOption(e)}},model:{value:t.comp_chart_option[e.metricName],callback:function(a){t.$set(t.comp_chart_option,e.metricName,a)},expression:"comp_chart_option[metric.metricName]"}})],1),t._v(" "),a("v-list-tile-content",{on:{click:function(a){t.toggleChartOption(e,!0)}}},[a("v-list-tile-title",[t._v(t._s(e.metricName))])],1)],1),t._v(" "),s+1<t.metrics.length?a("v-divider",{key:e.id}):t._e()]})],2)],1)],1),t._v(" "),a("v-tabs-content",{key:"setting-layout",attrs:{id:"setting-layout"}},[a("v-card",{attrs:{flat:""}},[a("v-list",{attrs:{"one-line":"",subheader:""}},[a("v-subheader",[t._v("数据框")]),t._v(" "),a("v-divider"),t._v(" "),a("draggable",{attrs:{options:{group:"value",animation:150}},on:{end:t.updateValueOption},model:{value:t.valueOptions,callback:function(e){t.valueOptions=e},expression:"valueOptions"}},t._l(t.valueOptions,function(e,s){return a("div",{key:e.id},[a("v-list-tile",{attrs:{avatar:""}},[a("v-list-tile-content",[a("v-list-tile-title",[t._v(t._s(e.metricName))])],1)],1),t._v(" "),a("v-divider")],1)}))],1)],1),t._v(" "),a("v-card",{attrs:{flat:""}},[a("v-list",{attrs:{"one-line":"",subheader:""}},[a("v-subheader",[t._v("趋势图")]),t._v(" "),a("v-divider"),t._v(" "),a("draggable",{attrs:{options:{group:"chart",animation:150}},on:{end:t.updateChartOption},model:{value:t.chartOptions,callback:function(e){t.chartOptions=e},expression:"chartOptions"}},t._l(t.chartOptions,function(e,s){return a("div",{key:e.id},[a("v-list-tile",{attrs:{avatar:""}},[a("v-list-tile-content",[a("v-list-tile-title",[t._v(t._s(e.metricName))])],1)],1),t._v(" "),a("v-divider")],1)}))],1)],1)],1)],1)],1)],1),t._v(" "),a("v-layout",{attrs:{row:"",wrap:"","text-xs-center":""}},[a("v-flex",{attrs:{xs4:"","offset-xs4":""},on:{click:t.goDef}},[a("v-layout",{attrs:{row:"",wrap:""}},[a("v-flex",{attrs:{xs2:"","offset-xs2":""}},[a("i",{staticClass:"material-icons md-16 yellow100"},[t._v("info")])]),t._v(" "),a("v-flex",{attrs:{xs7:"","text-xs-left":"",def:""}},[t._v("数据定义")])],1)],1),t._v(" "),a("v-flex",{attrs:{xs2:"","offset-xs10":"",logout:""},on:{click:t.goLogin}},[t._v("退出登录")])],1)],1)},r=[],i={render:s,staticRenderFns:r};e.a=i},YaEn:function(t,e,a){"use strict";var s=a("7+uW"),r=a("/ocq"),i=a("YlY5"),o=a("wrM5"),n=a("snr5"),l=a("NkRg"),c=a("vGxe");s.default.use(r.default),e.a=new r.default({routes:[{path:"/login",name:"login",component:i.a},{path:"/home",name:"homepage",component:o.a},{path:"/detail/:id",name:"detailpage",component:n.a},{path:"/settings",name:"settings",component:l.a},{path:"/def",name:"def",component:c.a}]})},YlY5:function(t,e,a){"use strict";var s=a("wBCo"),r=a("6/jm"),i=a("VU/8"),o=i(s.a,r.a,!1,null,null,null);e.a=o.exports},hdrz:function(t,e,a){"use strict";var s=a("mvHQ"),r=a.n(s),i=a("DAYN"),o=a.n(i);e.a={components:{draggable:o.a},data:function(){return{metrics:[],comp_value_option:{},comp_chart_option:{},valueOptions:[],chartOptions:[]}},methods:{goDef:function(){this.$router.push({path:"def"})},goBack:function(){this.$router.go(-1)},goLogin:function(){this.$router.push({path:"login"})},showHelp:function(){alert("show some help?")},updateValueOption:function(){this.$store.commit("setHomepageValue",this.valueOptions);var t=0,e=this;this.valueOptions.forEach(function(a){var s=a;s.seq=t,e.$store.commit("addMetrics",s),t+=1})},updateChartOption:function(){this.$store.commit("setHomepageChart",this.chartOptions);var t=0,e=this;this.chartOptions.forEach(function(a){var s=a;s.seq=t,e.$store.commit("addMetrics",s),t+=1})},toggleValueOption:function(t,e){var a=t.metricName;e&&(this.comp_value_option[a]=1-this.comp_value_option[a]),this.comp_chart_option[a]=0-this.comp_value_option[a],this.comp_value_option=JSON.parse(r()(this.comp_value_option));var s=t;s.metricType=1+this.comp_chart_option[a],this.$store.commit("addMetrics",s);var i=[],o=[];for(var n in this.comp_value_option)1===this.comp_value_option[n]?i.push(this.$store.state.allMetrics[n]):0===this.comp_value_option[n]&&o.push(this.$store.state.allMetrics[n]);this.valueOptions=i,this.$store.commit("setHomepageValue",this.valueOptions),this.$store.commit("setHomepageFree",o)},toggleChartOption:function(t,e){var a=t.metricName;e&&(this.comp_chart_option[a]=1-this.comp_chart_option[a]),this.comp_value_option[a]=0-this.comp_chart_option[a],this.comp_chart_option=JSON.parse(r()(this.comp_chart_option));var s=t;s.metricType=1+this.comp_chart_option[a],this.$store.commit("addMetrics",s);var i=[],o=[];for(var n in this.comp_chart_option)1===this.comp_chart_option[n]?i.push(this.$store.state.allMetrics[n]):0===this.comp_value_option[n]&&o.push(this.$store.state.allMetrics[n]);this.chartOptions=i,this.$store.commit("setHomepageChart",this.chartOptions),this.$store.commit("setHomepageFree",o)}},created:function(){for(var t in this.$store.state.allMetrics)0===this.$store.state.allMetrics[t].metricType?this.comp_value_option[t]=1:2===this.$store.state.allMetrics[t].metricType?this.comp_value_option[t]=-1:1===this.$store.state.allMetrics[t].metricType&&(this.comp_value_option[t]=0),this.comp_chart_option[t]=0-this.comp_value_option[t],this.metrics.push(this.$store.state.allMetrics[t]);this.comp_value_option=JSON.parse(r()(this.comp_value_option)),this.comp_chart_option=JSON.parse(r()(this.comp_chart_option)),this.valueOptions=this.$store.state.homepageValues,this.chartOptions=this.$store.state.homepageCharts},mounted:function(){}}},nqss:function(t,e,a){"use strict";var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("v-container",{attrs:{"grid-list-xs":"","text-xs-center":""}},[a("v-toolbar",{attrs:{fixed:""}},[a("v-layout",{attrs:{row:"",wrap:"","text-xs-center":""}},[a("v-flex",{attrs:{xs1:"","topbar-left":""}},[a("v-btn",{attrs:{icon:""},on:{click:t.goBack}},[t._v("返回")])],1),t._v(" "),a("v-flex",{attrs:{xs6:"","offset-xs2":"","topbar-center":""}},[t._v("\n        数据定义\n      ")])],1)],1),t._v(" "),a("div",{staticStyle:{"padding-top":"50px"}},t._l(t.desc,function(e,s){return a("v-card",{key:e.name,attrs:{flat:""}},[a("v-list",{attrs:{"one-line":"",subheader:""}},[a("v-subheader",[t._v(t._s(e.name))]),t._v(" "),a("v-list-tile",{attrs:{avatar:""}},[a("v-list-tile-content",[a("v-list-tile-title",[t._v("日维度："+t._s(e.day))])],1)],1),t._v(" "),a("v-divider"),t._v(" "),a("v-list-tile",{attrs:{avatar:""}},[a("v-list-tile-content",[a("v-list-tile-title",[t._v("周维度："+t._s(e.week))])],1)],1),t._v(" "),a("v-divider"),t._v(" "),a("v-list-tile",{attrs:{avatar:""}},[a("v-list-tile-content",[a("v-list-tile-title",[t._v("月维度："+t._s(e.month))])],1)],1)],1)],1)}))],1)},r=[],i={render:s,staticRenderFns:r};e.a=i},snr5:function(t,e,a){"use strict";var s=a("0fUs"),r=a("Gf7d"),i=a("VU/8"),o=i(s.a,r.a,!1,null,null,null);e.a=o.exports},vGxe:function(t,e,a){"use strict";var s=a("3VFh"),r=a("nqss"),i=a("VU/8"),o=i(s.a,r.a,!1,null,null,null);e.a=o.exports},wBCo:function(module,__webpack_exports__,__webpack_require__){"use strict";function combineUrl(t,e){var a="";for(var s in e)e[s]&&(a+="&"+s+"="+encodeURIComponent(e[s]));return a="/?"+a.substr(1),t+a}function drawChart(t,e){setTimeout(function(){if(document.getElementById(t)){echarts.init(document.getElementById(t)).setOption(e)}},50)}function addDate(t,e){var a=new Date(t);t||(a=new Date);var s=e||0;a.setDate(a.getDate()+s);var r=a.getFullYear(),i=a.getMonth()+1,o=a.getDate();return i=i<10?"0"+i:i,o=o<10?"0"+o:o,r+"/"+i+"/"+o}function getWeekOfYear(t){var e=new Date(t),a=e.getFullYear(),s=e,r=new Date(a,0,1),i=Math.round((s-r)/864e5);return a+"W"+Math.ceil((i+(r.getDay()+1-1))/7)}function getWeekDuration(t,e,a){var s=new Date(t);t||(s=new Date);var r=s.getTime(),i=s.getDay(),o=6048e5*(a||0),n=s;"s"===e&&(n=r-864e5*(i-1)+o),"e"===e&&(n=r+864e5*(7-i)+o),n=new Date(n);var l=n.getFullYear(),c=n.getMonth()+1,u=n.getDate();return c=c<10?"0"+c:c,u=u<10?"0"+u:u,i=l+"/"+c+"/"+u}function getMonthOfYear(t){var e=new Date(t),a=e.getFullYear(),s=e.getMonth()+1;return s=s<10?"0"+s:s,a+"M"+s}function getMonthDuration(t,e,a){var s=new Date(t);t||(s=new Date);var r=s.getFullYear(),i=s.getMonth()+1;Math.abs(a)>12&&(a%=12),a=a||0,0!==a&&(i+a>12?(r++,i=(i+a)%12):i+a<1?(r--,i=12+i+a):i+=a),i=i<10?"0"+i:i;var o=r+"/"+i+"/01",n="";n="01"===i||"03"===i||"05"===i||"07"===i||"08"===i||"10"===i||"12"===i?r+"-"+i+"-31":"02"===i?r%4==0&&r%100!=0||r%100==0&&r%400==0?r+"/"+i+"/29":r+"/"+i+"/28":r+"/"+i+"/30";return"s"===e?o:n}function initVue(components){for(var i=0;i<components.length;i++)!function(comp){__WEBPACK_IMPORTED_MODULE_0_vue__.default.component(comp.id+"-number",{template:comp.numberTemplate,data:function(){return{data:{},id:comp.id}},methods:{goDetails:function(t){this.$router.push({path:"detail/"+t})},renderNumber:function(t,e,a,s){if(void 0!==e){var r={metric:t,cycle:e,warehouse:a.id,sysdate:s},i=combineUrl(valueUrl,r);__WEBPACK_IMPORTED_MODULE_1_axios___default.a.get(i).then(function(t){this.data=t.data}.bind(this)).catch(function(t){console.log(t)})}}},mounted:function(){this.renderNumber(comp.id,"day",this.$store.state.warehouse,this.$store.state.sysDate)}}),__WEBPACK_IMPORTED_MODULE_0_vue__.default.use(comp.name+"-number"),__WEBPACK_IMPORTED_MODULE_0_vue__.default.component(comp.id+"-chart",{template:comp.chartTemplate,data:function(){return{data:{},id:comp.id,chartId:comp.id+"-day",sysDate:"",sysDateBefore:""}},methods:{goDetails:function(t){this.$router.push({path:"detail/"+t})},renderNumber:function(t,e,a,s){if(void 0!==e){var r={metric:t,cycle:e,warehouse:a.id,sysdate:s},i=combineUrl(valueUrl,r);__WEBPACK_IMPORTED_MODULE_1_axios___default.a.get(i).then(function(t){this.data=t.data}.bind(this)).catch(function(t){console.log(t)})}},renderChart:function renderChart(metricId,dateCycle,warehouse,sysdate){var query={metric:metricId,cycle:dateCycle,warehouse:warehouse.id,sysdate:sysdate},url=combineUrl(chartUrl,query);__WEBPACK_IMPORTED_MODULE_1_axios___default.a.get(url).then(function(response){var data=response.data,query2={metric:metricId,cycle:dateCycle},url2=combineUrl(chartOptionUrl,query2);__WEBPACK_IMPORTED_MODULE_1_axios___default.a.get(url2).then(function(response2){var option=function(res,optionstr){return eval("("+optionstr+")")}(data,response2.data);drawChart(metricId+"-"+dateCycle,option)}).catch(function(t){console.log(t)})}).catch(function(t){console.log(t)})}},mounted:function(){this.sysDate=this.$store.state.sysDate,this.sysDateBefore=addDate(this.sysDate,-7),this.renderNumber(comp.id,"day",this.$store.state.warehouse,this.$store.state.sysDate),this.renderChart(comp.id,"day",this.$store.state.warehouse,this.$store.state.sysDate)}}),__WEBPACK_IMPORTED_MODULE_0_vue__.default.use(comp.id+"-chart")}(components[i]);__WEBPACK_IMPORTED_MODULE_0_vue__.default.component("dummy-bar",{name:"dummy-bar",template:'<v-flex xs6><v-card class="number-box circle-bar"><v-icon class="md-48 grey100" @click="goSettings">add_circle</v-icon></v-card></v-flex>',data:function(){return{data:{}}},mounted:function(){},methods:{goSettings:function(){this.$router.push({path:"settings"})}}}),__WEBPACK_IMPORTED_MODULE_0_vue__.default.use("dummy-bar")}var __WEBPACK_IMPORTED_MODULE_0_vue__=__webpack_require__("7+uW"),__WEBPACK_IMPORTED_MODULE_1_axios__=__webpack_require__("mtWM"),__WEBPACK_IMPORTED_MODULE_1_axios___default=__webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_axios__),serverUrl="/api",valueUrl=serverUrl+"/value",chartUrl=serverUrl+"/chart",chartOptionUrl=serverUrl+"/chartOption",warehouseUrl=serverUrl+"/dim/warehouse",dateCycleUrl=serverUrl+"/dim/datecycle",loginUrl=serverUrl+"/user/login",metricUrl=serverUrl+"/metric",modelUrl=serverUrl+"/models",echarts=__webpack_require__("XLwt");__webpack_exports__.a={data:function(){return{valid:!1,verified:!0,e1:null,e2:!1,errorMsg:null,username:null,nameRules:[function(t){return!!t||"账号不能为空"}],password:null,mobile:null,pwdRules:[function(t){return!!t||"密码不能为空"}],remPwd:!1,autoLogin:!0,getall:!1}},methods:{getWarehouse:function(){__WEBPACK_IMPORTED_MODULE_1_axios___default.a.get(warehouseUrl).then(function(t){this.$store.commit("setWarehouse",t.data[0]),this.$store.commit("setWarehouseList",t.data),this.getModels()}.bind(this)).catch(function(t){console.log(t)})},getDateCycle:function(){__WEBPACK_IMPORTED_MODULE_1_axios___default.a.get(dateCycleUrl).then(function(t){this.$store.commit("setDateCycle",t.data)}.bind(this)).catch(function(t){console.log(t)})},getMetrics:function(){var t=[],e=[],a=[],s=this;__WEBPACK_IMPORTED_MODULE_1_axios___default.a.get(metricUrl).then(function(r){r.data.forEach(function(r){s.$store.commit("addMetrics",r),0===r.metricType?t.push(r):2===r.metricType?e.push(r):1===r.metricType&&a.push(r)}),s.$store.commit("setHomepageValue",t),s.$store.commit("setHomepageChart",e),s.$store.commit("setHomepageFree",a),s.$router.push({name:"homepage"})}).catch(function(t){console.log(t)})},getModels:function(){__WEBPACK_IMPORTED_MODULE_1_axios___default.a.get(modelUrl).then(function(t){initVue(t.data),this.getMetrics()}.bind(this)).catch(function(t){console.log(t)})},submit:function(){this.username=this.username.toLowerCase(),this.$refs.form.validate()&&__WEBPACK_IMPORTED_MODULE_1_axios___default.a.post(loginUrl,{username:this.username,password:this.password}).then(function(t){void 0===t.data.errors||0===t.data.errors.length?(this.$store.commit("setUser",this.username),__WEBPACK_IMPORTED_MODULE_1_axios___default.a.all([this.getWarehouse(),this.getDateCycle()]).then(__WEBPACK_IMPORTED_MODULE_1_axios___default.a.spread(function(t,e){}))):(this.verified=!1,this.errorMsg=t.data.errors[0].msg,this.$refs.form.reset())}.bind(this)).catch(function(t){console.log(t)})}},mounted:function(){var t="2017/10/31";this.$store.commit("setDate",t);var e=getWeekOfYear(t)+"("+getWeekDuration(t,"s")+"-"+getWeekDuration(t,"e")+")";this.$store.commit("setWeek",e);var a=getMonthOfYear(t)+"("+getMonthDuration(t,"s")+"-"+getMonthDuration(t,"e")+")";this.$store.commit("setMonth",a)}}},wrM5:function(t,e,a){"use strict";var s=a("GUTb"),r=a("2hEF"),i=a("VU/8"),o=i(s.a,r.a,!1,null,null,null);e.a=o.exports},xJD8:function(t,e,a){"use strict";e.a={name:"app"}}},["NHnr"]);
//# sourceMappingURL=app.1797670d79a793ef3e03.js.map