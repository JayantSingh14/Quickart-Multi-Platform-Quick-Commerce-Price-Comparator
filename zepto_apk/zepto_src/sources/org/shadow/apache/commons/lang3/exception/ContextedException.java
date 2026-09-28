package org.shadow.apache.commons.lang3.exception;

/* loaded from: classes5.dex */
public class ContextedException extends Exception implements ExceptionContext {

    /* renamed from: a, reason: collision with root package name */
    public final DefaultExceptionContext f57754a = new DefaultExceptionContext();

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.f57754a.a(super.getMessage());
    }
}
