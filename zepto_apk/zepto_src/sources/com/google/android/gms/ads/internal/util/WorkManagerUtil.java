package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.CancelWorkRunnable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.ads.internal.offline.buffering.OfflineNotificationPoster;
import com.google.android.gms.ads.internal.offline.buffering.OfflinePingSender;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import kotlin.jvm.internal.Intrinsics;

@KeepForSdk
/* loaded from: classes4.dex */
public class WorkManagerUtil extends zzbn {
    @UsedByReflection("This class must be instantiated reflectively so that the default class loader can be used.")
    public WorkManagerUtil() {
    }

    public static void Xb(Context context) {
        try {
            WorkManagerImpl.g(context.getApplicationContext(), new Configuration(new Configuration.Builder()));
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzbo
    public final boolean zze(@NonNull IObjectWrapper iObjectWrapper, @NonNull String str, @NonNull String str2) {
        return zzg(iObjectWrapper, new com.google.android.gms.ads.internal.offline.buffering.zza(str, str2, ""));
    }

    @Override // com.google.android.gms.ads.internal.util.zzbo
    public final void zzf(@NonNull IObjectWrapper iObjectWrapper) {
        Context context = (Context) ObjectWrapper.z0(iObjectWrapper);
        Xb(context);
        try {
            WorkManagerImpl workManagerImplF = WorkManagerImpl.f(context);
            workManagerImplF.getClass();
            workManagerImplF.f12656d.c(CancelWorkRunnable.d(workManagerImplF, "offline_ping_sender_work"));
            Constraints.Builder builder = new Constraints.Builder();
            NetworkType networkType = NetworkType.f12537b;
            Intrinsics.checkNotNullParameter(networkType, "networkType");
            builder.f12495a = networkType;
            Constraints constraintsA = builder.a();
            Intrinsics.checkNotNullParameter(OfflinePingSender.class, "workerClass");
            workManagerImplF.b((OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(OfflinePingSender.class).e(constraintsA)).a("offline_ping_sender_work")).b());
        } catch (IllegalStateException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to instantiate WorkManager.", e2);
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzbo
    public final boolean zzg(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.offline.buffering.zza zzaVar) throws Throwable {
        Context context = (Context) ObjectWrapper.z0(iObjectWrapper);
        Xb(context);
        Constraints.Builder builder = new Constraints.Builder();
        NetworkType networkType = NetworkType.f12537b;
        Intrinsics.checkNotNullParameter(networkType, "networkType");
        builder.f12495a = networkType;
        Constraints constraintsA = builder.a();
        Data.Builder builder2 = new Data.Builder();
        builder2.c("uri", zzaVar.f21311a);
        builder2.c("gws_query_id", zzaVar.f21312b);
        builder2.c("image_url", zzaVar.f21313c);
        Data dataA = builder2.a();
        Intrinsics.checkNotNullParameter(OfflineNotificationPoster.class, "workerClass");
        try {
            WorkManagerImpl.f(context).b((OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(OfflineNotificationPoster.class).e(constraintsA)).g(dataA)).a("offline_notification_work")).b());
            return true;
        } catch (IllegalStateException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to instantiate WorkManager.", e2);
            return false;
        }
    }
}
