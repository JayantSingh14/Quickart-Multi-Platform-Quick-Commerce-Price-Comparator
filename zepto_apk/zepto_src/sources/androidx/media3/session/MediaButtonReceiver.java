package androidx.media3.session;

import android.app.ForegroundServiceStartNotAllowedException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@UnstableApi
/* loaded from: classes3.dex */
public class MediaButtonReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f9953a = {"android.intent.action.MEDIA_BUTTON", "androidx.media3.session.MediaLibraryService", "androidx.media3.session.MediaSessionService"};

    @RequiresApi
    public static final class Api31 {
        @DoNotInline
        public static ForegroundServiceStartNotAllowedException a(IllegalStateException illegalStateException) {
            return androidx.core.os.a.c(illegalStateException);
        }

        @DoNotInline
        public static boolean b(IllegalStateException illegalStateException) {
            return androidx.core.os.a.y(illegalStateException);
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        ComponentName componentName;
        if (intent == null || !Objects.equals(intent.getAction(), "android.intent.action.MEDIA_BUTTON") || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            Log.d("MediaButtonReceiver", "Ignore unsupported intent: " + intent);
            return;
        }
        if (Util.f5744a >= 26) {
            Bundle extras = intent.getExtras();
            extras.getClass();
            KeyEvent keyEvent = (KeyEvent) extras.getParcelable("android.intent.extra.KEY_EVENT");
            if (keyEvent != null && keyEvent.getKeyCode() != 126 && keyEvent.getKeyCode() != 85 && keyEvent.getKeyCode() != 79) {
                Log.w("MediaButtonReceiver", "Ignore key event that is not a `play` command on API 26 or above to avoid an 'ForegroundServiceDidNotStartInTimeException'");
                return;
            }
        }
        String[] strArr = f9953a;
        for (int i2 = 0; i2 < 3; i2++) {
            String str = strArr[i2];
            PackageManager packageManager = context.getPackageManager();
            Intent intent2 = new Intent(str);
            intent2.setPackage(context.getPackageName());
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent2, 0);
            if (listQueryIntentServices.size() == 1) {
                ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
                componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
            } else {
                if (!listQueryIntentServices.isEmpty()) {
                    StringBuilder sbY = android.support.v4.media.b.y("Expected 1 service that handles ", str, ", found ");
                    sbY.append(listQueryIntentServices.size());
                    throw new IllegalStateException(sbY.toString());
                }
                componentName = null;
            }
            if (componentName != null) {
                intent.setComponent(componentName);
                try {
                    ContextCompat.f(context, intent);
                    return;
                } catch (IllegalStateException e2) {
                    if (Build.VERSION.SDK_INT < 31 || !Api31.b(e2)) {
                        throw e2;
                    }
                    androidx.media3.common.util.Log.d("MediaButtonReceiver", "caught exception when trying to start a foreground service from the background: " + Api31.a(e2).getMessage());
                    return;
                }
            }
        }
        throw new IllegalStateException("Could not find any Service that handles any of the actions " + Arrays.toString(strArr));
    }
}
