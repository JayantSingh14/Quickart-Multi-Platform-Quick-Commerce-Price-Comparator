package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class IntIntMap {

    /* renamed from: a, reason: collision with root package name */
    public long[] f1438a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f1439b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f1440c;

    /* renamed from: d, reason: collision with root package name */
    public int f1441d;

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c6, code lost:
    
        r27 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00d0, code lost:
    
        if (((r2 & ((~r2) << 6)) & r19) == 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00d2, code lost:
    
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
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntIntMap.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int[] iArr = this.f1439b;
        int[] iArr2 = this.f1440c;
        long[] jArr = this.f1438a;
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
                        int i6 = iArr[i5];
                        iHashCode += Integer.hashCode(iArr2[i5]) ^ Integer.hashCode(i6);
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
