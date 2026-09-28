package org.apache.xml.security.keys.content.x509;

import java.util.Arrays;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.utils.SignatureElementProxy;

/* loaded from: classes5.dex */
public class XMLX509Certificate extends SignatureElementProxy implements XMLX509DataContent {
    public byte[] a() {
        return n();
    }

    @Override // org.apache.xml.security.utils.ElementProxy
    public String e() {
        return "X509Certificate";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof XMLX509Certificate)) {
            return false;
        }
        try {
            return Arrays.equals(((XMLX509Certificate) obj).a(), a());
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
}
