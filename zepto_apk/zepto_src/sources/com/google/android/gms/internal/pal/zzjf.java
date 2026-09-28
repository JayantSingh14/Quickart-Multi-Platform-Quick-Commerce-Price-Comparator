package com.google.android.gms.internal.pal;

import java.util.AbstractMap;

/* loaded from: classes4.dex */
final class zzjf extends zziz {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzjg f37835c;

    public zzjf(zzjg zzjgVar) {
        this.f37835c = zzjgVar;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzjg zzjgVar = this.f37835c;
        zzip.a(i2, zzjgVar.f37838e);
        int i3 = i2 + i2;
        Object[] objArr = zzjgVar.f37837d;
        Object obj = objArr[i3];
        obj.getClass();
        Object obj2 = objArr[i3 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f37835c.f37838e;
    }
}
