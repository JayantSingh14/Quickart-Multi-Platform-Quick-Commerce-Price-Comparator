package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhgx implements zzgzq {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f33779a = new zzhgv();

    public static zzhfo a(zzhcm zzhcmVar) {
        zzhgw zzhgwVar = zzhgw.f33778a;
        byte[] bArr = zzhfo.f33717d;
        if (zzhfo.a(zzhgwVar.a())) {
            return new zzhfo(zzhcmVar.f33542b.f34463a.b(), zzhcmVar.f33543c.b());
        }
        throw new IllegalStateException("Cipher does not implement AES GCM SIV.");
    }

    @Override // com.google.android.gms.internal.ads.zzgzq
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        throw null;
    }
}
