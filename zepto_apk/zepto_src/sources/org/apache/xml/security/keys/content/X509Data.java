package org.apache.xml.security.keys.content;

import com.google.android.gms.internal.pal.a;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.utils.SignatureElementProxy;

/* loaded from: classes5.dex */
public class X509Data extends SignatureElementProxy implements KeyInfoContent {

    /* renamed from: a, reason: collision with root package name */
    static Log f57192a;

    /* renamed from: b, reason: collision with root package name */
    static Class f57193b;

    static {
        Class clsA = f57193b;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.keys.content.X509Data");
            f57193b = clsA;
        }
        f57192a = LogFactory.getLog(clsA.getName());
    }

    public static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    @Override // org.apache.xml.security.utils.ElementProxy
    public String e() {
        return "X509Data";
    }
}
