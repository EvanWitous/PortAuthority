package beans;

import org.primefaces.json.JSONObject;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.Set;

@MessageDriven(mappedName="jms/myLog" )

public class PortAuthority implements MessageListener {
    @Override
    public void onMessage(Message msg) {
        if(msg instanceof TextMessage) {
            TextMessage tm = (TextMessage) msg;
            String text;
            try {
                text = tm.getText();
                JSONObject json = new JSONObject(text);
                Set<String> keys = json.keySet();
                NoticeOfArrival NOA = new NoticeOfArrival();
                NOA.setName(json.getString("name"));
                NOA.setMmsi(json.getInt("mmsi"));
                NOA.setClient(json.getInt("client"));
                System.out.println("PA: My name is " + NOA.getName());
                BoatManagementFacadeBean.add(NOA);
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }
    }

}
