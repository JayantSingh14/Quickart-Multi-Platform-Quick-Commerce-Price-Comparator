package ch.qos.logback.classic.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/* loaded from: classes3.dex */
public class JNDIUtil {
    public static Context a() {
        return new InitialContext();
    }

    public static String b(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            Object objLookup = context.lookup(str);
            if (objLookup == null) {
                return null;
            }
            return objLookup.toString();
        } catch (NamingException unused) {
            return null;
        }
    }
}
