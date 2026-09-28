package org.apache.xml.security.signature;

/* loaded from: classes5.dex */
public class MissingResourceFailureException extends XMLSignatureException {

    /* renamed from: c, reason: collision with root package name */
    Reference f57248c;

    public MissingResourceFailureException(String str, Reference reference) {
        super(str);
        this.f57248c = reference;
    }

    public MissingResourceFailureException(String str, Object[] objArr, Exception exc, Reference reference) {
        super(str, objArr, exc);
        this.f57248c = reference;
    }
}
