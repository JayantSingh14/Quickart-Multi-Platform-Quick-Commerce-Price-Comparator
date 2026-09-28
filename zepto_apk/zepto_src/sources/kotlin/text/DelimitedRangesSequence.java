package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: classes3.dex */
public final class DelimitedRangesSequence implements Sequence<IntRange> {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f53960a;

    /* renamed from: b, reason: collision with root package name */
    public final int f53961b;

    /* renamed from: c, reason: collision with root package name */
    public final Function2 f53962c;

    @Metadata
    /* renamed from: kotlin.text.DelimitedRangesSequence$iterator$1, reason: invalid class name */
    public final class AnonymousClass1 implements Iterator<IntRange>, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        public int f53963a = -1;

        /* renamed from: b, reason: collision with root package name */
        public int f53964b;

        /* renamed from: c, reason: collision with root package name */
        public int f53965c;

        /* renamed from: d, reason: collision with root package name */
        public IntRange f53966d;

        /* renamed from: e, reason: collision with root package name */
        public int f53967e;

        public AnonymousClass1() {
            DelimitedRangesSequence.this.getClass();
            int iB = RangesKt.b(0, DelimitedRangesSequence.this.f53960a.length());
            this.f53964b = iB;
            this.f53965c = iB;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a() {
            /*
                r7 = this;
                int r0 = r7.f53965c
                r1 = 0
                if (r0 >= 0) goto Lb
                r7.f53963a = r1
                r0 = 0
                r7.f53966d = r0
                return
            Lb:
                kotlin.text.DelimitedRangesSequence r2 = kotlin.text.DelimitedRangesSequence.this
                int r3 = r2.f53961b
                r4 = -1
                r5 = 1
                if (r3 <= 0) goto L1a
                int r6 = r7.f53967e
                int r6 = r6 + r5
                r7.f53967e = r6
                if (r6 >= r3) goto L22
            L1a:
                java.lang.CharSequence r3 = r2.f53960a
                int r3 = r3.length()
                if (r0 <= r3) goto L34
            L22:
                kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
                int r1 = r7.f53964b
                java.lang.CharSequence r2 = r2.f53960a
                int r2 = kotlin.text.StringsKt.v(r2)
                r0.<init>(r1, r2, r5)
                r7.f53966d = r0
                r7.f53965c = r4
                goto L79
            L34:
                kotlin.jvm.functions.Function2 r0 = r2.f53962c
                java.lang.CharSequence r3 = r2.f53960a
                int r6 = r7.f53965c
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
                java.lang.Object r0 = r0.invoke(r3, r6)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L58
                kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
                int r1 = r7.f53964b
                java.lang.CharSequence r2 = r2.f53960a
                int r2 = kotlin.text.StringsKt.v(r2)
                r0.<init>(r1, r2, r5)
                r7.f53966d = r0
                r7.f53965c = r4
                goto L79
            L58:
                java.lang.Object r2 = r0.f53533a
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.f53534b
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r3 = r7.f53964b
                kotlin.ranges.IntRange r3 = kotlin.ranges.RangesKt.f(r3, r2)
                r7.f53966d = r3
                int r2 = r2 + r0
                r7.f53964b = r2
                if (r0 != 0) goto L76
                r1 = r5
            L76:
                int r2 = r2 + r1
                r7.f53965c = r2
            L79:
                r7.f53963a = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.DelimitedRangesSequence.AnonymousClass1.a():void");
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f53963a == -1) {
                a();
            }
            return this.f53963a == 1;
        }

        @Override // java.util.Iterator
        public final IntRange next() {
            if (this.f53963a == -1) {
                a();
            }
            if (this.f53963a == 0) {
                throw new NoSuchElementException();
            }
            IntRange intRange = this.f53966d;
            Intrinsics.d(intRange, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f53966d = null;
            this.f53963a = -1;
            return intRange;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public DelimitedRangesSequence(CharSequence input, int i2, Function2 getNextMatch) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(getNextMatch, "getNextMatch");
        this.f53960a = input;
        this.f53961b = i2;
        this.f53962c = getNextMatch;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new AnonymousClass1();
    }
}
