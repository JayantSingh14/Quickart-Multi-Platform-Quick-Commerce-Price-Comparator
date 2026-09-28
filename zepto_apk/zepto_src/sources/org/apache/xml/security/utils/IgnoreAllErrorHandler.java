package org.apache.xml.security.utils;

import com.google.android.gms.internal.pal.a;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

/* loaded from: classes5.dex */
public class IgnoreAllErrorHandler implements ErrorHandler {

    /* renamed from: a, reason: collision with root package name */
    static Log f57349a;

    /* renamed from: b, reason: collision with root package name */
    static final boolean f57350b;

    /* renamed from: c, reason: collision with root package name */
    static final boolean f57351c;

    /* renamed from: d, reason: collision with root package name */
    static Class f57352d;

    static {
        Class clsA = f57352d;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.utils.IgnoreAllErrorHandler");
            f57352d = clsA;
        }
        f57349a = LogFactory.getLog(clsA.getName());
        f57350b = System.getProperty("org.apache.xml.security.test.warn.on.exceptions", "false").equals("true");
        f57351c = System.getProperty("org.apache.xml.security.test.throw.exceptions", "false").equals("true");
    }

    public static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    @Override // org.xml.sax.ErrorHandler
    public void error(SAXParseException sAXParseException) throws SAXParseException {
        if (f57350b) {
            f57349a.error("", sAXParseException);
        }
        if (f57351c) {
            throw sAXParseException;
        }
    }

    @Override // org.xml.sax.ErrorHandler
    public void fatalError(SAXParseException sAXParseException) throws SAXParseException {
        if (f57350b) {
            f57349a.warn("", sAXParseException);
        }
        if (f57351c) {
            throw sAXParseException;
        }
    }

    @Override // org.xml.sax.ErrorHandler
    public void warning(SAXParseException sAXParseException) throws SAXParseException {
        if (f57350b) {
            f57349a.warn("", sAXParseException);
        }
        if (f57351c) {
            throw sAXParseException;
        }
    }
}
