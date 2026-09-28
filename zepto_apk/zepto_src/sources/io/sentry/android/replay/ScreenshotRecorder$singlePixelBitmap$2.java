package io.sentry.android.replay;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class ScreenshotRecorder$singlePixelBitmap$2 extends Lambda implements Function0<Bitmap> {

    /* renamed from: c, reason: collision with root package name */
    public static final ScreenshotRecorder$singlePixelBitmap$2 f52483c = new ScreenshotRecorder$singlePixelBitmap$2(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(\n          …onfig.ARGB_8888\n        )");
        return bitmapCreateBitmap;
    }
}
