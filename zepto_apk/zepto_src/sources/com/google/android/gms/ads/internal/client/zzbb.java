package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzblu;
import com.google.android.gms.internal.ads.zzblv;
import com.google.android.gms.internal.ads.zzbwv;
import com.google.android.gms.internal.ads.zzcar;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes4.dex */
public final class zzbb {

    /* renamed from: g, reason: collision with root package name */
    public static final zzbb f21141g = new zzbb();

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.client.zzf f21142a;

    /* renamed from: b, reason: collision with root package name */
    public final zzaz f21143b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f21144c;

    /* renamed from: d, reason: collision with root package name */
    public final VersionInfoParcel f21145d;

    /* renamed from: e, reason: collision with root package name */
    public final Random f21146e;

    /* renamed from: f, reason: collision with root package name */
    public final String f21147f;

    public zzbb() throws NoSuchAlgorithmException {
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = new com.google.android.gms.ads.internal.util.client.zzf();
        zzk zzkVar = new zzk();
        zzi zziVar = new zzi();
        zzff zzffVar = new zzff();
        zzblu zzbluVar = new zzblu();
        new zzcar();
        zzaz zzazVar = new zzaz(zzkVar, zziVar, zzffVar, zzbluVar, new zzbwv(), new zzblv(), new zzl());
        VersionInfoParcel versionInfoParcel = new VersionInfoParcel(0, ModuleDescriptor.MODULE_VERSION, true, false);
        Random random = new Random();
        UUID uuidRandomUUID = UUID.randomUUID();
        byte[] byteArray = BigInteger.valueOf(uuidRandomUUID.getLeastSignificantBits()).toByteArray();
        byte[] byteArray2 = BigInteger.valueOf(uuidRandomUUID.getMostSignificantBits()).toByteArray();
        String string = new BigInteger(1, byteArray).toString();
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                messageDigest.update(byteArray);
                messageDigest.update(byteArray2);
                byte[] bArr = new byte[8];
                System.arraycopy(messageDigest.digest(), 0, bArr, 0, 8);
                string = new BigInteger(1, bArr).toString();
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        this.f21142a = zzfVar;
        this.f21143b = zzazVar;
        this.f21144c = false;
        this.f21145d = versionInfoParcel;
        this.f21146e = random;
        this.f21147f = string;
    }

    public static void a() {
        f21141g.f21144c = false;
    }
}
