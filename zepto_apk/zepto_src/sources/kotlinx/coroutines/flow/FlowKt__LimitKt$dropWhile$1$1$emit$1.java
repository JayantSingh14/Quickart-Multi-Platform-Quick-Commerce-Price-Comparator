package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1", f = "Limit.kt", l = {33, 34, 36}, m = "emit")
/* loaded from: classes3.dex */
final class FlowKt__LimitKt$dropWhile$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f54703a;

    /* renamed from: b, reason: collision with root package name */
    public Object f54704b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f54705c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FlowKt__LimitKt$dropWhile$1$1 f54706d;

    /* renamed from: e, reason: collision with root package name */
    public int f54707e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__LimitKt$dropWhile$1$1$emit$1(FlowKt__LimitKt$dropWhile$1$1 flowKt__LimitKt$dropWhile$1$1, Continuation continuation) {
        super(continuation);
        this.f54706d = flowKt__LimitKt$dropWhile$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54705c = obj;
        this.f54707e |= Integer.MIN_VALUE;
        return this.f54706d.a(null, this);
    }
}
