package org.apache.xml.security.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.MessageFormat;
import org.apache.xml.security.utils.I18n;

/* loaded from: classes5.dex */
public class XMLSecurityException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    protected Exception f57180a;

    /* renamed from: b, reason: collision with root package name */
    protected String f57181b;

    public XMLSecurityException() {
        super("Missing message string");
        this.f57181b = null;
        this.f57180a = null;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        synchronized (System.err) {
            try {
                super.printStackTrace(System.err);
                Exception exc = this.f57180a;
                if (exc != null) {
                    exc.printStackTrace(System.err);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        String name = getClass().getName();
        String localizedMessage = super.getLocalizedMessage();
        if (localizedMessage != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(name);
            stringBuffer.append(": ");
            stringBuffer.append(localizedMessage);
            name = stringBuffer.toString();
        }
        if (this.f57180a == null) {
            return name;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(name);
        stringBuffer2.append("\nOriginal Exception was ");
        stringBuffer2.append(this.f57180a.toString());
        return stringBuffer2.toString();
    }

    public XMLSecurityException(String str) {
        super(I18n.b(str));
        this.f57181b = str;
        this.f57180a = null;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        Exception exc = this.f57180a;
        if (exc != null) {
            exc.printStackTrace(printStream);
        }
    }

    public XMLSecurityException(String str, Exception exc) {
        super(I18n.a(str, exc));
        this.f57181b = str;
        this.f57180a = exc;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        Exception exc = this.f57180a;
        if (exc != null) {
            exc.printStackTrace(printWriter);
        }
    }

    public XMLSecurityException(String str, Object[] objArr) {
        super(MessageFormat.format(I18n.b(str), objArr));
        this.f57181b = str;
        this.f57180a = null;
    }

    public XMLSecurityException(String str, Object[] objArr, Exception exc) {
        super(MessageFormat.format(I18n.b(str), objArr));
        this.f57181b = str;
        this.f57180a = exc;
    }
}
