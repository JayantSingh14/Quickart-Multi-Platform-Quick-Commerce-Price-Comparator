package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class SimpleBitmapReleaser implements ResourceReleaser<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    public static SimpleBitmapReleaser f17718a;

    public static SimpleBitmapReleaser b() {
        if (f17718a == null) {
            f17718a = new SimpleBitmapReleaser();
        }
        return f17718a;
    }

    @Override // com.facebook.common.references.ResourceReleaser
    public final void a(Object obj) {
        ((Bitmap) obj).recycle();
    }
}
