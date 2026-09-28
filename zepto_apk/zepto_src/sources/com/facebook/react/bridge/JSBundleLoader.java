package com.facebook.react.bridge;

import android.content.Context;
import com.facebook.react.common.DebugServerException;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class JSBundleLoader {
    public static JSBundleLoader createAssetLoader(final Context context, final String str, final boolean z) {
        return new JSBundleLoader() { // from class: com.facebook.react.bridge.JSBundleLoader.1
            @Override // com.facebook.react.bridge.JSBundleLoader
            public String loadScript(JSBundleLoaderDelegate jSBundleLoaderDelegate) {
                jSBundleLoaderDelegate.loadScriptFromAssets(context.getAssets(), str, z);
                return str;
            }
        };
    }

    public static JSBundleLoader createCachedBundleFromNetworkLoader(final String str, final String str2) {
        return new JSBundleLoader() { // from class: com.facebook.react.bridge.JSBundleLoader.3
            @Override // com.facebook.react.bridge.JSBundleLoader
            public String loadScript(JSBundleLoaderDelegate jSBundleLoaderDelegate) {
                try {
                    jSBundleLoaderDelegate.loadScriptFromFile(str2, str, false);
                    return str;
                } catch (Exception e2) {
                    String url = str;
                    String reason = Objects.toString(e2.getMessage(), "");
                    int i2 = DebugServerException.f18690a;
                    Intrinsics.checkNotNullParameter(url, "url");
                    Intrinsics.checkNotNullParameter(reason, "reason");
                    throw DebugServerException.Companion.a(url, reason, "", e2);
                }
            }
        };
    }

    public static JSBundleLoader createCachedSplitBundleFromNetworkLoader(final String str, final String str2) {
        return new JSBundleLoader() { // from class: com.facebook.react.bridge.JSBundleLoader.4
            @Override // com.facebook.react.bridge.JSBundleLoader
            public String loadScript(JSBundleLoaderDelegate jSBundleLoaderDelegate) {
                try {
                    jSBundleLoaderDelegate.loadSplitBundleFromFile(str2, str);
                    return str;
                } catch (Exception e2) {
                    String url = str;
                    String reason = Objects.toString(e2.getMessage(), "");
                    int i2 = DebugServerException.f18690a;
                    Intrinsics.checkNotNullParameter(url, "url");
                    Intrinsics.checkNotNullParameter(reason, "reason");
                    throw DebugServerException.Companion.a(url, reason, "", e2);
                }
            }
        };
    }

    public static JSBundleLoader createFileLoader(String str) {
        return createFileLoader(str, str, false);
    }

    public static JSBundleLoader createRemoteDebuggerBundleLoader(final String str, final String str2) {
        return new JSBundleLoader() { // from class: com.facebook.react.bridge.JSBundleLoader.5
            @Override // com.facebook.react.bridge.JSBundleLoader
            public String loadScript(JSBundleLoaderDelegate jSBundleLoaderDelegate) {
                jSBundleLoaderDelegate.setSourceURLs(str2, str);
                return str2;
            }
        };
    }

    public abstract String loadScript(JSBundleLoaderDelegate jSBundleLoaderDelegate);

    public static JSBundleLoader createFileLoader(final String str, final String str2, final boolean z) {
        return new JSBundleLoader() { // from class: com.facebook.react.bridge.JSBundleLoader.2
            @Override // com.facebook.react.bridge.JSBundleLoader
            public String loadScript(JSBundleLoaderDelegate jSBundleLoaderDelegate) {
                jSBundleLoaderDelegate.loadScriptFromFile(str, str2, z);
                return str;
            }
        };
    }
}
