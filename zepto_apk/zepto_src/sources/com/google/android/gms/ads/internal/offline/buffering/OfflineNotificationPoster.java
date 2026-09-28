package com.google.android.gms.ads.internal.offline.buffering;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbsv;
import com.google.android.gms.internal.ads.zzbwr;

@KeepForSdk
/* loaded from: classes4.dex */
public class OfflineNotificationPoster extends Worker {

    /* renamed from: f, reason: collision with root package name */
    public final zzbwr f21309f;

    public OfflineNotificationPoster(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f21309f = zzbb.f21141g.f21143b.j(context, new zzbsv());
    }

    @Override // androidx.work.Worker
    @NonNull
    public final ListenableWorker.Result doWork() {
        try {
            this.f21309f.Bb(new ObjectWrapper(getApplicationContext()), new zza(getInputData().b("uri"), getInputData().b("gws_query_id"), getInputData().b("image_url")));
            return new ListenableWorker.Result.Success();
        } catch (RemoteException unused) {
            return new ListenableWorker.Result.Failure();
        }
    }
}
