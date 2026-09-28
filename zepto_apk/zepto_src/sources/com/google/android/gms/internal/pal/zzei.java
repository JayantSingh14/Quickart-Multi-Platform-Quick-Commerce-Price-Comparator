package com.google.android.gms.internal.pal;

import android.content.Context;
import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$OnChecksumsReadyListener;
import android.os.Build;
import in.juspay.hyper.constants.LogSubCategory;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class zzei extends zzfg {

    /* renamed from: j, reason: collision with root package name */
    public static final zzfh f37691j = new zzfh();

    /* renamed from: h, reason: collision with root package name */
    public final Context f37692h;

    /* renamed from: i, reason: collision with root package name */
    public final zzi f37693i;

    public zzei(zzdu zzduVar, zzr zzrVar, int i2, Context context, zzi zziVar) {
        super(zzduVar, "hhtrMjcGMTQSGdrv1+l2gakNTe0Pfchc8VT5kRHtsehlafuJ8JEE4iewNV4y5I/U", "o5W1eROpLyVNcsDGW3Y0lGc2x/V+mDPvMXouv3gbW6M=", zzrVar, i2, 27);
        this.f37692h = context;
        this.f37693i = zziVar;
    }

    @Override // com.google.android.gms.internal.pal.zzfg
    public final void a() {
        Boolean boolValueOf;
        int i2;
        zzbk zzbkVar;
        AtomicReference atomicReferenceA = f37691j.a(this.f37692h.getPackageName());
        synchronized (atomicReferenceA) {
            try {
                zzbk zzbkVar2 = (zzbk) atomicReferenceA.get();
                if (zzbkVar2 == null || zzdx.c(zzbkVar2.f37542a) || zzbkVar2.f37542a.equals("E") || zzbkVar2.f37542a.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                    zzi zziVar = this.f37693i;
                    boolean z = true;
                    if (zzdx.c((zziVar == null || !zziVar.t() || zzdx.c(zziVar.r().q())) ? null : zziVar.r().q())) {
                        zzi zziVar2 = this.f37693i;
                        if (zzdx.c((zziVar2 == null || !zziVar2.t() || zzdx.c(zziVar2.r().q())) ? null : zziVar2.r().q())) {
                            boolValueOf = Boolean.valueOf(zziVar2 != null && zziVar2.s() && zziVar2.q().q() == 4);
                        } else {
                            boolValueOf = Boolean.FALSE;
                        }
                        i2 = (boolValueOf.booleanValue() && this.f37723a.n) ? 4 : 3;
                    } else {
                        i2 = 5;
                    }
                    if (i2 != 3) {
                        z = false;
                    }
                    Boolean boolValueOf2 = Boolean.valueOf(z);
                    zzgc zzgcVar = zzgk.f37765b;
                    zzfv zzfvVar = zzfv.f37741d;
                    Boolean bool = (Boolean) zzfvVar.f37744c.a(zzgcVar);
                    String strC = ((Boolean) zzfvVar.f37744c.a(zzgk.f37764a)).booleanValue() ? c() : null;
                    if (bool.booleanValue() && this.f37723a.n && zzdx.c(strC)) {
                        strC = d();
                    }
                    zzbk zzbkVar3 = new zzbk((String) this.f37727e.invoke(null, this.f37692h, boolValueOf2, strC));
                    if (zzdx.c(zzbkVar3.f37542a) || zzbkVar3.f37542a.equals("E")) {
                        int i3 = i2 - 1;
                        if (i3 == 3) {
                            String strD = d();
                            if (!zzdx.c(strD)) {
                                zzbkVar3.f37542a = strD;
                            }
                        } else if (i3 == 4) {
                            zzbkVar3.f37542a = this.f37693i.r().q();
                        }
                    }
                    atomicReferenceA.set(zzbkVar3);
                }
                zzbkVar = (zzbk) atomicReferenceA.get();
            } finally {
            }
        }
        synchronized (this.f37726d) {
            if (zzbkVar != null) {
                try {
                    zzr zzrVar = this.f37726d;
                    String str = zzbkVar.f37542a;
                    if (zzrVar.f37406c) {
                        zzrVar.k();
                        zzrVar.f37406c = false;
                    }
                    zzaf.y0((zzaf) zzrVar.f37405b, str);
                    zzr zzrVar2 = this.f37726d;
                    long j2 = zzbkVar.f37543b;
                    if (zzrVar2.f37406c) {
                        zzrVar2.k();
                        zzrVar2.f37406c = false;
                    }
                    zzaf.p((zzaf) zzrVar2.f37405b, j2);
                    zzr zzrVar3 = this.f37726d;
                    String str2 = zzbkVar.f37544c;
                    if (zzrVar3.f37406c) {
                        zzrVar3.k();
                        zzrVar3.f37406c = false;
                    }
                    zzaf.D0((zzaf) zzrVar3.f37405b, str2);
                    zzr zzrVar4 = this.f37726d;
                    String str3 = zzbkVar.f37545d;
                    if (zzrVar4.f37406c) {
                        zzrVar4.k();
                        zzrVar4.f37406c = false;
                    }
                    zzaf.y((zzaf) zzrVar4.f37405b, str3);
                    zzr zzrVar5 = this.f37726d;
                    String str4 = zzbkVar.f37546e;
                    if (zzrVar5.f37406c) {
                        zzrVar5.k();
                        zzrVar5.f37406c = false;
                    }
                    zzaf.z((zzaf) zzrVar5.f37405b, str4);
                } finally {
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [com.google.android.gms.internal.pal.zzfi] */
    public final String c() throws PackageManager.NameNotFoundException, CertificateException {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            zzgc zzgcVar = zzgk.f37766c;
            zzfv zzfvVar = zzfv.f37741d;
            byte[] bArrD = zzdx.d((String) zzfvVar.f37744c.a(zzgcVar));
            ArrayList arrayList = new ArrayList();
            arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(bArrD)));
            if (!Build.TYPE.equals(LogSubCategory.Action.USER)) {
                arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(zzdx.d((String) zzfvVar.f37744c.a(zzgk.f37767d)))));
            }
            Context context = this.f37692h;
            String packageName = context.getPackageName();
            this.f37723a.getClass();
            if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals("S")) {
                return null;
            }
            final zzjr zzjrVar = new zzjr();
            context.getPackageManager().requestChecksums(packageName, false, 8, arrayList, new PackageManager$OnChecksumsReadyListener() { // from class: com.google.android.gms.internal.pal.zzfi
                public final void onChecksumsReady(List list) {
                    zzjr zzjrVar2 = zzjrVar;
                    if (list == null) {
                        zzjrVar2.f(null);
                        return;
                    }
                    try {
                        int size = list.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            ApkChecksum apkChecksumC = com.facebook.hermes.intl.a.c(list.get(i2));
                            if (apkChecksumC.getType() == 8) {
                                byte[] value = apkChecksumC.getValue();
                                char[] cArr = zzdx.f37659a;
                                int length = value.length;
                                char[] cArr2 = new char[length + length];
                                for (int i3 = 0; i3 < value.length; i3++) {
                                    byte b2 = value[i3];
                                    int i4 = i3 + i3;
                                    char[] cArr3 = zzdx.f37659a;
                                    cArr2[i4] = cArr3[(b2 & 255) >>> 4];
                                    cArr2[i4 + 1] = cArr3[b2 & 15];
                                }
                                zzjrVar2.f(new String(cArr2));
                                return;
                            }
                        }
                        zzjrVar2.f(null);
                    } catch (Throwable unused) {
                        zzjrVar2.f(null);
                    }
                }
            });
            return (String) zzjrVar.get();
        } catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException unused) {
            return null;
        }
    }

    public final String d() throws ExecutionException, InterruptedException {
        try {
            Future future = this.f37723a.f37644k;
            if (future != null) {
                future.get();
            }
            zzaf zzafVar = this.f37723a.f37643j;
            if (zzafVar == null || !zzafVar.Z()) {
                return null;
            }
            return zzafVar.j0();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }
}
