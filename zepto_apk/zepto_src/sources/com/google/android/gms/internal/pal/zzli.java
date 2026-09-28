package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes4.dex */
public final class zzli {

    /* renamed from: a, reason: collision with root package name */
    public static final String f37919a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f37920b;

    static {
        new zzlo();
        f37919a = "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
        new zzlx();
        f37920b = "type.googleapis.com/google.crypto.tink.AesGcmKey";
        new zzma();
        new zzlu();
        new zzmg();
        new zzmk();
        new zzmd();
        new zzmn();
        int i2 = zzwx.f38103a;
        try {
            a();
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void a() throws NoSuchPaddingException, NoSuchAlgorithmException {
        zzlf.f(new zzll());
        zzqs.a();
        zzlf.e(new zzlo());
        zzlf.e(new zzlx());
        if (zznb.a()) {
            return;
        }
        zzlf.e(new zzlu());
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            zzlf.e(new zzma());
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
        }
        zzlf.e(new zzmd());
        zzlf.e(new zzmg());
        zzlf.e(new zzmk());
        zzlf.e(new zzmn());
    }
}
