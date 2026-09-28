package io.sentry.android.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import io.sentry.Breadcrumb;
import io.sentry.Hint;
import io.sentry.HubAdapter;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.SystemEventsBreadcrumbsIntegration;
import io.sentry.android.core.internal.util.Debouncer;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.Objects;
import io.sentry.util.StringUtils;
import java.io.Closeable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.lang3.time.DateUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public final class SystemEventsBreadcrumbsIntegration implements Integration, Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final Context f52221a;

    /* renamed from: b, reason: collision with root package name */
    public SystemEventsBroadcastReceiver f52222b;

    /* renamed from: c, reason: collision with root package name */
    public SentryAndroidOptions f52223c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f52224d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f52225e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f52226f;

    public static final class SystemEventsBroadcastReceiver extends BroadcastReceiver {

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int f52227d = 0;

        /* renamed from: a, reason: collision with root package name */
        public final HubAdapter f52228a;

        /* renamed from: b, reason: collision with root package name */
        public final SentryAndroidOptions f52229b;

        /* renamed from: c, reason: collision with root package name */
        public final Debouncer f52230c;

        public SystemEventsBroadcastReceiver(SentryAndroidOptions sentryAndroidOptions) {
            HubAdapter hubAdapter = HubAdapter.f51658a;
            this.f52230c = new Debouncer(DateUtils.MILLIS_PER_MINUTE, 0);
            this.f52228a = hubAdapter;
            this.f52229b = sentryAndroidOptions;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, final Intent intent) {
            SentryAndroidOptions sentryAndroidOptions = this.f52229b;
            final String action = intent.getAction();
            final boolean zEquals = "android.intent.action.BATTERY_CHANGED".equals(action);
            if (zEquals && this.f52230c.a()) {
                return;
            }
            final long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                sentryAndroidOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.core.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        String strSubstring;
                        int i2;
                        int i3 = SystemEventsBreadcrumbsIntegration.SystemEventsBroadcastReceiver.f52227d;
                        SystemEventsBreadcrumbsIntegration.SystemEventsBroadcastReceiver systemEventsBroadcastReceiver = this.f52360a;
                        Breadcrumb breadcrumb = new Breadcrumb(jCurrentTimeMillis);
                        breadcrumb.f51558d = "system";
                        breadcrumb.f51560f = "device.event";
                        Charset charset = StringUtils.f53134a;
                        String str = action;
                        if (str != null) {
                            int iLastIndexOf = str.lastIndexOf(CLConstants.DOT_SALT_DELIMETER);
                            strSubstring = (iLastIndexOf < 0 || str.length() <= (i2 = iLastIndexOf + 1)) ? str : str.substring(i2);
                        } else {
                            strSubstring = null;
                        }
                        if (strSubstring != null) {
                            breadcrumb.b(strSubstring, "action");
                        }
                        Intent intent2 = intent;
                        boolean z = zEquals;
                        SentryAndroidOptions sentryAndroidOptions2 = systemEventsBroadcastReceiver.f52229b;
                        if (z) {
                            Float fB = DeviceInfoUtil.b(intent2, sentryAndroidOptions2);
                            if (fB != null) {
                                breadcrumb.b(fB, "level");
                            }
                            Boolean boolD = DeviceInfoUtil.d(intent2, sentryAndroidOptions2);
                            if (boolD != null) {
                                breadcrumb.b(boolD, "charging");
                            }
                        } else {
                            Bundle extras = intent2.getExtras();
                            HashMap map = new HashMap();
                            if (extras != null && !extras.isEmpty()) {
                                for (String str2 : extras.keySet()) {
                                    try {
                                        Object obj = extras.get(str2);
                                        if (obj != null) {
                                            map.put(str2, obj.toString());
                                        }
                                    } catch (Throwable th) {
                                        sentryAndroidOptions2.getLogger().a(SentryLevel.ERROR, th, "%s key of the %s action threw an error.", str2, str);
                                    }
                                }
                                breadcrumb.b(map, "extras");
                            }
                        }
                        breadcrumb.f51562h = SentryLevel.INFO;
                        Hint hint = new Hint();
                        hint.c(intent2, "android:intent");
                        systemEventsBroadcastReceiver.f52228a.b(breadcrumb, hint);
                    }
                });
            } catch (Throwable th) {
                sentryAndroidOptions.getLogger().a(SentryLevel.ERROR, th, "Failed to submit system event breadcrumb action.", new Object[0]);
            }
        }
    }

    public SystemEventsBreadcrumbsIntegration(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.intent.action.ACTION_SHUTDOWN");
        arrayList.add("android.intent.action.AIRPLANE_MODE");
        arrayList.add("android.intent.action.BATTERY_CHANGED");
        arrayList.add("android.intent.action.CAMERA_BUTTON");
        arrayList.add("android.intent.action.CONFIGURATION_CHANGED");
        arrayList.add("android.intent.action.DATE_CHANGED");
        arrayList.add("android.intent.action.DEVICE_STORAGE_LOW");
        arrayList.add("android.intent.action.DEVICE_STORAGE_OK");
        arrayList.add("android.intent.action.DOCK_EVENT");
        arrayList.add("android.intent.action.DREAMING_STARTED");
        arrayList.add("android.intent.action.DREAMING_STOPPED");
        arrayList.add("android.intent.action.INPUT_METHOD_CHANGED");
        arrayList.add("android.intent.action.LOCALE_CHANGED");
        arrayList.add("android.intent.action.SCREEN_OFF");
        arrayList.add("android.intent.action.SCREEN_ON");
        arrayList.add("android.intent.action.TIMEZONE_CHANGED");
        arrayList.add("android.intent.action.TIME_SET");
        arrayList.add("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        arrayList.add("android.os.action.POWER_SAVE_MODE_CHANGED");
        this.f52225e = false;
        this.f52226f = new Object();
        Context applicationContext = context.getApplicationContext();
        this.f52221a = applicationContext != null ? applicationContext : context;
        this.f52224d = arrayList;
    }

    public final void a(SentryAndroidOptions sentryAndroidOptions) {
        this.f52222b = new SystemEventsBroadcastReceiver(sentryAndroidOptions);
        IntentFilter intentFilter = new IntentFilter();
        Iterator it = this.f52224d.iterator();
        while (it.hasNext()) {
            intentFilter.addAction((String) it.next());
        }
        try {
            Context context = this.f52221a;
            SystemEventsBroadcastReceiver systemEventsBroadcastReceiver = this.f52222b;
            new BuildInfoProvider(sentryAndroidOptions.getLogger());
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(systemEventsBroadcastReceiver, intentFilter, 4);
            } else {
                context.registerReceiver(systemEventsBroadcastReceiver, intentFilter);
            }
            sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "SystemEventsBreadcrumbsIntegration installed.", new Object[0]);
            IntegrationUtils.a("SystemEventsBreadcrumbs");
        } catch (Throwable th) {
            sentryAndroidOptions.setEnableSystemEventBreadcrumbs(false);
            sentryAndroidOptions.getLogger().b(SentryLevel.ERROR, "Failed to initialize SystemEventsBreadcrumbsIntegration.", th);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f52226f) {
            this.f52225e = true;
        }
        SystemEventsBroadcastReceiver systemEventsBroadcastReceiver = this.f52222b;
        if (systemEventsBroadcastReceiver != null) {
            this.f52221a.unregisterReceiver(systemEventsBroadcastReceiver);
            this.f52222b = null;
            SentryAndroidOptions sentryAndroidOptions = this.f52223c;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "SystemEventsBreadcrumbsIntegration remove.", new Object[0]);
            }
        }
    }

    @Override // io.sentry.Integration
    public final void l(final SentryOptions sentryOptions) {
        SentryAndroidOptions sentryAndroidOptions = sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null;
        Objects.b(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f52223c = sentryAndroidOptions;
        sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "SystemEventsBreadcrumbsIntegration enabled: %s", Boolean.valueOf(this.f52223c.isEnableSystemEventBreadcrumbs()));
        if (this.f52223c.isEnableSystemEventBreadcrumbs()) {
            try {
                sentryOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.core.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        SystemEventsBreadcrumbsIntegration systemEventsBreadcrumbsIntegration = this.f52358a;
                        SentryOptions sentryOptions2 = sentryOptions;
                        synchronized (systemEventsBreadcrumbsIntegration.f52226f) {
                            try {
                                if (!systemEventsBreadcrumbsIntegration.f52225e) {
                                    systemEventsBreadcrumbsIntegration.a((SentryAndroidOptions) sentryOptions2);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                });
            } catch (Throwable th) {
                sentryOptions.getLogger().b(SentryLevel.DEBUG, "Failed to start SystemEventsBreadcrumbsIntegration on executor thread.", th);
            }
        }
    }
}
