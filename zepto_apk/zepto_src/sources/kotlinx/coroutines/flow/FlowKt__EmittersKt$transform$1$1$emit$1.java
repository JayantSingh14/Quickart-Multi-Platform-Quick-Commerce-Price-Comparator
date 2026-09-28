package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1", f = "Emitters.kt", l = {Type.A6}, m = "emit")
/* loaded from: classes3.dex */
public final class FlowKt__EmittersKt$transform$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f54638a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlowKt__EmittersKt$transform$1.AnonymousClass1 f54639b;

    /* renamed from: c, reason: collision with root package name */
    public int f54640c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__EmittersKt$transform$1$1$emit$1(FlowKt__EmittersKt$transform$1.AnonymousClass1 anonymousClass1, Continuation continuation) {
        super(continuation);
        this.f54639b = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54638a = obj;
        this.f54640c |= Integer.MIN_VALUE;
        return this.f54639b.a(null, this);
    }
}
