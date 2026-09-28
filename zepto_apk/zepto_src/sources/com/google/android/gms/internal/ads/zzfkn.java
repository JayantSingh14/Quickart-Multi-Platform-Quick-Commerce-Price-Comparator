package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcelable;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzfkn {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f31325a = new HashMap();

    public final zzfkm a(zzfkd zzfkdVar, Context context, zzfjv zzfjvVar, zzfks zzfksVar) {
        zzfkg zzfkgVar;
        HashMap map = this.f31325a;
        zzfkm zzfkmVar = (zzfkm) map.get(zzfkdVar);
        if (zzfkmVar != null) {
            return zzfkmVar;
        }
        if (zzfkdVar == zzfkd.f31303a) {
            zzbgb zzbgbVar = zzbgk.Y6;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            int iIntValue = ((Integer) zzbdVar.f21153c.a(zzbgbVar)).intValue();
            zzbgb zzbgbVar2 = zzbgk.e7;
            zzbgi zzbgiVar = zzbdVar.f21153c;
            int iIntValue2 = ((Integer) zzbgiVar.a(zzbgbVar2)).intValue();
            int iIntValue3 = ((Integer) zzbgiVar.a(zzbgk.g7)).intValue();
            String str = (String) zzbgiVar.a(zzbgk.i7);
            String str2 = (String) zzbgiVar.a(zzbgk.a7);
            zzfkgVar = new zzfkg(context, zzfkdVar, iIntValue, iIntValue2, iIntValue3, str, str2);
        } else if (zzfkdVar == zzfkd.f31304b) {
            zzbgb zzbgbVar3 = zzbgk.Z6;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar2 = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            int iIntValue4 = ((Integer) zzbdVar2.f21153c.a(zzbgbVar3)).intValue();
            zzbgb zzbgbVar4 = zzbgk.f7;
            zzbgi zzbgiVar2 = zzbdVar2.f21153c;
            int iIntValue5 = ((Integer) zzbgiVar2.a(zzbgbVar4)).intValue();
            int iIntValue6 = ((Integer) zzbgiVar2.a(zzbgk.h7)).intValue();
            String str3 = (String) zzbgiVar2.a(zzbgk.j7);
            String str4 = (String) zzbgiVar2.a(zzbgk.b7);
            zzfkgVar = new zzfkg(context, zzfkdVar, iIntValue4, iIntValue5, iIntValue6, str3, str4);
        } else if (zzfkdVar == zzfkd.f31305c) {
            zzbgb zzbgbVar5 = zzbgk.m7;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar3 = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            int iIntValue7 = ((Integer) zzbdVar3.f21153c.a(zzbgbVar5)).intValue();
            zzbgb zzbgbVar6 = zzbgk.o7;
            zzbgi zzbgiVar3 = zzbdVar3.f21153c;
            int iIntValue8 = ((Integer) zzbgiVar3.a(zzbgbVar6)).intValue();
            int iIntValue9 = ((Integer) zzbgiVar3.a(zzbgk.p7)).intValue();
            String str5 = (String) zzbgiVar3.a(zzbgk.k7);
            String str6 = (String) zzbgiVar3.a(zzbgk.l7);
            zzfkgVar = new zzfkg(context, zzfkdVar, iIntValue7, iIntValue8, iIntValue9, str5, str6);
        } else {
            Parcelable.Creator<zzfkg> creator = zzfkg.CREATOR;
            zzfkgVar = null;
        }
        zzfka zzfkaVar = new zzfka(zzfkgVar);
        zzfkm zzfkmVar2 = new zzfkm(zzfkaVar, new zzfkv(zzfkaVar, zzfjvVar, zzfksVar));
        map.put(zzfkdVar, zzfkmVar2);
        return zzfkmVar2;
    }
}
