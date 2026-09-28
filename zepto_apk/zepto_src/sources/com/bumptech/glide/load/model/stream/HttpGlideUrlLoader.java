package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class HttpGlideUrlLoader implements ModelLoader<GlideUrl, InputStream> {

    /* renamed from: b, reason: collision with root package name */
    public static final Option f16210b = Option.a(2500, "com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout");

    /* renamed from: a, reason: collision with root package name */
    public final ModelCache f16211a;

    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        public final ModelCache f16212a = new ModelCache(500);

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader b(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new HttpGlideUrlLoader(this.f16212a);
        }
    }

    public HttpGlideUrlLoader() {
        this(null);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final ModelLoader.LoadData b(Object obj, int i2, int i3, Options options) {
        GlideUrl glideUrl = (GlideUrl) obj;
        ModelCache modelCache = this.f16211a;
        if (modelCache != null) {
            GlideUrl glideUrl2 = (GlideUrl) modelCache.a(glideUrl);
            if (glideUrl2 == null) {
                modelCache.b(glideUrl, glideUrl);
            } else {
                glideUrl = glideUrl2;
            }
        }
        return new ModelLoader.LoadData(glideUrl, new HttpUrlFetcher(glideUrl, ((Integer) options.c(f16210b)).intValue()));
    }

    public HttpGlideUrlLoader(ModelCache modelCache) {
        this.f16211a = modelCache;
    }
}
