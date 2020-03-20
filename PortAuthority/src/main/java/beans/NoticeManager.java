package beans;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.jms.*;

@SessionScoped
@Named("noticeMgr")
public class NoticeManager implements Serializable {


    private static final long serialVersionUID = 1L;

    private NoticeOfArrival notice = new NoticeOfArrival();
    @Resource(mappedName = "jms/myLog")
    private Queue logMessages;
    @Resource(mappedName = "jms/myMessageFactory")
    private ConnectionFactory logFactory;


    public void setNotice(NoticeOfArrival notice) {
        this.notice = notice;
    }

    public String toJSON(NoticeOfArrival notice) {
        // Variables in NoticeOfArrival: long ID (auto-generated) and String name (string)
        return "{\"id\": "+notice.getId()+", \"mmsi\": " + notice.getMmsi() + ", \"client\": " + notice.getClient() + ", \"name\": " + notice.getName() + " }";
    }

    public void sendMessage(String msg) {
        JMSContext context = logFactory.createContext();
        JMSProducer mp = context.createProducer();
        Message tm = context.createTextMessage(msg);
        mp.send(logMessages, tm);
    }

    public NoticeOfArrival getNotice() {
        return notice;
    }


    public void mesg() {
        System.out.println("Sending Message");
        String json = toJSON(this.notice);
        System.out.println(json);
        sendMessage(json);
        System.out.println("Sent Message!");
    }

}
