package coil3;

import coil3.intercept.RealInterceptorChain;
import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import coil3.size.Size;
import coil3.size.SizeResolver;
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
@DebugMetadata(c = "coil3.RealImageLoader$execute$result$1", f = "RealImageLoader.kt", l = {147}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RealImageLoader$execute$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageResult>, Object> {
    final /* synthetic */ Image $cachedPlaceholder;
    final /* synthetic */ EventListener $eventListener;
    final /* synthetic */ ImageRequest $request;
    final /* synthetic */ Size $size;
    final /* synthetic */ SizeResolver $sizeResolver;
    int label;
    final /* synthetic */ RealImageLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealImageLoader$execute$result$1(ImageRequest imageRequest, RealImageLoader realImageLoader, Size size, SizeResolver sizeResolver, EventListener eventListener, Image image, Continuation<? super RealImageLoader$execute$result$1> continuation) {
        super(2, continuation);
        this.$request = imageRequest;
        this.this$0 = realImageLoader;
        this.$size = size;
        this.$sizeResolver = sizeResolver;
        this.$eventListener = eventListener;
        this.$cachedPlaceholder = image;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RealImageLoader$execute$result$1(this.$request, this.this$0, this.$size, this.$sizeResolver, this.$eventListener, this.$cachedPlaceholder, continuation);
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
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.$request, this.this$0.getComponents().getInterceptors(), 0, this.$request, this.$size, this.$sizeResolver, this.$eventListener, this.$cachedPlaceholder != null);
        this.label = 1;
        Object objProceed = realInterceptorChain.proceed(this);
        return objProceed == coroutineSingletons ? coroutineSingletons : objProceed;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImageResult> continuation) {
        return ((RealImageLoader$execute$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f53572a);
    }
}
