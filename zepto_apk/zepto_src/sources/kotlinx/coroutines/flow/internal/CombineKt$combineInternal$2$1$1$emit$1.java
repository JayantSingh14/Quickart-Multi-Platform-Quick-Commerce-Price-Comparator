package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1", f = "Combine.kt", l = {29, 30}, m = "emit")
/* loaded from: classes.dex */
final class CombineKt$combineInternal$2$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f55004a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CombineKt$combineInternal$2.AnonymousClass1.C00631 f55005b;

    /* renamed from: c, reason: collision with root package name */
    public int f55006c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineKt$combineInternal$2$1$1$emit$1(CombineKt$combineInternal$2.AnonymousClass1.C00631 c00631, Continuation continuation) {
        super(continuation);
        this.f55005b = c00631;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f55004a = obj;
        this.f55006c |= Integer.MIN_VALUE;
        return this.f55005b.a(null, this);
    }
}
