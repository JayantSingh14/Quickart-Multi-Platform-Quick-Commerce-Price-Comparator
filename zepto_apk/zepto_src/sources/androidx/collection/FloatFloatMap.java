package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class FloatFloatMap {

    /* renamed from: a, reason: collision with root package name */
    public long[] f1410a;

    /* renamed from: b, reason: collision with root package name */
    public float[] f1411b;

    /* renamed from: c, reason: collision with root package name */
    public float[] f1412c;

    /* renamed from: d, reason: collision with root package name */
    public int f1413d;

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c7, code lost:
    
        r27 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00d1, code lost:
    
        if (((r2 & ((~r2) << 6)) & r20) == 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00d3, code lost:
    
        r25 = -1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r29) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.FloatFloatMap.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        float[] fArr = this.f1411b;
        float[] fArr2 = this.f1412c;
        long[] jArr = this.f1410a;
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
                        int i5 = (i2 << 3) + i4;
                        float f2 = fArr[i5];
                        iHashCode += Float.hashCode(fArr2[i5]) ^ Float.hashCode(f2);
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

    public final String toString() {
        return "{}";
    }
}
