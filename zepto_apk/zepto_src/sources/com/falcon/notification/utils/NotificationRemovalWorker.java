package com.falcon.notification.utils;

import android.content.Context;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.falcon.notification.constants.NotificationConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class NotificationRemovalWorker extends Worker {

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationRemovalWorker(@NotNull Context context, @NotNull WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result doWork() {
        Object next;
        try {
            Object obj = getInputData().f12510a.get("notification_id");
            int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : -1;
            Object obj2 = getInputData().f12510a.get("time_of_creation");
            long jLongValue = obj2 instanceof Long ? ((Long) obj2).longValue() : -1L;
            if (iIntValue != -1 && jLongValue != -1) {
                NotificationManagerCompat notificationManagerCompat = new NotificationManagerCompat(getApplicationContext());
                Intrinsics.checkNotNullExpressionValue(notificationManagerCompat, "from(...)");
                StatusBarNotification[] activeNotifications = notificationManagerCompat.f2692b.getActiveNotifications();
                Iterable arrayList = activeNotifications == null ? new ArrayList() : Arrays.asList(activeNotifications);
                Intrinsics.checkNotNullExpressionValue(arrayList, "getActiveNotifications(...)");
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    StatusBarNotification statusBarNotification = (StatusBarNotification) next;
                    Bundle bundle = statusBarNotification.getNotification().extras;
                    NotificationConfig[] notificationConfigArr = NotificationConfig.f20458a;
                    long j2 = bundle.getLong("sticky_notification_creation_time");
                    if (statusBarNotification.getId() == iIntValue && j2 == jLongValue) {
                        break;
                    }
                }
                if (((StatusBarNotification) next) != null) {
                    notificationManagerCompat.b(iIntValue);
                }
                return new ListenableWorker.Result.Success();
            }
            ListenableWorker.Result.Failure failure = new ListenableWorker.Result.Failure();
            Intrinsics.checkNotNullExpressionValue(failure, "failure(...)");
            return failure;
        } catch (Exception unused) {
            return new ListenableWorker.Result.Failure();
        }
    }
}
