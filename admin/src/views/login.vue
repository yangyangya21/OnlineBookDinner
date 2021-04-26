<template>
    <div class="login_box">
        <div class="login_l_img"><img src="../../public/static/login/images/login-img.png" /></div>
        <div class="login">
            <div class="login_logo"><img src="../../public/static/login/images/login_logo.png" /></div>
            <div class="login_name">
                <p>后台管理系统</p>
            </div>
            <input name="username" id="user_no" type="text" class="required" placeholder="请输入昵称"/>
            <input id="password_text" type="password" class="required" placeholder="请输入密码"/>
            <input id="captcha" type="text" class="required" style="width:150px;margin-bottom: 40px;" placeholder="请输入验证码">
            <img id="captcha-img" title="点击切换验证码" style="cursor:pointer;" src="" width="135px" height="50px" >
            <input value="登录" style="width:100%;" type="button" onclick="login();" />
        </div>

        <div class="copyright">版权所有©2020-2021 杨杨吖 技术支持QQ：823208782</div>
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
        methods:{
        }
    }

</script>


<style>
</style>
