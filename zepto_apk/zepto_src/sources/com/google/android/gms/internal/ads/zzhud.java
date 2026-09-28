package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.interfaces.ECPublicKey;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzhud implements zzhaq {

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f34294g = new byte[0];

    /* renamed from: h, reason: collision with root package name */
    public static final byte[] f34295h = {0};

    /* renamed from: i, reason: collision with root package name */
    public static final zzhhs f34296i;

    /* renamed from: j, reason: collision with root package name */
    public static final zzhhs f34297j;

    /* renamed from: k, reason: collision with root package name */
    public static final zzhhs f34298k;

    /* renamed from: a, reason: collision with root package name */
    public final ECPublicKey f34299a;

    /* renamed from: b, reason: collision with root package name */
    public final String f34300b;

    /* renamed from: c, reason: collision with root package name */
    public final zzhvv f34301c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f34302d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f34303e;

    /* renamed from: f, reason: collision with root package name */
    public final Provider f34304f;

    static {
        zzhhr zzhhrVar = new zzhhr();
        zzhhrVar.a(zzhwl.f34421a, zzhrb.f34083b);
        zzhhrVar.a(zzhwl.f34422b, zzhrb.f34084c);
        zzhhrVar.a(zzhwl.f34423c, zzhrb.f34085d);
        f34296i = zzhhrVar.b();
        zzhhr zzhhrVar2 = new zzhhr();
        zzhhrVar2.a(zzhvv.f34404a, zzhrc.f34087b);
        zzhhrVar2.a(zzhvv.f34405b, zzhrc.f34088c);
        f34297j = zzhhrVar2.b();
        zzhhr zzhhrVar3 = new zzhhr();
        zzhhrVar3.a(zzhvu.f34400a, zzhra.f34078c);
        zzhhrVar3.a(zzhvu.f34401b, zzhra.f34079d);
        zzhhrVar3.a(zzhvu.f34402c, zzhra.f34080e);
        f34298k = zzhhrVar3.b();
    }

    public zzhud(ECPublicKey eCPublicKey, zzhwl zzhwlVar, zzhvv zzhvvVar, byte[] bArr, byte[] bArr2, Provider provider) throws GeneralSecurityException {
        if (!zzhhb.a(2)) {
            throw new GeneralSecurityException("Can not use ECDSA in FIPS-mode, as BoringCrypto is not available.");
        }
        zzhxa.b(zzhwlVar);
        this.f34300b = zzhwlVar.toString().concat("withECDSA");
        this.f34299a = eCPublicKey;
        this.f34301c = zzhvvVar;
        this.f34302d = bArr;
        this.f34303e = bArr2;
        this.f34304f = provider;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0138 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(byte[] r18, byte[] r19) throws java.security.GeneralSecurityException {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhud.a(byte[], byte[]):void");
    }

    @Override // com.google.android.gms.internal.ads.zzhaq
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.f34302d;
        int length = bArr3.length;
        if (length == 0) {
            a(bArr, bArr2);
        } else {
            if (!zzhkl.c(bArr3, bArr)) {
                throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
            }
            a(Arrays.copyOfRange(bArr, length, bArr.length), bArr2);
        }
    }
}
