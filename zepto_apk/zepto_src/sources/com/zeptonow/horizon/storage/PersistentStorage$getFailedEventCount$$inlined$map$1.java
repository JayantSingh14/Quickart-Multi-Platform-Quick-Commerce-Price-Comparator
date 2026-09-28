package com.zeptonow.horizon.storage;

import app.cash.sqldelight.coroutines.FlowQuery$mapToOne$$inlined$map$1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class PersistentStorage$getFailedEventCount$$inlined$map$1 implements Flow<Integer> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowQuery$mapToOne$$inlined$map$1 f48178a;

    @Metadata
    @SourceDebugExtension
    /* renamed from: com.zeptonow.horizon.storage.PersistentStorage$getFailedEventCount$$inlined$map$1$2, reason: invalid class name */
    public final class AnonymousClass2<T> implements FlowCollector {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowCollector f48179a;

        @Metadata
        @DebugMetadata(c = "com.zeptonow.horizon.storage.PersistentStorage$getFailedEventCount$$inlined$map$1$2", f = "PersistentStorage.kt", l = {219}, m = "emit")
        @SourceDebugExtension
        /* renamed from: com.zeptonow.horizon.storage.PersistentStorage$getFailedEventCount$$inlined$map$1$2$1, reason: invalid class name */
        public final class AnonymousClass1 extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f48180a;

            /* renamed from: b, reason: collision with root package name */
            public int f48181b;

            public AnonymousClass1(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f48180a = obj;
                this.f48181b |= Integer.MIN_VALUE;
                return AnonymousClass2.this.a(null, this);
            }
        }

        public AnonymousClass2(FlowCollector flowCollector) {
            this.f48179a = flowCollector;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof com.zeptonow.horizon.storage.PersistentStorage$getFailedEventCount$$inlined$map$1.AnonymousClass2.AnonymousClass1
                if (r0 == 0) goto L13
                r0 = r6
                com.zeptonow.horizon.storage.PersistentStorage$getFailedEventCount$$inlined$map$1$2$1 r0 = (com.zeptonow.horizon.storage.PersistentStorage$getFailedEventCount$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                int r1 = r0.f48181b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f48181b = r1
                goto L18
            L13:
                com.zeptonow.horizon.storage.PersistentStorage$getFailedEventCount$$inlined$map$1$2$1 r0 = new com.zeptonow.horizon.storage.PersistentStorage$getFailedEventCount$$inlined$map$1$2$1
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.f48180a
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                int r2 = r0.f48181b
                r3 = 1
                if (r2 == 0) goto L2f
                if (r2 != r3) goto L27
                kotlin.ResultKt.b(r6)
                goto L49
            L27:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L2f:
                kotlin.ResultKt.b(r6)
                java.lang.Number r5 = (java.lang.Number) r5
                long r5 = r5.longValue()
                int r5 = (int) r5
                java.lang.Integer r6 = new java.lang.Integer
                r6.<init>(r5)
                r0.f48181b = r3
                kotlinx.coroutines.flow.FlowCollector r5 = r4.f48179a
                java.lang.Object r5 = r5.a(r6, r0)
                if (r5 != r1) goto L49
                return r1
            L49:
                kotlin.Unit r5 = kotlin.Unit.f53572a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.storage.PersistentStorage$getFailedEventCount$$inlined$map$1.AnonymousClass2.a(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    public PersistentStorage$getFailedEventCount$$inlined$map$1(FlowQuery$mapToOne$$inlined$map$1 flowQuery$mapToOne$$inlined$map$1) {
        this.f48178a = flowQuery$mapToOne$$inlined$map$1;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object c(FlowCollector flowCollector, Continuation continuation) {
        Object objC = this.f48178a.c(new AnonymousClass2(flowCollector), continuation);
        return objC == CoroutineSingletons.f53689a ? objC : Unit.f53572a;
    }
}
