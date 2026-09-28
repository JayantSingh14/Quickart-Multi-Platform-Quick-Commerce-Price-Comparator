package org.apache.xml.security.signature;

import com.google.android.gms.internal.pal.a;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.utils.I18n;
import org.apache.xml.security.utils.SignatureElementProxy;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
public class Manifest extends SignatureElementProxy {

    /* renamed from: a, reason: collision with root package name */
    static Log f57241a;

    /* renamed from: f, reason: collision with root package name */
    static Class f57242f;

    /* renamed from: b, reason: collision with root package name */
    List f57243b;

    /* renamed from: c, reason: collision with root package name */
    Element[] f57244c;

    /* renamed from: d, reason: collision with root package name */
    HashMap f57245d;

    /* renamed from: e, reason: collision with root package name */
    List f57246e;

    /* renamed from: g, reason: collision with root package name */
    private boolean[] f57247g;

    static {
        Class clsA = f57242f;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.signature.Manifest");
            f57242f = clsA;
        }
        f57241a = LogFactory.getLog(clsA.getName());
    }

    public Manifest(Element element, String str) {
        super(element, str);
        this.f57247g = null;
        this.f57245d = null;
        this.f57246e = null;
        Element[] elementArrA = XMLUtils.a(this.f57333k.getFirstChild(), "Reference");
        this.f57244c = elementArrA;
        int length = elementArrA.length;
        if (length == 0) {
            throw new DOMException((short) 4, I18n.a("xml.WrongContent", new Object[]{"Reference", "Manifest"}));
        }
        this.f57243b = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            this.f57243b.add(null);
        }
    }

    public int a() {
        return this.f57243b.size();
    }

    @Override // org.apache.xml.security.utils.ElementProxy
    public String e() {
        return "Manifest";
    }

    public static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    private void a(int i2, boolean z) {
        if (this.f57247g == null) {
            this.f57247g = new boolean[a()];
        }
        this.f57247g[i2] = z;
    }

    public boolean a(boolean z) throws XMLSecurityException {
        if (this.f57244c == null) {
            this.f57244c = XMLUtils.a(this.f57333k.getFirstChild(), "Reference");
        }
        if (f57241a.isDebugEnabled()) {
            Log log = f57241a;
            StringBuffer stringBuffer = new StringBuffer("verify ");
            stringBuffer.append(this.f57244c.length);
            stringBuffer.append(" References");
            log.debug(stringBuffer.toString());
            Log log2 = f57241a;
            StringBuffer stringBuffer2 = new StringBuffer("I am ");
            stringBuffer2.append(z ? "" : "not");
            stringBuffer2.append(" requested to follow nested Manifests");
            log2.debug(stringBuffer2.toString());
        }
        Element[] elementArr = this.f57244c;
        if (elementArr.length == 0) {
            throw new XMLSecurityException("empty");
        }
        this.f57247g = new boolean[elementArr.length];
        boolean z2 = true;
        for (int i2 = 0; i2 < this.f57244c.length; i2++) {
            Reference reference = new Reference(this.f57244c[i2], this.f57334l, this);
            this.f57243b.set(i2, reference);
            try {
                boolean zJ = reference.j();
                a(i2, zJ);
                if (!zJ) {
                    z2 = false;
                }
                if (f57241a.isDebugEnabled()) {
                    Log log3 = f57241a;
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("The Reference has Type ");
                    stringBuffer3.append(reference.c());
                    log3.debug(stringBuffer3.toString());
                }
                if (z2 && z && reference.f()) {
                    f57241a.debug("We have to follow a nested Manifest");
                    Manifest manifest = null;
                    try {
                        try {
                            try {
                                XMLSignatureInput xMLSignatureInputA = reference.a((OutputStream) null);
                                Iterator it = xMLSignatureInputA.b().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    Node node = (Node) it.next();
                                    if (node.getNodeType() == 1 && ((Element) node).getNamespaceURI().equals("http://www.w3.org/2000/09/xmldsig#") && ((Element) node).getLocalName().equals("Manifest")) {
                                        try {
                                            manifest = new Manifest((Element) node, xMLSignatureInputA.k());
                                            break;
                                        } catch (XMLSecurityException unused) {
                                            continue;
                                        }
                                    }
                                }
                                if (manifest == null) {
                                    throw new MissingResourceFailureException("empty", reference);
                                }
                                manifest.f57246e = this.f57246e;
                                manifest.f57245d = this.f57245d;
                                if (manifest.a(z)) {
                                    f57241a.debug("The nested Manifest was valid (good)");
                                } else {
                                    f57241a.warn("The nested Manifest was invalid (bad)");
                                    z2 = false;
                                }
                            } catch (IOException e2) {
                                throw new ReferenceNotInitializedException("empty", e2);
                            }
                        } catch (SAXException e3) {
                            throw new ReferenceNotInitializedException("empty", e3);
                        }
                    } catch (ParserConfigurationException e4) {
                        throw new ReferenceNotInitializedException("empty", e4);
                    }
                }
            } catch (ReferenceNotInitializedException e5) {
                throw new MissingResourceFailureException("signature.Verification.Reference.NoInput", new Object[]{reference.b()}, e5, reference);
            }
        }
        return z2;
    }
}
