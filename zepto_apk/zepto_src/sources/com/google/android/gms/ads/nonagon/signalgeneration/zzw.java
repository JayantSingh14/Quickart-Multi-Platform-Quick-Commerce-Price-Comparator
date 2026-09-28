package com.google.android.gms.ads.nonagon.signalgeneration;

import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzdjd;
import com.google.android.gms.internal.ads.zzdwy;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzw implements zzdjd {

    /* renamed from: a, reason: collision with root package name */
    public final zzdwy f21952a;

    /* renamed from: b, reason: collision with root package name */
    public final zzv f21953b;

    /* renamed from: c, reason: collision with root package name */
    public final String f21954c;

    /* renamed from: d, reason: collision with root package name */
    public final int f21955d;

    public zzw(zzdwy zzdwyVar, zzv zzvVar, String str, int i2) {
        this.f21952a = zzdwyVar;
        this.f21953b = zzvVar;
        this.f21954c = str;
        this.f21955d = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzdjd
    public final void a(zzbj zzbjVar) {
        String strOptString;
        if (zzbjVar == null || this.f21955d == 2) {
            return;
        }
        boolean zIsEmpty = TextUtils.isEmpty(zzbjVar.f21854c);
        zzdwy zzdwyVar = this.f21952a;
        zzv zzvVar = this.f21953b;
        if (zIsEmpty) {
            zzvVar.a(this.f21954c, zzbjVar.f21853b, zzdwyVar);
            return;
        }
        try {
            strOptString = new JSONObject(zzbjVar.f21854c).optString("request_id");
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("RenderSignals.getRequestId", e2);
            strOptString = null;
        }
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        zzvVar.a(strOptString, zzbjVar.f21854c, zzdwyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdjd
    public final void q(String str) {
    }
}
