package io.ktor.client.network.sockets;

import io.ktor.client.plugins.HttpTimeoutKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class TimeoutExceptionsKt$ByteChannelWithMappedExceptions$1 extends Lambda implements Function1<Throwable, Throwable> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Throwable cause;
        Throwable th = (Throwable) obj;
        if (th != null) {
            Intrinsics.checkNotNullParameter(th, "<this>");
            cause = th;
            while (true) {
                if ((cause != null ? cause.getCause() : null) == null) {
                    break;
                }
                cause = cause.getCause();
            }
        } else {
            cause = null;
        }
        if (!(cause instanceof java.net.SocketTimeoutException)) {
            return th;
        }
        HttpTimeoutKt.b(null, th);
        throw null;
    }
}
