package com.google.android.gms.internal.pal;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzjg extends zzjd {

    /* renamed from: c, reason: collision with root package name */
    public final transient zzjc f37836c;

    /* renamed from: d, reason: collision with root package name */
    public final transient Object[] f37837d;

    /* renamed from: e, reason: collision with root package name */
    public final transient int f37838e;

    public zzjg(zzjc zzjcVar, Object[] objArr, int i2) {
        this.f37836c = zzjcVar;
        this.f37837d = objArr;
        this.f37838e = i2;
    }

    @Override // com.google.android.gms.internal.pal.zziw
    public final int b(Object[] objArr) {
        return j().b(objArr);
    }

    @Override // com.google.android.gms.internal.pal.zziw, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f37836c.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.pal.zziw
    /* renamed from: g */
    public final zzjl iterator() {
        return j().listIterator(0);
    }

    @Override // com.google.android.gms.internal.pal.zzjd, com.google.android.gms.internal.pal.zziw, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return j().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f37838e;
    }
}
