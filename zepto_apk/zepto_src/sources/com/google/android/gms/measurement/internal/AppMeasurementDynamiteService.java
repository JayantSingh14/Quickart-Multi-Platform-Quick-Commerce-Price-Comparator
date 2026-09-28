package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import in.juspay.airborne.ota.Constants;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONException;

@DynamiteApi
/* loaded from: classes.dex */
public class AppMeasurementDynamiteService extends com.google.android.gms.internal.measurement.zzcq {

    /* renamed from: a, reason: collision with root package name */
    public zzib f38653a = null;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayMap f38654b = new ArrayMap();

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void beginAdUnitExposure(@NonNull String str, long j2) throws RemoteException {
        zzb();
        zzd zzdVar = this.f38653a.n;
        zzib.i(zzdVar);
        zzdVar.h(j2, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void clearConditionalUserProperty(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) throws RemoteException {
        zzb();
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        zzliVar.y(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void clearMeasurementEnabled(long j2) throws RemoteException {
        zzb();
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        zzliVar.h();
        zzhy zzhyVar = zzliVar.f39180a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.p(new zzkr(zzliVar, null));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void endAdUnitExposure(@NonNull String str, long j2) throws RemoteException {
        zzb();
        zzd zzdVar = this.f38653a.n;
        zzib.i(zzdVar);
        zzdVar.i(j2, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void generateEventId(com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        zzpo zzpoVar = this.f38653a.f39092i;
        zzib.j(zzpoVar);
        long jB0 = zzpoVar.b0();
        zzb();
        zzpo zzpoVar2 = this.f38653a.f39092i;
        zzib.j(zzpoVar2);
        zzpoVar2.O(zzcuVar, jB0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getAppInstanceId(com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        zzhy zzhyVar = this.f38653a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.p(new zzi(this, zzcuVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getCachedAppInstanceId(com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        z0((String) zzliVar.f39319g.get(), zzcuVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getConditionalUserProperties(String str, String str2, com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        zzhy zzhyVar = this.f38653a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.p(new zzm(this, zzcuVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getCurrentScreenClass(com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        z0(zzliVar.B(), zzcuVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getCurrentScreenName(com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        z0(zzliVar.A(), zzcuVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getGmpAppId(com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        String strA;
        zzb();
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        zzib zzibVar = zzliVar.f39180a;
        try {
            strA = zzls.a(zzibVar.f39084a, zzibVar.p);
        } catch (IllegalStateException e2) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.b(e2, "getGoogleAppId failed with exception");
            strA = null;
        }
        z0(strA, zzcuVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getMaxUserProperties(String str, com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        zzliVar.v(str);
        zzb();
        zzpo zzpoVar = this.f38653a.f39092i;
        zzib.j(zzpoVar);
        zzpoVar.P(zzcuVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getSessionId(com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        zzhy zzhyVar = zzliVar.f39180a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.p(new zzkl(zzliVar, zzcuVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getTestFlag(com.google.android.gms.internal.measurement.zzcu zzcuVar, int i2) throws RemoteException {
        zzb();
        if (i2 == 0) {
            zzpo zzpoVar = this.f38653a.f39092i;
            zzib.j(zzpoVar);
            zzli zzliVar = this.f38653a.f39096m;
            zzib.k(zzliVar);
            AtomicReference atomicReference = new AtomicReference();
            zzhy zzhyVar = zzliVar.f39180a.f39090g;
            zzib.l(zzhyVar);
            zzpoVar.N((String) zzhyVar.q(atomicReference, 15000L, "String test flag value", new zzkn(zzliVar, atomicReference)), zzcuVar);
            return;
        }
        if (i2 == 1) {
            zzpo zzpoVar2 = this.f38653a.f39092i;
            zzib.j(zzpoVar2);
            zzli zzliVar2 = this.f38653a.f39096m;
            zzib.k(zzliVar2);
            AtomicReference atomicReference2 = new AtomicReference();
            zzhy zzhyVar2 = zzliVar2.f39180a.f39090g;
            zzib.l(zzhyVar2);
            zzpoVar2.O(zzcuVar, ((Long) zzhyVar2.q(atomicReference2, 15000L, "long test flag value", new zzko(zzliVar2, atomicReference2))).longValue());
            return;
        }
        if (i2 == 2) {
            zzpo zzpoVar3 = this.f38653a.f39092i;
            zzib.j(zzpoVar3);
            zzli zzliVar3 = this.f38653a.f39096m;
            zzib.k(zzliVar3);
            AtomicReference atomicReference3 = new AtomicReference();
            zzhy zzhyVar3 = zzliVar3.f39180a.f39090g;
            zzib.l(zzhyVar3);
            double dDoubleValue = ((Double) zzhyVar3.q(atomicReference3, 15000L, "double test flag value", new zzkq(zzliVar3, atomicReference3))).doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", dDoubleValue);
            try {
                zzcuVar.b0(bundle);
                return;
            } catch (RemoteException e2) {
                zzgt zzgtVar = zzpoVar3.f39180a.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.f38961i.b(e2, "Error returning double value to wrapper");
                return;
            }
        }
        if (i2 == 3) {
            zzpo zzpoVar4 = this.f38653a.f39092i;
            zzib.j(zzpoVar4);
            zzli zzliVar4 = this.f38653a.f39096m;
            zzib.k(zzliVar4);
            AtomicReference atomicReference4 = new AtomicReference();
            zzhy zzhyVar4 = zzliVar4.f39180a.f39090g;
            zzib.l(zzhyVar4);
            zzpoVar4.P(zzcuVar, ((Integer) zzhyVar4.q(atomicReference4, 15000L, "int test flag value", new zzkp(zzliVar4, atomicReference4))).intValue());
            return;
        }
        if (i2 != 4) {
            return;
        }
        zzpo zzpoVar5 = this.f38653a.f39092i;
        zzib.j(zzpoVar5);
        zzli zzliVar5 = this.f38653a.f39096m;
        zzib.k(zzliVar5);
        AtomicReference atomicReference5 = new AtomicReference();
        zzhy zzhyVar5 = zzliVar5.f39180a.f39090g;
        zzib.l(zzhyVar5);
        zzpoVar5.R(zzcuVar, ((Boolean) zzhyVar5.q(atomicReference5, 15000L, "boolean test flag value", new zzkd(zzliVar5, atomicReference5))).booleanValue());
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getUserProperties(String str, String str2, boolean z, com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        zzhy zzhyVar = this.f38653a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.p(new zzk(this, zzcuVar, str, str2, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void initForTests(@NonNull Map map) throws RemoteException {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void initialize(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzdd zzddVar, long j2) throws RemoteException {
        zzib zzibVar = this.f38653a;
        if (zzibVar == null) {
            this.f38653a = zzib.r((Context) Preconditions.checkNotNull((Context) ObjectWrapper.z0(iObjectWrapper)), zzddVar, Long.valueOf(j2));
            return;
        }
        zzgt zzgtVar = zzibVar.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.f38961i.a("Attempting to initialize multiple times");
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void isDataCollectionEnabled(com.google.android.gms.internal.measurement.zzcu zzcuVar) throws RemoteException {
        zzb();
        zzhy zzhyVar = this.f38653a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.p(new zzn(this, zzcuVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void logEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, boolean z, boolean z2, long j2) throws RemoteException {
        zzb();
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        zzliVar.m(str, str2, bundle, z, z2, j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void logEventAndBundle(String str, String str2, Bundle bundle, com.google.android.gms.internal.measurement.zzcu zzcuVar, long j2) throws RemoteException {
        zzb();
        Preconditions.checkNotEmpty(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", Constants.APP_DIR);
        zzbg zzbgVar = new zzbg(str2, new zzbe(bundle), Constants.APP_DIR, j2);
        zzhy zzhyVar = this.f38653a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.p(new zzj(this, zzcuVar, zzbgVar, str));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void logHealthData(int i2, @NonNull String str, @NonNull IObjectWrapper iObjectWrapper, @NonNull IObjectWrapper iObjectWrapper2, @NonNull IObjectWrapper iObjectWrapper3) throws RemoteException {
        zzb();
        Object objZ0 = iObjectWrapper == null ? null : ObjectWrapper.z0(iObjectWrapper);
        Object objZ02 = iObjectWrapper2 == null ? null : ObjectWrapper.z0(iObjectWrapper2);
        Object objZ03 = iObjectWrapper3 != null ? ObjectWrapper.z0(iObjectWrapper3) : null;
        zzgt zzgtVar = this.f38653a.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.p(i2, true, false, str, objZ0, objZ02, objZ03);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityCreated(@NonNull IObjectWrapper iObjectWrapper, @NonNull Bundle bundle, long j2) throws RemoteException {
        zzb();
        onActivityCreatedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.b((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.z0(iObjectWrapper))), bundle, j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityCreatedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, Bundle bundle, long j2) {
        zzb();
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        zzkx zzkxVar = zzliVar.f39315c;
        if (zzkxVar != null) {
            zzli zzliVar2 = this.f38653a.f39096m;
            zzib.k(zzliVar2);
            zzliVar2.F();
            zzkxVar.a(zzdfVar, bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityDestroyed(@NonNull IObjectWrapper iObjectWrapper, long j2) throws RemoteException {
        zzb();
        onActivityDestroyedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.b((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.z0(iObjectWrapper))), j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityDestroyedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, long j2) throws RemoteException {
        zzb();
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        zzkx zzkxVar = zzliVar.f39315c;
        if (zzkxVar != null) {
            zzli zzliVar2 = this.f38653a.f39096m;
            zzib.k(zzliVar2);
            zzliVar2.F();
            zzkxVar.b(zzdfVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityPaused(@NonNull IObjectWrapper iObjectWrapper, long j2) throws RemoteException {
        zzb();
        onActivityPausedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.b((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.z0(iObjectWrapper))), j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityPausedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, long j2) throws RemoteException {
        zzb();
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        zzkx zzkxVar = zzliVar.f39315c;
        if (zzkxVar != null) {
            zzli zzliVar2 = this.f38653a.f39096m;
            zzib.k(zzliVar2);
            zzliVar2.F();
            zzkxVar.c(zzdfVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityResumed(@NonNull IObjectWrapper iObjectWrapper, long j2) throws RemoteException {
        zzb();
        onActivityResumedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.b((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.z0(iObjectWrapper))), j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityResumedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, long j2) throws RemoteException {
        zzb();
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        zzkx zzkxVar = zzliVar.f39315c;
        if (zzkxVar != null) {
            zzli zzliVar2 = this.f38653a.f39096m;
            zzib.k(zzliVar2);
            zzliVar2.F();
            zzkxVar.d(zzdfVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzcu zzcuVar, long j2) throws RemoteException {
        zzb();
        onActivitySaveInstanceStateByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.b((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.z0(iObjectWrapper))), zzcuVar, j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivitySaveInstanceStateByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, com.google.android.gms.internal.measurement.zzcu zzcuVar, long j2) throws RemoteException {
        zzb();
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        zzkx zzkxVar = zzliVar.f39315c;
        Bundle bundle = new Bundle();
        if (zzkxVar != null) {
            zzli zzliVar2 = this.f38653a.f39096m;
            zzib.k(zzliVar2);
            zzliVar2.F();
            zzkxVar.e(zzdfVar, bundle);
        }
        try {
            zzcuVar.b0(bundle);
        } catch (RemoteException e2) {
            zzgt zzgtVar = this.f38653a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38961i.b(e2, "Error returning bundle value to wrapper");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityStarted(@NonNull IObjectWrapper iObjectWrapper, long j2) throws RemoteException {
        zzb();
        onActivityStartedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.b((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.z0(iObjectWrapper))), j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityStartedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, long j2) throws RemoteException {
        zzb();
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        if (zzliVar.f39315c != null) {
            zzli zzliVar2 = this.f38653a.f39096m;
            zzib.k(zzliVar2);
            zzliVar2.F();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityStopped(@NonNull IObjectWrapper iObjectWrapper, long j2) throws RemoteException {
        zzb();
        onActivityStoppedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.b((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.z0(iObjectWrapper))), j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityStoppedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, long j2) throws RemoteException {
        zzb();
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        if (zzliVar.f39315c != null) {
            zzli zzliVar2 = this.f38653a.f39096m;
            zzib.k(zzliVar2);
            zzliVar2.F();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void performAction(Bundle bundle, com.google.android.gms.internal.measurement.zzcu zzcuVar, long j2) throws RemoteException {
        zzb();
        zzcuVar.b0(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzda zzdaVar) throws RemoteException {
        Object zzqVar;
        zzb();
        ArrayMap arrayMap = this.f38654b;
        synchronized (arrayMap) {
            try {
                zzqVar = (zzjp) arrayMap.get(Integer.valueOf(zzdaVar.zzf()));
                if (zzqVar == null) {
                    zzqVar = new zzq(this, zzdaVar);
                    arrayMap.put(Integer.valueOf(zzdaVar.zzf()), zzqVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        zzliVar.h();
        Preconditions.checkNotNull(zzqVar);
        if (zzliVar.f39317e.add(zzqVar)) {
            return;
        }
        zzgt zzgtVar = zzliVar.f39180a.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.f38961i.a("OnEventListener already registered");
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void resetAnalyticsData(long j2) throws RemoteException {
        zzb();
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        zzliVar.f39319g.set(null);
        zzhy zzhyVar = zzliVar.f39180a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.p(new zzkg(zzliVar, j2));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void retrieveAndUploadBatches(final com.google.android.gms.internal.measurement.zzcx zzcxVar) throws MalformedURLException {
        int i2;
        zzlq zzlqVar;
        zzb();
        final zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.measurement.internal.zzo
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    zzcxVar.zze();
                } catch (RemoteException e2) {
                    zzgt zzgtVar = ((zzib) Preconditions.checkNotNull(this.f39529a.f38653a)).f39089f;
                    zzib.l(zzgtVar);
                    zzgtVar.f38961i.b(e2, "Failed to call IDynamiteUploadBatchesCallback");
                }
            }
        };
        zzliVar.h();
        zzib zzibVar = zzliVar.f39180a;
        zzhy zzhyVar = zzibVar.f39090g;
        zzib.l(zzhyVar);
        if (zzhyVar.m()) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Cannot retrieve and upload batches from analytics worker thread");
            return;
        }
        zzhy zzhyVar2 = zzibVar.f39090g;
        zzib.l(zzhyVar2);
        if (Thread.currentThread() == zzhyVar2.f39072d) {
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.a("Cannot retrieve and upload batches from analytics network thread");
            return;
        }
        if (zzae.a()) {
            zzgt zzgtVar3 = zzibVar.f39089f;
            zzib.l(zzgtVar3);
            zzgtVar3.f38958f.a("Cannot retrieve and upload batches from main thread");
            return;
        }
        zzgt zzgtVar4 = zzibVar.f39089f;
        zzib.l(zzgtVar4);
        zzgtVar4.n.a("[sgtm] Started client-side batch upload work.");
        boolean z = false;
        int size = 0;
        int i3 = 0;
        while (!z) {
            zzgt zzgtVar5 = zzibVar.f39089f;
            zzib.l(zzgtVar5);
            zzgtVar5.n.a("[sgtm] Getting upload batches from service (FE)");
            final AtomicReference atomicReference = new AtomicReference();
            zzhy zzhyVar3 = zzibVar.f39090g;
            zzib.l(zzhyVar3);
            zzhyVar3.q(atomicReference, 10000L, "[sgtm] Getting upload batches", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlh
                @Override // java.lang.Runnable
                public final void run() {
                    final zznk zznkVarO = zzliVar.f39180a.o();
                    final zzon zzonVarB = zzon.b(zzlr.SGTM_CLIENT);
                    zznkVarO.g();
                    zznkVarO.h();
                    final zzr zzrVarW = zznkVarO.w(false);
                    final AtomicReference atomicReference2 = atomicReference;
                    zznkVarO.u(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznh
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzga zzgaVar;
                            zznk zznkVar = zznkVarO;
                            AtomicReference atomicReference3 = atomicReference2;
                            zzr zzrVar = zzrVarW;
                            zzon zzonVar = zzonVarB;
                            synchronized (atomicReference3) {
                                try {
                                    zzgaVar = zznkVar.f39485d;
                                } catch (RemoteException e2) {
                                    zzgt zzgtVar6 = zznkVar.f39180a.f39089f;
                                    zzib.l(zzgtVar6);
                                    zzgtVar6.f38958f.b(e2, "[sgtm] Failed to get upload batches; remote exception");
                                    atomicReference3.notifyAll();
                                }
                                if (zzgaVar == null) {
                                    zzgt zzgtVar7 = zznkVar.f39180a.f39089f;
                                    zzib.l(zzgtVar7);
                                    zzgtVar7.f38958f.a("[sgtm] Failed to get upload batches; not connected to service");
                                } else {
                                    Preconditions.checkNotNull(zzrVar);
                                    zzgaVar.D5(zzrVar, zzonVar, new zzme(zznkVar, atomicReference3));
                                    zznkVar.t();
                                }
                            }
                        }
                    });
                }
            });
            zzop zzopVar = (zzop) atomicReference.get();
            if (zzopVar == null) {
                break;
            }
            ArrayList arrayList = zzopVar.f39560a;
            if (arrayList.isEmpty()) {
                break;
            }
            zzgt zzgtVar6 = zzibVar.f39089f;
            zzib.l(zzgtVar6);
            zzgtVar6.n.b(Integer.valueOf(arrayList.size()), "[sgtm] Retrieved upload batches. count");
            size += arrayList.size();
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                final zzol zzolVar = (zzol) it.next();
                try {
                    URL url = new URI(zzolVar.f39554c).toURL();
                    final AtomicReference atomicReference2 = new AtomicReference();
                    zzgh zzghVarQ = zzliVar.f39180a.q();
                    zzghVarQ.h();
                    Preconditions.checkNotNull(zzghVarQ.f38920g);
                    String str = zzghVarQ.f38920g;
                    zzib zzibVar2 = zzliVar.f39180a;
                    zzgt zzgtVar7 = zzibVar2.f39089f;
                    zzib.l(zzgtVar7);
                    zzgr zzgrVar = zzgtVar7.n;
                    i2 = size;
                    Long lValueOf = Long.valueOf(zzolVar.f39552a);
                    zzgrVar.d("[sgtm] Uploading data from app. row_id, url, uncompressed size", lValueOf, zzolVar.f39554c, Integer.valueOf(zzolVar.f39553b.length));
                    if (!TextUtils.isEmpty(zzolVar.f39558g)) {
                        zzgt zzgtVar8 = zzibVar2.f39089f;
                        zzib.l(zzgtVar8);
                        zzgtVar8.n.c("[sgtm] Uploading data from app. row_id", lValueOf, zzolVar.f39558g);
                    }
                    HashMap map = new HashMap();
                    Bundle bundle = zzolVar.f39555d;
                    for (String str2 : bundle.keySet()) {
                        String string = bundle.getString(str2);
                        if (!TextUtils.isEmpty(string)) {
                            map.put(str2, string);
                        }
                    }
                    zzln zzlnVar = zzibVar2.o;
                    zzib.l(zzlnVar);
                    byte[] bArr = zzolVar.f39553b;
                    zzlk zzlkVar = new zzlk() { // from class: com.google.android.gms.measurement.internal.zzky
                        /* JADX WARN: Removed duplicated region for block: B:10:0x0016  */
                        /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
                        /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
                        @Override // com.google.android.gms.measurement.internal.zzlk
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final void a(int r9, java.io.IOException r10, byte[] r11) {
                            /*
                                r8 = this;
                                com.google.android.gms.measurement.internal.zzli r11 = r1
                                r11.g()
                                com.google.android.gms.measurement.internal.zzol r0 = r3
                                r1 = 200(0xc8, float:2.8E-43)
                                if (r9 == r1) goto L14
                                r1 = 204(0xcc, float:2.86E-43)
                                if (r9 == r1) goto L14
                                r1 = 304(0x130, float:4.26E-43)
                                if (r9 != r1) goto L2d
                                r9 = r1
                            L14:
                                if (r10 != 0) goto L2d
                                com.google.android.gms.measurement.internal.zzib r9 = r11.f39180a
                                com.google.android.gms.measurement.internal.zzgt r9 = r9.f39089f
                                com.google.android.gms.measurement.internal.zzib.l(r9)
                                com.google.android.gms.measurement.internal.zzgr r9 = r9.n
                                long r1 = r0.f39552a
                                java.lang.Long r10 = java.lang.Long.valueOf(r1)
                                java.lang.String r1 = "[sgtm] Upload succeeded for row_id"
                                r9.b(r10, r1)
                                com.google.android.gms.measurement.internal.zzlq r9 = com.google.android.gms.measurement.internal.zzlq.SUCCESS
                                goto L67
                            L2d:
                                com.google.android.gms.measurement.internal.zzib r1 = r11.f39180a
                                com.google.android.gms.measurement.internal.zzgt r1 = r1.f39089f
                                com.google.android.gms.measurement.internal.zzib.l(r1)
                                com.google.android.gms.measurement.internal.zzgr r1 = r1.f38961i
                                long r2 = r0.f39552a
                                java.lang.Long r2 = java.lang.Long.valueOf(r2)
                                java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
                                java.lang.String r4 = "[sgtm] Upload failed for row_id. response, exception"
                                r1.d(r4, r2, r3, r10)
                                com.google.android.gms.measurement.internal.zzfw r10 = com.google.android.gms.measurement.internal.zzfx.u
                                r1 = 0
                                java.lang.Object r10 = r10.a(r1)
                                java.lang.String r10 = (java.lang.String) r10
                                java.lang.String r1 = ","
                                java.lang.String[] r10 = r10.split(r1)
                                java.util.List r10 = java.util.Arrays.asList(r10)
                                java.lang.String r9 = java.lang.String.valueOf(r9)
                                boolean r9 = r10.contains(r9)
                                if (r9 == 0) goto L65
                                com.google.android.gms.measurement.internal.zzlq r9 = com.google.android.gms.measurement.internal.zzlq.BACKOFF
                                goto L67
                            L65:
                                com.google.android.gms.measurement.internal.zzlq r9 = com.google.android.gms.measurement.internal.zzlq.FAILURE
                            L67:
                                java.util.concurrent.atomic.AtomicReference r10 = r2
                                com.google.android.gms.measurement.internal.zzib r1 = r11.f39180a
                                com.google.android.gms.measurement.internal.zznk r1 = r1.o()
                                com.google.android.gms.measurement.internal.zzaf r2 = new com.google.android.gms.measurement.internal.zzaf
                                long r3 = r0.f39552a
                                int r7 = r9.f39343a
                                long r5 = r0.f39557f
                                r2.<init>(r3, r5, r7)
                                r1.g()
                                r1.h()
                                r0 = 1
                                com.google.android.gms.measurement.internal.zzr r0 = r1.w(r0)
                                com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
                                com.google.android.gms.measurement.internal.zzni r5 = new com.google.android.gms.measurement.internal.zzni
                                r5.<init>()
                                r1.u(r5)
                                com.google.android.gms.measurement.internal.zzib r11 = r11.f39180a
                                com.google.android.gms.measurement.internal.zzgt r11 = r11.f39089f
                                com.google.android.gms.measurement.internal.zzib.l(r11)
                                com.google.android.gms.measurement.internal.zzgr r11 = r11.n
                                java.lang.Long r0 = java.lang.Long.valueOf(r3)
                                java.lang.String r1 = "[sgtm] Updated status for row_id"
                                r11.c(r1, r0, r9)
                                monitor-enter(r10)
                                r10.set(r9)     // Catch: java.lang.Throwable -> Lab
                                r10.notifyAll()     // Catch: java.lang.Throwable -> Lab
                                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lab
                                return
                            Lab:
                                r0 = move-exception
                                r9 = r0
                                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lab
                                throw r9
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzky.a(int, java.io.IOException, byte[]):void");
                        }
                    };
                    zzlnVar.i();
                    Preconditions.checkNotNull(url);
                    Preconditions.checkNotNull(bArr);
                    Preconditions.checkNotNull(zzlkVar);
                    zzhy zzhyVar4 = zzlnVar.f39180a.f39090g;
                    zzib.l(zzhyVar4);
                    zzhyVar4.s(new zzlm(zzlnVar, str, url, bArr, map, zzlkVar));
                    try {
                        zzpo zzpoVar = zzibVar2.f39092i;
                        zzib.j(zzpoVar);
                        zzib zzibVar3 = zzpoVar.f39180a;
                        long jCurrentTimeMillis = zzibVar3.f39094k.currentTimeMillis();
                        long j2 = jCurrentTimeMillis + DateUtils.MILLIS_PER_MINUTE;
                        synchronized (atomicReference2) {
                            for (long jCurrentTimeMillis2 = DateUtils.MILLIS_PER_MINUTE; atomicReference2.get() == null && jCurrentTimeMillis2 > 0; jCurrentTimeMillis2 = j2 - zzibVar3.f39094k.currentTimeMillis()) {
                                try {
                                    atomicReference2.wait(jCurrentTimeMillis2);
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    } catch (InterruptedException unused) {
                        zzgt zzgtVar9 = zzliVar.f39180a.f39089f;
                        zzib.l(zzgtVar9);
                        zzgtVar9.f38961i.a("[sgtm] Interrupted waiting for uploading batch");
                    }
                    zzlqVar = atomicReference2.get() == null ? zzlq.UNKNOWN : (zzlq) atomicReference2.get();
                } catch (MalformedURLException | URISyntaxException e2) {
                    i2 = size;
                    zzgt zzgtVar10 = zzliVar.f39180a.f39089f;
                    zzib.l(zzgtVar10);
                    zzgtVar10.f38958f.d("[sgtm] Bad upload url for row_id", zzolVar.f39554c, Long.valueOf(zzolVar.f39552a), e2);
                    zzlqVar = zzlq.FAILURE;
                }
                if (zzlqVar != zzlq.SUCCESS) {
                    if (zzlqVar == zzlq.BACKOFF) {
                        z = true;
                        size = i2;
                        break;
                    }
                } else {
                    i3++;
                }
                size = i2;
            }
        }
        zzgt zzgtVar11 = zzibVar.f39089f;
        zzib.l(zzgtVar11);
        zzgtVar11.n.c("[sgtm] Completed client-side batch upload work. total, success", Integer.valueOf(size), Integer.valueOf(i3));
        runnable.run();
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setConditionalUserProperty(@NonNull Bundle bundle, long j2) throws RemoteException {
        zzb();
        if (bundle == null) {
            zzgt zzgtVar = this.f38653a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Conditional user property must not be null");
        } else {
            zzli zzliVar = this.f38653a.f39096m;
            zzib.k(zzliVar);
            zzliVar.x(bundle, j2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setConsent(@NonNull Bundle bundle, long j2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setConsentThirdParty(@NonNull Bundle bundle, long j2) throws Throwable {
        zzb();
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        zzliVar.G(bundle, -20, j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setCurrentScreen(@NonNull IObjectWrapper iObjectWrapper, @NonNull String str, @NonNull String str2, long j2) throws RemoteException {
        zzb();
        setCurrentScreenByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.b((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.z0(iObjectWrapper))), str, str2, j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0086, code lost:
    
        if (r3 <= 500) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00af, code lost:
    
        if (r3 <= 500) goto L39;
     */
    @Override // com.google.android.gms.internal.measurement.zzcr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setCurrentScreenByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf r6, java.lang.String r7, java.lang.String r8, long r9) throws android.os.RemoteException {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.AppMeasurementDynamiteService.setCurrentScreenByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf, java.lang.String, java.lang.String, long):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        zzb();
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        zzliVar.h();
        zzhy zzhyVar = zzliVar.f39180a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.p(new zzjx(zzliVar, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setDefaultEventParameters(@NonNull Bundle bundle) {
        zzb();
        final zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        final Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        zzhy zzhyVar = zzliVar.f39180a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.p(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzle
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                Bundle bundle3;
                zzkm zzkmVar;
                zzal zzalVar;
                zzgt zzgtVar;
                zzpo zzpoVar;
                zzli zzliVar2 = zzliVar;
                zzliVar2.getClass();
                Bundle bundle4 = bundle2;
                boolean zIsEmpty = bundle4.isEmpty();
                zzib zzibVar = zzliVar2.f39180a;
                if (zIsEmpty) {
                    bundle3 = bundle4;
                } else {
                    zzhg zzhgVar = zzibVar.f39088e;
                    zzib.j(zzhgVar);
                    bundle3 = new Bundle(zzhgVar.y.a());
                    Iterator<String> it = bundle4.keySet().iterator();
                    while (true) {
                        boolean zHasNext = it.hasNext();
                        zzkmVar = zzliVar2.w;
                        zzalVar = zzibVar.f39087d;
                        zzgtVar = zzibVar.f39089f;
                        zzpoVar = zzibVar.f39092i;
                        if (!zHasNext) {
                            break;
                        }
                        String next = it.next();
                        Object obj = bundle4.get(next);
                        if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                            zzib.j(zzpoVar);
                            if (zzpo.n0(obj)) {
                                zzpo.w(zzkmVar, null, 27, null, null, 0);
                            }
                            zzib.l(zzgtVar);
                            zzgtVar.f38963k.c("Invalid default event parameter type. Name, value", next, obj);
                        } else if (zzpo.D(next)) {
                            zzib.l(zzgtVar);
                            zzgtVar.f38963k.b(next, "Invalid default event parameter name. Name");
                        } else if (obj == null) {
                            bundle3.remove(next);
                        } else {
                            zzib.j(zzpoVar);
                            zzalVar.getClass();
                            if (zzpoVar.o0("param", next, 500, obj)) {
                                zzpoVar.v(bundle3, next, obj);
                            }
                        }
                    }
                    zzib.j(zzpoVar);
                    zzpo zzpoVar2 = zzalVar.f39180a.f39092i;
                    zzib.j(zzpoVar2);
                    int i2 = zzpoVar2.K(201500000) ? 100 : 25;
                    if (bundle3.size() > i2) {
                        Iterator it2 = new TreeSet(bundle3.keySet()).iterator();
                        int i3 = 0;
                        while (it2.hasNext()) {
                            String str = (String) it2.next();
                            i3++;
                            if (i3 > i2) {
                                bundle3.remove(str);
                            }
                        }
                        zzib.j(zzpoVar);
                        zzpo.w(zzkmVar, null, 26, null, null, 0);
                        zzib.l(zzgtVar);
                        zzgtVar.f38963k.a("Too many default event parameters set. Discarding beyond event parameter limit");
                    }
                }
                zzhg zzhgVar2 = zzibVar.f39088e;
                zzib.j(zzhgVar2);
                zzhgVar2.y.b(bundle3);
                if (bundle4.isEmpty()) {
                    if (!zzibVar.f39087d.q(null, zzfx.W0)) {
                        return;
                    }
                }
                zzibVar.o().l(bundle3);
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setEventInterceptor(com.google.android.gms.internal.measurement.zzda zzdaVar) throws RemoteException {
        zzb();
        zzp zzpVar = new zzp(this, zzdaVar);
        zzhy zzhyVar = this.f38653a.f39090g;
        zzib.l(zzhyVar);
        if (!zzhyVar.m()) {
            zzhy zzhyVar2 = this.f38653a.f39090g;
            zzib.l(zzhyVar2);
            zzhyVar2.p(new zzl(this, zzpVar));
            return;
        }
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        zzliVar.g();
        zzliVar.h();
        zzjo zzjoVar = zzliVar.f39316d;
        if (zzpVar != zzjoVar) {
            Preconditions.checkState(zzjoVar == null, "EventInterceptor already set.");
        }
        zzliVar.f39316d = zzpVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.zzdc zzdcVar) throws RemoteException {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setMeasurementEnabled(boolean z, long j2) throws RemoteException {
        zzb();
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        Boolean boolValueOf = Boolean.valueOf(z);
        zzliVar.h();
        zzhy zzhyVar = zzliVar.f39180a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.p(new zzkr(zzliVar, boolValueOf));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setMinimumSessionDuration(long j2) throws RemoteException {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setSessionTimeoutDuration(long j2) throws RemoteException {
        zzb();
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        zzhy zzhyVar = zzliVar.f39180a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.p(new zzjz(zzliVar, j2));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setSgtmDebugInfo(@NonNull Intent intent) throws RemoteException {
        zzb();
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        Uri data = intent.getData();
        zzib zzibVar = zzliVar.f39180a;
        if (data == null) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38964l.a("Activity intent has no data. Preview Mode was not enabled.");
            return;
        }
        String queryParameter = data.getQueryParameter("sgtm_debug_enable");
        if (queryParameter == null || !queryParameter.equals("1")) {
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38964l.a("[sgtm] Preview Mode was not enabled.");
            zzibVar.f39087d.f38689c = null;
            return;
        }
        String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
        if (TextUtils.isEmpty(queryParameter2)) {
            return;
        }
        zzgt zzgtVar3 = zzibVar.f39089f;
        zzib.l(zzgtVar3);
        zzgtVar3.f38964l.b(queryParameter2, "[sgtm] Preview Mode was enabled. Using the sgtmPreviewKey: ");
        zzibVar.f39087d.f38689c = queryParameter2;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setUserId(@NonNull final String str, long j2) throws RemoteException {
        zzb();
        final zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        zzib zzibVar = zzliVar.f39180a;
        if (str != null && TextUtils.isEmpty(str)) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38961i.a("User ID must be non-empty or null");
        } else {
            zzhy zzhyVar = zzibVar.f39090g;
            zzib.l(zzhyVar);
            zzhyVar.p(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlf
                @Override // java.lang.Runnable
                public final void run() {
                    zzib zzibVar2 = zzliVar.f39180a;
                    zzgh zzghVarQ = zzibVar2.q();
                    String str2 = zzghVarQ.q;
                    String str3 = str;
                    boolean z = false;
                    if (str2 != null && !str2.equals(str3)) {
                        z = true;
                    }
                    zzghVarQ.q = str3;
                    if (z) {
                        zzibVar2.q().l();
                    }
                }
            });
            zzliVar.r(null, "_id", str, true, j2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull IObjectWrapper iObjectWrapper, boolean z, long j2) throws SecurityException, RemoteException {
        zzb();
        Object objZ0 = ObjectWrapper.z0(iObjectWrapper);
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        zzliVar.r(str, str2, objZ0, z, j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzda zzdaVar) throws RemoteException {
        Object zzqVar;
        zzb();
        ArrayMap arrayMap = this.f38654b;
        synchronized (arrayMap) {
            zzqVar = (zzjp) arrayMap.remove(Integer.valueOf(zzdaVar.zzf()));
        }
        if (zzqVar == null) {
            zzqVar = new zzq(this, zzdaVar);
        }
        zzli zzliVar = this.f38653a.f39096m;
        zzib.k(zzliVar);
        zzliVar.h();
        Preconditions.checkNotNull(zzqVar);
        if (zzliVar.f39317e.remove(zzqVar)) {
            return;
        }
        zzgt zzgtVar = zzliVar.f39180a.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.f38961i.a("OnEventListener had not been registered");
    }

    public final void z0(String str, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        zzb();
        zzpo zzpoVar = this.f38653a.f39092i;
        zzib.j(zzpoVar);
        zzpoVar.N(str, zzcuVar);
    }

    public final void zzb() {
        if (this.f38653a == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }
}
