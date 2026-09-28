package androidx.datastore.core;

import androidx.datastore.core.UpdatingDataContextElement;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.MutexKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class DataStoreImpl<T> implements DataStore<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Storage f3396a;

    /* renamed from: b, reason: collision with root package name */
    public final CorruptionHandler f3397b;

    /* renamed from: c, reason: collision with root package name */
    public final CoroutineScope f3398c;

    /* renamed from: d, reason: collision with root package name */
    public final Flow f3399d;

    /* renamed from: e, reason: collision with root package name */
    public final MutexImpl f3400e;

    /* renamed from: f, reason: collision with root package name */
    public int f3401f;

    /* renamed from: g, reason: collision with root package name */
    public Job f3402g;

    /* renamed from: h, reason: collision with root package name */
    public final DataStoreInMemoryCache f3403h;

    /* renamed from: i, reason: collision with root package name */
    public final InitDataStore f3404i;

    /* renamed from: j, reason: collision with root package name */
    public final Lazy f3405j;

    /* renamed from: k, reason: collision with root package name */
    public final Lazy f3406k;

    /* renamed from: l, reason: collision with root package name */
    public final SimpleActor f3407l;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public final class InitDataStore extends RunOnce {

        /* renamed from: c, reason: collision with root package name */
        public List f3413c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DataStoreImpl f3414d;

        public InitDataStore(DataStoreImpl dataStoreImpl, List initTasksList) {
            Intrinsics.checkNotNullParameter(initTasksList, "initTasksList");
            this.f3414d = dataStoreImpl;
            this.f3413c = CollectionsKt.e0(initTasksList);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // androidx.datastore.core.RunOnce
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(kotlin.coroutines.jvm.internal.ContinuationImpl r7) throws androidx.datastore.core.CorruptionException {
            /*
                r6 = this;
                boolean r0 = r7 instanceof androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1
                if (r0 == 0) goto L13
                r0 = r7
                androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1 r0 = (androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1) r0
                int r1 = r0.f3418d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f3418d = r1
                goto L18
            L13:
                androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1 r0 = new androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1
                r0.<init>(r6, r7)
            L18:
                java.lang.Object r7 = r0.f3416b
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                int r2 = r0.f3418d
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L3e
                if (r2 == r4) goto L36
                if (r2 != r3) goto L2e
                java.lang.Object r0 = r0.f3415a
                androidx.datastore.core.DataStoreImpl$InitDataStore r0 = (androidx.datastore.core.DataStoreImpl.InitDataStore) r0
                kotlin.ResultKt.b(r7)
                goto L64
            L2e:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L36:
                java.lang.Object r0 = r0.f3415a
                androidx.datastore.core.DataStoreImpl$InitDataStore r0 = (androidx.datastore.core.DataStoreImpl.InitDataStore) r0
                kotlin.ResultKt.b(r7)
                goto L74
            L3e:
                kotlin.ResultKt.b(r7)
                java.util.List r7 = r6.f3413c
                androidx.datastore.core.DataStoreImpl r2 = r6.f3414d
                if (r7 == 0) goto L67
                boolean r7 = r7.isEmpty()
                if (r7 == 0) goto L4e
                goto L67
            L4e:
                androidx.datastore.core.InterProcessCoordinator r7 = r2.g()
                androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1 r4 = new androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1
                r5 = 0
                r4.<init>(r2, r6, r5)
                r0.f3415a = r6
                r0.f3418d = r3
                java.lang.Object r7 = r7.d(r4, r0)
                if (r7 != r1) goto L63
                goto L72
            L63:
                r0 = r6
            L64:
                androidx.datastore.core.Data r7 = (androidx.datastore.core.Data) r7
                goto L76
            L67:
                r0.f3415a = r6
                r0.f3418d = r4
                r7 = 0
                java.lang.Object r7 = androidx.datastore.core.DataStoreImpl.f(r2, r7, r0)
                if (r7 != r1) goto L73
            L72:
                return r1
            L73:
                r0 = r6
            L74:
                androidx.datastore.core.Data r7 = (androidx.datastore.core.Data) r7
            L76:
                androidx.datastore.core.DataStoreImpl r0 = r0.f3414d
                androidx.datastore.core.DataStoreInMemoryCache r0 = r0.f3403h
                r0.b(r7)
                kotlin.Unit r7 = kotlin.Unit.f53572a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.InitDataStore.a(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
        }
    }

    public DataStoreImpl(Storage storage, List initTasksList, CorruptionHandler corruptionHandler, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(initTasksList, "initTasksList");
        Intrinsics.checkNotNullParameter(corruptionHandler, "corruptionHandler");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f3396a = storage;
        this.f3397b = corruptionHandler;
        this.f3398c = scope;
        this.f3399d = FlowKt.l(new DataStoreImpl$data$1(this, null));
        this.f3400e = MutexKt.a();
        this.f3403h = new DataStoreInMemoryCache();
        this.f3404i = new InitDataStore(this, initTasksList);
        this.f3405j = LazyKt.b(new Function0<StorageConnection<Object>>() { // from class: androidx.datastore.core.DataStoreImpl$storageConnectionDelegate$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f3513c.f3396a.a();
            }
        });
        this.f3406k = LazyKt.b(new Function0<InterProcessCoordinator>() { // from class: androidx.datastore.core.DataStoreImpl$coordinator$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ((StorageConnection) this.f3440c.f3405j.getValue()).e();
            }
        });
        this.f3407l = new SimpleActor(scope, new DataStoreImpl$writeActor$1(this), new DataStoreImpl$writeActor$3(this, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(androidx.datastore.core.DataStoreImpl r4, kotlin.coroutines.jvm.internal.ContinuationImpl r5) {
        /*
            r4.getClass()
            boolean r0 = r5 instanceof androidx.datastore.core.DataStoreImpl$decrementCollector$1
            if (r0 == 0) goto L16
            r0 = r5
            androidx.datastore.core.DataStoreImpl$decrementCollector$1 r0 = (androidx.datastore.core.DataStoreImpl$decrementCollector$1) r0
            int r1 = r0.f3456e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.f3456e = r1
            goto L1b
        L16:
            androidx.datastore.core.DataStoreImpl$decrementCollector$1 r0 = new androidx.datastore.core.DataStoreImpl$decrementCollector$1
            r0.<init>(r4, r5)
        L1b:
            java.lang.Object r5 = r0.f3454c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f3456e
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            kotlinx.coroutines.sync.MutexImpl r4 = r0.f3453b
            androidx.datastore.core.DataStoreImpl r0 = r0.f3452a
            kotlin.ResultKt.b(r5)
            r5 = r4
            r4 = r0
            goto L4a
        L30:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L38:
            kotlin.ResultKt.b(r5)
            kotlinx.coroutines.sync.MutexImpl r5 = r4.f3400e
            r0.f3452a = r4
            r0.f3453b = r5
            r0.f3456e = r3
            java.lang.Object r0 = r5.c(r0)
            if (r0 != r1) goto L4a
            return r1
        L4a:
            r0 = 0
            int r1 = r4.f3401f     // Catch: java.lang.Throwable -> L5f
            int r1 = r1 + (-1)
            r4.f3401f = r1     // Catch: java.lang.Throwable -> L5f
            if (r1 != 0) goto L61
            kotlinx.coroutines.Job r1 = r4.f3402g     // Catch: java.lang.Throwable -> L5f
            if (r1 == 0) goto L5c
            kotlinx.coroutines.JobSupport r1 = (kotlinx.coroutines.JobSupport) r1     // Catch: java.lang.Throwable -> L5f
            r1.e(r0)     // Catch: java.lang.Throwable -> L5f
        L5c:
            r4.f3402g = r0     // Catch: java.lang.Throwable -> L5f
            goto L61
        L5f:
            r4 = move-exception
            goto L69
        L61:
            kotlin.Unit r4 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L5f
            r5.b(r0)
            kotlin.Unit r4 = kotlin.Unit.f53572a
            return r4
        L69:
            r5.b(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.b(androidx.datastore.core.DataStoreImpl, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|2|(2:4|(1:6)(1:7))(0)|8|(1:73)|(7:(1:(1:(1:13)(2:18|19))(3:20|21|22))(1:23)|14|52|65|(1:67)(1:68)|69|70)(5:24|77|25|(3:27|75|28)(3:38|(1:40)(1:41)|(2:43|(2:45|(1:47))(2:56|57))(2:58|(2:60|61)(2:62|63)))|51)|48|71|49|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0082, code lost:
    
        if (r9 == r1) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0085, code lost:
    
        r8 = r11;
        r11 = r9;
        r9 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00cc, code lost:
    
        if (r9 == r1) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d2, code lost:
    
        r9 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Type inference failed for: r9v0, types: [androidx.datastore.core.DataStoreImpl, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(androidx.datastore.core.DataStoreImpl r9, androidx.datastore.core.Message.Update r10, kotlin.coroutines.jvm.internal.ContinuationImpl r11) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.c(androidx.datastore.core.DataStoreImpl, androidx.datastore.core.Message$Update, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(androidx.datastore.core.DataStoreImpl r4, kotlin.coroutines.jvm.internal.ContinuationImpl r5) {
        /*
            r4.getClass()
            boolean r0 = r5 instanceof androidx.datastore.core.DataStoreImpl$incrementCollector$1
            if (r0 == 0) goto L16
            r0 = r5
            androidx.datastore.core.DataStoreImpl$incrementCollector$1 r0 = (androidx.datastore.core.DataStoreImpl$incrementCollector$1) r0
            int r1 = r0.f3469e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.f3469e = r1
            goto L1b
        L16:
            androidx.datastore.core.DataStoreImpl$incrementCollector$1 r0 = new androidx.datastore.core.DataStoreImpl$incrementCollector$1
            r0.<init>(r4, r5)
        L1b:
            java.lang.Object r5 = r0.f3467c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f3469e
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            kotlinx.coroutines.sync.MutexImpl r4 = r0.f3466b
            androidx.datastore.core.DataStoreImpl r0 = r0.f3465a
            kotlin.ResultKt.b(r5)
            r5 = r4
            r4 = r0
            goto L4a
        L30:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L38:
            kotlin.ResultKt.b(r5)
            kotlinx.coroutines.sync.MutexImpl r5 = r4.f3400e
            r0.f3465a = r4
            r0.f3466b = r5
            r0.f3469e = r3
            java.lang.Object r0 = r5.c(r0)
            if (r0 != r1) goto L4a
            return r1
        L4a:
            r0 = 0
            int r1 = r4.f3401f     // Catch: java.lang.Throwable -> L61
            int r1 = r1 + r3
            r4.f3401f = r1     // Catch: java.lang.Throwable -> L61
            if (r1 != r3) goto L63
            kotlinx.coroutines.CoroutineScope r1 = r4.f3398c     // Catch: java.lang.Throwable -> L61
            androidx.datastore.core.DataStoreImpl$incrementCollector$2$1 r2 = new androidx.datastore.core.DataStoreImpl$incrementCollector$2$1     // Catch: java.lang.Throwable -> L61
            r2.<init>(r4, r0)     // Catch: java.lang.Throwable -> L61
            r3 = 3
            kotlinx.coroutines.Job r1 = kotlinx.coroutines.BuildersKt.c(r1, r0, r2, r3)     // Catch: java.lang.Throwable -> L61
            r4.f3402g = r1     // Catch: java.lang.Throwable -> L61
            goto L63
        L61:
            r4 = move-exception
            goto L6b
        L63:
            kotlin.Unit r4 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L61
            r5.b(r0)
            kotlin.Unit r4 = kotlin.Unit.f53572a
            return r4
        L6b:
            r5.b(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.d(androidx.datastore.core.DataStoreImpl, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(androidx.datastore.core.DataStoreImpl r8, boolean r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.e(androidx.datastore.core.DataStoreImpl, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00a2 A[Catch: CorruptionException -> 0x0062, TryCatch #2 {CorruptionException -> 0x0062, blocks: (B:19:0x005d, B:54:0x0101, B:24:0x006b, B:51:0x00e3, B:32:0x0088, B:40:0x00a2, B:42:0x00a8, B:36:0x0091, B:48:0x00d0), top: B:81:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x013e A[Catch: all -> 0x016a, TryCatch #1 {all -> 0x016a, blocks: (B:61:0x012c, B:63:0x013e, B:64:0x0146), top: B:80:0x012c }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0146 A[Catch: all -> 0x016a, TRY_LEAVE, TryCatch #1 {all -> 0x016a, blocks: (B:61:0x012c, B:63:0x013e, B:64:0x0146), top: B:80:0x012c }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object f(androidx.datastore.core.DataStoreImpl r9, boolean r10, kotlin.coroutines.jvm.internal.ContinuationImpl r11) throws androidx.datastore.core.CorruptionException {
        /*
            Method dump skipped, instructions count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.f(androidx.datastore.core.DataStoreImpl, boolean, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // androidx.datastore.core.DataStore
    public final Object a(Function2 function2, ContinuationImpl continuationImpl) {
        UpdatingDataContextElement updatingDataContextElement = (UpdatingDataContextElement) continuationImpl.getContext().get(UpdatingDataContextElement.Companion.Key.f3645a);
        if (updatingDataContextElement != null) {
            updatingDataContextElement.b(this);
        }
        return BuildersKt.e(new UpdatingDataContextElement(updatingDataContextElement, this), new DataStoreImpl$updateData$2(this, function2, null), continuationImpl);
    }

    public final InterProcessCoordinator g() {
        return (InterProcessCoordinator) this.f3406k.getValue();
    }

    @Override // androidx.datastore.core.DataStore
    public final Flow getData() {
        return this.f3399d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0063, code lost:
    
        if (r4.b(r0) == r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(kotlin.coroutines.jvm.internal.ContinuationImpl r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 r0 = (androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1) r0
            int r1 = r0.f3477e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3477e = r1
            goto L18
        L13:
            androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 r0 = new androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f3475c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f3477e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            int r1 = r0.f3474b
            androidx.datastore.core.DataStoreImpl r0 = r0.f3473a
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L2e
            goto L66
        L2e:
            r6 = move-exception
            goto L6f
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L38:
            androidx.datastore.core.DataStoreImpl r2 = r0.f3473a
            kotlin.ResultKt.b(r6)
            goto L51
        L3e:
            kotlin.ResultKt.b(r6)
            androidx.datastore.core.InterProcessCoordinator r6 = r5.g()
            r0.f3473a = r5
            r0.f3477e = r4
            java.lang.Object r6 = r6.c(r0)
            if (r6 != r1) goto L50
            goto L65
        L50:
            r2 = r5
        L51:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            androidx.datastore.core.DataStoreImpl$InitDataStore r4 = r2.f3404i     // Catch: java.lang.Throwable -> L6d
            r0.f3473a = r2     // Catch: java.lang.Throwable -> L6d
            r0.f3474b = r6     // Catch: java.lang.Throwable -> L6d
            r0.f3477e = r3     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r6 = r4.b(r0)     // Catch: java.lang.Throwable -> L6d
            if (r6 != r1) goto L66
        L65:
            return r1
        L66:
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        L69:
            r1 = r6
            r6 = r0
            r0 = r2
            goto L6f
        L6d:
            r0 = move-exception
            goto L69
        L6f:
            androidx.datastore.core.DataStoreInMemoryCache r0 = r0.f3403h
            androidx.datastore.core.ReadException r2 = new androidx.datastore.core.ReadException
            r2.<init>(r1, r6)
            r0.b(r2)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.h(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final Object i(ContinuationImpl continuationImpl) {
        return ((StorageConnection) this.f3405j.getValue()).b(new StorageConnectionKt$readData$2(3, null), continuationImpl);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.Object r11, boolean r12, kotlin.coroutines.jvm.internal.ContinuationImpl r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof androidx.datastore.core.DataStoreImpl$writeData$1
            if (r0 == 0) goto L13
            r0 = r13
            androidx.datastore.core.DataStoreImpl$writeData$1 r0 = (androidx.datastore.core.DataStoreImpl$writeData$1) r0
            int r1 = r0.f3534d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3534d = r1
            goto L18
        L13:
            androidx.datastore.core.DataStoreImpl$writeData$1 r0 = new androidx.datastore.core.DataStoreImpl$writeData$1
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.f3532b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f3534d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.jvm.internal.Ref$IntRef r11 = r0.f3531a
            kotlin.ResultKt.b(r13)
            goto L56
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L31:
            kotlin.ResultKt.b(r13)
            kotlin.jvm.internal.Ref$IntRef r5 = new kotlin.jvm.internal.Ref$IntRef
            r5.<init>()
            kotlin.Lazy r13 = r10.f3405j
            java.lang.Object r13 = r13.getValue()
            androidx.datastore.core.StorageConnection r13 = (androidx.datastore.core.StorageConnection) r13
            androidx.datastore.core.DataStoreImpl$writeData$2 r4 = new androidx.datastore.core.DataStoreImpl$writeData$2
            r9 = 0
            r6 = r10
            r7 = r11
            r8 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            r0.f3531a = r5
            r0.f3534d = r3
            java.lang.Object r11 = r13.c(r4, r0)
            if (r11 != r1) goto L55
            return r1
        L55:
            r11 = r5
        L56:
            int r11 = r11.f53799a
            java.lang.Integer r12 = new java.lang.Integer
            r12.<init>(r11)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.j(java.lang.Object, boolean, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
