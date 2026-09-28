package coil3.network;

import android.content.Context;
import coil3.ImageLoader;
import coil3.Uri;
import coil3.annotation.InternalCoilApi;
import coil3.d;
import coil3.decode.DataSource;
import coil3.decode.ImageSource;
import coil3.decode.ImageSourceKt;
import coil3.disk.DiskCache;
import coil3.fetch.Fetcher;
import coil3.fetch.SourceFetchResult;
import coil3.network.NetworkHeaders;
import coil3.network.internal.SingleParameterLazy;
import coil3.network.internal.SingleParameterLazyKt;
import coil3.network.internal.UtilsKt;
import coil3.network.internal.Utils_androidKt;
import coil3.request.Options;
import coil3.util.MimeTypeMap;
import defpackage.b;
import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.FileSystem;
import okio.Okio;
import okio.RealBufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xbill.DNS.WKSRecord;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class NetworkFetcher implements Fetcher {

    @NotNull
    private final Lazy<CacheStrategy> cacheStrategy;

    @NotNull
    private final ConnectivityChecker connectivityChecker;

    @NotNull
    private final Lazy<DiskCache> diskCache;

    @NotNull
    private final Lazy<NetworkClient> networkClient;

    @NotNull
    private final Options options;

    @NotNull
    private final String url;

    @Metadata
    public static final class Factory implements Fetcher.Factory<Uri> {

        @NotNull
        private final Lazy<CacheStrategy> cacheStrategyLazy;

        @NotNull
        private final SingleParameterLazy<Context, ConnectivityChecker> connectivityCheckerLazy;

        @NotNull
        private final Lazy<NetworkClient> networkClientLazy;

        @Metadata
        /* renamed from: coil3.network.NetworkFetcher$Factory$2, reason: invalid class name */
        public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Context, ConnectivityChecker> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            public AnonymousClass2() {
                super(1, ConnectivityCheckerKt.class, "ConnectivityChecker", "ConnectivityChecker(Landroid/content/Context;)Lcoil3/network/ConnectivityChecker;", 1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ConnectivityChecker invoke(Context context) {
                return ConnectivityCheckerKt.ConnectivityChecker(context);
            }
        }

        public Factory(@NotNull Function0<? extends NetworkClient> function0, @NotNull Function0<? extends CacheStrategy> function02, @NotNull Function1<? super Context, ? extends ConnectivityChecker> function1) {
            this.networkClientLazy = LazyKt.b(function0);
            this.cacheStrategyLazy = LazyKt.b(function02);
            this.connectivityCheckerLazy = SingleParameterLazyKt.singleParameterLazy(function1);
        }

        private final boolean isApplicable(Uri uri) {
            return Intrinsics.b(uri.getScheme(), "http") || Intrinsics.b(uri.getScheme(), "https");
        }

        @Override // coil3.fetch.Fetcher.Factory
        @Nullable
        public Fetcher create(@NotNull Uri uri, @NotNull Options options, @NotNull ImageLoader imageLoader) {
            if (isApplicable(uri)) {
                return new NetworkFetcher(uri.toString(), options, this.networkClientLazy, LazyKt.b(new b(imageLoader, 4)), this.cacheStrategyLazy, this.connectivityCheckerLazy.get(options.getContext()));
            }
            return null;
        }

        public /* synthetic */ Factory(Function0 function0, Function0 function02, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(function0, (i2 & 2) != 0 ? new d(3) : function02, (i2 & 4) != 0 ? AnonymousClass2.INSTANCE : function1);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata
    @DebugMetadata(c = "coil3.network.NetworkFetcher$executeNetworkRequest$2", f = "NetworkFetcher.kt", l = {207}, m = "invokeSuspend")
    /* renamed from: coil3.network.NetworkFetcher$executeNetworkRequest$2, reason: invalid class name */
    public static final class AnonymousClass2<T> extends SuspendLambda implements Function2<NetworkResponse, Continuation<? super T>, Object> {
        final /* synthetic */ Function2<NetworkResponse, Continuation<? super T>, Object> $block;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$block, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(NetworkResponse networkResponse, Continuation<? super T> continuation) {
            return ((AnonymousClass2) create(networkResponse, continuation)).invokeSuspend(Unit.f53572a);
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
            NetworkResponse networkResponse = (NetworkResponse) this.L$0;
            int code = networkResponse.getCode();
            if ((200 > code || code >= 300) && networkResponse.getCode() != 304) {
                throw new HttpException(networkResponse);
            }
            Function2<NetworkResponse, Continuation<? super T>, Object> function2 = this.$block;
            this.label = 1;
            Object objInvoke = function2.invoke(networkResponse, this);
            return objInvoke == coroutineSingletons ? coroutineSingletons : objInvoke;
        }
    }

    @Metadata
    @DebugMetadata(c = "coil3.network.NetworkFetcher", f = "NetworkFetcher.kt", l = {64, 77, 105}, m = "fetch")
    /* renamed from: coil3.network.NetworkFetcher$fetch$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
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
            return NetworkFetcher.this.fetch(this);
        }
    }

    @Metadata
    @DebugMetadata(c = "coil3.network.NetworkFetcher$fetch$2", f = "NetworkFetcher.kt", l = {107}, m = "invokeSuspend")
    /* renamed from: coil3.network.NetworkFetcher$fetch$2, reason: invalid class name and case insensitive filesystem */
    /* loaded from: classes3.dex */
    public static final class C00832 extends SuspendLambda implements Function2<NetworkResponse, Continuation<? super SourceFetchResult>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public C00832(Continuation<? super C00832> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00832 c00832 = NetworkFetcher.this.new C00832(continuation);
            c00832.L$0 = obj;
            return c00832;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(NetworkResponse networkResponse, Continuation<? super SourceFetchResult> continuation) {
            return ((C00832) create(networkResponse, continuation)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            NetworkResponse networkResponse;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.b(obj);
                NetworkResponse networkResponse2 = (NetworkResponse) this.L$0;
                NetworkFetcher networkFetcher = NetworkFetcher.this;
                NetworkResponseBody networkResponseBodyRequireBody = UtilsKt.requireBody(networkResponse2);
                this.L$0 = networkResponse2;
                this.label = 1;
                Object imageSource = networkFetcher.toImageSource(networkResponseBodyRequireBody, this);
                if (imageSource == coroutineSingletons) {
                    return coroutineSingletons;
                }
                networkResponse = networkResponse2;
                obj = imageSource;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                networkResponse = (NetworkResponse) this.L$0;
                ResultKt.b(obj);
            }
            NetworkFetcher networkFetcher2 = NetworkFetcher.this;
            return new SourceFetchResult((ImageSource) obj, networkFetcher2.getMimeType(networkFetcher2.url, networkResponse.getHeaders().get(UtilsKt.CONTENT_TYPE)), DataSource.NETWORK);
        }
    }

    @Metadata
    @DebugMetadata(c = "coil3.network.NetworkFetcher", f = "NetworkFetcher.kt", l = {247}, m = "toImageSource")
    /* renamed from: coil3.network.NetworkFetcher$toImageSource$1, reason: invalid class name and case insensitive filesystem */
    /* loaded from: classes3.dex */
    public static final class C00841 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C00841(Continuation<? super C00841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NetworkFetcher.this.toImageSource(null, this);
        }
    }

    @Metadata
    @DebugMetadata(c = "coil3.network.NetworkFetcher", f = "NetworkFetcher.kt", l = {WKSRecord.Service.EMFIS_CNTL, 156}, m = "writeToDiskCache")
    /* renamed from: coil3.network.NetworkFetcher$writeToDiskCache$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00851 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C00851(Continuation<? super C00851> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NetworkFetcher.this.writeToDiskCache(null, null, null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NetworkFetcher(@NotNull String str, @NotNull Options options, @NotNull Lazy<? extends NetworkClient> lazy, @NotNull Lazy<? extends DiskCache> lazy2, @NotNull Lazy<? extends CacheStrategy> lazy3, @NotNull ConnectivityChecker connectivityChecker) {
        this.url = str;
        this.options = options;
        this.networkClient = lazy;
        this.diskCache = lazy2;
        this.cacheStrategy = lazy3;
        this.connectivityChecker = connectivityChecker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> Object executeNetworkRequest(NetworkRequest networkRequest, Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        if (this.options.getNetworkCachePolicy().getReadEnabled()) {
            Utils_androidKt.assertNotOnMainThread();
        }
        return ((NetworkClient) this.networkClient.getValue()).executeRequest(networkRequest, new AnonymousClass2(function2, null), continuation);
    }

    private final String getDiskCacheKey() {
        String diskCacheKey = this.options.getDiskCacheKey();
        return diskCacheKey == null ? this.url : diskCacheKey;
    }

    private final FileSystem getFileSystem() {
        FileSystem fileSystem;
        DiskCache diskCache = (DiskCache) this.diskCache.getValue();
        return (diskCache == null || (fileSystem = diskCache.getFileSystem()) == null) ? this.options.getFileSystem() : fileSystem;
    }

    private final NetworkRequest newRequest() {
        NetworkHeaders.Builder builderNewBuilder = ImageRequestsKt.getHttpHeaders(this.options).newBuilder();
        boolean readEnabled = this.options.getDiskCachePolicy().getReadEnabled();
        boolean z = this.options.getNetworkCachePolicy().getReadEnabled() && this.connectivityChecker.isOnline();
        if (!z && readEnabled) {
            builderNewBuilder.set(UtilsKt.CACHE_CONTROL, "only-if-cached, max-stale=2147483647");
        } else if (!z || readEnabled) {
            if (!z && !readEnabled) {
                builderNewBuilder.set(UtilsKt.CACHE_CONTROL, "no-cache, only-if-cached");
            }
        } else if (this.options.getDiskCachePolicy().getWriteEnabled()) {
            builderNewBuilder.set(UtilsKt.CACHE_CONTROL, "no-cache");
        } else {
            builderNewBuilder.set(UtilsKt.CACHE_CONTROL, "no-cache, no-store");
        }
        return new NetworkRequest(this.url, ImageRequestsKt.getHttpMethod(this.options), builderNewBuilder.build(), ImageRequestsKt.getHttpBody(this.options));
    }

    private final DiskCache.Snapshot readFromDiskCache() {
        DiskCache diskCache;
        if (!this.options.getDiskCachePolicy().getReadEnabled() || (diskCache = (DiskCache) this.diskCache.getValue()) == null) {
            return null;
        }
        return diskCache.openSnapshot(getDiskCacheKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageSource toImageSource(DiskCache.Snapshot snapshot) {
        return ImageSourceKt.ImageSource$default(snapshot.getData(), getFileSystem(), getDiskCacheKey(), snapshot, null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NetworkResponse toNetworkResponseOrNull(DiskCache.Snapshot snapshot) throws Throwable {
        Throwable th;
        NetworkResponse from;
        try {
            RealBufferedSource realBufferedSourceD = Okio.d(getFileSystem().source(snapshot.getMetadata()));
            try {
                from = CacheNetworkResponse.INSTANCE.readFrom(realBufferedSourceD);
                try {
                    realBufferedSourceD.close();
                    th = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                try {
                    realBufferedSourceD.close();
                } catch (Throwable th4) {
                    ExceptionsKt.a(th3, th4);
                }
                th = th3;
                from = null;
            }
            if (th == null) {
                return from;
            }
            throw th;
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00fb, code lost:
    
        if (r0.writeTo(r14, r3, r7) == r1) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeToDiskCache(coil3.disk.DiskCache.Snapshot r12, coil3.network.NetworkResponse r13, coil3.network.NetworkRequest r14, coil3.network.NetworkResponse r15, kotlin.coroutines.Continuation<? super coil3.disk.DiskCache.Snapshot> r16) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.NetworkFetcher.writeToDiskCache(coil3.disk.DiskCache$Snapshot, coil3.network.NetworkResponse, coil3.network.NetworkRequest, coil3.network.NetworkResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014d A[Catch: Exception -> 0x004d, TRY_LEAVE, TryCatch #0 {Exception -> 0x004d, blocks: (B:21:0x0048, B:67:0x0149, B:69:0x014d), top: B:79:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[SYNTHETIC] */
    @Override // coil3.fetch.Fetcher
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object fetch(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super coil3.fetch.FetchResult> r14) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.NetworkFetcher.fetch(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @InternalCoilApi
    @Nullable
    public final String getMimeType(@NotNull String str, @Nullable String str2) {
        String mimeTypeFromUrl;
        if ((str2 == null || StringsKt.O(str2, UtilsKt.MIME_TYPE_TEXT_PLAIN, false)) && (mimeTypeFromUrl = MimeTypeMap.INSTANCE.getMimeTypeFromUrl(str)) != null) {
            return mimeTypeFromUrl;
        }
        if (str2 != null) {
            return StringsKt.U(str2, ';');
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object toImageSource(coil3.network.NetworkResponseBody r5, kotlin.coroutines.Continuation<? super coil3.decode.ImageSource> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof coil3.network.NetworkFetcher.C00841
            if (r0 == 0) goto L13
            r0 = r6
            coil3.network.NetworkFetcher$toImageSource$1 r0 = (coil3.network.NetworkFetcher.C00841) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            coil3.network.NetworkFetcher$toImageSource$1 r0 = new coil3.network.NetworkFetcher$toImageSource$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r5 = r0.L$1
            okio.Buffer r5 = (okio.Buffer) r5
            java.lang.Object r0 = r0.L$0
            coil3.network.NetworkFetcher r0 = (coil3.network.NetworkFetcher) r0
            kotlin.ResultKt.b(r6)
            goto L4e
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.b(r6)
            okio.Buffer r6 = new okio.Buffer
            r6.<init>()
            r0.L$0 = r4
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r5 = r5.writeTo(r6, r0)
            if (r5 != r1) goto L4c
            return r1
        L4c:
            r0 = r4
            r5 = r6
        L4e:
            okio.FileSystem r6 = r0.getFileSystem()
            r0 = 4
            r1 = 0
            coil3.decode.ImageSource r5 = coil3.decode.ImageSourceKt.ImageSource$default(r5, r6, r1, r0, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.NetworkFetcher.toImageSource(coil3.network.NetworkResponseBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageSource toImageSource(Buffer buffer) {
        return ImageSourceKt.ImageSource$default(buffer, getFileSystem(), null, 4, null);
    }
}
