package com.google.android.gms.internal.location;

import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final class zzda extends GmsClient {

    /* renamed from: a, reason: collision with root package name */
    public final SimpleArrayMap f36667a;

    /* renamed from: b, reason: collision with root package name */
    public final SimpleArrayMap f36668b;

    /* renamed from: c, reason: collision with root package name */
    public final SimpleArrayMap f36669c;

    public zzda(Context context, Looper looper, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 23, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.f36667a = new SimpleArrayMap();
        this.f36668b = new SimpleArrayMap();
        this.f36669c = new SimpleArrayMap();
    }

    public final void c(TaskCompletionSource taskCompletionSource) {
        if (f(com.google.android.gms.location.zzm.f38387c)) {
            ((zzo) getService()).A7(new zzcl(null, taskCompletionSource));
        } else {
            ((zzo) getService()).j();
            taskCompletionSource.b(null);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return iInterfaceQueryLocalInterface instanceof zzo ? (zzo) iInterfaceQueryLocalInterface : new zzn(iBinder);
    }

    public final void d(ListenerHolder.ListenerKey listenerKey, boolean z, TaskCompletionSource taskCompletionSource) {
        synchronized (this.f36668b) {
            try {
                zzcw zzcwVar = (zzcw) this.f36668b.remove(listenerKey);
                if (zzcwVar == null) {
                    taskCompletionSource.b(Boolean.FALSE);
                    return;
                }
                zzcwVar.f36656b.zza().clear();
                if (!z) {
                    taskCompletionSource.b(Boolean.TRUE);
                } else if (f(com.google.android.gms.location.zzm.f38389e)) {
                    ((zzo) getService()).H8(new zzdb(2, null, zzcwVar, null, null, null), new zzcl(Boolean.TRUE, taskCompletionSource));
                } else {
                    ((zzo) getService()).Q7(new zzdf(2, null, null, zzcwVar, null, new zzcn(Boolean.TRUE, taskCompletionSource), null));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e(TaskCompletionSource taskCompletionSource) {
        if (f(com.google.android.gms.location.zzm.f38389e)) {
            ((zzo) getService()).H8(new zzdb(3, null, null, null, null, null), new zzcl(null, taskCompletionSource));
        } else {
            ((zzo) getService()).Q7(new zzdf(2, null, null, null, null, new zzcn(null, taskCompletionSource), null));
        }
    }

    public final boolean f(Feature feature) {
        Feature feature2;
        Feature[] availableFeatures = getAvailableFeatures();
        if (availableFeatures == null) {
            return false;
        }
        int length = availableFeatures.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                feature2 = null;
                break;
            }
            feature2 = availableFeatures[i2];
            if (feature.getName().equals(feature2.getName())) {
                break;
            }
            i2++;
        }
        return feature2 != null && feature2.getVersion() >= feature.getVersion();
    }

    public final void g(LastLocationRequest lastLocationRequest, TaskCompletionSource taskCompletionSource) {
        getContext();
        if (f(com.google.android.gms.location.zzm.f38386b)) {
            ((zzo) getService()).I7(lastLocationRequest, new zzcm(taskCompletionSource));
        } else {
            taskCompletionSource.b(((zzo) getService()).zzd());
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return com.google.android.gms.location.zzm.f38390f;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 11717000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    public final void h(zzcs zzcsVar, LocationRequest locationRequest, TaskCompletionSource taskCompletionSource) {
        zzcw zzcwVar;
        ListenerHolder listenerHolderZza = zzcsVar.zza();
        ListenerHolder.ListenerKey listenerKey = listenerHolderZza.getListenerKey();
        listenerKey.getClass();
        boolean zF = f(com.google.android.gms.location.zzm.f38389e);
        synchronized (this.f36668b) {
            try {
                zzcw zzcwVar2 = (zzcw) this.f36668b.get(listenerKey);
                if (zzcwVar2 == null || zF) {
                    zzcw zzcwVar3 = new zzcw(zzcsVar);
                    this.f36668b.put(listenerKey, zzcwVar3);
                    zzcwVar = zzcwVar3;
                } else {
                    zzcwVar2.f36656b.a(listenerHolderZza);
                    zzcwVar = zzcwVar2;
                    zzcwVar2 = null;
                }
                getContext();
                String idString = listenerKey.toIdString();
                if (zF) {
                    ((zzo) getService()).s6(new zzdb(2, zzcwVar2 == null ? null : zzcwVar2, zzcwVar, null, null, idString), locationRequest, new zzcl(null, taskCompletionSource));
                } else {
                    zzo zzoVar = (zzo) getService();
                    LocationRequest.Builder builder = new LocationRequest.Builder(locationRequest);
                    if (Build.VERSION.SDK_INT < 30) {
                        builder.f38335l = null;
                    }
                    zzoVar.Q7(new zzdf(1, new zzdd(builder.a(), null, false, false, null, false, false, null, Long.MAX_VALUE), null, zzcwVar, null, new zzcp(taskCompletionSource, zzcwVar), idString));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i(zzcs zzcsVar, TaskCompletionSource taskCompletionSource) {
        zzcz zzczVar;
        zzas zzasVar = (zzas) zzcsVar;
        ListenerHolder listenerHolderZza = zzasVar.zza();
        ListenerHolder.ListenerKey listenerKey = listenerHolderZza.getListenerKey();
        listenerKey.getClass();
        boolean zF = f(com.google.android.gms.location.zzm.f38389e);
        synchronized (this.f36667a) {
            try {
                zzcz zzczVar2 = (zzcz) this.f36667a.get(listenerKey);
                if (zzczVar2 == null || zF) {
                    zzcz zzczVar3 = new zzcz(zzasVar);
                    this.f36667a.put(listenerKey, zzczVar3);
                    zzczVar = zzczVar3;
                } else {
                    ((zzas) zzczVar2.f36658b).a(listenerHolderZza);
                    zzczVar = zzczVar2;
                    zzczVar2 = null;
                }
                getContext();
                String idString = listenerKey.toIdString();
                if (!zF) {
                    new LocationRequest.Builder(null);
                    throw null;
                }
                ((zzo) getService()).s6(new zzdb(1, zzczVar2 == null ? null : zzczVar2, zzczVar, null, null, idString), null, new zzcl(null, taskCompletionSource));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j(TaskCompletionSource taskCompletionSource) {
        getContext();
        if (f(com.google.android.gms.location.zzm.f38389e)) {
            ((zzo) getService()).s6(new zzdb(3, null, null, null, null, null), null, new zzcl(null, taskCompletionSource));
        } else {
            new LocationRequest.Builder(null);
            throw null;
        }
    }

    public final void k(TaskCompletionSource taskCompletionSource) {
        Preconditions.checkArgument(false, "geofenceRequestIds can't be null nor empty.");
        throw null;
    }

    public final void l(TaskCompletionSource taskCompletionSource) {
        if (f(com.google.android.gms.location.zzm.f38388d)) {
            ((zzo) getService()).H6(new zzcl(null, taskCompletionSource));
        } else {
            ((zzo) getService()).c();
            taskCompletionSource.b(null);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectionSuspended(int i2) {
        super.onConnectionSuspended(i2);
        synchronized (this.f36667a) {
            this.f36667a.clear();
        }
        synchronized (this.f36668b) {
            this.f36668b.clear();
        }
        synchronized (this.f36669c) {
            this.f36669c.clear();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }
}
