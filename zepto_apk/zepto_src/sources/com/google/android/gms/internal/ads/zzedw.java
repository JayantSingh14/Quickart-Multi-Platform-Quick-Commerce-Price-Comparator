package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes4.dex */
public final class zzedw extends zzedq {

    /* renamed from: g, reason: collision with root package name */
    public String f29160g;

    /* renamed from: h, reason: collision with root package name */
    public int f29161h;

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.f29149b) {
            try {
                if (!this.f29151d) {
                    this.f29151d = true;
                    try {
                        try {
                            int i2 = this.f29161h;
                            if (i2 == 2) {
                                ((zzbyn) this.f29153f.getService()).I9(this.f29152e, ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.de)).booleanValue() ? new zzedp(this.f29148a, this.f29152e) : new zzedo(this));
                            } else if (i2 == 3) {
                                ((zzbyn) this.f29153f.getService()).Vb(this.f29160g, ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.de)).booleanValue() ? new zzedp(this.f29148a, this.f29152e) : new zzedo(this));
                            } else {
                                this.f29148a.c(new zzeef(1));
                            }
                        } catch (Throwable th) {
                            com.google.android.gms.ads.internal.zzt.C.f21684h.d("RemoteUrlAndCacheKeyClientTask.onConnected", th);
                            this.f29148a.c(new zzeef(1));
                        }
                    } catch (RemoteException | IllegalArgumentException unused) {
                        this.f29148a.c(new zzeef(1));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzedq, com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.a("Cannot connect to remote service, fallback to local instance.");
        this.f29148a.c(new zzeef(1));
    }
}
