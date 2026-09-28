package com.chuckerteam.chucker.internal.support;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.LongSparseArray;
import androidx.core.app.NotificationCompat;
import androidx.media3.session.e;
import com.chuckerteam.chucker.R;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import com.chuckerteam.chucker.internal.ui.BaseChuckerActivity;
import java.util.HashSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class NotificationHelper {

    /* renamed from: d, reason: collision with root package name */
    public static final LongSparseArray f16779d = new LongSparseArray();

    /* renamed from: e, reason: collision with root package name */
    public static final HashSet f16780e = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final Context f16781a;

    /* renamed from: b, reason: collision with root package name */
    public final NotificationManager f16782b;

    /* renamed from: c, reason: collision with root package name */
    public final Lazy f16783c;

    @Metadata
    public static final class Companion {
    }

    public NotificationHelper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f16781a = context;
        Object systemService = context.getSystemService("notification");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        this.f16782b = notificationManager;
        this.f16783c = LazyKt.b(new coil3.decode.a(this, 6));
        if (Build.VERSION.SDK_INT >= 26) {
            e.C();
            notificationManager.createNotificationChannels(CollectionsKt.H(com.bumptech.glide.load.resource.bitmap.a.e(context.getString(R.string.chucker_network_notification_category))));
        }
    }

    public final void a(HttpTransaction transaction) {
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        int i2 = 0;
        if (transaction.getId() != 0) {
            LongSparseArray longSparseArray = f16779d;
            synchronized (longSparseArray) {
                try {
                    f16780e.add(Long.valueOf(transaction.getId()));
                    longSparseArray.put(transaction.getId(), transaction);
                    if (longSparseArray.size() > 10) {
                        longSparseArray.removeAt(0);
                    }
                    Unit unit = Unit.f53572a;
                } finally {
                }
            }
        }
        if (BaseChuckerActivity.f16848i || !this.f16782b.areNotificationsEnabled()) {
            return;
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.f16781a, "chucker_transactions");
        builder.f2670g = (PendingIntent) this.f16783c.getValue();
        builder.p = true;
        builder.y.icon = R.drawable.chucker_ic_transaction_notification;
        builder.r = this.f16781a.getColor(R.color.chucker_color_primary);
        builder.f2668e = NotificationCompat.Builder.c(this.f16781a.getString(R.string.chucker_http_notification_title));
        builder.i(16, true);
        int i3 = R.string.chucker_clear;
        Context context = this.f16781a;
        String string = context.getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        builder.f2665b.add(new NotificationCompat.Action(R.drawable.chucker_ic_delete_white, string, PendingIntent.getBroadcast(context, 11, new Intent(context, (Class<?>) ClearDatabaseJobIntentServiceReceiver.class), 1140850688)));
        Intrinsics.checkNotNullExpressionValue(builder, "addAction(...)");
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        LongSparseArray longSparseArray2 = f16779d;
        synchronized (longSparseArray2) {
            try {
                for (int size = longSparseArray2.size() - 1; -1 < size; size--) {
                    HttpTransaction httpTransaction = (HttpTransaction) f16779d.valueAt(size);
                    if (httpTransaction != null && i2 < 10) {
                        if (i2 == 0) {
                            builder.g(httpTransaction.getNotificationText());
                        }
                        String notificationText = httpTransaction.getNotificationText();
                        if (notificationText != null) {
                            inboxStyle.f2677b.add(NotificationCompat.Builder.c(notificationText));
                        }
                    }
                    i2++;
                }
                builder.o(inboxStyle);
                builder.n = NotificationCompat.Builder.c(String.valueOf(f16780e.size()));
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f16782b.notify(1138, builder.b());
    }
}
