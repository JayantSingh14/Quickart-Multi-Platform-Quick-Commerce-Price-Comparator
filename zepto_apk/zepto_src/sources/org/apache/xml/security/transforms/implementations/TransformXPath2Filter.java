package org.apache.xml.security.transforms.implementations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.InvalidCanonicalizerException;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;
import org.apache.xml.security.transforms.TransformationException;
import org.apache.xml.security.transforms.params.XPath2FilterContainer;
import org.apache.xml.security.utils.CachedXPathAPIHolder;
import org.apache.xml.security.utils.CachedXPathFuncHereAPI;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
public class TransformXPath2Filter extends TransformSpi {
    public static Set a(List list) {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < list.size(); i2++) {
            NodeList nodeList = (NodeList) list.get(i2);
            int length = nodeList.getLength();
            for (int i3 = 0; i3 < length; i3++) {
                hashSet.add(nodeList.item(i3));
            }
        }
        return hashSet;
    }

    @Override // org.apache.xml.security.transforms.TransformSpi
    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, Transform transform) throws TransformationException {
        CachedXPathAPIHolder.a(transform.k().getOwnerDocument());
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            CachedXPathFuncHereAPI cachedXPathFuncHereAPI = new CachedXPathFuncHereAPI(CachedXPathAPIHolder.a());
            int length = XMLUtils.a(transform.k().getFirstChild(), "http://www.w3.org/2002/06/xmldsig-filter2", "XPath").length;
            if (length == 0) {
                throw new TransformationException("xml.WrongContent", new Object[]{"http://www.w3.org/2002/06/xmldsig-filter2", "XPath"});
            }
            Document documentB = xMLSignatureInput.m() != null ? XMLUtils.b(xMLSignatureInput.m()) : XMLUtils.a(xMLSignatureInput.b());
            for (int i2 = 0; i2 < length; i2++) {
                XPath2FilterContainer xPath2FilterContainerA = XPath2FilterContainer.a(XMLUtils.a(transform.k().getFirstChild(), "http://www.w3.org/2002/06/xmldsig-filter2", "XPath", i2), xMLSignatureInput.k());
                NodeList nodeListA = cachedXPathFuncHereAPI.a(documentB, xPath2FilterContainerA.f(), CachedXPathFuncHereAPI.a(xPath2FilterContainerA.f()), xPath2FilterContainerA.k());
                if (xPath2FilterContainerA.a()) {
                    arrayList3.add(nodeListA);
                } else if (xPath2FilterContainerA.b()) {
                    arrayList2.add(nodeListA);
                } else if (xPath2FilterContainerA.c()) {
                    arrayList.add(nodeListA);
                }
            }
            xMLSignatureInput.a(new XPath2NodeFilter(a(arrayList), a(arrayList2), a(arrayList3)));
            xMLSignatureInput.d(true);
            return xMLSignatureInput;
        } catch (IOException e2) {
            throw new TransformationException("empty", e2);
        } catch (ParserConfigurationException e3) {
            throw new TransformationException("empty", e3);
        } catch (TransformerException e4) {
            throw new TransformationException("empty", e4);
        } catch (CanonicalizationException e5) {
            throw new TransformationException("empty", e5);
        } catch (InvalidCanonicalizerException e6) {
            throw new TransformationException("empty", e6);
        } catch (XMLSecurityException e7) {
            throw new TransformationException("empty", e7);
        } catch (DOMException e8) {
            throw new TransformationException("empty", e8);
        } catch (SAXException e9) {
            throw new TransformationException("empty", e9);
        }
    }
}
