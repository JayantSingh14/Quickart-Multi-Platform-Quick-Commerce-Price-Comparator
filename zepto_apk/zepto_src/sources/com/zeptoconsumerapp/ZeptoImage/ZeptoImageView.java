package com.zeptoconsumerapp.ZeptoImage;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import androidx.appcompat.widget.AppCompatImageView;
import coil3.transform.Transformation;
import com.zeptoconsumerapp.ZeptoImage.Transformations.ColorFilterTransformation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class ZeptoImageView extends AppCompatImageView {

    /* renamed from: d, reason: collision with root package name */
    public String f47577d;

    /* renamed from: e, reason: collision with root package name */
    public Integer f47578e;

    /* renamed from: f, reason: collision with root package name */
    public String f47579f;

    @Nullable
    public final String getSourceUri() {
        return this.f47577d;
    }

    @Nullable
    public final String getThumbHash() {
        return this.f47579f;
    }

    @Nullable
    public final Drawable getThumbHashDrawable() {
        String str = this.f47579f;
        if (str == null) {
            return null;
        }
        byte[] bArrDecode = Base64.decode(str, 0);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        return new BitmapDrawable(getContext().getResources(), ThumbHash.a(bArrDecode));
    }

    @Nullable
    public final Integer getTintColorValue() {
        return this.f47578e;
    }

    @NotNull
    public final List<Transformation> getTransformations() {
        ArrayList arrayList = new ArrayList();
        Integer num = this.f47578e;
        if (num != null) {
            arrayList.add(new ColorFilterTransformation(num.intValue()));
        }
        return arrayList;
    }

    public final void setSourceUri(@Nullable String str) {
        this.f47577d = str;
    }

    public final void setThumbHash(@Nullable String str) {
        this.f47579f = str;
    }

    public final void setTintColorValue(@Nullable Integer num) {
        this.f47578e = num;
    }
}
