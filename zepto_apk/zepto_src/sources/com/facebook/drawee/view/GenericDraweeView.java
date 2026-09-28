package com.facebook.drawee.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyInflater;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.Nullsafe;
import javax.annotation.Nullable;

@Nullsafe
@Deprecated
/* loaded from: classes.dex */
public class GenericDraweeView extends DraweeView<GenericDraweeHierarchy> {
    public GenericDraweeView(Context context, @Nullable AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        c(context, attributeSet);
    }

    public final void c(Context context, AttributeSet attributeSet) throws Throwable {
        FrescoSystrace.a();
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilderD = GenericDraweeHierarchyInflater.d(context, attributeSet);
        setAspectRatio(genericDraweeHierarchyBuilderD.b());
        setHierarchy(genericDraweeHierarchyBuilderD.a());
        FrescoSystrace.a();
    }

    public GenericDraweeView(Context context, @Nullable AttributeSet attributeSet, int i2) throws Throwable {
        super(context, attributeSet, i2);
        c(context, attributeSet);
    }
}
