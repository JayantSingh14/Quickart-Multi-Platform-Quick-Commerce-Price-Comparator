package coil3.intercept;

import coil3.ComponentRegistry;
import coil3.EventListener;
import coil3.fetch.FetchResult;
import coil3.fetch.SourceFetchResult;
import coil3.intercept.EngineInterceptor;
import coil3.request.ImageRequest;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "coil3.intercept.EngineInterceptor$execute$executeResult$1", f = "EngineInterceptor.kt", l = {WKSRecord.Service.ERPC}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class EngineInterceptor$execute$executeResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super EngineInterceptor.ExecuteResult>, Object> {
    final /* synthetic */ Ref.ObjectRef<ComponentRegistry> $components;
    final /* synthetic */ EventListener $eventListener;
    final /* synthetic */ Ref.ObjectRef<FetchResult> $fetchResult;
    final /* synthetic */ Object $mappedData;
    final /* synthetic */ Ref.ObjectRef<Options> $options;
    final /* synthetic */ ImageRequest $request;
    int label;
    final /* synthetic */ EngineInterceptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EngineInterceptor$execute$executeResult$1(EngineInterceptor engineInterceptor, Ref.ObjectRef<FetchResult> objectRef, Ref.ObjectRef<ComponentRegistry> objectRef2, ImageRequest imageRequest, Object obj, Ref.ObjectRef<Options> objectRef3, EventListener eventListener, Continuation<? super EngineInterceptor$execute$executeResult$1> continuation) {
        super(2, continuation);
        this.this$0 = engineInterceptor;
        this.$fetchResult = objectRef;
        this.$components = objectRef2;
        this.$request = imageRequest;
        this.$mappedData = obj;
        this.$options = objectRef3;
        this.$eventListener = eventListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EngineInterceptor$execute$executeResult$1(this.this$0, this.$fetchResult, this.$components, this.$request, this.$mappedData, this.$options, this.$eventListener, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        EngineInterceptor engineInterceptor = this.this$0;
        SourceFetchResult sourceFetchResult = (SourceFetchResult) this.$fetchResult.f53801a;
        ComponentRegistry componentRegistry = (ComponentRegistry) this.$components.f53801a;
        ImageRequest imageRequest = this.$request;
        Object obj2 = this.$mappedData;
        Options options = (Options) this.$options.f53801a;
        EventListener eventListener = this.$eventListener;
        this.label = 1;
        Object objDecode = engineInterceptor.decode(sourceFetchResult, componentRegistry, imageRequest, obj2, options, eventListener, this);
        return objDecode == coroutineSingletons ? coroutineSingletons : objDecode;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super EngineInterceptor.ExecuteResult> continuation) {
        return ((EngineInterceptor$execute$executeResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f53572a);
    }
}
