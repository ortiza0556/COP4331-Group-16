package UI;

import core.MediaProfile;

import javax.swing.*;

public class InfoBox extends JPanel {


    public InfoBox(MediaProfile media){



        JOptionPane.showMessageDialog(this.getParent(),"Title: " +media.getTitle()+
                "\n\n" +"Year: "+media.getYear()+
                "\n\n" +"Rated: "+media.getRated()+
                "\n\n" +"Released: "+media.getReleased()+
                "\n\n" +"Genre(s): "+media.getGenre()+
                "\n\n" +"Director(s): "+media.getDirector()+
                "\n\n" +"Writer(s): "+media.getWriter()+
                "\n\n" +"Actors: "+media.getActors()+
                "\n\n" +"Plot: "+media.getPlot()+
                "\n\n" +"Language: "+media.getLanguage()+
                "\n\n" +"Country: "+media.getCountry()+
                "\n\n" +"Awards: "+media.getAwards()+
                "\n\n" +"MetaScore: "+media.getMetascore()+
                "\n\n" +"IMDB Rating: "+media.getImdbRating()+
                "\n\n" +"IMDB ID: "+media.getImdbID()+
                "\n\n" +"Type: "+media.getType()+
                "\n\n" +"DVD Release: "+media.getDVD()+
                "\n\n" +"Box Office: "+media.getBoxOffice()+
                "\n\n" +"Production Company: "+media.getProduction()+
                "\n\n");
    }


}
