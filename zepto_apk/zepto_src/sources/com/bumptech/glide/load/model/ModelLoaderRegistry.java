package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class ModelLoaderRegistry {

    /* renamed from: a, reason: collision with root package name */
    public final MultiModelLoaderFactory f16170a;

    /* renamed from: b, reason: collision with root package name */
    public final ModelLoaderCache f16171b;

    public static class ModelLoaderCache {

        /* renamed from: a, reason: collision with root package name */
        public final HashMap f16172a = new HashMap();

        public static class Entry<Model> {

            /* renamed from: a, reason: collision with root package name */
            public final List f16173a;

            public Entry(List list) {
                this.f16173a = list;
            }
        }
    }

    public ModelLoaderRegistry(Pools.Pool pool) {
        MultiModelLoaderFactory multiModelLoaderFactory = new MultiModelLoaderFactory(pool);
        this.f16171b = new ModelLoaderCache();
        this.f16170a = multiModelLoaderFactory;
    }

    public final synchronized void a(Class cls, Class cls2, ModelLoaderFactory modelLoaderFactory) {
        MultiModelLoaderFactory multiModelLoaderFactory = this.f16170a;
        synchronized (multiModelLoaderFactory) {
            try {
                MultiModelLoaderFactory.Entry entry = new MultiModelLoaderFactory.Entry(cls, cls2, modelLoaderFactory);
                ArrayList arrayList = multiModelLoaderFactory.f16185a;
                arrayList.add(arrayList.size(), entry);
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f16171b.f16172a.clear();
    }

    public final List b(Object obj) {
        List listUnmodifiableList;
        Class<?> cls = obj.getClass();
        synchronized (this) {
            ModelLoaderCache.Entry entry = (ModelLoaderCache.Entry) this.f16171b.f16172a.get(cls);
            listUnmodifiableList = entry == null ? null : entry.f16173a;
            if (listUnmodifiableList == null) {
                listUnmodifiableList = Collections.unmodifiableList(this.f16170a.c(cls));
                if (((ModelLoaderCache.Entry) this.f16171b.f16172a.put(cls, new ModelLoaderCache.Entry(listUnmodifiableList))) != null) {
                    throw new IllegalStateException("Already cached loaders for model: " + cls);
                }
            }
        }
        if (listUnmodifiableList.isEmpty()) {
            throw new Registry.NoModelLoaderAvailableException("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }
        int size = listUnmodifiableList.size();
        List arrayList = Collections.EMPTY_LIST;
        boolean z = true;
        for (int i2 = 0; i2 < size; i2++) {
            ModelLoader modelLoader = (ModelLoader) listUnmodifiableList.get(i2);
            if (modelLoader.a(obj)) {
                if (z) {
                    arrayList = new ArrayList(size - i2);
                    z = false;
                }
                arrayList.add(modelLoader);
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        throw new Registry.NoModelLoaderAvailableException("Found ModelLoaders for model class: " + listUnmodifiableList + ", but none that handle this specific model instance: " + obj);
    }
}
