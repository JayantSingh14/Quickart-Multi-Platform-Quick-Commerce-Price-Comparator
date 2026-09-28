package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;

@Metadata
/* loaded from: classes3.dex */
public final class FrameTooBigException extends Exception implements CopyableThrowable<FrameTooBigException> {

    /* renamed from: a, reason: collision with root package name */
    public final long f51449a;

    public FrameTooBigException(long j2) {
        this.f51449a = j2;
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    public final Throwable a() {
        FrameTooBigException frameTooBigException = new FrameTooBigException(this.f51449a);
        Intrinsics.checkNotNullParameter(frameTooBigException, "<this>");
        Intrinsics.checkNotNullParameter(this, "cause");
        frameTooBigException.initCause(this);
        return frameTooBigException;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return "Frame is too big: " + this.f51449a;
    }
}
