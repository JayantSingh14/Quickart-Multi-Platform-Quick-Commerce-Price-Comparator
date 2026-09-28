package com.facebook.react.views.imagehelper;

import android.content.Context;
import android.net.Uri;
import com.facebook.react.modules.fresco.ImageCacheControl;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public class ImageSource {

    /* renamed from: a, reason: collision with root package name */
    public final String f19963a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageCacheControl f19964b;

    /* renamed from: c, reason: collision with root package name */
    public final Uri f19965c;

    /* renamed from: d, reason: collision with root package name */
    public final double f19966d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f19967e;

    @Metadata
    public static final class Companion {
        public static ImageSource a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new ImageSource(context, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII=", ImageCacheControl.f19112a, 12);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageSource(Context context, String str) {
        this(context, str, null, 28);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final ImageCacheControl a() {
        return this.f19964b;
    }

    public final Uri b() {
        return this.f19965c;
    }

    public final boolean c() {
        return this.f19967e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        ImageSource imageSource = (ImageSource) obj;
        return Double.compare(imageSource.f19966d, this.f19966d) == 0 && this.f19967e == imageSource.f19967e && Intrinsics.b(this.f19965c, imageSource.f19965c) && Intrinsics.b(this.f19963a, imageSource.f19963a) && this.f19964b == imageSource.f19964b;
    }

    public final int hashCode() {
        return Objects.hash(this.f19965c, this.f19963a, Double.valueOf(this.f19966d), Boolean.valueOf(this.f19967e), this.f19964b);
    }

    public ImageSource(Context context, String str, double d2, double d3, ImageCacheControl cacheControl) {
        Uri uriD;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cacheControl, "cacheControl");
        this.f19963a = str;
        this.f19964b = cacheControl;
        try {
            uriD = Uri.parse(str);
            if (uriD.getScheme() == null) {
                this.f19967e = true;
                uriD = ResourceDrawableIdHelper.f19970b.d(context, str);
            }
        } catch (NullPointerException unused) {
            this.f19967e = true;
            uriD = ResourceDrawableIdHelper.f19970b.d(context, this.f19963a);
        }
        this.f19965c = uriD;
        this.f19966d = d2 * d3;
    }

    public /* synthetic */ ImageSource(Context context, String str, ImageCacheControl imageCacheControl, int i2) {
        this(context, str, 0.0d, 0.0d, (i2 & 16) != 0 ? ImageCacheControl.f19112a : imageCacheControl);
    }
}
