package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
final class zzhl extends zzgst {

    /* renamed from: a, reason: collision with root package name */
    public final Map f33966a;

    public zzhl(Map map) {
        this.f33966a = map;
    }

    @Override // com.google.android.gms.internal.ads.zzgst, com.google.android.gms.internal.ads.zzgsu
    public final /* synthetic */ Object b() {
        return this.f33966a;
    }

    @Override // com.google.android.gms.internal.ads.zzgst, java.util.Map
    public final boolean containsKey(Object obj) {
        return obj != null && super.containsKey(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgst, java.util.Map
    public final boolean containsValue(Object obj) {
        Iterator it = entrySet().iterator();
        zzguf zzgufVar = new zzguf(it);
        if (obj == null) {
            while (it.hasNext()) {
                if (zzgufVar.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(zzgufVar.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgst
    public final Map d() {
        return this.f33966a;
    }

    @Override // com.google.android.gms.internal.ads.zzgst, java.util.Map
    public final Set entrySet() {
        return zzgvn.b(this.f33966a.entrySet(), zzhj.f33877a);
    }

    @Override // com.google.android.gms.internal.ads.zzgst, java.util.Map
    public final boolean equals(Object obj) {
        return obj != null && zzguk.a(obj, this);
    }

    @Override // com.google.android.gms.internal.ads.zzgst, java.util.Map
    public final /* synthetic */ Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        return (List) this.f33966a.get(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgst, java.util.Map
    public final int hashCode() {
        return zzgvn.c(entrySet());
    }

    @Override // com.google.android.gms.internal.ads.zzgst, java.util.Map
    public final boolean isEmpty() {
        if (this.f33966a.isEmpty()) {
            return true;
        }
        return super.size() == 1 && super.containsKey(null);
    }

    @Override // com.google.android.gms.internal.ads.zzgst, java.util.Map
    public final Set keySet() {
        return zzgvn.b(this.f33966a.keySet(), zzhk.f33915a);
    }

    @Override // com.google.android.gms.internal.ads.zzgst, java.util.Map
    public final int size() {
        return super.size() - (super.containsKey(null) ? 1 : 0);
    }
}
