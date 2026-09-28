package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzarg;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzarq;
import com.google.android.gms.internal.ads.zzash;
import com.google.android.gms.internal.ads.zzcdt;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzbk extends zzark {

    /* renamed from: m, reason: collision with root package name */
    public final zzcdt f21533m;
    public final com.google.android.gms.ads.internal.util.client.zzl n;

    public zzbk(String str, zzcdt zzcdtVar) throws IOException {
        super(0, str, new zzbj(zzcdtVar));
        this.f21533m = zzcdtVar;
        com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl(0);
        this.n = zzlVar;
        zzlVar.b(str, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzark
    public final zzarq i(zzarg zzargVar) {
        return new zzarq(zzargVar, zzash.a(zzargVar));
    }

    @Override // com.google.android.gms.internal.ads.zzark
    public final void l(Object obj) throws IOException {
        byte[] bArr;
        zzarg zzargVar = (zzarg) obj;
        Map map = zzargVar.f24207c;
        com.google.android.gms.ads.internal.util.client.zzl zzlVar = this.n;
        zzlVar.getClass();
        if (com.google.android.gms.ads.internal.util.client.zzl.e()) {
            int i2 = zzargVar.f24205a;
            zzlVar.f(i2, map);
            if (i2 < 200 || i2 >= 300) {
                zzlVar.g(null);
            }
        }
        if (com.google.android.gms.ads.internal.util.client.zzl.e() && (bArr = zzargVar.f24206b) != null) {
            zzlVar.d(bArr);
        }
        this.f21533m.b(zzargVar);
    }
}
