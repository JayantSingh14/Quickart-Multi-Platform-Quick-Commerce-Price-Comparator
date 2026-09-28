package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class zzbko extends zzbcc implements zzbkp {
    public zzbko() {
        super("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        List list;
        zzbjy zzbjyVar;
        IObjectWrapper iObjectWrapper;
        switch (i2) {
            case 2:
                ObjectWrapper objectWrapper = new ObjectWrapper(((zzdrv) this).f28382b);
                parcel2.writeNoException();
                zzbcd.e(parcel2, objectWrapper);
                return true;
            case 3:
                String strA = ((zzdrv) this).f28383c.a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            case 4:
                zzdnm zzdnmVar = ((zzdrv) this).f28383c;
                synchronized (zzdnmVar) {
                    list = zzdnmVar.f28030e;
                }
                parcel2.writeNoException();
                parcel2.writeList(list);
                return true;
            case 5:
                String strC = ((zzdrv) this).f28383c.c();
                parcel2.writeNoException();
                parcel2.writeString(strC);
                return true;
            case 6:
                zzdnm zzdnmVar2 = ((zzdrv) this).f28383c;
                synchronized (zzdnmVar2) {
                    zzbjyVar = zzdnmVar2.t;
                }
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbjyVar);
                return true;
            case 7:
                String strE = ((zzdrv) this).f28383c.e();
                parcel2.writeNoException();
                parcel2.writeString(strE);
                return true;
            case 8:
                String strF = ((zzdrv) this).f28383c.f();
                parcel2.writeNoException();
                parcel2.writeString(strF);
                return true;
            case 9:
                Bundle bundleD = ((zzdrv) this).f28383c.d();
                parcel2.writeNoException();
                zzbcd.d(parcel2, bundleD);
                return true;
            case 10:
                ((zzdrv) this).f28382b.o();
                parcel2.writeNoException();
                return true;
            case 11:
                com.google.android.gms.ads.internal.client.zzed zzedVarR = ((zzdrv) this).f28383c.r();
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzedVarR);
                return true;
            case 12:
                Bundle bundle = (Bundle) zzbcd.b(parcel, Bundle.CREATOR);
                zzbcd.f(parcel);
                zzdnh zzdnhVar = ((zzdrv) this).f28382b;
                synchronized (zzdnhVar) {
                    zzdnhVar.n.W(bundle);
                }
                parcel2.writeNoException();
                return true;
            case 13:
                Bundle bundle2 = (Bundle) zzbcd.b(parcel, Bundle.CREATOR);
                zzbcd.f(parcel);
                boolean zP = ((zzdrv) this).f28382b.p(bundle2);
                parcel2.writeNoException();
                parcel2.writeInt(zP ? 1 : 0);
                return true;
            case 14:
                Bundle bundle3 = (Bundle) zzbcd.b(parcel, Bundle.CREATOR);
                zzbcd.f(parcel);
                zzdnh zzdnhVar2 = ((zzdrv) this).f28382b;
                synchronized (zzdnhVar2) {
                    zzdnhVar2.n.d0(bundle3);
                }
                parcel2.writeNoException();
                return true;
            case 15:
                zzbjr zzbjrVarS = ((zzdrv) this).f28383c.s();
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbjrVarS);
                return true;
            case 16:
                zzdnm zzdnmVar3 = ((zzdrv) this).f28383c;
                synchronized (zzdnmVar3) {
                    iObjectWrapper = zzdnmVar3.q;
                }
                parcel2.writeNoException();
                zzbcd.e(parcel2, iObjectWrapper);
                return true;
            case 17:
                String str = ((zzdrv) this).f28381a;
                parcel2.writeNoException();
                parcel2.writeString(str);
                return true;
            default:
                return false;
        }
    }
}
