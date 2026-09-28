package coil3;

import android.content.Context;
import coil3.EventListener;
import coil3.ImageLoader;
import coil3.disk.DiskCache;
import coil3.intercept.EngineInterceptor;
import coil3.memory.MemoryCache;
import coil3.request.Disposable;
import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import coil3.request.RequestService;
import coil3.request.RequestService_androidKt;
import coil3.util.Logger;
import coil3.util.SystemCallbacks;
import coil3.util.SystemCallbacksKt;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xbill.DNS.WKSRecord;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class RealImageLoader implements ImageLoader {
    private static final /* synthetic */ AtomicIntegerFieldUpdater shutdown$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(RealImageLoader.class, "shutdown$volatile");

    @NotNull
    private final ComponentRegistry components;

    @NotNull
    private final Options options;

    @NotNull
    private final RequestService requestService;

    @NotNull
    private final CoroutineScope scope;
    private volatile /* synthetic */ int shutdown$volatile;

    @NotNull
    private final SystemCallbacks systemCallbacks;

    @Metadata
    public static final class Options {

        @NotNull
        private final Context application;

        @NotNull
        private final ComponentRegistry componentRegistry;

        @NotNull
        private final ImageRequest.Defaults defaults;

        @NotNull
        private final Lazy<DiskCache> diskCacheLazy;

        @NotNull
        private final EventListener.Factory eventListenerFactory;

        @Nullable
        private final Logger logger;

        @NotNull
        private final Lazy<MemoryCache> memoryCacheLazy;

        /* JADX WARN: Multi-variable type inference failed */
        public Options(@NotNull Context context, @NotNull ImageRequest.Defaults defaults, @NotNull Lazy<? extends MemoryCache> lazy, @NotNull Lazy<? extends DiskCache> lazy2, @NotNull EventListener.Factory factory, @NotNull ComponentRegistry componentRegistry, @Nullable Logger logger) {
            this.application = context;
            this.defaults = defaults;
            this.memoryCacheLazy = lazy;
            this.diskCacheLazy = lazy2;
            this.eventListenerFactory = factory;
            this.componentRegistry = componentRegistry;
            this.logger = logger;
        }

        public static /* synthetic */ Options copy$default(Options options, Context context, ImageRequest.Defaults defaults, Lazy lazy, Lazy lazy2, EventListener.Factory factory, ComponentRegistry componentRegistry, Logger logger, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                context = options.application;
            }
            if ((i2 & 2) != 0) {
                defaults = options.defaults;
            }
            if ((i2 & 4) != 0) {
                lazy = options.memoryCacheLazy;
            }
            if ((i2 & 8) != 0) {
                lazy2 = options.diskCacheLazy;
            }
            if ((i2 & 16) != 0) {
                factory = options.eventListenerFactory;
            }
            if ((i2 & 32) != 0) {
                componentRegistry = options.componentRegistry;
            }
            if ((i2 & 64) != 0) {
                logger = options.logger;
            }
            ComponentRegistry componentRegistry2 = componentRegistry;
            Logger logger2 = logger;
            EventListener.Factory factory2 = factory;
            Lazy lazy3 = lazy;
            return options.copy(context, defaults, lazy3, lazy2, factory2, componentRegistry2, logger2);
        }

        @NotNull
        public final Context component1() {
            return this.application;
        }

        @NotNull
        public final ImageRequest.Defaults component2() {
            return this.defaults;
        }

        @NotNull
        public final Lazy<MemoryCache> component3() {
            return this.memoryCacheLazy;
        }

        @NotNull
        public final Lazy<DiskCache> component4() {
            return this.diskCacheLazy;
        }

        @NotNull
        public final EventListener.Factory component5() {
            return this.eventListenerFactory;
        }

        @NotNull
        public final ComponentRegistry component6() {
            return this.componentRegistry;
        }

        @Nullable
        public final Logger component7() {
            return this.logger;
        }

        @NotNull
        public final Options copy(@NotNull Context context, @NotNull ImageRequest.Defaults defaults, @NotNull Lazy<? extends MemoryCache> lazy, @NotNull Lazy<? extends DiskCache> lazy2, @NotNull EventListener.Factory factory, @NotNull ComponentRegistry componentRegistry, @Nullable Logger logger) {
            return new Options(context, defaults, lazy, lazy2, factory, componentRegistry, logger);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Options)) {
                return false;
            }
            Options options = (Options) obj;
            return Intrinsics.b(this.application, options.application) && Intrinsics.b(this.defaults, options.defaults) && Intrinsics.b(this.memoryCacheLazy, options.memoryCacheLazy) && Intrinsics.b(this.diskCacheLazy, options.diskCacheLazy) && Intrinsics.b(this.eventListenerFactory, options.eventListenerFactory) && Intrinsics.b(this.componentRegistry, options.componentRegistry) && Intrinsics.b(this.logger, options.logger);
        }

        @NotNull
        public final Context getApplication() {
            return this.application;
        }

        @NotNull
        public final ComponentRegistry getComponentRegistry() {
            return this.componentRegistry;
        }

        @NotNull
        public final ImageRequest.Defaults getDefaults() {
            return this.defaults;
        }

        @NotNull
        public final Lazy<DiskCache> getDiskCacheLazy() {
            return this.diskCacheLazy;
        }

        @NotNull
        public final EventListener.Factory getEventListenerFactory() {
            return this.eventListenerFactory;
        }

        @Nullable
        public final Logger getLogger() {
            return this.logger;
        }

        @NotNull
        public final Lazy<MemoryCache> getMemoryCacheLazy() {
            return this.memoryCacheLazy;
        }

        public int hashCode() {
            int iHashCode = (this.componentRegistry.hashCode() + ((this.eventListenerFactory.hashCode() + ((this.diskCacheLazy.hashCode() + ((this.memoryCacheLazy.hashCode() + ((this.defaults.hashCode() + (this.application.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
            Logger logger = this.logger;
            return iHashCode + (logger == null ? 0 : logger.hashCode());
        }

        @NotNull
        public String toString() {
            return "Options(application=" + this.application + ", defaults=" + this.defaults + ", memoryCacheLazy=" + this.memoryCacheLazy + ", diskCacheLazy=" + this.diskCacheLazy + ", eventListenerFactory=" + this.eventListenerFactory + ", componentRegistry=" + this.componentRegistry + ", logger=" + this.logger + ')';
        }
    }

    @Metadata
    @DebugMetadata(c = "coil3.RealImageLoader$execute$2", f = "RealImageLoader.kt", l = {86}, m = "invokeSuspend")
    /* renamed from: coil3.RealImageLoader$execute$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageResult>, Object> {
        final /* synthetic */ ImageRequest $request;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RealImageLoader this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ImageRequest imageRequest, RealImageLoader realImageLoader, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$request = imageRequest;
            this.this$0 = realImageLoader;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$request, this.this$0, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
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
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            DefaultScheduler defaultScheduler = Dispatchers.f54091a;
            Deferred<ImageResult> job = RealImageLoader_androidKt.getDisposable(this.$request, BuildersKt.a(coroutineScope, MainDispatcherLoader.f55099a.O1(), new RealImageLoader$execute$2$job$1(this.this$0, this.$request, null), 2)).getJob();
            this.label = 1;
            Object objV = job.V(this);
            return objV == coroutineSingletons ? coroutineSingletons : objV;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImageResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f53572a);
        }
    }

    @Metadata
    @DebugMetadata(c = "coil3.RealImageLoader", f = "RealImageLoader.kt", l = {WKSRecord.Service.ERPC, WKSRecord.Service.STATSRV, WKSRecord.Service.NETBIOS_NS}, m = "execute")
    /* renamed from: coil3.RealImageLoader$execute$3, reason: invalid class name */
    public static final class AnonymousClass3 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RealImageLoader.this.execute(null, 0, this);
        }
    }

    public RealImageLoader(@NotNull Options options) {
        this.options = options;
        this.scope = RealImageLoaderKt.CoroutineScope(options.getLogger());
        SystemCallbacks SystemCallbacks = SystemCallbacksKt.SystemCallbacks(this);
        this.systemCallbacks = SystemCallbacks;
        RequestService RequestService = RequestService_androidKt.RequestService(this, SystemCallbacks, options.getLogger());
        this.requestService = RequestService;
        options.getMemoryCacheLazy();
        options.getDiskCacheLazy();
        this.components = RealImageLoaderKt.addCommonComponents(RealImageLoader_nonNativeKt.addAppleComponents(RealImageLoader_jvmCommonKt.addJvmComponents(RealImageLoader_androidKt.addAndroidComponents(RealImageLoaderKt.addServiceLoaderComponents(options.getComponentRegistry().newBuilder(), options), options), options), options)).add(new EngineInterceptor(this, SystemCallbacks, RequestService, options.getLogger())).build();
        this.shutdown$volatile = 0;
    }

    private final /* synthetic */ int getShutdown$volatile() {
        return this.shutdown$volatile;
    }

    private final void onCancel(ImageRequest imageRequest, EventListener eventListener) {
        Logger logger = this.options.getLogger();
        if (logger != null) {
            Logger.Level level = Logger.Level.Info;
            if (logger.getMinLevel().compareTo(level) <= 0) {
                logger.log("RealImageLoader", level, "🏗 Cancelled - " + imageRequest.getData(), null);
            }
        }
        eventListener.onCancel(imageRequest);
        ImageRequest.Listener listener = imageRequest.getListener();
        if (listener != null) {
            listener.onCancel(imageRequest);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void onError(coil3.request.ErrorResult r7, coil3.target.Target r8, coil3.EventListener r9) {
        /*
            r6 = this;
            coil3.request.ImageRequest r0 = r7.getRequest()
            coil3.RealImageLoader$Options r1 = r6.options
            coil3.util.Logger r1 = r1.getLogger()
            if (r1 == 0) goto L3c
            coil3.util.Logger$Level r2 = coil3.util.Logger.Level.Info
            coil3.util.Logger$Level r3 = r1.getMinLevel()
            int r3 = r3.compareTo(r2)
            if (r3 > 0) goto L3c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "🚨 Failed - "
            r3.<init>(r4)
            java.lang.Object r4 = r0.getData()
            r3.append(r4)
            java.lang.String r4 = " - "
            r3.append(r4)
            java.lang.Throwable r4 = r7.getThrowable()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r4 = 0
            java.lang.String r5 = "RealImageLoader"
            r1.log(r5, r2, r3, r4)
        L3c:
            boolean r1 = r8 instanceof coil3.transition.TransitionTarget
            if (r1 != 0) goto L43
            if (r8 == 0) goto L6f
            goto L56
        L43:
            coil3.request.ImageRequest r1 = r7.getRequest()
            coil3.transition.Transition$Factory r1 = coil3.request.ImageRequests_androidKt.getTransitionFactory(r1)
            r2 = r8
            coil3.transition.TransitionTarget r2 = (coil3.transition.TransitionTarget) r2
            coil3.transition.Transition r1 = r1.create(r2, r7)
            boolean r2 = r1 instanceof coil3.transition.NoneTransition
            if (r2 == 0) goto L5e
        L56:
            coil3.Image r1 = r7.getImage()
            r8.onError(r1)
            goto L6f
        L5e:
            coil3.request.ImageRequest r8 = r7.getRequest()
            r9.transitionStart(r8, r1)
            r1.transition()
            coil3.request.ImageRequest r8 = r7.getRequest()
            r9.transitionEnd(r8, r1)
        L6f:
            r9.onError(r0, r7)
            coil3.request.ImageRequest$Listener r8 = r0.getListener()
            if (r8 == 0) goto L7b
            r8.onError(r0, r7)
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.RealImageLoader.onError(coil3.request.ErrorResult, coil3.target.Target, coil3.EventListener):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void onSuccess(coil3.request.SuccessResult r7, coil3.target.Target r8, coil3.EventListener r9) {
        /*
            r6 = this;
            coil3.request.ImageRequest r0 = r7.getRequest()
            coil3.decode.DataSource r1 = r7.getDataSource()
            coil3.RealImageLoader$Options r2 = r6.options
            coil3.util.Logger r2 = r2.getLogger()
            if (r2 == 0) goto L4a
            coil3.util.Logger$Level r3 = coil3.util.Logger.Level.Info
            coil3.util.Logger$Level r4 = r2.getMinLevel()
            int r4 = r4.compareTo(r3)
            if (r4 > 0) goto L4a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = coil3.util.UtilsKt.getEmoji(r1)
            r4.append(r5)
            java.lang.String r5 = " Successful ("
            r4.append(r5)
            java.lang.String r1 = r1.name()
            r4.append(r1)
            java.lang.String r1 = ") - "
            r4.append(r1)
            java.lang.Object r1 = r0.getData()
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r4 = 0
            java.lang.String r5 = "RealImageLoader"
            r2.log(r5, r3, r1, r4)
        L4a:
            boolean r1 = r8 instanceof coil3.transition.TransitionTarget
            if (r1 != 0) goto L51
            if (r8 == 0) goto L7d
            goto L64
        L51:
            coil3.request.ImageRequest r1 = r7.getRequest()
            coil3.transition.Transition$Factory r1 = coil3.request.ImageRequests_androidKt.getTransitionFactory(r1)
            r2 = r8
            coil3.transition.TransitionTarget r2 = (coil3.transition.TransitionTarget) r2
            coil3.transition.Transition r1 = r1.create(r2, r7)
            boolean r2 = r1 instanceof coil3.transition.NoneTransition
            if (r2 == 0) goto L6c
        L64:
            coil3.Image r1 = r7.getImage()
            r8.onSuccess(r1)
            goto L7d
        L6c:
            coil3.request.ImageRequest r8 = r7.getRequest()
            r9.transitionStart(r8, r1)
            r1.transition()
            coil3.request.ImageRequest r8 = r7.getRequest()
            r9.transitionEnd(r8, r1)
        L7d:
            r9.onSuccess(r0, r7)
            coil3.request.ImageRequest$Listener r8 = r0.getListener()
            if (r8 == 0) goto L89
            r8.onSuccess(r0, r7)
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.RealImageLoader.onSuccess(coil3.request.SuccessResult, coil3.target.Target, coil3.EventListener):void");
    }

    private final /* synthetic */ void setShutdown$volatile(int i2) {
        this.shutdown$volatile = i2;
    }

    @Override // coil3.ImageLoader
    @NotNull
    public Disposable enqueue(@NotNull ImageRequest imageRequest) {
        return RealImageLoader_androidKt.getDisposable(imageRequest, BuildersKt.a(this.scope, null, new RealImageLoader$enqueue$job$1(this, imageRequest, null), 3));
    }

    @Override // coil3.ImageLoader
    @Nullable
    public Object execute(@NotNull ImageRequest imageRequest, @NotNull Continuation<? super ImageResult> continuation) {
        return RealImageLoader_androidKt.needsExecuteOnMainDispatcher(imageRequest) ? CoroutineScopeKt.c(new AnonymousClass2(imageRequest, this, null), continuation) : execute(imageRequest, 1, continuation);
    }

    @Override // coil3.ImageLoader
    @NotNull
    public ComponentRegistry getComponents() {
        return this.components;
    }

    @Override // coil3.ImageLoader
    @NotNull
    public ImageRequest.Defaults getDefaults() {
        return this.options.getDefaults();
    }

    @Override // coil3.ImageLoader
    @Nullable
    public DiskCache getDiskCache() {
        return (DiskCache) this.options.getDiskCacheLazy().getValue();
    }

    @Override // coil3.ImageLoader
    @Nullable
    public MemoryCache getMemoryCache() {
        return (MemoryCache) this.options.getMemoryCacheLazy().getValue();
    }

    @NotNull
    public final Options getOptions() {
        return this.options;
    }

    @Override // coil3.ImageLoader
    @NotNull
    public ImageLoader.Builder newBuilder() {
        return new ImageLoader.Builder(this.options);
    }

    @Override // coil3.ImageLoader
    public void shutdown() {
        if (shutdown$volatile$FU.getAndSet(this, 1) != 0) {
            return;
        }
        CoroutineScopeKt.b(this.scope, null);
        this.systemCallbacks.shutdown();
        MemoryCache memoryCache = getMemoryCache();
        if (memoryCache != null) {
            memoryCache.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(16:0|2|(2:4|(1:6)(1:7))(0)|8|(6:(1:(1:(7:13|121|14|81|(1:83)(2:84|(1:86)(2:89|90))|87|88)(2:18|19))(15:20|119|21|22|23|110|73|74|122|75|76|117|77|(5:80|81|(0)(0)|87|88)|79))(4:28|115|29|46)|26|27|124|99|(3:101|102|103)(2:106|107))(6:33|(1:35)(1:36)|37|112|38|(2:40|(3:42|(2:45|46)|79)(1:49))(2:97|98))|113|50|(1:59)(1:56)|60|(2:(1:63)(1:64)|65)|66|(1:68)|69|(11:72|23|110|73|74|122|75|76|117|77|(0))|79|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0115, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0116, code lost:
    
        r6 = r2;
        r4 = r5;
        r5 = r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01ce A[Catch: all -> 0x01dd, TRY_LEAVE, TryCatch #8 {all -> 0x01dd, blocks: (B:99:0x01ca, B:101:0x01ce, B:106:0x01df, B:107:0x01e2), top: B:124:0x01ca }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01df A[Catch: all -> 0x01dd, TRY_ENTER, TryCatch #8 {all -> 0x01dd, blocks: (B:99:0x01ca, B:101:0x01ce, B:106:0x01df, B:107:0x01e2), top: B:124:0x01ca }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0194 A[Catch: all -> 0x0049, TryCatch #6 {all -> 0x0049, blocks: (B:14:0x0044, B:81:0x018e, B:83:0x0194, B:84:0x019f, B:86:0x01a3, B:89:0x01b1, B:90:0x01b6), top: B:121:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x019f A[Catch: all -> 0x0049, TryCatch #6 {all -> 0x0049, blocks: (B:14:0x0044, B:81:0x018e, B:83:0x0194, B:84:0x019f, B:86:0x01a3, B:89:0x01b1, B:90:0x01b6), top: B:121:0x0044 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object execute(coil3.request.ImageRequest r21, int r22, kotlin.coroutines.Continuation<? super coil3.request.ImageResult> r23) {
        /*
            Method dump skipped, instructions count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.RealImageLoader.execute(coil3.request.ImageRequest, int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
