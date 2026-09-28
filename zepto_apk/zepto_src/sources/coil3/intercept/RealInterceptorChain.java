package coil3.intercept;

import coil3.EventListener;
import coil3.intercept.Interceptor;
import coil3.request.ImageRequest;
import coil3.request.NullRequestData;
import coil3.size.Size;
import coil3.size.SizeResolver;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class RealInterceptorChain implements Interceptor.Chain {

    @NotNull
    private final EventListener eventListener;
    private final int index;

    @NotNull
    private final ImageRequest initialRequest;

    @NotNull
    private final List<Interceptor> interceptors;
    private final boolean isPlaceholderCached;

    @NotNull
    private final ImageRequest request;

    @NotNull
    private final Size size;

    @NotNull
    private final SizeResolver sizeResolver;

    @Metadata
    @DebugMetadata(c = "coil3.intercept.RealInterceptorChain", f = "RealInterceptorChain.kt", l = {33}, m = "proceed")
    /* renamed from: coil3.intercept.RealInterceptorChain$proceed$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RealInterceptorChain.this.proceed(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RealInterceptorChain(@NotNull ImageRequest imageRequest, @NotNull List<? extends Interceptor> list, int i2, @NotNull ImageRequest imageRequest2, @NotNull Size size, @NotNull SizeResolver sizeResolver, @NotNull EventListener eventListener, boolean z) {
        this.initialRequest = imageRequest;
        this.interceptors = list;
        this.index = i2;
        this.request = imageRequest2;
        this.size = size;
        this.sizeResolver = sizeResolver;
        this.eventListener = eventListener;
        this.isPlaceholderCached = z;
    }

    private final void checkRequest(ImageRequest imageRequest, Interceptor interceptor) {
        if (imageRequest.getContext() != this.initialRequest.getContext()) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's context.").toString());
        }
        if (imageRequest.getData() == NullRequestData.INSTANCE) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot set the request's data to null.").toString());
        }
        if (imageRequest.getTarget() != this.initialRequest.getTarget()) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's target.").toString());
        }
        if (imageRequest.getSizeResolver() == this.initialRequest.getSizeResolver()) {
            return;
        }
        throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's size resolver. Use `Interceptor.Chain.withSize` instead.").toString());
    }

    private final RealInterceptorChain copy(int i2, ImageRequest imageRequest, Size size) {
        return new RealInterceptorChain(this.initialRequest, this.interceptors, i2, imageRequest, size, this.sizeResolver, this.eventListener, this.isPlaceholderCached);
    }

    public static /* synthetic */ RealInterceptorChain copy$default(RealInterceptorChain realInterceptorChain, int i2, ImageRequest imageRequest, Size size, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = realInterceptorChain.index;
        }
        if ((i3 & 2) != 0) {
            imageRequest = realInterceptorChain.getRequest();
        }
        if ((i3 & 4) != 0) {
            size = realInterceptorChain.getSize();
        }
        return realInterceptorChain.copy(i2, imageRequest, size);
    }

    @NotNull
    public final EventListener getEventListener() {
        return this.eventListener;
    }

    public final int getIndex() {
        return this.index;
    }

    @NotNull
    public final ImageRequest getInitialRequest() {
        return this.initialRequest;
    }

    @NotNull
    public final List<Interceptor> getInterceptors() {
        return this.interceptors;
    }

    @Override // coil3.intercept.Interceptor.Chain
    @NotNull
    public ImageRequest getRequest() {
        return this.request;
    }

    @Override // coil3.intercept.Interceptor.Chain
    @NotNull
    public Size getSize() {
        return this.size;
    }

    @NotNull
    public final SizeResolver getSizeResolver() {
        return this.sizeResolver;
    }

    public final boolean isPlaceholderCached() {
        return this.isPlaceholderCached;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // coil3.intercept.Interceptor.Chain
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object proceed(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super coil3.request.ImageResult> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof coil3.intercept.RealInterceptorChain.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r11
            coil3.intercept.RealInterceptorChain$proceed$1 r0 = (coil3.intercept.RealInterceptorChain.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            coil3.intercept.RealInterceptorChain$proceed$1 r0 = new coil3.intercept.RealInterceptorChain$proceed$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r1 = r0.L$1
            coil3.intercept.Interceptor r1 = (coil3.intercept.Interceptor) r1
            java.lang.Object r0 = r0.L$0
            coil3.intercept.RealInterceptorChain r0 = (coil3.intercept.RealInterceptorChain) r0
            kotlin.ResultKt.b(r11)
            r4 = r10
            goto L62
        L30:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L38:
            kotlin.ResultKt.b(r11)
            java.util.List<coil3.intercept.Interceptor> r11 = r10.interceptors
            int r2 = r10.index
            java.lang.Object r11 = r11.get(r2)
            coil3.intercept.Interceptor r11 = (coil3.intercept.Interceptor) r11
            int r2 = r10.index
            int r5 = r2 + 1
            r8 = 6
            r9 = 0
            r6 = 0
            r7 = 0
            r4 = r10
            coil3.intercept.RealInterceptorChain r2 = copy$default(r4, r5, r6, r7, r8, r9)
            r0.L$0 = r4
            r0.L$1 = r11
            r0.label = r3
            java.lang.Object r0 = r11.intercept(r2, r0)
            if (r0 != r1) goto L5f
            return r1
        L5f:
            r1 = r11
            r11 = r0
            r0 = r4
        L62:
            coil3.request.ImageResult r11 = (coil3.request.ImageResult) r11
            coil3.request.ImageRequest r2 = r11.getRequest()
            r0.checkRequest(r2, r1)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.intercept.RealInterceptorChain.proceed(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // coil3.intercept.Interceptor.Chain
    @NotNull
    public Interceptor.Chain withRequest(@NotNull ImageRequest imageRequest) {
        int i2 = this.index;
        if (i2 > 0) {
            checkRequest(imageRequest, this.interceptors.get(i2 - 1));
        }
        return copy$default(this, 0, imageRequest, null, 5, null);
    }

    @Override // coil3.intercept.Interceptor.Chain
    @NotNull
    public Interceptor.Chain withSize(@NotNull Size size) {
        return copy$default(this, 0, null, size, 3, null);
    }
}
