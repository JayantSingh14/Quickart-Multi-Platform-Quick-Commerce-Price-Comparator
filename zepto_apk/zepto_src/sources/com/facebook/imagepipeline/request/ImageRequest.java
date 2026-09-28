package com.facebook.imagepipeline.request;

import android.net.Uri;
import android.os.Build;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Fn;
import com.facebook.common.internal.Objects;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.DownsampleMode;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.memory.helper.HashCode;
import java.io.File;
import javax.annotation.concurrent.Immutable;

@Nullsafe
@Immutable
/* loaded from: classes3.dex */
public class ImageRequest {
    public static final Fn r = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final CacheChoice f18347a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f18348b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18349c;

    /* renamed from: d, reason: collision with root package name */
    public File f18350d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f18351e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f18352f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageDecodeOptions f18353g;

    /* renamed from: h, reason: collision with root package name */
    public final ResizeOptions f18354h;

    /* renamed from: i, reason: collision with root package name */
    public final RotationOptions f18355i;

    /* renamed from: j, reason: collision with root package name */
    public final BytesRange f18356j;

    /* renamed from: k, reason: collision with root package name */
    public final Priority f18357k;

    /* renamed from: l, reason: collision with root package name */
    public final RequestLevel f18358l;

    /* renamed from: m, reason: collision with root package name */
    public final int f18359m;
    public final boolean n;
    public final boolean o;
    public final Postprocessor p;
    public final DownsampleMode q;

    /* renamed from: com.facebook.imagepipeline.request.ImageRequest$1, reason: invalid class name */
    public class AnonymousClass1 implements Fn<ImageRequest, Uri> {
        @Override // com.facebook.common.internal.Fn
        public final Uri apply(Object obj) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (imageRequest != null) {
                return imageRequest.f18348b;
            }
            return null;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class CacheChoice {

        /* renamed from: a, reason: collision with root package name */
        public static final CacheChoice f18360a;

        /* renamed from: b, reason: collision with root package name */
        public static final CacheChoice f18361b;

        /* renamed from: c, reason: collision with root package name */
        public static final CacheChoice f18362c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ CacheChoice[] f18363d;

        static {
            CacheChoice cacheChoice = new CacheChoice("SMALL", 0);
            f18360a = cacheChoice;
            CacheChoice cacheChoice2 = new CacheChoice("DEFAULT", 1);
            f18361b = cacheChoice2;
            CacheChoice cacheChoice3 = new CacheChoice("DYNAMIC", 2);
            f18362c = cacheChoice3;
            f18363d = new CacheChoice[]{cacheChoice, cacheChoice2, cacheChoice3};
        }

        public static CacheChoice valueOf(String str) {
            return (CacheChoice) Enum.valueOf(CacheChoice.class, str);
        }

        public static CacheChoice[] values() {
            return (CacheChoice[]) f18363d.clone();
        }
    }

    public @interface CachesLocationsMasks {
    }

    public enum RequestLevel {
        FULL_FETCH(1),
        DISK_CACHE(2),
        ENCODED_MEMORY_CACHE(3),
        BITMAP_MEMORY_CACHE(4);


        /* renamed from: a, reason: collision with root package name */
        public final int f18369a;

        RequestLevel(int i2) {
            this.f18369a = i2;
        }

        public static RequestLevel a(RequestLevel requestLevel, RequestLevel requestLevel2) {
            return requestLevel.f18369a > requestLevel2.f18369a ? requestLevel : requestLevel2;
        }

        public final int b() {
            return this.f18369a;
        }
    }

    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.f18347a = imageRequestBuilder.f18376g;
        Uri uri = imageRequestBuilder.f18370a;
        this.f18348b = uri;
        int i2 = -1;
        if (uri != null) {
            if (UriUtil.f(uri)) {
                i2 = 0;
            } else if (uri.getPath() != null && UriUtil.e(uri)) {
                i2 = MediaUtils.b(MediaUtils.a(uri.getPath())) ? 2 : 3;
            } else if (UriUtil.d(uri)) {
                i2 = 4;
            } else if ("asset".equals(UriUtil.b(uri))) {
                i2 = 5;
            } else if ("res".equals(UriUtil.b(uri))) {
                i2 = 6;
            } else if ("data".equals(uri.getScheme())) {
                i2 = 7;
            } else if ("android.resource".equals(UriUtil.b(uri))) {
                i2 = 8;
            }
        }
        this.f18349c = i2;
        this.f18351e = imageRequestBuilder.f18377h;
        this.f18352f = imageRequestBuilder.f18378i;
        this.f18353g = imageRequestBuilder.f18375f;
        this.f18354h = imageRequestBuilder.f18373d;
        RotationOptions rotationOptions = imageRequestBuilder.f18374e;
        this.f18355i = rotationOptions == null ? RotationOptions.f17789c : rotationOptions;
        this.f18356j = imageRequestBuilder.f18381l;
        this.f18357k = imageRequestBuilder.f18379j;
        this.f18358l = imageRequestBuilder.f18371b;
        boolean z = (imageRequestBuilder.f18372c & 48) == 0 && (UriUtil.f(imageRequestBuilder.f18370a) || ImageRequestBuilder.c(imageRequestBuilder.f18370a));
        this.n = z;
        int i3 = imageRequestBuilder.f18372c;
        this.f18359m = !z ? i3 | 48 : i3;
        this.o = (i3 & 15) == 0;
        this.p = imageRequestBuilder.f18380k;
        this.q = imageRequestBuilder.f18382m;
    }

    public static ImageRequest a(Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.d(uri).a();
    }

    public final CacheChoice b() {
        return this.f18347a;
    }

    public final ImageDecodeOptions c() {
        return this.f18353g;
    }

    public final boolean d() {
        return Build.VERSION.SDK_INT >= 29 && this.f18352f;
    }

    public final RequestLevel e() {
        return this.f18358l;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ImageRequest)) {
            return false;
        }
        ImageRequest imageRequest = (ImageRequest) obj;
        imageRequest.getClass();
        if (this.n != imageRequest.n || this.o != imageRequest.o || !Objects.a(this.f18348b, imageRequest.f18348b) || !Objects.a(this.f18347a, imageRequest.f18347a)) {
            return false;
        }
        if (!Objects.a(null, null) || !Objects.a(this.f18350d, imageRequest.f18350d) || !Objects.a(this.f18356j, imageRequest.f18356j) || !Objects.a(this.f18353g, imageRequest.f18353g) || !Objects.a(this.f18354h, imageRequest.f18354h) || !Objects.a(this.f18357k, imageRequest.f18357k) || !Objects.a(this.f18358l, imageRequest.f18358l) || !Objects.a(Integer.valueOf(this.f18359m), Integer.valueOf(imageRequest.f18359m)) || !Objects.a(null, null) || !Objects.a(null, null) || !Objects.a(this.q, imageRequest.q) || !Objects.a(this.f18355i, imageRequest.f18355i) || this.f18352f != imageRequest.f18352f) {
            return false;
        }
        Postprocessor postprocessor = this.p;
        CacheKey cacheKeyA = postprocessor != null ? postprocessor.a() : null;
        Postprocessor postprocessor2 = imageRequest.p;
        return Objects.a(cacheKeyA, postprocessor2 != null ? postprocessor2.a() : null);
    }

    public final Postprocessor f() {
        return this.p;
    }

    public final Priority g() {
        return this.f18357k;
    }

    public final boolean h() {
        return this.f18351e;
    }

    public final int hashCode() {
        Postprocessor postprocessor = this.p;
        return HashCode.a(HashCode.a(HashCode.a(HashCode.a(HashCode.a(HashCode.a(HashCode.a(HashCode.a(HashCode.a(HashCode.a(HashCode.a(HashCode.a(HashCode.a(HashCode.a(HashCode.a(HashCode.a(HashCode.a(HashCode.a(0, this.f18347a), this.f18348b), Boolean.FALSE), this.f18356j), this.f18357k), this.f18358l), Integer.valueOf(this.f18359m)), Boolean.valueOf(this.n)), Boolean.valueOf(this.o)), this.f18353g), null), this.f18354h), this.f18355i), postprocessor != null ? postprocessor.a() : null), null), this.q), 0), Boolean.valueOf(this.f18352f));
    }

    public final ResizeOptions i() {
        return this.f18354h;
    }

    public final RotationOptions j() {
        return this.f18355i;
    }

    public final synchronized File k() {
        try {
            if (this.f18350d == null) {
                this.f18348b.getPath().getClass();
                this.f18350d = new File(this.f18348b.getPath());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f18350d;
    }

    public final Uri l() {
        return this.f18348b;
    }

    public final int m() {
        return this.f18349c;
    }

    public final boolean n(int i2) {
        return (i2 & this.f18359m) == 0;
    }

    public final String toString() {
        Objects.ToStringHelper toStringHelperB = Objects.b(this);
        toStringHelperB.c(this.f18348b, "uri");
        toStringHelperB.c(this.f18347a, "cacheChoice");
        toStringHelperB.c(this.f18353g, "decodeOptions");
        toStringHelperB.c(this.p, "postprocessor");
        toStringHelperB.c(this.f18357k, "priority");
        toStringHelperB.c(this.f18354h, "resizeOptions");
        toStringHelperB.c(this.f18355i, "rotationOptions");
        toStringHelperB.c(this.f18356j, "bytesRange");
        toStringHelperB.c(null, "resizingAllowedOverride");
        toStringHelperB.c(this.q, "downsampleOverride");
        toStringHelperB.b("progressiveRenderingEnabled", this.f18351e);
        toStringHelperB.b("localThumbnailPreviewsEnabled", false);
        toStringHelperB.b("loadThumbnailOnly", this.f18352f);
        toStringHelperB.c(this.f18358l, "lowestPermittedRequestLevel");
        toStringHelperB.c(String.valueOf(this.f18359m), "cachesDisabled");
        toStringHelperB.b("isDiskCacheEnabled", this.n);
        toStringHelperB.b("isMemoryCacheEnabled", this.o);
        toStringHelperB.c(null, "decodePrefetches");
        toStringHelperB.c(String.valueOf(0), "delayMs");
        return toStringHelperB.toString();
    }
}
