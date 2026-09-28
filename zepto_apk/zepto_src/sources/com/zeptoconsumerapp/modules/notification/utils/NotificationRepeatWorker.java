package com.zeptoconsumerapp.modules.notification.utils;

import android.content.Context;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class NotificationRepeatWorker extends Worker {

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationRepeatWorker(@NotNull Context context, @NotNull WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    @Override // androidx.work.Worker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.work.ListenableWorker.Result doWork() {
        /*
            r8 = this;
            java.lang.String r0 = "data"
            java.lang.String r1 = "z_r_t"
            androidx.work.Data r2 = r8.getInputData()     // Catch: java.lang.Exception -> Lf0
            java.lang.String r3 = "notification_data"
            java.lang.String r2 = r2.b(r3)     // Catch: java.lang.Exception -> Lf0
            if (r2 == 0) goto Le5
            int r3 = r2.length()     // Catch: java.lang.Exception -> Lf0
            if (r3 != 0) goto L18
            goto Le5
        L18:
            java.util.HashMap r2 = com.zeptoconsumerapp.modules.utils.JsonUtils.a(r2)     // Catch: java.lang.Exception -> Lf0
            java.util.LinkedHashMap r2 = kotlin.collections.MapsKt.n(r2)     // Catch: java.lang.Exception -> Lf0
            com.zeptoconsumerapp.modules.notification.constants.NotificationConfig[] r3 = com.zeptoconsumerapp.modules.notification.constants.NotificationConfig.f47662a     // Catch: java.lang.Exception -> Lf0
            java.lang.String r3 = "z_ong_et"
            java.lang.Long r3 = com.zeptoconsumerapp.modules.notification.utils.NotificationDataUtils.c(r3, r2)     // Catch: java.lang.Exception -> Lf0
            if (r3 == 0) goto L41
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> Lf0
            long r6 = r3.longValue()     // Catch: java.lang.Exception -> Lf0
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 < 0) goto L41
            androidx.work.ListenableWorker$Result$Success r0 = new androidx.work.ListenableWorker$Result$Success     // Catch: java.lang.Exception -> Lf0
            r0.<init>()     // Catch: java.lang.Exception -> Lf0
            java.lang.String r1 = "success(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.Exception -> Lf0
            return r0
        L41:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)     // Catch: java.lang.Exception -> Lf0
            java.lang.String r3 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)     // Catch: java.lang.Exception -> Lf0
            java.lang.Object r3 = r2.get(r1)     // Catch: java.lang.Exception -> Lf0
            boolean r4 = r3 instanceof java.lang.String     // Catch: java.lang.Exception -> Lf0
            if (r4 == 0) goto L5e
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Exception -> Lf0
            java.lang.Integer r3 = kotlin.text.StringsKt.toIntOrNull(r3)     // Catch: java.lang.Exception -> Lf0
            if (r3 == 0) goto L69
            int r3 = r3.intValue()     // Catch: java.lang.Exception -> Lf0
            goto L6a
        L5e:
            boolean r4 = r3 instanceof java.lang.Number     // Catch: java.lang.Exception -> Lf0
            if (r4 == 0) goto L69
            java.lang.Number r3 = (java.lang.Number) r3     // Catch: java.lang.Exception -> Lf0
            int r3 = r3.intValue()     // Catch: java.lang.Exception -> Lf0
            goto L6a
        L69:
            r3 = 0
        L6a:
            int r3 = r3 + (-1)
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Exception -> Lf0
            r2.put(r1, r3)     // Catch: java.lang.Exception -> Lf0
            java.lang.String r1 = "_isRepeated"
            java.lang.String r3 = "true"
            r2.put(r1, r3)     // Catch: java.lang.Exception -> Lf0
            com.zeptoconsumerapp.modules.notification.factory.NotificationTemplateFactory$Builder r1 = new com.zeptoconsumerapp.modules.notification.factory.NotificationTemplateFactory$Builder     // Catch: java.lang.Exception -> Lf0
            r1.<init>()     // Catch: java.lang.Exception -> Lf0
            android.content.Context r3 = r8.getApplicationContext()     // Catch: java.lang.Exception -> Lf0
            java.lang.String r4 = "getApplicationContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch: java.lang.Exception -> Lf0
            java.lang.String r4 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)     // Catch: java.lang.Exception -> Lf0
            r1.f47675a = r3     // Catch: java.lang.Exception -> Lf0
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap     // Catch: java.lang.Exception -> Lf0
            int r4 = r2.size()     // Catch: java.lang.Exception -> Lf0
            int r4 = kotlin.collections.MapsKt.f(r4)     // Catch: java.lang.Exception -> Lf0
            r3.<init>(r4)     // Catch: java.lang.Exception -> Lf0
            java.util.Set r2 = r2.entrySet()     // Catch: java.lang.Exception -> Lf0
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Exception -> Lf0
        La4:
            boolean r4 = r2.hasNext()     // Catch: java.lang.Exception -> Lf0
            if (r4 == 0) goto Lc3
            java.lang.Object r4 = r2.next()     // Catch: java.lang.Exception -> Lf0
            r5 = r4
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch: java.lang.Exception -> Lf0
            java.lang.Object r5 = r5.getKey()     // Catch: java.lang.Exception -> Lf0
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch: java.lang.Exception -> Lf0
            java.lang.Object r4 = r4.getValue()     // Catch: java.lang.Exception -> Lf0
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Exception -> Lf0
            r3.put(r5, r4)     // Catch: java.lang.Exception -> Lf0
            goto La4
        Lc3:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)     // Catch: java.lang.Exception -> Lf0
            r1.f47676b = r3     // Catch: java.lang.Exception -> Lf0
            com.zeptoconsumerapp.modules.notification.factory.NotificationTemplateFactory$NotificationHandler r0 = r1.a()     // Catch: java.lang.Exception -> Lf0
            android.content.Context r1 = r0.f47677a     // Catch: java.lang.Exception -> Lf0
            if (r1 != 0) goto Ld1
            goto Ldf
        Ld1:
            android.app.Notification r2 = r0.f47678b     // Catch: java.lang.Exception -> Lf0
            if (r2 == 0) goto Ldf
            androidx.core.app.NotificationManagerCompat r3 = new androidx.core.app.NotificationManagerCompat     // Catch: java.lang.Exception -> Lf0
            r3.<init>(r1)     // Catch: java.lang.Exception -> Lf0
            int r0 = r0.f47679c     // Catch: java.lang.Exception -> Lf0
            r3.d(r0, r2)     // Catch: java.lang.Exception -> Lf0
        Ldf:
            androidx.work.ListenableWorker$Result$Success r0 = new androidx.work.ListenableWorker$Result$Success     // Catch: java.lang.Exception -> Lf0
            r0.<init>()     // Catch: java.lang.Exception -> Lf0
            return r0
        Le5:
            androidx.work.ListenableWorker$Result$Failure r0 = new androidx.work.ListenableWorker$Result$Failure     // Catch: java.lang.Exception -> Lf0
            r0.<init>()     // Catch: java.lang.Exception -> Lf0
            java.lang.String r1 = "failure(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.Exception -> Lf0
            return r0
        Lf0:
            androidx.work.ListenableWorker$Result$Failure r0 = new androidx.work.ListenableWorker$Result$Failure
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.modules.notification.utils.NotificationRepeatWorker.doWork():androidx.work.ListenableWorker$Result");
    }
}
