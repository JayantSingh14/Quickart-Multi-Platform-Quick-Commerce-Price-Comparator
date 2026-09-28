package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Fn;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.facebook.drawee.debug.listener.ImageLoadingTimeControllerListener;
import com.facebook.drawee.drawable.ArrayDrawable;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.xml.XmlDrawableFactory;
import com.facebook.infer.annotation.Nullsafe;
import java.util.HashSet;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

@Nullsafe
/* loaded from: classes3.dex */
public class PipelineDraweeController extends AbstractDraweeController<CloseableReference<CloseableImage>, ImageInfo> {
    public ImageRequest A;
    public final DefaultDrawableFactory t;
    public final InstrumentedMemoryCache u;
    public CacheKey v;
    public Supplier w;
    public boolean x;
    public HashSet y;
    public ImageRequest z;

    public PipelineDraweeController(Resources resources, DeferredReleaser deferredReleaser, DrawableFactory drawableFactory, XmlDrawableFactory xmlDrawableFactory, UiThreadImmediateExecutorService uiThreadImmediateExecutorService, InstrumentedMemoryCache instrumentedMemoryCache) {
        super(deferredReleaser, uiThreadImmediateExecutorService);
        this.t = new DefaultDrawableFactory(resources, drawableFactory, xmlDrawableFactory);
        this.u = instrumentedMemoryCache;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ScaleTypeDrawable C(Drawable drawable) {
        if (drawable == 0) {
            return null;
        }
        if (drawable instanceof ScaleTypeDrawable) {
            return (ScaleTypeDrawable) drawable;
        }
        if (drawable instanceof DrawableParent) {
            return C(((DrawableParent) drawable).getDrawable());
        }
        if (!(drawable instanceof ArrayDrawable)) {
            return null;
        }
        ArrayDrawable arrayDrawable = (ArrayDrawable) drawable;
        int length = arrayDrawable.f17298c.length;
        for (int i2 = 0; i2 < length; i2++) {
            ScaleTypeDrawable scaleTypeDrawableC = C(arrayDrawable.a(i2));
            if (scaleTypeDrawableC != null) {
                return scaleTypeDrawableC;
            }
        }
        return null;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public final void A(Object obj) {
        CloseableReference.e((CloseableReference) obj);
    }

    public final void D(CloseableImage closeableImage) {
        ScaleTypeDrawable scaleTypeDrawableC;
        if (this.x) {
            if (this.f17252g == null) {
                DebugControllerOverlayDrawable debugControllerOverlayDrawable = new DebugControllerOverlayDrawable();
                f(new ImageLoadingTimeControllerListener(debugControllerOverlayDrawable));
                this.f17252g = debugControllerOverlayDrawable;
                SettableDraweeHierarchy settableDraweeHierarchy = this.f17251f;
                if (settableDraweeHierarchy != null) {
                    settableDraweeHierarchy.a(debugControllerOverlayDrawable);
                }
            }
            DebugControllerOverlayDrawable debugControllerOverlayDrawable2 = this.f17252g;
            if (debugControllerOverlayDrawable2 != null) {
                String str = this.f17253h;
                debugControllerOverlayDrawable2.getClass();
                if (str == null) {
                    str = "none";
                }
                debugControllerOverlayDrawable2.f17281a = str;
                debugControllerOverlayDrawable2.invalidateSelf();
                SettableDraweeHierarchy settableDraweeHierarchy2 = this.f17251f;
                debugControllerOverlayDrawable2.f17285e = (settableDraweeHierarchy2 == null || (scaleTypeDrawableC = C(settableDraweeHierarchy2.c())) == null) ? null : scaleTypeDrawableC.f17377d;
                Object obj = this.f17254i;
                String string = obj != null ? obj.toString() : null;
                if (string != null) {
                    debugControllerOverlayDrawable2.f17286f.put("cc", string);
                }
                if (closeableImage == null) {
                    debugControllerOverlayDrawable2.b();
                    return;
                }
                int width = closeableImage.getWidth();
                int height = closeableImage.getHeight();
                debugControllerOverlayDrawable2.f17282b = width;
                debugControllerOverlayDrawable2.f17283c = height;
                debugControllerOverlayDrawable2.invalidateSelf();
                debugControllerOverlayDrawable2.f17284d = closeableImage.B0();
            }
        }
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController, com.facebook.drawee.interfaces.DraweeController
    public final void c(DraweeHierarchy draweeHierarchy) {
        super.c(draweeHierarchy);
        D(null);
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public final Drawable h(Object obj) {
        CloseableReference closeableReference = (CloseableReference) obj;
        try {
            FrescoSystrace.a();
            Preconditions.e(CloseableReference.A(closeableReference));
            CloseableImage closeableImage = (CloseableImage) closeableReference.l();
            D(closeableImage);
            Drawable drawableB = this.t.b(closeableImage);
            if (drawableB != null) {
                return drawableB;
            }
            throw new UnsupportedOperationException("Unrecognized image class: " + closeableImage);
        } finally {
            FrescoSystrace.a();
        }
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public final Object i() {
        CacheKey cacheKey;
        FrescoSystrace.a();
        try {
            InstrumentedMemoryCache instrumentedMemoryCache = this.u;
            if (instrumentedMemoryCache != null && (cacheKey = this.v) != null) {
                CloseableReference closeableReference = instrumentedMemoryCache.get(cacheKey);
                if (closeableReference == null || ((CloseableImage) closeableReference.l()).q1().a()) {
                    return closeableReference;
                }
                closeableReference.close();
                return null;
            }
            return null;
        } finally {
            FrescoSystrace.a();
        }
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public final DataSource k() {
        FrescoSystrace.a();
        if (FLog.f17086a.a(2)) {
            FLog.l(PipelineDraweeController.class, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
        }
        DataSource dataSource = (DataSource) this.w.get();
        FrescoSystrace.a();
        return dataSource;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public final int l(Object obj) {
        CloseableReference closeableReference = (CloseableReference) obj;
        if (closeableReference == null || !closeableReference.x()) {
            return 0;
        }
        return System.identityHashCode(closeableReference.f17110b.b());
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public final ImageInfo m(Object obj) {
        CloseableReference closeableReference = (CloseableReference) obj;
        Preconditions.e(CloseableReference.A(closeableReference));
        return ((CloseableImage) closeableReference.l()).t1();
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public final Uri n() {
        ImageRequest imageRequest = this.z;
        ImageRequest imageRequest2 = this.A;
        Fn requestToUri = ImageRequest.r;
        Intrinsics.checkNotNullParameter(requestToUri, "requestToUri");
        Uri uriApply = imageRequest != null ? requestToUri.apply(imageRequest) : null;
        if (uriApply != null) {
            return uriApply;
        }
        if (imageRequest2 != null) {
            return requestToUri.apply(imageRequest2);
        }
        return null;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public final String toString() {
        Objects.ToStringHelper toStringHelperB = Objects.b(this);
        toStringHelperB.c(super.toString(), "super");
        toStringHelperB.c(this.w, "dataSourceSupplier");
        return toStringHelperB.toString();
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public final Map u(Object obj) {
        ImageInfo imageInfo = (ImageInfo) obj;
        if (imageInfo == null) {
            return null;
        }
        return imageInfo.getExtras();
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public final void w(Object obj) {
        synchronized (this) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public final void y(Drawable drawable) {
        if (drawable instanceof DrawableWithCaches) {
            ((DrawableWithCaches) drawable).a();
        }
    }
}
