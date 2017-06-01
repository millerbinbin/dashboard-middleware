Vue.config.devtools = true;
var router = new VueRouter({});
router.map({
    '/': {
        component: app.list
    },
    '/edit': {
        component: app.edit
    },
});
var App = Vue.extend({});
router.start(App, '#app');