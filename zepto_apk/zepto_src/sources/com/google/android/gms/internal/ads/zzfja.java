package com.google.android.gms.internal.ads;

import android.util.Base64;
import androidx.annotation.VisibleForTesting;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzfja {
    @VisibleForTesting
    public zzfja() {
        try {
            zzhav.a();
        } catch (GeneralSecurityException e2) {
            com.google.android.gms.ads.internal.util.zze.k("Failed to Configure Aead. ".concat(e2.toString()));
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("CryptoUtils.registerAead", e2);
        }
    }

    public static final String a(byte[] bArr, byte[] bArr2, String str, zzdwy zzdwyVar) throws GeneralSecurityException {
        zzhai zzhaiVarA;
        if (str != null) {
            try {
                try {
                    zzhaiVarA = zzhai.a(new zzgzr(new ByteArrayInputStream(Base64.decode(str, 11))).a());
                } catch (IOException unused) {
                    throw new GeneralSecurityException("Parse keyset failed");
                }
            } catch (GeneralSecurityException e2) {
                com.google.android.gms.ads.internal.util.zze.k("Failed to get keysethandle".concat(e2.toString()));
                com.google.android.gms.ads.internal.zzt.C.f21684h.d("CryptoUtils.getHandle", e2);
                zzhaiVarA = null;
            }
            if (zzhaiVarA != null) {
                try {
                    byte[] bArrZza = ((zzgzq) zzhaiVarA.f((zzhhv) zzhhd.a(), zzgzq.class)).zza(bArr, bArr2);
                    zzdwyVar.f28712a.put("ds", "1");
                    return new String(bArrZza, "UTF-8");
                } catch (UnsupportedEncodingException | UnsupportedOperationException | GeneralSecurityException e3) {
                    com.google.android.gms.ads.internal.util.zze.k("Failed to decrypt ".concat(e3.toString()));
                    com.google.android.gms.ads.internal.zzt.C.f21684h.d("CryptoUtils.decrypt", e3);
                    zzdwyVar.f28712a.put("dsf", e3.toString());
                }
            }
        }
        return null;
    }
}
