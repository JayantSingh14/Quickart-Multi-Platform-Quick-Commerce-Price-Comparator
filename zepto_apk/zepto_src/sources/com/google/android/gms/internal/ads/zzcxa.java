package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzbfp;
import java.util.LinkedList;

/* loaded from: classes4.dex */
public final class zzcxa implements zzdby, com.google.android.gms.ads.internal.client.zza, zzddq, zzdbe, zzdak, zzdgb {

    /* renamed from: a, reason: collision with root package name */
    public final Clock f27335a;

    /* renamed from: b, reason: collision with root package name */
    public final zzccu f27336b;

    public zzcxa(Clock clock, zzccu zzccuVar) {
        this.f27335a = clock;
        this.f27336b = zzccuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final void F(zzfic zzficVar) {
        Clock clock = this.f27335a;
        zzccu zzccuVar = this.f27336b;
        long jElapsedRealtime = clock.elapsedRealtime();
        synchronized (zzccuVar.f25899d) {
            try {
                zzccuVar.f25906k = jElapsedRealtime;
                if (jElapsedRealtime != -1) {
                    zzccuVar.f25897b.a(zzccuVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final void R(zzbza zzbzaVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void T() {
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void b() {
        zzccu zzccuVar = this.f27336b;
        synchronized (zzccuVar.f25899d) {
            try {
                if (zzccuVar.f25906k != -1) {
                    LinkedList linkedList = zzccuVar.f25898c;
                    if (!linkedList.isEmpty()) {
                        zzcct zzcctVar = (zzcct) linkedList.getLast();
                        if (zzcctVar.f25894b == -1) {
                            zzcctVar.f25894b = zzcctVar.f25895c.f25896a.elapsedRealtime();
                            zzccuVar.f25897b.a(zzccuVar);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbe
    public final void f() {
        zzccu zzccuVar = this.f27336b;
        synchronized (zzccuVar.f25899d) {
            try {
                if (zzccuVar.f25906k != -1 && zzccuVar.f25902g == -1) {
                    zzccuVar.f25902g = zzccuVar.f25896a.elapsedRealtime();
                    zzccuVar.f25897b.a(zzccuVar);
                }
                zzcdf zzcdfVar = zzccuVar.f25897b;
                synchronized (zzcdfVar.f25962a) {
                    zzcdc zzcdcVar = zzcdfVar.f25965d;
                    synchronized (zzcdcVar.f25952f) {
                        zzcdcVar.f25957k++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void g() {
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void h() {
        zzccu zzccuVar = this.f27336b;
        synchronized (zzccuVar.f25899d) {
            if (zzccuVar.f25906k != -1) {
                zzcct zzcctVar = new zzcct(zzccuVar);
                zzcctVar.f25893a = zzcctVar.f25895c.f25896a.elapsedRealtime();
                zzccuVar.f25898c.add(zzcctVar);
                zzccuVar.f25904i++;
                zzcdf zzcdfVar = zzccuVar.f25897b;
                synchronized (zzcdfVar.f25962a) {
                    zzcdc zzcdcVar = zzcdfVar.f25965d;
                    synchronized (zzcdcVar.f25952f) {
                        zzcdcVar.f25956j++;
                    }
                }
                zzcdfVar.a(zzccuVar);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdgb
    public final void i0(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzdgb
    public final void l0(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzdgb
    public final void m(zzbfp.zzb zzbVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdgb
    public final void s0(zzbfp.zzb zzbVar) {
        zzccu zzccuVar = this.f27336b;
        synchronized (zzccuVar.f25899d) {
            zzcdf zzcdfVar = zzccuVar.f25897b;
            synchronized (zzcdfVar.f25962a) {
                zzcdfVar.f25965d.b();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdgb
    public final void y(zzbfp.zzb zzbVar) {
        zzccu zzccuVar = this.f27336b;
        synchronized (zzccuVar.f25899d) {
            zzcdf zzcdfVar = zzccuVar.f25897b;
            synchronized (zzcdfVar.f25962a) {
                zzcdfVar.f25965d.b();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    public final void zzg() {
        zzccu zzccuVar = this.f27336b;
        synchronized (zzccuVar.f25899d) {
            try {
                if (zzccuVar.f25906k != -1) {
                    zzccuVar.f25903h = zzccuVar.f25896a.elapsedRealtime();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdgb
    public final void zzo() {
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void Y(zzbzj zzbzjVar, String str, String str2) {
    }
}
