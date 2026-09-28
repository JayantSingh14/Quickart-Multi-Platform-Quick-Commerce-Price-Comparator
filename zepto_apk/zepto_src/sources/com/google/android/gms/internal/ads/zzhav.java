package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzhav {
    static {
        int i2 = zzhpy.zza;
        try {
            a();
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void a() {
        zzhbj zzhbjVar = zzhbj.f33448a;
        zzhjb zzhjbVar = zzhjb.f33880b;
        zzhjbVar.b(zzhbj.f33448a);
        zzhjbVar.a(zzhbj.f33449b);
        zzhlj.a();
        int i2 = zzhbp.f33466e;
        if (!zzhhb.a(i2)) {
            throw new GeneralSecurityException("Can not use AES-CTR-HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzhjl zzhjlVar = zzhfa.f33696a;
        zzhje zzhjeVar = zzhje.f33884b;
        zzhjeVar.c(zzhfa.f33696a);
        zzhjeVar.d(zzhfa.f33697b);
        zzhjeVar.a(zzhfa.f33698c);
        zzhjeVar.b(zzhfa.f33699d);
        zzhjbVar.a(zzhbp.f33462a);
        zzhja zzhjaVar = zzhja.f33878b;
        HashMap map = new HashMap();
        map.put("AES128_CTR_HMAC_SHA256", zzhei.f33651e);
        zzhbq zzhbqVar = new zzhbq();
        zzhbqVar.a(16);
        zzhbqVar.b(32);
        zzhbqVar.d(16);
        zzhbqVar.c(16);
        zzhbr zzhbrVar = zzhbr.f33475d;
        zzhbqVar.f33471e = zzhbrVar;
        zzhbs zzhbsVar = zzhbs.f33481d;
        zzhbqVar.f33472f = zzhbsVar;
        map.put("AES128_CTR_HMAC_SHA256_RAW", zzhbqVar.e());
        map.put("AES256_CTR_HMAC_SHA256", zzhei.f33652f);
        zzhbq zzhbqVar2 = new zzhbq();
        zzhbqVar2.a(32);
        zzhbqVar2.b(32);
        zzhbqVar2.d(32);
        zzhbqVar2.c(16);
        zzhbqVar2.f33471e = zzhbrVar;
        zzhbqVar2.f33472f = zzhbsVar;
        map.put("AES256_CTR_HMAC_SHA256_RAW", zzhbqVar2.e());
        zzhjaVar.b(Collections.unmodifiableMap(map));
        zzhix zzhixVar = zzhix.f33872b;
        zzhixVar.a(zzhbp.f33464c, zzhbt.class);
        zzhiv zzhivVar = zzhiv.f33870c;
        zzhivVar.a(zzhbp.f33465d, zzhbt.class);
        zzhia zzhiaVar = zzhia.f33848d;
        zzhiaVar.c(zzhbp.f33463b, i2, true);
        int i3 = zzhch.f33527e;
        if (!zzhhb.a(i3)) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzhjeVar.c(zzhfm.f33713a);
        zzhjeVar.d(zzhfm.f33714b);
        zzhjeVar.a(zzhfm.f33715c);
        zzhjeVar.b(zzhfm.f33716d);
        zzhjbVar.a(zzhch.f33523a);
        HashMap map2 = new HashMap();
        map2.put("AES128_GCM", zzhei.f33647a);
        zzhci zzhciVar = new zzhci();
        zzhciVar.b();
        zzhciVar.a(16);
        zzhciVar.c();
        zzhcj zzhcjVar = zzhcj.f33534d;
        zzhciVar.f33531d = zzhcjVar;
        map2.put("AES128_GCM_RAW", zzhciVar.d());
        map2.put("AES256_GCM", zzhei.f33648b);
        zzhci zzhciVar2 = new zzhci();
        zzhciVar2.b();
        zzhciVar2.a(32);
        zzhciVar2.c();
        zzhciVar2.f33531d = zzhcjVar;
        map2.put("AES256_GCM_RAW", zzhciVar2.d());
        zzhjaVar.b(Collections.unmodifiableMap(map2));
        zzhixVar.a(zzhch.f33525c, zzhck.class);
        zzhivVar.a(zzhch.f33526d, zzhck.class);
        zzhiaVar.c(zzhch.f33524b, i3, true);
        if (zzhhc.a()) {
            return;
        }
        zzhjs zzhjsVar = zzhby.f33498a;
        if (!zzhhb.a(1)) {
            throw new GeneralSecurityException("Registering AES EAX is not supported in FIPS mode");
        }
        zzhjeVar.c(zzhff.f33704a);
        zzhjeVar.d(zzhff.f33705b);
        zzhjeVar.a(zzhff.f33706c);
        zzhjeVar.b(zzhff.f33707d);
        zzhjbVar.a(zzhby.f33498a);
        HashMap map3 = new HashMap();
        map3.put("AES128_EAX", zzhei.f33649c);
        zzhbz zzhbzVar = new zzhbz();
        zzhbzVar.b(16);
        zzhbzVar.a(16);
        zzhbzVar.c();
        zzhca zzhcaVar = zzhca.f33508d;
        zzhbzVar.f33504d = zzhcaVar;
        map3.put("AES128_EAX_RAW", zzhbzVar.d());
        map3.put("AES256_EAX", zzhei.f33650d);
        zzhbz zzhbzVar2 = new zzhbz();
        zzhbzVar2.b(16);
        zzhbzVar2.a(32);
        zzhbzVar2.c();
        zzhbzVar2.f33504d = zzhcaVar;
        map3.put("AES256_EAX_RAW", zzhbzVar2.d());
        zzhjaVar.b(Collections.unmodifiableMap(map3));
        zzhivVar.a(zzhby.f33500c, zzhcb.class);
        zzhiaVar.a(zzhby.f33499b, true);
        zzhjs zzhjsVar2 = zzhcq.f33548a;
        if (!zzhhb.a(1)) {
            throw new GeneralSecurityException("Registering AES GCM SIV is not supported in FIPS mode");
        }
        zzhjeVar.c(zzhft.f33729a);
        zzhjeVar.d(zzhft.f33730b);
        zzhjeVar.a(zzhft.f33731c);
        zzhjeVar.b(zzhft.f33732d);
        HashMap map4 = new HashMap();
        zzhcr zzhcrVar = new zzhcr();
        zzhcrVar.a(16);
        zzhcs zzhcsVar = zzhcs.f33554b;
        zzhcrVar.f33553b = zzhcsVar;
        map4.put("AES128_GCM_SIV", zzhcrVar.b());
        zzhcr zzhcrVar2 = new zzhcr();
        zzhcrVar2.a(16);
        zzhcs zzhcsVar2 = zzhcs.f33556d;
        zzhcrVar2.f33553b = zzhcsVar2;
        map4.put("AES128_GCM_SIV_RAW", zzhcrVar2.b());
        zzhcr zzhcrVar3 = new zzhcr();
        zzhcrVar3.a(32);
        zzhcrVar3.f33553b = zzhcsVar;
        map4.put("AES256_GCM_SIV", zzhcrVar3.b());
        zzhcr zzhcrVar4 = new zzhcr();
        zzhcrVar4.a(32);
        zzhcrVar4.f33553b = zzhcsVar2;
        map4.put("AES256_GCM_SIV_RAW", zzhcrVar4.b());
        zzhjaVar.b(Collections.unmodifiableMap(map4));
        zzhixVar.a(zzhco.f33546a, zzhct.class);
        zzhivVar.a(zzhcp.f33547a, zzhct.class);
        zzhjbVar.a(zzhcq.f33548a);
        zzhiaVar.a(zzhcq.f33551d, true);
        zzhjs zzhjsVar3 = zzhcx.f33566a;
        if (!zzhhb.a(1)) {
            throw new GeneralSecurityException("Registering ChaCha20Poly1305 is not supported in FIPS mode");
        }
        zzhjeVar.c(zzhfz.f33743a);
        zzhjeVar.d(zzhfz.f33744b);
        zzhjeVar.a(zzhfz.f33745c);
        zzhjeVar.b(zzhfz.f33746d);
        zzhjbVar.a(zzhcx.f33566a);
        zzhivVar.a(zzhcv.f33564a, zzhcz.class);
        HashMap map5 = new HashMap();
        map5.put("CHACHA20_POLY1305", new zzhcz(zzhcy.f33569b));
        map5.put("CHACHA20_POLY1305_RAW", new zzhcz(zzhcy.f33571d));
        zzhjaVar.b(Collections.unmodifiableMap(map5));
        zzhiaVar.a(zzhcx.f33568c, true);
        zzhjs zzhjsVar4 = zzhdc.f33576a;
        if (!zzhhb.a(1)) {
            throw new GeneralSecurityException("Registering KMS AEAD is not supported in FIPS mode");
        }
        zzhjeVar.c(zzhdo.f33600a);
        zzhjeVar.d(zzhdo.f33601b);
        zzhjeVar.a(zzhdo.f33602c);
        zzhjeVar.b(zzhdo.f33603d);
        zzhjbVar.a(zzhdc.f33576a);
        zzhivVar.a(zzhdc.f33578c, zzhdj.class);
        zzhiaVar.a(zzhdc.f33577b, true);
        zzhij zzhijVar = zzhdg.f33585a;
        if (!zzhhb.a(1)) {
            throw new GeneralSecurityException("Registering KMS Envelope AEAD is not supported in FIPS mode");
        }
        zzhjeVar.c(zzhdy.f33629a);
        zzhjeVar.d(zzhdy.f33630b);
        zzhjeVar.a(zzhdy.f33631c);
        zzhjeVar.b(zzhdy.f33632d);
        zzhivVar.a(zzhdg.f33586b, zzhdt.class);
        zzhjbVar.a(zzhdg.f33587c);
        zzhiaVar.a(zzhdg.f33585a, true);
        zzhjs zzhjsVar5 = zzhet.f33677a;
        if (!zzhhb.a(1)) {
            throw new GeneralSecurityException("Registering XChaCha20Poly1305 is not supported in FIPS mode");
        }
        zzhjeVar.c(zzhgu.f33774a);
        zzhjeVar.d(zzhgu.f33775b);
        zzhjeVar.a(zzhgu.f33776c);
        zzhjeVar.b(zzhgu.f33777d);
        zzhjbVar.a(zzhet.f33677a);
        HashMap map6 = new HashMap();
        map6.put("XCHACHA20_POLY1305", new zzhev(zzheu.f33681b));
        map6.put("XCHACHA20_POLY1305_RAW", new zzhev(zzheu.f33683d));
        zzhjaVar.b(Collections.unmodifiableMap(map6));
        zzhivVar.a(zzhet.f33680d, zzhev.class);
        zzhixVar.a(zzhet.f33679c, zzhev.class);
        zzhiaVar.a(zzhet.f33678b, true);
        zzhhz zzhhzVar = zzhem.f33663a;
        zzhjeVar.c(zzhgo.f33763a);
        zzhjeVar.d(zzhgo.f33764b);
        zzhjeVar.a(zzhgo.f33765c);
        zzhjeVar.b(zzhgo.f33766d);
        HashMap map7 = new HashMap();
        map7.put("XAES_256_GCM_192_BIT_NONCE", zzhei.f33653g);
        map7.put("XAES_256_GCM_192_BIT_NONCE_NO_PREFIX", zzhei.f33654h);
        map7.put("XAES_256_GCM_160_BIT_NONCE_NO_PREFIX", zzhei.f33655i);
        map7.put("X_AES_GCM_8_BYTE_SALT_NO_PREFIX", zzhei.f33656j);
        zzhjaVar.b(Collections.unmodifiableMap(map7));
        zzhjbVar.a(zzhem.f33664b);
        zzhivVar.a(zzhel.f33662a, zzheo.class);
    }
}
