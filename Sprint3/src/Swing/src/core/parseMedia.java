package core;

import UI.MediaCard;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

public class parseMedia {

    public parseMedia(){}

    static String key=constants.KEY;


        URL surl;
    public MediaProfile parse(String[] args) {

        String str=new String();
        for(int i=0;i<args.length;i++){
            str=str.concat(args[i]+"&");
        }


            try {
                surl = new URL("http://www.omdbapi.com/?"+str + key);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }



        InputStream input=new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };

        {
            try {
                input = surl.openStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        MediaProfile output=new MediaProfile();

        {
            try {
                output = new Gson().fromJson(new InputStreamReader(input, "UTF-8"), MediaProfile.class);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return output;
    }
    public MediaProfile[] search(String t){
        try{
            surl=new URL("http://www.omdbapi.com/?s="+t+key);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStream input=new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };

        {
            try {
                input = surl.openStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Results results=new Results();
        
        try {
            results= new Gson().fromJson(new InputStreamReader(input,"UTF-8"),Results.class);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if(results.Search==null) {
        	JOptionPane.showMessageDialog(null,"No results found. If needed omit article adjectives(of/the/etc.)");
        	return null;}
        MediaProfile[] output= new MediaProfile[results.Search.size()];
        for(int i=0;i<results.Search.size();i++){
            MediaProfile temp= new MediaProfile();
            temp= new Gson().fromJson(results.Search.get(i),MediaProfile.class);
            output[i]=temp;

        }




        return output;

    }
}
