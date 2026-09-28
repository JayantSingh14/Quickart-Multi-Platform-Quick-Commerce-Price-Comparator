package org.apache.commons.codec;

import android.support.v4.media.b;
import java.io.InputStream;

/* loaded from: classes5.dex */
public class Resources {
    public static InputStream getInputStream(String str) {
        InputStream resourceAsStream = Resources.class.getClassLoader().getResourceAsStream(str);
        if (resourceAsStream != null) {
            return resourceAsStream;
        }
        throw new IllegalArgumentException(b.C("Unable to resolve required resource: ", str));
    }
}
