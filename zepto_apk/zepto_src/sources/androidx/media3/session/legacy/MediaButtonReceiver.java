package androidx.media3.session.legacy;

import android.app.ForegroundServiceStartNotAllowedException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.support.v4.media.b;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.os.a;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.session.legacy.MediaBrowserCompat;
import java.util.List;

@RestrictTo
@UnstableApi
/* loaded from: classes3.dex */
public class MediaButtonReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f10561a = 0;

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
        public final Context f10562c;

        /* renamed from: d, reason: collision with root package name */
        public final Intent f10563d;

        /* renamed from: e, reason: collision with root package name */
        public final BroadcastReceiver.PendingResult f10564e;

        /* renamed from: f, reason: collision with root package name */
        public MediaBrowserCompat f10565f;

        public MediaButtonConnectionCallback(BroadcastReceiver.PendingResult pendingResult, Context context, Intent intent) {
            this.f10562c = context;
            this.f10563d = intent;
            this.f10564e = pendingResult;
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.ConnectionCallback
        public final void a() {
            MediaBrowserCompat mediaBrowserCompat = this.f10565f;
            mediaBrowserCompat.getClass();
            new MediaControllerCompat(this.f10562c, mediaBrowserCompat.c()).c((KeyEvent) this.f10563d.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            MediaBrowserCompat mediaBrowserCompat2 = this.f10565f;
            mediaBrowserCompat2.getClass();
            mediaBrowserCompat2.b();
            this.f10564e.finish();
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.ConnectionCallback
        public final void b() {
            MediaBrowserCompat mediaBrowserCompat = this.f10565f;
            mediaBrowserCompat.getClass();
            mediaBrowserCompat.b();
            this.f10564e.finish();
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.ConnectionCallback
        public final void c() {
            MediaBrowserCompat mediaBrowserCompat = this.f10565f;
            mediaBrowserCompat.getClass();
            mediaBrowserCompat.b();
            this.f10564e.finish();
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
            mediaButtonConnectionCallback.f10565f = mediaBrowserCompat;
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
