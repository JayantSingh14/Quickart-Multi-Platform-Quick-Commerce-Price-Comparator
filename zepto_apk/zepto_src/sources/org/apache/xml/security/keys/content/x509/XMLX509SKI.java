package org.apache.xml.security.keys.content.x509;

import com.google.android.gms.internal.pal.a;
import java.util.Arrays;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.utils.SignatureElementProxy;

/* loaded from: classes5.dex */
public class XMLX509SKI extends SignatureElementProxy implements XMLX509DataContent {

    /* renamed from: a, reason: collision with root package name */
    static Log f57196a;

    /* renamed from: b, reason: collision with root package name */
    static Class f57197b;

    static {
        Class clsA = f57197b;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.keys.content.x509.XMLX509SKI");
            f57197b = clsA;
        }
        f57196a = LogFactory.getLog(clsA.getName());
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
        return "X509SKI";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof XMLX509SKI)) {
            return false;
        }
        try {
            return Arrays.equals(((XMLX509SKI) obj).a(), a());
        } catch (XMLSecurityException unused) {
            return false;
        }
    }

    public int hashCode() {
        int i2 = 17;
        try {
            for (byte b2 : a()) {
                i2 = b2 + (i2 * 31);
            }
        } catch (XMLSecurityException unused) {
        }
        return i2;
    }

    public byte[] a() {
        return n();
    }
}
