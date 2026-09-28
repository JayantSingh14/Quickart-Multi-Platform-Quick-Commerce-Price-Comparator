package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1", f = "Combine.kt", l = {87}, m = "emit")
/* loaded from: classes3.dex */
final class CombineKt$zipImpl$1$1$second$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f55029a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CombineKt$zipImpl$1$1$second$1.AnonymousClass1 f55030b;

    /* renamed from: c, reason: collision with root package name */
    public int f55031c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineKt$zipImpl$1$1$second$1$1$emit$1(CombineKt$zipImpl$1$1$second$1.AnonymousClass1 anonymousClass1, Continuation continuation) {
        super(continuation);
        this.f55030b = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f55029a = obj;
        this.f55031c |= Integer.MIN_VALUE;
        return this.f55030b.a(null, this);
    }
}
