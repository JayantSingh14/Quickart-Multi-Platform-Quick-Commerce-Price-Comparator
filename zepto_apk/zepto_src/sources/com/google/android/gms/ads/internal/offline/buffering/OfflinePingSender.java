package com.google.android.gms.ads.internal.offline.buffering;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbsv;
import com.google.android.gms.internal.ads.zzbwr;

@KeepForSdk
/* loaded from: classes4.dex */
public class OfflinePingSender extends Worker {

    /* renamed from: f, reason: collision with root package name */
    public final zzbwr f21310f;

    public OfflinePingSender(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f21310f = zzbb.f21141g.f21143b.j(context, new zzbsv());
    }

    @Override // androidx.work.Worker
    @NonNull
    public final ListenableWorker.Result doWork() {
        try {
            this.f21310f.zzg();
            return new ListenableWorker.Result.Success();
        } catch (RemoteException unused) {
            return new ListenableWorker.Result.Failure();
        }
    }
}
