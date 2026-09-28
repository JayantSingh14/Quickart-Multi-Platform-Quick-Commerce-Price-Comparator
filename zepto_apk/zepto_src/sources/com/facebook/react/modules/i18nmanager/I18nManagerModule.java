package com.facebook.react.modules.i18nmanager;

import android.content.SharedPreferences;
import com.facebook.fbreact.specs.NativeI18nManagerSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = "I18nManager")
@Metadata
/* loaded from: classes.dex */
public final class I18nManagerModule extends NativeI18nManagerSpec {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String NAME = "I18nManager";

    @Metadata
    public static final class Companion {
    }

    public I18nManagerModule(@Nullable ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.fbreact.specs.NativeI18nManagerSpec
    public void allowRTL(boolean z) {
        ReactApplicationContext context = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(context, "getReactApplicationContext(...)");
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.facebook.react.modules.i18nmanager.I18nUtil", 0).edit();
        editorEdit.putBoolean("RCTI18nUtil_allowRTL", z);
        editorEdit.apply();
    }

    @Override // com.facebook.fbreact.specs.NativeI18nManagerSpec
    public void forceRTL(boolean z) {
        ReactApplicationContext context = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(context, "getReactApplicationContext(...)");
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.facebook.react.modules.i18nmanager.I18nUtil", 0).edit();
        editorEdit.putBoolean("RCTI18nUtil_forceRTL", z);
        editorEdit.apply();
    }

    @Override // com.facebook.fbreact.specs.NativeI18nManagerSpec
    @NotNull
    public Map<String, Object> getTypedExportedConstants() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        return MapsKt.h(new Pair("isRTL", Boolean.valueOf(I18nUtil.b(reactApplicationContext))), new Pair("doLeftAndRightSwapInRTL", Boolean.valueOf(I18nUtil.a(reactApplicationContext))), new Pair("localeIdentifier", reactApplicationContext.getResources().getConfiguration().getLocales().get(0).toString()));
    }

    @Override // com.facebook.fbreact.specs.NativeI18nManagerSpec
    public void swapLeftAndRightInRTL(boolean z) {
        ReactApplicationContext context = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(context, "getReactApplicationContext(...)");
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.facebook.react.modules.i18nmanager.I18nUtil", 0).edit();
        editorEdit.putBoolean("RCTI18nUtil_makeRTLFlipLeftAndRightStyles", z);
        editorEdit.apply();
    }
}
