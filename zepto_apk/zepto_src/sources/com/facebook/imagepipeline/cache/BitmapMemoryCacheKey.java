package com.facebook.imagepipeline.cache;

import android.net.Uri;
import android.os.SystemClock;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes3.dex */
public final class BitmapMemoryCacheKey implements CacheKey {

    /* renamed from: a, reason: collision with root package name */
    public final String f17720a;

    /* renamed from: b, reason: collision with root package name */
    public final ResizeOptions f17721b;

    /* renamed from: c, reason: collision with root package name */
    public final RotationOptions f17722c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageDecodeOptions f17723d;

    /* renamed from: e, reason: collision with root package name */
    public final CacheKey f17724e;

    /* renamed from: f, reason: collision with root package name */
    public final String f17725f;

    /* renamed from: g, reason: collision with root package name */
    public Object f17726g;

    /* renamed from: h, reason: collision with root package name */
    public final int f17727h;

    public BitmapMemoryCacheKey(String sourceString, ResizeOptions resizeOptions, RotationOptions rotationOptions, ImageDecodeOptions imageDecodeOptions, CacheKey cacheKey, String str) {
        Intrinsics.checkNotNullParameter(sourceString, "sourceString");
        Intrinsics.checkNotNullParameter(rotationOptions, "rotationOptions");
        Intrinsics.checkNotNullParameter(imageDecodeOptions, "imageDecodeOptions");
        this.f17720a = sourceString;
        this.f17721b = resizeOptions;
        this.f17722c = rotationOptions;
        this.f17723d = imageDecodeOptions;
        this.f17724e = cacheKey;
        this.f17725f = str;
        this.f17727h = ((((imageDecodeOptions.hashCode() + ((rotationOptions.hashCode() + (((sourceString.hashCode() * 31) + (resizeOptions != null ? resizeOptions.hashCode() : 0)) * 31)) * 31)) * 31) + (cacheKey != null ? cacheKey.hashCode() : 0)) * 31) + (str != null ? str.hashCode() : 0);
        RealtimeSinceBootClock.get().getClass();
        SystemClock.elapsedRealtime();
    }

    @Override // com.facebook.cache.common.CacheKey
    public final String a() {
        return this.f17720a;
    }

    @Override // com.facebook.cache.common.CacheKey
    public final boolean b(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return StringsKt.n(this.f17720a, string, false);
    }

    @Override // com.facebook.cache.common.CacheKey
    public final boolean c() {
        return false;
    }

    public final void d(Object obj) {
        this.f17726g = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!BitmapMemoryCacheKey.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.d(obj, "null cannot be cast to non-null type com.facebook.imagepipeline.cache.BitmapMemoryCacheKey");
        BitmapMemoryCacheKey bitmapMemoryCacheKey = (BitmapMemoryCacheKey) obj;
        return Intrinsics.b(this.f17720a, bitmapMemoryCacheKey.f17720a) && Intrinsics.b(this.f17721b, bitmapMemoryCacheKey.f17721b) && Intrinsics.b(this.f17722c, bitmapMemoryCacheKey.f17722c) && Intrinsics.b(this.f17723d, bitmapMemoryCacheKey.f17723d) && Intrinsics.b(this.f17724e, bitmapMemoryCacheKey.f17724e) && Intrinsics.b(this.f17725f, bitmapMemoryCacheKey.f17725f);
    }

    public final int hashCode() {
        return this.f17727h;
    }

    public final String toString() {
        return "BitmapMemoryCacheKey(sourceString=" + this.f17720a + ", resizeOptions=" + this.f17721b + ", rotationOptions=" + this.f17722c + ", imageDecodeOptions=" + this.f17723d + ", postprocessorCacheKey=" + this.f17724e + ", postprocessorName=" + this.f17725f + ")";
    }
}
