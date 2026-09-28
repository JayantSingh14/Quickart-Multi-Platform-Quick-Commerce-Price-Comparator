package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.Objects;

/* loaded from: classes.dex */
public final class zzne implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f39468a;

    /* renamed from: b, reason: collision with root package name */
    public volatile zzgn f39469b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zznk f39470c;

    public zzne(zznk zznkVar) {
        Objects.requireNonNull(zznkVar);
        this.f39470c = zznkVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzhy zzhyVar = this.f39470c.f39180a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.l();
        synchronized (this) {
            try {
                Preconditions.checkNotNull(this.f39469b);
                zzga zzgaVar = (zzga) this.f39469b.getService();
                zzhy zzhyVar2 = this.f39470c.f39180a.f39090g;
                zzib.l(zzhyVar2);
                zzhyVar2.p(new zzmz(this, zzgaVar));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f39469b = null;
                this.f39468a = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zznk zznkVar = this.f39470c;
        zzhy zzhyVar = zznkVar.f39180a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.l();
        zzgt zzgtVar = zznkVar.f39180a.f39089f;
        if (zzgtVar == null || !zzgtVar.f39181b) {
            zzgtVar = null;
        }
        if (zzgtVar != null) {
            zzgtVar.n.b(connectionResult, "Service connection failed");
        }
        synchronized (this) {
            this.f39468a = false;
            this.f39469b = null;
        }
        zzhy zzhyVar2 = this.f39470c.f39180a.f39090g;
        zzib.l(zzhyVar2);
        zzhyVar2.p(new zznd(this, connectionResult));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i2) {
        zzib zzibVar = this.f39470c.f39180a;
        zzhy zzhyVar = zzibVar.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.l();
        zzgt zzgtVar = zzibVar.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.f38965m.a("Service connection suspended");
        zzhy zzhyVar2 = zzibVar.f39090g;
        zzib.l(zzhyVar2);
        zzhyVar2.p(new zzna(this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzhy zzhyVar = this.f39470c.f39180a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.l();
        synchronized (this) {
            if (iBinder == null) {
                this.f39468a = false;
                zzgt zzgtVar = this.f39470c.f39180a.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.f38958f.a("Service connected with null binder");
                return;
            }
            zzga zzfyVar = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    zzfyVar = iInterfaceQueryLocalInterface instanceof zzga ? (zzga) iInterfaceQueryLocalInterface : new zzfy(iBinder);
                    zzgt zzgtVar2 = this.f39470c.f39180a.f39089f;
                    zzib.l(zzgtVar2);
                    zzgtVar2.n.a("Bound to IMeasurementService interface");
                } else {
                    zzgt zzgtVar3 = this.f39470c.f39180a.f39089f;
                    zzib.l(zzgtVar3);
                    zzgtVar3.f38958f.b(interfaceDescriptor, "Got binder with a wrong descriptor");
                }
            } catch (RemoteException unused) {
                zzgt zzgtVar4 = this.f39470c.f39180a.f39089f;
                zzib.l(zzgtVar4);
                zzgtVar4.f38958f.a("Service connect failed to get IMeasurementService");
            }
            if (zzfyVar == null) {
                this.f39468a = false;
                try {
                    ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                    zznk zznkVar = this.f39470c;
                    connectionTracker.unbindService(zznkVar.f39180a.f39084a, zznkVar.f39484c);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                zzhy zzhyVar2 = this.f39470c.f39180a.f39090g;
                zzib.l(zzhyVar2);
                zzhyVar2.p(new zzmx(this, zzfyVar));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzib zzibVar = this.f39470c.f39180a;
        zzhy zzhyVar = zzibVar.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.l();
        zzgt zzgtVar = zzibVar.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.f38965m.a("Service disconnected");
        zzhy zzhyVar2 = zzibVar.f39090g;
        zzib.l(zzhyVar2);
        zzhyVar2.p(new zzmy(this, componentName));
    }
}
