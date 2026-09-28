package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes4.dex */
public final class zzedj extends zzedq {

    /* renamed from: g, reason: collision with root package name */
    public final Context f29139g;

    /* renamed from: h, reason: collision with root package name */
    public final zzgyw f29140h;

    public zzedj(Context context, zzgyw zzgywVar) {
        this.f29139g = context;
        this.f29140h = zzgywVar;
        this.f29153f = new zzbyc(context, com.google.android.gms.ads.internal.zzt.C.t.a(), this, this);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.f29149b) {
            try {
                if (!this.f29151d) {
                    this.f29151d = true;
                    try {
                        ((zzbyn) this.f29153f.getService()).r3(this.f29152e, ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.de)).booleanValue() ? new zzedp(this.f29148a, this.f29152e) : new zzedo(this));
                    } catch (RemoteException | IllegalArgumentException unused) {
                        this.f29148a.c(new zzeef(1));
                    } catch (Throwable th) {
                        com.google.android.gms.ads.internal.zzt.C.f21684h.d("RemoteAdRequestClientTask.onConnected", th);
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
