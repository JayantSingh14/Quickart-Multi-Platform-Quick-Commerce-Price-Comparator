package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* loaded from: classes4.dex */
final class zzfuq implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    public final zzfvh f31903a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfvb f31904b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f31905c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public boolean f31906d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f31907e = false;

    public zzfuq(Context context, Looper looper, zzfvb zzfvbVar) {
        this.f31904b = zzfvbVar;
        this.f31903a = new zzfvh(context, looper, this, this, 12800000);
    }

    public final void a() {
        synchronized (this.f31905c) {
            try {
                zzfvh zzfvhVar = this.f31903a;
                if (zzfvhVar.isConnected() || zzfvhVar.isConnecting()) {
                    zzfvhVar.disconnect();
                }
                Binder.flushPendingCommands();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.f31905c) {
            try {
                if (this.f31907e) {
                    return;
                }
                this.f31907e = true;
                try {
                    zzfvm zzfvmVar = (zzfvm) this.f31903a.getService();
                    zzfvf zzfvfVar = new zzfvf(1, this.f31904b.g());
                    Parcel parcelG = zzfvmVar.g();
                    zzbcd.c(parcelG, zzfvfVar);
                    zzfvmVar.j1(2, parcelG);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    a();
                    throw th;
                }
                a();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i2) {
    }
}
