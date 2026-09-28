package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzhtr {
    static {
        int i2 = zzhpy.zza;
        try {
            a();
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void a() {
        zzhso zzhsoVar = zzhso.f34169a;
        zzhjb zzhjbVar = zzhjb.f33880b;
        zzhjbVar.b(zzhso.f34169a);
        zzhjbVar.a(zzhso.f34170b);
        zzhjbVar.b(zzhss.f34174a);
        zzhjbVar.a(zzhss.f34175b);
        int i2 = zzhrm.f34118f;
        if (!zzhhb.a(i2)) {
            throw new GeneralSecurityException("Can not use ECDSA in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzhjl zzhjlVar = zzhub.f34288a;
        zzhje zzhjeVar = zzhje.f33884b;
        zzhjeVar.c(zzhub.f34288a);
        zzhjeVar.d(zzhub.f34289b);
        zzhjeVar.a(zzhub.f34290c);
        zzhjeVar.b(zzhub.f34291d);
        zzhjeVar.a(zzhub.f34292e);
        zzhjeVar.b(zzhub.f34293f);
        zzhja zzhjaVar = zzhja.f33878b;
        HashMap map = new HashMap();
        map.put("ECDSA_P256", zzhsk.f34156a);
        map.put("ECDSA_P256_IEEE_P1363", zzhsk.f34159d);
        zzhqz zzhqzVar = new zzhqz();
        zzhqzVar.f34076c = zzhrb.f34083b;
        zzhqzVar.f34075b = zzhra.f34078c;
        zzhqzVar.f34074a = zzhrc.f34087b;
        zzhqzVar.f34077d = zzhrd.f34093e;
        map.put("ECDSA_P256_RAW", zzhqzVar.a());
        map.put("ECDSA_P256_IEEE_P1363_WITHOUT_PREFIX", zzhsk.f34161f);
        map.put("ECDSA_P384", zzhsk.f34157b);
        map.put("ECDSA_P384_IEEE_P1363", zzhsk.f34160e);
        zzhqz zzhqzVar2 = new zzhqz();
        zzhqzVar2.f34076c = zzhrb.f34085d;
        zzhra zzhraVar = zzhra.f34079d;
        zzhqzVar2.f34075b = zzhraVar;
        zzhrc zzhrcVar = zzhrc.f34088c;
        zzhqzVar2.f34074a = zzhrcVar;
        zzhrd zzhrdVar = zzhrd.f34090b;
        zzhqzVar2.f34077d = zzhrdVar;
        map.put("ECDSA_P384_SHA512", zzhqzVar2.a());
        zzhqz zzhqzVar3 = new zzhqz();
        zzhqzVar3.f34076c = zzhrb.f34084c;
        zzhqzVar3.f34075b = zzhraVar;
        zzhqzVar3.f34074a = zzhrcVar;
        zzhqzVar3.f34077d = zzhrdVar;
        map.put("ECDSA_P384_SHA384", zzhqzVar3.a());
        map.put("ECDSA_P521", zzhsk.f34158c);
        map.put("ECDSA_P521_IEEE_P1363", zzhsk.f34162g);
        zzhjaVar.b(Collections.unmodifiableMap(map));
        zzhjbVar.a(zzhrm.f34113a);
        zzhjbVar.a(zzhrm.f34114b);
        zzhiv zzhivVar = zzhiv.f33870c;
        zzhivVar.a(zzhrm.f34117e, zzhre.class);
        zzhia zzhiaVar = zzhia.f33848d;
        zzhiaVar.c(zzhrm.f34115c, i2, true);
        zzhiaVar.c(zzhrm.f34116d, i2, false);
        int i3 = zzhte.f34227f;
        if (!zzhhb.a(i3)) {
            throw new GeneralSecurityException("Can not use RSA SSA PKCS1 in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzhjeVar.c(zzhuv.f34333a);
        zzhjeVar.d(zzhuv.f34334b);
        zzhjeVar.a(zzhuv.f34335c);
        zzhjeVar.b(zzhuv.f34336d);
        zzhjeVar.a(zzhuv.f34337e);
        zzhjeVar.b(zzhuv.f34338f);
        HashMap map2 = new HashMap();
        map2.put("RSA_SSA_PKCS1_3072_SHA256_F4", zzhsk.f34163h);
        BigInteger bigInteger = zzhsw.f34191e;
        zzhst zzhstVar = new zzhst();
        zzhstVar.f34180c = zzhsu.f34182b;
        zzhstVar.a(3072);
        BigInteger bigInteger2 = zzhsw.f34191e;
        zzhstVar.f34179b = bigInteger2;
        zzhsv zzhsvVar = zzhsv.f34189e;
        zzhstVar.f34181d = zzhsvVar;
        map2.put("RSA_SSA_PKCS1_3072_SHA256_F4_RAW", zzhstVar.b());
        map2.put("RSA_SSA_PKCS1_3072_SHA256_F4_WITHOUT_PREFIX", zzhsk.f34164i);
        map2.put("RSA_SSA_PKCS1_4096_SHA512_F4", zzhsk.f34165j);
        zzhst zzhstVar2 = new zzhst();
        zzhstVar2.f34180c = zzhsu.f34184d;
        zzhstVar2.a(4096);
        zzhstVar2.f34179b = bigInteger2;
        zzhstVar2.f34181d = zzhsvVar;
        map2.put("RSA_SSA_PKCS1_4096_SHA512_F4_RAW", zzhstVar2.b());
        zzhjaVar.b(map2);
        zzhjbVar.a(zzhte.f34222a);
        zzhjbVar.a(zzhte.f34223b);
        zzhivVar.a(zzhte.f34226e, zzhsw.class);
        zzhiaVar.c(zzhte.f34224c, i3, true);
        zzhiaVar.c(zzhte.f34225d, i3, false);
        int i4 = zzhtq.f34281f;
        if (!zzhhb.a(i4)) {
            throw new GeneralSecurityException("Can not use RSA SSA PSS in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzhjeVar.c(zzhve.f34365a);
        zzhjeVar.d(zzhve.f34366b);
        zzhjeVar.a(zzhve.f34367c);
        zzhjeVar.b(zzhve.f34368d);
        zzhjeVar.a(zzhve.f34369e);
        zzhjeVar.b(zzhve.f34370f);
        HashMap map3 = new HashMap();
        BigInteger bigInteger3 = zzhti.f34245g;
        zzhtf zzhtfVar = new zzhtf();
        zzhtg zzhtgVar = zzhtg.f34236b;
        zzhtfVar.f34232c = zzhtgVar;
        zzhtfVar.f34233d = zzhtgVar;
        zzhtfVar.b(32);
        zzhtfVar.a(3072);
        BigInteger bigInteger4 = zzhti.f34245g;
        zzhtfVar.f34231b = bigInteger4;
        zzhth zzhthVar = zzhth.f34240b;
        zzhtfVar.f34235f = zzhthVar;
        map3.put("RSA_SSA_PSS_3072_SHA256_F4", zzhtfVar.c());
        zzhtf zzhtfVar2 = new zzhtf();
        zzhtfVar2.f34232c = zzhtgVar;
        zzhtfVar2.f34233d = zzhtgVar;
        zzhtfVar2.b(32);
        zzhtfVar2.a(3072);
        zzhtfVar2.f34231b = bigInteger4;
        zzhth zzhthVar2 = zzhth.f34243e;
        zzhtfVar2.f34235f = zzhthVar2;
        map3.put("RSA_SSA_PSS_3072_SHA256_F4_RAW", zzhtfVar2.c());
        map3.put("RSA_SSA_PSS_3072_SHA256_SHA256_32_F4", zzhsk.f34166k);
        zzhtf zzhtfVar3 = new zzhtf();
        zzhtg zzhtgVar2 = zzhtg.f34238d;
        zzhtfVar3.f34232c = zzhtgVar2;
        zzhtfVar3.f34233d = zzhtgVar2;
        zzhtfVar3.b(64);
        zzhtfVar3.a(4096);
        zzhtfVar3.f34231b = bigInteger4;
        zzhtfVar3.f34235f = zzhthVar;
        map3.put("RSA_SSA_PSS_4096_SHA512_F4", zzhtfVar3.c());
        zzhtf zzhtfVar4 = new zzhtf();
        zzhtfVar4.f34232c = zzhtgVar2;
        zzhtfVar4.f34233d = zzhtgVar2;
        zzhtfVar4.b(64);
        zzhtfVar4.a(4096);
        zzhtfVar4.f34231b = bigInteger4;
        zzhtfVar4.f34235f = zzhthVar2;
        map3.put("RSA_SSA_PSS_4096_SHA512_F4_RAW", zzhtfVar4.c());
        map3.put("RSA_SSA_PSS_4096_SHA512_SHA512_64_F4", zzhsk.f34167l);
        zzhjaVar.b(Collections.unmodifiableMap(map3));
        zzhjbVar.a(zzhtq.f34276a);
        zzhjbVar.a(zzhtq.f34277b);
        zzhivVar.a(zzhtq.f34280e, zzhti.class);
        zzhiaVar.c(zzhtq.f34278c, i4, true);
        zzhiaVar.c(zzhtq.f34279d, i4, false);
        if (zzhhc.a()) {
            return;
        }
        zzhjs zzhjsVar = zzhru.f34131a;
        if (!zzhhb.a(1)) {
            throw new GeneralSecurityException("Registering AES GCM SIV is not supported in FIPS mode");
        }
        zzhjeVar.c(zzhuk.f34311a);
        zzhjeVar.d(zzhuk.f34312b);
        zzhjeVar.a(zzhuk.f34313c);
        zzhjeVar.b(zzhuk.f34314d);
        zzhjeVar.a(zzhuk.f34315e);
        zzhjeVar.b(zzhuk.f34316f);
        HashMap map4 = new HashMap();
        map4.put("ED25519", new zzhro(zzhrn.f34119b));
        zzhrn zzhrnVar = zzhrn.f34122e;
        map4.put("ED25519_RAW", new zzhro(zzhrnVar));
        map4.put("ED25519WithRawOutput", new zzhro(zzhrnVar));
        zzhjaVar.b(Collections.unmodifiableMap(map4));
        zzhivVar.a(zzhru.f34136f, zzhro.class);
        zzhix.f33872b.a(zzhru.f34135e, zzhro.class);
        zzhjbVar.a(zzhru.f34131a);
        zzhjbVar.a(zzhru.f34132b);
        zzhiaVar.a(zzhru.f34133c, true);
        zzhiaVar.a(zzhru.f34134d, false);
    }
}
