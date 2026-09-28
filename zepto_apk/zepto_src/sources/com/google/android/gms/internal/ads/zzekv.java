package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzekv extends zzbte implements zzdbu {

    /* renamed from: a, reason: collision with root package name */
    public zzeok f29583a;

    /* renamed from: b, reason: collision with root package name */
    public zzdbt f29584b;

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void B() {
        zzeok zzeokVar = this.f29583a;
        if (zzeokVar != null) {
            zzeokVar.B();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void D4() {
        zzeok zzeokVar = this.f29583a;
        if (zzeokVar != null) {
            zzeokVar.D4();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void H1(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzdbt zzdbtVar = this.f29584b;
        if (zzdbtVar != null) {
            zzeof zzeofVar = (zzeof) zzdbtVar;
            synchronized (zzeofVar) {
                if (!zzeofVar.f29948a) {
                    zzeofVar.f29948a = true;
                    zzeofVar.a(zzeVar);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void K(int i2) {
        zzeok zzeokVar = this.f29583a;
        if (zzeokVar != null) {
            zzeokVar.K(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void Qb(int i2, String str) {
        zzdbt zzdbtVar = this.f29584b;
        if (zzdbtVar != null) {
            zzeof zzeofVar = (zzeof) zzdbtVar;
            synchronized (zzeofVar) {
                try {
                    if (!zzeofVar.f29948a) {
                        zzeofVar.f29948a = true;
                        if (str == null) {
                            str = zzeoi.c(i2, zzeofVar.f29949b.f29462a);
                        }
                        zzeofVar.a(new com.google.android.gms.ads.internal.client.zze(i2, str, "undefined", null, null));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void V5(String str, String str2) {
        zzeok zzeokVar = this.f29583a;
        if (zzeokVar != null) {
            zzeokVar.V5(str, str2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void Y0(String str) {
        zzeok zzeokVar = this.f29583a;
        if (zzeokVar != null) {
            zzeokVar.Y0(str);
        }
    }

    public final synchronized void Yb(zzeok zzeokVar) {
        this.f29583a = zzeokVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void Z0() {
        zzeok zzeokVar = this.f29583a;
        if (zzeokVar != null) {
            zzeokVar.Z0();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void d2(zzbks zzbksVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void hb(zzcac zzcacVar) {
        zzeok zzeokVar = this.f29583a;
        if (zzeokVar != null) {
            zzeokVar.hb(zzcacVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void m0() {
        zzeok zzeokVar = this.f29583a;
        if (zzeokVar != null) {
            zzeokVar.m0();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbu
    public final synchronized void m9(zzdbt zzdbtVar) {
        this.f29584b = zzdbtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void o2(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzeok zzeokVar = this.f29583a;
        if (zzeokVar != null) {
            zzeokVar.o2(zzeVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void p0() {
        zzeok zzeokVar = this.f29583a;
        if (zzeokVar != null) {
            zzeokVar.p0();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void v8(zzbzy zzbzyVar) {
        zzeok zzeokVar = this.f29583a;
        if (zzeokVar != null) {
            zzeokVar.v8(zzbzyVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void zze() {
        zzeok zzeokVar = this.f29583a;
        if (zzeokVar != null) {
            zzeokVar.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void zzf() {
        zzeok zzeokVar = this.f29583a;
        if (zzeokVar != null) {
            zzeokVar.zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void zzg(int i2) {
        zzdbt zzdbtVar = this.f29584b;
        if (zzdbtVar != null) {
            zzdbtVar.zzb(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void zzh() {
        zzeok zzeokVar = this.f29583a;
        if (zzeokVar != null) {
            zzeokVar.zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void zzi() {
        zzeok zzeokVar = this.f29583a;
        if (zzeokVar != null) {
            zzeokVar.zzi();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void zzj() {
        try {
            zzeok zzeokVar = this.f29583a;
            if (zzeokVar != null) {
                zzeokVar.zzj();
            }
            zzdbt zzdbtVar = this.f29584b;
            if (zzdbtVar != null) {
                ((zzeof) zzdbtVar).zza();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void zzk() {
        zzeok zzeokVar = this.f29583a;
        if (zzeokVar != null) {
            zzeokVar.zzk();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void zzo() {
        zzeok zzeokVar = this.f29583a;
        if (zzeokVar != null) {
            zzeokVar.zzo();
        }
    }
}
