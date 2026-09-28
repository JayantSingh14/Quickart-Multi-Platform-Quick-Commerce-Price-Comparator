package org.apache.xml.security.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.MessageFormat;
import org.apache.xml.security.utils.I18n;

/* loaded from: classes5.dex */
public class XMLSecurityRuntimeException extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    protected Exception f57182a;

    /* renamed from: b, reason: collision with root package name */
    protected String f57183b;

    public XMLSecurityRuntimeException() {
        super("Missing message string");
        this.f57183b = null;
        this.f57182a = null;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        synchronized (System.err) {
            try {
                super.printStackTrace(System.err);
                Exception exc = this.f57182a;
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
        if (this.f57182a == null) {
            return name;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(name);
        stringBuffer2.append("\nOriginal Exception was ");
        stringBuffer2.append(this.f57182a.toString());
        return stringBuffer2.toString();
    }

    public XMLSecurityRuntimeException(String str, Exception exc) {
        super(I18n.a(str, exc));
        this.f57183b = str;
        this.f57182a = exc;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        Exception exc = this.f57182a;
        if (exc != null) {
            exc.printStackTrace(printStream);
        }
    }

    public XMLSecurityRuntimeException(String str, Object[] objArr, Exception exc) {
        super(MessageFormat.format(I18n.b(str), objArr));
        this.f57183b = str;
        this.f57182a = exc;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        Exception exc = this.f57182a;
        if (exc != null) {
            exc.printStackTrace(printWriter);
        }
    }
}
