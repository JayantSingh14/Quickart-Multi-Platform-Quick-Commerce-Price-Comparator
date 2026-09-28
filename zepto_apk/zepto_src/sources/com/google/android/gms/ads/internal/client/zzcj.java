package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.ads.zzbcc;
import com.google.android.gms.internal.ads.zzbcd;
import com.google.android.gms.internal.ads.zzbed;
import com.google.android.gms.internal.ads.zzbsy;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzfpp;
import com.google.android.gms.internal.ads.zzfpu;
import com.google.android.gms.internal.ads.zzfqb;
import com.google.android.gms.internal.ads.zzfqd;
import com.google.android.gms.internal.ads.zzfqy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class zzcj extends zzbcc implements zzck {
    public zzcj() {
        super("com.google.android.gms.ads.internal.client.IAdPreloader");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        HashMap map;
        zzfqy zzfqyVar;
        zzce zzccVar = null;
        zzftVar = null;
        zzft zzftVar = null;
        zzch zzcfVar = null;
        switch (i2) {
            case 1:
                ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(zzft.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloadCallback");
                    zzccVar = iInterfaceQueryLocalInterface instanceof zzce ? (zzce) iInterfaceQueryLocalInterface : new zzcc(strongBinder, "com.google.android.gms.ads.internal.client.IAdPreloadCallback");
                }
                zzbcd.f(parcel);
                ((zzfqb) this).Xb(arrayListCreateTypedArrayList, zzccVar);
                parcel2.writeNoException();
                return true;
            case 2:
                String string = parcel.readString();
                zzbcd.f(parcel);
                boolean zYb = ((zzfqb) this).Yb(string);
                parcel2.writeNoException();
                parcel2.writeInt(zYb ? 1 : 0);
                return true;
            case 3:
                String string2 = parcel.readString();
                zzbcd.f(parcel);
                zzcaf zzcafVarZb = ((zzfqb) this).Zb(string2);
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzcafVarZb);
                return true;
            case 4:
                String string3 = parcel.readString();
                zzbcd.f(parcel);
                boolean zAc = ((zzfqb) this).ac(string3);
                parcel2.writeNoException();
                parcel2.writeInt(zAc ? 1 : 0);
                return true;
            case 5:
                String string4 = parcel.readString();
                zzbcd.f(parcel);
                zzbed zzbedVarBc = ((zzfqb) this).bc(string4);
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbedVarBc);
                return true;
            case 6:
                String string5 = parcel.readString();
                zzbcd.f(parcel);
                boolean zCc = ((zzfqb) this).cc(string5);
                parcel2.writeNoException();
                parcel2.writeInt(zCc ? 1 : 0);
                return true;
            case 7:
                String string6 = parcel.readString();
                zzbcd.f(parcel);
                zzbx zzbxVarDc = ((zzfqb) this).dc(string6);
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbxVarDc);
                return true;
            case 8:
                zzbsy.Xb(parcel.readStrongBinder());
                zzbcd.f(parcel);
                parcel2.writeNoException();
                return true;
            case 9:
                String string7 = parcel.readString();
                zzft zzftVar2 = (zzft) zzbcd.b(parcel, zzft.CREATOR);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloadCallbackV2");
                    zzcfVar = iInterfaceQueryLocalInterface2 instanceof zzch ? (zzch) iInterfaceQueryLocalInterface2 : new zzcf(strongBinder2, "com.google.android.gms.ads.internal.client.IAdPreloadCallbackV2");
                }
                zzbcd.f(parcel);
                boolean zEc = ((zzfqb) this).ec(string7, zzftVar2, zzcfVar);
                parcel2.writeNoException();
                parcel2.writeInt(zEc ? 1 : 0);
                return true;
            case 10:
                int i3 = parcel.readInt();
                String string8 = parcel.readString();
                zzbcd.f(parcel);
                boolean zFc = ((zzfqb) this).fc(i3, string8);
                parcel2.writeNoException();
                parcel2.writeInt(zFc ? 1 : 0);
                return true;
            case 11:
                String string9 = parcel.readString();
                zzbcd.f(parcel);
                zzbx zzbxVarGc = ((zzfqb) this).gc(string9);
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbxVarGc);
                return true;
            case 12:
                String string10 = parcel.readString();
                zzbcd.f(parcel);
                zzbed zzbedVarHc = ((zzfqb) this).hc(string10);
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbedVarHc);
                return true;
            case 13:
                String string11 = parcel.readString();
                zzbcd.f(parcel);
                zzcaf zzcafVarIc = ((zzfqb) this).ic(string11);
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzcafVarIc);
                return true;
            case 14:
                int i4 = parcel.readInt();
                String string12 = parcel.readString();
                zzbcd.f(parcel);
                zzfqb zzfqbVar = (zzfqb) this;
                AdFormat adFormatA = AdFormat.a(i4);
                if (adFormatA != null) {
                    zzfpu zzfpuVar = zzfqbVar.f31619b;
                    synchronized (zzfpuVar) {
                        HashMap map2 = zzfpuVar.f31590a;
                        if (map2.containsKey(adFormatA)) {
                            zzfqy zzfqyVar2 = (zzfqy) ((Map) map2.get(adFormatA)).get(string12);
                            zzfpuVar.f31592c.f("pgc", zzfpuVar.f31596g.currentTimeMillis(), string12, zzfqyVar2 == null ? null : zzfqyVar2.f31671e.f21239a, adFormatA, zzfqyVar2 == null ? -1 : zzfqyVar2.f31671e.f21242d, zzfqyVar2 != null ? zzfqyVar2.p() : -1, 1);
                            if (zzfqyVar2 != null) {
                                zzftVar = zzfqyVar2.f31671e;
                            }
                        }
                    }
                }
                parcel2.writeNoException();
                zzbcd.d(parcel2, zzftVar);
                return true;
            case 15:
                int i5 = parcel.readInt();
                zzbcd.f(parcel);
                zzfpu zzfpuVar2 = ((zzfqb) this).f31619b;
                synchronized (zzfpuVar2) {
                    try {
                        map = new HashMap();
                        AdFormat adFormatA2 = AdFormat.a(i5);
                        if (adFormatA2 != null) {
                            HashMap map3 = zzfpuVar2.f31590a;
                            if (map3.containsKey(adFormatA2)) {
                                for (zzfqy zzfqyVar3 : ((Map) map3.get(adFormatA2)).values()) {
                                    map.put(zzfqyVar3.f31678l, zzfqyVar3.f31671e);
                                }
                                zzfpuVar2.f31592c.f("pgcs", zzfpuVar2.f31596g.currentTimeMillis(), null, null, adFormatA2, -1, -1, map.size());
                            }
                        }
                    } finally {
                    }
                }
                Bundle bundle = new Bundle();
                for (Map.Entry entry : map.entrySet()) {
                    bundle.putByteArray((String) entry.getKey(), SafeParcelableSerializer.serializeToBytes((zzft) entry.getValue()));
                }
                parcel2.writeNoException();
                zzbcd.d(parcel2, bundle);
                return true;
            case 16:
                int i6 = parcel.readInt();
                String string13 = parcel.readString();
                zzbcd.f(parcel);
                zzfqb zzfqbVar2 = (zzfqb) this;
                AdFormat adFormatA3 = AdFormat.a(i6);
                if (adFormatA3 != null) {
                    zzfpu zzfpuVar3 = zzfqbVar2.f31619b;
                    synchronized (zzfpuVar3) {
                        HashMap map4 = zzfpuVar3.f31590a;
                        if (map4.containsKey(adFormatA3)) {
                            zzfqy zzfqyVar4 = (zzfqy) ((Map) map4.get(adFormatA3)).get(string13);
                            int iP = zzfqyVar4 != null ? zzfqyVar4.p() : 0;
                            zzfpuVar3.f31592c.f("pnav", zzfpuVar3.f31596g.currentTimeMillis(), string13, zzfqyVar4 != null ? zzfqyVar4.f31671e.f21239a : null, adFormatA3, zzfqyVar4 != null ? zzfqyVar4.f31671e.f21242d : -1, iP, 1);
                            i = iP;
                        }
                    }
                }
                parcel2.writeNoException();
                parcel2.writeInt(i);
                return true;
            case 17:
                int i7 = parcel.readInt();
                String string14 = parcel.readString();
                zzbcd.f(parcel);
                zzfqb zzfqbVar3 = (zzfqb) this;
                AdFormat adFormatA4 = AdFormat.a(i7);
                if (adFormatA4 != null) {
                    zzfpu zzfpuVar4 = zzfqbVar3.f31619b;
                    synchronized (zzfpuVar4) {
                        try {
                            HashMap map5 = zzfpuVar4.f31590a;
                            if (map5.containsKey(adFormatA4) && (zzfqyVar = (zzfqy) ((Map) map5.get(adFormatA4)).get(string14)) != null) {
                                ((Map) map5.get(adFormatA4)).remove(string14);
                                zzfqyVar.f31673g.set(false);
                                zzfqyVar.p.set(false);
                                zzfpp zzfppVar = zzfpuVar4.f31598i;
                                if (zzfppVar != null) {
                                    zzfppVar.e(string14, adFormatA4);
                                }
                                synchronized (zzfqyVar) {
                                    zzfqyVar.f31676j.clear();
                                }
                                zzfqd zzfqdVar = zzfpuVar4.f31592c;
                                long jCurrentTimeMillis = zzfpuVar4.f31596g.currentTimeMillis();
                                zzft zzftVar3 = zzfqyVar.f31671e;
                                zzfqdVar.f("pd", jCurrentTimeMillis, string14, zzftVar3.f21239a, adFormatA4, zzftVar3.f21242d, zzfqyVar.p(), 1);
                                i = 1;
                            }
                        } finally {
                        }
                    }
                }
                parcel2.writeNoException();
                parcel2.writeInt(i);
                return true;
            case 18:
                int i8 = parcel.readInt();
                zzbcd.f(parcel);
                ((zzfqb) this).i0(i8);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
