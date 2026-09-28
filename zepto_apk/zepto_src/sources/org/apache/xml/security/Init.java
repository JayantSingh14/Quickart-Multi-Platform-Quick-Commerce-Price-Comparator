package org.apache.xml.security;

import com.google.android.gms.internal.pal.a;
import java.io.InputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.algorithms.JCEMapper;
import org.apache.xml.security.algorithms.SignatureAlgorithm;
import org.apache.xml.security.c14n.Canonicalizer;
import org.apache.xml.security.keys.KeyInfo;
import org.apache.xml.security.keys.keyresolver.KeyResolver;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.utils.ElementProxy;
import org.apache.xml.security.utils.I18n;
import org.apache.xml.security.utils.XMLUtils;
import org.apache.xml.security.utils.resolver.ResourceResolver;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public class Init {

    /* renamed from: a, reason: collision with root package name */
    static Log f57082a;

    /* renamed from: b, reason: collision with root package name */
    static Class f57083b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f57084c;

    static {
        Class clsA = f57083b;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.Init");
            f57083b = clsA;
        }
        f57082a = LogFactory.getLog(clsA.getName());
        f57084c = false;
    }

    public static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    public static synchronized void b() {
        long jCurrentTimeMillis;
        long jCurrentTimeMillis2;
        long jCurrentTimeMillis3;
        long jCurrentTimeMillis4;
        Document document;
        long jCurrentTimeMillis5;
        long jCurrentTimeMillis6;
        Node node;
        long j2;
        long j3;
        int i2;
        Element[] elementArr;
        int i3;
        int i4;
        try {
            if (f57084c) {
                return;
            }
            try {
                jCurrentTimeMillis = System.currentTimeMillis();
                jCurrentTimeMillis2 = System.currentTimeMillis();
                jCurrentTimeMillis3 = System.currentTimeMillis();
                jCurrentTimeMillis4 = System.currentTimeMillis();
                DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
                documentBuilderFactoryNewInstance.setNamespaceAware(true);
                documentBuilderFactoryNewInstance.setValidating(false);
                document = documentBuilderFactoryNewInstance.newDocumentBuilder().parse((InputStream) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.xml.security.Init.1
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        String property = System.getProperty("org.apache.xml.security.resource.config");
                        Class<?> cls = getClass();
                        if (property == null) {
                            property = "resource/config.xml";
                        }
                        return cls.getResourceAsStream(property);
                    }
                }));
                jCurrentTimeMillis5 = System.currentTimeMillis();
                jCurrentTimeMillis6 = System.currentTimeMillis();
            } catch (Exception e2) {
                f57082a.fatal("Bad: ", e2);
                e2.printStackTrace();
            }
            try {
                KeyInfo.a();
                long jCurrentTimeMillis7 = System.currentTimeMillis();
                Node firstChild = document.getFirstChild();
                while (firstChild != null && !"Configuration".equals(firstChild.getLocalName())) {
                    firstChild = firstChild.getNextSibling();
                }
                long jCurrentTimeMillis8 = 0;
                Node firstChild2 = firstChild.getFirstChild();
                long jCurrentTimeMillis9 = 0;
                long jCurrentTimeMillis10 = 0;
                long jCurrentTimeMillis11 = 0;
                long jCurrentTimeMillis12 = 0;
                long jCurrentTimeMillis13 = 0;
                long jCurrentTimeMillis14 = 0;
                long jCurrentTimeMillis15 = 0;
                long jCurrentTimeMillis16 = 0;
                long j4 = 0;
                long jCurrentTimeMillis17 = 0;
                long jCurrentTimeMillis18 = 0;
                long jCurrentTimeMillis19 = 0;
                long jCurrentTimeMillis20 = 0;
                long jCurrentTimeMillis21 = 0;
                long jCurrentTimeMillis22 = 0;
                while (firstChild2 != null) {
                    if (1 != firstChild2.getNodeType()) {
                        node = firstChild2;
                        j2 = jCurrentTimeMillis;
                        j3 = jCurrentTimeMillis2;
                    } else {
                        String localName = firstChild2.getLocalName();
                        node = firstChild2;
                        if (localName.equals("ResourceBundles")) {
                            jCurrentTimeMillis9 = System.currentTimeMillis();
                            Element element = (Element) node;
                            Attr attributeNode = element.getAttributeNode("defaultLanguageCode");
                            Attr attributeNode2 = element.getAttributeNode("defaultCountryCode");
                            I18n.a(attributeNode == null ? null : attributeNode.getNodeValue(), attributeNode2 == null ? null : attributeNode2.getNodeValue());
                            jCurrentTimeMillis8 = System.currentTimeMillis();
                        }
                        if (localName.equals("CanonicalizationMethods")) {
                            jCurrentTimeMillis11 = System.currentTimeMillis();
                            Canonicalizer.a();
                            j2 = jCurrentTimeMillis;
                            Element[] elementArrA = XMLUtils.a(node.getFirstChild(), "http://www.xmlsecurity.org/NS/#configuration", "CanonicalizationMethod");
                            int i5 = 0;
                            while (i5 < elementArrA.length) {
                                int i6 = i5;
                                String attributeNS = elementArrA[i5].getAttributeNS(null, "URI");
                                long j5 = jCurrentTimeMillis2;
                                String attributeNS2 = elementArrA[i6].getAttributeNS(null, "JAVACLASS");
                                try {
                                    Class.forName(attributeNS2);
                                    if (f57082a.isDebugEnabled()) {
                                        Log log = f57082a;
                                        StringBuffer stringBuffer = new StringBuffer();
                                        stringBuffer.append("Canonicalizer.register(");
                                        stringBuffer.append(attributeNS);
                                        stringBuffer.append(", ");
                                        stringBuffer.append(attributeNS2);
                                        stringBuffer.append(")");
                                        log.debug(stringBuffer.toString());
                                    }
                                    Canonicalizer.a(attributeNS, attributeNS2);
                                } catch (ClassNotFoundException unused) {
                                    f57082a.fatal(I18n.a("algorithm.classDoesNotExist", new Object[]{attributeNS, attributeNS2}));
                                }
                                i5 = i6 + 1;
                                jCurrentTimeMillis2 = j5;
                            }
                            j3 = jCurrentTimeMillis2;
                            jCurrentTimeMillis10 = System.currentTimeMillis();
                        } else {
                            j2 = jCurrentTimeMillis;
                            j3 = jCurrentTimeMillis2;
                        }
                        if (localName.equals("TransformAlgorithms")) {
                            jCurrentTimeMillis22 = System.currentTimeMillis();
                            Transform.a();
                            Element[] elementArrA2 = XMLUtils.a(node.getFirstChild(), "http://www.xmlsecurity.org/NS/#configuration", "TransformAlgorithm");
                            for (int i7 = 0; i7 < elementArrA2.length; i7 = i4 + 1) {
                                String attributeNS3 = elementArrA2[i7].getAttributeNS(null, "URI");
                                String attributeNS4 = elementArrA2[i7].getAttributeNS(null, "JAVACLASS");
                                try {
                                    Class.forName(attributeNS4);
                                    if (f57082a.isDebugEnabled()) {
                                        Log log2 = f57082a;
                                        StringBuffer stringBuffer2 = new StringBuffer();
                                        i4 = i7;
                                        try {
                                            stringBuffer2.append("Transform.register(");
                                            stringBuffer2.append(attributeNS3);
                                            stringBuffer2.append(", ");
                                            stringBuffer2.append(attributeNS4);
                                            stringBuffer2.append(")");
                                            log2.debug(stringBuffer2.toString());
                                        } catch (ClassNotFoundException unused2) {
                                            f57082a.fatal(I18n.a("algorithm.classDoesNotExist", new Object[]{attributeNS3, attributeNS4}));
                                        } catch (NoClassDefFoundError unused3) {
                                            f57082a.warn("Not able to found dependecies for algorithm, I'm keep working.");
                                        }
                                    } else {
                                        i4 = i7;
                                    }
                                    Transform.a(attributeNS3, attributeNS4);
                                } catch (ClassNotFoundException unused4) {
                                    i4 = i7;
                                } catch (NoClassDefFoundError unused5) {
                                    i4 = i7;
                                }
                            }
                            jCurrentTimeMillis21 = System.currentTimeMillis();
                        }
                        if ("JCEAlgorithmMappings".equals(localName)) {
                            jCurrentTimeMillis13 = System.currentTimeMillis();
                            JCEMapper.a((Element) node);
                            jCurrentTimeMillis12 = System.currentTimeMillis();
                        }
                        if (localName.equals("SignatureAlgorithms")) {
                            jCurrentTimeMillis20 = System.currentTimeMillis();
                            SignatureAlgorithm.h();
                            Element[] elementArrA3 = XMLUtils.a(node.getFirstChild(), "http://www.xmlsecurity.org/NS/#configuration", "SignatureAlgorithm");
                            for (int i8 = 0; i8 < elementArrA3.length; i8 = i3 + 1) {
                                String attributeNS5 = elementArrA3[i8].getAttributeNS(null, "URI");
                                String attributeNS6 = elementArrA3[i8].getAttributeNS(null, "JAVACLASS");
                                try {
                                    Class.forName(attributeNS6);
                                    if (f57082a.isDebugEnabled()) {
                                        Log log3 = f57082a;
                                        StringBuffer stringBuffer3 = new StringBuffer();
                                        i3 = i8;
                                        try {
                                            stringBuffer3.append("SignatureAlgorithm.register(");
                                            stringBuffer3.append(attributeNS5);
                                            stringBuffer3.append(", ");
                                            stringBuffer3.append(attributeNS6);
                                            stringBuffer3.append(")");
                                            log3.debug(stringBuffer3.toString());
                                        } catch (ClassNotFoundException unused6) {
                                            f57082a.fatal(I18n.a("algorithm.classDoesNotExist", new Object[]{attributeNS5, attributeNS6}));
                                        }
                                    } else {
                                        i3 = i8;
                                    }
                                    SignatureAlgorithm.a(attributeNS5, attributeNS6);
                                } catch (ClassNotFoundException unused7) {
                                    i3 = i8;
                                }
                            }
                            jCurrentTimeMillis19 = System.currentTimeMillis();
                        }
                        if (localName.equals("ResourceResolvers")) {
                            jCurrentTimeMillis18 = System.currentTimeMillis();
                            ResourceResolver.a();
                            int i9 = 0;
                            for (Element[] elementArrA4 = XMLUtils.a(node.getFirstChild(), "http://www.xmlsecurity.org/NS/#configuration", "Resolver"); i9 < elementArrA4.length; elementArrA4 = elementArr) {
                                String attributeNS7 = elementArrA4[i9].getAttributeNS(null, "JAVACLASS");
                                String attributeNS8 = elementArrA4[i9].getAttributeNS(null, "DESCRIPTION");
                                if (attributeNS8 == null || attributeNS8.length() <= 0) {
                                    elementArr = elementArrA4;
                                    if (f57082a.isDebugEnabled()) {
                                        Log log4 = f57082a;
                                        StringBuffer stringBuffer4 = new StringBuffer();
                                        stringBuffer4.append("Register Resolver: ");
                                        stringBuffer4.append(attributeNS7);
                                        stringBuffer4.append(": For unknown purposes");
                                        log4.debug(stringBuffer4.toString());
                                    }
                                } else if (f57082a.isDebugEnabled()) {
                                    Log log5 = f57082a;
                                    StringBuffer stringBuffer5 = new StringBuffer();
                                    elementArr = elementArrA4;
                                    stringBuffer5.append("Register Resolver: ");
                                    stringBuffer5.append(attributeNS7);
                                    stringBuffer5.append(": ");
                                    stringBuffer5.append(attributeNS8);
                                    log5.debug(stringBuffer5.toString());
                                } else {
                                    elementArr = elementArrA4;
                                }
                                try {
                                    ResourceResolver.a(attributeNS7);
                                } catch (Throwable th) {
                                    Log log6 = f57082a;
                                    StringBuffer stringBuffer6 = new StringBuffer();
                                    stringBuffer6.append("Cannot register:");
                                    stringBuffer6.append(attributeNS7);
                                    stringBuffer6.append(" perhaps some needed jars are not installed");
                                    log6.warn(stringBuffer6.toString(), th);
                                }
                                jCurrentTimeMillis17 = System.currentTimeMillis();
                                i9++;
                            }
                        }
                        if (localName.equals("KeyResolver")) {
                            jCurrentTimeMillis15 = System.currentTimeMillis();
                            KeyResolver.a();
                            Element[] elementArrA5 = XMLUtils.a(node.getFirstChild(), "http://www.xmlsecurity.org/NS/#configuration", "Resolver");
                            int i10 = 0;
                            while (i10 < elementArrA5.length) {
                                String attributeNS9 = elementArrA5[i10].getAttributeNS(null, "JAVACLASS");
                                String attributeNS10 = elementArrA5[i10].getAttributeNS(null, "DESCRIPTION");
                                if (attributeNS10 == null || attributeNS10.length() <= 0) {
                                    i2 = i10;
                                    if (f57082a.isDebugEnabled()) {
                                        Log log7 = f57082a;
                                        StringBuffer stringBuffer7 = new StringBuffer();
                                        stringBuffer7.append("Register Resolver: ");
                                        stringBuffer7.append(attributeNS9);
                                        stringBuffer7.append(": For unknown purposes");
                                        log7.debug(stringBuffer7.toString());
                                    }
                                } else if (f57082a.isDebugEnabled()) {
                                    Log log8 = f57082a;
                                    StringBuffer stringBuffer8 = new StringBuffer();
                                    i2 = i10;
                                    stringBuffer8.append("Register Resolver: ");
                                    stringBuffer8.append(attributeNS9);
                                    stringBuffer8.append(": ");
                                    stringBuffer8.append(attributeNS10);
                                    log8.debug(stringBuffer8.toString());
                                } else {
                                    i2 = i10;
                                }
                                KeyResolver.a(attributeNS9);
                                i10 = i2 + 1;
                            }
                            jCurrentTimeMillis14 = System.currentTimeMillis();
                        }
                        if (localName.equals("PrefixMappings")) {
                            long jCurrentTimeMillis23 = System.currentTimeMillis();
                            if (f57082a.isDebugEnabled()) {
                                f57082a.debug("Now I try to bind prefixes:");
                            }
                            Element[] elementArrA6 = XMLUtils.a(node.getFirstChild(), "http://www.xmlsecurity.org/NS/#configuration", "PrefixMapping");
                            int i11 = 0;
                            while (i11 < elementArrA6.length) {
                                String attributeNS11 = elementArrA6[i11].getAttributeNS(null, "namespace");
                                long j6 = jCurrentTimeMillis23;
                                String attributeNS12 = elementArrA6[i11].getAttributeNS(null, "prefix");
                                if (f57082a.isDebugEnabled()) {
                                    Log log9 = f57082a;
                                    StringBuffer stringBuffer9 = new StringBuffer();
                                    stringBuffer9.append("Now I try to bind ");
                                    stringBuffer9.append(attributeNS12);
                                    stringBuffer9.append(" to ");
                                    stringBuffer9.append(attributeNS11);
                                    log9.debug(stringBuffer9.toString());
                                }
                                ElementProxy.d(attributeNS11, attributeNS12);
                                i11++;
                                jCurrentTimeMillis23 = j6;
                            }
                            j4 = jCurrentTimeMillis23;
                            jCurrentTimeMillis16 = System.currentTimeMillis();
                        }
                    }
                    firstChild2 = node.getNextSibling();
                    jCurrentTimeMillis = j2;
                    jCurrentTimeMillis2 = j3;
                }
                long j7 = jCurrentTimeMillis;
                long j8 = jCurrentTimeMillis2;
                long jCurrentTimeMillis24 = System.currentTimeMillis();
                if (f57082a.isDebugEnabled()) {
                    Log log10 = f57082a;
                    StringBuffer stringBuffer10 = new StringBuffer();
                    stringBuffer10.append("XX_init                             ");
                    stringBuffer10.append((int) (jCurrentTimeMillis24 - j7));
                    stringBuffer10.append(" ms");
                    log10.debug(stringBuffer10.toString());
                    Log log11 = f57082a;
                    StringBuffer stringBuffer11 = new StringBuffer();
                    stringBuffer11.append("  XX_prng                           ");
                    stringBuffer11.append((int) (jCurrentTimeMillis3 - j8));
                    stringBuffer11.append(" ms");
                    log11.debug(stringBuffer11.toString());
                    Log log12 = f57082a;
                    StringBuffer stringBuffer12 = new StringBuffer();
                    stringBuffer12.append("  XX_parsing                        ");
                    stringBuffer12.append((int) (jCurrentTimeMillis5 - jCurrentTimeMillis4));
                    stringBuffer12.append(" ms");
                    log12.debug(stringBuffer12.toString());
                    Log log13 = f57082a;
                    StringBuffer stringBuffer13 = new StringBuffer();
                    stringBuffer13.append("  XX_configure_i18n                 ");
                    stringBuffer13.append((int) (jCurrentTimeMillis8 - jCurrentTimeMillis9));
                    stringBuffer13.append(" ms");
                    log13.debug(stringBuffer13.toString());
                    Log log14 = f57082a;
                    StringBuffer stringBuffer14 = new StringBuffer();
                    stringBuffer14.append("  XX_configure_reg_c14n             ");
                    stringBuffer14.append((int) (jCurrentTimeMillis10 - jCurrentTimeMillis11));
                    stringBuffer14.append(" ms");
                    log14.debug(stringBuffer14.toString());
                    Log log15 = f57082a;
                    StringBuffer stringBuffer15 = new StringBuffer();
                    stringBuffer15.append("  XX_configure_reg_jcemapper        ");
                    stringBuffer15.append((int) (jCurrentTimeMillis12 - jCurrentTimeMillis13));
                    stringBuffer15.append(" ms");
                    log15.debug(stringBuffer15.toString());
                    Log log16 = f57082a;
                    StringBuffer stringBuffer16 = new StringBuffer();
                    stringBuffer16.append("  XX_configure_reg_keyInfo          ");
                    stringBuffer16.append((int) (jCurrentTimeMillis7 - jCurrentTimeMillis6));
                    stringBuffer16.append(" ms");
                    log16.debug(stringBuffer16.toString());
                    Log log17 = f57082a;
                    StringBuffer stringBuffer17 = new StringBuffer();
                    stringBuffer17.append("  XX_configure_reg_keyResolver      ");
                    stringBuffer17.append((int) (jCurrentTimeMillis14 - jCurrentTimeMillis15));
                    stringBuffer17.append(" ms");
                    log17.debug(stringBuffer17.toString());
                    Log log18 = f57082a;
                    StringBuffer stringBuffer18 = new StringBuffer();
                    stringBuffer18.append("  XX_configure_reg_prefixes         ");
                    stringBuffer18.append((int) (jCurrentTimeMillis16 - j4));
                    stringBuffer18.append(" ms");
                    log18.debug(stringBuffer18.toString());
                    Log log19 = f57082a;
                    StringBuffer stringBuffer19 = new StringBuffer();
                    stringBuffer19.append("  XX_configure_reg_resourceresolver ");
                    stringBuffer19.append((int) (jCurrentTimeMillis17 - jCurrentTimeMillis18));
                    stringBuffer19.append(" ms");
                    log19.debug(stringBuffer19.toString());
                    Log log20 = f57082a;
                    StringBuffer stringBuffer20 = new StringBuffer();
                    stringBuffer20.append("  XX_configure_reg_sigalgos         ");
                    stringBuffer20.append((int) (jCurrentTimeMillis19 - jCurrentTimeMillis20));
                    stringBuffer20.append(" ms");
                    log20.debug(stringBuffer20.toString());
                    Log log21 = f57082a;
                    StringBuffer stringBuffer21 = new StringBuffer();
                    stringBuffer21.append("  XX_configure_reg_transforms       ");
                    stringBuffer21.append((int) (jCurrentTimeMillis21 - jCurrentTimeMillis22));
                    stringBuffer21.append(" ms");
                    log21.debug(stringBuffer21.toString());
                }
                f57084c = true;
            } catch (Exception e3) {
                e3.printStackTrace();
                throw e3;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static final boolean a() {
        return f57084c;
    }
}
