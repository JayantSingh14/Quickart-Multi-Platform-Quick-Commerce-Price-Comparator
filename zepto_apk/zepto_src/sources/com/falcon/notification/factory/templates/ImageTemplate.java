package com.falcon.notification.factory.templates;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ImageTemplate implements BaseTemplate {

    /* renamed from: a, reason: collision with root package name */
    public final Map f20481a;

    public ImageTemplate(Context context, NotificationCompat.Builder notificationBuilder, Map data) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notificationBuilder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(data, "data");
        this.f20481a = data;
    }
}
