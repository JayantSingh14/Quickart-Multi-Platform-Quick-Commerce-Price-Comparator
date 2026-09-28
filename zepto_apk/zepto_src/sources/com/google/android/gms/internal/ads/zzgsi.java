package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzgsi extends zzgru {

    /* renamed from: a, reason: collision with root package name */
    public final Object f33151a;

    /* renamed from: b, reason: collision with root package name */
    public int f33152b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzgsk f33153c;

    public zzgsi(zzgsk zzgskVar, int i2) {
        Objects.requireNonNull(zzgskVar);
        this.f33153c = zzgskVar;
        this.f33151a = zzgskVar.b()[i2];
        this.f33152b = i2;
    }

    public final void a() {
        int i2 = this.f33152b;
        Object obj = this.f33151a;
        zzgsk zzgskVar = this.f33153c;
        if (i2 != -1 && i2 < zzgskVar.size()) {
            if (Objects.equals(obj, zzgskVar.b()[this.f33152b])) {
                return;
            }
        }
        this.f33152b = zzgskVar.i(obj);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f33151a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        zzgsk zzgskVar = this.f33153c;
        Map mapE = zzgskVar.e();
        if (mapE != null) {
            return mapE.get(this.f33151a);
        }
        a();
        int i2 = this.f33152b;
        if (i2 == -1) {
            return null;
        }
        return zzgskVar.c()[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzgru, java.util.Map.Entry
    public final Object setValue(Object obj) {
        zzgsk zzgskVar = this.f33153c;
        Map mapE = zzgskVar.e();
        Object obj2 = this.f33151a;
        if (mapE != null) {
            return mapE.put(obj2, obj);
        }
        a();
        int i2 = this.f33152b;
        if (i2 == -1) {
            zzgskVar.put(obj2, obj);
            return null;
        }
        Object obj3 = zzgskVar.c()[i2];
        zzgskVar.c()[this.f33152b] = obj;
        return obj3;
    }
}
