package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzcqg implements zzcpq {

    /* renamed from: a, reason: collision with root package name */
    public final Context f26891a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzj f26892b = com.google.android.gms.ads.internal.zzt.C.f21684h.g();

    public zzcqg(Context context) {
        this.f26891a = context;
    }

    @Override // com.google.android.gms.internal.ads.zzcpq
    public final void a(HashMap map) throws IOException {
        String str;
        if (map.isEmpty() || (str = (String) map.get("gad_idless")) == null) {
            return;
        }
        boolean z = Boolean.parseBoolean(str);
        this.f26892b.P(z);
        if (z) {
            com.google.android.gms.ads.internal.util.zzac.a(this.f26891a);
        }
    }
}
