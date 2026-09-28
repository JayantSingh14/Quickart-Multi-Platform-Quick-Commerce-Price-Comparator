package io.ktor.client.network.sockets;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class SocketTimeoutException extends java.net.SocketTimeoutException {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f49442a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocketTimeoutException(String message, Throwable th) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
        this.f49442a = th;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f49442a;
    }
}
