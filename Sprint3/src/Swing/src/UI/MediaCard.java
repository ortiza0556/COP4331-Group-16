package UI;

import core.MediaProfile;
import core.constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import static core.constants.NO_IMAGE_URL;

public class MediaCard extends JPanel {
	
	public final static int BACKLOG=1;
	public final static int COMPLETE=2;
	public final static int RECOMMENDED=5;
	public CardList parent;

    MediaCard(MediaProfile info){
    	
    	MediaCard local=this;
        super.setLayout(new GridBagLayout());
        ImageIcon poster=new ImageIcon();
        Image posterI;
        
        int status=0;
        int isAt=0;



        try {
            if(info.getPoster()!=null) {
                posterI = ImageIO.read(new URL(info.getPoster()));
                posterI = posterI.getScaledInstance(170, 252, Image.SCALE_DEFAULT);
                poster = new ImageIcon(posterI);

            }
        } catch (IOException e) {
            poster=GystUI.createImageIcon("/images/noPoster.png");
        }
        
        

        JLabel imgLabel=new JLabel(info.getTitle(),poster,JLabel.CENTER);
        imgLabel.setVerticalTextPosition(JLabel.BOTTOM);
        imgLabel.setHorizontalTextPosition(JLabel.CENTER);

        GridBagConstraints g= new GridBagConstraints();
        g.gridx=0;
        g.gridwidth=3;
        g.gridy=0;
        g.gridheight=1;


        add(imgLabel,g);

        JPanel buttons=new JPanel();
        buttons.setLayout(new GridLayout(1,3));

        ImageIcon trash=GystUI.createImageIcon("/images/trash.png");
        JButton delete=new JButton(trash);
        delete.setPreferredSize(new Dimension(50,20));

        
        
        
        buttons.add(delete);
        
        delete.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				parent.removeCard(local);
				//---------------------------------------------------------------------------------------
				//
				//Delete SQL entry
				//
				//---------------------------------------------------------------------------------------
			}
        	
        });
        

        ImageIcon infI=GystUI.createImageIcon("/images/info.png");
        JButton more=new JButton(infI);

        more.setPreferredSize(new Dimension(50,20));

        more.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InfoBox(info);
            }
        });

        buttons.add(more);
        ImageIcon check=GystUI.createImageIcon("/images/check.png");
        JButton done=new JButton(check);

        done.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(isAt==0) {
					parent.page.backlog.addCard(local);
					parent.list.updateUI();
				}
				
				
			}
        	
        }
       );
        done.setPreferredSize(new Dimension(50,20));
        buttons.add(done);

        buttons.setPreferredSize(new Dimension(170,30));

        g.gridx=0;
        g.gridwidth=3;
        g.gridy=1;
        g.gridheight=1;

        add(buttons,g);







    }
    

}
