package com.google.android.gms.internal.pal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* loaded from: classes4.dex */
public final class zzhp {

    /* renamed from: a, reason: collision with root package name */
    public final zzhs f37803a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f37804b = true;

    public zzhp(zzhs zzhsVar) {
        this.f37803a = zzhsVar;
    }

    public static zzhp a(Context context) throws zzhg {
        zzhs zzhqVar;
        try {
            try {
                try {
                    IBinder iBinderB = DynamiteModule.c(context, DynamiteModule.f22318b, ModuleDescriptor.MODULE_ID).b("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger");
                    if (iBinderB == null) {
                        zzhqVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderB.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                        zzhqVar = iInterfaceQueryLocalInterface instanceof zzhs ? (zzhs) iInterfaceQueryLocalInterface : new zzhq(iBinderB, "com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                    }
                    zzhqVar.g1(new ObjectWrapper(context));
                    Log.i("GASS", "GassClearcutLogger Initialized.");
                    return new zzhp(zzhqVar);
                } catch (Exception e2) {
                    throw new zzhg(e2);
                }
            } catch (Exception e3) {
                throw new zzhg(e3);
            }
        } catch (RemoteException | zzhg | NullPointerException | SecurityException unused) {
            Log.d("GASS", "Cannot dynamite load clearcut");
            return new zzhp(new zzht());
        }
    }
}
