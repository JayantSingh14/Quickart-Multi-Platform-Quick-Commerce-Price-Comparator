package com.falcon.notification.factory.templates;

import android.content.Context;
import android.support.v4.media.b;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class NormalTemplate implements BaseTemplate {

    /* renamed from: a, reason: collision with root package name */
    public final Context f20482a;

    /* renamed from: b, reason: collision with root package name */
    public final NotificationCompat.Builder f20483b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f20484c;

    public NormalTemplate(Context context, NotificationCompat.Builder notificationBuilder, Map data) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notificationBuilder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(data, "data");
        this.f20482a = context;
        this.f20483b = notificationBuilder;
        this.f20484c = data;
    }

    public final Integer a(String str, String str2) {
        Context context = this.f20482a;
        int identifier = context.getResources().getIdentifier(str, str2, context.getPackageName());
        if (identifier != 0) {
            return Integer.valueOf(identifier);
        }
        Log.w("NormalTemplate", b.m("Resource not found: ", str2, "/", str, ". Please define it in the app."));
        return null;
    }
}
