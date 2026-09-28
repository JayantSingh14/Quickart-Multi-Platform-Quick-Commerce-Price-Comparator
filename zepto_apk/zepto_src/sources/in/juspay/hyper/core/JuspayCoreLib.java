package in.juspay.hyper.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata
/* loaded from: classes4.dex */
public final class JuspayCoreLib {

    @NotNull
    public static final JuspayCoreLib INSTANCE = new JuspayCoreLib();

    @Nullable
    private static Context applicationContext;
    private static boolean isMultiClientIntegration;

    private JuspayCoreLib() {
    }

    @Nullable
    public static final Context getApplicationContext() {
        return applicationContext;
    }

    @JvmStatic
    public static /* synthetic */ void getApplicationContext$annotations() {
    }

    public static final boolean isAppDebuggable() {
        Context context = applicationContext;
        return (context == null || (context.getApplicationInfo().flags & 2) == 0) ? false : true;
    }

    @JvmStatic
    public static /* synthetic */ void isAppDebuggable$annotations() {
    }

    public static final boolean isMultiClientIntegration() {
        return isMultiClientIntegration;
    }

    @JvmStatic
    public static /* synthetic */ void isMultiClientIntegration$annotations() {
    }

    @JvmStatic
    @SuppressLint({"DiscouragedApi"})
    public static final void setApplicationContext(@NotNull Context applicationContext2) {
        Intrinsics.checkNotNullParameter(applicationContext2, "applicationContext");
        applicationContext = applicationContext2;
        try {
            isMultiClientIntegration = Intrinsics.b(applicationContext2.getString(applicationContext2.getResources().getIdentifier("multiclient_integration", "string", applicationContext2.getPackageName())), "true");
        } catch (Resources.NotFoundException unused) {
        }
    }
}
