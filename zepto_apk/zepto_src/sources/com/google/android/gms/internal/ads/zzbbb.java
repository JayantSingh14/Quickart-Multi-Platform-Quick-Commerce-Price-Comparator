package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public final class zzbbb extends zzbbh {

    /* renamed from: h, reason: collision with root package name */
    public final zzbaa f24657h;

    /* renamed from: i, reason: collision with root package name */
    public final long f24658i;

    public zzbbb(zzazt zzaztVar, zzavs zzavsVar, int i2, zzbaa zzbaaVar) {
        super(zzaztVar, "7i2iPrjrwVOXQymI9kbzBw+Saen0JiBKsL25H084g9vqkkZvrS3PC/gXCAaliMdd", "jjLuguQ1TtUBIYvLkWHGRHLEQB49t1f8VaYjdD5pX6Q=", zzavsVar, i2, 53);
        this.f24657h = zzbaaVar;
        if (zzbaaVar != null) {
            if (zzbaaVar.f24619l <= -2) {
                WeakReference weakReference = zzbaaVar.f24615h;
                if ((weakReference != null ? (View) weakReference.get() : null) == null) {
                    zzbaaVar.f24619l = -3L;
                }
            }
            this.f24658i = zzbaaVar.f24619l;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void a() {
        if (this.f24657h != null) {
            long jLongValue = ((Long) this.f24673e.invoke(null, Long.valueOf(this.f24658i))).longValue();
            zzavs zzavsVar = this.f24672d;
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).U(jLongValue);
        }
    }
}
