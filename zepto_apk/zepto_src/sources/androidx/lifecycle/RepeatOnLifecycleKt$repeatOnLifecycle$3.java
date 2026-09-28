package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata
@DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", l = {84}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f4868a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f4869b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Lifecycle f4870c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SuspendLambda f4871d;

    @Metadata
    @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", l = {166}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Ref.ObjectRef f4872a;

        /* renamed from: b, reason: collision with root package name */
        public Ref.ObjectRef f4873b;

        /* renamed from: c, reason: collision with root package name */
        public CoroutineScope f4874c;

        /* renamed from: d, reason: collision with root package name */
        public int f4875d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Lifecycle f4876e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ CoroutineScope f4877f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ SuspendLambda f4878g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Lifecycle lifecycle, CoroutineScope coroutineScope, Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.f4876e = lifecycle;
            this.f4877f = coroutineScope;
            this.f4878g = (SuspendLambda) function2;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f4876e, this.f4877f, this.f4878g, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0085  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00a6  */
        /* JADX WARN: Removed duplicated region for block: B:46:? A[SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r11v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
            /*
                r12 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                int r1 = r12.f4875d
                r2 = 0
                androidx.lifecycle.Lifecycle r3 = r12.f4876e
                r4 = 1
                if (r1 == 0) goto L20
                if (r1 != r4) goto L18
                kotlin.jvm.internal.Ref$ObjectRef r1 = r12.f4873b
                kotlin.jvm.internal.Ref$ObjectRef r4 = r12.f4872a
                kotlin.ResultKt.b(r13)     // Catch: java.lang.Throwable -> L14
                goto L7f
            L14:
                r0 = move-exception
                r13 = r0
                goto L97
            L18:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L20:
                kotlin.ResultKt.b(r13)
                androidx.lifecycle.Lifecycle$State r13 = r3.b()
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.f4805a
                if (r13 != r1) goto L2e
                kotlin.Unit r13 = kotlin.Unit.f53572a
                return r13
            L2e:
                kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
                r6.<init>()
                kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
                r1.<init>()
                androidx.lifecycle.Lifecycle$State r13 = androidx.lifecycle.Lifecycle.State.f4808d     // Catch: java.lang.Throwable -> L94
                kotlinx.coroutines.CoroutineScope r7 = r12.f4877f     // Catch: java.lang.Throwable -> L94
                kotlin.coroutines.jvm.internal.SuspendLambda r11 = r12.f4878g     // Catch: java.lang.Throwable -> L94
                r12.f4872a = r6     // Catch: java.lang.Throwable -> L94
                r12.f4873b = r1     // Catch: java.lang.Throwable -> L94
                r12.f4874c = r7     // Catch: java.lang.Throwable -> L94
                r12.f4875d = r4     // Catch: java.lang.Throwable -> L94
                kotlinx.coroutines.CancellableContinuationImpl r9 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch: java.lang.Throwable -> L94
                kotlin.coroutines.Continuation r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.b(r12)     // Catch: java.lang.Throwable -> L94
                r9.<init>(r4, r5)     // Catch: java.lang.Throwable -> L94
                r9.s()     // Catch: java.lang.Throwable -> L94
                androidx.lifecycle.Lifecycle$Event$Companion r4 = androidx.lifecycle.Lifecycle.Event.Companion     // Catch: java.lang.Throwable -> L94
                r4.getClass()     // Catch: java.lang.Throwable -> L94
                androidx.lifecycle.Lifecycle$Event r5 = androidx.lifecycle.Lifecycle.Event.Companion.b(r13)     // Catch: java.lang.Throwable -> L94
                androidx.lifecycle.Lifecycle$Event r8 = androidx.lifecycle.Lifecycle.Event.Companion.a(r13)     // Catch: java.lang.Throwable -> L94
                kotlinx.coroutines.sync.MutexImpl r10 = kotlinx.coroutines.sync.MutexKt.a()     // Catch: java.lang.Throwable -> L94
                androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 r4 = new androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1     // Catch: java.lang.Throwable -> L94
                r4.<init>(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L94
                r1.f53801a = r4     // Catch: java.lang.Throwable -> L94
                r3.a(r4)     // Catch: java.lang.Throwable -> L94
                java.lang.Object r13 = r9.r()     // Catch: java.lang.Throwable -> L94
                if (r13 != r0) goto L7b
                java.lang.String r4 = "frame"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r4)     // Catch: java.lang.Throwable -> L94
                goto L7b
            L79:
                r4 = r6
                goto L97
            L7b:
                if (r13 != r0) goto L7e
                return r0
            L7e:
                r4 = r6
            L7f:
                java.lang.Object r13 = r4.f53801a
                kotlinx.coroutines.Job r13 = (kotlinx.coroutines.Job) r13
                if (r13 == 0) goto L88
                r13.e(r2)
            L88:
                java.lang.Object r13 = r1.f53801a
                androidx.lifecycle.LifecycleEventObserver r13 = (androidx.lifecycle.LifecycleEventObserver) r13
                if (r13 == 0) goto L91
                r3.c(r13)
            L91:
                kotlin.Unit r13 = kotlin.Unit.f53572a
                return r13
            L94:
                r0 = move-exception
                r13 = r0
                goto L79
            L97:
                java.lang.Object r0 = r4.f53801a
                kotlinx.coroutines.Job r0 = (kotlinx.coroutines.Job) r0
                if (r0 == 0) goto La0
                r0.e(r2)
            La0:
                java.lang.Object r0 = r1.f53801a
                androidx.lifecycle.LifecycleEventObserver r0 = (androidx.lifecycle.LifecycleEventObserver) r0
                if (r0 == 0) goto La9
                r3.c(r0)
            La9:
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle lifecycle, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f4870c = lifecycle;
        this.f4871d = (SuspendLambda) function2;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3 repeatOnLifecycleKt$repeatOnLifecycle$3 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.f4870c, this.f4871d, continuation);
        repeatOnLifecycleKt$repeatOnLifecycle$3.f4869b = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f4868a;
        if (i2 == 0) {
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f4869b;
            DefaultScheduler defaultScheduler = Dispatchers.f54091a;
            MainCoroutineDispatcher mainCoroutineDispatcherO1 = MainDispatcherLoader.f55099a.O1();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f4870c, coroutineScope, this.f4871d, null);
            this.f4868a = 1;
            if (BuildersKt.e(mainCoroutineDispatcherO1, anonymousClass1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f53572a;
    }
}
