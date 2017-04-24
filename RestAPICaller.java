import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import jdk.nashorn.internal.parser.JSONParser;
import netscape.javascript.JSObject;
import sun.net.www.http.HttpClient;
import sun.net.www.protocol.http.HttpURLConnection;
import org.json.*;

class RestAPICaller
{
    public static JSONObject httpGetJSON(String url) {
        JSONObject jsonObject = null;
        try{
            //fetch json
            URL urlObj = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) urlObj.openConnection();
            InputStream is = urlConnection.getInputStream();
            int status = urlConnection.getResponseCode();

            if(status != 200) {
                jsonObject = httpGetJSON(url);
                return jsonObject;
            }
            
            //build json
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder out = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }

            jsonObject = new JSONObject(out.toString());
            reader.close();
        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return jsonObject;
    }
}