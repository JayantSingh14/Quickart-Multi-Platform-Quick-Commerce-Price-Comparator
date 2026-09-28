package androidx.activity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import in.juspay.hypernfc.NfcActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@JvmName
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class EdgeToEdge {

    /* renamed from: a, reason: collision with root package name */
    public static final int f139a = Color.argb(230, 255, 255, 255);

    /* renamed from: b, reason: collision with root package name */
    public static final int f140b = Color.argb(128, 27, 27, 27);

    public static void a(NfcActivity nfcActivity) {
        SystemBarStyle$Companion$auto$1 detectDarkMode = SystemBarStyle$Companion$auto$1.f178c;
        Intrinsics.checkNotNullParameter(detectDarkMode, "detectDarkMode");
        SystemBarStyle statusBarStyle = new SystemBarStyle(0, 0);
        Intrinsics.checkNotNullParameter(detectDarkMode, "detectDarkMode");
        SystemBarStyle navigationBarStyle = new SystemBarStyle(f139a, f140b);
        Intrinsics.checkNotNullParameter(nfcActivity, "<this>");
        Intrinsics.checkNotNullParameter(statusBarStyle, "statusBarStyle");
        Intrinsics.checkNotNullParameter(navigationBarStyle, "navigationBarStyle");
        View decorView = nfcActivity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        Resources resources = decorView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        boolean zBooleanValue = ((Boolean) detectDarkMode.invoke(resources)).booleanValue();
        Resources resources2 = decorView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "view.resources");
        boolean zBooleanValue2 = ((Boolean) detectDarkMode.invoke(resources2)).booleanValue();
        int i2 = Build.VERSION.SDK_INT;
        EdgeToEdgeImpl edgeToEdgeApi30 = i2 >= 30 ? new EdgeToEdgeApi30() : i2 >= 29 ? new EdgeToEdgeApi29() : i2 >= 28 ? new EdgeToEdgeApi28() : i2 >= 26 ? new EdgeToEdgeApi26() : new EdgeToEdgeApi23();
        Window window = nfcActivity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        edgeToEdgeApi30.b(statusBarStyle, navigationBarStyle, window, decorView, zBooleanValue, zBooleanValue2);
        Window window2 = nfcActivity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window2, "window");
        edgeToEdgeApi30.a(window2);
    }
}
