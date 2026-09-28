package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.concurrent.ThreadSafe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ThreadSafe
@Metadata
@TargetApi(26)
/* loaded from: classes.dex */
public final class OreoDecoder extends DefaultDecoder {
    @Override // com.facebook.imagepipeline.platform.DefaultDecoder
    public final int d(int i2, int i3, BitmapFactory.Options options) {
        Intrinsics.checkNotNullParameter(options, "options");
        Bitmap.Config config = options.outConfig;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        return BitmapUtil.c(i2, i3, config);
    }
}
