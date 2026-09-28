package com.bumptech.glide;

import androidx.core.util.Pools;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.DataRewinderRegistry;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.provider.EncoderRegistry;
import com.bumptech.glide.provider.ImageHeaderParserRegistry;
import com.bumptech.glide.provider.LoadPathCache;
import com.bumptech.glide.provider.ModelToResourceClassCache;
import com.bumptech.glide.provider.ResourceDecoderRegistry;
import com.bumptech.glide.provider.ResourceEncoderRegistry;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class Registry {

    /* renamed from: a, reason: collision with root package name */
    public final ModelLoaderRegistry f15688a;

    /* renamed from: b, reason: collision with root package name */
    public final EncoderRegistry f15689b;

    /* renamed from: c, reason: collision with root package name */
    public final ResourceDecoderRegistry f15690c;

    /* renamed from: d, reason: collision with root package name */
    public final ResourceEncoderRegistry f15691d;

    /* renamed from: e, reason: collision with root package name */
    public final DataRewinderRegistry f15692e;

    /* renamed from: f, reason: collision with root package name */
    public final TranscoderRegistry f15693f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageHeaderParserRegistry f15694g;

    /* renamed from: h, reason: collision with root package name */
    public final ModelToResourceClassCache f15695h = new ModelToResourceClassCache();

    /* renamed from: i, reason: collision with root package name */
    public final LoadPathCache f15696i = new LoadPathCache();

    /* renamed from: j, reason: collision with root package name */
    public final Pools.Pool f15697j;

    public static class MissingComponentException extends RuntimeException {
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
    }

    public Registry() {
        Pools.Pool poolB = FactoryPools.b();
        this.f15697j = poolB;
        this.f15688a = new ModelLoaderRegistry(poolB);
        this.f15689b = new EncoderRegistry();
        ResourceDecoderRegistry resourceDecoderRegistry = new ResourceDecoderRegistry();
        this.f15690c = resourceDecoderRegistry;
        this.f15691d = new ResourceEncoderRegistry();
        this.f15692e = new DataRewinderRegistry();
        this.f15693f = new TranscoderRegistry();
        this.f15694g = new ImageHeaderParserRegistry();
        List listAsList = Arrays.asList("Gif", "Bitmap", "BitmapDrawable");
        ArrayList arrayList = new ArrayList(listAsList.size());
        arrayList.addAll(listAsList);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        synchronized (resourceDecoderRegistry) {
            try {
                ArrayList arrayList2 = new ArrayList(resourceDecoderRegistry.f16433a);
                resourceDecoderRegistry.f16433a.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    resourceDecoderRegistry.f16433a.add((String) it.next());
                }
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    if (!arrayList.contains(str)) {
                        resourceDecoderRegistry.f16433a.add(str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(ResourceDecoder resourceDecoder, Class cls, Class cls2, String str) {
        this.f15690c.a(resourceDecoder, cls, cls2, str);
    }

    public final ArrayList b() {
        ArrayList arrayList;
        ImageHeaderParserRegistry imageHeaderParserRegistry = this.f15694g;
        synchronized (imageHeaderParserRegistry) {
            arrayList = imageHeaderParserRegistry.f16427a;
        }
        if (arrayList.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return arrayList;
    }

    public final void c(DataRewinder.Factory factory) {
        DataRewinderRegistry dataRewinderRegistry = this.f15692e;
        synchronized (dataRewinderRegistry) {
            dataRewinderRegistry.f15829a.put(factory.a(), factory);
        }
    }
}
