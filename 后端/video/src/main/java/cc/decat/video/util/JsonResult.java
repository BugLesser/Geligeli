package cc.decat.video.util;

public class JsonResult {

    private Integer state;
    private String msg;
    private Object data;

    public JsonResult(Integer state, String msg, Object data) {
        this.state = state;
        this.msg = msg;
        this.data = data;
    }

    public static JsonResult ok(String msg) {
        return new JsonResult(200, msg, null);
    }

    public static JsonResult error(String msg) {
        return new JsonResult(500, msg, null);
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
