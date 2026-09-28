package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzery implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30196a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfik f30197b;

    /* renamed from: c, reason: collision with root package name */
    public final int f30198c;

    public zzery(zzgyw zzgywVar, zzfik zzfikVar, int i2) {
        this.f30196a = zzgywVar;
        this.f30197b = zzfikVar;
        this.f30198c = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return ((zzgxi) this.f30196a).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzerx
            @Override // java.util.concurrent.Callable
            public final Object call() throws GeneralSecurityException, IOException {
                List listAsList;
                byte[] byteArray;
                zzhan zzhanVarA;
                zzhai zzhaiVarE;
                ByteArrayOutputStream byteArrayOutputStream;
                zzery zzeryVar = this.f30195a;
                zzeryVar.getClass();
                zzbgb zzbgbVar = zzbgk.I7;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                String strEncodeToString = null;
                if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                    zzfik zzfikVar = zzeryVar.f30197b;
                    if (zzeryVar.f30198c != 2) {
                        String strB = com.google.android.gms.ads.nonagon.signalgeneration.zzaa.b(zzfikVar.f31216d);
                        if (((Boolean) zzbdVar.f21153c.a(zzbgk.K7)).booleanValue()) {
                            listAsList = Arrays.asList(((String) zzbdVar.f21153c.a(zzbgk.L7)).split(","));
                        } else {
                            listAsList = Arrays.asList(((String) zzbdVar.f21153c.a(zzbgk.J7)).split(","));
                        }
                        if (listAsList.contains(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.a(strB))) {
                            try {
                                zzhja zzhjaVar = zzhja.f33878b;
                                synchronized (zzhjaVar) {
                                    HashMap map = zzhjaVar.f33879a;
                                    if (!map.containsKey("AES128_GCM")) {
                                        throw new GeneralSecurityException("Name AES128_GCM does not exist");
                                    }
                                    zzhanVarA = (zzhan) map.get("AES128_GCM");
                                }
                                if (zzhanVarA == null) {
                                    try {
                                        zzhanVarA = zzhat.a(((zzhka) zzhje.f33884b.h(null)).f33917b.g());
                                    } catch (GeneralSecurityException e2) {
                                        throw new zzhkk("Parsing parameters failed in getProto(). You probably want to call some Tink register function for ".concat("null"), e2);
                                    }
                                }
                                zzhaiVarE = zzhai.e(zzhanVarA);
                                try {
                                    byteArrayOutputStream = new ByteArrayOutputStream();
                                } catch (IOException unused) {
                                    throw new GeneralSecurityException("Serialize keyset failed");
                                }
                            } catch (GeneralSecurityException e3) {
                                com.google.android.gms.ads.internal.util.zze.k("Failed to generate key".concat(e3.toString()));
                                com.google.android.gms.ads.internal.zzt.C.f21684h.d("CryptoUtils.generateKey", e3);
                                byteArray = new byte[0];
                            }
                            try {
                                zzhaiVarE.b().a(byteArrayOutputStream);
                                byteArrayOutputStream.close();
                                byteArray = byteArrayOutputStream.toByteArray();
                                strEncodeToString = Base64.encodeToString(byteArray, 11);
                            } catch (Throwable th) {
                                byteArrayOutputStream.close();
                                throw th;
                            }
                        }
                    }
                }
                return new zzerz(strEncodeToString);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 5;
    }
}
