package io.sentry.react;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.core.app.FrameMetricsAggregator;
import com.facebook.react.bridge.ReactApplicationContext;
import io.sentry.SentryExecutorService;
import io.sentry.SentryLevel;
import io.sentry.android.core.AndroidLogger;
import io.sentry.android.core.AndroidProfiler;
import io.sentry.android.core.BuildInfoProvider;
import io.sentry.android.core.SentryAndroidDateProvider;
import io.sentry.android.core.internal.debugmeta.AssetsDebugMetaLoader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/* loaded from: classes.dex */
public class RNSentryModuleImpl {

    /* renamed from: l, reason: collision with root package name */
    public static final AndroidLogger f52986l;

    /* renamed from: m, reason: collision with root package name */
    public static final BuildInfoProvider f52987m;
    public static final Charset n;
    public static long o;

    /* renamed from: a, reason: collision with root package name */
    public final ReactApplicationContext f52988a;

    /* renamed from: b, reason: collision with root package name */
    public final PackageInfo f52989b;

    /* renamed from: d, reason: collision with root package name */
    public boolean f52991d;

    /* renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.a f52997j;

    /* renamed from: k, reason: collision with root package name */
    public final SentryAndroidDateProvider f52998k;

    /* renamed from: c, reason: collision with root package name */
    public FrameMetricsAggregator f52990c = null;

    /* renamed from: e, reason: collision with root package name */
    public AndroidProfiler f52992e = null;

    /* renamed from: f, reason: collision with root package name */
    public boolean f52993f = false;

    /* renamed from: g, reason: collision with root package name */
    public String f52994g = null;

    /* renamed from: h, reason: collision with root package name */
    public String f52995h = null;

    /* renamed from: i, reason: collision with root package name */
    public SentryExecutorService f52996i = null;

    static {
        AndroidLogger androidLogger = new AndroidLogger("RNSentry");
        f52986l = androidLogger;
        f52987m = new BuildInfoProvider(androidLogger);
        n = Charset.forName("UTF-8");
        o = -1L;
    }

    public RNSentryModuleImpl(ReactApplicationContext reactApplicationContext) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = null;
        try {
            packageInfo = reactApplicationContext.getPackageManager().getPackageInfo(reactApplicationContext.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            f52986l.c(SentryLevel.WARNING, "Error getting package info.", new Object[0]);
        }
        this.f52989b = packageInfo;
        this.f52988a = reactApplicationContext;
        this.f52997j = new androidx.lifecycle.a(this, 11);
        this.f52998k = new SentryAndroidDateProvider();
    }

    public final String a() throws IOException {
        if (this.f52993f) {
            return this.f52994g;
        }
        this.f52993f = true;
        AndroidLogger androidLogger = f52986l;
        List listA = new AssetsDebugMetaLoader(this.f52988a, androidLogger).a();
        if (listA == null) {
            return null;
        }
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            String property = ((Properties) it.next()).getProperty("io.sentry.ProguardUuids");
            this.f52994g = property;
            if (property != null) {
                androidLogger.c(SentryLevel.INFO, "Proguard uuid found: " + this.f52994g, new Object[0]);
                return this.f52994g;
            }
        }
        androidLogger.c(SentryLevel.WARNING, "No proguard uuid found in debug meta properties file!", new Object[0]);
        return null;
    }
}
