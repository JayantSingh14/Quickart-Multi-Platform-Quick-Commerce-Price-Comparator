package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class LongIntMap {

    /* renamed from: a, reason: collision with root package name */
    public long[] f1459a;

    /* renamed from: b, reason: collision with root package name */
    public long[] f1460b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f1461c;

    /* renamed from: d, reason: collision with root package name */
    public int f1462d;

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00d0, code lost:
    
        if (((r2 & ((~r2) << 6)) & r20) == 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00d2, code lost:
    
        r0 = -1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r31) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongIntMap.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        long[] jArr = this.f1460b;
        int[] iArr = this.f1461c;
        long[] jArr2 = this.f1459a;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i2 = 0;
        int iHashCode = 0;
        while (true) {
            long j2 = jArr2[i2];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i2 - length)) >>> 31);
                for (int i4 = 0; i4 < i3; i4++) {
                    if ((255 & j2) < 128) {
                        int i5 = (i2 << 3) + i4;
                        long j3 = jArr[i5];
                        iHashCode += Integer.hashCode(iArr[i5]) ^ Long.hashCode(j3);
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
