package androidx.work.impl.model;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import androidx.arch.core.util.Function;
import androidx.work.impl.c;
import androidx.work.impl.model.WorkSpec;
import coil3.EventListener;
import coil3.request.ImageRequest;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Predicate;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.react.bridge.queue.QueueThreadExceptionHandler;
import com.google.android.datatransport.Transformer;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRegistrarProcessor;
import com.google.firebase.crashlytics.internal.CrashlyticsRemoteConfigListener;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
import com.google.firebase.datatransport.TransportRegistrar;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.remoteconfig.interop.FirebaseRemoteConfigInterop;
import com.google.firebase.sessions.FirebaseSessionsRegistrar;
import com.reactnativecommunity.webview.RNCWebViewConfig;
import com.swmansion.reanimated.ReanimatedMessageQueueThreadBase;
import io.sentry.IScope;
import io.sentry.ScopeCallback;
import io.sentry.android.core.util.AndroidLazyEvaluator;
import io.sentry.util.LazyEvaluator;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Function, EventListener.Factory, Predicate, LibraryVersionComponent.VersionExtractor, ComponentRegistrarProcessor, Deferred.DeferredHandler, OnFailureListener, Transformer, ComponentFactory, RNCWebViewConfig, QueueThreadExceptionHandler, AndroidLazyEvaluator.AndroidEvaluator, LazyEvaluator.Evaluator, ScopeCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12956a;

    public /* synthetic */ a(int i2) {
        this.f12956a = i2;
    }

    private final void i(Provider provider) {
    }

    @Override // io.sentry.util.LazyEvaluator.Evaluator
    public Object a() {
        try {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            return Boolean.valueOf(runningAppProcessInfo.importance == 100);
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }

    @Override // com.facebook.common.internal.Predicate
    /* renamed from: apply */
    public boolean mo0apply(Object obj) {
        CacheKey it = (CacheKey) obj;
        CancellationException cancellationException = ImagePipeline.n;
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    @Override // com.google.firebase.components.ComponentRegistrarProcessor
    public List b(ComponentRegistrar componentRegistrar) {
        return componentRegistrar.getComponents();
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object c(ComponentContainer componentContainer) {
        switch (this.f12956a) {
            case 12:
                return TransportRegistrar.lambda$getComponents$0(componentContainer);
            case 13:
                return TransportRegistrar.lambda$getComponents$1(componentContainer);
            case 14:
                return TransportRegistrar.lambda$getComponents$2(componentContainer);
            case 15:
                return FirebaseInstallationsRegistrar.lambda$getComponents$0(componentContainer);
            case 16:
                return FirebaseSessionsRegistrar.getComponents$lambda$0(componentContainer);
            default:
                return FirebaseSessionsRegistrar.getComponents$lambda$1(componentContainer);
        }
    }

    @Override // coil3.EventListener.Factory
    public EventListener create(ImageRequest imageRequest) {
        return EventListener.Factory.NONE$lambda$0(imageRequest);
    }

    @Override // io.sentry.android.core.util.AndroidLazyEvaluator.AndroidEvaluator
    public Object d(Context context) {
        String string;
        switch (this.f12956a) {
            case 20:
                try {
                    return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                } catch (Throwable unused) {
                    return null;
                }
            case 21:
                return Settings.Global.getString(context.getContentResolver(), "device_name");
            case 22:
            default:
                try {
                    return context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.ApplicationInfoFlags.of(128L));
                } catch (Throwable unused2) {
                    return null;
                }
            case 23:
                try {
                    return context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
                } catch (Throwable unused3) {
                    return null;
                }
            case 24:
                try {
                    return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                } catch (Throwable unused4) {
                    return null;
                }
            case 25:
                try {
                    ApplicationInfo applicationInfo = context.getApplicationInfo();
                    int i2 = applicationInfo.labelRes;
                    if (i2 == 0) {
                        CharSequence charSequence = applicationInfo.nonLocalizedLabel;
                        string = charSequence != null ? charSequence.toString() : context.getPackageManager().getApplicationLabel(applicationInfo).toString();
                    } else {
                        string = context.getString(i2);
                    }
                    return string;
                } catch (Throwable unused5) {
                    return null;
                }
        }
    }

    @Override // com.google.firebase.inject.Deferred.DeferredHandler
    public void f(Provider provider) {
        switch (this.f12956a) {
            case 8:
                break;
            default:
                ((FirebaseRemoteConfigInterop) provider.get()).a();
                Logger.f43705a.b("Registering RemoteConfig Rollouts subscriber", null);
                break;
        }
    }

    @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
    public String g(Context context) {
        switch (this.f12956a) {
            case 3:
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                return applicationInfo != null ? String.valueOf(applicationInfo.targetSdkVersion) : "";
            case 4:
                ApplicationInfo applicationInfo2 = context.getApplicationInfo();
                return applicationInfo2 != null ? String.valueOf(applicationInfo2.minSdkVersion) : "";
            case 5:
                return context.getPackageManager().hasSystemFeature("android.hardware.type.television") ? "tv" : context.getPackageManager().hasSystemFeature("android.hardware.type.watch") ? "watch" : context.getPackageManager().hasSystemFeature("android.hardware.type.automotive") ? "auto" : (Build.VERSION.SDK_INT < 26 || !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) ? "" : "embedded";
            default:
                String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                return installerPackageName != null ? FirebaseCommonRegistrar.a(installerPackageName) : "";
        }
    }

    @Override // io.sentry.ScopeCallback
    public void h(IScope iScope) {
        iScope.E(new c(iScope, 10));
    }

    @Override // com.facebook.react.bridge.queue.QueueThreadExceptionHandler
    public void handleException(Exception exc) {
        ReanimatedMessageQueueThreadBase.lambda$new$0(exc);
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        Logger.f43705a.c("Error fetching settings.", exc);
    }

    public /* synthetic */ a(CrashlyticsRemoteConfigListener crashlyticsRemoteConfigListener) {
        this.f12956a = 10;
    }

    @Override // androidx.arch.core.util.Function
    public Object apply(Object obj) {
        switch (this.f12956a) {
            case 0:
                List list = (List) obj;
                String str = WorkSpec.x;
                if (list == null) {
                    return null;
                }
                List list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.r(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((WorkSpec.WorkInfoPojo) it.next()).a());
                }
                return arrayList;
            default:
                DataTransportCrashlyticsReportSender.f44394b.getClass();
                return CrashlyticsReportJsonTransform.f44368a.encode((CrashlyticsReport) obj).getBytes(Charset.forName("UTF-8"));
        }
    }
}
