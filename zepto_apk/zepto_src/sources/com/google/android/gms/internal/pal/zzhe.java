package com.google.android.gms.internal.pal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.LinkedBlockingQueue;

@VisibleForTesting
/* loaded from: classes4.dex */
final class zzhe implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    public final zzhh f37787a;

    /* renamed from: b, reason: collision with root package name */
    public final String f37788b;

    /* renamed from: c, reason: collision with root package name */
    public final String f37789c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedBlockingQueue f37790d;

    /* renamed from: e, reason: collision with root package name */
    public final HandlerThread f37791e;

    public zzhe(Context context, String str, String str2) {
        this.f37788b = str;
        this.f37789c = str2;
        HandlerThread handlerThread = new HandlerThread("GassClient");
        this.f37791e = handlerThread;
        handlerThread.start();
        zzhh zzhhVar = new zzhh(context, handlerThread.getLooper(), this, this);
        this.f37787a = zzhhVar;
        this.f37790d = new LinkedBlockingQueue();
        zzhhVar.checkAvailabilityAndConnect();
    }

    public static zzaf a() {
        zzr zzrVarR = zzaf.R();
        zzrVarR.l(32768L);
        return (zzaf) zzrVarR.h();
    }

    public final void b() {
        zzhh zzhhVar = this.f37787a;
        if (zzhhVar != null) {
            if (zzhhVar.isConnected() || zzhhVar.isConnecting()) {
                zzhhVar.disconnect();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzhm zzhmVar;
        LinkedBlockingQueue linkedBlockingQueue = this.f37790d;
        HandlerThread handlerThread = this.f37791e;
        try {
            zzhmVar = (zzhm) this.f37787a.getService();
        } catch (DeadObjectException | IllegalStateException unused) {
            zzhmVar = null;
        }
        if (zzhmVar != null) {
            try {
                try {
                    zzhi zzhiVar = new zzhi(1, this.f37788b, this.f37789c);
                    Parcel parcelG = zzhmVar.g();
                    int i2 = zzfl.f37734a;
                    parcelG.writeInt(1);
                    zzhiVar.writeToParcel(parcelG, 0);
                    Parcel parcelZ0 = zzhmVar.z0(1, parcelG);
                    zzhk zzhkVarCreateFromParcel = parcelZ0.readInt() == 0 ? null : zzhk.CREATOR.createFromParcel(parcelZ0);
                    parcelZ0.recycle();
                    if (zzhkVarCreateFromParcel.f37797b == null) {
                        try {
                            zzhkVarCreateFromParcel.f37797b = zzaf.h0(zzhkVarCreateFromParcel.f37798c, zzacm.a());
                            zzhkVarCreateFromParcel.f37798c = null;
                        } catch (zzadi | NullPointerException e2) {
                            throw new IllegalStateException(e2);
                        }
                    }
                    zzhkVarCreateFromParcel.b();
                    linkedBlockingQueue.put(zzhkVarCreateFromParcel.f37797b);
                } catch (Throwable unused2) {
                    linkedBlockingQueue.put(a());
                }
            } catch (InterruptedException unused3) {
            } catch (Throwable th) {
                b();
                handlerThread.quit();
                throw th;
            }
            b();
            handlerThread.quit();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) throws InterruptedException {
        try {
            this.f37790d.put(a());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i2) throws InterruptedException {
        try {
            this.f37790d.put(a());
        } catch (InterruptedException unused) {
        }
    }
}
