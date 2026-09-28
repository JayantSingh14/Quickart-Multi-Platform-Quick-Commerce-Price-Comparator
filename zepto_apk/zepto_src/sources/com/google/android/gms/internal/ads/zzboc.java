package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.json.JSONObject;

/* loaded from: classes4.dex */
final class zzboc implements zzbod {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcdt f25384a;

    public zzboc(zzboe zzboeVar, zzcdt zzcdtVar) {
        this.f25384a = zzcdtVar;
        Objects.requireNonNull(zzboeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbod
    public final void b(String str) {
        this.f25384a.c(new zzbru(str));
    }

    @Override // com.google.android.gms.internal.ads.zzbod
    public final void c(JSONObject jSONObject) {
        this.f25384a.b(jSONObject);
    }
}
