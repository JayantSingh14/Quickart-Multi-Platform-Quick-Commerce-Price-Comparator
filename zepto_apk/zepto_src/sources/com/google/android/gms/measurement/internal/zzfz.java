package com.google.android.gms.measurement.internal;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public abstract class zzfz extends com.google.android.gms.internal.measurement.zzbm implements zzga {
    public zzfz() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) throws ExecutionException, InterruptedException, PackageManager.NameNotFoundException, TimeoutException {
        List list;
        ArrayList arrayList = null;
        zzgd zzgbVar = null;
        zzgg zzgeVar = null;
        switch (i2) {
            case 1:
                zzbg zzbgVar = (zzbg) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzbg.CREATOR);
                zzr zzrVar = (zzr) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                ((zzjc) this).e4(zzbgVar, zzrVar);
                parcel2.writeNoException();
                return true;
            case 2:
                zzpk zzpkVar = (zzpk) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzpk.CREATOR);
                zzr zzrVar2 = (zzr) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                ((zzjc) this).h9(zzpkVar, zzrVar2);
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            case 22:
            case 23:
            case 28:
            default:
                return false;
            case 4:
                zzr zzrVar3 = (zzr) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                ((zzjc) this).ya(zzrVar3);
                parcel2.writeNoException();
                return true;
            case 5:
                zzbg zzbgVar2 = (zzbg) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzbg.CREATOR);
                String string = parcel.readString();
                parcel.readString();
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                zzjc zzjcVar = (zzjc) this;
                Preconditions.checkNotNull(zzbgVar2);
                Preconditions.checkNotEmpty(string);
                zzjcVar.w1(string, true);
                zzjcVar.V2(new zzir(zzjcVar, zzbgVar2, string));
                parcel2.writeNoException();
                return true;
            case 6:
                zzr zzrVar4 = (zzr) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                ((zzjc) this).h4(zzrVar4);
                parcel2.writeNoException();
                return true;
            case 7:
                zzr zzrVar5 = (zzr) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzr.CREATOR);
                boolean zA = com.google.android.gms.internal.measurement.zzbn.a(parcel);
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                zzjc zzjcVar2 = (zzjc) this;
                zzjcVar2.j1(zzrVar5);
                String str = zzrVar5.f39648a;
                Preconditions.checkNotNull(str);
                zzpf zzpfVar = zzjcVar2.f39177a;
                try {
                    List<zzpm> list2 = (List) ((FutureTask) zzpfVar.c().n(new zzic(zzjcVar2, str))).get();
                    ArrayList arrayList2 = new ArrayList(list2.size());
                    for (zzpm zzpmVar : list2) {
                        if (zA || !zzpo.D(zzpmVar.f39635c)) {
                            arrayList2.add(new zzpk(zzpmVar));
                        }
                    }
                    arrayList = arrayList2;
                } catch (InterruptedException e2) {
                    e = e2;
                    Object obj = e;
                    zzpfVar.b().f38958f.c("Failed to get user properties. appId", zzgt.o(str), obj);
                    parcel2.writeNoException();
                    parcel2.writeTypedList(arrayList);
                    return true;
                } catch (ExecutionException e3) {
                    e = e3;
                    Object obj2 = e;
                    zzpfVar.b().f38958f.c("Failed to get user properties. appId", zzgt.o(str), obj2);
                    parcel2.writeNoException();
                    parcel2.writeTypedList(arrayList);
                    return true;
                }
                parcel2.writeNoException();
                parcel2.writeTypedList(arrayList);
                return true;
            case 9:
                zzbg zzbgVar3 = (zzbg) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzbg.CREATOR);
                String string2 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                byte[] bArrV4 = ((zzjc) this).v4(zzbgVar3, string2);
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrV4);
                return true;
            case 10:
                long j2 = parcel.readLong();
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                ((zzjc) this).J7(j2, string3, string4, string5);
                parcel2.writeNoException();
                return true;
            case 11:
                zzr zzrVar6 = (zzr) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                String strJ6 = ((zzjc) this).j6(zzrVar6);
                parcel2.writeNoException();
                parcel2.writeString(strJ6);
                return true;
            case 12:
                zzah zzahVar = (zzah) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzah.CREATOR);
                zzr zzrVar7 = (zzr) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                ((zzjc) this).C1(zzahVar, zzrVar7);
                parcel2.writeNoException();
                return true;
            case 13:
                zzah zzahVar2 = (zzah) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzah.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                zzjc zzjcVar3 = (zzjc) this;
                Preconditions.checkNotNull(zzahVar2);
                Preconditions.checkNotNull(zzahVar2.f38678c);
                Preconditions.checkNotEmpty(zzahVar2.f38676a);
                zzjcVar3.w1(zzahVar2.f38676a, true);
                zzjcVar3.V2(new zzih(zzjcVar3, new zzah(zzahVar2)));
                parcel2.writeNoException();
                return true;
            case 14:
                String string6 = parcel.readString();
                String string7 = parcel.readString();
                boolean zA2 = com.google.android.gms.internal.measurement.zzbn.a(parcel);
                zzr zzrVar8 = (zzr) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                List listFb = ((zzjc) this).fb(string6, string7, zA2, zzrVar8);
                parcel2.writeNoException();
                parcel2.writeTypedList(listFb);
                return true;
            case 15:
                String string8 = parcel.readString();
                String string9 = parcel.readString();
                String string10 = parcel.readString();
                boolean zA3 = com.google.android.gms.internal.measurement.zzbn.a(parcel);
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                List listZ1 = ((zzjc) this).z1(string8, string9, string10, zA3);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZ1);
                return true;
            case 16:
                String string11 = parcel.readString();
                String string12 = parcel.readString();
                zzr zzrVar9 = (zzr) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                List listPb = ((zzjc) this).pb(string11, string12, zzrVar9);
                parcel2.writeNoException();
                parcel2.writeTypedList(listPb);
                return true;
            case 17:
                String string13 = parcel.readString();
                String string14 = parcel.readString();
                String string15 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                List listZ2 = ((zzjc) this).Z2(string13, string14, string15);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZ2);
                return true;
            case 18:
                zzr zzrVar10 = (zzr) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                ((zzjc) this).M7(zzrVar10);
                parcel2.writeNoException();
                return true;
            case 19:
                Bundle bundle = (Bundle) com.google.android.gms.internal.measurement.zzbn.b(parcel, Bundle.CREATOR);
                zzr zzrVar11 = (zzr) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                ((zzjc) this).aa(bundle, zzrVar11);
                parcel2.writeNoException();
                return true;
            case 20:
                zzr zzrVar12 = (zzr) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                ((zzjc) this).Nb(zzrVar12);
                parcel2.writeNoException();
                return true;
            case 21:
                zzr zzrVar13 = (zzr) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                zzao zzaoVarV9 = ((zzjc) this).V9(zzrVar13);
                parcel2.writeNoException();
                if (zzaoVarV9 == null) {
                    parcel2.writeInt(0);
                    return true;
                }
                parcel2.writeInt(1);
                zzaoVarV9.writeToParcel(parcel2, 1);
                return true;
            case 24:
                zzr zzrVar14 = (zzr) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzr.CREATOR);
                Bundle bundle2 = (Bundle) com.google.android.gms.internal.measurement.zzbn.b(parcel, Bundle.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                zzjc zzjcVar4 = (zzjc) this;
                zzjcVar4.j1(zzrVar14);
                String str2 = zzrVar14.f39648a;
                Preconditions.checkNotNull(str2);
                zzpf zzpfVar2 = zzjcVar4.f39177a;
                if (zzpfVar2.d0().q(null, zzfx.Y0)) {
                    try {
                        list = (List) ((FutureTask) zzpfVar2.c().o(new zziu(zzjcVar4, zzrVar14, bundle2))).get(10000L, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException | ExecutionException | TimeoutException e4) {
                        zzpfVar2.b().f38958f.c("Failed to get trigger URIs. appId", zzgt.o(str2), e4);
                        list = Collections.EMPTY_LIST;
                    }
                } else {
                    try {
                        list = (List) ((FutureTask) zzpfVar2.c().n(new zziv(zzjcVar4, zzrVar14, bundle2))).get();
                    } catch (InterruptedException | ExecutionException e5) {
                        zzpfVar2.b().f38958f.c("Failed to get trigger URIs. appId", zzgt.o(str2), e5);
                        list = Collections.EMPTY_LIST;
                    }
                }
                parcel2.writeNoException();
                parcel2.writeTypedList(list);
                return true;
            case 25:
                zzr zzrVar15 = (zzr) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                ((zzjc) this).p3(zzrVar15);
                parcel2.writeNoException();
                return true;
            case 26:
                zzr zzrVar16 = (zzr) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                ((zzjc) this).m4(zzrVar16);
                parcel2.writeNoException();
                return true;
            case 27:
                zzr zzrVar17 = (zzr) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                ((zzjc) this).Wa(zzrVar17);
                parcel2.writeNoException();
                return true;
            case 29:
                zzr zzrVar18 = (zzr) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzr.CREATOR);
                zzon zzonVar = (zzon) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzon.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
                    zzgeVar = iInterfaceQueryLocalInterface instanceof zzgg ? (zzgg) iInterfaceQueryLocalInterface : new zzge(strongBinder);
                }
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                ((zzjc) this).D5(zzrVar18, zzonVar, zzgeVar);
                parcel2.writeNoException();
                return true;
            case 30:
                zzr zzrVar19 = (zzr) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzr.CREATOR);
                zzaf zzafVar = (zzaf) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzaf.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                ((zzjc) this).y9(zzrVar19, zzafVar);
                parcel2.writeNoException();
                return true;
            case 31:
                zzr zzrVar20 = (zzr) com.google.android.gms.internal.measurement.zzbn.b(parcel, zzr.CREATOR);
                Bundle bundle3 = (Bundle) com.google.android.gms.internal.measurement.zzbn.b(parcel, Bundle.CREATOR);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
                    zzgbVar = iInterfaceQueryLocalInterface2 instanceof zzgd ? (zzgd) iInterfaceQueryLocalInterface2 : new zzgb(strongBinder2);
                }
                com.google.android.gms.internal.measurement.zzbn.f(parcel);
                ((zzjc) this).B8(zzrVar20, bundle3, zzgbVar);
                parcel2.writeNoException();
                return true;
        }
    }
}
