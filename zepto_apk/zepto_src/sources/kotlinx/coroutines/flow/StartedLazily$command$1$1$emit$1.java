package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.StartedLazily$command$1;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedLazily$command$1$1", f = "SharingStarted.kt", l = {154}, m = "emit")
/* loaded from: classes3.dex */
final class StartedLazily$command$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f54908a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StartedLazily$command$1.AnonymousClass1 f54909b;

    /* renamed from: c, reason: collision with root package name */
    public int f54910c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartedLazily$command$1$1$emit$1(StartedLazily$command$1.AnonymousClass1 anonymousClass1, Continuation continuation) {
        super(continuation);
        this.f54909b = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54908a = obj;
        this.f54910c |= Integer.MIN_VALUE;
        return this.f54909b.b(0, this);
    }
}
