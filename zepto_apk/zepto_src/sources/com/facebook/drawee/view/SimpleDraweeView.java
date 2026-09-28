package com.facebook.drawee.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.R;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilderSupplier;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;

@Deprecated
/* loaded from: classes.dex */
public class SimpleDraweeView extends GenericDraweeView {

    /* renamed from: i, reason: collision with root package name */
    public static PipelineDraweeControllerBuilderSupplier f17460i;

    /* renamed from: h, reason: collision with root package name */
    public AbstractDraweeControllerBuilder f17461h;

    public SimpleDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context, attributeSet);
    }

    public final void d(Context context, AttributeSet attributeSet) {
        int resourceId;
        try {
            FrescoSystrace.a();
            if (isInEditMode()) {
                getTopLevelDrawable().setVisible(true, false);
                getTopLevelDrawable().invalidateSelf();
            } else {
                Preconditions.d(f17460i, "SimpleDraweeView was not initialized!");
                this.f17461h = f17460i.get();
            }
            if (attributeSet != null) {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SimpleDraweeView);
                try {
                    if (typedArrayObtainStyledAttributes.hasValue(R.styleable.SimpleDraweeView_actualImageUri)) {
                        e(Uri.parse(typedArrayObtainStyledAttributes.getString(R.styleable.SimpleDraweeView_actualImageUri)));
                    } else if (typedArrayObtainStyledAttributes.hasValue(R.styleable.SimpleDraweeView_actualImageResource) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.SimpleDraweeView_actualImageResource, -1)) != -1) {
                        if (isInEditMode()) {
                            setImageResource(resourceId);
                        } else {
                            setActualImageResource(resourceId);
                        }
                    }
                    typedArrayObtainStyledAttributes.recycle();
                } catch (Throwable th) {
                    typedArrayObtainStyledAttributes.recycle();
                    throw th;
                }
            }
            FrescoSystrace.a();
        } catch (Throwable th2) {
            FrescoSystrace.a();
            throw th2;
        }
    }

    public final void e(Uri uri) {
        AbstractDraweeControllerBuilder abstractDraweeControllerBuilder = this.f17461h;
        abstractDraweeControllerBuilder.f17265a = null;
        PipelineDraweeControllerBuilder pipelineDraweeControllerBuilder = (PipelineDraweeControllerBuilder) abstractDraweeControllerBuilder;
        pipelineDraweeControllerBuilder.f(uri);
        pipelineDraweeControllerBuilder.f17270f = getController();
        setController(pipelineDraweeControllerBuilder.a());
    }

    public AbstractDraweeControllerBuilder getControllerBuilder() {
        return this.f17461h;
    }

    public void setActualImageResource(@DrawableRes int i2) {
        e(UriUtil.c(i2));
    }

    public void setImageRequest(ImageRequest imageRequest) {
        AbstractDraweeControllerBuilder abstractDraweeControllerBuilder = this.f17461h;
        abstractDraweeControllerBuilder.f17266b = imageRequest;
        abstractDraweeControllerBuilder.f17270f = getController();
        setController(abstractDraweeControllerBuilder.a());
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageResource(int i2) {
        super.setImageResource(i2);
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        e(uri);
    }

    public void setImageURI(@Nullable String str) {
        e(str != null ? Uri.parse(str) : null);
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        d(context, attributeSet);
    }
}
