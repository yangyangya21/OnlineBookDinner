<template>
    <div id="submitView" class="viewer clearfix">
        <section class="submit_title" >
            <div class="container" id="">
                <div class="col-md-12 clearfix">
                    <div class="now_submit clearfix" style="margin-left:0px;">
                        <form role="form">
                            <div class="form-group" id="form_info">
                                <span style="text-align: center;font-size:18px;">
                                    <label class="mgt10">
                                    在线点餐系统注册页面
                                    </label>
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
                                    <a class="btn btn-default bottommargin" id="cancelSubmit">
                                        注册
                                    </a>
                                    <button class="btn btn-info bottommargin" id="stickyGrowl">
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
        name: 'register',
        //mounted 页面渲染完后执行 钩子函数
        mounted:function(){
            $("body").css("background-color","#f2eeeb");
        }
    }

</script>


<style>
</style>
