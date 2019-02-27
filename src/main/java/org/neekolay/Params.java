package org.neekolay;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class Params {

    private static final String API_KEY = "trnsl.1.1.20190225T202800Z.d137ffda379670ce.ea148c362d7b114b32ffd1540b4fabdeffa1ea47";
    private static final String LANG = "en-ru";

    private String lang;

    private String key;

    private String text;

    Params(String text) {
        setLang(LANG);
        setKey(API_KEY);
        this.text = text;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setText(String text) {
        this.text = text;
    }


    String toEncodeString() throws UnsupportedEncodingException {
            return "?key=" + API_KEY +
                    "&lang=" + lang +
                    "&text=" + URLEncoder.encode(text, "UTF-8");

    }
}
