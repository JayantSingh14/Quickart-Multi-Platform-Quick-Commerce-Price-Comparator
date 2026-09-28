package bridges;

import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.zeptoconsumerapp.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class JSIModules extends ReactContextBaseJavaModule {

    @NotNull
    public static final Companion Companion = new Companion();

    @Metadata
    public static final class Companion {
    }

    static {
        System.loadLibrary("cppJsiModules");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JSIModules(@NotNull ReactApplicationContext reactAppContext) {
        super(reactAppContext);
        Intrinsics.checkNotNullParameter(reactAppContext, "reactAppContext");
    }

    private final native void install(long j2);

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return "JSIModules";
    }

    @ReactMethod(isBlockingSynchronousMethod = BuildConfig.IS_HERMES_ENABLED)
    public final void installCppModules() {
        JavaScriptContextHolder javaScriptContextHolder = getReactApplicationContext().getJavaScriptContextHolder();
        Long lValueOf = javaScriptContextHolder != null ? Long.valueOf(javaScriptContextHolder.get()) : null;
        Intrinsics.c(lValueOf);
        install(lValueOf.longValue());
    }
}
