package org.apache.xml.security.encryption;

import com.google.android.gms.internal.pal.a;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes5.dex */
public class XMLCipherInput {

    /* renamed from: a, reason: collision with root package name */
    static Class f57178a;

    /* renamed from: b, reason: collision with root package name */
    private static Log f57179b;

    static {
        Class clsA = f57178a;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.encryption.XMLCipher");
            f57178a = clsA;
        }
        f57179b = LogFactory.getLog(clsA.getName());
    }

    public static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }
}
