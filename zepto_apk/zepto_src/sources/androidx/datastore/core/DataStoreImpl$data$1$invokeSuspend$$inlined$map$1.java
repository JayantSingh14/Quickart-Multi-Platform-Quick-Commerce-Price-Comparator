package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DataStoreImpl$data$1$invokeSuspend$$inlined$map$1 implements Flow<Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1 f3408a;

    @Metadata
    @SourceDebugExtension
    /* renamed from: androidx.datastore.core.DataStoreImpl$data$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
    public final class AnonymousClass2<T> implements FlowCollector {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowCollector f3409a;

        @Metadata
        @DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$data$1$invokeSuspend$$inlined$map$1$2", f = "DataStoreImpl.kt", l = {223}, m = "emit")
        @SourceDebugExtension
        /* renamed from: androidx.datastore.core.DataStoreImpl$data$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
        public final class AnonymousClass1 extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f3410a;

            /* renamed from: b, reason: collision with root package name */
            public int f3411b;

            public AnonymousClass1(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f3410a = obj;
                this.f3411b |= Integer.MIN_VALUE;
                return AnonymousClass2.this.a(null, this);
            }
        }

        public AnonymousClass2(FlowCollector flowCollector) {
            this.f3409a = flowCollector;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(java.lang.Object r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r6 instanceof androidx.datastore.core.DataStoreImpl$data$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                if (r0 == 0) goto L13
                r0 = r6
                androidx.datastore.core.DataStoreImpl$data$1$invokeSuspend$$inlined$map$1$2$1 r0 = (androidx.datastore.core.DataStoreImpl$data$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                int r1 = r0.f3411b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f3411b = r1
                goto L18
            L13:
                androidx.datastore.core.DataStoreImpl$data$1$invokeSuspend$$inlined$map$1$2$1 r0 = new androidx.datastore.core.DataStoreImpl$data$1$invokeSuspend$$inlined$map$1$2$1
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.f3410a
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                int r2 = r0.f3411b
                r3 = 1
                if (r2 == 0) goto L2f
                if (r2 != r3) goto L27
                kotlin.ResultKt.b(r6)
                goto L4b
            L27:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L2f:
                kotlin.ResultKt.b(r6)
                androidx.datastore.core.State r5 = (androidx.datastore.core.State) r5
                boolean r6 = r5 instanceof androidx.datastore.core.ReadException
                if (r6 != 0) goto L65
                boolean r6 = r5 instanceof androidx.datastore.core.Data
                if (r6 == 0) goto L4e
                androidx.datastore.core.Data r5 = (androidx.datastore.core.Data) r5
                java.lang.Object r5 = r5.f3378b
                r0.f3411b = r3
                kotlinx.coroutines.flow.FlowCollector r6 = r4.f3409a
                java.lang.Object r5 = r6.a(r5, r0)
                if (r5 != r1) goto L4b
                return r1
            L4b:
                kotlin.Unit r5 = kotlin.Unit.f53572a
                return r5
            L4e:
                boolean r6 = r5 instanceof androidx.datastore.core.Final
                if (r6 == 0) goto L53
                goto L55
            L53:
                boolean r3 = r5 instanceof androidx.datastore.core.UnInitialized
            L55:
                if (r3 == 0) goto L5f
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542"
                r5.<init>(r6)
                throw r5
            L5f:
                kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
                r5.<init>()
                throw r5
            L65:
                androidx.datastore.core.ReadException r5 = (androidx.datastore.core.ReadException) r5
                java.lang.Throwable r5 = r5.f3605b
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$data$1$invokeSuspend$$inlined$map$1.AnonymousClass2.a(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    public DataStoreImpl$data$1$invokeSuspend$$inlined$map$1(FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1 flowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1) {
        this.f3408a = flowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object c(FlowCollector flowCollector, Continuation continuation) {
        Object objC = this.f3408a.c(new AnonymousClass2(flowCollector), continuation);
        return objC == CoroutineSingletons.f53689a ? objC : Unit.f53572a;
    }
}
