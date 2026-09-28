package org.apache.xml.security.transforms;

import java.io.OutputStream;
import org.apache.xml.security.signature.XMLSignatureInput;

/* loaded from: classes5.dex */
public abstract class TransformSpi {

    /* renamed from: a, reason: collision with root package name */
    protected Transform f57289a = null;

    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput) {
        throw new UnsupportedOperationException();
    }

    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, OutputStream outputStream, Transform transform) {
        return a(xMLSignatureInput, transform);
    }

    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, Transform transform) throws TransformationException {
        try {
            TransformSpi transformSpi = (TransformSpi) getClass().newInstance();
            transformSpi.a(transform);
            return transformSpi.a(xMLSignatureInput);
        } catch (IllegalAccessException e2) {
            throw new TransformationException("", e2);
        } catch (InstantiationException e3) {
            throw new TransformationException("", e3);
        }
    }

    public void a(Transform transform) {
        this.f57289a = transform;
    }
}
