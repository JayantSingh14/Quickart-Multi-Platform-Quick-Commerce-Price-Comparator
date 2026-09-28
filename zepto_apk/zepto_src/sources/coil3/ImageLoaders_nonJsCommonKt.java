package coil3;

import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class ImageLoaders_nonJsCommonKt {

    @Metadata
    @DebugMetadata(c = "coil3.ImageLoaders_nonJsCommonKt$executeBlocking$1", f = "imageLoaders.nonJsCommon.kt", l = {15}, m = "invokeSuspend")
    /* renamed from: coil3.ImageLoaders_nonJsCommonKt$executeBlocking$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageResult>, Object> {
        final /* synthetic */ ImageRequest $request;
        final /* synthetic */ ImageLoader $this_executeBlocking;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ImageLoader imageLoader, ImageRequest imageRequest, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_executeBlocking = imageLoader;
            this.$request = imageRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_executeBlocking, this.$request, continuation);
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
            ImageLoader imageLoader = this.$this_executeBlocking;
            ImageRequest imageRequest = this.$request;
            this.label = 1;
            Object objExecute = imageLoader.execute(imageRequest, this);
            return objExecute == coroutineSingletons ? coroutineSingletons : objExecute;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImageResult> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f53572a);
        }
    }

    @NotNull
    public static final ImageResult executeBlocking(@NotNull ImageLoader imageLoader, @NotNull ImageRequest imageRequest) {
        return (ImageResult) BuildersKt.d(new AnonymousClass1(imageLoader, imageRequest, null));
    }
}
