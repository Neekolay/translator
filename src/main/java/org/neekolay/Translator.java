package org.neekolay;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

class Translator {

    private static final String USER_AGENT = "Mozilla/5.0";

    private static final String PATH = "https://translate.yandex.net/api/v1.5/tr.json/translate";

    static String translate(String text) {

        String result = null;

        Params params = new Params(text);

        try {
            URL url = new URL(PATH + params.toEncodeString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("User-Agent", USER_AGENT);
            connection.setRequestProperty("Accept-Charset", "UTF-8");

            Reader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            result = getFormattedString(in);

            connection.disconnect();

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static String getFormattedString(Reader in) throws IOException, JSONException {
        StringBuilder sb = new StringBuilder();
        for (int c; (c = in.read()) >= 0; )
            sb.append((char) c);

        String response = sb.toString();
        JSONObject jsonObject = new JSONObject(response);
        return jsonObject.getString("text")
                .trim()
                .replace("\"", "")
                .replace("[", "")
                .replace("]", "");
    }

}
