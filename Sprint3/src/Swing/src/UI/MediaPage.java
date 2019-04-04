package UI;

import core.parseMedia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import UI.GystUI;
public class MediaPage extends JPanel{

     public CardList backlog;
    
     public CardList reccomended;

     public CardList completed;

    JScrollPane pane;


    public void populate(){

        JPanel lists=new JPanel();



        lists.setLayout(new GridBagLayout());

        GridBagConstraints c=new GridBagConstraints();
        
        c.weighty=0;
        c.gridy=0;
        lists.add(new JLabel("Backlog"),c);
        c.gridy=1;
        lists.add(backlog,c);
        c.gridy=2;
        lists.add(new JLabel("Recommended"),c);
        c.gridy=3;
        lists.add(reccomended,c);
        c.gridy=4;
        lists.add(new JLabel("Finished"),c);
        c.gridy=5;
        lists.add(completed,c);
        
        backlog.page=this;
        reccomended.page=this;
        completed.page=this;

        pane = new JScrollPane(lists,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pane.setPreferredSize(new Dimension(950,1000));
        pane.setWheelScrollingEnabled(false);


        MediaPage t=this;
        JButton addB=new JButton(" ",GystUI.createImageIcon("/images/add.png"));
        addB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	new AddUI(t);
            }
        });
        addB.setPreferredSize(new Dimension(100,1080));
        add(addB);

        add(pane);




        }



}

