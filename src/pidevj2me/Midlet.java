/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevj2me;

import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

/**
 * @author maroo
 */
public class Midlet extends MIDlet implements CommandListener {

    Display disp = Display.getDisplay(this);
    Form f1 = new Form("Authentification");
    TextField tfUsername = new TextField("UserName", null, 15, TextField.ANY);
    TextField tfPassword = new TextField("Mot de passe", null, 20, TextField.PASSWORD);
    Command cmdValider = new Command("Valider", Command.OK, 0);
    Command cmdBack = new Command("Back", Command.BACK, 0);
   Form f2 = new Form("Welcome");
    Form f3 = new Form("Erreur");
     //Connexion
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/j2me/login.php";
    StringBuffer sb = new StringBuffer();
    int ch;
    public void startApp() {
         f1.append(tfUsername);
        f1.append(tfPassword);
       f1.addCommand(cmdValider);
       f1.setCommandListener(this);
       f1.addCommand(cmdBack);
       f1.setCommandListener(this);
       disp.setCurrent(f1);

    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if (c==cmdValider){
            
           try {
                hc = (HttpConnection) Connector.open(url+"?username="+tfUsername.getString().trim()+"&password="+tfPassword.getString().trim());
                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char)ch);
                }
                if ("ArrayOK".equals(sb.toString().trim())) {
                    disp.setCurrent(f2);
                }else{
                    disp.setCurrent(f3);
                }
                sb = new StringBuffer();
           }
           catch(IOException e){
               e.printStackTrace();
           }
        }
        if (c == cmdBack) {
            
            disp.setCurrent(f1);
        }
        
    }

}
