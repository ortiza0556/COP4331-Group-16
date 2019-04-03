package UI;

import core.parseMedia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaPage extends JPanel{

    CardList backlog;

    CardList reccomended;

    CardList completed;

    JScrollPane pane;


    public void populate(){

        JPanel lists=new JPanel();



        lists.setLayout(new GridLayout(3,1));


        lists.add(backlog);
        lists.add(reccomended);
        lists.add(completed);

        pane = new JScrollPane(lists,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pane.setPreferredSize(new Dimension(950,1080));
        pane.setWheelScrollingEnabled(false);

        JPanel addmed=new JPanel();

        addmed.setLayout(new GridLayout(2,1));

        JTextArea search=new JTextArea();

        addmed.add(search);

        JButton addB=new JButton("ADD Media");
        addB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[]args=new String[1];
                args[0]=search.getText();
                backlog.addCard(new MediaCard(new parseMedia().parse(args)));
            }
        });
        addmed.add(addB);
        add(addmed);

        add(pane);




        }



}

