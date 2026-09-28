package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ProduceKt", f = "Produce.kt", l = {302}, m = "awaitClose")
/* loaded from: classes3.dex */
final class ProduceKt$awaitClose$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ProducerScope f54422a;

    /* renamed from: b, reason: collision with root package name */
    public Function0 f54423b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f54424c;

    /* renamed from: d, reason: collision with root package name */
    public int f54425d;

    public ProduceKt$awaitClose$1(ContinuationImpl continuationImpl) {
        super(continuationImpl);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54424c = obj;
        this.f54425d |= Integer.MIN_VALUE;
        return ProduceKt.a(null, null, this);
    }
}
