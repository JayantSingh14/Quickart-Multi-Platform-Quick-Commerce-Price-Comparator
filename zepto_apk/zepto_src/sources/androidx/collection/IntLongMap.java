package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class IntLongMap {

    /* renamed from: a, reason: collision with root package name */
    public long[] f1443a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f1444b;

    /* renamed from: c, reason: collision with root package name */
    public long[] f1445c;

    /* renamed from: d, reason: collision with root package name */
    public int f1446d;

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c5, code lost:
    
        r28 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00cf, code lost:
    
        if (((r2 & ((~r2) << 6)) & r21) == 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00d1, code lost:
    
        r26 = -1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r30) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntLongMap.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int[] iArr = this.f1444b;
        long[] jArr = this.f1445c;
        long[] jArr2 = this.f1443a;
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
                        iHashCode += Integer.hashCode(iArr[i5]) ^ Long.hashCode(jArr[i5]);
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
