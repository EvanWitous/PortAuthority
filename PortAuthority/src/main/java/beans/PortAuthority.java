package beans;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName="jms/myLog" )
public class PortAuthority implements MessageListener {
    @Override
    public void onMessage(Message message) {

    }
}
