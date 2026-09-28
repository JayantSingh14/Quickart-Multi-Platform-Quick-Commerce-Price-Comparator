package com.facebook.react.modules.appearance;

import android.content.Context;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.helper.widget.a;
import com.facebook.fbreact.specs.NativeAppearanceSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = "Appearance")
@Metadata
/* loaded from: classes.dex */
public final class AppearanceModule extends NativeAppearanceSpec {

    @NotNull
    private static final String APPEARANCE_CHANGED_EVENT_NAME = "appearanceChanged";

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String NAME = "Appearance";

    @Nullable
    private String lastEmittedColorScheme;

    @Nullable
    private final OverrideColorScheme overrideColorScheme;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    @Metadata
    /* loaded from: classes3.dex */
    public interface OverrideColorScheme {
        String a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public AppearanceModule(@NotNull ReactApplicationContext reactContext) {
        this(reactContext, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    private final String colorSchemeForCurrentConfiguration(Context context) {
        OverrideColorScheme overrideColorScheme = this.overrideColorScheme;
        if (overrideColorScheme != null) {
            return overrideColorScheme.a();
        }
        int i2 = context.getResources().getConfiguration().uiMode & 48;
        return (i2 == 16 || i2 != 32) ? "light" : "dark";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setColorScheme$lambda$0(String str) {
        int iHashCode = str.hashCode();
        if (iHashCode == -1626174665) {
            if (str.equals("unspecified")) {
                AppCompatDelegate.A(-1);
            }
        } else if (iHashCode == 3075958) {
            if (str.equals("dark")) {
                AppCompatDelegate.A(2);
            }
        } else if (iHashCode == 102970646 && str.equals("light")) {
            AppCompatDelegate.A(1);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeAppearanceSpec
    public void addListener(@NotNull String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    public final void emitAppearanceChanged(@NotNull String colorScheme) {
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("colorScheme", colorScheme);
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            reactApplicationContextIfActiveOrWarn.emitDeviceEvent(APPEARANCE_CHANGED_EVENT_NAME, writableMapCreateMap);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeAppearanceSpec
    @NotNull
    public String getColorScheme() {
        Context currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            currentActivity = getReactApplicationContext();
        }
        Intrinsics.c(currentActivity);
        return colorSchemeForCurrentConfiguration(currentActivity);
    }

    public final void onConfigurationChanged(@NotNull Context currentContext) {
        Intrinsics.checkNotNullParameter(currentContext, "currentContext");
        String strColorSchemeForCurrentConfiguration = colorSchemeForCurrentConfiguration(currentContext);
        if (Intrinsics.b(this.lastEmittedColorScheme, strColorSchemeForCurrentConfiguration)) {
            return;
        }
        this.lastEmittedColorScheme = strColorSchemeForCurrentConfiguration;
        emitAppearanceChanged(strColorSchemeForCurrentConfiguration);
    }

    @Override // com.facebook.fbreact.specs.NativeAppearanceSpec
    public void removeListeners(double d2) {
    }

    @Override // com.facebook.fbreact.specs.NativeAppearanceSpec
    public void setColorScheme(@NotNull String style) {
        Intrinsics.checkNotNullParameter(style, "style");
        UiThreadUtil.runOnUiThread(new a(style, 15));
    }

    public /* synthetic */ AppearanceModule(ReactApplicationContext reactApplicationContext, OverrideColorScheme overrideColorScheme, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(reactApplicationContext, (i2 & 2) != 0 ? null : overrideColorScheme);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AppearanceModule(@NotNull ReactApplicationContext reactContext, @Nullable OverrideColorScheme overrideColorScheme) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.overrideColorScheme = overrideColorScheme;
    }
}
