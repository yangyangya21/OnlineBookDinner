<template>
   <main role="main">
       <div>欢迎您，<span v-text="user.username"></span>！请挑选您的食物叭！</div>
       <div id="wrapper" class="viewer">
           <div id="sidebar-wrapper">
               <div class="well sidebar-nav">
                   <nav id="J_menuList" class="nav nav-list">

                       <dl><dd class="active"><a data_name="肉品">肉品</a></dd></dl>
                   </nav>
               </div>

               <footer class="footFix footRight">
                    <span style="display:block;width:50px;height:50px;">
                    <img src="../../public/static/dinner/images/cart.png"><sup id="total-sum" display="font-color:red;">0</sup>
                    </span>
               </footer>
           </div>
           <div id="page-content-wrapper" class="">
               <div class="page-content">
                   <div class="container" id="J_list_Container">
                       <div class="row">
                           <div class="col-md-4 clearfix foot-items">
                               <div class="col-xs-4 foot-img">
                                   <img src='http://127.0.0.1:9000/business/common/photo/view?filename=1.jpg' class="img-responsive" alt="Responsive image" data_id="1">
                               </div>
                               <div class="col-xs-6 foot-info"><p><strong>纯瘦肉</strong></p><p class="colred">15元/份</p><p><small>45人买过</small></p></div>
                               <div class="col-xs-2 icons-pick foot-pick"><div class="btn_wrap" style="margin-top:45%;width:80px;"><button class="list_minus" style="display: inline-block;" data_id="1"><strong></strong></button><i style="display: inline-block;" class="food-count-i">0</i><button class="list_add list_id_respone" data_id="1"><strong></strong></button><em class="fixBig  fake"></em></div></div>
                           </div>

                       </div>
                   </div>
               </div>
           </div>
           <footer class="footFix footLeft">
               <button id="myOrder" class="btn_change">
                   菜篮子
                   <!--span class="num">9</span-->
               </button>
           </footer>
       </div>
   </main>
</template>

<script>
    export default {
        name: 'dinner',
        data: function() {
            return {
                iG:{},
                user:{}
            }
        },
        //created 页面渲染前执行 钩子函数
        created:function() {
            let _this = this;
            let token = Tool.getLoginUser();
            if (Tool.isEmpty(token)) {
                this.$router.push("/login");
            }else{
                //用token去查询用户数据是否仍存在
                _this.$ajax.post("http://127.0.0.1:9000/business/web/user/check_login", {token:token}).then((response)=>{
                    let resp = response.data;
                    if(resp.code == 0){
                        _this.user = resp.data;
                    }else{
                        this.$router.push("/login");
                    }
                });
            }
        },
        //mounted 页面渲染完后执行 钩子函数
        mounted:function() {
            let  _this = this;
            if(window.localStorage){
                try{
                    _this.iG = JSON.parse(localStorage["zaiG"])||{};
                }catch(e){
                    localStorage.removeItem("zaiG");
                    _this.iG = _this.iG||{};
                }
            }else{
                _this.iG = _this.iG||{};
            }
            setTimeout(function () { window.scrollTo(0, 1); }, 0);
            setTimeout(function () {
                _this.iG.items={
                    "肉品":[{id:"1",name:"纯瘦肉",cls:"肉品",price:"15",sels:"45",imageUrl:"../../public/static/dinner/images/1.jpg"},
                        {id:"2",name:"猪耳朵",cls:"肉品",price:"23",sels:"75",imageUrl:"../../public/static/dinner/images/2.jpg"},
                        {id:"3",name:"牛肉",cls:"肉品",price:"45",sels:"36",imageUrl:"../../public/static/dinner/images/3.jpg"},
                        {id:"4",name:"牛肉和牛肚",cls:"肉品",price:"85",sels:"26",imageUrl:"../../public/static/dinner/images/4.jpg"},
                        {id:"5",name:"排骨",cls:"肉品",price:"63",sels:"12",imageUrl:"../../public/static/dinner/images/5.jpg"},
                        {id:"6",name:"猪脚",cls:"肉品",price:"56",sels:"32",imageUrl:"../../public/static/dinner/images/6.jpg"}
                    ],
                };
                _this.init();//ajax成功后执行init();
                _this.showTotal();

                _this.showEveryFoodTotal();
            }, 20);//模拟ajax请求时间

        },
        methods:{
            init(){
                //初始化整个页面
                let _this = this;
                //_this.setMenu(_this.iG.items);
                //$("#J_list_Container").html(_this.listManger(_this.iG.items));
                $("#loadingView").addClass("hide");
            },
            setMenu(_list){
                let  _this = this;
                _this.iG.menu = [];
                _this.iG.indexMenu = (function(){
                    var menu;
                    var count = 0;
                    for(var i in _list){
                        if(count===0){
                            menu =  i;
                        }
                        count++;
                        _this.iG.menu.push(i);
                    }
                    return menu;
                })();
                _this.buildMenu(_this.iG.menu);
            },
            buildMenu(_list){
                var menuHtml = "<dl>";
                var active;
                let _this = this;
                for(var i in _list){
                    active = "";
                    if(_list[i]===_this.iG.indexMenu)active = "active";
                    menuHtml += "<dd class=\""+active+"\"><a data_name=\""+ _list[i] +"\">"+ _list[i] +"</a></dd>"

                }
                menuHtml += "</dl>";
                $("#J_menuList").html(menuHtml);
            },
            showTotal(){
                let _this = this;
                var total = 0;
                for(var i in _this.iG.order){
                    total += _this.iG.order[i].counter;
                }
                $("#total-sum").text(total);
            },
            showEveryFoodTotal(){
                let _this = this;
                $(".food-count-i").text(0);
                var total = 0;
                for(var i in _this.iG.order){
                    total += _this.iG.order[i].counter;
                    $("button[data_id="+i+"]").prev(".food-count-i").text(_this.iG.order[i].counter);
                }
            },
            listManger(_list){
                let _this = this;
                var result = "";
                var listArr = [];
                var indexList = _list[_this.iG.indexMenu];
                for(var i in indexList){
                    listArr.push(indexList[i]);
                    if(Math.floor(i/3)===0&&i>2){
                        result += "<div class=\"row\">";
                        result += _this.buildList(listArr);
                        result += "</div>";
                        listArr = [];
                    }
                }
                result += "<div class=\"row\">";
                result += _this.buildList(listArr);
                result += "</div>";
                return result;
            },
            buildList(_list){
                var result = "";
                for(var i in _list){
                    result += "<div class=\"col-md-4 clearfix foot-items\"><div class=\"col-xs-4 foot-img\"><img :src=\""+(_list[i].imageUrl)+"\" class=\"img-responsive\" alt=\"Responsive image\" data_id=\""+_list[i].id+"\" ></div><div class=\"col-xs-6 foot-info\"><p><strong>"+_list[i].name+"</strong></p><p class=\"colred\">"+_list[i].price+"元/份</p><p><small>"+_list[i].sels+"人买过</small></p></div><div class=\"col-xs-2 icons-pick foot-pick\"><div class=\"btn_wrap\" style=\"margin-top:45%;width:80px;\"><button class=\"list_minus\" style=\"display: inline-block;\" data_id=\""+_list[i].id+"\"><strong></strong></button><i style=\"display: inline-block;\" class=\"food-count-i\">0</i><button class=\"list_add list_id_respone\" data_id=\""+_list[i].id+"\"><strong></strong></button><em class=\"fixBig  fake\"></em></div></div></div>"
                    //<button ontouchstart=\"\" class=\"list_id_respone button button-circle button-flat-primary fa fa-plus\" data_id=\""+_list[i].id+"\"></button>
                }
                return result;
            }
        }
    }





</script>


<style>
</style>
