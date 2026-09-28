package org.apache.xml.security.transforms.implementations;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.xml.security.exceptions.Base64DecodingException;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;
import org.apache.xml.security.transforms.TransformationException;
import org.apache.xml.security.utils.Base64;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
public class TransformBase64Decode extends TransformSpi {
    @Override // org.apache.xml.security.transforms.TransformSpi
    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, OutputStream outputStream, Transform transform) throws TransformationException, IOException {
        XMLSignatureInput xMLSignatureInput2;
        try {
            if (xMLSignatureInput.g()) {
                Node nodeM = xMLSignatureInput.m();
                if (xMLSignatureInput.m().getNodeType() == 3) {
                    nodeM = nodeM.getParentNode();
                }
                StringBuffer stringBuffer = new StringBuffer();
                a((Element) nodeM, stringBuffer);
                if (outputStream == null) {
                    return new XMLSignatureInput(Base64.a(stringBuffer.toString()));
                }
                Base64.a(stringBuffer.toString(), outputStream);
                xMLSignatureInput2 = new XMLSignatureInput((byte[]) null);
            } else {
                if (!xMLSignatureInput.h() && !xMLSignatureInput.f()) {
                    try {
                        try {
                            Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xMLSignatureInput.c()).getDocumentElement();
                            StringBuffer stringBuffer2 = new StringBuffer();
                            a(documentElement, stringBuffer2);
                            return new XMLSignatureInput(Base64.a(stringBuffer2.toString()));
                        } catch (ParserConfigurationException e2) {
                            throw new TransformationException("c14n.Canonicalizer.Exception", e2);
                        }
                    } catch (SAXException e3) {
                        throw new TransformationException("SAX exception", e3);
                    }
                }
                if (outputStream == null) {
                    return new XMLSignatureInput(Base64.a(xMLSignatureInput.e()));
                }
                if (xMLSignatureInput.j() || xMLSignatureInput.f()) {
                    Base64.a(xMLSignatureInput.e(), outputStream);
                } else {
                    Base64.a(new BufferedInputStream(xMLSignatureInput.d()), outputStream);
                }
                xMLSignatureInput2 = new XMLSignatureInput((byte[]) null);
            }
            xMLSignatureInput2.b(outputStream);
            return xMLSignatureInput2;
        } catch (Base64DecodingException e4) {
            throw new TransformationException("Base64Decoding", e4);
        }
    }

    @Override // org.apache.xml.security.transforms.TransformSpi
    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, Transform transform) {
        return a(xMLSignatureInput, null, transform);
    }

    public void a(Element element, StringBuffer stringBuffer) {
        for (Node firstChild = element.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            short nodeType = firstChild.getNodeType();
            if (nodeType == 1) {
                a((Element) firstChild, stringBuffer);
            } else if (nodeType == 3) {
                stringBuffer.append(((Text) firstChild).getData());
            }
        }
    }
}
