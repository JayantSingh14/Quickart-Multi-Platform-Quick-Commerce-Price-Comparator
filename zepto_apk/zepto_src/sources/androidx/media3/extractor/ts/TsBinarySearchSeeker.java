package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.BinarySearchSeeker;

/* loaded from: classes3.dex */
final class TsBinarySearchSeeker extends BinarySearchSeeker {

    public static final class TsPcrSeeker implements BinarySearchSeeker.TimestampSeeker {

        /* renamed from: a, reason: collision with root package name */
        public final TimestampAdjuster f9772a;

        /* renamed from: b, reason: collision with root package name */
        public final ParsableByteArray f9773b = new ParsableByteArray();

        /* renamed from: c, reason: collision with root package name */
        public final int f9774c;

        /* renamed from: d, reason: collision with root package name */
        public final int f9775d;

        public TsPcrSeeker(int i2, TimestampAdjuster timestampAdjuster, int i3) {
            this.f9774c = i2;
            this.f9772a = timestampAdjuster;
            this.f9775d = i3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x00a1, code lost:
        
            if (r13 == r16) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00ac, code lost:
        
            return new androidx.media3.extractor.BinarySearchSeeker.TimestampSearchResult(r13, r4 + r6, -2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00af, code lost:
        
            return androidx.media3.extractor.BinarySearchSeeker.TimestampSearchResult.f8499d;
         */
        @Override // androidx.media3.extractor.BinarySearchSeeker.TimestampSeeker
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final androidx.media3.extractor.BinarySearchSeeker.TimestampSearchResult a(androidx.media3.extractor.DefaultExtractorInput r19, long r20) {
            /*
                r18 = this;
                r0 = r18
                r1 = r19
                long r4 = r1.f8519d
                int r2 = r0.f9775d
                long r2 = (long) r2
                long r6 = r1.f8518c
                long r6 = r6 - r4
                long r2 = java.lang.Math.min(r2, r6)
                int r2 = (int) r2
                androidx.media3.common.util.ParsableByteArray r3 = r0.f9773b
                r3.G(r2)
                byte[] r6 = r3.f5723a
                r7 = 0
                r1.b(r6, r7, r2, r7)
                int r1 = r3.f5725c
                r6 = -1
                r10 = r6
                r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            L26:
                int r2 = r3.a()
                r12 = 188(0xbc, float:2.63E-43)
                if (r2 < r12) goto L9a
                byte[] r2 = r3.f5723a
                int r12 = r3.f5724b
            L32:
                if (r12 >= r1) goto L42
                r15 = r2[r12]
                r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                r8 = 71
                if (r15 == r8) goto L47
                int r12 = r12 + 1
                goto L32
            L42:
                r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            L47:
                int r2 = r12 + 188
                if (r2 <= r1) goto L4c
                goto L9f
            L4c:
                int r6 = r0.f9774c
                long r6 = androidx.media3.extractor.ts.TsUtil.a(r3, r12, r6)
                int r8 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
                if (r8 == 0) goto L95
                androidx.media3.common.util.TimestampAdjuster r8 = r0.f9772a
                long r6 = r8.b(r6)
                int r8 = (r6 > r20 ? 1 : (r6 == r20 ? 0 : -1))
                if (r8 <= 0) goto L7b
                int r1 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
                if (r1 != 0) goto L6c
                androidx.media3.extractor.BinarySearchSeeker$TimestampSearchResult r1 = new androidx.media3.extractor.BinarySearchSeeker$TimestampSearchResult
                r2 = r6
                r6 = -1
                r1.<init>(r2, r4, r6)
                return r1
            L6c:
                long r15 = r4 + r10
                androidx.media3.extractor.BinarySearchSeeker$TimestampSearchResult r12 = new androidx.media3.extractor.BinarySearchSeeker$TimestampSearchResult
                r17 = 0
                r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                r12.<init>(r13, r15, r17)
                return r12
            L7b:
                r13 = r6
                r6 = 100000(0x186a0, double:4.94066E-319)
                long r6 = r6 + r13
                int r6 = (r6 > r20 ? 1 : (r6 == r20 ? 0 : -1))
                if (r6 <= 0) goto L93
                long r1 = (long) r12
                long r9 = r4 + r1
                androidx.media3.extractor.BinarySearchSeeker$TimestampSearchResult r6 = new androidx.media3.extractor.BinarySearchSeeker$TimestampSearchResult
                r11 = 0
                r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                r6.<init>(r7, r9, r11)
                return r6
            L93:
                long r6 = (long) r12
                r10 = r6
            L95:
                r3.J(r2)
                long r6 = (long) r2
                goto L26
            L9a:
                r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            L9f:
                int r1 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
                if (r1 == 0) goto Lad
                long r15 = r4 + r6
                androidx.media3.extractor.BinarySearchSeeker$TimestampSearchResult r12 = new androidx.media3.extractor.BinarySearchSeeker$TimestampSearchResult
                r17 = -2
                r12.<init>(r13, r15, r17)
                return r12
            Lad:
                androidx.media3.extractor.BinarySearchSeeker$TimestampSearchResult r1 = androidx.media3.extractor.BinarySearchSeeker.TimestampSearchResult.f8499d
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.TsBinarySearchSeeker.TsPcrSeeker.a(androidx.media3.extractor.DefaultExtractorInput, long):androidx.media3.extractor.BinarySearchSeeker$TimestampSearchResult");
        }

        @Override // androidx.media3.extractor.BinarySearchSeeker.TimestampSeeker
        public final void b() {
            byte[] bArr = Util.f5749f;
            ParsableByteArray parsableByteArray = this.f9773b;
            parsableByteArray.getClass();
            parsableByteArray.H(bArr.length, bArr);
        }
    }
}
