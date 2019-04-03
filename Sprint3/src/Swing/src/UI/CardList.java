package UI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CardList extends JPanel{
    JPanel list;
    protected JScrollPane pane;

    CardList(){
        list=new JPanel(new FlowLayout());

        pane= new JScrollPane(list);
        pane.setPreferredSize(new Dimension(800,350));
        pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        pane.setWheelScrollingEnabled(true);
        pane.getHorizontalScrollBar().setUnitIncrement(50);

        //hide scrollbar
        pane.getHorizontalScrollBar().setPreferredSize(new Dimension(0,0));

        ImageIcon leftIcon=GetYourShitTogether.createImageIcon("/images/left.png");
        JButton left = new JButton(leftIcon);
        left.setPreferredSize(new Dimension(50,350));
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pane.getHorizontalScrollBar().setValue(pane.getHorizontalScrollBar().getValue()-800);
            }
        });


        ImageIcon rightIcon=GetYourShitTogether.createImageIcon("/images/right.png");
        JButton right= new JButton(rightIcon);
        right.setPreferredSize(new Dimension(50,350));
        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pane.getHorizontalScrollBar().setValue(pane.getHorizontalScrollBar().getValue()+800);
            }
        });

                add(left);
                add(pane);
                add(right);


    }

    public void addCard(MediaCard card){
        list.add(card);
        pane.updateUI();
    }




}
