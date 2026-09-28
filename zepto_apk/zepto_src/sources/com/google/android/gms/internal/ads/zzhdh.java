package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhdh extends zzhbe {

    /* renamed from: a, reason: collision with root package name */
    public final zzhdj f33588a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhxc f33589b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f33590c;

    public zzhdh(zzhdj zzhdjVar, zzhxc zzhxcVar, Integer num) {
        this.f33588a = zzhdjVar;
        this.f33589b = zzhxcVar;
        this.f33590c = num;
    }

    public static zzhdh d(zzhdj zzhdjVar, Integer num) throws GeneralSecurityException {
        zzhxc zzhxcVarA;
        zzhdi zzhdiVar = zzhdi.f33591b;
        zzhdi zzhdiVar2 = zzhdjVar.f33595b;
        if (zzhdiVar2 == zzhdiVar) {
            if (num == null) {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
            zzhxcVarA = zzhxc.a(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        } else {
            if (zzhdiVar2 != zzhdi.f33592c) {
                throw new GeneralSecurityException("Unknown Variant: ".concat(zzhdiVar2.f33593a));
            }
            if (num != null) {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
            zzhxcVarA = zzhxc.a(new byte[0]);
        }
        return new zzhdh(zzhdjVar, zzhxcVarA, num);
    }

    @Override // com.google.android.gms.internal.ads.zzhbe, com.google.android.gms.internal.ads.zzgzx
    public final /* synthetic */ zzhan a() {
        return this.f33588a;
    }

    @Override // com.google.android.gms.internal.ads.zzgzx
    public final Integer b() {
        return this.f33590c;
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final zzhxc c() {
        return this.f33589b;
    }
}
