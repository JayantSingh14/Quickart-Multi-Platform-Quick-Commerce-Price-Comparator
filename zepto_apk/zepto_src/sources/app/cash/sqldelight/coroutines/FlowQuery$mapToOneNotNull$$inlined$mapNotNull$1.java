package app.cash.sqldelight.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class FlowQuery$mapToOneNotNull$$inlined$mapNotNull$1 implements Flow<Object> {

    @Metadata
    @SourceDebugExtension
    /* renamed from: app.cash.sqldelight.coroutines.FlowQuery$mapToOneNotNull$$inlined$mapNotNull$1$2, reason: invalid class name */
    public final class AnonymousClass2<T> implements FlowCollector {

        @Metadata
        @DebugMetadata(c = "app.cash.sqldelight.coroutines.FlowQuery$mapToOneNotNull$$inlined$mapNotNull$1$2", f = "FlowExtensions.kt", l = {220, 221}, m = "emit")
        @SourceDebugExtension
        /* renamed from: app.cash.sqldelight.coroutines.FlowQuery$mapToOneNotNull$$inlined$mapNotNull$1$2$1, reason: invalid class name */
        public final class AnonymousClass1 extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f13116a;

            /* renamed from: b, reason: collision with root package name */
            public int f13117b;

            public AnonymousClass1(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f13116a = obj;
                this.f13117b |= Integer.MIN_VALUE;
                return AnonymousClass2.this.a(null, this);
            }
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
                boolean r0 = r6 instanceof app.cash.sqldelight.coroutines.FlowQuery$mapToOneNotNull$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                if (r0 == 0) goto L13
                r0 = r6
                app.cash.sqldelight.coroutines.FlowQuery$mapToOneNotNull$$inlined$mapNotNull$1$2$1 r0 = (app.cash.sqldelight.coroutines.FlowQuery$mapToOneNotNull$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                int r1 = r0.f13117b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f13117b = r1
                goto L18
            L13:
                app.cash.sqldelight.coroutines.FlowQuery$mapToOneNotNull$$inlined$mapNotNull$1$2$1 r0 = new app.cash.sqldelight.coroutines.FlowQuery$mapToOneNotNull$$inlined$mapNotNull$1$2$1
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.f13116a
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                int r1 = r0.f13117b
                r2 = 0
                if (r1 == 0) goto L3e
                r5 = 2
                r3 = 1
                if (r1 == r3) goto L33
                if (r1 != r5) goto L2b
                kotlin.ResultKt.b(r6)
                goto L38
            L2b:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L33:
                kotlin.ResultKt.b(r6)
                if (r6 != 0) goto L3b
            L38:
                kotlin.Unit r5 = kotlin.Unit.f53572a
                return r5
            L3b:
                r0.f13117b = r5
                throw r2
            L3e:
                kotlin.ResultKt.b(r6)
                app.cash.sqldelight.Query r5 = (app.cash.sqldelight.Query) r5
                app.cash.sqldelight.coroutines.FlowQuery$mapToOneNotNull$1$1 r6 = new app.cash.sqldelight.coroutines.FlowQuery$mapToOneNotNull$1$1
                r6.<init>(r5, r2)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: app.cash.sqldelight.coroutines.FlowQuery$mapToOneNotNull$$inlined$mapNotNull$1.AnonymousClass2.a(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object c(FlowCollector flowCollector, Continuation continuation) {
        throw null;
    }
}
