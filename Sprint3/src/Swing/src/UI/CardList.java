package UI;


import core.MediaProfile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CardList extends JPanel{
	
	public static final int SEARCH_RESULT=0;
	public static final int BACKLOG=1;
	public static final int RECOMMENDED=5;
	public static final int COMPLETE=2;
	
	
	public MediaPage page;
	
    JPanel list;
    protected JScrollPane pane;

    public CardList(){
        list=new JPanel(new FlowLayout());

        pane= new JScrollPane(list);
        pane.setPreferredSize(new Dimension(800,300));
        pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        pane.setWheelScrollingEnabled(true);
        pane.getHorizontalScrollBar().setUnitIncrement(50);

        //hide scrollbar
        pane.getHorizontalScrollBar().setPreferredSize(new Dimension(0,0));

        ImageIcon leftIcon=GystUI.createImageIcon("/images/left.png");
        JButton left = new JButton(leftIcon);
        left.setPreferredSize(new Dimension(50,300));
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pane.getHorizontalScrollBar().setValue(pane.getHorizontalScrollBar().getValue()-800);
            }
        });


        ImageIcon rightIcon=GystUI.createImageIcon("/images/right.png");
        JButton right= new JButton(rightIcon);
        right.setPreferredSize(new Dimension(50,300));
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


    public CardList(MediaProfile[] profiles,int isAt){
        list=new JPanel(new FlowLayout());

        pane= new JScrollPane(list);
        pane.setPreferredSize(new Dimension(800,310));
        pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        pane.setWheelScrollingEnabled(true);
        pane.getHorizontalScrollBar().setUnitIncrement(50);

        //hide scrollbar
        pane.getHorizontalScrollBar().setPreferredSize(new Dimension(0,0));

        ImageIcon leftIcon=GystUI.createImageIcon("/images/left.png");
        JButton left = new JButton(leftIcon);
        left.setPreferredSize(new Dimension(50,310));
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pane.getHorizontalScrollBar().setValue(pane.getHorizontalScrollBar().getValue()-400);
            }
        });


        ImageIcon rightIcon=GystUI.createImageIcon("/images/right.png");
        JButton right= new JButton(rightIcon);
        right.setPreferredSize(new Dimension(50,310));
        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pane.getHorizontalScrollBar().setValue(pane.getHorizontalScrollBar().getValue()+400);
            }
        });

        add(left);
        add(pane);
        add(right);
        if(profiles!=null)
        for(int i=0;i<profiles.length;i++){
            addCard(new MediaCard(profiles[i]));
        }


    }

    public void addCard(MediaCard card){
        //--------------------------------------------------------
    	//
    	//add SQL entry
    	//
    	//--------------------------------------------------------
    	list.add(card);
        card.parent=this;
        pane.updateUI();
    }
    public void removeCard(MediaCard card) {
    	list.remove(card);
    	pane.updateUI();
    }




}
