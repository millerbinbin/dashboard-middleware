Vue.config.devtools = true;
Vue.config.debug = true;
var router = new VueRouter({});
router.map({
    '/': {
        component: app.list
    },
    '/edit': {
        component: app.edit
    },
    '/add': {
        component: app.add
    }
});
var App = Vue.extend({});
router.start(App, '#app');