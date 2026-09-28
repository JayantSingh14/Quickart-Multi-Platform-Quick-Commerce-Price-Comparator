package androidx.collection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequenceScope;

@Metadata
@DebugMetadata(c = "androidx.collection.MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1", f = "ScatterSet.kt", l = {1060}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<Object>, Continuation<? super Unit>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public MutableScatterSet$MutableSetWrapper$iterator$1 f1532b;

    /* renamed from: c, reason: collision with root package name */
    public MutableScatterSet f1533c;

    /* renamed from: d, reason: collision with root package name */
    public long[] f1534d;

    /* renamed from: e, reason: collision with root package name */
    public int f1535e;

    /* renamed from: f, reason: collision with root package name */
    public int f1536f;

    /* renamed from: g, reason: collision with root package name */
    public int f1537g;

    /* renamed from: h, reason: collision with root package name */
    public int f1538h;

    /* renamed from: i, reason: collision with root package name */
    public long f1539i;

    /* renamed from: j, reason: collision with root package name */
    public int f1540j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f1541k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ MutableScatterSet$MutableSetWrapper$iterator$1 f1542l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1(MutableScatterSet$MutableSetWrapper$iterator$1 mutableScatterSet$MutableSetWrapper$iterator$1, Continuation continuation) {
        super(2, continuation);
        this.f1542l = mutableScatterSet$MutableSetWrapper$iterator$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1 mutableScatterSet$MutableSetWrapper$iterator$1$iterator$1 = new MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1(this.f1542l, continuation);
        mutableScatterSet$MutableSetWrapper$iterator$1$iterator$1.f1541k = obj;
        return mutableScatterSet$MutableSetWrapper$iterator$1$iterator$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0069, code lost:
    
        r4 = 8 - ((~(r7 - r8)) >>> 31);
        r3 = 0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = 1
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r3 = r0.f1540j
            if (r3 == 0) goto L7d
            if (r3 != r1) goto L75
            int r3 = r0.f1538h
            int r4 = r0.f1537g
            long r5 = r0.f1539i
            int r7 = r0.f1536f
            int r8 = r0.f1535e
            long[] r9 = r0.f1534d
            androidx.collection.MutableScatterSet r10 = r0.f1533c
            androidx.collection.MutableScatterSet$MutableSetWrapper$iterator$1 r11 = r0.f1532b
            java.lang.Object r12 = r0.f1541k
            kotlin.sequences.SequenceScope r12 = (kotlin.sequences.SequenceScope) r12
            kotlin.ResultKt.b(r18)
        L22:
            r13 = 8
            long r5 = r5 >> r13
            int r3 = r3 + r1
        L26:
            if (r3 >= r4) goto L54
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r5
            r15 = 128(0x80, double:6.32E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L22
            int r13 = r7 << 3
            int r13 = r13 + r3
            r11.f1530a = r13
            java.lang.Object[] r14 = r10.f1591b
            r13 = r14[r13]
            r0.f1541k = r12
            r0.f1532b = r11
            r0.f1533c = r10
            r0.f1534d = r9
            r0.f1535e = r8
            r0.f1536f = r7
            r0.f1539i = r5
            r0.f1537g = r4
            r0.f1538h = r3
            r0.f1540j = r1
            r12.a(r13, r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            return r2
        L54:
            if (r4 != r13) goto L72
        L56:
            if (r7 == r8) goto L72
            int r7 = r7 + r1
            r5 = r9[r7]
            long r3 = ~r5
            r14 = 7
            long r3 = r3 << r14
            long r3 = r3 & r5
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r3 = r3 & r14
            int r3 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r3 == 0) goto L56
            int r3 = r7 - r8
            int r3 = ~r3
            int r3 = r3 >>> 31
            int r4 = 8 - r3
            r3 = 0
            goto L26
        L72:
            kotlin.Unit r1 = kotlin.Unit.f53572a
            return r1
        L75:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L7d:
            kotlin.ResultKt.b(r18)
            java.lang.Object r1 = r0.f1541k
            kotlin.sequences.SequenceScope r1 = (kotlin.sequences.SequenceScope) r1
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
