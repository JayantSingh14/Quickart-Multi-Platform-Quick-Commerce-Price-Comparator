package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import java.util.Objects;
import org.json.JSONException;

/* loaded from: classes4.dex */
final class zzbhn extends QueryInfoGenerationCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f25072a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbhp f25073b;

    public zzbhn(zzbhp zzbhpVar, String str) {
        this.f25072a = str;
        Objects.requireNonNull(zzbhpVar);
        this.f25073b = zzbhpVar;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void a(String str) {
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.f("Failed to generate query info for Custom Tab error: ".concat(String.valueOf(str)));
        try {
            zzbhp zzbhpVar = this.f25073b;
            zzbhpVar.f25081g.a(zzbhpVar.b(this.f25072a, str).toString());
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("Error creating PACT Error Response JSON: ", e2);
        }
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void b(QueryInfo queryInfo) {
        String str = queryInfo.f21972a.f21226a;
        try {
            zzbhp zzbhpVar = this.f25073b;
            zzbhpVar.f25081g.a(zzbhpVar.c(this.f25072a, str).toString());
        } catch (JSONException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error creating PACT Signal Response JSON: ", e2);
        }
    }
}
