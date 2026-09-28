package com.zeptoconsumerapp.modules.notification.factory.templates;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class NormalTemplate implements BaseTemplate {

    /* renamed from: a, reason: collision with root package name */
    public final Map f47685a;

    public NormalTemplate(Context context, NotificationCompat.Builder notificationBuilder, Map data) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notificationBuilder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(data, "data");
        this.f47685a = data;
    }
}
