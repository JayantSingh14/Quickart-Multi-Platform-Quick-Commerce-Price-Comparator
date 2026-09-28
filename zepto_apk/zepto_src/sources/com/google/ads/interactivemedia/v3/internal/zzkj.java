package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class zzkj extends RemoteCreator {
    private static final zzkj zza = new zzkj();

    private zzkj() {
        super("com.google.android.gms.ads.adshield.AdShieldCreatorImpl");
    }

    public static zzkm zza(Context context, Executor executor, zzm zzmVar) {
        zzkm zzkmVarZzb = null;
        if (zzmVar.zzh() && GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 12800000) == 0) {
            zzkmVarZzb = zza.zzb(context, executor, zzmVar);
        }
        return zzkmVarZzb == null ? new zzki(context, executor, zzmVar) : zzkmVarZzb;
    }

    private final zzkm zzb(Context context, Executor executor, zzm zzmVar) {
        try {
            IBinder iBinderZze = ((zzkn) getRemoteCreatorInstance(context)).zze(new ObjectWrapper(context), new ObjectWrapper(executor), zzmVar.zzav());
            if (iBinderZze == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderZze.queryLocalInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            return iInterfaceQueryLocalInterface instanceof zzkm ? (zzkm) iInterfaceQueryLocalInterface : new zzkk(iBinderZze);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException | IllegalArgumentException | LinkageError unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.adshield.internal.IAdShieldCreator");
        return iInterfaceQueryLocalInterface instanceof zzkn ? (zzkn) iInterfaceQueryLocalInterface : new zzkn(iBinder);
    }
}
