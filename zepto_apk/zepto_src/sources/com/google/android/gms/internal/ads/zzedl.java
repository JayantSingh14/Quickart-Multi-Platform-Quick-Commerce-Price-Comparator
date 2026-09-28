package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes4.dex */
public final class zzedl extends zzedq {

    /* renamed from: g, reason: collision with root package name */
    public final Context f29141g;

    /* renamed from: h, reason: collision with root package name */
    public final VersionInfoParcel f29142h;

    /* renamed from: i, reason: collision with root package name */
    public final zzedk f29143i;

    public zzedl(Context context, VersionInfoParcel versionInfoParcel, zzedk zzedkVar) {
        this.f29141g = context;
        this.f29142h = versionInfoParcel;
        this.f29143i = zzedkVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.f29149b) {
            if (!this.f29151d) {
                this.f29151d = true;
                try {
                    ((zzbyn) this.f29153f.getService()).zzi(this.f29142h.f21400a);
                    ((zzeey) this.f29143i).b();
                } catch (RemoteException e2) {
                    ((zzeey) this.f29143i).a(e2);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzedq, com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        this.f29143i.a(new RemoteException("Connection failed: ".concat(String.valueOf(connectionResult.getErrorMessage()))));
    }

    @Override // com.google.android.gms.internal.ads.zzedq, com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i2) {
        int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.a("Cannot connect to remote service, fallback to local instance.");
        ((zzeey) this.f29143i).a(new RemoteException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i2).length() + 33), i2, "Connection suspended with cause: ")));
    }
}
