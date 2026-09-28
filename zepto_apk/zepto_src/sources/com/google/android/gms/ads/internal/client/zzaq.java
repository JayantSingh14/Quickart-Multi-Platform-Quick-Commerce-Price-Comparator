package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
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
final class zzaq extends zzba {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f21116b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f21117c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzbsv f21118d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzaz f21119e;

    public zzaq(zzaz zzazVar, Context context, String str, zzbsv zzbsvVar) {
        this.f21116b = context;
        this.f21117c = str;
        this.f21118d = zzbsvVar;
        Objects.requireNonNull(zzazVar);
        this.f21119e = zzazVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object a() {
        zzaz.k(this.f21116b, "native_ad");
        return new zzfi();
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object b() {
        Context context = this.f21116b;
        zzbgk.a(context);
        boolean zBooleanValue = ((Boolean) zzbd.f21150e.f21153c.a(zzbgk.Ob)).booleanValue();
        zzbsv zzbsvVar = this.f21118d;
        zzaz zzazVar = this.f21119e;
        String str = this.f21117c;
        if (!zBooleanValue) {
            zzi zziVar = zzazVar.f21133b;
            try {
                ObjectWrapper objectWrapper = new ObjectWrapper(context);
                zzbu zzbuVar = (zzbu) zziVar.getRemoteCreatorInstance(context);
                Parcel parcelG = zzbuVar.g();
                zzbcd.e(parcelG, objectWrapper);
                parcelG.writeString(str);
                zzbcd.e(parcelG, zzbsvVar);
                parcelG.writeInt(ModuleDescriptor.MODULE_VERSION);
                Parcel parcelZ0 = zzbuVar.z0(1, parcelG);
                IBinder strongBinder = parcelZ0.readStrongBinder();
                parcelZ0.recycle();
                if (strongBinder == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                return iInterfaceQueryLocalInterface instanceof zzbt ? (zzbt) iInterfaceQueryLocalInterface : new zzbr(strongBinder);
            } catch (RemoteException e2) {
                e = e2;
                com.google.android.gms.ads.internal.util.client.zzo.g("Could not create remote builder for AdLoader.", e);
                return null;
            } catch (RemoteCreator.RemoteCreatorException e3) {
                e = e3;
                com.google.android.gms.ads.internal.util.client.zzo.g("Could not create remote builder for AdLoader.", e);
                return null;
            }
        }
        try {
            ObjectWrapper objectWrapper2 = new ObjectWrapper(context);
            zzbu zzbuVar2 = (zzbu) com.google.android.gms.ads.internal.util.client.zzs.a(context, "com.google.android.gms.ads.ChimeraAdLoaderBuilderCreatorImpl", zzap.f21115a);
            Parcel parcelG2 = zzbuVar2.g();
            zzbcd.e(parcelG2, objectWrapper2);
            parcelG2.writeString(str);
            zzbcd.e(parcelG2, zzbsvVar);
            parcelG2.writeInt(ModuleDescriptor.MODULE_VERSION);
            Parcel parcelZ02 = zzbuVar2.z0(1, parcelG2);
            IBinder strongBinder2 = parcelZ02.readStrongBinder();
            parcelZ02.recycle();
            if (strongBinder2 == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            return iInterfaceQueryLocalInterface2 instanceof zzbt ? (zzbt) iInterfaceQueryLocalInterface2 : new zzbr(strongBinder2);
        } catch (RemoteException e4) {
            e = e4;
            zzbxx zzbxxVarC = zzbxv.c(context);
            zzazVar.f21137f = zzbxxVarC;
            zzbxxVarC.a("ClientApiBroker.createAdLoaderBuilder", e);
            return null;
        } catch (com.google.android.gms.ads.internal.util.client.zzr e5) {
            e = e5;
            zzbxx zzbxxVarC2 = zzbxv.c(context);
            zzazVar.f21137f = zzbxxVarC2;
            zzbxxVarC2.a("ClientApiBroker.createAdLoaderBuilder", e);
            return null;
        } catch (NullPointerException e6) {
            e = e6;
            zzbxx zzbxxVarC22 = zzbxv.c(context);
            zzazVar.f21137f = zzbxxVarC22;
            zzbxxVarC22.a("ClientApiBroker.createAdLoaderBuilder", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object c(zzcr zzcrVar) {
        return zzcrVar.D8(new ObjectWrapper(this.f21116b), this.f21117c, this.f21118d, ModuleDescriptor.MODULE_VERSION);
    }
}
