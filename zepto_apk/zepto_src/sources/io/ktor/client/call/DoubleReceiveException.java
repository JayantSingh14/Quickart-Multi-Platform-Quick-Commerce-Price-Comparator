package io.ktor.client.call;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class DoubleReceiveException extends IllegalStateException {

    /* renamed from: a, reason: collision with root package name */
    public final String f49299a;

    public DoubleReceiveException(HttpClientCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.f49299a = "Response already received: " + call;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.f49299a;
    }
}
