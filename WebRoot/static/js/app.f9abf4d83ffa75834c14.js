webpackJsonp([10],{114:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),window.config={screenWidth:document.documentElement.clientWidth,screenHeight:document.documentElement.clientHeight,contentHeight:function(t,e){var n=window.config.screenHeight;return t&&(n-=48),e&&(n-=48),n}},e.default={name:"app",data:function(){return{screenWidth:document.documentElement.clientWidth,screenHeight:document.documentElement.clientHeight}}}},115:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var o=n(9),c=n(40),r=n.n(c),u=n(46),i=n(45),a=n(39),s=n(43),l=(n.n(s),n(44),n(42)),_=(n.n(l),n(41));n.n(_);o.a.config.productionTip=!1,o.a.use(a.a),new o.a({el:"#app",router:i.a,store:u.a,template:"<App/>",components:{App:r.a}})},116:function(module,__webpack_exports__,__webpack_require__){"use strict";var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_json_stringify__=__webpack_require__(49),__WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_json_stringify___default=__webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_json_stringify__),local={set:function(t,e){"string"==typeof e?localStorage.setItem(t,e):localStorage.setItem(t,__WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_json_stringify___default()(e))},get:function get(key){var value=localStorage.getItem(key);if(value&&("{"==value.substr(0,1)||"["==value.substr(0,1)))try{value=eval("("+value+")")}catch(t){console.log("error in get cache key:"+key+", value:"+value)}return value}};__webpack_exports__.a=local},117:function(t,e,n){"use strict";var o=n(112),c=n.n(o),r=n(51),u=n.n(r),i=u.a.create();i.defaults.baseURL="http://localhost:8080",i.defaults.method="post",i.defaults.timeout=6e4,i.defaults.headers.post["Content-Type"]="application/x-www-form-urlencoded",i.interceptors.request.use(function(t){return t},function(t){return console.log(t),c.a.reject(t)}),i.interceptors.response.use(function(t){return t},function(t){return console.log(t),c.a.reject(t)}),e.a=i},118:function(t,e,n){"use strict";var o=n(116),c=n(117);o.a,c.a},119:function(t,e,n){"use strict";var o=n(113),c=n.n(o),r=(n(118),{ADD_PRODUCT:"ADD_PRODUCT"}),u={productList:[{name:"product A",price:18,isHot:!0},{name:"product B",price:28,isHot:!1},{name:"product C",price:38,isHot:!0}]},i={getHotProductlist:function(t){return t.productList.map(function(t){return t.isHot?t:{}})}},a={add:function(t,e){var n=t.commit;t.state;n(r.ADD_PRODUCT,e)}},s=c()({},r.ADD_PRODUCT,function(t,e){t.productList.push(e)});e.a={state:u,getters:i,actions:a,mutations:s}},40:function(t,e,n){var o=n(47)(n(114),n(71),null,null,null);t.exports=o.exports},41:function(t,e){},42:function(t,e){},43:function(t,e){},44:function(t,e,n){"use strict";n(9).a.filter("filter-gender",function(t){return"1"===t?"男":"女"})},45:function(t,e,n){"use strict";var o=n(9),c=n(109);c.a.prototype.goBack=function(){this.isBack=!0,window.history.go(-1)},o.a.use(c.a);var r=new c.a({routes:[{path:"/",redirect:"/page/home"},{path:"/page",name:"page",component:function(t){n.e(2).then(function(){return t(n(129))}.bind(null,n)).catch(n.oe)},children:[{path:"login",component:function(t){n.e(6).then(function(){return t(n(128))}.bind(null,n)).catch(n.oe)}},{path:"home",component:function(t){n.e(7).then(function(){return t(n(126))}.bind(null,n)).catch(n.oe)}},{path:"customer",component:function(t){n.e(4).then(function(){return t(n(125))}.bind(null,n)).catch(n.oe)}},{path:"about",component:function(t){n.e(8).then(function(){return t(n(122))}.bind(null,n)).catch(n.oe)}},{path:"list",component:function(t){n.e(3).then(function(){return t(n(127))}.bind(null,n)).catch(n.oe)}},{path:"chart",component:function(t){n.e(0).then(function(){return t(n(123))}.bind(null,n)).catch(n.oe)}},{path:"contact",component:function(t){n.e(1).then(function(){return t(n(124))}.bind(null,n)).catch(n.oe)}},{path:"test",component:function(t){n.e(5).then(function(){return t(n(130))}.bind(null,n)).catch(n.oe)}}]}]});e.a=r},46:function(t,e,n){"use strict";var o=n(9),c=n(72),r=n(119);o.a.use(c.a),e.a=new c.a.Store({modules:{common:r.a}})},71:function(t,e){t.exports={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"app"}},[n("router-view")],1)},staticRenderFns:[]}}},[115]);