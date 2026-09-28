package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$OnChecksumsReadyListener;
import android.os.Build;
import in.juspay.hyper.constants.LogSubCategory;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class zziv extends zzjv {
    private static final zzjw zzi = new zzjw();
    private final Context zzj;

    public zziv(zzih zzihVar, String str, String str2, zzaf zzafVar, int i2, int i3, Context context, zzy zzyVar) {
        super(zzihVar, "iz9pI8M74OdFMOjBXhk6CVKK/c29GtinDT3TfbuphLdYOSnoV+Rg8WuW9whaa7rD", "AMztxBQmasdCMrU1nlH2RhtlfSPsjcYFxTHFmKvCDYM=", zzafVar, i2, 27);
        this.zzj = context;
    }

    private final String zzc() throws ExecutionException, InterruptedException {
        try {
            if (this.zzb.zzl() != null) {
                this.zzb.zzl().get();
            }
            zzbc zzbcVarZzc = this.zzb.zzc();
            if (zzbcVarZzc == null || !zzbcVarZzc.zzaj()) {
                return null;
            }
            return zzbcVarZzc.zzg();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzjv
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        int i2;
        zzfp zzfpVar;
        AtomicReference atomicReferenceZza = zzi.zza(this.zzj.getPackageName());
        synchronized (atomicReferenceZza) {
            try {
                zzfp zzfpVar2 = (zzfp) atomicReferenceZza.get();
                if (zzfpVar2 == null || zzik.zzd(zzfpVar2.zza) || zzfpVar2.zza.equals("E") || zzfpVar2.zza.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                    if (zzik.zzd(null)) {
                        zzik.zzd(null);
                        i2 = 3;
                    } else {
                        i2 = 5;
                    }
                    Boolean boolValueOf = Boolean.valueOf(i2 == 3);
                    Boolean bool = (Boolean) zzkq.zzc().zza(zzlg.zzcp);
                    String strZzb = ((Boolean) zzkq.zzc().zza(zzlg.zzco)).booleanValue() ? zzb() : null;
                    if (bool.booleanValue() && this.zzb.zzp() && zzik.zzd(strZzb)) {
                        strZzb = zzc();
                    }
                    zzfp zzfpVar3 = new zzfp((String) this.zzf.invoke(null, this.zzj, boolValueOf, strZzb));
                    if (zzik.zzd(zzfpVar3.zza) || zzfpVar3.zza.equals("E")) {
                        int i3 = i2 - 1;
                        if (i3 == 3) {
                            String strZzc = zzc();
                            if (!zzik.zzd(strZzc)) {
                                zzfpVar3.zza = strZzc;
                            }
                        } else if (i3 == 4) {
                            throw null;
                        }
                    }
                    atomicReferenceZza.set(zzfpVar3);
                }
                zzfpVar = (zzfp) atomicReferenceZza.get();
            } finally {
            }
        }
        synchronized (this.zze) {
            if (zzfpVar != null) {
                try {
                    this.zze.zzx(zzfpVar.zza);
                    this.zze.zzX(zzfpVar.zzb);
                    this.zze.zzZ(zzfpVar.zzc);
                    this.zze.zzi(zzfpVar.zzd);
                    this.zze.zzw(zzfpVar.zze);
                } finally {
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.google.ads.interactivemedia.v3.internal.zzjx] */
    public final String zzb() throws PackageManager.NameNotFoundException, CertificateException {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            byte[] bArrZzf = zzik.zzf((String) zzkq.zzc().zza(zzlg.zzcq));
            ArrayList arrayList = new ArrayList();
            arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(bArrZzf)));
            if (!Build.TYPE.equals(LogSubCategory.Action.USER)) {
                arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(zzik.zzf((String) zzkq.zzc().zza(zzlg.zzcr)))));
            }
            Context context = this.zzj;
            String packageName = context.getPackageName();
            this.zzb.zzk();
            if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals("S")) {
                return null;
            }
            final zzth zzthVarZzp = zzth.zzp();
            context.getPackageManager().requestChecksums(packageName, false, 8, arrayList, new PackageManager$OnChecksumsReadyListener() { // from class: com.google.ads.interactivemedia.v3.internal.zzjx
                public final void onChecksumsReady(List list) {
                    zzth zzthVar = zzthVarZzp;
                    if (list == null) {
                        zzthVar.zzc(null);
                        return;
                    }
                    try {
                        int size = list.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            ApkChecksum apkChecksumC = com.facebook.hermes.intl.a.c(list.get(i2));
                            if (apkChecksumC.getType() == 8) {
                                zzthVar.zzc(zzik.zzb(apkChecksumC.getValue()));
                                return;
                            }
                        }
                        zzthVar.zzc(null);
                    } catch (Throwable unused) {
                        zzthVar.zzc(null);
                    }
                }
            });
            return (String) zzthVarZzp.get();
        } catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException unused) {
            return null;
        }
    }
}
