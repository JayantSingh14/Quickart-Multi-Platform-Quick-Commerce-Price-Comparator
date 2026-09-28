package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public abstract class BaseBitmapReferenceDataSubscriber extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void f(DataSource dataSource) {
        if (dataSource.b()) {
            CloseableReference closeableReference = (CloseableReference) dataSource.a();
            CloseableReference closeableReferenceG = (closeableReference == null || !(closeableReference.l() instanceof CloseableStaticBitmap)) ? null : ((CloseableStaticBitmap) closeableReference.l()).G();
            try {
                g();
            } finally {
                CloseableReference.e(closeableReferenceG);
                CloseableReference.e(closeableReference);
            }
        }
    }

    public abstract void g();
}
