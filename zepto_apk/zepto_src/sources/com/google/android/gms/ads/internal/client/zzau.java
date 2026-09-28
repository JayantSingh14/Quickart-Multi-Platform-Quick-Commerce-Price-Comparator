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
import com.google.android.gms.internal.ads.zzbxv;
import com.google.android.gms.internal.ads.zzbxx;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzau extends zzba {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReactApplicationContext f21125b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzaz f21126c;

    public zzau(zzaz zzazVar, ReactApplicationContext reactApplicationContext) {
        this.f21125b = reactApplicationContext;
        Objects.requireNonNull(zzazVar);
        this.f21126c = zzazVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object a() {
        zzaz.k(this.f21125b, "mobile_ads_settings");
        return new zzfm();
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object b() {
        ReactApplicationContext reactApplicationContext = this.f21125b;
        zzbgk.a(reactApplicationContext);
        boolean zBooleanValue = ((Boolean) zzbd.f21150e.f21153c.a(zzbgk.Ob)).booleanValue();
        zzaz zzazVar = this.f21126c;
        if (!zBooleanValue) {
            zzff zzffVar = zzazVar.f21134c;
            try {
                ObjectWrapper objectWrapper = new ObjectWrapper(reactApplicationContext);
                zzdc zzdcVar = (zzdc) zzffVar.getRemoteCreatorInstance(reactApplicationContext);
                Parcel parcelG = zzdcVar.g();
                zzbcd.e(parcelG, objectWrapper);
                parcelG.writeInt(ModuleDescriptor.MODULE_VERSION);
                Parcel parcelZ0 = zzdcVar.z0(1, parcelG);
                IBinder strongBinder = parcelZ0.readStrongBinder();
                parcelZ0.recycle();
                if (strongBinder == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
                return iInterfaceQueryLocalInterface instanceof zzdb ? (zzdb) iInterfaceQueryLocalInterface : new zzcz(strongBinder);
            } catch (RemoteException e2) {
                e = e2;
                com.google.android.gms.ads.internal.util.client.zzo.g("Could not get remote MobileAdsSettingManager.", e);
                return null;
            } catch (RemoteCreator.RemoteCreatorException e3) {
                e = e3;
                com.google.android.gms.ads.internal.util.client.zzo.g("Could not get remote MobileAdsSettingManager.", e);
                return null;
            }
        }
        try {
            ObjectWrapper objectWrapper2 = new ObjectWrapper(reactApplicationContext);
            zzdc zzdcVar2 = (zzdc) com.google.android.gms.ads.internal.util.client.zzs.a(reactApplicationContext, "com.google.android.gms.ads.ChimeraMobileAdsSettingManagerCreatorImpl", zzat.f21124a);
            Parcel parcelG2 = zzdcVar2.g();
            zzbcd.e(parcelG2, objectWrapper2);
            parcelG2.writeInt(ModuleDescriptor.MODULE_VERSION);
            Parcel parcelZ02 = zzdcVar2.z0(1, parcelG2);
            IBinder strongBinder2 = parcelZ02.readStrongBinder();
            parcelZ02.recycle();
            if (strongBinder2 == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            return iInterfaceQueryLocalInterface2 instanceof zzdb ? (zzdb) iInterfaceQueryLocalInterface2 : new zzcz(strongBinder2);
        } catch (RemoteException e4) {
            e = e4;
            zzbxx zzbxxVarC = zzbxv.c(reactApplicationContext);
            zzazVar.f21137f = zzbxxVarC;
            zzbxxVarC.a("ClientApiBroker.getMobileAdsSettingsManager", e);
            return null;
        } catch (com.google.android.gms.ads.internal.util.client.zzr e5) {
            e = e5;
            zzbxx zzbxxVarC2 = zzbxv.c(reactApplicationContext);
            zzazVar.f21137f = zzbxxVarC2;
            zzbxxVarC2.a("ClientApiBroker.getMobileAdsSettingsManager", e);
            return null;
        } catch (NullPointerException e6) {
            e = e6;
            zzbxx zzbxxVarC22 = zzbxv.c(reactApplicationContext);
            zzazVar.f21137f = zzbxxVarC22;
            zzbxxVarC22.a("ClientApiBroker.getMobileAdsSettingsManager", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object c(zzcr zzcrVar) {
        return zzcrVar.e6(new ObjectWrapper(this.f21125b), ModuleDescriptor.MODULE_VERSION);
    }
}
