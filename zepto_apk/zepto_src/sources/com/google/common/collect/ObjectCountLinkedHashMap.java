package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Arrays;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
class ObjectCountLinkedHashMap<K> extends ObjectCountHashMap<K> {

    /* renamed from: i, reason: collision with root package name */
    public transient long[] f42987i;

    /* renamed from: j, reason: collision with root package name */
    public transient int f42988j;

    /* renamed from: k, reason: collision with root package name */
    public transient int f42989k;

    @Override // com.google.common.collect.ObjectCountHashMap
    public final void a() {
        super.a();
        this.f42988j = -2;
        this.f42989k = -2;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public final int c() {
        int i2 = this.f42988j;
        if (i2 == -2) {
            return -1;
        }
        return i2;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public final void h(int i2) {
        super.h(i2);
        this.f42988j = -2;
        this.f42989k = -2;
        long[] jArr = new long[i2];
        this.f42987i = jArr;
        Arrays.fill(jArr, -1L);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public final void i(Object obj, int i2, int i3, int i4) {
        super.i(obj, i2, i3, i4);
        q(this.f42989k, i2);
        q(i2, -2);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public final void j(int i2) {
        int i3 = this.f42978c - 1;
        long j2 = this.f42987i[i2];
        q((int) (j2 >>> 32), (int) j2);
        if (i2 < i3) {
            q((int) (this.f42987i[i3] >>> 32), i2);
            q(i2, (int) this.f42987i[i3]);
        }
        super.j(i2);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public final int k(int i2) {
        int i3 = (int) this.f42987i[i2];
        if (i3 == -2) {
            return -1;
        }
        return i3;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public final int l(int i2, int i3) {
        return i2 == this.f42978c ? i3 : i2;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public final void o(int i2) {
        super.o(i2);
        long[] jArr = this.f42987i;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, i2);
        this.f42987i = jArrCopyOf;
        Arrays.fill(jArrCopyOf, length, i2, -1L);
    }

    public final void q(int i2, int i3) {
        if (i2 == -2) {
            this.f42988j = i3;
        } else {
            long[] jArr = this.f42987i;
            jArr[i2] = (jArr[i2] & (-4294967296L)) | (i3 & 4294967295L);
        }
        if (i3 == -2) {
            this.f42989k = i2;
        } else {
            long[] jArr2 = this.f42987i;
            jArr2[i3] = (4294967295L & jArr2[i3]) | (i2 << 32);
        }
    }
}
