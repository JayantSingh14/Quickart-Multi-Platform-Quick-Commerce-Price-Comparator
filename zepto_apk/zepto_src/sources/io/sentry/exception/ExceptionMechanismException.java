package io.sentry.exception;

import io.sentry.protocol.Mechanism;
import io.sentry.util.Objects;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class ExceptionMechanismException extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final Mechanism f52735a;

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f52736b;

    /* renamed from: c, reason: collision with root package name */
    public final Thread f52737c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f52738d;

    public ExceptionMechanismException(Mechanism mechanism, Throwable th, Thread thread, boolean z) {
        this.f52735a = mechanism;
        Objects.b(th, "Throwable is required.");
        this.f52736b = th;
        Objects.b(thread, "Thread is required.");
        this.f52737c = thread;
        this.f52738d = z;
    }

    public final Mechanism a() {
        return this.f52735a;
    }

    public final Thread b() {
        return this.f52737c;
    }

    public final Throwable c() {
        return this.f52736b;
    }

    public final boolean d() {
        return this.f52738d;
    }

    public ExceptionMechanismException(Mechanism mechanism, Throwable th, Thread thread) {
        this(mechanism, th, thread, false);
    }
}
