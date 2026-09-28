package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzhlj {
    static {
        int i2 = zzhpy.zza;
        try {
            a();
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void a() throws GeneralSecurityException {
        zzhlp zzhlpVar = zzhlp.f33997a;
        zzhjb zzhjbVar = zzhjb.f33880b;
        zzhjbVar.b(zzhlp.f33997a);
        zzhjbVar.a(zzhlp.f33998b);
        zzhjbVar.b(zzhkx.f33958a);
        int i2 = zzhle.f33976f;
        if (!zzhhb.a(i2)) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzhhs zzhhsVar = zzhmj.f34028a;
        zzhje zzhjeVar = zzhje.f33884b;
        zzhjeVar.c(zzhmj.f34030c);
        zzhjeVar.d(zzhmj.f34031d);
        zzhjeVar.a(zzhmj.f34032e);
        zzhjeVar.b(zzhmj.f34033f);
        zzhjbVar.a(zzhle.f33971a);
        zzhjbVar.a(zzhle.f33972b);
        zzhja zzhjaVar = zzhja.f33878b;
        HashMap map = new HashMap();
        map.put("HMAC_SHA256_128BITTAG", zzhlv.f34004a);
        zzhlf zzhlfVar = new zzhlf();
        zzhlfVar.a(32);
        zzhlfVar.b(16);
        zzhlh zzhlhVar = zzhlh.f33990e;
        zzhlfVar.f33980d = zzhlhVar;
        zzhlg zzhlgVar = zzhlg.f33983d;
        zzhlfVar.f33979c = zzhlgVar;
        map.put("HMAC_SHA256_128BITTAG_RAW", zzhlfVar.c());
        zzhlf zzhlfVar2 = new zzhlf();
        zzhlfVar2.a(32);
        zzhlfVar2.b(32);
        zzhlh zzhlhVar2 = zzhlh.f33987b;
        zzhlfVar2.f33980d = zzhlhVar2;
        zzhlfVar2.f33979c = zzhlgVar;
        map.put("HMAC_SHA256_256BITTAG", zzhlfVar2.c());
        zzhlf zzhlfVar3 = new zzhlf();
        zzhlfVar3.a(32);
        zzhlfVar3.b(32);
        zzhlfVar3.f33980d = zzhlhVar;
        zzhlfVar3.f33979c = zzhlgVar;
        map.put("HMAC_SHA256_256BITTAG_RAW", zzhlfVar3.c());
        zzhlf zzhlfVar4 = new zzhlf();
        zzhlfVar4.a(64);
        zzhlfVar4.b(16);
        zzhlfVar4.f33980d = zzhlhVar2;
        zzhlg zzhlgVar2 = zzhlg.f33985f;
        zzhlfVar4.f33979c = zzhlgVar2;
        map.put("HMAC_SHA512_128BITTAG", zzhlfVar4.c());
        zzhlf zzhlfVar5 = new zzhlf();
        zzhlfVar5.a(64);
        zzhlfVar5.b(16);
        zzhlfVar5.f33980d = zzhlhVar;
        zzhlfVar5.f33979c = zzhlgVar2;
        map.put("HMAC_SHA512_128BITTAG_RAW", zzhlfVar5.c());
        zzhlf zzhlfVar6 = new zzhlf();
        zzhlfVar6.a(64);
        zzhlfVar6.b(32);
        zzhlfVar6.f33980d = zzhlhVar2;
        zzhlfVar6.f33979c = zzhlgVar2;
        map.put("HMAC_SHA512_256BITTAG", zzhlfVar6.c());
        zzhlf zzhlfVar7 = new zzhlf();
        zzhlfVar7.a(64);
        zzhlfVar7.b(32);
        zzhlfVar7.f33980d = zzhlhVar;
        zzhlfVar7.f33979c = zzhlgVar2;
        map.put("HMAC_SHA512_256BITTAG_RAW", zzhlfVar7.c());
        map.put("HMAC_SHA512_512BITTAG", zzhlv.f34005b);
        zzhlf zzhlfVar8 = new zzhlf();
        zzhlfVar8.a(64);
        zzhlfVar8.b(64);
        zzhlfVar8.f33980d = zzhlhVar;
        zzhlfVar8.f33979c = zzhlgVar2;
        map.put("HMAC_SHA512_512BITTAG_RAW", zzhlfVar8.c());
        zzhjaVar.b(Collections.unmodifiableMap(map));
        zzhiv zzhivVar = zzhiv.f33870c;
        zzhivVar.a(zzhle.f33975e, zzhli.class);
        zzhix.f33872b.a(zzhle.f33974d, zzhli.class);
        zzhia zzhiaVar = zzhia.f33848d;
        zzhiaVar.c(zzhle.f33973c, i2, true);
        if (zzhhc.a()) {
            return;
        }
        zzhhz zzhhzVar = zzhkr.f33943a;
        if (!zzhhb.a(1)) {
            throw new GeneralSecurityException("Registering AES CMAC is not supported in FIPS mode");
        }
        zzhjeVar.c(zzhma.f34020a);
        zzhjeVar.d(zzhma.f34021b);
        zzhjeVar.a(zzhma.f34022c);
        zzhjeVar.b(zzhma.f34023d);
        zzhivVar.a(zzhkq.f33942a, zzhku.class);
        zzhjbVar.a(zzhkr.f33944b);
        zzhjbVar.a(zzhkr.f33945c);
        HashMap map2 = new HashMap();
        zzhku zzhkuVar = zzhlv.f34006c;
        map2.put("AES_CMAC", zzhkuVar);
        map2.put("AES256_CMAC", zzhkuVar);
        zzhks zzhksVar = new zzhks();
        zzhksVar.a(32);
        zzhksVar.b(16);
        zzhksVar.f33949c = zzhkt.f33953e;
        map2.put("AES256_CMAC_RAW", zzhksVar.c());
        zzhjaVar.b(Collections.unmodifiableMap(map2));
        zzhiaVar.a(zzhkr.f33946d, true);
    }
}
