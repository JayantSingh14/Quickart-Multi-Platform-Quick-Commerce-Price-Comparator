package com.google.android.gms.internal.ads;

import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public final class zzhws implements zzham {

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f34432e = {0};

    /* renamed from: a, reason: collision with root package name */
    public final zzhmn f34433a;

    /* renamed from: b, reason: collision with root package name */
    public final int f34434b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f34435c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f34436d;

    public zzhws(zzhkn zzhknVar) {
        this.f34433a = zzhwp.b(zzhml.c(zzhmm.b(zzhknVar.f33936a.f33955a), zzhknVar.f33937b));
        zzhku zzhkuVar = zzhknVar.f33936a;
        this.f34434b = zzhkuVar.f33956b;
        this.f34435c = zzhknVar.f33938c.b();
        if (zzhkuVar.f33957c.equals(zzhkt.f33952d)) {
            this.f34436d = Arrays.copyOf(f34432e, 1);
        } else {
            this.f34436d = new byte[0];
        }
    }

    public zzhws(zzhkz zzhkzVar) {
        String strValueOf = String.valueOf(zzhkzVar.f33962a.f33995d);
        this.f34433a = new zzhwr("HMAC".concat(strValueOf), new SecretKeySpec(zzhkzVar.f33963b.f34463a.b(), "HMAC"));
        zzhli zzhliVar = zzhkzVar.f33962a;
        this.f34434b = zzhliVar.f33993b;
        this.f34435c = zzhkzVar.f33964c.b();
        if (zzhliVar.f33994c.equals(zzhlh.f33989d)) {
            this.f34436d = Arrays.copyOf(f34432e, 1);
        } else {
            this.f34436d = new byte[0];
        }
    }

    public zzhws(zzhwr zzhwrVar, int i2) throws IllegalStateException, InvalidAlgorithmParameterException {
        this.f34433a = zzhwrVar;
        this.f34434b = i2;
        this.f34435c = new byte[0];
        this.f34436d = new byte[0];
        zzhwrVar.a(i2, new byte[0]);
    }
}
