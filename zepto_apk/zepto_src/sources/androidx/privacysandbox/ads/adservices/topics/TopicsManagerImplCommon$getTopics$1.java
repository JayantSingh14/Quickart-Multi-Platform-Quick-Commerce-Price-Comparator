package androidx.privacysandbox.ads.adservices.topics;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon", f = "TopicsManagerImplCommon.kt", l = {40}, m = "getTopics$suspendImpl")
/* loaded from: classes3.dex */
public final class TopicsManagerImplCommon$getTopics$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public TopicsManagerImplCommon f11285a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f11286b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TopicsManagerImplCommon f11287c;

    /* renamed from: d, reason: collision with root package name */
    public int f11288d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicsManagerImplCommon$getTopics$1(TopicsManagerImplCommon topicsManagerImplCommon, Continuation continuation) {
        super(continuation);
        this.f11287c = topicsManagerImplCommon;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f11286b = obj;
        this.f11288d |= Integer.MIN_VALUE;
        return TopicsManagerImplCommon.d(this.f11287c, null, this);
    }
}
