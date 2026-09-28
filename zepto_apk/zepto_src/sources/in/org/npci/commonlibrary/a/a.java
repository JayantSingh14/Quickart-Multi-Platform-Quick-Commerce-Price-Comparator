package in.org.npci.commonlibrary.a;

import java.io.StringReader;
import java.security.PublicKey;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.xml.security.signature.XMLSignature;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/* loaded from: classes4.dex */
public class a {
    public static Document a(String str) {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
        return documentBuilderFactoryNewInstance.newDocumentBuilder().parse(new InputSource(new StringReader(str)));
    }

    public static boolean a(Document document, PublicKey publicKey) throws Exception {
        NodeList elementsByTagNameNS = document.getElementsByTagNameNS("http://www.w3.org/2000/09/xmldsig#", "Signature");
        if (elementsByTagNameNS.getLength() != 0) {
            return new XMLSignature((Element) elementsByTagNameNS.item(0), "").a(publicKey);
        }
        throw new Exception("Signature not found");
    }
}
