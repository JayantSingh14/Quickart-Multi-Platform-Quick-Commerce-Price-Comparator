package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* loaded from: classes4.dex */
public final class zzcc {

    /* renamed from: a, reason: collision with root package name */
    public static Context f38431a;

    /* renamed from: b, reason: collision with root package name */
    public static zzf f38432b;

    public static zzf a(Context context, MapsInitializer.Renderer renderer) throws GooglePlayServicesNotAvailableException, ClassNotFoundException {
        Preconditions.checkNotNull(context);
        Log.d("zzcc", "preferredRenderer: ".concat(String.valueOf(renderer)));
        zzf zzfVar = f38432b;
        if (zzfVar != null) {
            return zzfVar;
        }
        int iIsGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context, 13400000);
        if (iIsGooglePlayServicesAvailable != 0) {
            throw new GooglePlayServicesNotAvailableException(iIsGooglePlayServicesAvailable);
        }
        zzf zzfVarC = c(context, renderer);
        f38432b = zzfVarC;
        try {
            if (zzfVarC.zzd() == 2) {
                try {
                    f38432b.G0(new ObjectWrapper(b(context, renderer)));
                } catch (RemoteException e2) {
                    throw new RuntimeRemoteException(e2);
                } catch (UnsatisfiedLinkError unused) {
                    Log.w("zzcc", "Caught UnsatisfiedLinkError attempting to load the LATEST renderer's native library. Attempting to use the LEGACY renderer instead.");
                    f38431a = null;
                    f38432b = c(context, MapsInitializer.Renderer.f38414a);
                }
            }
            try {
                zzf zzfVar2 = f38432b;
                Context contextB = b(context, renderer);
                contextB.getClass();
                zzfVar2.O0(new ObjectWrapper(contextB.getResources()));
                return f38432b;
            } catch (RemoteException e3) {
                throw new RuntimeRemoteException(e3);
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public static Context b(Context context, MapsInitializer.Renderer renderer) {
        Context remoteContext;
        Context context2 = f38431a;
        if (context2 != null) {
            return context2;
        }
        String str = renderer == MapsInitializer.Renderer.f38414a ? "com.google.android.gms.maps_legacy_dynamite" : "com.google.android.gms.maps_core_dynamite";
        try {
            remoteContext = DynamiteModule.c(context, DynamiteModule.f22318b, str).f22330a;
        } catch (Exception e2) {
            if (str.equals("com.google.android.gms.maps_dynamite")) {
                Log.e("zzcc", "Failed to load maps module, use pre-Chimera", e2);
                remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
            } else {
                try {
                    Log.d("zzcc", "Attempting to load maps_dynamite again.");
                    remoteContext = DynamiteModule.c(context, DynamiteModule.f22318b, "com.google.android.gms.maps_dynamite").f22330a;
                } catch (Exception e3) {
                    Log.e("zzcc", "Failed to load maps module, use pre-Chimera", e3);
                    remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
                }
            }
        }
        f38431a = remoteContext;
        return remoteContext;
    }

    public static zzf c(Context context, MapsInitializer.Renderer renderer) throws ClassNotFoundException {
        Log.i("zzcc", "Making Creator dynamically");
        try {
            Class<?> clsLoadClass = ((ClassLoader) Preconditions.checkNotNull(b(context, renderer).getClassLoader())).loadClass("com.google.android.gms.maps.internal.CreatorImpl");
            try {
                IBinder iBinder = (IBinder) clsLoadClass.newInstance();
                if (iBinder == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
                return iInterfaceQueryLocalInterface instanceof zzf ? (zzf) iInterfaceQueryLocalInterface : new zze(iBinder, "com.google.android.gms.maps.internal.ICreator");
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Unable to call the default constructor of ".concat(clsLoadClass.getName()), e2);
            } catch (InstantiationException e3) {
                throw new IllegalStateException("Unable to instantiate the dynamic class ".concat(clsLoadClass.getName()), e3);
            }
        } catch (ClassNotFoundException e4) {
            throw new IllegalStateException("Unable to find dynamic class com.google.android.gms.maps.internal.CreatorImpl", e4);
        }
    }
}
