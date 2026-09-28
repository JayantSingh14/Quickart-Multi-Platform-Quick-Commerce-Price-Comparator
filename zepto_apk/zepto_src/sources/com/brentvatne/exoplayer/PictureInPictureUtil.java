package com.brentvatne.exoplayer;

import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.util.Rational;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.R;
import com.brentvatne.common.toolbox.DebugLog;
import com.brentvatne.receiver.PictureInPictureReceiver;
import com.facebook.react.uimanager.ThemedReactContext;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes3.dex */
public final class PictureInPictureUtil {
    public static final void a(ThemedReactContext context, PictureInPictureParams.Builder builder, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (builder == null || Build.VERSION.SDK_INT < 31) {
            return;
        }
        builder.setAutoEnterEnabled(z);
        PictureInPictureParams pictureInPictureParamsBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(pictureInPictureParamsBuild, "build(...)");
        g(context, pictureInPictureParamsBuild);
    }

    public static final void b(ThemedReactContext context, PictureInPictureParams.Builder builder, PictureInPictureReceiver receiver, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        if (builder == null || Build.VERSION.SDK_INT < 26) {
            return;
        }
        builder.setActions(e(context, z, receiver));
        PictureInPictureParams pictureInPictureParamsBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(pictureInPictureParamsBuild, "build(...)");
        g(context, pictureInPictureParamsBuild);
    }

    public static final Rational c(ExoPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        Rational rational = new Rational(player.V0().f5564a, player.V0().f5565b);
        Rational rational2 = new Rational(239, 100);
        Rational rational3 = new Rational(100, 239);
        return rational.floatValue() > rational2.floatValue() ? rational2 : rational.floatValue() < rational3.floatValue() ? rational3 : rational;
    }

    public static final void d(ThemedReactContext context, PictureInPictureParams pictureInPictureParams) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (f(context)) {
            if (!(Build.VERSION.SDK_INT >= 26) || pictureInPictureParams == null) {
                try {
                    PictureInPictureUtilKt.a(context).enterPictureInPictureMode();
                    return;
                } catch (IllegalStateException e2) {
                    DebugLog.b("PictureInPictureUtil", e2.toString());
                    return;
                }
            }
            try {
                PictureInPictureUtilKt.a(context).enterPictureInPictureMode(pictureInPictureParams);
            } catch (IllegalStateException e3) {
                DebugLog.b("PictureInPictureUtil", e3.toString());
            }
        }
    }

    public static final ArrayList e(ThemedReactContext context, boolean z, PictureInPictureReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        receiver.getClass();
        int i2 = z ? 1 : 2;
        Intent intentPutExtra = new Intent("rnv_media_control").putExtra("rnv_control_type", z ? 1 : 2);
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
        ThemedReactContext themedReactContext = receiver.f15645b;
        intentPutExtra.setPackage(themedReactContext.getPackageName());
        PendingIntent broadcast = PendingIntent.getBroadcast(themedReactContext, i2, intentPutExtra, 201326592);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
        Icon iconCreateWithResource = Icon.createWithResource(context, z ? R.drawable.exo_icon_play : R.drawable.exo_icon_pause);
        Intrinsics.checkNotNullExpressionValue(iconCreateWithResource, "createWithResource(...)");
        String str = z ? "play" : CLConstants.CRED_SUB_TYPE_MANDATE_PAUSE;
        androidx.media3.session.e.o();
        return CollectionsKt.k(androidx.media3.session.e.i(iconCreateWithResource, str, str, broadcast));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0059 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean f(com.facebook.react.uimanager.ThemedReactContext r5) {
        /*
            androidx.activity.ComponentActivity r0 = com.brentvatne.exoplayer.PictureInPictureUtilKt.a(r5)
            r1 = 0
            if (r0 != 0) goto L8
            goto L5a
        L8:
            android.content.pm.PackageManager r2 = r0.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5a
            android.content.ComponentName r3 = r0.getComponentName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5a
            r4 = 128(0x80, float:1.794E-43)
            android.content.pm.ActivityInfo r2 = r2.getActivityInfo(r3, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5a
            int r2 = r2.flags
            r3 = 4194304(0x400000, float:5.877472E-39)
            r2 = r2 & r3
            r3 = 1
            if (r2 == 0) goto L20
            r2 = r3
            goto L21
        L20:
            r2 = r1
        L21:
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            java.lang.String r4 = "android.software.picture_in_picture"
            boolean r0 = r0.hasSystemFeature(r4)
            if (r2 == 0) goto L5a
            if (r0 == 0) goto L5a
            com.facebook.react.bridge.ReactApplicationContext r5 = r5.f19479a
            android.app.Activity r5 = r5.getCurrentActivity()
            if (r5 != 0) goto L38
            goto L5a
        L38:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r0 < r2) goto L57
            int r0 = android.os.Process.myUid()
            java.lang.String r2 = r5.getPackageName()
            java.lang.String r4 = "appops"
            java.lang.Object r5 = r5.getSystemService(r4)
            android.app.AppOpsManager r5 = (android.app.AppOpsManager) r5
            java.lang.String r4 = "android:picture_in_picture"
            int r5 = r5.noteOpNoThrow(r4, r0, r2)
            if (r5 != 0) goto L5a
            goto L59
        L57:
            if (r0 >= r2) goto L5a
        L59:
            return r3
        L5a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.brentvatne.exoplayer.PictureInPictureUtil.f(com.facebook.react.uimanager.ThemedReactContext):boolean");
    }

    public static void g(ThemedReactContext themedReactContext, PictureInPictureParams pictureInPictureParams) {
        if (Build.VERSION.SDK_INT < 26 || !f(themedReactContext)) {
            return;
        }
        try {
            PictureInPictureUtilKt.a(themedReactContext).setPictureInPictureParams(pictureInPictureParams);
        } catch (IllegalStateException e2) {
            DebugLog.b("PictureInPictureUtil", e2.toString());
        }
    }
}
