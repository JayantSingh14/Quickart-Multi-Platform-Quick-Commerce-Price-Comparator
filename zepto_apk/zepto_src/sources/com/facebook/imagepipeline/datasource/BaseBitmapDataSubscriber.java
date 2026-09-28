package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public abstract class BaseBitmapDataSubscriber extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void f(DataSource dataSource) {
        if (dataSource.b()) {
            CloseableReference closeableReference = (CloseableReference) dataSource.a();
            try {
                g((closeableReference == null || !(closeableReference.l() instanceof CloseableBitmap)) ? null : ((CloseableBitmap) closeableReference.l()).v1());
            } finally {
                CloseableReference.e(closeableReference);
            }
        }
    }

    public abstract void g(Bitmap bitmap);
}
