package io.ktor.utils.io.internal;

import io.ktor.utils.io.ClosedWriteChannelException;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class ClosedElement {

    /* renamed from: b, reason: collision with root package name */
    public static final ClosedElement f51243b = new ClosedElement(null);

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f51244a;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    public ClosedElement(Throwable th) {
        this.f51244a = th;
    }

    public final Throwable a() {
        Throwable th = this.f51244a;
        return th == null ? new ClosedWriteChannelException("The channel was closed") : th;
    }

    public final String toString() {
        return "Closed[" + a() + ']';
    }
}
