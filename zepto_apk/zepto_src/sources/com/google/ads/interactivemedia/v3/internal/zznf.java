package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class zznf {
    private final Context zza;
    private final Executor zzb;
    private final zzmo zzc;
    private final zzmq zzd;
    private final zzne zze;
    private final zzne zzf;
    private Task zzg;
    private Task zzh;

    @VisibleForTesting
    public zznf(Context context, Executor executor, zzmo zzmoVar, zzmq zzmqVar, zznc zzncVar, zznd zzndVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzmoVar;
        this.zzd = zzmqVar;
        this.zze = zzncVar;
        this.zzf = zzndVar;
    }

    public static zznf zze(@NonNull Context context, @NonNull Executor executor, @NonNull zzmo zzmoVar, @NonNull zzmq zzmqVar) {
        final zznf zznfVar = new zznf(context, executor, zzmoVar, zzmqVar, new zznc(), new zznd());
        if (zznfVar.zzd.zzd()) {
            zznfVar.zzg = zznfVar.zzh(new Callable() { // from class: com.google.ads.interactivemedia.v3.internal.zzmz
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzc();
                }
            });
        } else {
            zznfVar.zzg = Tasks.e(zznfVar.zze.zza());
        }
        zznfVar.zzh = zznfVar.zzh(new Callable() { // from class: com.google.ads.interactivemedia.v3.internal.zzna
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzd();
            }
        });
        return zznfVar;
    }

    private static zzbc zzg(@NonNull Task task, @NonNull zzbc zzbcVar) {
        return !task.p() ? zzbcVar : (zzbc) task.l();
    }

    private final Task zzh(@NonNull Callable callable) {
        Task taskC = Tasks.c(callable, this.zzb);
        taskC.d(this.zzb, new OnFailureListener() { // from class: com.google.ads.interactivemedia.v3.internal.zznb
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.zza.zzf(exc);
            }
        });
        return taskC;
    }

    public final zzbc zza() {
        return zzg(this.zzg, this.zze.zza());
    }

    public final zzbc zzb() {
        return zzg(this.zzh, this.zzf.zza());
    }

    public final zzbc zzc() throws Exception {
        zzaf zzafVarZza = zzbc.zza();
        AdvertisingIdClient.Info infoA = AdvertisingIdClient.a(this.zza);
        String strEncodeToString = infoA.f21070a;
        if (strEncodeToString != null && strEncodeToString.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            UUID uuidFromString = UUID.fromString(strEncodeToString);
            byte[] bArr = new byte[16];
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            byteBufferWrap.putLong(uuidFromString.getMostSignificantBits());
            byteBufferWrap.putLong(uuidFromString.getLeastSignificantBits());
            strEncodeToString = Base64.encodeToString(bArr, 11);
        }
        if (strEncodeToString != null) {
            zzafVarZza.zzs(strEncodeToString);
            zzafVarZza.zzr(infoA.f21071b);
            zzafVarZza.zzab(6);
        }
        return (zzbc) zzafVarZza.zzan();
    }

    public final /* synthetic */ zzbc zzd() throws Exception {
        Context context = this.zza;
        return zzmw.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }

    public final /* synthetic */ void zzf(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzc.zzc(2025, -1L, exc);
    }
}
