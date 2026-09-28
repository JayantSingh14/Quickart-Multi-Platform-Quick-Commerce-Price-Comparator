package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.SafeCollector;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f54623a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Flow f54624b;

    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1", f = "Emitters.kt", l = {112, 116}, m = "collect")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1, reason: invalid class name */
    public final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f54625a;

        /* renamed from: b, reason: collision with root package name */
        public int f54626b;

        /* renamed from: d, reason: collision with root package name */
        public FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 f54628d;

        /* renamed from: e, reason: collision with root package name */
        public FlowCollector f54629e;

        /* renamed from: f, reason: collision with root package name */
        public SafeCollector f54630f;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f54625a = obj;
            this.f54626b |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.this.c(null, this);
        }
    }

    public FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(Function2 function2, Flow flow) {
        this.f54623a = function2;
        this.f54624b = flow;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(kotlinx.coroutines.flow.FlowCollector r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.f54626b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f54626b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f54625a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f54626b
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r8)
            kotlin.Unit r7 = kotlin.Unit.f53572a
            return r7
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            kotlinx.coroutines.flow.internal.SafeCollector r7 = r0.f54630f
            kotlinx.coroutines.flow.FlowCollector r2 = r0.f54629e
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 r4 = r0.f54628d
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L3e
            goto L60
        L3e:
            r8 = move-exception
            goto L78
        L40:
            kotlin.ResultKt.b(r8)
            kotlinx.coroutines.flow.internal.SafeCollector r8 = new kotlinx.coroutines.flow.internal.SafeCollector
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()
            r8.<init>(r7, r2)
            kotlin.jvm.functions.Function2 r2 = r6.f54623a     // Catch: java.lang.Throwable -> L74
            r0.f54628d = r6     // Catch: java.lang.Throwable -> L74
            r0.f54629e = r7     // Catch: java.lang.Throwable -> L74
            r0.f54630f = r8     // Catch: java.lang.Throwable -> L74
            r0.f54626b = r4     // Catch: java.lang.Throwable -> L74
            java.lang.Object r2 = r2.invoke(r8, r0)     // Catch: java.lang.Throwable -> L74
            if (r2 != r1) goto L5d
            return r1
        L5d:
            r4 = r6
            r2 = r7
            r7 = r8
        L60:
            r7.releaseIntercepted()
            kotlinx.coroutines.flow.Flow r7 = r4.f54624b
            r8 = 0
            r0.f54628d = r8
            r0.f54629e = r8
            r0.f54630f = r8
            r0.f54626b = r3
            kotlinx.coroutines.flow.StateFlowImpl r7 = (kotlinx.coroutines.flow.StateFlowImpl) r7
            r7.c(r2, r0)
            return r1
        L74:
            r7 = move-exception
            r5 = r8
            r8 = r7
            r7 = r5
        L78:
            r7.releaseIntercepted()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.c(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
