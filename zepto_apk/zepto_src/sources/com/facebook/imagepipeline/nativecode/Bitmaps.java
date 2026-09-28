package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.soloader.nativeloader.NativeLoader;
import java.util.List;

@DoNotStrip
@Nullsafe
/* loaded from: classes3.dex */
public class Bitmaps {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f18061a = 0;

    static {
        List list = ImagePipelineNativeLoader.f18064a;
        NativeLoader.b("imagepipeline");
    }

    @DoNotStrip
    public static void copyBitmap(Bitmap bitmap, Bitmap bitmap2) {
        Preconditions.a(Boolean.valueOf(bitmap2.getConfig() == bitmap.getConfig()));
        Preconditions.a(Boolean.valueOf(bitmap.isMutable()));
        Preconditions.a(Boolean.valueOf(bitmap.getWidth() == bitmap2.getWidth()));
        Preconditions.a(Boolean.valueOf(bitmap.getHeight() == bitmap2.getHeight()));
        nativeCopyBitmap(bitmap, bitmap.getRowBytes(), bitmap2, bitmap2.getRowBytes(), bitmap.getHeight());
    }

    @DoNotStrip
    private static native void nativeCopyBitmap(Bitmap bitmap, int i2, Bitmap bitmap2, int i3, int i4);
}
