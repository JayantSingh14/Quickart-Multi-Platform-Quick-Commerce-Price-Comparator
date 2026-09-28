package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.cache.Striped64;
import java.io.Serializable;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
final class LongAdder extends Striped64 implements Serializable, LongAddable {
    @Override // com.google.common.cache.LongAddable
    public final void a() {
        b(1L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b3, code lost:
    
        if (r13.f42447a != r6) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00b5, code lost:
    
        r5 = new com.google.common.cache.Striped64.Cell[r7 << 1];
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ba, code lost:
    
        if (r8 >= r7) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00bc, code lost:
    
        r5[r8] = r6[r8];
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00c5, code lost:
    
        r13.f42447a = r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0112 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0049 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007e  */
    @Override // com.google.common.cache.LongAddable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(long r14) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LongAdder.b(long):void");
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return f();
    }

    public final long f() {
        long j2 = this.f42448b;
        Striped64.Cell[] cellArr = this.f42447a;
        if (cellArr != null) {
            for (Striped64.Cell cell : cellArr) {
                if (cell != null) {
                    j2 += cell.f42452a;
                }
            }
        }
        return j2;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return f();
    }

    @Override // java.lang.Number
    public final int intValue() {
        return (int) f();
    }

    @Override // java.lang.Number
    public final long longValue() {
        return f();
    }

    public final String toString() {
        return Long.toString(f());
    }
}
