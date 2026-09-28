package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.soloader.DoNotOptimize;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@DoNotOptimize
@Metadata
/* loaded from: classes.dex */
public final class PreverificationHelper {
    @DoNotOptimize
    @TargetApi(26)
    public final boolean shouldUseHardwareBitmapConfig(@Nullable Bitmap.Config config) {
        return config == Bitmap.Config.HARDWARE;
    }
}
