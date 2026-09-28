package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;

/* loaded from: classes4.dex */
final class zzgut extends zzgrc {

    /* renamed from: f, reason: collision with root package name */
    public final transient zzgqs f33230f;

    public zzgut(Map map, zzgqs zzgqsVar) {
        super(map);
        this.f33230f = zzgqsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgrt, com.google.android.gms.internal.ads.zzgrw
    public final Map a() {
        Map map = this.f33127d;
        return map instanceof NavigableMap ? new zzgrk(this, (NavigableMap) map) : map instanceof SortedMap ? new zzgrn(this, (SortedMap) map) : new zzgrg(this, map);
    }

    public final /* bridge */ /* synthetic */ Collection f() {
        return (List) ((zzguo) this.f33230f).zza();
    }
}
