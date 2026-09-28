package com.falcon.notification.factory.provider;

import android.content.Context;
import android.support.v4.media.b;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.falcon.R;
import com.falcon.notification.constants.NotificationConfig;
import com.falcon.notification.utils.NotificationUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class NotificationTemplateProvider {

    /* renamed from: a, reason: collision with root package name */
    public final Context f20476a;

    /* renamed from: b, reason: collision with root package name */
    public final NotificationCompat.Builder f20477b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f20478c;

    @Metadata
    public static final class Companion {
    }

    public NotificationTemplateProvider(Context context, NotificationCompat.Builder notificationBuilder, Map data) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notificationBuilder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(data, "data");
        this.f20476a = context;
        this.f20477b = notificationBuilder;
        this.f20478c = data;
    }

    public final NotificationCompat.Builder a() {
        Integer numValueOf;
        NotificationCompat.Builder builder = this.f20477b;
        Context context = this.f20476a;
        NotificationConfig[] notificationConfigArr = NotificationConfig.f20458a;
        Map map = this.f20478c;
        String str = (String) map.get("cds_title");
        String str2 = "";
        if (str == null) {
            str = "";
        }
        try {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.basic_layout);
            Spanned spannedFromHtml = Html.fromHtml(str, 0);
            Intrinsics.checkNotNullExpressionValue(spannedFromHtml, "fromHtml(...)");
            remoteViews.setTextViewText(R.id.title, spannedFromHtml);
            String str3 = (String) map.get("title_color");
            if (str3 != null) {
                str2 = str3;
            }
            remoteViews.setTextColor(R.id.title, NotificationUtils.Companion.b(context, str2));
            builder.t = remoteViews;
        } catch (Exception e2) {
            b.A("Failed to set customContentView: ", e2.getMessage(), "NotificationTemplateProvider");
        }
        int identifier = context.getResources().getIdentifier("ic_notification_icon", "drawable", context.getPackageName());
        if (identifier != 0) {
            numValueOf = Integer.valueOf(identifier);
        } else {
            Log.w("NotificationTemplateProvider", "Resource not found: drawable/ic_notification_icon. Please define it in the app.");
            numValueOf = null;
        }
        if (numValueOf != null) {
            builder.y.icon = numValueOf.intValue();
        } else {
            Log.w("NotificationTemplateProvider", "Notification icon not found — using default.");
        }
        builder.o(new NotificationCompat.DecoratedCustomViewStyle());
        builder.f2673j = 1;
        Intrinsics.checkNotNullExpressionValue(builder, "setPriority(...)");
        return builder;
    }
}
