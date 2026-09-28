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
final class zzful implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    public final zzfvh f31888a;

    /* renamed from: b, reason: collision with root package name */
    public final String f31889b;

    /* renamed from: c, reason: collision with root package name */
    public final String f31890c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedBlockingQueue f31891d;

    /* renamed from: e, reason: collision with root package name */
    public final HandlerThread f31892e;

    public zzful(Context context, String str, String str2) {
        this.f31889b = str;
        this.f31890c = str2;
        HandlerThread handlerThread = new HandlerThread("GassClient");
        this.f31892e = handlerThread;
        handlerThread.start();
        zzfvh zzfvhVar = new zzfvh(context, handlerThread.getLooper(), this, this, 9200000);
        this.f31888a = zzfvhVar;
        this.f31891d = new LinkedBlockingQueue();
        zzfvhVar.checkAvailabilityAndConnect();
    }

    public static zzawp b() {
        zzavs zzavsVarF0 = zzawp.F0();
        zzavsVarF0.o(32768L);
        return (zzawp) zzavsVarF0.l();
    }

    public final void a() {
        zzfvh zzfvhVar = this.f31888a;
        if (zzfvhVar != null) {
            if (zzfvhVar.isConnected() || zzfvhVar.isConnecting()) {
                zzfvhVar.disconnect();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzfvm zzfvmVar;
        LinkedBlockingQueue linkedBlockingQueue = this.f31891d;
        HandlerThread handlerThread = this.f31892e;
        try {
            zzfvmVar = (zzfvm) this.f31888a.getService();
        } catch (DeadObjectException | IllegalStateException unused) {
            zzfvmVar = null;
        }
        if (zzfvmVar != null) {
            try {
                try {
                    zzfvi zzfviVar = new zzfvi(1, this.f31889b, this.f31890c);
                    Parcel parcelG = zzfvmVar.g();
                    zzbcd.c(parcelG, zzfviVar);
                    Parcel parcelZ0 = zzfvmVar.z0(1, parcelG);
                    zzfvk zzfvkVar = (zzfvk) zzbcd.b(parcelZ0, zzfvk.CREATOR);
                    parcelZ0.recycle();
                    if (zzfvkVar.f31925b == null) {
                        try {
                            byte[] bArr = zzfvkVar.f31926c;
                            zziab zziabVar = zziab.f34620b;
                            int i2 = zzhyy.f34536a;
                            zzfvkVar.f31925b = zzawp.E0(bArr, zziab.f34621c);
                            zzfvkVar.f31926c = null;
                        } catch (zzibg | NullPointerException e2) {
                            throw new IllegalStateException(e2);
                        }
                    }
                    zzfvkVar.zzb();
                    linkedBlockingQueue.put(zzfvkVar.f31925b);
                } catch (Throwable unused2) {
                    linkedBlockingQueue.put(b());
                }
            } catch (InterruptedException unused3) {
            } catch (Throwable th) {
                a();
                handlerThread.quit();
                throw th;
            }
            a();
            handlerThread.quit();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) throws InterruptedException {
        try {
            this.f31891d.put(b());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i2) throws InterruptedException {
        try {
            this.f31891d.put(b());
        } catch (InterruptedException unused) {
        }
    }
}
