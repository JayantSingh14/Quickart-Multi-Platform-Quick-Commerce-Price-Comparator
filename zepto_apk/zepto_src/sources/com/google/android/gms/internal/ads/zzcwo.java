package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzcwo {

    /* renamed from: a, reason: collision with root package name */
    public final zzedg f27288a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfik f27289b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfmu f27290c;

    /* renamed from: d, reason: collision with root package name */
    public final zzcpo f27291d;

    /* renamed from: e, reason: collision with root package name */
    public final zzemy f27292e;

    /* renamed from: f, reason: collision with root package name */
    public final zzdfz f27293f;

    /* renamed from: g, reason: collision with root package name */
    public zzfic f27294g;

    /* renamed from: h, reason: collision with root package name */
    public final zzeer f27295h;

    /* renamed from: i, reason: collision with root package name */
    public final zzczo f27296i;

    /* renamed from: j, reason: collision with root package name */
    public final zzgyw f27297j;

    /* renamed from: k, reason: collision with root package name */
    public final zzeec f27298k;

    /* renamed from: l, reason: collision with root package name */
    public final zzejl f27299l;

    public zzcwo(zzedg zzedgVar, zzfik zzfikVar, zzfmu zzfmuVar, zzcpo zzcpoVar, zzemy zzemyVar, zzdfz zzdfzVar, zzfic zzficVar, zzeer zzeerVar, zzczo zzczoVar, zzgyw zzgywVar, zzeec zzeecVar, zzejl zzejlVar) {
        this.f27288a = zzedgVar;
        this.f27289b = zzfikVar;
        this.f27290c = zzfmuVar;
        this.f27291d = zzcpoVar;
        this.f27292e = zzemyVar;
        this.f27293f = zzdfzVar;
        this.f27294g = zzficVar;
        this.f27295h = zzeerVar;
        this.f27296i = zzczoVar;
        this.f27297j = zzgywVar;
        this.f27298k = zzeecVar;
        this.f27299l = zzejlVar;
    }

    public final zzfmb a(ListenableFuture listenableFuture) {
        if (this.f27294g != null) {
            zzfmu zzfmuVar = this.f27290c;
            zzfmo zzfmoVar = zzfmo.SERVER_TRANSACTION;
            Objects.requireNonNull(zzfmuVar);
            return new zzfml(zzfmuVar, zzfmoVar, null, zzfmm.f31404d, Collections.EMPTY_LIST, zzgym.a(this.f27294g)).d();
        }
        zzber zzberVar = com.google.android.gms.ads.internal.zzt.C.f21686j;
        zzberVar.getClass();
        zzbgb zzbgbVar = zzbgk.V4;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            synchronized (zzberVar.f24848c) {
                try {
                    zzberVar.d();
                    ScheduledFuture scheduledFuture = zzberVar.f24846a;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    ScheduledExecutorService scheduledExecutorService = zzcdo.f25985d;
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) scheduledExecutorService;
                    zzberVar.f24846a = scheduledThreadPoolExecutor.schedule(zzberVar.f24847b, ((Long) zzbdVar.f21153c.a(zzbgk.W4)).longValue(), TimeUnit.MILLISECONDS);
                } finally {
                }
            }
        }
        zzfml zzfmlVarA = this.f27290c.a(listenableFuture, zzfmo.SERVER_TRANSACTION);
        final zzeec zzeecVar = this.f27298k;
        return zzfmlVarA.b(new zzgxu() { // from class: com.google.android.gms.internal.ads.zzcwn
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return zzeecVar.a((zzbza) obj);
            }
        }).d();
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0274 A[Catch: all -> 0x00f3, TRY_LEAVE, TryCatch #3 {all -> 0x00f3, blocks: (B:28:0x0097, B:30:0x00b1, B:32:0x00b9, B:34:0x00c6, B:36:0x00de, B:40:0x010a, B:43:0x0116, B:45:0x011e, B:47:0x0125, B:51:0x012e, B:62:0x0168, B:54:0x0142, B:61:0x0153, B:64:0x016d, B:39:0x00f6, B:65:0x0181, B:72:0x01a0, B:75:0x01a8, B:79:0x01cb, B:81:0x01e1, B:85:0x0203, B:87:0x021a, B:90:0x022e, B:95:0x0241, B:96:0x0242, B:97:0x024f, B:101:0x0254, B:102:0x0255, B:107:0x026b, B:119:0x027b, B:109:0x026d, B:113:0x0271, B:115:0x0273, B:116:0x0274, B:118:0x027a, B:126:0x028f, B:86:0x020d, B:82:0x01f4, B:78:0x01b7, B:69:0x018f, B:70:0x0194, B:91:0x022f, B:93:0x0239, B:117:0x0275, B:103:0x0256, B:105:0x0260), top: B:160:0x0097, inners: #2, #7, #9, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0275 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0203 A[Catch: all -> 0x00f3, TryCatch #3 {all -> 0x00f3, blocks: (B:28:0x0097, B:30:0x00b1, B:32:0x00b9, B:34:0x00c6, B:36:0x00de, B:40:0x010a, B:43:0x0116, B:45:0x011e, B:47:0x0125, B:51:0x012e, B:62:0x0168, B:54:0x0142, B:61:0x0153, B:64:0x016d, B:39:0x00f6, B:65:0x0181, B:72:0x01a0, B:75:0x01a8, B:79:0x01cb, B:81:0x01e1, B:85:0x0203, B:87:0x021a, B:90:0x022e, B:95:0x0241, B:96:0x0242, B:97:0x024f, B:101:0x0254, B:102:0x0255, B:107:0x026b, B:119:0x027b, B:109:0x026d, B:113:0x0271, B:115:0x0273, B:116:0x0274, B:118:0x027a, B:126:0x028f, B:86:0x020d, B:82:0x01f4, B:78:0x01b7, B:69:0x018f, B:70:0x0194, B:91:0x022f, B:93:0x0239, B:117:0x0275, B:103:0x0256, B:105:0x0260), top: B:160:0x0097, inners: #2, #7, #9, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x020d A[Catch: all -> 0x00f3, TryCatch #3 {all -> 0x00f3, blocks: (B:28:0x0097, B:30:0x00b1, B:32:0x00b9, B:34:0x00c6, B:36:0x00de, B:40:0x010a, B:43:0x0116, B:45:0x011e, B:47:0x0125, B:51:0x012e, B:62:0x0168, B:54:0x0142, B:61:0x0153, B:64:0x016d, B:39:0x00f6, B:65:0x0181, B:72:0x01a0, B:75:0x01a8, B:79:0x01cb, B:81:0x01e1, B:85:0x0203, B:87:0x021a, B:90:0x022e, B:95:0x0241, B:96:0x0242, B:97:0x024f, B:101:0x0254, B:102:0x0255, B:107:0x026b, B:119:0x027b, B:109:0x026d, B:113:0x0271, B:115:0x0273, B:116:0x0274, B:118:0x027a, B:126:0x028f, B:86:0x020d, B:82:0x01f4, B:78:0x01b7, B:69:0x018f, B:70:0x0194, B:91:0x022f, B:93:0x0239, B:117:0x0275, B:103:0x0256, B:105:0x0260), top: B:160:0x0097, inners: #2, #7, #9, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x022c A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzfmb b() {
        /*
            Method dump skipped, instructions count: 800
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcwo.b():com.google.android.gms.internal.ads.zzfmb");
    }

    public final zzfmb c(ListenableFuture listenableFuture) {
        zzfml zzfmlVarB = this.f27290c.a(listenableFuture, zzfmo.RENDERER).a(new zzflu() { // from class: com.google.android.gms.internal.ads.zzcwm
            @Override // com.google.android.gms.internal.ads.zzflu
            public final Object zza(Object obj) {
                zzfic zzficVar = (zzfic) obj;
                zzcpo zzcpoVar = this.f27286a.f27291d;
                Iterator it = zzficVar.f31194b.f31191c.iterator();
                while (it.hasNext()) {
                    zzfia zzfiaVar = (zzfia) it.next();
                    String str = zzfiaVar.f31187a;
                    Map map = zzcpoVar.f26867a;
                    boolean zContainsKey = map.containsKey(str);
                    JSONObject jSONObject = zzfiaVar.f31188b;
                    if (!zContainsKey || jSONObject == null) {
                        Map map2 = zzcpoVar.f26868b;
                        if (map2.containsKey(str) && jSONObject != null) {
                            zzcpq zzcpqVar = (zzcpq) map2.get(str);
                            HashMap map3 = new HashMap();
                            Iterator<String> itKeys = jSONObject.keys();
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                String strOptString = jSONObject.optString(next);
                                if (strOptString != null) {
                                    map3.put(next, strOptString);
                                }
                            }
                            zzcpqVar.a(map3);
                        }
                    } else {
                        ((zzcpr) map.get(str)).c(jSONObject);
                    }
                }
                return zzficVar;
            }
        }).b(this.f27292e);
        zzbgb zzbgbVar = zzbgk.n6;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (!((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            long jIntValue = ((Integer) zzbdVar.f21153c.a(zzbgk.o6)).intValue();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            zzfmlVarB = zzfmlVarB.c(jIntValue);
        }
        return zzfmlVarB.d();
    }
}
