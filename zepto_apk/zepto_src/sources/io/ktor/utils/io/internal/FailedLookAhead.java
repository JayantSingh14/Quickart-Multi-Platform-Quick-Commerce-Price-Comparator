package io.ktor.utils.io.internal;

import io.ktor.utils.io.LookAheadSuspendSession;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class FailedLookAhead implements LookAheadSuspendSession {

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f51245b;

    public FailedLookAhead(Throwable cause) {
        Intrinsics.checkNotNullParameter(cause, "cause");
        this.f51245b = cause;
    }

    @Override // io.ktor.utils.io.LookAheadSession
    public final void B(int i2) throws Throwable {
        throw this.f51245b;
    }

    @Override // io.ktor.utils.io.LookAheadSuspendSession
    public final Object b(int i2, ContinuationImpl continuationImpl) throws Throwable {
        throw this.f51245b;
    }

    @Override // io.ktor.utils.io.LookAheadSession
    public final ByteBuffer c(int i2, int i3) throws Throwable {
        throw this.f51245b;
    }
}
