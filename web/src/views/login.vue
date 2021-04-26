<template>
    <div id="submitView" class="viewer clearfix">
        <section class="submit_title">
            <div class="container" id="">
                <div class="col-md-12 clearfix">
                    <div class="now_submit clearfix" style="margin-left:0px;">
                        <div class="form-group" id="form_info">
                             <span style="text-align: center;font-size:18px;">
                                    <label class="mgt10">
                                    在线点餐系统登录页面
                                    </label>
                            </span>

                            <label>
                                用户名
                            </label>
                            <span class="twitter-typeahead">
                            <input type="text" v-model="user.username" name="phone" class="form-control tt-query" autocomplete="off"
                                   spellcheck="false" dir="auto">
                            </span>


                            <label class="mgt10">
                                密码
                            </label>
                            <span class="twitter-typeahead">
                            <input type="text" v-model="user.password" name="name" class="form-control tt-query" autocomplete="off"
                                   spellcheck="false" dir="auto">
                            </span>


                        </div>
                        <div class="form-group">
                            <div class="btn_control fr">
                                <a class="btn btn-default bottommargin" @click="openRegister()" id="cancelSubmit">
                                    注册
                                </a>
                                <button class="btn btn-info bottommargin" @click="submitLogin()" id="stickyGrowl">
                                    登录
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
</template>

<script>
    export default {
        name: 'login',
        data: function() {
            return {
                user: {}
            }
        },
        //mounted 页面渲染完后执行 钩子函数
        mounted:function(){
            $("body").css("background-color","#f2eeeb");
        },
        methods:{
            openRegister(){
                this.$router.push("/register")
            },
            submitLogin(){
                let _this = this;
                _this.$ajax.post("http://127.0.0.1:9000/business/web/user/login", _this.user).then((response)=>{
                    let resp = response.data;
                    if(resp.code == 0){
                        alert("成功");
                    }else{
                        alert(resp.msg);
                    }
                });
            }
        }
    }

</script>


<style>
</style>
