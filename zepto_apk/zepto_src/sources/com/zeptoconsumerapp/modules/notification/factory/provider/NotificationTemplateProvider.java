package com.zeptoconsumerapp.modules.notification.factory.provider;

import android.content.Context;
import android.text.Html;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.zeptoconsumerapp.R;
import com.zeptoconsumerapp.modules.notification.constants.NotificationConfig;
import com.zeptoconsumerapp.modules.notification.utils.NotificationUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class NotificationTemplateProvider {

    /* renamed from: a, reason: collision with root package name */
    public final Context f47680a;

    /* renamed from: b, reason: collision with root package name */
    public final NotificationCompat.Builder f47681b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f47682c;

    public NotificationTemplateProvider(Context context, NotificationCompat.Builder notificationBuilder, Map data) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notificationBuilder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(data, "data");
        this.f47680a = context;
        this.f47681b = notificationBuilder;
        this.f47682c = data;
    }

    public final NotificationCompat.Builder a() {
        int i2 = R.drawable.ic_notification_icon;
        NotificationConfig[] notificationConfigArr = NotificationConfig.f47662a;
        Map map = this.f47682c;
        String str = (String) map.get("cds_title");
        Context context = this.f47680a;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.basic_layout);
        if (str == null) {
            str = "";
        }
        remoteViews.setTextViewText(R.id.title, Html.fromHtml(str, 0));
        String str2 = (String) map.get("title_color");
        remoteViews.setTextColor(R.id.title, NotificationUtils.Companion.a(context, str2 != null ? str2 : ""));
        NotificationCompat.Builder builder = this.f47681b;
        builder.y.icon = i2;
        builder.o(new NotificationCompat.DecoratedCustomViewStyle());
        builder.f2673j = 1;
        builder.t = remoteViews;
        Intrinsics.checkNotNullExpressionValue(builder, "setCustomContentView(...)");
        return builder;
    }
}
