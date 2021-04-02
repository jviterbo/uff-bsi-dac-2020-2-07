/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author viter
 */
@JMSDestinationDefinition(name = "java:app/helloQueue", interfaceName = "javax.jms.Queue", resourceAdapter = "jmsra", destinationName = "helloQueue")
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:app/helloQueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class HelloMessageBean implements MessageListener {

    public HelloMessageBean() {
    }

    @EJB
    RegistryBean reg;

    TextMessage tmsg;

    @Override
    public void onMessage(Message message) {
        try {
            tmsg = (TextMessage) message;
            String msg = tmsg.getText();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            reg.saveMsgs(timestamp + ": " + msg);
 
            System.out.println(msg);

        } catch (JMSException ex) {

            Logger.getLogger(HelloMessageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
