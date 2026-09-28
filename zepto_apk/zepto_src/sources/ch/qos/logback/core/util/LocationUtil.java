package ch.qos.logback.core.util;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes3.dex */
public class LocationUtil {
    public static URL a(String str) throws MalformedURLException, FileNotFoundException {
        URL url;
        if (str == null) {
            throw new NullPointerException("location is required");
        }
        if (!str.matches("^\\p{Alpha}[\\p{Alnum}+.-]*:.*$")) {
            url = Loader.b(str);
        } else if (str.startsWith("classpath:")) {
            String strSubstring = str.substring(10);
            if (strSubstring.startsWith("/")) {
                strSubstring = strSubstring.substring(1);
            }
            if (strSubstring.length() == 0) {
                throw new MalformedURLException("path is required");
            }
            url = Loader.b(strSubstring);
        } else {
            url = new URL(str);
        }
        if (url != null) {
            return url;
        }
        throw new FileNotFoundException(str);
    }
}
