package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* loaded from: classes4.dex */
public final class zzfwb {

    /* renamed from: a, reason: collision with root package name */
    public final zzfwe f31969a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f31970b = true;

    public zzfwb(zzfwe zzfweVar) {
        this.f31969a = zzfweVar;
    }

    public static zzfwb a(Context context, String str) throws zzfve {
        zzfwe zzfwcVar;
        try {
            try {
                try {
                    IBinder iBinderB = DynamiteModule.c(context, DynamiteModule.f22318b, ModuleDescriptor.MODULE_ID).b("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger");
                    if (iBinderB == null) {
                        zzfwcVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderB.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                        zzfwcVar = iInterfaceQueryLocalInterface instanceof zzfwe ? (zzfwe) iInterfaceQueryLocalInterface : new zzfwc(iBinderB, "com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                    }
                    zzfwcVar.V3(new ObjectWrapper(context), str);
                    Log.i("GASS", "GassClearcutLogger Initialized.");
                    return new zzfwb(zzfwcVar);
                } catch (Exception e2) {
                    throw new zzfve(e2);
                }
            } catch (RemoteException | zzfve | NullPointerException | SecurityException unused) {
                Log.d("GASS", "Cannot dynamite load clearcut");
                return new zzfwb(new zzfwf());
            }
        } catch (Exception e3) {
            throw new zzfve(e3);
        }
    }
}
