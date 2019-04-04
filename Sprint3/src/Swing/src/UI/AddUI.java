package UI;

import core.MediaProfile;
import core.parseMedia;

import javax.swing.*;
import java.awt.*;

public class AddUI extends JPanel {

    public AddUI(MediaPage top)

    {
        String s = (String) JOptionPane.showInputDialog(this.getParent(), "Enter a title to search.\n Do not use article adjectives \n(the/and/of/etc)", JOptionPane.PLAIN_MESSAGE);


        if ( s!=null&&s.length() > 0 ) {

            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ' ') chars[i] = '+';
            }
            MediaProfile[] results=new parseMedia().search(new String(chars));
            
            if(results==null)return;

            JDialog picker=new JDialog();

            CardList cards= new CardList(results,CardList.SEARCH_RESULT);
            
            cards.page=top;

            JPanel box= new JPanel();
            box.setLayout(new FlowLayout());

            box.add(cards);

            picker.add(box);

            picker.setModal(true);

            picker.setPreferredSize(new Dimension(1000, 500));//set your desired size
            picker.pack();
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screenSize = toolkit.getScreenSize();

            picker.setVisible(true);


            picker.setBounds(0,0,800,400);

        }

    }
}
