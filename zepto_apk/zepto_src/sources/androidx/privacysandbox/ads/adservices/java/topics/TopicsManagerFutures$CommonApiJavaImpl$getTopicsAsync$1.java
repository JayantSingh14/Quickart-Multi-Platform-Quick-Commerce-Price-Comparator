package androidx.privacysandbox.ads.adservices.java.topics;

import androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1", f = "TopicsManagerFutures.kt", l = {55}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GetTopicsResponse>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f11264a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TopicsManagerFutures.CommonApiJavaImpl f11265b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ GetTopicsRequest f11266c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1(TopicsManagerFutures.CommonApiJavaImpl commonApiJavaImpl, GetTopicsRequest getTopicsRequest, Continuation continuation) {
        super(2, continuation);
        this.f11265b = commonApiJavaImpl;
        this.f11266c = getTopicsRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1(this.f11265b, this.f11266c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f11264a;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        TopicsManagerFutures.CommonApiJavaImpl commonApiJavaImpl = this.f11265b;
        this.f11264a = 1;
        Object objA = commonApiJavaImpl.f11263a.a(this.f11266c, this);
        return objA == coroutineSingletons ? coroutineSingletons : objA;
    }
}
