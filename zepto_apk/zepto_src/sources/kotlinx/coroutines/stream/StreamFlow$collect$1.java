package kotlinx.coroutines.stream;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.stream.StreamFlow", f = "Stream.kt", l = {22}, m = "collect")
/* loaded from: classes3.dex */
final class StreamFlow$collect$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public FlowCollector f55224a;

    /* renamed from: b, reason: collision with root package name */
    public Iterator f55225b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f55226c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ StreamFlow f55227d;

    /* renamed from: e, reason: collision with root package name */
    public int f55228e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamFlow$collect$1(StreamFlow streamFlow, Continuation continuation) {
        super(continuation);
        this.f55227d = streamFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f55226c = obj;
        this.f55228e |= Integer.MIN_VALUE;
        this.f55227d.c(null, this);
        return CoroutineSingletons.f53689a;
    }
}
