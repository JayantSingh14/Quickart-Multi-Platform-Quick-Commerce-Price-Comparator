package io.ktor.utils.io;

import io.ktor.utils.io.internal.UtilsKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class DelimitedKt$skipDelimiter$2 extends Lambda implements Function1<LookAheadSession, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        LookAheadSession lookAhead = (LookAheadSession) obj;
        Intrinsics.checkNotNullParameter(lookAhead, "$this$lookAhead");
        ByteBuffer byteBufferC = lookAhead.c(0, 1);
        byteBufferC.getClass();
        UtilsKt.b(byteBufferC);
        throw null;
    }
}
