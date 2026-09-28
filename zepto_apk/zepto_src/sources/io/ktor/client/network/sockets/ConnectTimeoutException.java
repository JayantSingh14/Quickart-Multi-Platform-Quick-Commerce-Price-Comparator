package io.ktor.client.network.sockets;

import java.io.IOException;
import java.net.ConnectException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ConnectTimeoutException extends ConnectException {

    /* renamed from: a, reason: collision with root package name */
    public final IOException f49441a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectTimeoutException(String message, IOException iOException) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
        this.f49441a = iOException;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f49441a;
    }
}
