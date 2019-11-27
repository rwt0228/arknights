package com.rwt.arknights.web.bean;

public class JsonResult {
    private boolean status;
    private String message;
    private String code;
    private Object data;

    public JsonResult(boolean status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public JsonResult() {

    }

    public static JsonResult OK(Object object) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode("200");
        jsonResult.setStatus(true);
        jsonResult.setMessage("操作成功");
        jsonResult.setData(object);
        return jsonResult;
    }

    public static JsonResult OK(String message) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode("200");
        jsonResult.setStatus(true);
        jsonResult.setMessage(message);
        return jsonResult;
    }

    public static JsonResult OK() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode("200");
        jsonResult.setStatus(true);
        jsonResult.setMessage("操作成功");
        return jsonResult;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static JsonResult Error() {
        JsonResult result = new JsonResult();
        result.setMessage("异常");
        result.setStatus(false);
        result.setCode("500");
        return result;
    }

    public static JsonResult Error(String msg) {
        JsonResult result = new JsonResult();
        result.setMessage(msg);
        result.setStatus(false);
        result.setCode("500");
        return result;
    }
}
