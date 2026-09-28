package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.DownsampleMode;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ImageRequestBuilder {
    public static final HashSet n = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public Uri f18370a;

    /* renamed from: b, reason: collision with root package name */
    public ImageRequest.RequestLevel f18371b;

    /* renamed from: c, reason: collision with root package name */
    public int f18372c;

    /* renamed from: d, reason: collision with root package name */
    public ResizeOptions f18373d;

    /* renamed from: e, reason: collision with root package name */
    public RotationOptions f18374e;

    /* renamed from: f, reason: collision with root package name */
    public ImageDecodeOptions f18375f;

    /* renamed from: g, reason: collision with root package name */
    public ImageRequest.CacheChoice f18376g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f18377h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f18378i;

    /* renamed from: j, reason: collision with root package name */
    public Priority f18379j;

    /* renamed from: k, reason: collision with root package name */
    public Postprocessor f18380k;

    /* renamed from: l, reason: collision with root package name */
    public BytesRange f18381l;

    /* renamed from: m, reason: collision with root package name */
    public DownsampleMode f18382m;

    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super("Invalid request builder: ".concat(str));
        }
    }

    public static ImageRequestBuilder b(ImageRequest imageRequest) {
        ImageRequestBuilder imageRequestBuilderD = d(imageRequest.f18348b);
        imageRequestBuilderD.f18375f = imageRequest.f18353g;
        imageRequestBuilderD.f18381l = imageRequest.f18356j;
        imageRequestBuilderD.f18376g = imageRequest.f18347a;
        imageRequestBuilderD.f18378i = imageRequest.d();
        imageRequestBuilderD.f18371b = imageRequest.f18358l;
        imageRequestBuilderD.f18372c = imageRequest.f18359m;
        imageRequestBuilderD.f18380k = imageRequest.p;
        imageRequestBuilderD.f18377h = imageRequest.f18351e;
        imageRequestBuilderD.f18379j = imageRequest.f18357k;
        imageRequestBuilderD.f18373d = imageRequest.f18354h;
        imageRequestBuilderD.f18374e = imageRequest.f18355i;
        imageRequestBuilderD.f18382m = imageRequest.q;
        return imageRequestBuilderD;
    }

    public static boolean c(Uri uri) {
        HashSet hashSet = n;
        if (hashSet == null || uri == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equals(uri.getScheme())) {
                return true;
            }
        }
        return false;
    }

    public static ImageRequestBuilder d(Uri uri) {
        ImageRequestBuilder imageRequestBuilder = new ImageRequestBuilder();
        imageRequestBuilder.f18370a = null;
        imageRequestBuilder.f18371b = ImageRequest.RequestLevel.FULL_FETCH;
        imageRequestBuilder.f18372c = 0;
        imageRequestBuilder.f18373d = null;
        imageRequestBuilder.f18374e = null;
        imageRequestBuilder.f18375f = ImageDecodeOptions.f17776c;
        imageRequestBuilder.f18376g = ImageRequest.CacheChoice.f18361b;
        ImagePipelineConfig.A.getClass();
        imageRequestBuilder.f18377h = false;
        imageRequestBuilder.f18378i = false;
        imageRequestBuilder.f18379j = Priority.f17784d;
        imageRequestBuilder.f18380k = null;
        imageRequestBuilder.f18381l = null;
        imageRequestBuilder.f18382m = null;
        uri.getClass();
        imageRequestBuilder.f18370a = uri;
        return imageRequestBuilder;
    }

    public final ImageRequest a() throws NumberFormatException {
        Uri uri = this.f18370a;
        if (uri == null) {
            throw new BuilderException("Source must be set!");
        }
        if ("res".equals(UriUtil.b(uri))) {
            if (!this.f18370a.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.f18370a.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.f18370a.getPath().substring(1));
            } catch (NumberFormatException unused) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (!"asset".equals(UriUtil.b(this.f18370a)) || this.f18370a.isAbsolute()) {
            return new ImageRequest(this);
        }
        throw new BuilderException("Asset URI path must be absolute.");
    }

    public final void e() {
        this.f18374e = RotationOptions.f17789c;
    }

    public final void f(ImageRequest.CacheChoice cacheChoice) {
        this.f18376g = cacheChoice;
    }

    public final void g() {
        this.f18382m = DownsampleMode.f17818c;
    }

    public final void h(ImageRequest.RequestLevel requestLevel) {
        this.f18371b = requestLevel;
    }

    public final void i(Postprocessor postprocessor) {
        this.f18380k = postprocessor;
    }

    public final void j(boolean z) {
        this.f18377h = z;
    }

    public final void k(ResizeOptions resizeOptions) {
        this.f18373d = resizeOptions;
    }

    public final void l(Uri uri) {
        this.f18370a = uri;
    }
}
