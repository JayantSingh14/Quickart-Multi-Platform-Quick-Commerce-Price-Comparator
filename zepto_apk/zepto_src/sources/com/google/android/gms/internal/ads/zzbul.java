package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public abstract class zzbul extends zzbcc implements zzbum {
    public zzbul() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        zzbti zzbtgVar;
        if (i2 == 1) {
            IObjectWrapper iObjectWrapperG = android.support.v4.media.a.g(parcel, parcel);
            zzeko zzekoVar = (zzeko) this;
            zzekoVar.f29558b.f29561c = (View) ObjectWrapper.z0(iObjectWrapperG);
            ((zzekv) zzekoVar.f29557a.f29464c).zzj();
        } else if (i2 == 2) {
            String string = parcel.readString();
            zzbcd.f(parcel);
            ((zzekv) ((zzeko) this).f29557a.f29464c).Qb(0, string);
        } else if (i2 == 3) {
            com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
            zzbcd.f(parcel);
            ((zzeko) this).a(zzeVar);
        } else {
            if (i2 != 4) {
                return false;
            }
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                zzbtgVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
                zzbtgVar = iInterfaceQueryLocalInterface instanceof zzbti ? (zzbti) iInterfaceQueryLocalInterface : new zzbtg(strongBinder);
            }
            zzbcd.f(parcel);
            zzeko zzekoVar2 = (zzeko) this;
            zzekoVar2.f29558b.f29562d = zzbtgVar;
            ((zzekv) zzekoVar2.f29557a.f29464c).zzj();
        }
        parcel2.writeNoException();
        return true;
    }
}
