package org.apache.xml.security.keys.content.x509;

import com.google.android.gms.internal.pal.a;
import java.math.BigInteger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.utils.RFC2253Parser;
import org.apache.xml.security.utils.SignatureElementProxy;

/* loaded from: classes5.dex */
public class XMLX509IssuerSerial extends SignatureElementProxy implements XMLX509DataContent {

    /* renamed from: a, reason: collision with root package name */
    static Log f57194a;

    /* renamed from: b, reason: collision with root package name */
    static Class f57195b;

    static {
        Class clsA = f57195b;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.keys.content.x509.XMLX509IssuerSerial");
            f57195b = clsA;
        }
        f57194a = LogFactory.getLog(clsA.getName());
    }

    public static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    public String b() {
        return RFC2253Parser.a(b("X509IssuerName", "http://www.w3.org/2000/09/xmldsig#"));
    }

    @Override // org.apache.xml.security.utils.ElementProxy
    public String e() {
        return "X509IssuerSerial";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof XMLX509IssuerSerial)) {
            return false;
        }
        XMLX509IssuerSerial xMLX509IssuerSerial = (XMLX509IssuerSerial) obj;
        return a().equals(xMLX509IssuerSerial.a()) && b().equals(xMLX509IssuerSerial.b());
    }

    public int hashCode() {
        return b().hashCode() + ((a().hashCode() + 527) * 31);
    }

    public BigInteger a() {
        String strB = b("X509SerialNumber", "http://www.w3.org/2000/09/xmldsig#");
        if (f57194a.isDebugEnabled()) {
            Log log = f57194a;
            StringBuffer stringBuffer = new StringBuffer("X509SerialNumber text: ");
            stringBuffer.append(strB);
            log.debug(stringBuffer.toString());
        }
        return new BigInteger(strB);
    }
}
