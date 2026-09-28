package org.apache.xml.security.transforms.implementations;

import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;
import org.apache.xml.security.transforms.TransformationException;

/* loaded from: classes5.dex */
public class TransformXPointer extends TransformSpi {
    @Override // org.apache.xml.security.transforms.TransformSpi
    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, Transform transform) throws TransformationException {
        throw new TransformationException("signature.Transform.NotYetImplemented", new Object[]{"http://www.w3.org/TR/2001/WD-xptr-20010108"});
    }
}
