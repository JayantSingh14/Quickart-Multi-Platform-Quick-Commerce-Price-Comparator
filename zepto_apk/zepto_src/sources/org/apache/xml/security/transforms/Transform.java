package org.apache.xml.security.transforms;

import com.google.android.gms.internal.pal.a;
import java.io.OutputStream;
import java.util.HashMap;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.exceptions.AlgorithmAlreadyRegisteredException;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.ClassLoaderUtils;
import org.apache.xml.security.utils.SignatureElementProxy;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
public final class Transform extends SignatureElementProxy {

    /* renamed from: a, reason: collision with root package name */
    static Class f57283a;

    /* renamed from: b, reason: collision with root package name */
    private static Log f57284b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f57285c;

    /* renamed from: d, reason: collision with root package name */
    private static HashMap f57286d;

    /* renamed from: e, reason: collision with root package name */
    private static HashMap f57287e;

    /* renamed from: f, reason: collision with root package name */
    private TransformSpi f57288f;

    static {
        Class clsA = f57283a;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.transforms.Transform");
            f57283a = clsA;
        }
        f57284b = LogFactory.getLog(clsA.getName());
        f57285c = false;
        f57286d = null;
        f57287e = new HashMap();
    }

    public Transform(Document document, String str, NodeList nodeList) throws DOMException, InvalidTransformException {
        super(document);
        this.f57288f = null;
        this.f57333k.setAttributeNS(null, "Algorithm", str);
        TransformSpi transformSpiD = d(str);
        this.f57288f = transformSpiD;
        if (transformSpiD == null) {
            throw new InvalidTransformException("signature.Transform.UnknownTransform", new Object[]{str});
        }
        if (f57284b.isDebugEnabled()) {
            Log log = f57284b;
            StringBuffer stringBuffer = new StringBuffer("Create URI \"");
            stringBuffer.append(str);
            stringBuffer.append("\" class \"");
            stringBuffer.append(this.f57288f.getClass());
            stringBuffer.append("\"");
            log.debug(stringBuffer.toString());
            Log log2 = f57284b;
            StringBuffer stringBuffer2 = new StringBuffer("The NodeList is ");
            stringBuffer2.append(nodeList);
            log2.debug(stringBuffer2.toString());
        }
        if (nodeList != null) {
            for (int i2 = 0; i2 < nodeList.getLength(); i2++) {
                this.f57333k.appendChild(nodeList.item(i2).cloneNode(true));
            }
        }
    }

    public static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    private static Class b(String str) {
        return (Class) f57286d.get(str);
    }

    private static TransformSpi d(String str) throws InvalidTransformException {
        try {
            Object obj = f57287e.get(str);
            if (obj != null) {
                return (TransformSpi) obj;
            }
            Class cls = (Class) f57286d.get(str);
            if (cls == null) {
                return null;
            }
            TransformSpi transformSpi = (TransformSpi) cls.newInstance();
            f57287e.put(str, transformSpi);
            return transformSpi;
        } catch (IllegalAccessException e2) {
            throw new InvalidTransformException("signature.Transform.UnknownTransform", new Object[]{str}, e2);
        } catch (InstantiationException e3) {
            throw new InvalidTransformException("signature.Transform.UnknownTransform", new Object[]{str}, e3);
        }
    }

    @Override // org.apache.xml.security.utils.ElementProxy
    public String e() {
        return "Transform";
    }

    public Transform(Element element, String str) throws DOMException, TransformationException, InvalidTransformException {
        super(element, str);
        this.f57288f = null;
        String attributeNS = element.getAttributeNS(null, "Algorithm");
        if (attributeNS == null || attributeNS.length() == 0) {
            throw new TransformationException("xml.WrongContent", new Object[]{"Algorithm", "Transform"});
        }
        TransformSpi transformSpiD = d(attributeNS);
        this.f57288f = transformSpiD;
        if (transformSpiD == null) {
            throw new InvalidTransformException("signature.Transform.UnknownTransform", new Object[]{attributeNS});
        }
    }

    public String b() {
        return this.f57333k.getAttributeNS(null, "Algorithm");
    }

    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput) throws CanonicalizationException {
        try {
            return this.f57288f.a(xMLSignatureInput, this);
        } catch (ParserConfigurationException e2) {
            throw new CanonicalizationException("signature.Transform.ErrorDuringTransform", new Object[]{b(), "ParserConfigurationException"}, e2);
        } catch (SAXException e3) {
            throw new CanonicalizationException("signature.Transform.ErrorDuringTransform", new Object[]{b(), "SAXException"}, e3);
        }
    }

    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, OutputStream outputStream) throws CanonicalizationException {
        try {
            return this.f57288f.a(xMLSignatureInput, outputStream, this);
        } catch (ParserConfigurationException e2) {
            throw new CanonicalizationException("signature.Transform.ErrorDuringTransform", new Object[]{b(), "ParserConfigurationException"}, e2);
        } catch (SAXException e3) {
            throw new CanonicalizationException("signature.Transform.ErrorDuringTransform", new Object[]{b(), "SAXException"}, e3);
        }
    }

    public static Transform a(Document document, String str) {
        return a(document, str, null);
    }

    public static Transform a(Document document, String str, NodeList nodeList) {
        return new Transform(document, str, nodeList);
    }

    public static void a() {
        if (f57285c) {
            return;
        }
        f57286d = new HashMap(10);
        f57285c = true;
    }

    public static void a(String str, String str2) throws Throwable {
        Class clsB = b(str);
        if (clsB != null) {
            throw new AlgorithmAlreadyRegisteredException("algorithm.alreadyRegistered", new Object[]{str, clsB});
        }
        try {
            HashMap map = f57286d;
            Class clsA = f57283a;
            if (clsA == null) {
                clsA = a("org.apache.xml.security.transforms.Transform");
                f57283a = clsA;
            }
            map.put(str, ClassLoaderUtils.a(str2, clsA));
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }
}
