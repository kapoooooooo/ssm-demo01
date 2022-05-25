package cn.kapooo.ssm.qo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class JsonResult {
    private boolean success = true;
    private String msg = "成功";
    private Object result;

    public JsonResult() {
    }

    public JsonResult(boolean success, String msg, Object result) {
        this.success = success;
        this.msg = msg;
        this.result = result;
    }

    public JsonResult(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public JsonResult(String msg, Object result) {
        this.msg = msg;
        this.result = result;
    }



    public static JsonResult success (String msg, Object result){
        JsonResult jsonResult = new JsonResult(true, msg, result);
        return  jsonResult;
    }
    public static JsonResult fail (String msg, Object result){
        JsonResult jsonResult = new JsonResult(false, msg, result);
        return  jsonResult;
    }

    public static JsonResult success (String msg){
        JsonResult jsonResult = new JsonResult(true, msg, null);
        return  jsonResult;
    }

    public static JsonResult fail (String msg){
        JsonResult jsonResult = new JsonResult(false, msg, null);
        return  jsonResult;
    }
}
