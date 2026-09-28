package androidx.media3.extractor;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class BinarySearchSeeker {

    /* renamed from: a, reason: collision with root package name */
    public final BinarySearchSeekMap f8481a;

    /* renamed from: b, reason: collision with root package name */
    public final TimestampSeeker f8482b;

    /* renamed from: c, reason: collision with root package name */
    public SeekOperationParams f8483c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8484d;

    public static class BinarySearchSeekMap implements SeekMap {

        /* renamed from: a, reason: collision with root package name */
        public final SeekTimestampConverter f8485a;

        /* renamed from: b, reason: collision with root package name */
        public final long f8486b;

        /* renamed from: c, reason: collision with root package name */
        public final long f8487c;

        /* renamed from: d, reason: collision with root package name */
        public final long f8488d;

        /* renamed from: e, reason: collision with root package name */
        public final long f8489e;

        /* renamed from: f, reason: collision with root package name */
        public final long f8490f;

        public BinarySearchSeekMap(SeekTimestampConverter seekTimestampConverter, long j2, long j3, long j4, long j5, long j6) {
            this.f8485a = seekTimestampConverter;
            this.f8486b = j2;
            this.f8487c = j3;
            this.f8488d = j4;
            this.f8489e = j5;
            this.f8490f = j6;
        }

        @Override // androidx.media3.extractor.SeekMap
        public final SeekMap.SeekPoints d(long j2) {
            SeekPoint seekPoint = new SeekPoint(j2, SeekOperationParams.a(this.f8485a.a(j2), 0L, this.f8487c, this.f8488d, this.f8489e, this.f8490f));
            return new SeekMap.SeekPoints(seekPoint, seekPoint);
        }

        @Override // androidx.media3.extractor.SeekMap
        public final boolean g() {
            return true;
        }

        @Override // androidx.media3.extractor.SeekMap
        public final long l() {
            return this.f8486b;
        }
    }

    public static final class DefaultSeekTimestampConverter implements SeekTimestampConverter {
        @Override // androidx.media3.extractor.BinarySearchSeeker.SeekTimestampConverter
        public final long a(long j2) {
            return j2;
        }
    }

    public static class SeekOperationParams {

        /* renamed from: a, reason: collision with root package name */
        public final long f8491a;

        /* renamed from: b, reason: collision with root package name */
        public final long f8492b;

        /* renamed from: c, reason: collision with root package name */
        public final long f8493c;

        /* renamed from: d, reason: collision with root package name */
        public long f8494d = 0;

        /* renamed from: e, reason: collision with root package name */
        public long f8495e;

        /* renamed from: f, reason: collision with root package name */
        public long f8496f;

        /* renamed from: g, reason: collision with root package name */
        public long f8497g;

        /* renamed from: h, reason: collision with root package name */
        public long f8498h;

        public SeekOperationParams(long j2, long j3, long j4, long j5, long j6, long j7) {
            this.f8491a = j2;
            this.f8492b = j3;
            this.f8495e = j4;
            this.f8496f = j5;
            this.f8497g = j6;
            this.f8493c = j7;
            this.f8498h = a(j3, 0L, j4, j5, j6, j7);
        }

        public static long a(long j2, long j3, long j4, long j5, long j6, long j7) {
            if (j5 + 1 >= j6 || j3 + 1 >= j4) {
                return j5;
            }
            long j8 = (long) ((j2 - j3) * ((j6 - j5) / (j4 - j3)));
            return Util.l(((j8 + j5) - j7) - (j8 / 20), j5, j6 - 1);
        }
    }

    public interface SeekTimestampConverter {
        long a(long j2);
    }

    public static final class TimestampSearchResult {

        /* renamed from: d, reason: collision with root package name */
        public static final TimestampSearchResult f8499d = new TimestampSearchResult(-9223372036854775807L, -1, -3);

        /* renamed from: a, reason: collision with root package name */
        public final int f8500a;

        /* renamed from: b, reason: collision with root package name */
        public final long f8501b;

        /* renamed from: c, reason: collision with root package name */
        public final long f8502c;

        public TimestampSearchResult(long j2, long j3, int i2) {
            this.f8500a = i2;
            this.f8501b = j2;
            this.f8502c = j3;
        }
    }

    public interface TimestampSeeker {
        TimestampSearchResult a(DefaultExtractorInput defaultExtractorInput, long j2);

        default void b() {
        }
    }

    public BinarySearchSeeker(SeekTimestampConverter seekTimestampConverter, TimestampSeeker timestampSeeker, long j2, long j3, long j4, long j5, long j6, int i2) {
        this.f8482b = timestampSeeker;
        this.f8484d = i2;
        this.f8481a = new BinarySearchSeekMap(seekTimestampConverter, j2, j3, j4, j5, j6);
    }

    public static int b(DefaultExtractorInput defaultExtractorInput, long j2, PositionHolder positionHolder) {
        if (j2 == defaultExtractorInput.f8519d) {
            return 0;
        }
        positionHolder.f8599a = j2;
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c6, code lost:
    
        return b(r28, r8, r29);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(androidx.media3.extractor.DefaultExtractorInput r28, androidx.media3.extractor.PositionHolder r29) throws java.io.EOFException, java.io.InterruptedIOException {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r2 = r29
        L6:
            androidx.media3.extractor.BinarySearchSeeker$SeekOperationParams r3 = r0.f8483c
            androidx.media3.common.util.Assertions.h(r3)
            long r4 = r3.f8496f
            long r6 = r3.f8497g
            long r8 = r3.f8498h
            long r6 = r6 - r4
            int r10 = r0.f8484d
            long r10 = (long) r10
            int r6 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            r7 = 0
            androidx.media3.extractor.BinarySearchSeeker$TimestampSeeker r10 = r0.f8482b
            if (r6 > 0) goto L26
            r0.f8483c = r7
            r10.b()
            int r1 = b(r1, r4, r2)
            return r1
        L26:
            long r4 = r1.f8519d
            long r4 = r8 - r4
            r11 = 0
            int r6 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r6 < 0) goto Lc2
            r13 = 262144(0x40000, double:1.295163E-318)
            int r6 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r6 > 0) goto Lc2
            int r4 = (int) r4
            r1.i(r4)
            r4 = 0
            r1.f8521f = r4
            long r4 = r3.f8492b
            androidx.media3.extractor.BinarySearchSeeker$TimestampSearchResult r4 = r10.a(r1, r4)
            r5 = -3
            int r6 = r4.f8500a
            if (r6 == r5) goto Lb8
            r5 = -2
            long r8 = r4.f8501b
            r15 = r11
            long r11 = r4.f8502c
            if (r6 == r5) goto L97
            r4 = -1
            if (r6 == r4) goto L78
            if (r6 != 0) goto L70
            long r3 = r1.f8519d
            long r3 = r11 - r3
            int r5 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1))
            if (r5 < 0) goto L66
            int r5 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r5 > 0) goto L66
            int r3 = (int) r3
            r1.i(r3)
        L66:
            r0.f8483c = r7
            r10.b()
            int r1 = b(r1, r11, r2)
            return r1
        L70:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Invalid case"
            r1.<init>(r2)
            throw r1
        L78:
            r3.f8495e = r8
            r3.f8497g = r11
            long r4 = r3.f8494d
            long r6 = r3.f8496f
            long r13 = r3.f8493c
            r17 = r4
            long r4 = r3.f8492b
            r15 = r4
            r21 = r6
            r19 = r8
            r23 = r11
            r25 = r13
            long r4 = androidx.media3.extractor.BinarySearchSeeker.SeekOperationParams.a(r15, r17, r19, r21, r23, r25)
            r3.f8498h = r4
            goto L6
        L97:
            r4 = r8
            r6 = r11
            r3.f8494d = r4
            r3.f8496f = r6
            long r8 = r3.f8495e
            long r10 = r3.f8497g
            long r12 = r3.f8493c
            long r14 = r3.f8492b
            r17 = r4
            r21 = r6
            r19 = r8
            r23 = r10
            r25 = r12
            r15 = r14
            long r4 = androidx.media3.extractor.BinarySearchSeeker.SeekOperationParams.a(r15, r17, r19, r21, r23, r25)
            r3.f8498h = r4
            goto L6
        Lb8:
            r0.f8483c = r7
            r10.b()
            int r1 = b(r1, r8, r2)
            return r1
        Lc2:
            int r1 = b(r1, r8, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.BinarySearchSeeker.a(androidx.media3.extractor.DefaultExtractorInput, androidx.media3.extractor.PositionHolder):int");
    }

    public final void c(long j2) {
        SeekOperationParams seekOperationParams = this.f8483c;
        if (seekOperationParams == null || seekOperationParams.f8491a != j2) {
            BinarySearchSeekMap binarySearchSeekMap = this.f8481a;
            this.f8483c = new SeekOperationParams(j2, binarySearchSeekMap.f8485a.a(j2), binarySearchSeekMap.f8487c, binarySearchSeekMap.f8488d, binarySearchSeekMap.f8489e, binarySearchSeekMap.f8490f);
        }
    }
}
