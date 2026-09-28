package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.util.Pools;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.concurrent.ThreadSafe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ThreadSafe
@Metadata
@TargetApi(21)
/* loaded from: classes3.dex */
public final class ArtDecoder extends DefaultDecoder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtDecoder(BitmapPool bitmapPool, Pools.Pool decodeBuffers, PlatformDecoderOptions platformDecoderOptions) {
        super(bitmapPool, decodeBuffers, platformDecoderOptions);
        Intrinsics.checkNotNullParameter(bitmapPool, "bitmapPool");
        Intrinsics.checkNotNullParameter(decodeBuffers, "decodeBuffers");
        Intrinsics.checkNotNullParameter(platformDecoderOptions, "platformDecoderOptions");
    }

    @Override // com.facebook.imagepipeline.platform.DefaultDecoder
    public final int d(int i2, int i3, BitmapFactory.Options options) {
        Intrinsics.checkNotNullParameter(options, "options");
        Bitmap.Config config = options.inPreferredConfig;
        if (config != null) {
            return BitmapUtil.c(i2, i3, config);
        }
        throw new IllegalStateException("Required value was null.");
    }
}
