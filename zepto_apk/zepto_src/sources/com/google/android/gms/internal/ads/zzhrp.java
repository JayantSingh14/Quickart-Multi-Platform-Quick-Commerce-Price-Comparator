package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzhrp extends zzhtt {

    /* renamed from: a, reason: collision with root package name */
    public final zzhrv f34125a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhxe f34126b;

    public zzhrp(zzhrv zzhrvVar, zzhxe zzhxeVar) {
        this.f34125a = zzhrvVar;
        this.f34126b = zzhxeVar;
    }

    public static zzhrp d(zzhrv zzhrvVar, zzhxe zzhxeVar) throws GeneralSecurityException {
        zzhxc zzhxcVar = zzhxeVar.f34463a;
        if (zzhxcVar.f34461a.length != 32) {
            int length = zzhxcVar.f34461a.length;
            throw new GeneralSecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(length).length() + 65), length, "Ed25519 key must be constructed with key of length 32 bytes, not "));
        }
        if (Arrays.equals(zzhrvVar.f34138b.b(), zzhhm.a(zzhhm.b(zzhxcVar.b())))) {
            return new zzhrp(zzhrvVar, zzhxeVar);
        }
        throw new GeneralSecurityException("Ed25519 keys mismatch");
    }

    @Override // com.google.android.gms.internal.ads.zzhtt, com.google.android.gms.internal.ads.zzgzx
    public final zzhan a() {
        return this.f34125a.f34137a;
    }

    @Override // com.google.android.gms.internal.ads.zzhtt
    public final /* synthetic */ zzhtu c() {
        return this.f34125a;
    }
}
