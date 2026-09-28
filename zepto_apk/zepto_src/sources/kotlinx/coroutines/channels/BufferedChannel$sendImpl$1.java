package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.functions.Function4;

@Metadata
/* loaded from: classes3.dex */
public final class BufferedChannel$sendImpl$1 implements Function4 {
    static {
        new BufferedChannel$sendImpl$1();
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object d(Object obj, Object obj2, Object obj3, Object obj4) {
        ((Number) obj2).intValue();
        ((Number) obj4).longValue();
        throw new IllegalStateException("unexpected");
    }
}
