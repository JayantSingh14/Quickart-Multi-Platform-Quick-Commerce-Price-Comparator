package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import android.os.Parcel;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.LinkedBlockingQueue;

@VisibleForTesting
/* loaded from: classes4.dex */
final class zzfun implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    public final zzfvh f31893a;

    /* renamed from: b, reason: collision with root package name */
    public final String f31894b;

    /* renamed from: c, reason: collision with root package name */
    public final String f31895c;

    /* renamed from: d, reason: collision with root package name */
    public final zzbbq f31896d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedBlockingQueue f31897e;

    /* renamed from: f, reason: collision with root package name */
    public final HandlerThread f31898f;

    /* renamed from: g, reason: collision with root package name */
    public final zzfuf f31899g;

    /* renamed from: h, reason: collision with root package name */
    public final long f31900h;

    public zzfun(Context context, zzbbq zzbbqVar, String str, String str2, zzfuf zzfufVar) {
        this.f31894b = str;
        this.f31896d = zzbbqVar;
        this.f31895c = str2;
        this.f31899g = zzfufVar;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.f31898f = handlerThread;
        handlerThread.start();
        this.f31900h = System.currentTimeMillis();
        zzfvh zzfvhVar = new zzfvh(context, handlerThread.getLooper(), this, this, 19621000);
        this.f31893a = zzfvhVar;
        this.f31897e = new LinkedBlockingQueue();
        zzfvhVar.checkAvailabilityAndConnect();
    }

    public final void a() {
        zzfvh zzfvhVar = this.f31893a;
        if (zzfvhVar != null) {
            if (zzfvhVar.isConnected() || zzfvhVar.isConnecting()) {
                zzfvhVar.disconnect();
            }
        }
    }

    public final void b(int i2, long j2, Exception exc) {
        zzfuf zzfufVar = this.f31899g;
        if (zzfufVar != null) {
            zzfufVar.c(i2, System.currentTimeMillis() - j2, exc);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzfvm zzfvmVar;
        long j2 = this.f31900h;
        HandlerThread handlerThread = this.f31898f;
        try {
            zzfvmVar = (zzfvm) this.f31893a.getService();
        } catch (DeadObjectException | IllegalStateException unused) {
            zzfvmVar = null;
        }
        if (zzfvmVar != null) {
            try {
                zzfvr zzfvrVar = new zzfvr(1, 1, this.f31896d.f24687a, this.f31894b, this.f31895c);
                Parcel parcelG = zzfvmVar.g();
                zzbcd.c(parcelG, zzfvrVar);
                Parcel parcelZ0 = zzfvmVar.z0(3, parcelG);
                zzfvt zzfvtVar = (zzfvt) zzbcd.b(parcelZ0, zzfvt.CREATOR);
                parcelZ0.recycle();
                b(5011, j2, null);
                this.f31897e.put(zzfvtVar);
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) throws InterruptedException {
        try {
            b(4012, this.f31900h, null);
            this.f31897e.put(new zzfvt());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i2) throws InterruptedException {
        try {
            b(4011, this.f31900h, null);
            this.f31897e.put(new zzfvt());
        } catch (InterruptedException unused) {
        }
    }
}
