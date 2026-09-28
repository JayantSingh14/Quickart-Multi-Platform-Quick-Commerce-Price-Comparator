package org.apache.xml.security.transforms.implementations;

import org.apache.xml.security.signature.NodeFilter;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;
import org.apache.xml.security.transforms.TransformationException;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public class TransformEnvelopedSignature extends TransformSpi {

    public static class EnvelopedNodeFilter implements NodeFilter {

        /* renamed from: a, reason: collision with root package name */
        Node f57293a;

        public EnvelopedNodeFilter(Node node) {
            this.f57293a = node;
        }

        @Override // org.apache.xml.security.signature.NodeFilter
        public int a(Node node) {
            Node node2 = this.f57293a;
            return (node == node2 || XMLUtils.a(node2, node)) ? -1 : 1;
        }

        @Override // org.apache.xml.security.signature.NodeFilter
        public int a(Node node, int i2) {
            return node == this.f57293a ? -1 : 1;
        }
    }

    @Override // org.apache.xml.security.transforms.TransformSpi
    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, Transform transform) throws TransformationException {
        Node nodeA = a(transform.k());
        xMLSignatureInput.a(nodeA);
        xMLSignatureInput.a(new EnvelopedNodeFilter(nodeA));
        return xMLSignatureInput;
    }

    private static Node a(Node node) throws TransformationException {
        while (node != null && node.getNodeType() != 9) {
            Element element = (Element) node;
            if (element.getNamespaceURI().equals("http://www.w3.org/2000/09/xmldsig#") && element.getLocalName().equals("Signature")) {
                return node;
            }
            node = node.getParentNode();
        }
        throw new TransformationException("transform.envelopedSignatureTransformNotInSignatureElement");
    }
}
