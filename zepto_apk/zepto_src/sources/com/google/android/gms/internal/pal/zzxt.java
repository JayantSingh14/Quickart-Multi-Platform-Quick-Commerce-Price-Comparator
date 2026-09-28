package com.google.android.gms.internal.pal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public final class zzxt implements zzjy {

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f38127f = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    public final zzxw f38128a;

    /* renamed from: b, reason: collision with root package name */
    public final String f38129b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f38130c;

    /* renamed from: d, reason: collision with root package name */
    public final zzxr f38131d;

    /* renamed from: e, reason: collision with root package name */
    public final int f38132e;

    public zzxt(ECPublicKey eCPublicKey, byte[] bArr, String str, int i2, zzxr zzxrVar) throws GeneralSecurityException {
        zzxx.b(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.f38128a = new zzxw(eCPublicKey);
        this.f38130c = bArr;
        this.f38129b = str;
        this.f38132e = i2;
        this.f38131d = zzxrVar;
    }

    @Override // com.google.android.gms.internal.pal.zzjy
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws IllegalStateException, GeneralSecurityException {
        zzoq zzoqVar;
        zzxr zzxrVar = this.f38131d;
        int i2 = ((zznu) zzxrVar).f37948b;
        ECPublicKey eCPublicKey = this.f38128a.f38135a;
        ECParameterSpec params = eCPublicKey.getParams();
        KeyPairGenerator keyPairGenerator = (KeyPairGenerator) zzxz.f38144h.a("EC");
        keyPairGenerator.initialize(params);
        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        ECPublicKey eCPublicKey2 = (ECPublicKey) keyPairGenerateKeyPair.getPublic();
        byte[] bArrD = zzxx.d((ECPrivateKey) keyPairGenerateKeyPair.getPrivate(), eCPublicKey);
        byte[] bArrH = zzxx.h(eCPublicKey2.getParams().getCurve(), this.f38132e, eCPublicKey2.getW());
        byte[] bArrC = zzxo.c(bArrH, bArrD);
        zzxz zzxzVar = zzxz.f38142f;
        String str = this.f38129b;
        Mac mac = (Mac) zzxzVar.a(str);
        if (i2 > mac.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        byte[] bArr3 = this.f38130c;
        if (bArr3 == null || bArr3.length == 0) {
            mac.init(new SecretKeySpec(new byte[mac.getMacLength()], str));
        } else {
            mac.init(new SecretKeySpec(bArr3, str));
        }
        byte[] bArr4 = new byte[i2];
        mac.init(new SecretKeySpec(mac.doFinal(bArrC), str));
        byte[] bArrDoFinal = new byte[0];
        int i3 = 1;
        int i4 = 0;
        while (true) {
            mac.update(bArrDoFinal);
            mac.update(bArr2);
            mac.update((byte) i3);
            bArrDoFinal = mac.doFinal();
            int length = bArrDoFinal.length;
            int i5 = i4 + length;
            if (i5 >= i2) {
                break;
            }
            System.arraycopy(bArrDoFinal, 0, bArr4, i4, length);
            i3++;
            i4 = i5;
        }
        System.arraycopy(bArrDoFinal, 0, bArr4, i4, i2 - i4);
        zzxv zzxvVar = new zzxv(bArrH, bArr4);
        byte[] bArr5 = zzxvVar.f38134b.f38163a;
        int length2 = bArr5.length;
        byte[] bArr6 = new byte[length2];
        System.arraycopy(bArr5, 0, bArr6, 0, length2);
        zznu zznuVar = (zznu) zzxrVar;
        int i6 = zznuVar.f37948b;
        if (length2 != i6) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        }
        String str2 = zzli.f37920b;
        String str3 = zznuVar.f37947a;
        if (str3.equals(str2)) {
            zzss zzssVarQ = zzst.q();
            zzssVarQ.d(zznuVar.f37949c);
            zzaby zzabyVarQ = zzaby.q(0, bArr6, i6);
            if (zzssVarQ.f37406c) {
                zzssVarQ.k();
                zzssVarQ.f37406c = false;
            }
            ((zzst) zzssVarQ.f37405b).zzf = zzabyVarQ;
            zzoqVar = new zzoq((zzjt) ((zzki) zzlf.f37912b.get()).a(zzjt.class, str3).a((zzst) zzssVarQ.h()));
        } else if (str3.equals(zzli.f37919a)) {
            int i7 = zznuVar.f37951e;
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr6, 0, i7);
            byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr6, i7, i6);
            zzsa zzsaVarQ = zzsb.q();
            zzrv zzrvVar = zznuVar.f37950d;
            zzsaVarQ.d(zzrvVar.s());
            zzaby zzabyVarQ2 = zzaby.q(0, bArrCopyOfRange, bArrCopyOfRange.length);
            if (zzsaVarQ.f37406c) {
                zzsaVarQ.k();
                zzsaVarQ.f37406c = false;
            }
            ((zzsb) zzsaVarQ.f37405b).zzg = zzabyVarQ2;
            zzsb zzsbVar = (zzsb) zzsaVarQ.h();
            zzuo zzuoVarQ = zzup.q();
            zzuoVarQ.d(zzrvVar.t());
            zzaby zzabyVarQ3 = zzaby.q(0, bArrCopyOfRange2, bArrCopyOfRange2.length);
            if (zzuoVarQ.f37406c) {
                zzuoVarQ.k();
                zzuoVarQ.f37406c = false;
            }
            ((zzup) zzuoVarQ.f37405b).zzg = zzabyVarQ3;
            zzup zzupVar = (zzup) zzuoVarQ.h();
            zzru zzruVarQ = zzrv.q();
            int iP = zzrvVar.p();
            if (zzruVarQ.f37406c) {
                zzruVarQ.k();
                zzruVarQ.f37406c = false;
            }
            ((zzrv) zzruVarQ.f37405b).zze = iP;
            if (zzruVarQ.f37406c) {
                zzruVarQ.k();
                zzruVarQ.f37406c = false;
            }
            ((zzrv) zzruVarQ.f37405b).zzf = zzsbVar;
            if (zzruVarQ.f37406c) {
                zzruVarQ.k();
                zzruVarQ.f37406c = false;
            }
            zzrv.w((zzrv) zzruVarQ.f37405b, zzupVar);
            zzoqVar = new zzoq((zzjt) ((zzki) zzlf.f37912b.get()).a(zzjt.class, str3).a((zzrv) zzruVarQ.h()));
        } else {
            if (!str3.equals(zznf.f37940a)) {
                throw new GeneralSecurityException("unknown DEM key type");
            }
            zzte zzteVarQ = zztf.q();
            zzteVarQ.d(zznuVar.f37952f);
            zzaby zzabyVarQ4 = zzaby.q(0, bArr6, i6);
            if (zzteVarQ.f37406c) {
                zzteVarQ.k();
                zzteVarQ.f37406c = false;
            }
            ((zztf) zzteVarQ.f37405b).zzf = zzabyVarQ4;
            zzoqVar = new zzoq((zzjw) ((zzki) zzlf.f37912b.get()).a(zzjw.class, str3).a((zztf) zzteVarQ.h()));
        }
        byte[] bArr7 = f38127f;
        zzjt zzjtVar = zzoqVar.f37985a;
        byte[] bArrZza = zzjtVar != null ? zzjtVar.zza(bArr, bArr7) : zzoqVar.f37986b.zza(bArr, bArr7);
        byte[] bArr8 = zzxvVar.f38133a.f38163a;
        int length3 = bArr8.length;
        byte[] bArr9 = new byte[length3];
        System.arraycopy(bArr8, 0, bArr9, 0, length3);
        return ByteBuffer.allocate(length3 + bArrZza.length).put(bArr9).put(bArrZza).array();
    }
}
