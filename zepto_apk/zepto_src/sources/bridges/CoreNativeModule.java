package bridges;

import android.app.Activity;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class CoreNativeModule extends ReactContextBaseJavaModule {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String NAME = "CoreNativeModule";

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoreNativeModule(@NotNull ReactApplicationContext reactAppContext) {
        super(reactAppContext);
        Intrinsics.checkNotNullParameter(reactAppContext, "reactAppContext");
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public final void reportFullyDrawn() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.reportFullyDrawn();
        }
    }
}
