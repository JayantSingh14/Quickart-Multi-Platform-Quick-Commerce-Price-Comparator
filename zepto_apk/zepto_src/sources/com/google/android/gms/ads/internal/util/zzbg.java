package com.google.android.gms.ads.internal.util;

import android.support.v4.media.a;
import com.google.android.gms.internal.ads.zzaro;
import com.google.android.gms.internal.ads.zzart;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
final class zzbg implements zzaro {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f21530a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbi f21531b;

    public zzbg(zzbl zzblVar, String str, zzbi zzbiVar) {
        this.f21530a = str;
        this.f21531b = zzbiVar;
        Objects.requireNonNull(zzblVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void a(zzart zzartVar) {
        String string = zzartVar.toString();
        String str = this.f21530a;
        String strN = a.n(new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(string).length()), "Failed to load URL: ", str, StringUtils.LF, string);
        int i2 = zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.f(strN);
        this.f21531b.b(null);
    }
}
