package com.google.android.gms.internal.pal;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import javax.crypto.Mac;

/* loaded from: classes4.dex */
final class zzom implements zzoc {

    /* renamed from: a, reason: collision with root package name */
    public final zznx f37982a;

    /* renamed from: b, reason: collision with root package name */
    public final int f37983b;

    public zzom(zznx zznxVar, int i2) {
        this.f37982a = zznxVar;
        this.f37983b = i2;
    }

    public static zzom b(int i2) {
        int i3 = i2 - 1;
        return i3 != 0 ? i3 != 1 ? new zzom(new zznx("HmacSha512"), 3) : new zzom(new zznx("HmacSha384"), 2) : new zzom(new zznx("HmacSha256"), 1);
    }

    @Override // com.google.android.gms.internal.pal.zzoc
    public final zzod a(byte[] bArr) throws IllegalStateException, GeneralSecurityException {
        int i2 = this.f37983b;
        ECParameterSpec eCParameterSpecG = zzxx.g(i2);
        KeyPairGenerator keyPairGenerator = (KeyPairGenerator) zzxz.f38144h.a("EC");
        keyPairGenerator.initialize(eCParameterSpecG);
        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        byte[] bArrD = zzxx.d((ECPrivateKey) keyPairGenerateKeyPair.getPrivate(), zzxx.f(zzxx.g(i2), bArr));
        byte[] bArrH = zzxx.h(zzxx.g(i2).getCurve(), 1, ((ECPublicKey) keyPairGenerateKeyPair.getPublic()).getW());
        byte[] bArrC = zzxo.c(bArrH, bArr);
        byte[] bArrC2 = zzxo.c(zzol.f37981m, zzb());
        zznx zznxVar = this.f37982a;
        int macLength = Mac.getInstance(zznxVar.f37954a).getMacLength();
        Charset charset = StandardCharsets.UTF_8;
        byte[] bytes = "eae_prk".getBytes(charset);
        byte[] bArr2 = zzol.o;
        return new zzod(zznxVar.b(macLength, zznxVar.c(zzxo.c(bArr2, bArrC2, bytes, bArrD), null), zzxo.c(zzol.b(2, macLength), bArr2, bArrC2, "shared_secret".getBytes(charset), bArrC)), bArrH);
    }

    @Override // com.google.android.gms.internal.pal.zzoc
    public final byte[] zzb() {
        int i2 = this.f37983b - 1;
        return i2 != 0 ? i2 != 1 ? zzol.f37973e : zzol.f37972d : zzol.f37971c;
    }
}
