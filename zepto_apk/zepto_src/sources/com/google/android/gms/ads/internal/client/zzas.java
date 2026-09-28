package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbcd;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbsv;
import com.google.android.gms.internal.ads.zzbxv;
import com.google.android.gms.internal.ads.zzbxx;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzas extends zzba {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReactApplicationContext f21121b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzbsv f21122c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzaz f21123d;

    public zzas(zzaz zzazVar, ReactApplicationContext reactApplicationContext, zzbsv zzbsvVar) {
        this.f21121b = reactApplicationContext;
        this.f21122c = zzbsvVar;
        Objects.requireNonNull(zzazVar);
        this.f21123d = zzazVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object a() {
        zzaz.k(this.f21121b, "ads_preloader");
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object b() {
        zzck zzciVar;
        ReactApplicationContext reactApplicationContext = this.f21121b;
        ObjectWrapper objectWrapper = new ObjectWrapper(reactApplicationContext);
        zzbgk.a(reactApplicationContext);
        boolean zBooleanValue = ((Boolean) zzbd.f21150e.f21153c.a(zzbgk.Ob)).booleanValue();
        zzbsv zzbsvVar = this.f21122c;
        zzaz zzazVar = this.f21123d;
        if (!zBooleanValue) {
            zzl zzlVar = zzazVar.f21138g;
            try {
                ObjectWrapper objectWrapper2 = new ObjectWrapper(reactApplicationContext);
                zzcl zzclVar = (zzcl) zzlVar.getRemoteCreatorInstance(reactApplicationContext);
                Parcel parcelG = zzclVar.g();
                zzbcd.e(parcelG, objectWrapper2);
                zzbcd.e(parcelG, zzbsvVar);
                parcelG.writeInt(ModuleDescriptor.MODULE_VERSION);
                Parcel parcelZ0 = zzclVar.z0(1, parcelG);
                IBinder strongBinder = parcelZ0.readStrongBinder();
                parcelZ0.recycle();
                if (strongBinder == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloader");
                return iInterfaceQueryLocalInterface instanceof zzck ? (zzck) iInterfaceQueryLocalInterface : new zzci(strongBinder);
            } catch (RemoteException e2) {
                e = e2;
                com.google.android.gms.ads.internal.util.client.zzo.g("Could not get remote AdPreloaderCreator.", e);
                return null;
            } catch (RemoteCreator.RemoteCreatorException e3) {
                e = e3;
                com.google.android.gms.ads.internal.util.client.zzo.g("Could not get remote AdPreloaderCreator.", e);
                return null;
            } catch (NullPointerException e4) {
                e = e4;
                com.google.android.gms.ads.internal.util.client.zzo.g("Could not get remote AdPreloaderCreator.", e);
                return null;
            }
        }
        try {
            zzcl zzclVar2 = (zzcl) com.google.android.gms.ads.internal.util.client.zzs.a(reactApplicationContext, "com.google.android.gms.ads.ChimeraAdPreloaderCreatorImpl", zzar.f21120a);
            Parcel parcelG2 = zzclVar2.g();
            zzbcd.e(parcelG2, objectWrapper);
            zzbcd.e(parcelG2, zzbsvVar);
            parcelG2.writeInt(ModuleDescriptor.MODULE_VERSION);
            Parcel parcelZ02 = zzclVar2.z0(1, parcelG2);
            IBinder strongBinder2 = parcelZ02.readStrongBinder();
            parcelZ02.recycle();
            if (strongBinder2 == null) {
                zzciVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloader");
                zzciVar = iInterfaceQueryLocalInterface2 instanceof zzck ? (zzck) iInterfaceQueryLocalInterface2 : new zzci(strongBinder2);
            }
            zzciVar.W9(zzbsvVar);
            return zzciVar;
        } catch (RemoteException e5) {
            e = e5;
            zzbxx zzbxxVarC = zzbxv.c(reactApplicationContext);
            zzazVar.f21137f = zzbxxVarC;
            zzbxxVarC.a("ClientApiBroker.getAdPreloader", e);
            return null;
        } catch (com.google.android.gms.ads.internal.util.client.zzr e6) {
            e = e6;
            zzbxx zzbxxVarC2 = zzbxv.c(reactApplicationContext);
            zzazVar.f21137f = zzbxxVarC2;
            zzbxxVarC2.a("ClientApiBroker.getAdPreloader", e);
            return null;
        } catch (NullPointerException e7) {
            e = e7;
            zzbxx zzbxxVarC22 = zzbxv.c(reactApplicationContext);
            zzazVar.f21137f = zzbxxVarC22;
            zzbxxVarC22.a("ClientApiBroker.getAdPreloader", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object c(zzcr zzcrVar) {
        return zzcrVar.ja(new ObjectWrapper(this.f21121b), this.f21122c, ModuleDescriptor.MODULE_VERSION);
    }
}
