package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.a;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbcc;
import com.google.android.gms.internal.ads.zzbcd;
import com.google.android.gms.internal.ads.zzbkc;
import com.google.android.gms.internal.ads.zzbki;
import com.google.android.gms.internal.ads.zzbol;
import com.google.android.gms.internal.ads.zzbon;
import com.google.android.gms.internal.ads.zzboq;
import com.google.android.gms.internal.ads.zzbsy;
import com.google.android.gms.internal.ads.zzbsz;
import com.google.android.gms.internal.ads.zzbwr;
import com.google.android.gms.internal.ads.zzbwy;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzccj;
import com.google.android.gms.internal.ads.zzclg;
import com.google.android.gms.internal.ads.zzfhk;
import com.google.android.gms.internal.ads.zzfho;

/* loaded from: classes4.dex */
public abstract class zzcq extends zzbcc implements zzcr {
    public zzcq() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        zzbon zzbolVar = null;
        switch (i2) {
            case 1:
                IObjectWrapper iObjectWrapperG = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzr zzrVar = (zzr) zzbcd.b(parcel, zzr.CREATOR);
                String string = parcel.readString();
                zzbsz zzbszVarXb = zzbsy.Xb(parcel.readStrongBinder());
                int i3 = parcel.readInt();
                zzbcd.f(parcel);
                zzbx zzbxVarM3 = ((ClientApi) this).m3(iObjectWrapperG, zzrVar, string, zzbszVarXb, i3);
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbxVarM3);
                return true;
            case 2:
                IObjectWrapper iObjectWrapperG2 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzr zzrVar2 = (zzr) zzbcd.b(parcel, zzr.CREATOR);
                String string2 = parcel.readString();
                zzbsz zzbszVarXb2 = zzbsy.Xb(parcel.readStrongBinder());
                int i4 = parcel.readInt();
                zzbcd.f(parcel);
                zzbx zzbxVarF2 = ((ClientApi) this).F2(iObjectWrapperG2, zzrVar2, string2, zzbszVarXb2, i4);
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbxVarF2);
                return true;
            case 3:
                IObjectWrapper iObjectWrapperG3 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                String string3 = parcel.readString();
                zzbsz zzbszVarXb3 = zzbsy.Xb(parcel.readStrongBinder());
                int i5 = parcel.readInt();
                zzbcd.f(parcel);
                zzbt zzbtVarD8 = ((ClientApi) this).D8(iObjectWrapperG3, string3, zzbszVarXb3, i5);
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbtVarD8);
                return true;
            case 4:
                IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                parcel2.writeNoException();
                parcel2.writeStrongBinder(null);
                return true;
            case 5:
                zzbkc zzbkcVarQ6 = ((ClientApi) this).Q6(IObjectWrapper.Stub.g(parcel.readStrongBinder()), a.g(parcel, parcel));
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbkcVarQ6);
                return true;
            case 6:
                IObjectWrapper iObjectWrapperG4 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbsz zzbszVarXb4 = zzbsy.Xb(parcel.readStrongBinder());
                int i6 = parcel.readInt();
                zzbcd.f(parcel);
                Context context = (Context) ObjectWrapper.z0(iObjectWrapperG4);
                zzfhk zzfhkVarT = zzclg.f(context, zzbszVarXb4, i6).t();
                zzfhkVarT.a(context);
                zzfho zzfhoVarZza = zzfhkVarT.zza().zza();
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzfhoVarZza);
                return true;
            case 7:
                IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                parcel2.writeNoException();
                parcel2.writeStrongBinder(null);
                return true;
            case 8:
                zzbwy zzbwyVarZ = ((ClientApi) this).Z(a.g(parcel, parcel));
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbwyVarZ);
                return true;
            case 9:
                IObjectWrapper iObjectWrapperG5 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                int i7 = parcel.readInt();
                zzbcd.f(parcel);
                zzdb zzdbVarE6 = ((ClientApi) this).e6(iObjectWrapperG5, i7);
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzdbVarE6);
                return true;
            case 10:
                IObjectWrapper iObjectWrapperG6 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzr zzrVar3 = (zzr) zzbcd.b(parcel, zzr.CREATOR);
                String string4 = parcel.readString();
                int i8 = parcel.readInt();
                zzbcd.f(parcel);
                zzbx zzbxVarH5 = ((ClientApi) this).H5(iObjectWrapperG6, zzrVar3, string4, i8);
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbxVarH5);
                return true;
            case 11:
                zzbki zzbkiVarZzk = ((ClientApi) this).zzk(IObjectWrapper.Stub.g(parcel.readStrongBinder()), IObjectWrapper.Stub.g(parcel.readStrongBinder()), a.g(parcel, parcel));
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbkiVarZzk);
                return true;
            case 12:
                IObjectWrapper iObjectWrapperG7 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                String string5 = parcel.readString();
                zzbsz zzbszVarXb5 = zzbsy.Xb(parcel.readStrongBinder());
                int i9 = parcel.readInt();
                zzbcd.f(parcel);
                zzcaf zzcafVarY2 = ((ClientApi) this).Y2(iObjectWrapperG7, string5, zzbszVarXb5, i9);
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzcafVarY2);
                return true;
            case 13:
                IObjectWrapper iObjectWrapperG8 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzr zzrVar4 = (zzr) zzbcd.b(parcel, zzr.CREATOR);
                String string6 = parcel.readString();
                zzbsz zzbszVarXb6 = zzbsy.Xb(parcel.readStrongBinder());
                int i10 = parcel.readInt();
                zzbcd.f(parcel);
                zzbx zzbxVarR6 = ((ClientApi) this).r6(iObjectWrapperG8, zzrVar4, string6, zzbszVarXb6, i10);
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbxVarR6);
                return true;
            case 14:
                IObjectWrapper iObjectWrapperG9 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbsz zzbszVarXb7 = zzbsy.Xb(parcel.readStrongBinder());
                int i11 = parcel.readInt();
                zzbcd.f(parcel);
                zzccj zzccjVarN7 = ((ClientApi) this).n7(iObjectWrapperG9, zzbszVarXb7, i11);
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzccjVarN7);
                return true;
            case 15:
                IObjectWrapper iObjectWrapperG10 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbsz zzbszVarXb8 = zzbsy.Xb(parcel.readStrongBinder());
                int i12 = parcel.readInt();
                zzbcd.f(parcel);
                zzbwr zzbwrVarG6 = ((ClientApi) this).G6(iObjectWrapperG10, zzbszVarXb8, i12);
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbwrVarG6);
                return true;
            case 16:
                IObjectWrapper iObjectWrapperG11 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbsz zzbszVarXb9 = zzbsy.Xb(parcel.readStrongBinder());
                int i13 = parcel.readInt();
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.h5.client.IH5AdsEventListener");
                    zzbolVar = iInterfaceQueryLocalInterface instanceof zzbon ? (zzbon) iInterfaceQueryLocalInterface : new zzbol(strongBinder, "com.google.android.gms.ads.internal.h5.client.IH5AdsEventListener");
                }
                zzbcd.f(parcel);
                zzboq zzboqVarJ3 = ((ClientApi) this).j3(iObjectWrapperG11, zzbszVarXb9, i13, zzbolVar);
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzboqVarJ3);
                return true;
            case 17:
                IObjectWrapper iObjectWrapperG12 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbsz zzbszVarXb10 = zzbsy.Xb(parcel.readStrongBinder());
                int i14 = parcel.readInt();
                zzbcd.f(parcel);
                zzdw zzdwVarN5 = ((ClientApi) this).n5(iObjectWrapperG12, zzbszVarXb10, i14);
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzdwVarN5);
                return true;
            case 18:
                IObjectWrapper iObjectWrapperG13 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbsz zzbszVarXb11 = zzbsy.Xb(parcel.readStrongBinder());
                int i15 = parcel.readInt();
                zzbcd.f(parcel);
                zzck zzckVarJa = ((ClientApi) this).ja(iObjectWrapperG13, zzbszVarXb11, i15);
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzckVarJa);
                return true;
            default:
                return false;
        }
    }
}
