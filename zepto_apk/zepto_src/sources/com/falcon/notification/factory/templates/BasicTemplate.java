package com.falcon.notification.factory.templates;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.falcon.R;
import com.falcon.falconModule.FalconNotificationUtils;
import com.falcon.notification.constants.NotificationConfig;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class BasicTemplate implements BaseTemplate {

    /* renamed from: a, reason: collision with root package name */
    public final Context f20479a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f20480b;

    @Metadata
    public static final class Companion {
    }

    public BasicTemplate(Context context, NotificationCompat.Builder notificationBuilder, Map data) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notificationBuilder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(data, "data");
        this.f20479a = context;
        this.f20480b = data;
    }

    public final RemoteViews a(int i2, CharSequence charSequence, CharSequence charSequence2, int i3, int i4, boolean z, Bitmap bitmap, String str) {
        String lowerCase;
        RemoteViews remoteViews = new RemoteViews(this.f20479a.getPackageName(), i2);
        Log.d("BasicTemplate", "Building RemoteView (layout=" + i2 + ")");
        remoteViews.setTextViewText(R.id.title, charSequence);
        remoteViews.setTextColor(R.id.title, i3);
        if (z) {
            remoteViews.setTextViewText(R.id.message, charSequence2);
            remoteViews.setTextColor(R.id.message, i4);
        } else {
            remoteViews.setViewVisibility(R.id.message, 8);
        }
        NotificationConfig[] notificationConfigArr = NotificationConfig.f20458a;
        String str2 = (String) this.f20480b.get("z_tbnl");
        if (str2 != null) {
            lowerCase = str2.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        boolean zB = Intrinsics.b(lowerCase, "true");
        if (zB && bitmap != null) {
            FalconNotificationUtils.e(remoteViews, bitmap, str);
            return remoteViews;
        }
        Log.d("BasicTemplate", "Thumbnail not shown. enabled=" + zB + " bitmap=" + bitmap);
        return remoteViews;
    }
}
