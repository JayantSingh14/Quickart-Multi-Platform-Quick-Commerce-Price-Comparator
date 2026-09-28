package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class MediaStoreVideoThumbLoader implements ModelLoader<Uri, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f16217a;

    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        public final Context f16218a;

        public Factory(Context context) {
            this.f16218a = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader b(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreVideoThumbLoader(this.f16218a);
        }
    }

    public MediaStoreVideoThumbLoader(Context context) {
        this.f16217a = context.getApplicationContext();
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final boolean a(Object obj) {
        Uri uri = (Uri) obj;
        return MediaStoreUtil.a(uri) && uri.getPathSegments().contains("video");
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final ModelLoader.LoadData b(Object obj, int i2, int i3, Options options) {
        Long l2;
        Uri uri = (Uri) obj;
        if (i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE || i2 > 512 || i3 > 384 || (l2 = (Long) options.c(VideoDecoder.f16327d)) == null || l2.longValue() != -1) {
            return null;
        }
        return new ModelLoader.LoadData(new ObjectKey(uri), ThumbFetcher.f(this.f16217a, uri));
    }
}
