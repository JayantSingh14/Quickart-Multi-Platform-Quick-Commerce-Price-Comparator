package org.apache.xml.security.transforms;

import com.google.android.gms.internal.pal.a;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.InvalidCanonicalizerException;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.SignatureElementProxy;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* loaded from: classes5.dex */
public class Transforms extends SignatureElementProxy {

    /* renamed from: a, reason: collision with root package name */
    static Log f57290a;

    /* renamed from: c, reason: collision with root package name */
    static Class f57291c;

    /* renamed from: b, reason: collision with root package name */
    Element[] f57292b;

    static {
        Class clsB = f57291c;
        if (clsB == null) {
            clsB = b("org.apache.xml.security.transforms.Transforms");
            f57291c = clsB;
        }
        f57290a = LogFactory.getLog(clsB.getName());
    }

    public Transforms() {
    }

    public static Class b(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    public int a() {
        if (this.f57292b == null) {
            this.f57292b = XMLUtils.a(this.f57333k.getFirstChild(), "Transform");
        }
        return this.f57292b.length;
    }

    @Override // org.apache.xml.security.utils.ElementProxy
    public String e() {
        return "Transforms";
    }

    public Transforms(Document document) throws DOMException {
        super(document);
        XMLUtils.b(this.f57333k);
    }

    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, OutputStream outputStream) throws TransformationException {
        try {
            int iA = a() - 1;
            for (int i2 = 0; i2 < iA; i2++) {
                Transform transformA = a(i2);
                if (f57290a.isDebugEnabled()) {
                    Log log = f57290a;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Perform the (");
                    stringBuffer.append(i2);
                    stringBuffer.append(")th ");
                    stringBuffer.append(transformA.b());
                    stringBuffer.append(" transform");
                    log.debug(stringBuffer.toString());
                }
                xMLSignatureInput = transformA.a(xMLSignatureInput);
            }
            return iA >= 0 ? a(iA).a(xMLSignatureInput, outputStream) : xMLSignatureInput;
        } catch (IOException e2) {
            throw new TransformationException("empty", e2);
        } catch (CanonicalizationException e3) {
            throw new TransformationException("empty", e3);
        } catch (InvalidCanonicalizerException e4) {
            throw new TransformationException("empty", e4);
        }
    }

    public Transforms(Element element, String str) throws TransformationException {
        super(element, str);
        if (a() == 0) {
            throw new TransformationException("xml.WrongContent", new Object[]{"Transform", "Transforms"});
        }
    }

    public Transform a(int i2) throws TransformationException {
        try {
            if (this.f57292b == null) {
                this.f57292b = XMLUtils.a(this.f57333k.getFirstChild(), "Transform");
            }
            return new Transform(this.f57292b[i2], this.f57334l);
        } catch (XMLSecurityException e2) {
            throw new TransformationException("empty", e2);
        }
    }

    public void a(String str) throws DOMException, TransformationException {
        try {
            if (f57290a.isDebugEnabled()) {
                Log log = f57290a;
                StringBuffer stringBuffer = new StringBuffer("Transforms.addTransform(");
                stringBuffer.append(str);
                stringBuffer.append(")");
                log.debug(stringBuffer.toString());
            }
            a(Transform.a(this.f57335m, str));
        } catch (InvalidTransformException e2) {
            throw new TransformationException("empty", e2);
        }
    }

    private void a(Transform transform) throws DOMException {
        if (f57290a.isDebugEnabled()) {
            Log log = f57290a;
            StringBuffer stringBuffer = new StringBuffer("Transforms.addTransform(");
            stringBuffer.append(transform.b());
            stringBuffer.append(")");
            log.debug(stringBuffer.toString());
        }
        this.f57333k.appendChild(transform.k());
        XMLUtils.b(this.f57333k);
    }
}
