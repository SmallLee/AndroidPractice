package practice.lxn.cn.testapp.event;

/**
 * 描述：
 *
 * @author Create by zxy on 2018/5/15
 */
public class TokenEvent {
    private String message;
    public TokenEvent(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
