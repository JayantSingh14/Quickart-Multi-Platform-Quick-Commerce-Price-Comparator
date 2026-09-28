package org.apache.xml.security.signature;

import com.google.android.gms.internal.pal.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.implementations.Canonicalizer11_OmitComments;
import org.apache.xml.security.c14n.implementations.Canonicalizer20010315OmitComments;
import org.apache.xml.security.c14n.implementations.CanonicalizerBase;
import org.apache.xml.security.exceptions.XMLSecurityRuntimeException;
import org.apache.xml.security.utils.IgnoreAllErrorHandler;
import org.apache.xml.security.utils.JavaUtils;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
public class XMLSignatureInput implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    static Log f57267a;

    /* renamed from: l, reason: collision with root package name */
    static Class f57268l;

    /* renamed from: b, reason: collision with root package name */
    InputStream f57269b;

    /* renamed from: c, reason: collision with root package name */
    Set f57270c;

    /* renamed from: d, reason: collision with root package name */
    Node f57271d;

    /* renamed from: e, reason: collision with root package name */
    Node f57272e;

    /* renamed from: f, reason: collision with root package name */
    boolean f57273f;

    /* renamed from: g, reason: collision with root package name */
    boolean f57274g;

    /* renamed from: h, reason: collision with root package name */
    byte[] f57275h;

    /* renamed from: i, reason: collision with root package name */
    List f57276i;

    /* renamed from: j, reason: collision with root package name */
    boolean f57277j;

    /* renamed from: k, reason: collision with root package name */
    OutputStream f57278k;

    /* renamed from: m, reason: collision with root package name */
    private String f57279m;
    private String n;

    static {
        Class clsC = f57268l;
        if (clsC == null) {
            clsC = c("org.apache.xml.security.signature.XMLSignatureInput");
            f57268l = clsC;
        }
        f57267a = LogFactory.getLog(clsC.getName());
    }

    public XMLSignatureInput(InputStream inputStream) {
        this.f57269b = null;
        this.f57270c = null;
        this.f57271d = null;
        this.f57272e = null;
        this.f57273f = false;
        this.f57274g = false;
        this.f57275h = null;
        this.f57279m = null;
        this.n = null;
        this.f57276i = new ArrayList();
        this.f57277j = false;
        this.f57278k = null;
        this.f57269b = inputStream;
    }

    public void a(OutputStream outputStream) throws CanonicalizationException, IOException {
        a(outputStream, false);
    }

    public Set b() {
        return b(false);
    }

    public InputStream c() {
        InputStream inputStream = this.f57269b;
        return inputStream instanceof FileInputStream ? inputStream : o();
    }

    public InputStream d() {
        return this.f57269b;
    }

    public byte[] e() throws CanonicalizationException, IOException {
        byte[] bArr = this.f57275h;
        if (bArr != null) {
            return bArr;
        }
        InputStream inputStreamO = o();
        if (inputStreamO == null) {
            byte[] bArrB = new Canonicalizer20010315OmitComments().b(this);
            this.f57275h = bArrB;
            return bArrB;
        }
        if (this.f57275h == null) {
            inputStreamO.reset();
            this.f57275h = JavaUtils.a(inputStreamO);
        }
        return this.f57275h;
    }

    public boolean f() {
        return (this.f57269b == null && this.f57270c != null) || this.f57274g;
    }

    public boolean g() {
        return this.f57269b == null && this.f57271d != null && this.f57270c == null && !this.f57274g;
    }

    public boolean h() {
        return !(this.f57269b == null && this.f57275h == null) && this.f57270c == null && this.f57271d == null;
    }

    public boolean i() {
        return this.f57278k != null;
    }

    public boolean j() {
        return this.f57275h != null && this.f57270c == null && this.f57271d == null;
    }

    public String k() {
        return this.n;
    }

    public Node l() {
        return this.f57272e;
    }

    public Node m() {
        return this.f57271d;
    }

    public boolean n() {
        return this.f57273f;
    }

    public InputStream o() throws IOException {
        ByteArrayInputStream byteArrayInputStream;
        InputStream inputStream = this.f57269b;
        if (inputStream instanceof ByteArrayInputStream) {
            if (inputStream.markSupported()) {
                return this.f57269b;
            }
            StringBuffer stringBuffer = new StringBuffer("Accepted as Markable but not truly been");
            stringBuffer.append(this.f57269b);
            throw new RuntimeException(stringBuffer.toString());
        }
        if (this.f57275h != null) {
            byteArrayInputStream = new ByteArrayInputStream(this.f57275h);
        } else {
            if (inputStream == null) {
                return null;
            }
            if (inputStream.markSupported()) {
                f57267a.info("Mark Suported but not used as reset");
            }
            this.f57275h = JavaUtils.a(this.f57269b);
            this.f57269b.close();
            byteArrayInputStream = new ByteArrayInputStream(this.f57275h);
        }
        this.f57269b = byteArrayInputStream;
        return byteArrayInputStream;
    }

    public List p() {
        return this.f57276i;
    }

    public void q() throws ParserConfigurationException, IOException {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        documentBuilderFactoryNewInstance.setValidating(false);
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
        DocumentBuilder documentBuilderNewDocumentBuilder = documentBuilderFactoryNewInstance.newDocumentBuilder();
        try {
            documentBuilderNewDocumentBuilder.setErrorHandler(new IgnoreAllErrorHandler());
            this.f57271d = documentBuilderNewDocumentBuilder.parse(c());
        } catch (SAXException unused) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write("<container>".getBytes());
            byteArrayOutputStream.write(e());
            byteArrayOutputStream.write("</container>".getBytes());
            this.f57271d = documentBuilderNewDocumentBuilder.parse(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).getDocumentElement().getFirstChild().getFirstChild();
        }
        this.f57269b = null;
        this.f57275h = null;
    }

    public String toString() {
        if (f()) {
            StringBuffer stringBuffer = new StringBuffer("XMLSignatureInput/NodeSet/");
            stringBuffer.append(this.f57270c.size());
            stringBuffer.append(" nodes/");
            stringBuffer.append(k());
            return stringBuffer.toString();
        }
        if (g()) {
            StringBuffer stringBuffer2 = new StringBuffer("XMLSignatureInput/Element/");
            stringBuffer2.append(this.f57271d);
            stringBuffer2.append(" exclude ");
            stringBuffer2.append(this.f57272e);
            stringBuffer2.append(" comments:");
            stringBuffer2.append(this.f57273f);
            stringBuffer2.append("/");
            stringBuffer2.append(k());
            return stringBuffer2.toString();
        }
        try {
            StringBuffer stringBuffer3 = new StringBuffer("XMLSignatureInput/OctetStream/");
            stringBuffer3.append(e().length);
            stringBuffer3.append(" octets/");
            stringBuffer3.append(k());
            return stringBuffer3.toString();
        } catch (IOException unused) {
            StringBuffer stringBuffer4 = new StringBuffer("XMLSignatureInput/OctetStream//");
            stringBuffer4.append(k());
            return stringBuffer4.toString();
        } catch (CanonicalizationException unused2) {
            StringBuffer stringBuffer5 = new StringBuffer("XMLSignatureInput/OctetStream//");
            stringBuffer5.append(k());
            return stringBuffer5.toString();
        }
    }

    public XMLSignatureInput(Node node) {
        this.f57269b = null;
        this.f57270c = null;
        this.f57271d = null;
        this.f57272e = null;
        this.f57273f = false;
        this.f57274g = false;
        this.f57275h = null;
        this.f57279m = null;
        this.n = null;
        this.f57276i = new ArrayList();
        this.f57277j = false;
        this.f57278k = null;
        this.f57271d = node;
    }

    public static Class c(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    public void a(OutputStream outputStream, boolean z) throws CanonicalizationException, IOException {
        if (outputStream == this.f57278k) {
            return;
        }
        byte[] bArr = this.f57275h;
        if (bArr != null) {
            outputStream.write(bArr);
            return;
        }
        InputStream inputStream = this.f57269b;
        if (inputStream == null) {
            CanonicalizerBase canonicalizer11_OmitComments = z ? new Canonicalizer11_OmitComments() : new Canonicalizer20010315OmitComments();
            canonicalizer11_OmitComments.a(outputStream);
            canonicalizer11_OmitComments.b(this);
            return;
        }
        if (inputStream instanceof FileInputStream) {
            byte[] bArr2 = new byte[4096];
            while (true) {
                int i2 = this.f57269b.read(bArr2);
                if (i2 == -1) {
                    return;
                } else {
                    outputStream.write(bArr2, 0, i2);
                }
            }
        } else {
            InputStream inputStreamO = o();
            byte[] bArr3 = this.f57275h;
            if (bArr3 != null) {
                outputStream.write(bArr3, 0, bArr3.length);
                return;
            }
            inputStreamO.reset();
            byte[] bArr4 = new byte[1024];
            while (true) {
                int i3 = inputStreamO.read(bArr4);
                if (i3 <= 0) {
                    return;
                } else {
                    outputStream.write(bArr4, 0, i3);
                }
            }
        }
    }

    public Set b(boolean z) throws ParserConfigurationException, DOMException, IOException {
        Node node;
        Set set = this.f57270c;
        if (set != null) {
            return set;
        }
        if (this.f57269b != null || (node = this.f57271d) == null) {
            if (!h()) {
                throw new RuntimeException("getNodeSet() called but no input data present");
            }
            q();
            HashSet hashSet = new HashSet();
            XMLUtils.a(this.f57271d, (Set) hashSet, (Node) null, false);
            return hashSet;
        }
        if (z) {
            XMLUtils.a(XMLUtils.b(node));
        }
        HashSet hashSet2 = new HashSet();
        this.f57270c = hashSet2;
        XMLUtils.a(this.f57271d, hashSet2, this.f57272e, this.f57273f);
        return this.f57270c;
    }

    public void d(boolean z) {
        this.f57274g = z;
    }

    public XMLSignatureInput(byte[] bArr) {
        this.f57269b = null;
        this.f57270c = null;
        this.f57271d = null;
        this.f57272e = null;
        this.f57273f = false;
        this.f57274g = false;
        this.f57275h = null;
        this.f57279m = null;
        this.n = null;
        this.f57276i = new ArrayList();
        this.f57277j = false;
        this.f57278k = null;
        this.f57275h = bArr;
    }

    public void a(String str) {
        this.f57279m = str;
    }

    public void b(OutputStream outputStream) {
        this.f57278k = outputStream;
    }

    public void a(NodeFilter nodeFilter) {
        if (h()) {
            try {
                q();
            } catch (Exception e2) {
                throw new XMLSecurityRuntimeException("signature.XMLSignatureInput.nodesetReference", e2);
            }
        }
        this.f57276i.add(nodeFilter);
    }

    public void b(String str) {
        this.n = str;
    }

    public void a(Node node) {
        this.f57272e = node;
    }

    public void a(boolean z) {
        this.f57277j = z;
    }

    public boolean a() {
        return this.f57277j;
    }

    public void c(boolean z) {
        this.f57273f = z;
    }
}
