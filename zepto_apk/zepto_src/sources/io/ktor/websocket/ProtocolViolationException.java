package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;

@Metadata
/* loaded from: classes3.dex */
public final class ProtocolViolationException extends Exception implements CopyableThrowable<ProtocolViolationException> {

    /* renamed from: a, reason: collision with root package name */
    public final String f51484a;

    public ProtocolViolationException(String violation) {
        Intrinsics.checkNotNullParameter(violation, "violation");
        this.f51484a = violation;
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    public final Throwable a() {
        ProtocolViolationException protocolViolationException = new ProtocolViolationException(this.f51484a);
        Intrinsics.checkNotNullParameter(protocolViolationException, "<this>");
        Intrinsics.checkNotNullParameter(this, "cause");
        protocolViolationException.initCause(this);
        return protocolViolationException;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return "Received illegal frame: " + this.f51484a;
    }
}
