package com.google.android.gms.internal.ads;

import android.content.Context;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzels implements zzelm {

    /* renamed from: a, reason: collision with root package name */
    public final zzdlv f29664a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgyw f29665b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdqf f29666c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfjj f29667d;

    /* renamed from: e, reason: collision with root package name */
    public final zzdsv f29668e;

    /* renamed from: f, reason: collision with root package name */
    public final zzdwy f29669f;

    /* renamed from: g, reason: collision with root package name */
    public final VersionInfoParcel f29670g;

    /* renamed from: h, reason: collision with root package name */
    public final Context f29671h;

    public zzels(zzdlv zzdlvVar, zzgyw zzgywVar, zzdqf zzdqfVar, zzfjj zzfjjVar, zzdsv zzdsvVar, zzdwy zzdwyVar, VersionInfoParcel versionInfoParcel, Context context, zzcbg zzcbgVar) {
        this.f29670g = versionInfoParcel;
        this.f29671h = context;
        this.f29664a = zzdlvVar;
        this.f29665b = zzgywVar;
        this.f29666c = zzdqfVar;
        this.f29667d = zzfjjVar;
        this.f29668e = zzdsvVar;
        this.f29669f = zzdwyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzejg
    public final ListenableFuture a(final zzfic zzficVar, final zzfhr zzfhrVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.B2)).booleanValue()) {
            this.f29669f.f28716e.putLong("rendering-native-ads-native-js-webview-start", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
        }
        ListenableFuture listenableFutureB = this.f29667d.b();
        zzgxu zzgxuVar = new zzgxu() { // from class: com.google.android.gms.internal.ads.zzelr
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final ListenableFuture zza(Object obj) throws JSONException {
                final zzdsp zzdspVar = (zzdsp) obj;
                final zzels zzelsVar = this.f29662a;
                zzelsVar.getClass();
                zzbgb zzbgbVar = zzbgk.B2;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                    zzelsVar.f29669f.f28716e.putLong("rendering-native-ads-preprocess-start", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isNonagon", true);
                if (((Boolean) zzbdVar.f21153c.a(zzbgk.H9)).booleanValue() && PlatformVersion.isAtLeastR()) {
                    jSONObject.put("skipDeepLinkValidation", true);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("response", zzfhrVar.s.f31181c);
                jSONObject2.put("sdk_params", jSONObject);
                return zzgym.h(zzdspVar.a("google.afma.nativeAds.preProcessJson", jSONObject2), new zzgxu() { // from class: com.google.android.gms.internal.ads.zzelo
                    @Override // com.google.android.gms.internal.ads.zzgxu
                    public final ListenableFuture zza(Object obj2) throws zzbru {
                        JSONObject jSONObject3 = (JSONObject) obj2;
                        zzels zzelsVar2 = zzelsVar;
                        zzelsVar2.getClass();
                        ListenableFuture listenableFutureA = zzgym.a(zzdspVar);
                        zzfjj zzfjjVar = zzelsVar2.f29667d;
                        synchronized (zzfjjVar) {
                            zzfjjVar.f31271a.addFirst(listenableFutureA);
                        }
                        if (!jSONObject3.optBoolean(APayConstants.SUCCESS)) {
                            throw new zzbru("process json failed");
                        }
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.B2)).booleanValue()) {
                            zzelsVar2.f29669f.f28716e.putLong("rendering-native-ads-preprocess-end", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
                        }
                        return zzgym.a(jSONObject3.getJSONObject("json").getJSONArray("ads"));
                    }
                }, zzelsVar.f29665b);
            }
        };
        zzgyw zzgywVar = this.f29665b;
        return zzgym.h(zzgym.h(listenableFutureB, zzgxuVar, zzgywVar), new zzgxu() { // from class: com.google.android.gms.internal.ads.zzeln
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final ListenableFuture zza(Object obj) {
                JSONArray jSONArray = (JSONArray) obj;
                zzels zzelsVar = this.f29648a;
                zzelsVar.getClass();
                if (jSONArray.length() == 0) {
                    return zzgym.b(new zzebr(3));
                }
                zzfic zzficVar2 = zzficVar;
                zzfik zzfikVar = zzficVar2.f31193a.f31185a;
                zzfhr zzfhrVar2 = zzfhrVar;
                int i2 = zzfikVar.f31224l;
                if (i2 <= 1) {
                    return zzgym.i(zzelsVar.c(zzficVar2, zzfhrVar2, jSONArray.getJSONObject(0)), zzelp.f29653a, zzelsVar.f29665b);
                }
                int length = jSONArray.length();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.D2)).booleanValue()) {
                    zzelsVar.f29669f.b("nsl", String.valueOf(length));
                }
                zzelsVar.f29667d.a(Math.min(length, i2));
                ArrayList arrayList = new ArrayList(i2);
                for (int i3 = 0; i3 < i2; i3++) {
                    if (i3 < length) {
                        arrayList.add(zzelsVar.c(zzficVar2, zzfhrVar2, jSONArray.getJSONObject(i3)));
                    } else {
                        arrayList.add(zzgym.b(new zzebr(3)));
                    }
                }
                return zzgym.a(arrayList);
            }
        }, zzgywVar);
    }

    @Override // com.google.android.gms.internal.ads.zzejg
    public final boolean b(zzfic zzficVar, zzfhr zzfhrVar) {
        zzfhw zzfhwVar = zzfhrVar.s;
        return (zzfhwVar == null || zzfhwVar.f31181c == null) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0371 A[EDGE_INSN: B:176:0x0371->B:109:0x0371 BREAK  A[LOOP:0: B:111:0x0375->B:124:0x03d9], PHI: r17
      0x0371: PHI (r17v5 com.google.android.gms.internal.ads.zzdwy) = 
      (r17v4 com.google.android.gms.internal.ads.zzdwy)
      (r17v4 com.google.android.gms.internal.ads.zzdwy)
      (r17v4 com.google.android.gms.internal.ads.zzdwy)
      (r17v4 com.google.android.gms.internal.ads.zzdwy)
      (r17v13 com.google.android.gms.internal.ads.zzdwy)
      (r17v13 com.google.android.gms.internal.ads.zzdwy)
      (r17v13 com.google.android.gms.internal.ads.zzdwy)
     binds: [B:102:0x0357, B:104:0x035d, B:106:0x0369, B:108:0x036f, B:176:0x0371, B:173:0x0371, B:118:0x0399] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0371 A[PHI: r17
      0x0371: PHI (r17v5 com.google.android.gms.internal.ads.zzdwy) = 
      (r17v4 com.google.android.gms.internal.ads.zzdwy)
      (r17v4 com.google.android.gms.internal.ads.zzdwy)
      (r17v4 com.google.android.gms.internal.ads.zzdwy)
      (r17v4 com.google.android.gms.internal.ads.zzdwy)
      (r17v13 com.google.android.gms.internal.ads.zzdwy)
      (r17v13 com.google.android.gms.internal.ads.zzdwy)
      (r17v13 com.google.android.gms.internal.ads.zzdwy)
     binds: [B:102:0x0357, B:104:0x035d, B:106:0x0369, B:108:0x036f, B:176:0x0371, B:173:0x0371, B:118:0x0399] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x056a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x027c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.common.util.concurrent.ListenableFuture c(final com.google.android.gms.internal.ads.zzfic r33, final com.google.android.gms.internal.ads.zzfhr r34, final org.json.JSONObject r35) {
        /*
            Method dump skipped, instructions count: 1464
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzels.c(com.google.android.gms.internal.ads.zzfic, com.google.android.gms.internal.ads.zzfhr, org.json.JSONObject):com.google.common.util.concurrent.ListenableFuture");
    }
}
