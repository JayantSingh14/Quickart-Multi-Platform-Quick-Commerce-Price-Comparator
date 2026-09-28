package org.apache.xml.security.transforms.implementations;

import javax.xml.transform.TransformerException;
import org.apache.xml.security.exceptions.XMLSecurityRuntimeException;
import org.apache.xml.security.signature.NodeFilter;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;
import org.apache.xml.security.transforms.TransformationException;
import org.apache.xml.security.utils.CachedXPathAPIHolder;
import org.apache.xml.security.utils.CachedXPathFuncHereAPI;
import org.apache.xml.security.utils.XMLUtils;
import org.apache.xml.utils.PrefixResolver;
import org.apache.xml.utils.PrefixResolverDefault;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public class TransformXPath extends TransformSpi {

    public static class XPathNodeFilter implements NodeFilter {

        /* renamed from: a, reason: collision with root package name */
        PrefixResolverDefault f57294a;

        /* renamed from: b, reason: collision with root package name */
        CachedXPathFuncHereAPI f57295b = new CachedXPathFuncHereAPI(CachedXPathAPIHolder.a());

        /* renamed from: c, reason: collision with root package name */
        Node f57296c;

        /* renamed from: d, reason: collision with root package name */
        String f57297d;

        public XPathNodeFilter(Element element, Node node, String str) {
            this.f57296c = node;
            this.f57297d = str;
            this.f57294a = new PrefixResolverDefault(element);
        }

        @Override // org.apache.xml.security.signature.NodeFilter
        public int a(Node node) {
            try {
                return this.f57295b.a(node, this.f57296c, this.f57297d, (PrefixResolver) this.f57294a).bool() ? 1 : 0;
            } catch (TransformerException e2) {
                throw new XMLSecurityRuntimeException("signature.Transform.node", new Object[]{node}, e2);
            } catch (Exception e3) {
                throw new XMLSecurityRuntimeException("signature.Transform.nodeAndType", new Object[]{node, new Short(node.getNodeType())}, e3);
            }
        }

        @Override // org.apache.xml.security.signature.NodeFilter
        public int a(Node node, int i2) {
            return a(node);
        }
    }

    @Override // org.apache.xml.security.transforms.TransformSpi
    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, Transform transform) throws TransformationException {
        try {
            CachedXPathAPIHolder.a(transform.k().getOwnerDocument());
            Element elementA = XMLUtils.a(transform.k().getFirstChild(), "XPath", 0);
            if (elementA == null) {
                throw new TransformationException("xml.WrongContent", new Object[]{"ds:XPath", "Transform"});
            }
            Node nodeItem = elementA.getChildNodes().item(0);
            String strA = CachedXPathFuncHereAPI.a(nodeItem);
            xMLSignatureInput.a(a(strA));
            if (nodeItem == null) {
                throw new DOMException((short) 3, "Text must be in ds:Xpath");
            }
            xMLSignatureInput.a(new XPathNodeFilter(elementA, nodeItem, strA));
            xMLSignatureInput.d(true);
            return xMLSignatureInput;
        } catch (DOMException e2) {
            throw new TransformationException("empty", e2);
        }
    }

    private boolean a(String str) {
        return (str.indexOf("namespace") == -1 && str.indexOf("name()") == -1) ? false : true;
    }
}
