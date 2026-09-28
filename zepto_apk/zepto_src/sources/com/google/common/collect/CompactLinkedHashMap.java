package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@J2ktIncompatible
@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {

    /* renamed from: k, reason: collision with root package name */
    public transient long[] f42575k;

    /* renamed from: l, reason: collision with root package name */
    public transient int f42576l;

    /* renamed from: m, reason: collision with root package name */
    public transient int f42577m;

    @Override // com.google.common.collect.CompactHashMap
    public final void a(int i2) {
    }

    @Override // com.google.common.collect.CompactHashMap
    public final int b(int i2, int i3) {
        return i2 >= size() ? i3 : i2;
    }

    @Override // com.google.common.collect.CompactHashMap
    public final int c() {
        int iC = super.c();
        this.f42575k = new long[iC];
        return iC;
    }

    @Override // com.google.common.collect.CompactHashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (p()) {
            return;
        }
        this.f42576l = -2;
        this.f42577m = -2;
        long[] jArr = this.f42575k;
        if (jArr != null) {
            Arrays.fill(jArr, 0, size(), 0L);
        }
        super.clear();
    }

    @Override // com.google.common.collect.CompactHashMap
    public final Map d() {
        Map mapD = super.d();
        this.f42575k = null;
        return mapD;
    }

    @Override // com.google.common.collect.CompactHashMap
    public final LinkedHashMap f(int i2) {
        return new LinkedHashMap(i2, 1.0f, false);
    }

    @Override // com.google.common.collect.CompactHashMap
    public final int h() {
        return this.f42576l;
    }

    @Override // com.google.common.collect.CompactHashMap
    public final int i(int i2) {
        return ((int) w()[i2]) - 1;
    }

    @Override // com.google.common.collect.CompactHashMap
    public final void m(int i2) {
        super.m(i2);
        this.f42576l = -2;
        this.f42577m = -2;
    }

    @Override // com.google.common.collect.CompactHashMap
    public final void n(int i2, Object obj, Object obj2, int i3, int i4) {
        super.n(i2, obj, obj2, i3, i4);
        x(this.f42577m, i2);
        x(i2, -2);
    }

    @Override // com.google.common.collect.CompactHashMap
    public final void o(int i2, int i3) {
        int size = size() - 1;
        super.o(i2, i3);
        x(((int) (w()[i2] >>> 32)) - 1, i(i2));
        if (i2 < size) {
            x(((int) (w()[size] >>> 32)) - 1, i2);
            x(i2, i(size));
        }
        w()[size] = 0;
    }

    @Override // com.google.common.collect.CompactHashMap
    public final void u(int i2) {
        super.u(i2);
        this.f42575k = Arrays.copyOf(w(), i2);
    }

    public final long[] w() {
        long[] jArr = this.f42575k;
        Objects.requireNonNull(jArr);
        return jArr;
    }

    public final void x(int i2, int i3) {
        if (i2 == -2) {
            this.f42576l = i3;
        } else {
            w()[i2] = (w()[i2] & (-4294967296L)) | ((i3 + 1) & 4294967295L);
        }
        if (i3 == -2) {
            this.f42577m = i2;
        } else {
            w()[i3] = (4294967295L & w()[i3]) | ((i2 + 1) << 32);
        }
    }
}
