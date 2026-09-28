package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import javax.annotation.concurrent.ThreadSafe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ThreadSafe
@Metadata
/* loaded from: classes3.dex */
public final class HoneycombBitmapFactory extends PlatformBitmapFactory {

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public final CloseableReference a(int i2, int i3, Bitmap.Config bitmapConfig) {
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        throw null;
    }
}
