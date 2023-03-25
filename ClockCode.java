package ClockProject;
import javax.swing.*;
import javax.swing.Timer;

import java.util.*;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

public class ClockCode extends JFrame
{
    private JLabel heading;
    private JLabel clockLabel;
    private Font font = new Font("",Font.BOLD,35);
    

    ClockCode()
    {
        super.setTitle("My Clock...");
        super.setSize(500,400);
        super.setLocation(300,50);
        this.createGUI();
        this.startClock();
        super.setVisible(true);
    }   


    public void createGUI()
    {
        heading = new JLabel("Clock Create By Simesh");
        clockLabel = new JLabel("clock");

        heading.setFont(font);
        clockLabel.setFont(font);

        this.setLayout(new GridLayout(2,1));
        this.add(heading);
        this.add(clockLabel);


    }
    public void startClock()
    {
/*     Timer timer = new Timer(1000, new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //String dateTime = new Date().toString();
                //String dateTime = new Date().toLocalString();
                Date d = new Date();
                SimpleDateFormat sfd = new SimpleDateFormat("hh : mm : ss a");
                String dateTime = sfd.format(d);
                clockLabel.setText(dateTime);
            }
        });

        timer.start();
*/
        Thread t = new Thread()
        {
            public void run()
            {
                try
                {
                    while(true)
                    {
                        Date d= new Date();
                        SimpleDateFormat sfd = new SimpleDateFormat(" hh : mm : ss a");
                        String dateTime = sfd.format(d);
                        clockLabel.setText(dateTime);
                        Thread.sleep(1000);
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        };
        t.start();

    }
}
