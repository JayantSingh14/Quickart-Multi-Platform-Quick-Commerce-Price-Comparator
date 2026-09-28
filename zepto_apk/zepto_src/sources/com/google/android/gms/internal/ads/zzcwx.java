package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public final class zzcwx implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27317a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcmj f27318b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdab f27319c;

    public zzcwx(zzijf zzijfVar, zzcmj zzcmjVar, zzdab zzdabVar) {
        this.f27317a = zzijfVar;
        this.f27318b = zzcmjVar;
        this.f27319c = zzdabVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        String string;
        Clock clock = (Clock) this.f27317a.zzb();
        zzcdf zzcdfVarZzb = this.f27318b.zzb();
        String str = this.f27319c.a().f31219g;
        zzcdd zzcddVar = zzcdfVarZzb.f25964c;
        synchronized (zzcddVar) {
            string = zzcddVar.f25960a.toString();
            zzcddVar.f25960a = zzcddVar.f25960a.add(BigInteger.ONE);
            zzcddVar.f25961b = string;
        }
        return new zzccu(clock, zzcdfVarZzb, string, str);
    }
}
