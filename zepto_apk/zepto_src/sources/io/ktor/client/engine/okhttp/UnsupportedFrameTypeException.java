package io.ktor.client.engine.okhttp;

import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;

@Metadata
/* loaded from: classes3.dex */
public final class UnsupportedFrameTypeException extends IllegalArgumentException implements CopyableThrowable<UnsupportedFrameTypeException> {

    /* renamed from: a, reason: collision with root package name */
    public final Frame f49440a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnsupportedFrameTypeException(Frame frame) {
        super("Unsupported frame type: " + frame);
        Intrinsics.checkNotNullParameter(frame, "frame");
        this.f49440a = frame;
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    public final Throwable a() {
        UnsupportedFrameTypeException unsupportedFrameTypeException = new UnsupportedFrameTypeException(this.f49440a);
        unsupportedFrameTypeException.initCause(this);
        return unsupportedFrameTypeException;
    }
}
