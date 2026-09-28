package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* loaded from: classes3.dex */
public final class zzoe {

    @VisibleForTesting
    final zzoh zza;

    @VisibleForTesting
    final boolean zzb;

    private zzoe(zzoh zzohVar) {
        this.zza = zzohVar;
        this.zzb = zzohVar != null;
    }

    public static zzoe zzb(Context context, String str, String str2) throws zzni {
        zzoh zzofVar;
        try {
            try {
                try {
                    IBinder iBinderB = DynamiteModule.c(context, DynamiteModule.f22318b, ModuleDescriptor.MODULE_ID).b("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger");
                    if (iBinderB == null) {
                        zzofVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderB.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                        zzofVar = iInterfaceQueryLocalInterface instanceof zzoh ? (zzoh) iInterfaceQueryLocalInterface : new zzof(iBinderB);
                    }
                    zzofVar.zze(new ObjectWrapper(context), str, null);
                    Log.i("GASS", "GassClearcutLogger Initialized.");
                    return new zzoe(zzofVar);
                } catch (Exception e2) {
                    throw new zzni(e2);
                }
            } catch (RemoteException | zzni | NullPointerException | SecurityException unused) {
                Log.d("GASS", "Cannot dynamite load clearcut");
                return new zzoe(new zzoi());
            }
        } catch (Exception e3) {
            throw new zzni(e3);
        }
    }

    public static zzoe zzc() {
        zzoi zzoiVar = new zzoi();
        Log.d("GASS", "Clearcut logging disabled");
        return new zzoe(zzoiVar);
    }

    public final zzod zza(byte[] bArr) {
        return new zzod(this, bArr, null);
    }
}
