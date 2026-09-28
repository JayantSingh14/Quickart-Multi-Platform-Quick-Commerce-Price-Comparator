package com.facebook.react.bridge;

import android.content.res.AssetManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public interface JSBundleLoaderDelegate {
    void loadScriptFromAssets(@NotNull AssetManager assetManager, @NotNull String str, boolean z);

    void loadScriptFromFile(@NotNull String str, @NotNull String str2, boolean z);

    void loadSplitBundleFromFile(@NotNull String str, @NotNull String str2);

    void setSourceURLs(@NotNull String str, @NotNull String str2);
}
