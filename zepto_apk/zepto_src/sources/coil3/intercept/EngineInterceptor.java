package coil3.intercept;

import androidx.fragment.app.e;
import coil3.EventListener;
import coil3.Image;
import coil3.ImageLoader;
import coil3.decode.DataSource;
import coil3.intercept.Interceptor;
import coil3.memory.MemoryCache;
import coil3.memory.MemoryCacheService;
import coil3.request.ImageRequest;
import coil3.request.Options;
import coil3.request.RequestService;
import coil3.request.SuccessResult;
import coil3.util.Logger;
import coil3.util.SystemCallbacks;
import coil3.util.UtilsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xbill.DNS.WKSRecord;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class EngineInterceptor implements Interceptor {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final String TAG = "EngineInterceptor";

    @NotNull
    private final ImageLoader imageLoader;

    @Nullable
    private final Logger logger;

    @NotNull
    private final MemoryCacheService memoryCacheService;

    @NotNull
    private final RequestService requestService;

    @NotNull
    private final SystemCallbacks systemCallbacks;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata
    public static final class ExecuteResult {

        @NotNull
        private final DataSource dataSource;

        @Nullable
        private final String diskCacheKey;

        @NotNull
        private final Image image;
        private final boolean isSampled;

        public ExecuteResult(@NotNull Image image, boolean z, @NotNull DataSource dataSource, @Nullable String str) {
            this.image = image;
            this.isSampled = z;
            this.dataSource = dataSource;
            this.diskCacheKey = str;
        }

        public static /* synthetic */ ExecuteResult copy$default(ExecuteResult executeResult, Image image, boolean z, DataSource dataSource, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                image = executeResult.image;
            }
            if ((i2 & 2) != 0) {
                z = executeResult.isSampled;
            }
            if ((i2 & 4) != 0) {
                dataSource = executeResult.dataSource;
            }
            if ((i2 & 8) != 0) {
                str = executeResult.diskCacheKey;
            }
            return executeResult.copy(image, z, dataSource, str);
        }

        @NotNull
        public final Image component1() {
            return this.image;
        }

        public final boolean component2() {
            return this.isSampled;
        }

        @NotNull
        public final DataSource component3() {
            return this.dataSource;
        }

        @Nullable
        public final String component4() {
            return this.diskCacheKey;
        }

        @NotNull
        public final ExecuteResult copy(@NotNull Image image, boolean z, @NotNull DataSource dataSource, @Nullable String str) {
            return new ExecuteResult(image, z, dataSource, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ExecuteResult)) {
                return false;
            }
            ExecuteResult executeResult = (ExecuteResult) obj;
            return Intrinsics.b(this.image, executeResult.image) && this.isSampled == executeResult.isSampled && this.dataSource == executeResult.dataSource && Intrinsics.b(this.diskCacheKey, executeResult.diskCacheKey);
        }

        @NotNull
        public final DataSource getDataSource() {
            return this.dataSource;
        }

        @Nullable
        public final String getDiskCacheKey() {
            return this.diskCacheKey;
        }

        @NotNull
        public final Image getImage() {
            return this.image;
        }

        public int hashCode() {
            int iHashCode = (this.dataSource.hashCode() + ((Boolean.hashCode(this.isSampled) + (this.image.hashCode() * 31)) * 31)) * 31;
            String str = this.diskCacheKey;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public final boolean isSampled() {
            return this.isSampled;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("ExecuteResult(image=");
            sb.append(this.image);
            sb.append(", isSampled=");
            sb.append(this.isSampled);
            sb.append(", dataSource=");
            sb.append(this.dataSource);
            sb.append(", diskCacheKey=");
            return e.t(sb, this.diskCacheKey, ')');
        }
    }

    @Metadata
    @DebugMetadata(c = "coil3.intercept.EngineInterceptor", f = "EngineInterceptor.kt", l = {191}, m = "decode")
    /* renamed from: coil3.intercept.EngineInterceptor$decode$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
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
            return EngineInterceptor.this.decode(null, null, null, null, null, null, this);
        }
    }

    @Metadata
    @DebugMetadata(c = "coil3.intercept.EngineInterceptor", f = "EngineInterceptor.kt", l = {116, 120, WKSRecord.Service.NETBIOS_DGM}, m = "execute")
    /* renamed from: coil3.intercept.EngineInterceptor$execute$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00801 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public C00801(Continuation<? super C00801> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.this.execute(null, null, null, null, this);
        }
    }

    @Metadata
    @DebugMetadata(c = "coil3.intercept.EngineInterceptor", f = "EngineInterceptor.kt", l = {157}, m = "fetch")
    /* renamed from: coil3.intercept.EngineInterceptor$fetch$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00811 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public C00811(Continuation<? super C00811> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.this.fetch(null, null, null, null, null, this);
        }
    }

    @Metadata
    @DebugMetadata(c = "coil3.intercept.EngineInterceptor", f = "EngineInterceptor.kt", l = {65}, m = "intercept")
    /* renamed from: coil3.intercept.EngineInterceptor$intercept$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00821 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C00821(Continuation<? super C00821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.this.intercept(null, this);
        }
    }

    @Metadata
    @DebugMetadata(c = "coil3.intercept.EngineInterceptor$intercept$2", f = "EngineInterceptor.kt", l = {67}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: coil3.intercept.EngineInterceptor$intercept$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SuccessResult>, Object> {
        final /* synthetic */ MemoryCache.Key $cacheKey;
        final /* synthetic */ Interceptor.Chain $chain;
        final /* synthetic */ EventListener $eventListener;
        final /* synthetic */ Object $mappedData;
        final /* synthetic */ Options $options;
        final /* synthetic */ ImageRequest $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, MemoryCache.Key key, Interceptor.Chain chain, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$request = imageRequest;
            this.$mappedData = obj;
            this.$options = options;
            this.$eventListener = eventListener;
            this.$cacheKey = key;
            this.$chain = chain;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EngineInterceptor.this.new AnonymousClass2(this.$request, this.$mappedData, this.$options, this.$eventListener, this.$cacheKey, this.$chain, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objExecute;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.b(obj);
                EngineInterceptor engineInterceptor = EngineInterceptor.this;
                ImageRequest imageRequest = this.$request;
                Object obj2 = this.$mappedData;
                Options options = this.$options;
                EventListener eventListener = this.$eventListener;
                this.label = 1;
                objExecute = engineInterceptor.execute(imageRequest, obj2, options, eventListener, this);
                if (objExecute == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                objExecute = obj;
            }
            ExecuteResult executeResult = (ExecuteResult) objExecute;
            EngineInterceptor.this.systemCallbacks.registerMemoryPressureCallbacks();
            boolean cacheValue = EngineInterceptor.this.memoryCacheService.setCacheValue(this.$cacheKey, this.$request, executeResult);
            Image image = executeResult.getImage();
            ImageRequest imageRequest2 = this.$request;
            DataSource dataSource = executeResult.getDataSource();
            MemoryCache.Key key = this.$cacheKey;
            if (!cacheValue) {
                key = null;
            }
            return new SuccessResult(image, imageRequest2, dataSource, key, executeResult.getDiskCacheKey(), executeResult.isSampled(), UtilsKt.isPlaceholderCached(this.$chain));
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SuccessResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f53572a);
        }
    }

    public EngineInterceptor(@NotNull ImageLoader imageLoader, @NotNull SystemCallbacks systemCallbacks, @NotNull RequestService requestService, @Nullable Logger logger) {
        this.imageLoader = imageLoader;
        this.systemCallbacks = systemCallbacks;
        this.requestService = requestService;
        this.logger = logger;
        this.memoryCacheService = new MemoryCacheService(imageLoader, requestService, logger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0091 -> B:21:0x0098). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object decode(coil3.fetch.SourceFetchResult r8, coil3.ComponentRegistry r9, coil3.request.ImageRequest r10, java.lang.Object r11, coil3.request.Options r12, coil3.EventListener r13, kotlin.coroutines.Continuation<? super coil3.intercept.EngineInterceptor.ExecuteResult> r14) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.intercept.EngineInterceptor.decode(coil3.fetch.SourceFetchResult, coil3.ComponentRegistry, coil3.request.ImageRequest, java.lang.Object, coil3.request.Options, coil3.EventListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01c7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object execute(coil3.request.ImageRequest r24, java.lang.Object r25, coil3.request.Options r26, coil3.EventListener r27, kotlin.coroutines.Continuation<? super coil3.intercept.EngineInterceptor.ExecuteResult> r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.intercept.EngineInterceptor.execute(coil3.request.ImageRequest, java.lang.Object, coil3.request.Options, coil3.EventListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0096 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x008b -> B:21:0x008f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fetch(coil3.ComponentRegistry r8, coil3.request.ImageRequest r9, java.lang.Object r10, coil3.request.Options r11, coil3.EventListener r12, kotlin.coroutines.Continuation<? super coil3.fetch.FetchResult> r13) {
        /*
            Method dump skipped, instructions count: 191
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.intercept.EngineInterceptor.fetch(coil3.ComponentRegistry, coil3.request.ImageRequest, java.lang.Object, coil3.request.Options, coil3.EventListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // coil3.intercept.Interceptor
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object intercept(@org.jetbrains.annotations.NotNull coil3.intercept.Interceptor.Chain r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super coil3.request.ImageResult> r15) throws java.lang.Throwable {
        /*
            r13 = this;
            boolean r0 = r15 instanceof coil3.intercept.EngineInterceptor.C00821
            if (r0 == 0) goto L13
            r0 = r15
            coil3.intercept.EngineInterceptor$intercept$1 r0 = (coil3.intercept.EngineInterceptor.C00821) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            coil3.intercept.EngineInterceptor$intercept$1 r0 = new coil3.intercept.EngineInterceptor$intercept$1
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r14 = r0.L$0
            coil3.intercept.Interceptor$Chain r14 = (coil3.intercept.Interceptor.Chain) r14
            kotlin.ResultKt.b(r15)     // Catch: java.lang.Throwable -> L2b
            return r15
        L2b:
            r0 = move-exception
        L2c:
            r15 = r0
            goto La0
        L2f:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L37:
            kotlin.ResultKt.b(r15)
            coil3.request.ImageRequest r6 = r14.getRequest()     // Catch: java.lang.Throwable -> L9d
            java.lang.Object r15 = r6.getData()     // Catch: java.lang.Throwable -> L9d
            coil3.size.Size r2 = r14.getSize()     // Catch: java.lang.Throwable -> L9d
            coil3.size.SizeResolver r4 = coil3.util.UtilsKt.getSizeResolver(r14)     // Catch: java.lang.Throwable -> L9d
            coil3.EventListener r9 = coil3.util.UtilsKt.getEventListener(r14)     // Catch: java.lang.Throwable -> L9d
            coil3.request.RequestService r5 = r13.requestService     // Catch: java.lang.Throwable -> L9d
            coil3.request.Options r8 = r5.options(r6, r4, r2)     // Catch: java.lang.Throwable -> L9d
            coil3.size.Scale r4 = r8.getScale()     // Catch: java.lang.Throwable -> L9d
            r9.mapStart(r6, r15)     // Catch: java.lang.Throwable -> L9d
            coil3.ImageLoader r5 = r13.imageLoader     // Catch: java.lang.Throwable -> L9d
            coil3.ComponentRegistry r5 = r5.getComponents()     // Catch: java.lang.Throwable -> L9d
            java.lang.Object r7 = r5.map(r15, r8)     // Catch: java.lang.Throwable -> L9d
            r9.mapEnd(r6, r7)     // Catch: java.lang.Throwable -> L9d
            coil3.memory.MemoryCacheService r15 = r13.memoryCacheService     // Catch: java.lang.Throwable -> L9d
            coil3.memory.MemoryCache$Key r10 = r15.newCacheKey(r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L9d
            if (r10 == 0) goto L77
            coil3.memory.MemoryCacheService r15 = r13.memoryCacheService     // Catch: java.lang.Throwable -> L2b
            coil3.memory.MemoryCache$Value r15 = r15.getCacheValue(r6, r10, r2, r4)     // Catch: java.lang.Throwable -> L2b
            goto L78
        L77:
            r15 = 0
        L78:
            if (r15 == 0) goto L81
            coil3.memory.MemoryCacheService r0 = r13.memoryCacheService     // Catch: java.lang.Throwable -> L2b
            coil3.request.SuccessResult r14 = r0.newResult(r14, r6, r10, r15)     // Catch: java.lang.Throwable -> L2b
            return r14
        L81:
            kotlin.coroutines.CoroutineContext r15 = r6.getFetcherCoroutineContext()     // Catch: java.lang.Throwable -> L9d
            coil3.intercept.EngineInterceptor$intercept$2 r4 = new coil3.intercept.EngineInterceptor$intercept$2     // Catch: java.lang.Throwable -> L9d
            r12 = 0
            r5 = r13
            r11 = r14
            r4.<init>(r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L99
            r0.L$0 = r11     // Catch: java.lang.Throwable -> L99
            r0.label = r3     // Catch: java.lang.Throwable -> L99
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.e(r15, r4, r0)     // Catch: java.lang.Throwable -> L99
            if (r14 != r1) goto L98
            return r1
        L98:
            return r14
        L99:
            r0 = move-exception
            r15 = r0
            r14 = r11
            goto La0
        L9d:
            r0 = move-exception
            r11 = r14
            goto L2c
        La0:
            boolean r0 = r15 instanceof java.util.concurrent.CancellationException
            if (r0 != 0) goto Lad
            coil3.request.ImageRequest r14 = r14.getRequest()
            coil3.request.ErrorResult r14 = coil3.util.UtilsKt.ErrorResult(r14, r15)
            return r14
        Lad:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.intercept.EngineInterceptor.intercept(coil3.intercept.Interceptor$Chain, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
