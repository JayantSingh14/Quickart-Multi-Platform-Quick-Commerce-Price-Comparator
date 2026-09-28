package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class LongSet {

    /* renamed from: a, reason: collision with root package name */
    public long[] f1472a;

    /* renamed from: b, reason: collision with root package name */
    public long[] f1473b;

    /* renamed from: c, reason: collision with root package name */
    public int f1474c;

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00bc, code lost:
    
        r28 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ca, code lost:
    
        if (((r12 & ((~r12) << 6)) & r24) == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00cc, code lost:
    
        r13 = -1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r20v5, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r30) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongSet.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        long[] jArr = this.f1473b;
        long[] jArr2 = this.f1472a;
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
                        iHashCode = Long.hashCode(jArr[(i2 << 3) + i4]) + iHashCode;
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
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(", ", "separator");
        Intrinsics.checkNotNullParameter("[", "prefix");
        Intrinsics.checkNotNullParameter("]", "postfix");
        Intrinsics.checkNotNullParameter("...", "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "[");
        long[] jArr = this.f1473b;
        long[] jArr2 = this.f1472a;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i5 = 0;
            int i6 = 0;
            loop0: while (true) {
                long j2 = jArr2[i5];
                if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i7 = 8;
                    int i8 = 8 - ((~(i5 - length)) >>> 31);
                    int i9 = 0;
                    while (i9 < i8) {
                        if ((j2 & 255) < 128) {
                            i3 = i5;
                            long j3 = jArr[(i5 << 3) + i9];
                            i4 = i7;
                            if (i6 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i6 != 0) {
                                sb.append((CharSequence) ", ");
                            }
                            sb.append(j3);
                            i6++;
                        } else {
                            i3 = i5;
                            i4 = i7;
                        }
                        j2 >>= i4;
                        i9++;
                        i7 = i4;
                        i5 = i3;
                    }
                    int i10 = i5;
                    if (i8 != i7) {
                        break;
                    }
                    i2 = i10;
                } else {
                    i2 = i5;
                }
                if (i2 == length) {
                    break;
                }
                i5 = i2 + 1;
            }
            sb.append((CharSequence) "]");
        } else {
            sb.append((CharSequence) "]");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
