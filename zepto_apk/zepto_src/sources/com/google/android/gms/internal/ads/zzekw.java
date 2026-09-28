package com.google.android.gms.internal.ads;

import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public final class zzekw extends zzbzw implements zzdbu {

    /* renamed from: a, reason: collision with root package name */
    public zzbzx f29585a;

    /* renamed from: b, reason: collision with root package name */
    public zzdbt f29586b;

    /* renamed from: c, reason: collision with root package name */
    public zzdjc f29587c;

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final synchronized void C8(IObjectWrapper iObjectWrapper, int i2) {
        zzdbt zzdbtVar = this.f29586b;
        if (zzdbtVar != null) {
            zzdbtVar.zzb(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final synchronized void J(IObjectWrapper iObjectWrapper) {
        zzbzx zzbzxVar = this.f29585a;
        if (zzbzxVar != null) {
            ((zzeny) zzbzxVar).f29933c.w0();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final synchronized void X0(IObjectWrapper iObjectWrapper) {
        zzbzx zzbzxVar = this.f29585a;
        if (zzbzxVar != null) {
            ((zzeny) zzbzxVar).f29931a.zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final synchronized void Z(IObjectWrapper iObjectWrapper) {
        zzdbt zzdbtVar = this.f29586b;
        if (zzdbtVar != null) {
            zzdbtVar.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final synchronized void c2(IObjectWrapper iObjectWrapper) {
        zzbzx zzbzxVar = this.f29585a;
        if (zzbzxVar != null) {
            ((zzeny) zzbzxVar).f29933c.v0(zzdbp.f27592a);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbu
    public final synchronized void m9(zzdbt zzdbtVar) {
        this.f29586b = zzdbtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final synchronized void pa(IObjectWrapper iObjectWrapper, zzbzy zzbzyVar) {
        zzbzx zzbzxVar = this.f29585a;
        if (zzbzxVar != null) {
            ((zzeny) zzbzxVar).f29934d.P(zzbzyVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final synchronized void ua(IObjectWrapper iObjectWrapper) {
        zzbzx zzbzxVar = this.f29585a;
        if (zzbzxVar != null) {
            zzbzxVar.ua(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final synchronized void v0(IObjectWrapper iObjectWrapper, int i2) {
        zzdjc zzdjcVar = this.f29587c;
        if (zzdjcVar != null) {
            String str = ((zzenw) zzdjcVar).f29927c.f29462a;
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Fail to initialize adapter ".concat(String.valueOf(str)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final synchronized void y7(IObjectWrapper iObjectWrapper) {
        zzdjc zzdjcVar = this.f29587c;
        if (zzdjcVar != null) {
            final zzejj zzejjVar = ((zzenw) zzdjcVar).f29927c;
            final zzfhr zzfhrVar = ((zzenw) zzdjcVar).f29926b;
            final zzfic zzficVar = ((zzenw) zzdjcVar).f29925a;
            ((zzenw) zzdjcVar).f29928d.f29936b.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzenv
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() throws zzfir {
                    zzenz.c(zzficVar, zzfhrVar, zzejjVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final synchronized void zzi(IObjectWrapper iObjectWrapper) {
        zzbzx zzbzxVar = this.f29585a;
        if (zzbzxVar != null) {
            ((zzeny) zzbzxVar).f29934d.g();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final synchronized void zzl(IObjectWrapper iObjectWrapper) {
        zzbzx zzbzxVar = this.f29585a;
        if (zzbzxVar != null) {
            ((zzeny) zzbzxVar).f29932b.h();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final synchronized void zzp(IObjectWrapper iObjectWrapper) {
        zzbzx zzbzxVar = this.f29585a;
        if (zzbzxVar != null) {
            ((zzeny) zzbzxVar).f29934d.P(null);
        }
    }
}
