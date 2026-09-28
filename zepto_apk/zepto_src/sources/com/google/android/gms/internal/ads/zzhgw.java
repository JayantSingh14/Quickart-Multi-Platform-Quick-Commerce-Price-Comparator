package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhgw implements zzhfn {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhgw f33778a = new zzhgw();

    public final /* synthetic */ Cipher a() {
        try {
            Cipher cipher = (Cipher) zzhgx.f33779a.get();
            if (cipher != null) {
                return cipher;
            }
            throw new GeneralSecurityException("AES GCM SIV cipher is invalid.");
        } catch (IllegalStateException e2) {
            throw new GeneralSecurityException("AES GCM SIV cipher is not available or is invalid.", e2);
        }
    }
}
