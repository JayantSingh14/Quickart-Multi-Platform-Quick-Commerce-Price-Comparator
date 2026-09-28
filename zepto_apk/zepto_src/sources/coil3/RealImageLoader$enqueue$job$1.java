package coil3;

import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import coil3.util.Logger;
import coil3.util.LoggingKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "coil3.RealImageLoader$enqueue$job$1", f = "RealImageLoader.kt", l = {WKSRecord.Protocol.RVD}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RealImageLoader$enqueue$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageResult>, Object> {
    final /* synthetic */ ImageRequest $request;
    int label;
    final /* synthetic */ RealImageLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealImageLoader$enqueue$job$1(RealImageLoader realImageLoader, ImageRequest imageRequest, Continuation<? super RealImageLoader$enqueue$job$1> continuation) {
        super(2, continuation);
        this.this$0 = realImageLoader;
        this.$request = imageRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RealImageLoader$enqueue$job$1(this.this$0, this.$request, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Logger logger;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.b(obj);
            RealImageLoader realImageLoader = this.this$0;
            ImageRequest imageRequest = this.$request;
            this.label = 1;
            obj = realImageLoader.execute(imageRequest, 0, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        RealImageLoader realImageLoader2 = this.this$0;
        ImageResult imageResult = (ImageResult) obj;
        if ((imageResult instanceof ErrorResult) && (logger = realImageLoader2.getOptions().getLogger()) != null) {
            LoggingKt.log(logger, "RealImageLoader", ((ErrorResult) imageResult).getThrowable());
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImageResult> continuation) {
        return ((RealImageLoader$enqueue$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f53572a);
    }
}
