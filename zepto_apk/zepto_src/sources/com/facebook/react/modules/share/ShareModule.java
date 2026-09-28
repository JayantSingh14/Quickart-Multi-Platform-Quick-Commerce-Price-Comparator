package com.facebook.react.modules.share;

import android.app.Activity;
import android.content.Intent;
import coil3.network.internal.UtilsKt;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.fbreact.specs.NativeShareModuleSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = "ShareModule")
@Metadata
/* loaded from: classes.dex */
public final class ShareModule extends NativeShareModuleSpec {

    @NotNull
    private static final String ACTION_SHARED = "sharedAction";

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String ERROR_INVALID_CONTENT = "E_INVALID_CONTENT";

    @NotNull
    private static final String ERROR_UNABLE_TO_OPEN_DIALOG = "E_UNABLE_TO_OPEN_DIALOG";

    @NotNull
    public static final String NAME = "ShareModule";

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @Override // com.facebook.fbreact.specs.NativeShareModuleSpec
    public void share(@Nullable ReadableMap readableMap, @Nullable String str, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (readableMap == null) {
            promise.reject(ERROR_INVALID_CONTENT, "Content cannot be null");
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setTypeAndNormalize(UtilsKt.MIME_TYPE_TEXT_PLAIN);
            if (readableMap.hasKey("title")) {
                intent.putExtra("android.intent.extra.SUBJECT", readableMap.getString("title"));
            }
            if (readableMap.hasKey(APayConstants.Error.MESSAGE)) {
                intent.putExtra("android.intent.extra.TEXT", readableMap.getString(APayConstants.Error.MESSAGE));
            }
            Intent intentCreateChooser = Intent.createChooser(intent, str);
            intentCreateChooser.addCategory("android.intent.category.DEFAULT");
            Activity currentActivity = getCurrentActivity();
            if (currentActivity != null) {
                currentActivity.startActivity(intentCreateChooser);
            } else {
                getReactApplicationContext().startActivity(intentCreateChooser);
            }
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("action", ACTION_SHARED);
            promise.resolve(writableMapCreateMap);
        } catch (Exception unused) {
            promise.reject(ERROR_UNABLE_TO_OPEN_DIALOG, "Failed to open share dialog");
        }
    }
}
