package org.apache.xml.security.utils.resolver.implementations;

import coil3.network.internal.UtilsKt;
import com.google.android.gms.internal.pal.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.Base64;
import org.apache.xml.security.utils.resolver.ResourceResolverException;
import org.apache.xml.security.utils.resolver.ResourceResolverSpi;
import org.apache.xml.utils.URI;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;

/* loaded from: classes5.dex */
public class ResolverDirectHTTP extends ResourceResolverSpi {

    /* renamed from: d, reason: collision with root package name */
    static Log f57384d;

    /* renamed from: e, reason: collision with root package name */
    static Class f57385e;

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f57386f;

    static {
        Class clsC = f57385e;
        if (clsC == null) {
            clsC = c("org.apache.xml.security.utils.resolver.implementations.ResolverDirectHTTP");
            f57385e = clsC;
        }
        f57384d = LogFactory.getLog(clsC.getName());
        f57386f = new String[]{"http.proxy.host", "http.proxy.port", "http.proxy.username", "http.proxy.password", "http.basic.username", "http.basic.password"};
    }

    public static Class c(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    @Override // org.apache.xml.security.utils.resolver.ResourceResolverSpi
    public XMLSignatureInput a(Attr attr, String str) throws IOException, ResourceResolverException {
        String str2;
        String property;
        String property2;
        boolean z;
        try {
            String[] strArr = f57386f;
            String strA = a(strArr[0]);
            String strA2 = a(strArr[1]);
            boolean z2 = (strA == null || strA2 == null) ? false : true;
            if (z2) {
                if (f57384d.isDebugEnabled()) {
                    Log log = f57384d;
                    StringBuffer stringBuffer = new StringBuffer("Use of HTTP proxy enabled: ");
                    stringBuffer.append(strA);
                    stringBuffer.append(":");
                    stringBuffer.append(strA2);
                    log.debug(stringBuffer.toString());
                }
                String property3 = System.getProperty("http.proxySet");
                property = System.getProperty("http.proxyHost");
                property2 = System.getProperty("http.proxyPort");
                System.setProperty("http.proxySet", "true");
                System.setProperty("http.proxyHost", strA);
                System.setProperty("http.proxyPort", strA2);
                str2 = property3;
            } else {
                str2 = null;
                property = null;
                property2 = null;
            }
            boolean z3 = (str2 == null || property == null || property2 == null) ? false : true;
            URI uriA = a(attr.getNodeValue(), str);
            URI uri = new URI(uriA);
            uri.setFragment((String) null);
            URL url = new URL(uri.toString());
            URLConnection uRLConnectionOpenConnection = url.openConnection();
            String strA3 = a(strArr[2]);
            String strA4 = a(strArr[3]);
            if (strA3 == null || strA4 == null) {
                z = z2;
            } else {
                z = z2;
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(strA3);
                stringBuffer2.append(":");
                stringBuffer2.append(strA4);
                uRLConnectionOpenConnection.setRequestProperty("Proxy-Authorization", Base64.b(stringBuffer2.toString().getBytes()));
            }
            String headerField = uRLConnectionOpenConnection.getHeaderField("WWW-Authenticate");
            if (headerField != null && headerField.startsWith("Basic")) {
                String strA5 = a(strArr[4]);
                String strA6 = a(strArr[5]);
                if (strA5 != null && strA6 != null) {
                    uRLConnectionOpenConnection = url.openConnection();
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append(strA5);
                    stringBuffer3.append(":");
                    stringBuffer3.append(strA6);
                    String strB = Base64.b(stringBuffer3.toString().getBytes());
                    StringBuffer stringBuffer4 = new StringBuffer("Basic ");
                    stringBuffer4.append(strB);
                    uRLConnectionOpenConnection.setRequestProperty("Authorization", stringBuffer4.toString());
                }
            }
            String headerField2 = uRLConnectionOpenConnection.getHeaderField(UtilsKt.CONTENT_TYPE);
            InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[4096];
            int i2 = 0;
            while (true) {
                int i3 = inputStream.read(bArr);
                if (i3 < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i3);
                i2 += i3;
            }
            Log log2 = f57384d;
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("Fetched ");
            stringBuffer5.append(i2);
            stringBuffer5.append(" bytes from URI ");
            stringBuffer5.append(uriA.toString());
            log2.debug(stringBuffer5.toString());
            XMLSignatureInput xMLSignatureInput = new XMLSignatureInput(byteArrayOutputStream.toByteArray());
            xMLSignatureInput.b(uriA.toString());
            xMLSignatureInput.a(headerField2);
            if (z && z3) {
                System.setProperty("http.proxySet", str2);
                System.setProperty("http.proxyHost", property);
                System.setProperty("http.proxyPort", property2);
            }
            return xMLSignatureInput;
        } catch (MalformedURLException e2) {
            throw new ResourceResolverException("generic.EmptyMessage", e2, attr, str);
        } catch (IOException e3) {
            throw new ResourceResolverException("generic.EmptyMessage", e3, attr, str);
        }
    }

    @Override // org.apache.xml.security.utils.resolver.ResourceResolverSpi
    public boolean b(Attr attr, String str) throws DOMException {
        Log log;
        String str2;
        if (attr == null) {
            log = f57384d;
            str2 = "quick fail, uri == null";
        } else {
            String nodeValue = attr.getNodeValue();
            if (!nodeValue.equals("") && nodeValue.charAt(0) != '#') {
                if (f57384d.isDebugEnabled()) {
                    f57384d.debug("I was asked whether I can resolve ".concat(nodeValue));
                }
                if (!nodeValue.startsWith("http:") && (str == null || !str.startsWith("http:"))) {
                    if (f57384d.isDebugEnabled()) {
                        f57384d.debug("I state that I can't resolve ".concat(nodeValue));
                    }
                    return false;
                }
                if (!f57384d.isDebugEnabled()) {
                    return true;
                }
                f57384d.debug("I state that I can resolve ".concat(nodeValue));
                return true;
            }
            log = f57384d;
            str2 = "quick fail for empty URIs and local ones";
        }
        log.debug(str2);
        return false;
    }

    private URI a(String str, String str2) {
        return (str2 == null || "".equals(str2)) ? new URI(str) : new URI(new URI(str2), str);
    }

    @Override // org.apache.xml.security.utils.resolver.ResourceResolverSpi
    public boolean a() {
        return true;
    }
}
