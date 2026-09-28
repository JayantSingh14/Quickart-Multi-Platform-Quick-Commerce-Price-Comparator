package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public abstract class zzbqa extends zzbcc implements zzbqb {
    public zzbqa() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        zzdnj zzdnjVar;
        com.google.android.gms.ads.internal.client.zzed zzedVar = null;
        zzbjvVar = null;
        zzbjvVar = null;
        zzbjv zzbjvVar = null;
        zzbqe zzbqcVar = null;
        if (i2 == 3) {
            zzdrr zzdrrVar = (zzdrr) this;
            Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
            if (zzdrrVar.f28371d) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.c("getVideoController: Instream ad should not be used after destroyed");
            } else {
                zzedVar = zzdrrVar.f28369b;
            }
            parcel2.writeNoException();
            zzbcd.e(parcel2, zzedVar);
        } else if (i2 == 4) {
            zzdrr zzdrrVar2 = (zzdrr) this;
            Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
            zzdrrVar2.Yb();
            zzdnh zzdnhVar = zzdrrVar2.f28370c;
            if (zzdnhVar != null) {
                zzdnhVar.o();
            }
            zzdrrVar2.f28370c = null;
            zzdrrVar2.f28368a = null;
            zzdrrVar2.f28369b = null;
            zzdrrVar2.f28371d = true;
            parcel2.writeNoException();
        } else if (i2 == 5) {
            IObjectWrapper iObjectWrapperG = IObjectWrapper.Stub.g(parcel.readStrongBinder());
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
                zzbqcVar = iInterfaceQueryLocalInterface instanceof zzbqe ? (zzbqe) iInterfaceQueryLocalInterface : new zzbqc(strongBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
            }
            zzbcd.f(parcel);
            ((zzdrr) this).Xb(iObjectWrapperG, zzbqcVar);
            parcel2.writeNoException();
        } else if (i2 == 6) {
            IObjectWrapper iObjectWrapperG2 = android.support.v4.media.a.g(parcel, parcel);
            Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
            ((zzdrr) this).Xb(iObjectWrapperG2, new zzdrp());
            parcel2.writeNoException();
        } else {
            if (i2 != 7) {
                return false;
            }
            zzdrr zzdrrVar3 = (zzdrr) this;
            Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
            if (zzdrrVar3.f28371d) {
                int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.c("getVideoController: Instream ad should not be used after destroyed");
            } else {
                zzdnh zzdnhVar2 = zzdrrVar3.f28370c;
                if (zzdnhVar2 != null && (zzdnjVar = zzdnhVar2.F) != null) {
                    synchronized (zzdnjVar) {
                        zzbjvVar = zzdnjVar.f28021a;
                    }
                }
            }
            parcel2.writeNoException();
            zzbcd.e(parcel2, zzbjvVar);
        }
        return true;
    }
}
