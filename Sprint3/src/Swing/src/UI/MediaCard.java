package UI;

import core.MediaProfile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import static core.constants.NO_IMAGE_URL;

public class MediaCard extends JPanel {

    MediaCard(MediaProfile info){

        super.setLayout(new GridBagLayout());
        ImageIcon poster=new ImageIcon();
        Image posterI;



        try {
            if(info.getPoster()!=null) {
                posterI = ImageIO.read(new URL(info.getPoster()));
                posterI = posterI.getScaledInstance(189, 280, Image.SCALE_DEFAULT);
                poster = new ImageIcon(posterI);
            }else{
                poster=new ImageIcon(this.getClass().getResource(NO_IMAGE_URL));
{
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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
        delete.setPreferredSize(new Dimension(60,20));

        buttons.add(delete);

        ImageIcon infI=GystUI.createImageIcon("/images/info.png");
        JButton more=new JButton(infI);

        more.setPreferredSize(new Dimension(60,20));

        more.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InfoBox(info);
            }
        });

        buttons.add(more);
        ImageIcon check=GystUI.createImageIcon("/images/check.png");
        JButton done=new JButton(check);


        done.setPreferredSize(new Dimension(60,20));
        buttons.add(done);

        buttons.setPreferredSize(new Dimension(189,30));

        g.gridx=0;
        g.gridwidth=3;
        g.gridy=1;
        g.gridheight=1;

        add(buttons,g);







    }

}
