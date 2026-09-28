package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzaro;
import com.google.android.gms.internal.ads.zzarp;
import com.google.android.gms.internal.ads.zzasn;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbh extends zzasn {
    public final /* synthetic */ byte[] o;
    public final /* synthetic */ HashMap p;
    public final /* synthetic */ com.google.android.gms.ads.internal.util.client.zzl q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbh(zzbl zzblVar, int i2, String str, zzarp zzarpVar, zzaro zzaroVar, byte[] bArr, HashMap map, com.google.android.gms.ads.internal.util.client.zzl zzlVar) {
        super(i2, str, zzarpVar, zzaroVar);
        this.o = bArr;
        this.p = map;
        this.q = zzlVar;
        Objects.requireNonNull(zzblVar);
    }

    @Override // com.google.android.gms.internal.ads.zzark
    public final Map e() {
        HashMap map = this.p;
        return map == null ? Collections.EMPTY_MAP : map;
    }

    @Override // com.google.android.gms.internal.ads.zzark
    public final byte[] g() {
        byte[] bArr = this.o;
        if (bArr == null) {
            return null;
        }
        return bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzasn, com.google.android.gms.internal.ads.zzark
    /* renamed from: q */
    public final void l(String str) throws IOException {
        com.google.android.gms.ads.internal.util.client.zzl zzlVar = this.q;
        if (com.google.android.gms.ads.internal.util.client.zzl.e() && str != null) {
            zzlVar.d(str.getBytes());
        }
        super.l(str);
    }
}
