package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class FlowKt__CollectKt$collectIndexed$2 implements FlowCollector<Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f54548a;

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object a(Object obj, Continuation continuation) {
        int i2 = this.f54548a;
        this.f54548a = i2 + 1;
        if (i2 < 0) {
            throw new ArithmeticException("Index overflow has happened");
        }
        new Integer(i2);
        throw null;
    }
}
