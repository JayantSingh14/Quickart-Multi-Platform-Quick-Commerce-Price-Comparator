package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public abstract class zzbhb extends zzbcc implements zzbhc {
    public zzbhb() {
        super("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            parcel2.writeNoException();
            parcel2.writeString(((zzbha) this).f25052b);
            return true;
        }
        if (i2 == 2) {
            parcel2.writeNoException();
            parcel2.writeString(((zzbha) this).f25053c);
            return true;
        }
        if (i2 == 3) {
            IObjectWrapper iObjectWrapperG = android.support.v4.media.a.g(parcel, parcel);
            zzbha zzbhaVar = (zzbha) this;
            if (iObjectWrapperG != null) {
                zzbhaVar.f25051a.zza((View) ObjectWrapper.z0(iObjectWrapperG));
            }
            parcel2.writeNoException();
            return true;
        }
        if (i2 == 4) {
            ((zzbha) this).f25051a.zzb();
            parcel2.writeNoException();
            return true;
        }
        if (i2 != 5) {
            return false;
        }
        ((zzbha) this).f25051a.zzc();
        parcel2.writeNoException();
        return true;
    }
}
