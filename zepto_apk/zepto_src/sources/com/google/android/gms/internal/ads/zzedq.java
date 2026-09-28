package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* loaded from: classes4.dex */
public abstract class zzedq implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    public final zzcdt f29148a = new zzcdt();

    /* renamed from: b, reason: collision with root package name */
    public final Object f29149b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public boolean f29150c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f29151d = false;

    /* renamed from: e, reason: collision with root package name */
    public zzbza f29152e;

    /* renamed from: f, reason: collision with root package name */
    public zzbyc f29153f;

    public static void b(Context context, zzcdt zzcdtVar, zzgyw zzgywVar) {
        if (((Boolean) zzbic.f25130j.c()).booleanValue() || ((Boolean) zzbic.f25128h.c()).booleanValue()) {
            zzcdtVar.q(new zzgyk(zzcdtVar, new zzedn(context)), zzgywVar);
        }
    }

    public final void a() {
        synchronized (this.f29149b) {
            try {
                this.f29151d = true;
                if (this.f29153f.isConnected() || this.f29153f.isConnecting()) {
                    this.f29153f.disconnect();
                }
                Binder.flushPendingCommands();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.a("Disconnected from remote ad request service.");
        this.f29148a.c(new zzeef(1));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public void onConnectionSuspended(int i2) {
        int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.a("Cannot connect to remote service, fallback to local instance.");
    }
}
