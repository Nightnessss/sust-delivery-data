package com.fehead.sustdelivery.error;

/**
 * 写代码 敲快乐
 * だからよ...止まるんじゃねぇぞ
 * ▏n
 * █▏　､⺍
 * █▏ ⺰ʷʷｨ
 * █◣▄██◣
 * ◥██████▋
 * 　◥████ █▎
 * 　　███▉ █▎
 * 　◢████◣⌠ₘ℩
 * 　　██◥█◣\≫
 * 　　██　◥█◣
 * 　　█▉　　█▊
 * 　　█▊　　█▊
 * 　　█▊　　█▋
 * 　　 █▏　　█▙
 * 　　 █
 *
 * @author Nightnessss 2019/7/8 16:27
 */
public enum EmBusinessError implements CommonError {
    // 通用错误类型 10001
    UNKNOWN_ERROR(10000, "未知错误"),
    PARAMETER_VALIDATION_ERROR(10001, "参数不合法"),
//    DATA_ERROR(10002, "数据层参数获取异常"),

    // 20000 开头为用户信息相关错误定义

    DATA_ERROR(20000,"数据操作失败"),
    DATA_INSERT_ERROR(20001,"数据插入失败"),
    DATA_DELETE_ERROR(20002,"数据删除失败"),
    DATA_UPDATE_ERROR(20003,"数据更新失败"),
    DATA_SELECT_ERROR(20004,"数据查询失败")
    ;

    private EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    private int errCode;
    private String errMsg;



    @Override
    public int getErrorCode() {
        return errCode;
    }

    @Override
    public String getErrorMsg() {
        return errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
