package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class zzblr extends zzbcc implements zzbls {
    public zzblr() {
        super("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        List list;
        zzbjy zzbjyVar;
        double d2;
        String strP;
        String strP2;
        IObjectWrapper iObjectWrapper;
        List list2;
        com.google.android.gms.ads.internal.client.zzez zzezVar;
        zzbjv zzbjvVar;
        boolean zZzh;
        zzcze zzczeVar;
        zzcze zzczeVar2;
        int i3 = 0;
        zzblp zzblnVar = null;
        com.google.android.gms.ads.internal.client.zzdf zzddVar = null;
        switch (i2) {
            case 2:
                String strA = ((zzdsa) this).f28398c.a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            case 3:
                zzdnm zzdnmVar = ((zzdsa) this).f28398c;
                synchronized (zzdnmVar) {
                    list = zzdnmVar.f28030e;
                }
                parcel2.writeNoException();
                parcel2.writeList(list);
                return true;
            case 4:
                String strC = ((zzdsa) this).f28398c.c();
                parcel2.writeNoException();
                parcel2.writeString(strC);
                return true;
            case 5:
                zzdnm zzdnmVar2 = ((zzdsa) this).f28398c;
                synchronized (zzdnmVar2) {
                    zzbjyVar = zzdnmVar2.s;
                }
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbjyVar);
                return true;
            case 6:
                String strE = ((zzdsa) this).f28398c.e();
                parcel2.writeNoException();
                parcel2.writeString(strE);
                return true;
            case 7:
                String strF = ((zzdsa) this).f28398c.f();
                parcel2.writeNoException();
                parcel2.writeString(strF);
                return true;
            case 8:
                zzdnm zzdnmVar3 = ((zzdsa) this).f28398c;
                synchronized (zzdnmVar3) {
                    d2 = zzdnmVar3.r;
                }
                parcel2.writeNoException();
                parcel2.writeDouble(d2);
                return true;
            case 9:
                zzdnm zzdnmVar4 = ((zzdsa) this).f28398c;
                synchronized (zzdnmVar4) {
                    strP = zzdnmVar4.p("store");
                }
                parcel2.writeNoException();
                parcel2.writeString(strP);
                return true;
            case 10:
                zzdnm zzdnmVar5 = ((zzdsa) this).f28398c;
                synchronized (zzdnmVar5) {
                    strP2 = zzdnmVar5.p("price");
                }
                parcel2.writeNoException();
                parcel2.writeString(strP2);
                return true;
            case 11:
                com.google.android.gms.ads.internal.client.zzed zzedVarR = ((zzdsa) this).f28398c.r();
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzedVarR);
                return true;
            case 12:
                String str = ((zzdsa) this).f28396a;
                parcel2.writeNoException();
                parcel2.writeString(str);
                return true;
            case 13:
                ((zzdsa) this).f28397b.o();
                parcel2.writeNoException();
                return true;
            case 14:
                zzbjr zzbjrVarS = ((zzdsa) this).f28398c.s();
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbjrVarS);
                return true;
            case 15:
                Bundle bundle = (Bundle) zzbcd.b(parcel, Bundle.CREATOR);
                zzbcd.f(parcel);
                zzdnh zzdnhVar = ((zzdsa) this).f28397b;
                synchronized (zzdnhVar) {
                    zzdnhVar.n.W(bundle);
                }
                parcel2.writeNoException();
                return true;
            case 16:
                Bundle bundle2 = (Bundle) zzbcd.b(parcel, Bundle.CREATOR);
                zzbcd.f(parcel);
                boolean zP = ((zzdsa) this).f28397b.p(bundle2);
                parcel2.writeNoException();
                parcel2.writeInt(zP ? 1 : 0);
                return true;
            case 17:
                Bundle bundle3 = (Bundle) zzbcd.b(parcel, Bundle.CREATOR);
                zzbcd.f(parcel);
                zzdnh zzdnhVar2 = ((zzdsa) this).f28397b;
                synchronized (zzdnhVar2) {
                    zzdnhVar2.n.d0(bundle3);
                }
                parcel2.writeNoException();
                return true;
            case 18:
                IObjectWrapper iObjectWrapperC = ((zzdsa) this).c();
                parcel2.writeNoException();
                zzbcd.e(parcel2, iObjectWrapperC);
                return true;
            case 19:
                zzdnm zzdnmVar6 = ((zzdsa) this).f28398c;
                synchronized (zzdnmVar6) {
                    iObjectWrapper = zzdnmVar6.q;
                }
                parcel2.writeNoException();
                zzbcd.e(parcel2, iObjectWrapper);
                return true;
            case 20:
                Bundle bundleD = ((zzdsa) this).f28398c.d();
                parcel2.writeNoException();
                zzbcd.d(parcel2, bundleD);
                return true;
            case 21:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
                    zzblnVar = iInterfaceQueryLocalInterface instanceof zzblp ? (zzblp) iInterfaceQueryLocalInterface : new zzbln(strongBinder, "com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
                }
                zzbcd.f(parcel);
                ((zzdsa) this).Zb(zzblnVar);
                parcel2.writeNoException();
                return true;
            case 22:
                zzdnh zzdnhVar3 = ((zzdsa) this).f28397b;
                synchronized (zzdnhVar3) {
                    zzdnhVar3.n.B();
                }
                parcel2.writeNoException();
                return true;
            case 23:
                List listI = ((zzdsa) this).I();
                parcel2.writeNoException();
                parcel2.writeList(listI);
                return true;
            case 24:
                zzdnm zzdnmVar7 = ((zzdsa) this).f28398c;
                synchronized (zzdnmVar7) {
                    list2 = zzdnmVar7.f28031f;
                }
                if (!list2.isEmpty()) {
                    synchronized (zzdnmVar7) {
                        zzezVar = zzdnmVar7.f28032g;
                    }
                    if (zzezVar != null) {
                        i3 = 1;
                    }
                }
                parcel2.writeNoException();
                ClassLoader classLoader = zzbcd.f24690a;
                parcel2.writeInt(i3);
                return true;
            case 25:
                com.google.android.gms.ads.internal.client.zzdj zzdjVarXb = com.google.android.gms.ads.internal.client.zzdi.Xb(parcel.readStrongBinder());
                zzbcd.f(parcel);
                ((zzdsa) this).Xb(zzdjVarXb);
                parcel2.writeNoException();
                return true;
            case 26:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IMuteThisAdListener");
                    zzddVar = iInterfaceQueryLocalInterface2 instanceof com.google.android.gms.ads.internal.client.zzdf ? (com.google.android.gms.ads.internal.client.zzdf) iInterfaceQueryLocalInterface2 : new com.google.android.gms.ads.internal.client.zzdd(strongBinder2, "com.google.android.gms.ads.internal.client.IMuteThisAdListener");
                }
                zzbcd.f(parcel);
                ((zzdsa) this).Yb(zzddVar);
                parcel2.writeNoException();
                return true;
            case 27:
                zzdnh zzdnhVar4 = ((zzdsa) this).f28397b;
                synchronized (zzdnhVar4) {
                    zzdnhVar4.n.zzg();
                }
                parcel2.writeNoException();
                return true;
            case 28:
                final zzdnh zzdnhVar5 = ((zzdsa) this).f28397b;
                synchronized (zzdnhVar5) {
                    zzbcc zzbccVar = zzdnhVar5.w;
                    if (zzbccVar == null) {
                        int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.a("Ad should be associated with an ad view before calling recordCustomClickGesture()");
                    } else {
                        final boolean z = zzbccVar instanceof zzdof;
                        zzdnhVar5.f28006l.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdnc
                            /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.internal.ads.zzbcc, com.google.android.gms.internal.ads.zzdpj] */
                            /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.internal.ads.zzbcc, com.google.android.gms.internal.ads.zzdpj] */
                            /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.gms.internal.ads.zzbcc, com.google.android.gms.internal.ads.zzdpj] */
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzdnh zzdnhVar6 = zzdnhVar5;
                                ?? r1 = zzdnhVar6.w;
                                if (r1 == 0) {
                                    int i5 = com.google.android.gms.ads.internal.util.zze.f21576b;
                                    com.google.android.gms.ads.internal.util.client.zzo.a("Ad should be associated with an ad view before calling recordCustomClickGesture()");
                                    return;
                                }
                                View viewZ8 = r1.Z8();
                                Map mapZzj = zzdnhVar6.w.zzj();
                                Map mapZzk = zzdnhVar6.w.zzk();
                                ImageView.ScaleType scaleTypeL = zzdnhVar6.l();
                                zzdnhVar6.n.c0(null, viewZ8, mapZzj, mapZzk, z, scaleTypeL, 0);
                            }
                        });
                    }
                }
                parcel2.writeNoException();
                return true;
            case 29:
                zzdnj zzdnjVar = ((zzdsa) this).f28397b.F;
                synchronized (zzdnjVar) {
                    zzbjvVar = zzdnjVar.f28021a;
                }
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbjvVar);
                return true;
            case 30:
                zzdnh zzdnhVar6 = ((zzdsa) this).f28397b;
                synchronized (zzdnhVar6) {
                    zZzh = zzdnhVar6.n.zzh();
                }
                parcel2.writeNoException();
                ClassLoader classLoader2 = zzbcd.f24690a;
                parcel2.writeInt(zZzh ? 1 : 0);
                return true;
            case 31:
                com.google.android.gms.ads.internal.client.zzea zzeaVarM = ((zzdsa) this).m();
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzeaVarM);
                return true;
            case 32:
                com.google.android.gms.ads.internal.client.zzdt zzdtVarXb = com.google.android.gms.ads.internal.client.zzds.Xb(parcel.readStrongBinder());
                zzbcd.f(parcel);
                zzdsa zzdsaVar = (zzdsa) this;
                try {
                    if (!zzdtVarXb.zzf()) {
                        zzdsaVar.f28399d.b();
                    }
                } catch (RemoteException e2) {
                    int i5 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.b("Error in making CSI ping for reporting paid event callback", e2);
                }
                zzdnh zzdnhVar7 = zzdsaVar.f28397b;
                synchronized (zzdnhVar7) {
                    zzdnhVar7.G.f30115a.set(zzdtVarXb);
                }
                parcel2.writeNoException();
                return true;
            case 33:
                Bundle bundle4 = (Bundle) zzbcd.b(parcel, Bundle.CREATOR);
                zzbcd.f(parcel);
                ((zzdsa) this).H4(bundle4);
                parcel2.writeNoException();
                return true;
            case 34:
                zzdnh zzdnhVar8 = ((zzdsa) this).f28397b;
                long j2 = (zzdnhVar8 == null || (zzczeVar = zzdnhVar8.f27236j) == null) ? 0L : zzczeVar.f27458a.get();
                parcel2.writeNoException();
                parcel2.writeLong(j2);
                return true;
            case 35:
                long j3 = parcel.readLong();
                zzbcd.f(parcel);
                zzdnh zzdnhVar9 = ((zzdsa) this).f28397b;
                if (zzdnhVar9 != null && (zzczeVar2 = zzdnhVar9.f27236j) != null) {
                    zzczeVar2.a(j3);
                }
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
