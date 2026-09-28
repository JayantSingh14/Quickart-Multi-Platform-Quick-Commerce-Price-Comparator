package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbif;
import com.google.android.gms.internal.ads.zzbit;

/* loaded from: classes4.dex */
abstract class zzba {

    /* renamed from: a, reason: collision with root package name */
    public static final zzcr f21140a;

    static {
        zzcr zzcpVar = null;
        try {
            Object objNewInstance = zzaz.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(null).newInstance(null);
            if (objNewInstance instanceof IBinder) {
                IBinder iBinder = (IBinder) objNewInstance;
                if (iBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzcpVar = iInterfaceQueryLocalInterface instanceof zzcr ? (zzcr) iInterfaceQueryLocalInterface : new zzcp(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
                }
            } else {
                com.google.android.gms.ads.internal.util.client.zzo.f("ClientApi class is not an instance of IBinder.");
            }
        } catch (Exception unused) {
            com.google.android.gms.ads.internal.util.client.zzo.f("Failed to instantiate ClientApi class.");
        }
        f21140a = zzcpVar;
    }

    public abstract Object a();

    public abstract Object b();

    public abstract Object c(zzcr zzcrVar);

    public final Object d(Context context, boolean z) {
        boolean z2;
        Object objB;
        Object objC;
        if (!z) {
            com.google.android.gms.ads.internal.util.client.zzf zzfVar = zzbb.f21141g.f21142a;
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 12451000) != 0) {
                com.google.android.gms.ads.internal.util.client.zzo.a("Google Play Services is not available.");
                z = true;
            }
        }
        boolean z3 = false;
        boolean z4 = !(DynamiteModule.a(context, ModuleDescriptor.MODULE_ID) <= DynamiteModule.d(context, ModuleDescriptor.MODULE_ID, false));
        zzbgk.a(context);
        if (((Boolean) zzbif.f25137a.c()).booleanValue()) {
            z2 = false;
        } else if (((Boolean) zzbif.f25138b.c()).booleanValue()) {
            z2 = true;
            z3 = true;
        } else {
            z3 = z | z4;
            z2 = false;
        }
        zzcr zzcrVar = f21140a;
        Object objC2 = null;
        if (z3) {
            if (zzcrVar != null) {
                try {
                    objC = c(zzcrVar);
                } catch (RemoteException e2) {
                    com.google.android.gms.ads.internal.util.client.zzo.g("Cannot invoke local loader using ClientApi class.", e2);
                }
                if (objC == null && !z2) {
                    try {
                        objC2 = b();
                    } catch (RemoteException e3) {
                        com.google.android.gms.ads.internal.util.client.zzo.g("Cannot invoke remote loader.", e3);
                    }
                    objC = objC2;
                }
            } else {
                com.google.android.gms.ads.internal.util.client.zzo.f("ClientApi class cannot be loaded.");
            }
            objC = null;
            if (objC == null) {
                objC2 = b();
                objC = objC2;
            }
        } else {
            try {
                objB = b();
            } catch (RemoteException e4) {
                com.google.android.gms.ads.internal.util.client.zzo.g("Cannot invoke remote loader.", e4);
                objB = null;
            }
            if (objB == null) {
                int iIntValue = ((Long) zzbit.f25213a.c()).intValue();
                zzbb zzbbVar = zzbb.f21141g;
                if (zzbbVar.f21146e.nextInt(iIntValue) == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("action", "dynamite_load");
                    bundle.putInt("is_missing", 1);
                    zzbbVar.f21142a.k(context, zzbbVar.f21145d.f21400a, bundle);
                }
            }
            if (objB == null) {
                if (zzcrVar != null) {
                    try {
                        objC2 = c(zzcrVar);
                    } catch (RemoteException e5) {
                        com.google.android.gms.ads.internal.util.client.zzo.g("Cannot invoke local loader using ClientApi class.", e5);
                    }
                } else {
                    com.google.android.gms.ads.internal.util.client.zzo.f("ClientApi class cannot be loaded.");
                }
                objC = objC2;
            } else {
                objC = objB;
            }
        }
        return objC == null ? a() : objC;
    }
}
