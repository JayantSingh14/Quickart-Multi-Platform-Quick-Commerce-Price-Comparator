package androidx.media.session;

import android.app.ForegroundServiceStartNotAllowedException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.b;
import android.support.v4.media.session.MediaControllerCompat;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.os.a;
import java.util.List;

/* loaded from: classes3.dex */
public class MediaButtonReceiver extends BroadcastReceiver {

    @RequiresApi
    public static final class Api31 {
        @DoNotInline
        public static ForegroundServiceStartNotAllowedException a(IllegalStateException illegalStateException) {
            return a.c(illegalStateException);
        }

        @DoNotInline
        public static boolean b(IllegalStateException illegalStateException) {
            return a.y(illegalStateException);
        }
    }

    public static class MediaButtonConnectionCallback extends MediaBrowserCompat.ConnectionCallback {

        /* renamed from: c, reason: collision with root package name */
        public final Context f5110c;

        /* renamed from: d, reason: collision with root package name */
        public final Intent f5111d;

        /* renamed from: e, reason: collision with root package name */
        public final BroadcastReceiver.PendingResult f5112e;

        /* renamed from: f, reason: collision with root package name */
        public MediaBrowserCompat f5113f;

        public MediaButtonConnectionCallback(BroadcastReceiver.PendingResult pendingResult, Context context, Intent intent) {
            this.f5110c = context;
            this.f5111d = intent;
            this.f5112e = pendingResult;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public final void a() {
            new MediaControllerCompat(this.f5110c, this.f5113f.c()).a((KeyEvent) this.f5111d.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            this.f5113f.b();
            this.f5112e.finish();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public final void b() {
            this.f5113f.b();
            this.f5112e.finish();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public final void c() {
            this.f5113f.b();
            this.f5112e.finish();
        }
    }

    public static ComponentName a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (listQueryIntentServices.size() == 1) {
            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
            return new ComponentName(serviceInfo.packageName, serviceInfo.name);
        }
        if (listQueryIntentServices.isEmpty()) {
            return null;
        }
        StringBuilder sbY = b.y("Expected 1 service that handles ", str, ", found ");
        sbY.append(listQueryIntentServices.size());
        throw new IllegalStateException(sbY.toString());
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            Log.d("MediaButtonReceiver", "Ignore unsupported intent: " + intent);
            return;
        }
        ComponentName componentNameA = a(context, "android.intent.action.MEDIA_BUTTON");
        if (componentNameA == null) {
            ComponentName componentNameA2 = a(context, "android.media.browse.MediaBrowserService");
            if (componentNameA2 == null) {
                throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
            }
            BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
            Context applicationContext = context.getApplicationContext();
            MediaButtonConnectionCallback mediaButtonConnectionCallback = new MediaButtonConnectionCallback(pendingResultGoAsync, applicationContext, intent);
            MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, componentNameA2, mediaButtonConnectionCallback);
            mediaButtonConnectionCallback.f5113f = mediaBrowserCompat;
            mediaBrowserCompat.a();
            return;
        }
        intent.setComponent(componentNameA);
        try {
            ContextCompat.f(context, intent);
        } catch (IllegalStateException e2) {
            if (Build.VERSION.SDK_INT < 31 || !Api31.b(e2)) {
                throw e2;
            }
            Log.e("MediaButtonReceiver", "caught exception when trying to start a foreground service from the background: " + Api31.a(e2).getMessage());
        }
    }
}
