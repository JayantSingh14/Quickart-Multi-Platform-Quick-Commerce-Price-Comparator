package com.facebook.react.views.view;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.TypedValue;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.PixelUtil;
import in.juspay.hyper.constants.LogSubCategory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ReactDrawableHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final TypedValue f20236a = new TypedValue();

    public static final Drawable a(Context context, ReadableMap drawableDescriptionDict) throws Resources.NotFoundException {
        int color;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(drawableDescriptionDict, "drawableDescriptionDict");
        String string = drawableDescriptionDict.getString("type");
        boolean zEquals = "ThemeAttrAndroid".equals(string);
        TypedValue typedValue = f20236a;
        if (!zEquals) {
            if (!"RippleAndroid".equals(string)) {
                throw new JSApplicationIllegalArgumentException(android.support.v4.media.b.C("Invalid type for android drawable: ", string));
            }
            if (drawableDescriptionDict.hasKey("color") && !drawableDescriptionDict.isNull("color")) {
                color = drawableDescriptionDict.getInt("color");
            } else {
                if (!context.getTheme().resolveAttribute(R.attr.colorControlHighlight, typedValue, true)) {
                    throw new JSApplicationIllegalArgumentException("Attribute colorControlHighlight couldn't be resolved into a drawable");
                }
                color = context.getResources().getColor(typedValue.resourceId, context.getTheme());
            }
            RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{color}), null, (drawableDescriptionDict.hasKey("borderless") && !drawableDescriptionDict.isNull("borderless") && drawableDescriptionDict.getBoolean("borderless")) ? null : new ColorDrawable(-1));
            if (drawableDescriptionDict.hasKey("rippleRadius")) {
                rippleDrawable.setRadius((int) PixelUtil.b((float) drawableDescriptionDict.getDouble("rippleRadius")));
            }
            return rippleDrawable;
        }
        String string2 = drawableDescriptionDict.getString("attribute");
        if (string2 == null) {
            throw new JSApplicationIllegalArgumentException("JS description missing 'attribute' field");
        }
        int identifier = "selectableItemBackground".equals(string2) ? R.attr.selectableItemBackground : "selectableItemBackgroundBorderless".equals(string2) ? R.attr.selectableItemBackgroundBorderless : context.getResources().getIdentifier(string2, "attr", LogSubCategory.LifeCycle.ANDROID);
        if (context.getTheme().resolveAttribute(identifier, typedValue, true)) {
            Drawable drawable = context.getResources().getDrawable(typedValue.resourceId, context.getTheme());
            if (drawableDescriptionDict.hasKey("rippleRadius") && (drawable instanceof RippleDrawable)) {
                ((RippleDrawable) drawable).setRadius((int) PixelUtil.b((float) drawableDescriptionDict.getDouble("rippleRadius")));
            }
            return drawable;
        }
        throw new JSApplicationIllegalArgumentException("Attribute " + string2 + " with id " + identifier + " couldn't be resolved into a drawable");
    }
}
