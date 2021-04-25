package com.yjq.server.bean;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2020-09-19 23:14
 */

/**
 * 错误码统一处理类，所有的错误码统一定义在这里
 */
public class CodeMsg {

    private Integer code;//错误码

    private String msg;//错误信息

    /**
     * 构造函数私有化即单例模式
     * 该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。
     * @param code
     * @param msg
     */
    private CodeMsg(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public CodeMsg() {

    }

    public Integer getCode() {
        return code;
    }



    public void setCode(Integer code) {
        this.code = code;
    }



    public String getMsg() {
        return msg;
    }



    public void setMsg(String msg) {
        this.msg = msg;
    }

    //通用错误码定义
    //处理成功消息码
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    //通用数据错误码
    public static CodeMsg DATA_ERROR = new CodeMsg(-1, "非法数据！");
    public static CodeMsg VALIDATE_ENTITY_ERROR = new CodeMsg(-2, "");
    public static CodeMsg CAPTCHA_EMPTY = new CodeMsg(-3, "验证码不能为空!");
    public static CodeMsg NO_PERMISSION = new CodeMsg(-4, "您没有当前操作的权限哦！");
    public static CodeMsg CAPTCHA_ERROR = new CodeMsg(-5, "验证码错误！");
    public static CodeMsg USER_SESSION_EXPIRED = new CodeMsg(-6, "还未登录或会话失效，请重新登录！");
    public static CodeMsg PHOTO_EMPTY = new CodeMsg(-7, "上传的图片不能为空！");
    public static CodeMsg PHOTO_SURPASS_MAX_SIZE = new CodeMsg(-8, "上传的图片不能超过10MB！");
    public static CodeMsg PHOTO_FORMAT_NOT_CORRECT = new CodeMsg(-9, "上传的图片格式不正确！");
    public static CodeMsg SAVE_FILE_EXCEPTION = new CodeMsg(-10, "保存文件异常！");
    public static CodeMsg FILE_EXPORT_ERROR = new CodeMsg(-11, "文件导出失败！");
    public static CodeMsg SYSTEM_ERROR = new CodeMsg(-12, "系统出现了错误，请联系管理员！");
    public static CodeMsg EXPORT_EXCEL_ERROR = new CodeMsg(-13, "导出Excel文件失败，请联系管理员！");
    public static CodeMsg CAPTCHA_EXPIRED = new CodeMsg(-14, "验证码已过期，请刷新验证码！");
    public static CodeMsg REQUEST_LIMIT = new CodeMsg(-15, "当前请求被限流，请稍后重试！");
    public static CodeMsg REQUEST_COUNT_MANY = new CodeMsg(-16, "当前请求接口次数过多，请稍后重试！");


    //用户管理类错误码
    public static CodeMsg CONFIRM_PASSWD_EMPTY = new CodeMsg(-1000, "确认密码不能为空！");
    public static CodeMsg USERNAME_EXIST = new CodeMsg(-1001, "用户昵称存在，请换一个！");
    public static CodeMsg USER_PHONE_EXIST = new CodeMsg(-1002, "用户手机号存在，请换一个！");
    public static CodeMsg PASSWD_NOT_MATCH = new CodeMsg(-1003, "密码和确认密码不一致！");
    public static CodeMsg REGISTER_ERROR = new CodeMsg(-1004, "用户注册失败，请联系管理员！");
    public static CodeMsg USER_PREPASSWD_EMPTY = new CodeMsg(-1005, "原密码不能为空！");
    public static CodeMsg USER_NEWPASSWD_EMPTY = new CodeMsg(-1006, "新密码不能为空！");
    public static CodeMsg USER_REPASSWD_EMPTY = new CodeMsg(-1007, "确认新密码不能为空！");
    public static CodeMsg USER_REPASSWD_NOT_EQUAL_NEWPASSWD = new CodeMsg(-1008, "确认新密码和新密码不一致！");
    public static CodeMsg USER_PREPASSWD_NOT_CORRECT = new CodeMsg(-1009, "原密码输入错误！");
    public static CodeMsg USER_PASSWD_EDIT_ERROR = new CodeMsg(-1010, "修改密码失败，请联系管理员！");
    public static CodeMsg USERNAME_EMPTY = new CodeMsg(-1011, "昵称不能为空！");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(-1012, "密码不能为空！");
    public static CodeMsg USERNAME_OR_PASSWD_ERROR = new CodeMsg(-1013, "昵称或密码错误！");
    public static CodeMsg USER_ROLE_EMPTY = new CodeMsg(-1014, "用户所属角色不能为空！");
    public static CodeMsg USER_INFO_EDIT_ERROR = new CodeMsg(-1015, "用户个人信息修改失败，请联系管理员！");
    public static CodeMsg USER_ADD_ERROR = new CodeMsg(-1016, "添加用户信息失败，请联系管理员！");
    public static CodeMsg USER_EDIT_ERROR = new CodeMsg(-1017, "修改用户信息失败，请联系管理员！");
    public static CodeMsg USER_DELETE_ERROR = new CodeMsg(-1018, "删除用户信息失败，请联系管理员！");
    public static CodeMsg ILLEGAL_EDIT_USER_ROLE = new CodeMsg(-1019, "你不能非法篡改用户角色！");


    //权限管理类错误码
    public static CodeMsg AUTHORITY_NAME_EXIST = new CodeMsg(-2000, "该角色已有该权限，请换一个！");
    public static CodeMsg AUTHORITY_ADD_ERROR = new CodeMsg(-2001, "添加权限信息失败，请联系管理员！");
    public static CodeMsg AUTHORITY_EDIT_ERROR = new CodeMsg(-2002, "修改权限信息失败，请联系管理员！");
    public static CodeMsg AUTHORITY_DELETE_ERROR = new CodeMsg(-2003, "删除权限信息失败，请联系管理员！");

    //库存管理类错误码
    public static CodeMsg STOCK_NAME_EXIST = new CodeMsg(-3000, "库存名称重复，请换一个！");
    public static CodeMsg STOCK_ADD_ERROR = new CodeMsg(-3001, "添加库存信息失败，请联系管理员！");
    public static CodeMsg STOCK_EDIT_ERROR = new CodeMsg(-3002, "修改库存信息失败，请联系管理员！");
    public static CodeMsg STOCK_DELETE_ERROR = new CodeMsg(-3003, "删除库存信息失败，请联系管理员！");
    public static CodeMsg STOCK_NOT_ENOUGH = new CodeMsg(-3004, "库存不足，请减少购买数量！");
    public static CodeMsg STOCK_NOT_EXIST = new CodeMsg(-3005, "该图书库存不存在，请稍后购买！");
    public static CodeMsg STOCK_SOLD_OUT = new CodeMsg(-3006, "该图书已售罄，请更换图书购买！");


    //图书管理错误码
    public static CodeMsg BOOK_NAME_EXIST = new CodeMsg(-4000, "图书名称重复，请换一个！");
    public static CodeMsg BOOK_ADD_ERROR = new CodeMsg(-4001, "添加图书信息失败，请联系管理员！");
    public static CodeMsg BOOK_EDIT_ERROR = new CodeMsg(-4002, "修改图书信息失败，请联系管理员！");
    public static CodeMsg BOOK_DELETE_ERROR = new CodeMsg(-4003, "删除图书信息失败，请联系管理员！");
    public static CodeMsg PRESS_TIME_ERROR = new CodeMsg(-4004, "出版时间的格式不正确！");
    public static CodeMsg STOCK_ALREADY_SELECTED = new CodeMsg(-4005, "该库存已属于其他图书，请换一个！");
    public static CodeMsg ADD_OTHER_BOOK = new CodeMsg(-4006, "你不能给其他用户添加图书！");
    public static CodeMsg SELECT_OTHER_STOCK = new CodeMsg(-4007, "你不能选择其他用户的库存！");
    public static CodeMsg IS_KILL_EMPTY = new CodeMsg(-4008, "图书是否参与秒杀的选择不能为空！");
    public static CodeMsg KILL_END_ERROR = new CodeMsg(-4009, "秒杀结束时间的格式不正确！");
    public static CodeMsg KILL_END_LE_NOW = new CodeMsg(-4010, "秒杀结束时间不能小等于当前时间！");
    public static CodeMsg KILL_PRICE_EMPTY = new CodeMsg(-4011, "秒杀价格不能为空！");
    public static CodeMsg KILL_PRICE_MIN_ERROR = new CodeMsg(-4012, "秒杀价格不能小于0.00元！");
    public static CodeMsg KILL_PRICE_MAX_ERROR = new CodeMsg(-4013, "秒杀价格不能大于999999.99元！");
    public static CodeMsg BOOK_NOT_EXIST = new CodeMsg(-4014, "该图书已不存在！");
    public static CodeMsg KILL_PRICE_GE_OLD_PRICE = new CodeMsg(-4015, "秒杀价格不能大等于原价格！");
    public static CodeMsg EDIT_OTHER_BOOK = new CodeMsg(-4016, "你不能修改其他用户的图书信息！");
    public static CodeMsg BOOK_STATE_EMPTY = new CodeMsg(-4017, "图书状态不能为空！");
    public static CodeMsg KILL_END_GT_MAX_TIME = new CodeMsg(-4018, "秒杀结束时间必须在99天之内！");
    public static CodeMsg KILL_END_EXPIRED = new CodeMsg(-4019, "该图书已过秒杀时间，无法购买！");
    public static CodeMsg BOOK_STATE_EXCEPTION = new CodeMsg(-4020, "该图书状态异常，无法购买！");

    //购物车管理错误码
    public static CodeMsg CART_ADD_ERROR = new CodeMsg(-5001, "购物车信息添加失败，请联系管理员！");
    public static CodeMsg CART_DELETE_ERROR = new CodeMsg(-5002, "购物车信息删除失败，请联系管理员！");
    public static CodeMsg CART_QUANTITY_EDIT_ERROR = new CodeMsg(-5003, "此条记录已不存在，修改数量失败！");
    public static CodeMsg CART_EDIT_ERROR = new CodeMsg(-5004, "购物车信息修改失败，请联系管理员！");
    public static CodeMsg NO_SELECT_OR_PAY_EXPIRED = new CodeMsg(-5005, "没有选择购买的图书或者支付时间已过！");
    public static CodeMsg CART_NUM_OUT_LIMIT = new CodeMsg(-5006, "购物车不能多于100种图书！");
    public static CodeMsg ADD_CART_BUST = new CodeMsg(-5007, "当前抢购过于火爆，请刷新页面再添加购物车！");
    public static CodeMsg ADD_CART_ILLEGAL = new CodeMsg(-5008, "非法请求访问添加购物车！");
    public static CodeMsg BUY_NUM_LT_MIN = new CodeMsg(-5009, "购买数量至少为1本！");

    //订单管理错误码
    public static CodeMsg SUBMIT_ORDER_ERROR = new CodeMsg(-6000, "提交订单失败，请稍后重试！");
    public static CodeMsg ORDER_BOOK_NOT_EXIST = new CodeMsg(-6001, "订单中有图书已经不存在了哦，请检查下订单！");
    public static CodeMsg ORDER_NOT_EXIST = new CodeMsg(-6002, "该订单已不存在！");
    public static CodeMsg ORDER_DELETE_ERROR = new CodeMsg(-6003, "订单删除失败，请联系管理员！");
    public static CodeMsg EDIT_ORDER_STATE_ERROR = new CodeMsg(-6004, "修改订单状态失败，请联系管理员！");

    //支付管理错误码
    public static CodeMsg CREATE_PAY_ERROR = new CodeMsg(-7000, "创建支付数据失败，请联系管理员！");
    public static CodeMsg CREATE_PAY_ITEM_ERROR = new CodeMsg(-7001, "创建支付详情数据失败，请联系管理员！");
    public static CodeMsg PAY_SESSION_EXPIRED = new CodeMsg(-7002, "支付会话失效，请重新操作！");
    public static CodeMsg PAY_DATA_ERROR = new CodeMsg(-7003, "数据非法，支付失败，请重新操作！");
    public static CodeMsg PAY_SUCCESS_BUT_DATA_ERROR = new CodeMsg(-7004, "支付成功，但数据异常，下单失败，请及时联系管理员解决！");
    public static CodeMsg PAY_SUCCESS_BUT_PAY_STATE_ERROR = new CodeMsg(-7005, "支付成功，但支付状态异常，下单失败，请及时联系管理员解决！");
    public static CodeMsg PAY_SUCCESS_BUT_ORDER_STATE_ERROR = new CodeMsg(-7006, "支付成功，但订单状态异常，下单失败，请及时联系管理员解决！");
    public static CodeMsg PAY_NOT_EXIST = new CodeMsg(-7007, "该支付数据已不存在！");
}
