package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbxo extends zzccf {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ QueryInfoGenerationCallback f25665a;

    public zzbxo(zzbxp zzbxpVar, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        this.f25665a = queryInfoGenerationCallback;
        Objects.requireNonNull(zzbxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzccg
    public final void G2(String str, String str2, Bundle bundle) {
        this.f25665a.b(new QueryInfo(new com.google.android.gms.ads.internal.client.zzfa(str)));
    }

    @Override // com.google.android.gms.internal.ads.zzccg
    public final void b(String str) {
        this.f25665a.a(str);
    }
}
