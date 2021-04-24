<template>
    <div id="submitView" class="viewer clearfix" style="">
        <section class="submit_title" style="height:850px;">
            <div class="container" id="">
                <div class="col-md-12 clearfix">
                    <div class="now_submit clearfix" style="margin-left:0px;">
                        <form role="form">
                            <div class="form-group" id="form_info">
                                <label>
                                    用户名
                                </label>
                                <span class="twitter-typeahead">
                                <input type="text" name="phone" class="form-control tt-query" autocomplete="off"
                                       spellcheck="false" dir="auto">
                            </span>
                                <label class="mgt10">
                                    密码
                                </label>
                                <span class="twitter-typeahead">
                                <input type="text" name="name" class="form-control tt-query" autocomplete="off"
                                       spellcheck="false" dir="auto">
                            </span>

                            </div>
                            <div class="form-group">
                                <div class="btn_control fr">
                                    <a class="btn btn-default bottommargin" @click="openRegister()" id="cancelSubmit">
                                        注册
                                    </a>
                                    <button formaction="order.html" class="btn btn-info bottommargin" id="stickyGrowl">
                                        登录
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </div>
</template>

<script>

    export default {
        name: 'login',
        methods:{
            openRegister(){
                this.$router.push("/register")
            }
        }
    }

</script>


<style>
</style>
