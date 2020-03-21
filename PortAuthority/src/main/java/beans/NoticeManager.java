package beans;

import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.jms.*;
import java.io.Serializable;

@SessionScoped
@Named("noticeMgr")
public class NoticeManager implements Serializable {


    private static final long serialVersionUID = 1L;

    private NoticeOfArrival notice = new NoticeOfArrival();
    @Resource(mappedName = "jms/myLog")
    private Queue logMessages;
    @Resource(mappedName = "jms/AgentOne")
    private Topic AgentOne;
    @Resource(mappedName = "jms/AgentTwo")
    private Topic AgentTwo;
    @Resource(mappedName = "jms/myMessageFactory")
    private ConnectionFactory logFactory;


    public void setNotice(NoticeOfArrival notice) {
        this.notice = notice;
    }

    private void sendMessage(String msg) {
        JMSContext context = logFactory.createContext();
        JMSProducer mp = context.createProducer();
        Message tm = context.createTextMessage(msg);
        mp.send(logMessages, tm);
    }
    private void sendToClient(String msg, Topic client) {
        JMSContext context = logFactory.createContext();
        JMSProducer mp = context.createProducer();
        Message tm = context.createTextMessage(msg);
        mp.send(logMessages, tm);
    }

    public NoticeOfArrival getNotice() {
        return notice;
    }

    public void mesg() {
        System.out.println("NM: Sending Message");
        String json = this.notice.toJsonString();
        System.out.println(json);
        sendMessage(json);
        switch(this.notice.getClient()) {
            case 1:
            case 3:
                sendToClient(json, AgentOne);
                break;
            case 2:
                sendToClient(json, AgentTwo);
                break;
        }
        System.out.println("NM: Sent Message!");
    }

}
