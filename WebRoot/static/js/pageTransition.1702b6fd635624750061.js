webpackJsonp([2],{129:function(t,e,n){function i(t){n(220)}var o=n(49)(n(368),n(216),i,null,null);t.exports=o.exports},209:function(t,e,n){e=t.exports=n(120)(!1),e.push([t.i,".child-view{position:absolute;top:0;width:100%;height:100%;transition:all .1s ease-out}.slide-left-enter,.slide-right-leave-active{opacity:0;-webkit-transform:translate(50px);transform:translate(50px)}.slide-left-leave-active,.slide-right-enter{opacity:0;-webkit-transform:translate(-50px);transform:translate(-50px)}",""])},216:function(t,e){t.exports={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("transition",{attrs:{name:t.transitionName}},[n("router-view")],1)],1)},staticRenderFns:[]}},220:function(t,e,n){var i=n(209);"string"==typeof i&&(i=[[t.i,i,""]]),i.locals&&(t.exports=i.locals);n(121)("263f0bc7",i,!0)},368:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.default={data:function(){return{transitionName:"slide-left",bottomNav:"home",hasFooter:!0,screenWidth:document.documentElement.clientWidth,screenHeight:document.documentElement.clientHeight}},methods:{handleChange:function(t){this.bottomNav=t}},beforeRouteUpdate:function(t,e,n){var i=this.$router.isBack;this.transitionName=i?"slide-right":"slide-left",this.$router.isBack=!1,n()}}}});