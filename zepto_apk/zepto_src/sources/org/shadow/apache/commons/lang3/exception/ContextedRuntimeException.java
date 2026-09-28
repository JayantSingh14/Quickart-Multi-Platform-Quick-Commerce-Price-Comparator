package org.shadow.apache.commons.lang3.exception;

/* loaded from: classes5.dex */
public class ContextedRuntimeException extends RuntimeException implements ExceptionContext {

    /* renamed from: a, reason: collision with root package name */
    public final DefaultExceptionContext f57755a = new DefaultExceptionContext();

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.f57755a.a(super.getMessage());
    }
}
