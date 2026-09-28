package org.apache.xml.security.c14n;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

/* loaded from: classes5.dex */
public abstract class CanonicalizerSpi {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f57125a = false;

    public abstract void a(OutputStream outputStream);

    public abstract byte[] a(Node node);

    public abstract byte[] a(Node node, String str);

    public byte[] a(byte[] bArr) {
        InputSource inputSource = new InputSource(new ByteArrayInputStream(bArr));
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
        return a(documentBuilderFactoryNewInstance.newDocumentBuilder().parse(inputSource));
    }
}
