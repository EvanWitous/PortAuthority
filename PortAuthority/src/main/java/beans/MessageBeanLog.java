package beans;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MessageBeanLog implements MessageListener {

    public MessageBeanLog() {}
    @Override
    public void onMessage(Message msg) {
        if(msg instanceof TextMessage) {
            TextMessage tm = (TextMessage) msg;
            String text = null;
            try {
                text = tm.getText();
                System.out.println("Message recieved: " + text);
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }
    }
}
