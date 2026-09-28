package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class DummyBitmapPool implements BitmapPool {
    @Override // com.facebook.common.memory.Pool, com.facebook.common.references.ResourceReleaser
    public final void a(Object obj) {
        Bitmap value = (Bitmap) obj;
        Intrinsics.checkNotNullParameter(value, "value");
        value.recycle();
    }

    @Override // com.facebook.common.memory.Pool
    public final Object get(int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, (int) Math.ceil(i2 / 2.0d), Bitmap.Config.RGB_565);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        return bitmapCreateBitmap;
    }
}
