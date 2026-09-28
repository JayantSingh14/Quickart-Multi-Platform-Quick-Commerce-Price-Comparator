package org.apache.xml.security.algorithms;

import java.security.Key;
import org.w3c.dom.Element;

/* loaded from: classes5.dex */
public abstract class SignatureAlgorithmSpi {
    public abstract String a();

    public abstract void a(byte b2);

    public abstract void a(Key key);

    public void a(Element element) {
    }

    public abstract void a(byte[] bArr);

    public abstract void a(byte[] bArr, int i2, int i3);

    public abstract String b();

    public abstract boolean b(byte[] bArr);

    public void c() {
    }
}
