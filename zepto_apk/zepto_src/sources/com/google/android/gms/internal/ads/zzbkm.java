package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class zzbkm extends zzbcc implements zzbkn {
    public zzbkm() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        List list;
        zzbjy zzbjyVar;
        double d2;
        String strP;
        String strP2;
        IObjectWrapper iObjectWrapper;
        switch (i2) {
            case 2:
                ObjectWrapper objectWrapper = new ObjectWrapper(((zzdrt) this).f28376b);
                parcel2.writeNoException();
                zzbcd.e(parcel2, objectWrapper);
                return true;
            case 3:
                String strA = ((zzdrt) this).f28377c.a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            case 4:
                zzdnm zzdnmVar = ((zzdrt) this).f28377c;
                synchronized (zzdnmVar) {
                    list = zzdnmVar.f28030e;
                }
                parcel2.writeNoException();
                parcel2.writeList(list);
                return true;
            case 5:
                String strC = ((zzdrt) this).f28377c.c();
                parcel2.writeNoException();
                parcel2.writeString(strC);
                return true;
            case 6:
                zzdnm zzdnmVar2 = ((zzdrt) this).f28377c;
                synchronized (zzdnmVar2) {
                    zzbjyVar = zzdnmVar2.s;
                }
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbjyVar);
                return true;
            case 7:
                String strE = ((zzdrt) this).f28377c.e();
                parcel2.writeNoException();
                parcel2.writeString(strE);
                return true;
            case 8:
                zzdnm zzdnmVar3 = ((zzdrt) this).f28377c;
                synchronized (zzdnmVar3) {
                    d2 = zzdnmVar3.r;
                }
                parcel2.writeNoException();
                parcel2.writeDouble(d2);
                return true;
            case 9:
                zzdnm zzdnmVar4 = ((zzdrt) this).f28377c;
                synchronized (zzdnmVar4) {
                    strP = zzdnmVar4.p("store");
                }
                parcel2.writeNoException();
                parcel2.writeString(strP);
                return true;
            case 10:
                zzdnm zzdnmVar5 = ((zzdrt) this).f28377c;
                synchronized (zzdnmVar5) {
                    strP2 = zzdnmVar5.p("price");
                }
                parcel2.writeNoException();
                parcel2.writeString(strP2);
                return true;
            case 11:
                Bundle bundleD = ((zzdrt) this).f28377c.d();
                parcel2.writeNoException();
                zzbcd.d(parcel2, bundleD);
                return true;
            case 12:
                ((zzdrt) this).f28376b.o();
                parcel2.writeNoException();
                return true;
            case 13:
                com.google.android.gms.ads.internal.client.zzed zzedVarR = ((zzdrt) this).f28377c.r();
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzedVarR);
                return true;
            case 14:
                Bundle bundle = (Bundle) zzbcd.b(parcel, Bundle.CREATOR);
                zzbcd.f(parcel);
                zzdnh zzdnhVar = ((zzdrt) this).f28376b;
                synchronized (zzdnhVar) {
                    zzdnhVar.n.W(bundle);
                }
                parcel2.writeNoException();
                return true;
            case 15:
                Bundle bundle2 = (Bundle) zzbcd.b(parcel, Bundle.CREATOR);
                zzbcd.f(parcel);
                boolean zP = ((zzdrt) this).f28376b.p(bundle2);
                parcel2.writeNoException();
                parcel2.writeInt(zP ? 1 : 0);
                return true;
            case 16:
                Bundle bundle3 = (Bundle) zzbcd.b(parcel, Bundle.CREATOR);
                zzbcd.f(parcel);
                zzdnh zzdnhVar2 = ((zzdrt) this).f28376b;
                synchronized (zzdnhVar2) {
                    zzdnhVar2.n.d0(bundle3);
                }
                parcel2.writeNoException();
                return true;
            case 17:
                zzbjr zzbjrVarS = ((zzdrt) this).f28377c.s();
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbjrVarS);
                return true;
            case 18:
                zzdnm zzdnmVar6 = ((zzdrt) this).f28377c;
                synchronized (zzdnmVar6) {
                    iObjectWrapper = zzdnmVar6.q;
                }
                parcel2.writeNoException();
                zzbcd.e(parcel2, iObjectWrapper);
                return true;
            case 19:
                parcel2.writeNoException();
                parcel2.writeString(((zzdrt) this).f28375a);
                return true;
            default:
                return false;
        }
    }
}
