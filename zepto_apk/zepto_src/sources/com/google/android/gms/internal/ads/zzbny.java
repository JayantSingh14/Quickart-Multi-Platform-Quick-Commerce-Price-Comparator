package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbny implements com.google.android.gms.ads.internal.overlay.zzaa {

    /* renamed from: a, reason: collision with root package name */
    public boolean f25369a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f25370b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.ads.internal.client.zza f25371c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HashMap f25372d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Map f25373e;

    public zzbny(zzboa zzboaVar, boolean z, com.google.android.gms.ads.internal.client.zza zzaVar, HashMap map, Map map2) {
        this.f25370b = z;
        this.f25371c = zzaVar;
        this.f25372d = map;
        this.f25373e = map2;
        Objects.requireNonNull(zzboaVar);
        this.f25369a = false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzaa
    public final void j1(boolean z) {
        if (this.f25369a) {
            return;
        }
        com.google.android.gms.ads.internal.client.zza zzaVar = this.f25371c;
        if (z && this.f25370b) {
            ((zzdir) zzaVar).S();
        }
        this.f25369a = true;
        String str = (String) this.f25373e.get("event_id");
        Boolean boolValueOf = Boolean.valueOf(z);
        HashMap map = this.f25372d;
        map.put(str, boolValueOf);
        ((zzbqj) zzaVar).g("openIntentAsync", map);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzaa
    public final void zzb(int i2) {
    }
}
