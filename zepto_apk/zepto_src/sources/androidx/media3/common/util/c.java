package androidx.media3.common.util;

import android.app.Activity;
import android.view.Choreographer;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.internal.ChoreographerProvider;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.statusbar.StatusBarModule;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.sentry.Breadcrumb;
import io.sentry.SentryLevel;
import io.sentry.android.core.AndroidLogger;
import io.sentry.android.core.internal.util.SentryFrameMetricsCollector;
import io.sentry.cache.PersistingScopeObserver;
import io.sentry.cache.tape.ObjectQueue;
import io.sentry.protocol.Contexts;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5761a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5762b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5763c;

    public /* synthetic */ c(int i2, Object obj, Object obj2) {
        this.f5761a = i2;
        this.f5762b = obj;
        this.f5763c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj = this.f5763c;
        Object obj2 = this.f5762b;
        switch (this.f5761a) {
            case 0:
                ((androidx.media3.exoplayer.upstream.b) obj).a(((NetworkTypeObserver) obj2).c());
                break;
            case 1:
                ((ReactChoreographer) obj2).f19064a = ((ChoreographerProvider) obj).a();
                break;
            case 2:
                StatusBarModule.setStyle$lambda$2((Activity) obj2, (String) obj);
                break;
            case 3:
                ReactNativeFirebaseEventEmitter reactNativeFirebaseEventEmitter = (ReactNativeFirebaseEventEmitter) obj2;
                reactNativeFirebaseEventEmitter.f49235e = (Boolean) obj;
                reactNativeFirebaseEventEmitter.c();
                break;
            case 4:
                ReactNativeFirebaseEventEmitter reactNativeFirebaseEventEmitter2 = (ReactNativeFirebaseEventEmitter) obj2;
                reactNativeFirebaseEventEmitter2.f49234d = (ReactContext) obj;
                reactNativeFirebaseEventEmitter2.c();
                break;
            case 5:
                int i2 = SentryFrameMetricsCollector.p;
                SentryFrameMetricsCollector sentryFrameMetricsCollector = (SentryFrameMetricsCollector) obj2;
                sentryFrameMetricsCollector.getClass();
                try {
                    sentryFrameMetricsCollector.f52336j = Choreographer.getInstance();
                    break;
                } catch (Throwable th) {
                    ((AndroidLogger) obj).b(SentryLevel.ERROR, "Error retrieving Choreographer instance. Slow and frozen frames will not be reported.", th);
                    return;
                }
            case 6:
                Breadcrumb breadcrumb = (Breadcrumb) obj;
                Charset charset = PersistingScopeObserver.f52680c;
                PersistingScopeObserver persistingScopeObserver = (PersistingScopeObserver) obj2;
                persistingScopeObserver.getClass();
                try {
                    ((ObjectQueue) persistingScopeObserver.f52682b.a()).b(breadcrumb);
                    break;
                } catch (IOException e2) {
                    persistingScopeObserver.f52681a.getLogger().b(SentryLevel.ERROR, "Failed to add breadcrumb to file queue", e2);
                    return;
                }
            case 7:
                Charset charset2 = PersistingScopeObserver.f52680c;
                PersistingScopeObserver persistingScopeObserver2 = (PersistingScopeObserver) obj2;
                String str = (String) obj;
                if (str != null) {
                    persistingScopeObserver2.p(str, "transaction.json");
                    break;
                } else {
                    persistingScopeObserver2.l("transaction.json");
                    break;
                }
            case 8:
                Runnable runnable = (Runnable) obj;
                Charset charset3 = PersistingScopeObserver.f52680c;
                PersistingScopeObserver persistingScopeObserver3 = (PersistingScopeObserver) obj2;
                persistingScopeObserver3.getClass();
                try {
                    runnable.run();
                    break;
                } catch (Throwable th2) {
                    persistingScopeObserver3.f52681a.getLogger().b(SentryLevel.ERROR, "Serialization task failed", th2);
                    return;
                }
            case 9:
                Charset charset4 = PersistingScopeObserver.f52680c;
                ((PersistingScopeObserver) obj2).p((ConcurrentHashMap) obj, "tags.json");
                break;
            default:
                Charset charset5 = PersistingScopeObserver.f52680c;
                ((PersistingScopeObserver) obj2).p((Contexts) obj, "contexts.json");
                break;
        }
    }
}
