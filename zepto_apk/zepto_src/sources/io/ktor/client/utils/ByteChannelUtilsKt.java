package io.ktor.client.utils;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.CoroutinesKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.GlobalScope;

@Metadata
/* loaded from: classes3.dex */
public final class ByteChannelUtilsKt {
    public static final ByteReadChannel a(ByteReadChannel byteReadChannel, CoroutineContext context, Long l2, Function3 listener) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        return CoroutinesKt.a(GlobalScope.f54113a, context, true, new ByteChannelUtilsKt$observable$1(l2, byteReadChannel, listener, null)).t0();
    }
}
