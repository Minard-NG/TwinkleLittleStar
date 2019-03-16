/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twinkle;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.*;
/**
 *
 * @author Xquisite Genius
 */
public class AppWindow extends JFrame{
    
    private JPanel toppan,midpan,endpan;
    private JLabel titlelab,line0,line1,line2,line3,line4;
    private JRadioButton rb1,rb2,rb3,rb4,rb5;
    private ButtonGroup rbs;
    
    String a = "en";
    String b = "EN";
    
    
    String title = "Twinkle Twinkle Little Star";
    Locale l;
    ResourceBundle message;
    
    public AppWindow(){
        super("Twinkle App");
        setLayout(new BorderLayout());
        
        toppan = new JPanel();
        toppan.setLayout(new FlowLayout());
        add(toppan,BorderLayout.NORTH);
        
        titlelab = new JLabel(title);
        titlelab.setFont(new Font("Algerian",Font.BOLD,18));
        toppan.add(titlelab);
        
        GridBagLayout lay = new GridBagLayout();
        GridBagConstraints gc = new GridBagConstraints();
        
        midpan = new JPanel();
        midpan.setLayout(lay);
        add(midpan,BorderLayout.CENTER);
        
        line0 = new JLabel("English");
        line0.setFont(new Font("Serif",17,15));
        gc.gridx = 0;
        gc.gridy = 0;
        midpan.add(line0,gc);
        
        line1 = new JLabel("Twinkle, twinkle, little star,");
        line1.setFont(new Font("Serif",17,15));
        gc.gridx = 0;
        gc.gridy = 2;
        midpan.add(line1,gc);
        
        line2 = new JLabel("How we wonder what you are.");
        line2.setFont(new Font("Serif",17,15));
        gc.gridx = 0;
        gc.gridy++;
        midpan.add(line2,gc);
        
        line3 = new JLabel("Up above the world so high,");
        line3.setFont(new Font("Serif",17,15));
        gc.gridx = 0;
        gc.gridy++;
        midpan.add(line3,gc);
        
        line4 = new JLabel("Like a diamond in the sky.");
        line4.setFont(new Font("Serif",17,15));
        gc.gridx = 0;
        gc.gridy++;
        midpan.add(line4,gc);
        
        endpan = new JPanel();
        endpan.setLayout(new FlowLayout());
        add(endpan,BorderLayout.SOUTH);
        
        rb1 = new JRadioButton("English",true);
        endpan.add(rb1);
        
        rb2 = new JRadioButton("German",false);
        endpan.add(rb2);
        
        rb3 = new JRadioButton("French",false);
        endpan.add(rb3);
        
        rb4 = new JRadioButton("Arabic",false);
        endpan.add(rb4);
        
         rb5 = new JRadioButton("Chinese",false);
        endpan.add(rb5);
        
        //add radiobuttons to buttongroup
        
        rbs = new ButtonGroup();
        rbs.add(rb1);
        rbs.add(rb2);
        rbs.add(rb3);
        rbs.add(rb4);
        rbs.add(rb5);
        
        //create object of innerclass
        ItemHandler handler = new ItemHandler();
        
        rb1.addItemListener(handler);
        rb2.addItemListener(handler);
        rb3.addItemListener(handler);
        rb4.addItemListener(handler);
        rb5.addItemListener(handler);
    
    }
    
    class ItemHandler implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            
            if(rb1.isSelected()){
            
                a = "en";
                b = "EN";
             
            }else if(rb2.isSelected()){
                a = "de";
                b = "DE";
            }else if(rb3.isSelected()){
                a = "fr";
                b = "FR";
            }else if(rb4.isSelected()){
                a = "ar";
                b = "AR";
            }else if(rb5.isSelected()){
                a = "zh";
                b = "ZH";
            }
            
         l = new Locale(a,b);
         message = ResourceBundle.getBundle("MessagesBundle", l);
         line0.setText(message.getString("Line0"));
         line1.setText(message.getString("Line1"));
         line2.setText(message.getString("Line2"));
         line3.setText(message.getString("Line3"));
         line4.setText(message.getString("Line4"));
        }
    
    }
    public static void main(String[]args){
            
                AppWindow obj = new AppWindow();
                
                obj.setSize(400, 300);
                obj.setVisible(true);
                obj.setLocationRelativeTo(null);
                obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        
    }
}
