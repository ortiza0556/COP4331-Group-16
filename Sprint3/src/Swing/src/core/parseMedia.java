package core;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

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
}
