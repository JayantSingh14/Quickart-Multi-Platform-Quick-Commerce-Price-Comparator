package org.apache.xml.security.algorithms;

import com.google.android.gms.internal.pal.a;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.exceptions.AlgorithmAlreadyRegisteredException;
import org.apache.xml.security.signature.XMLSignatureException;
import org.w3c.dom.Element;

/* loaded from: classes5.dex */
public class SignatureAlgorithm extends Algorithm {

    /* renamed from: a, reason: collision with root package name */
    static Log f57095a;

    /* renamed from: b, reason: collision with root package name */
    static boolean f57096b;

    /* renamed from: c, reason: collision with root package name */
    static HashMap f57097c;

    /* renamed from: d, reason: collision with root package name */
    static ThreadLocal f57098d;

    /* renamed from: e, reason: collision with root package name */
    static ThreadLocal f57099e;

    /* renamed from: f, reason: collision with root package name */
    static ThreadLocal f57100f;

    /* renamed from: g, reason: collision with root package name */
    static ThreadLocal f57101g;

    /* renamed from: i, reason: collision with root package name */
    static Class f57102i;

    /* renamed from: h, reason: collision with root package name */
    protected SignatureAlgorithmSpi f57103h;
    private String q;

    static {
        Class clsB = f57102i;
        if (clsB == null) {
            clsB = b("org.apache.xml.security.algorithms.SignatureAlgorithm");
            f57102i = clsB;
        }
        f57095a = LogFactory.getLog(clsB.getName());
        f57096b = false;
        f57097c = null;
        f57098d = new ThreadLocal() { // from class: org.apache.xml.security.algorithms.SignatureAlgorithm.1
            @Override // java.lang.ThreadLocal
            public Object initialValue() {
                return new HashMap();
            }
        };
        f57099e = new ThreadLocal() { // from class: org.apache.xml.security.algorithms.SignatureAlgorithm.2
            @Override // java.lang.ThreadLocal
            public Object initialValue() {
                return new HashMap();
            }
        };
        f57100f = new ThreadLocal() { // from class: org.apache.xml.security.algorithms.SignatureAlgorithm.3
            @Override // java.lang.ThreadLocal
            public Object initialValue() {
                return new HashMap();
            }
        };
        f57101g = new ThreadLocal() { // from class: org.apache.xml.security.algorithms.SignatureAlgorithm.4
            @Override // java.lang.ThreadLocal
            public Object initialValue() {
                return new HashMap();
            }
        };
    }

    public SignatureAlgorithm(Element element, String str) {
        super(element, str);
        this.f57103h = null;
        this.q = g();
    }

    public static Class b(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    private static SignatureAlgorithmSpi f(String str) throws XMLSignatureException {
        try {
            Class clsG = g(str);
            if (f57095a.isDebugEnabled()) {
                Log log = f57095a;
                StringBuffer stringBuffer = new StringBuffer("Create URI \"");
                stringBuffer.append(str);
                stringBuffer.append("\" class \"");
                stringBuffer.append(clsG);
                stringBuffer.append("\"");
                log.debug(stringBuffer.toString());
            }
            return (SignatureAlgorithmSpi) clsG.newInstance();
        } catch (IllegalAccessException e2) {
            throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{str, e2.getMessage()}, e2);
        } catch (InstantiationException e3) {
            throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{str, e3.getMessage()}, e3);
        } catch (NullPointerException e4) {
            throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{str, e4.getMessage()}, e4);
        }
    }

    private static Class g(String str) {
        HashMap map = f57097c;
        if (map == null) {
            return null;
        }
        return (Class) map.get(str);
    }

    public static void h() throws Throwable {
        if (f57095a == null) {
            Class clsB = f57102i;
            if (clsB == null) {
                clsB = b("org.apache.xml.security.algorithms.SignatureAlgorithm");
                f57102i = clsB;
            }
            f57095a = LogFactory.getLog(clsB.getName());
        }
        f57095a.debug("Init() called");
        if (f57096b) {
            return;
        }
        f57097c = new HashMap(10);
        f57096b = true;
    }

    public void a(byte b2) {
        this.f57103h.a(b2);
    }

    public String c() {
        try {
            return e(this.q).b();
        } catch (XMLSignatureException unused) {
            return null;
        }
    }

    @Override // org.apache.xml.security.utils.SignatureElementProxy, org.apache.xml.security.utils.ElementProxy
    public String d() {
        return "http://www.w3.org/2000/09/xmldsig#";
    }

    @Override // org.apache.xml.security.utils.ElementProxy
    public String e() {
        return "SignatureMethod";
    }

    public static void a(String str, String str2) throws AlgorithmAlreadyRegisteredException, XMLSignatureException {
        if (f57095a.isDebugEnabled()) {
            Log log = f57095a;
            StringBuffer stringBuffer = new StringBuffer("Try to register ");
            stringBuffer.append(str);
            stringBuffer.append(StringUtils.SPACE);
            stringBuffer.append(str2);
            log.debug(stringBuffer.toString());
        }
        Class clsG = g(str);
        if (clsG != null) {
            String name = clsG.getName();
            if (name.length() != 0) {
                throw new AlgorithmAlreadyRegisteredException("algorithm.alreadyRegistered", new Object[]{str, name});
            }
        }
        try {
            f57097c.put(str, Class.forName(str2));
        } catch (ClassNotFoundException e2) {
            throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{str, e2.getMessage()}, e2);
        } catch (NullPointerException e3) {
            throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{str, e3.getMessage()}, e3);
        }
    }

    private static SignatureAlgorithmSpi d(String str) throws XMLSignatureException {
        SignatureAlgorithmSpi signatureAlgorithmSpi = (SignatureAlgorithmSpi) ((Map) f57098d.get()).get(str);
        if (signatureAlgorithmSpi != null) {
            signatureAlgorithmSpi.c();
            return signatureAlgorithmSpi;
        }
        SignatureAlgorithmSpi signatureAlgorithmSpiF = f(str);
        ((Map) f57098d.get()).put(str, signatureAlgorithmSpiF);
        return signatureAlgorithmSpiF;
    }

    private static SignatureAlgorithmSpi e(String str) throws XMLSignatureException {
        SignatureAlgorithmSpi signatureAlgorithmSpi = (SignatureAlgorithmSpi) ((Map) f57099e.get()).get(str);
        if (signatureAlgorithmSpi != null) {
            signatureAlgorithmSpi.c();
            return signatureAlgorithmSpi;
        }
        SignatureAlgorithmSpi signatureAlgorithmSpiF = f(str);
        ((Map) f57099e.get()).put(str, signatureAlgorithmSpiF);
        return signatureAlgorithmSpiF;
    }

    public void f() {
        ((Map) f57101g.get()).clear();
        ((Map) f57099e.get()).clear();
    }

    public final String g() {
        return this.f57333k.getAttributeNS(null, "Algorithm");
    }

    public void a(Key key) {
        a(false);
        Map map = (Map) f57101g.get();
        if (map.get(this.q) == key) {
            return;
        }
        map.put(this.q, key);
        this.f57103h.a(key);
    }

    private void a(boolean z) {
        SignatureAlgorithmSpi signatureAlgorithmSpiD = z ? d(this.q) : e(this.q);
        this.f57103h = signatureAlgorithmSpiD;
        signatureAlgorithmSpiD.a(this.f57333k);
    }

    public void a(byte[] bArr) {
        this.f57103h.a(bArr);
    }

    public void a(byte[] bArr, int i2, int i3) {
        this.f57103h.a(bArr, i2, i3);
    }

    public String b() {
        try {
            return e(this.q).a();
        } catch (XMLSignatureException unused) {
            return null;
        }
    }

    public boolean b(byte[] bArr) {
        return this.f57103h.b(bArr);
    }
}
