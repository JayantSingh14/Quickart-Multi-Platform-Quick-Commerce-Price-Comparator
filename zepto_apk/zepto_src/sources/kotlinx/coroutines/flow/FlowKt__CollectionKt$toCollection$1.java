package kotlinx.coroutines.flow;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", f = "Collection.kt", l = {22}, m = "toCollection")
/* loaded from: classes3.dex */
final class FlowKt__CollectionKt$toCollection$1<T, C extends Collection<? super T>> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f54551a;

    /* renamed from: b, reason: collision with root package name */
    public int f54552b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowKt__CollectionKt$toCollection$1<T, C> flowKt__CollectionKt$toCollection$1;
        this.f54551a = obj;
        int i2 = this.f54552b | Integer.MIN_VALUE;
        this.f54552b = i2;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f54552b = i2 - Integer.MIN_VALUE;
            flowKt__CollectionKt$toCollection$1 = this;
        } else {
            flowKt__CollectionKt$toCollection$1 = new FlowKt__CollectionKt$toCollection$1<>(this);
        }
        Object obj2 = flowKt__CollectionKt$toCollection$1.f54551a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = flowKt__CollectionKt$toCollection$1.f54552b;
        if (i3 == 0) {
            ResultKt.b(obj2);
            flowKt__CollectionKt$toCollection$1.f54552b = 1;
            throw null;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj2);
        return null;
    }
}
