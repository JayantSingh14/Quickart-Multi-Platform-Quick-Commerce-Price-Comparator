package com.bumptech.glide.load.model;

import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class UrlUriLoader<Data> implements ModelLoader<Uri, Data> {

    /* renamed from: b, reason: collision with root package name */
    public static final Set f16208b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: a, reason: collision with root package name */
    public final ModelLoader f16209a;

    public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader b(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UrlUriLoader(multiModelLoaderFactory.b(GlideUrl.class, InputStream.class));
        }
    }

    public UrlUriLoader(ModelLoader modelLoader) {
        this.f16209a = modelLoader;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final boolean a(Object obj) {
        return f16208b.contains(((Uri) obj).getScheme());
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final ModelLoader.LoadData b(Object obj, int i2, int i3, Options options) {
        return this.f16209a.b(new GlideUrl(((Uri) obj).toString()), i2, i3, options);
    }
}
