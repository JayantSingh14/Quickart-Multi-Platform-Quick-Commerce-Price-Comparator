package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class FloatSet {

    /* renamed from: a, reason: collision with root package name */
    public long[] f1427a;

    /* renamed from: b, reason: collision with root package name */
    public float[] f1428b;

    /* renamed from: c, reason: collision with root package name */
    public int f1429c;

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00bc, code lost:
    
        r27 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ca, code lost:
    
        if (((r12 & ((~r12) << 6)) & r23) == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00cc, code lost:
    
        r13 = -1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v3 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r19v5, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r29) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.FloatSet.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        float[] fArr = this.f1428b;
        long[] jArr = this.f1427a;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i2 = 0;
        int iHashCode = 0;
        while (true) {
            long j2 = jArr[i2];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i2 - length)) >>> 31);
                for (int i4 = 0; i4 < i3; i4++) {
                    if ((255 & j2) < 128) {
                        iHashCode = Float.hashCode(fArr[(i2 << 3) + i4]) + iHashCode;
                    }
                    j2 >>= 8;
                }
                if (i3 != 8) {
                    return iHashCode;
                }
            }
            if (i2 == length) {
                return iHashCode;
            }
            i2++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007d A[PHI: r10
      0x007d: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x003f, B:20:0x007b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            r20 = this;
            r0 = r20
            java.lang.String r1 = "separator"
            java.lang.String r2 = ", "
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            java.lang.String r1 = "prefix"
            java.lang.String r3 = "["
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            java.lang.String r1 = "postfix"
            java.lang.String r4 = "]"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r1)
            java.lang.String r1 = "truncated"
            java.lang.String r5 = "..."
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            float[] r3 = r0.f1428b
            long[] r6 = r0.f1427a
            int r7 = r6.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L82
            r9 = 0
            r10 = 0
        L31:
            r11 = r6[r9]
            long r13 = ~r11
            r15 = 7
            long r13 = r13 << r15
            long r13 = r13 & r11
            r15 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r13 = r13 & r15
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 == 0) goto L7d
            int r13 = r9 - r7
            int r13 = ~r13
            int r13 = r13 >>> 31
            r14 = 8
            int r13 = 8 - r13
            r15 = 0
        L4b:
            if (r15 >= r13) goto L7a
            r16 = 255(0xff, double:1.26E-321)
            long r16 = r11 & r16
            r18 = 128(0x80, double:6.32E-322)
            int r16 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r16 >= 0) goto L71
            int r16 = r9 << 3
            int r16 = r16 + r15
            r8 = r3[r16]
            r16 = r14
            r14 = -1
            if (r10 != r14) goto L66
            r1.append(r5)
            goto L85
        L66:
            if (r10 == 0) goto L6b
            r1.append(r2)
        L6b:
            r1.append(r8)
            int r10 = r10 + 1
            goto L73
        L71:
            r16 = r14
        L73:
            long r11 = r11 >> r16
            int r15 = r15 + 1
            r14 = r16
            goto L4b
        L7a:
            r8 = r14
            if (r13 != r8) goto L82
        L7d:
            if (r9 == r7) goto L82
            int r9 = r9 + 1
            goto L31
        L82:
            r1.append(r4)
        L85:
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.FloatSet.toString():java.lang.String");
    }
}
