package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class ByteChannelSequentialJVM$attachJob$1 extends Lambda implements Function1<Throwable, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        null.attachedJob = null;
        if (th == null) {
            return Unit.f53572a;
        }
        ExceptionUtilsKt.a(th);
        throw null;
    }
}
