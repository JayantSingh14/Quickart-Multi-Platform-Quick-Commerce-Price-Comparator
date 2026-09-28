package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class LongLongMap {

    /* renamed from: a, reason: collision with root package name */
    public long[] f1464a;

    /* renamed from: b, reason: collision with root package name */
    public long[] f1465b;

    /* renamed from: c, reason: collision with root package name */
    public long[] f1466c;

    /* renamed from: d, reason: collision with root package name */
    public int f1467d;

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ce, code lost:
    
        if (((r2 & ((~r2) << 6)) & r22) == 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00d0, code lost:
    
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
    public final boolean equals(java.lang.Object r32) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongLongMap.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        long[] jArr = this.f1465b;
        long[] jArr2 = this.f1466c;
        long[] jArr3 = this.f1464a;
        int length = jArr3.length - 2;
        if (length < 0) {
            return 0;
        }
        int i2 = 0;
        int iHashCode = 0;
        while (true) {
            long j2 = jArr3[i2];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i2 - length)) >>> 31);
                for (int i4 = 0; i4 < i3; i4++) {
                    if ((255 & j2) < 128) {
                        int i5 = (i2 << 3) + i4;
                        iHashCode += Long.hashCode(jArr[i5]) ^ Long.hashCode(jArr2[i5]);
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
