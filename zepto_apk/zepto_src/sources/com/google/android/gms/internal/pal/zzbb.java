package com.google.android.gms.internal.pal;

import android.util.Base64;
import android.util.Log;
import com.google.ads.interactivemedia.pal.NonceLoaderException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final class zzbb implements zzba {

    /* renamed from: a, reason: collision with root package name */
    public final zzjy f37533a;

    public zzbb(zzjy zzjyVar) {
        this.f37533a = zzjyVar;
    }

    @Override // com.google.android.gms.internal.pal.zzba
    public final String a(String str) throws NonceLoaderException {
        try {
            return Base64.encodeToString(this.f37533a.zza(str.getBytes("UTF-8"), new byte[0]), 10);
        } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException e2) {
            Log.e("NonceGenerator", "Failed to encrypt the string.", e2);
            throw new NonceLoaderException(204, e2);
        }
    }
}
