package androidx.collection;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.SequenceScope;

@Metadata
/* loaded from: classes3.dex */
public final class MutableScatterMap$MutableMapWrapper$entries$1$iterator$1 implements Iterator<Map.Entry<Object, Object>>, KMutableIterator {

    /* renamed from: a, reason: collision with root package name */
    public Iterator f1497a;

    /* renamed from: b, reason: collision with root package name */
    public int f1498b;

    @Metadata
    @DebugMetadata(c = "androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1$iterator$1$1", f = "ScatterMap.kt", l = {1328}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1$iterator$1$1, reason: invalid class name */
    final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Map.Entry<Object, Object>>, Continuation<? super Unit>, Object> {

        /* renamed from: b, reason: collision with root package name */
        public MutableScatterMap$MutableMapWrapper$entries$1$iterator$1 f1499b;

        /* renamed from: c, reason: collision with root package name */
        public MutableScatterMap f1500c;

        /* renamed from: d, reason: collision with root package name */
        public long[] f1501d;

        /* renamed from: e, reason: collision with root package name */
        public int f1502e;

        /* renamed from: f, reason: collision with root package name */
        public int f1503f;

        /* renamed from: g, reason: collision with root package name */
        public int f1504g;

        /* renamed from: h, reason: collision with root package name */
        public int f1505h;

        /* renamed from: i, reason: collision with root package name */
        public long f1506i;

        /* renamed from: j, reason: collision with root package name */
        public int f1507j;

        /* renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f1508k;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = MutableScatterMap$MutableMapWrapper$entries$1$iterator$1.this.new AnonymousClass1(continuation);
            anonymousClass1.f1508k = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x006f, code lost:
        
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
                int r3 = r0.f1507j
                if (r3 == 0) goto L83
                if (r3 != r1) goto L7b
                int r3 = r0.f1505h
                int r4 = r0.f1504g
                long r5 = r0.f1506i
                int r7 = r0.f1503f
                int r8 = r0.f1502e
                long[] r9 = r0.f1501d
                androidx.collection.MutableScatterMap r10 = r0.f1500c
                androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1$iterator$1 r11 = r0.f1499b
                java.lang.Object r12 = r0.f1508k
                kotlin.sequences.SequenceScope r12 = (kotlin.sequences.SequenceScope) r12
                kotlin.ResultKt.b(r18)
            L22:
                r13 = 8
                long r5 = r5 >> r13
                int r3 = r3 + r1
            L26:
                if (r3 >= r4) goto L5a
                r13 = 255(0xff, double:1.26E-321)
                long r13 = r13 & r5
                r15 = 128(0x80, double:6.32E-322)
                int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
                if (r13 >= 0) goto L22
                int r13 = r7 << 3
                int r13 = r13 + r3
                r11.f1498b = r13
                androidx.collection.MutableMapEntry r14 = new androidx.collection.MutableMapEntry
                java.lang.Object[] r15 = r10.f1559b
                java.lang.Object[] r1 = r10.f1560c
                r14.<init>(r13, r15, r1)
                r0.f1508k = r12
                r0.f1499b = r11
                r0.f1500c = r10
                r0.f1501d = r9
                r0.f1502e = r8
                r0.f1503f = r7
                r0.f1506i = r5
                r0.f1504g = r4
                r0.f1505h = r3
                r1 = 1
                r0.f1507j = r1
                r12.a(r14, r0)
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                return r2
            L5a:
                if (r4 != r13) goto L78
            L5c:
                if (r7 == r8) goto L78
                int r7 = r7 + r1
                r5 = r9[r7]
                long r3 = ~r5
                r14 = 7
                long r3 = r3 << r14
                long r3 = r3 & r5
                r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r3 = r3 & r14
                int r3 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
                if (r3 == 0) goto L5c
                int r3 = r7 - r8
                int r3 = ~r3
                int r3 = r3 >>> 31
                int r4 = 8 - r3
                r3 = 0
                goto L26
            L78:
                kotlin.Unit r1 = kotlin.Unit.f53572a
                return r1
            L7b:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L83:
                kotlin.ResultKt.b(r18)
                java.lang.Object r1 = r0.f1508k
                kotlin.sequences.SequenceScope r1 = (kotlin.sequences.SequenceScope) r1
                r1 = 0
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1$iterator$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1497a.hasNext();
    }

    @Override // java.util.Iterator
    public final Map.Entry<Object, Object> next() {
        return (Map.Entry) this.f1497a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.f1498b != -1) {
            throw null;
        }
    }
}
