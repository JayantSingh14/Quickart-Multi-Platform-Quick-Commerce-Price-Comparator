package com.amazon.apay.hardened.external.model;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.browser.customtabs.CustomTabsIntent;
import com.amazon.apay.hardened.util.ValidationUtil;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class APayRequestContext {

    /* renamed from: a, reason: collision with root package name */
    public final UUID f14996a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14997b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f14998c;

    /* renamed from: d, reason: collision with root package name */
    public final PendingIntent f14999d;

    /* renamed from: e, reason: collision with root package name */
    public final PendingIntent f15000e;

    /* renamed from: f, reason: collision with root package name */
    public final CustomTabsIntent f15001f;

    public APayRequestContext(Activity activity, String str, PendingIntent pendingIntent, PendingIntent pendingIntent2, CustomTabsIntent customTabsIntent) {
        ValidationUtil.a(activity, "Context");
        this.f14996a = UUID.randomUUID();
        this.f14998c = activity;
        this.f14997b = str;
        this.f14999d = pendingIntent;
        this.f15000e = pendingIntent2;
        this.f15001f = customTabsIntent;
    }

    public static APayRequestContext create(@NonNull Activity activity, String str) {
        return new APayRequestContext(activity, str, null, null, null);
    }

    public PendingIntent getCancelIntent() {
        return this.f15000e;
    }

    public String getClientId() {
        return this.f14997b;
    }

    public PendingIntent getCompletionIntent() {
        return this.f14999d;
    }

    public Context getContext() {
        return this.f14998c;
    }

    public CustomTabsIntent getCustomTabsIntent() {
        return this.f15001f;
    }

    public String getId() {
        return this.f14996a.toString();
    }

    public static APayRequestContext create(@NonNull Activity activity, @NonNull String str, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2, @NonNull CustomTabsIntent customTabsIntent) {
        return new APayRequestContext(activity, str, pendingIntent, pendingIntent2, customTabsIntent);
    }

    public static APayRequestContext create(@NonNull Activity activity, @NonNull String str, @NonNull PendingIntent pendingIntent, @NonNull CustomTabsIntent customTabsIntent) {
        return new APayRequestContext(activity, str, pendingIntent, null, customTabsIntent);
    }

    public static APayRequestContext create(@NonNull Activity activity, @NonNull String str, @NonNull CustomTabsIntent customTabsIntent) {
        return new APayRequestContext(activity, str, null, null, customTabsIntent);
    }
}
