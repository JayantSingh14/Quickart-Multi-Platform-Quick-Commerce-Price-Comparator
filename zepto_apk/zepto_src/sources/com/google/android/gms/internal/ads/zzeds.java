package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzeds extends zzedq {

    /* renamed from: g, reason: collision with root package name */
    public final Context f29155g;

    /* renamed from: h, reason: collision with root package name */
    public final zzgyw f29156h;

    public zzeds(Context context, zzgyw zzgywVar) {
        this.f29155g = context;
        this.f29156h = zzgywVar;
        this.f29153f = new zzbyc(context, com.google.android.gms.ads.internal.zzt.C.t.a(), this, this);
    }

    public final ListenableFuture c(zzbza zzbzaVar) {
        synchronized (this.f29149b) {
            try {
                if (this.f29150c) {
                    return this.f29148a;
                }
                this.f29150c = true;
                this.f29152e = zzbzaVar;
                this.f29153f.checkAvailabilityAndConnect();
                zzcdt zzcdtVar = this.f29148a;
                zzcdtVar.f25992a.q(new Runnable() { // from class: com.google.android.gms.internal.ads.zzedr
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.f29154a.a();
                    }
                }, zzcdo.f25988g);
                zzedq.b(this.f29155g, zzcdtVar, this.f29156h);
                return zzcdtVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.f29149b) {
            try {
                if (!this.f29151d) {
                    this.f29151d = true;
                    try {
                        ((zzbyn) this.f29153f.getService()).Ea(this.f29152e, ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.de)).booleanValue() ? new zzedp(this.f29148a, this.f29152e) : new zzedo(this));
                    } catch (RemoteException | IllegalArgumentException unused) {
                        this.f29148a.c(new zzeef(1));
                    } catch (Throwable th) {
                        com.google.android.gms.ads.internal.zzt.C.f21684h.d("RemoteSignalsClientTask.onConnected", th);
                        this.f29148a.c(new zzeef(1));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
