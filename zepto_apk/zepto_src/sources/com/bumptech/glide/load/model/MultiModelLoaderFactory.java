package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class MultiModelLoaderFactory {

    /* renamed from: e, reason: collision with root package name */
    public static final Factory f16183e = new Factory();

    /* renamed from: f, reason: collision with root package name */
    public static final ModelLoader f16184f = new EmptyModelLoader();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f16185a;

    /* renamed from: b, reason: collision with root package name */
    public final Factory f16186b;

    /* renamed from: c, reason: collision with root package name */
    public final HashSet f16187c;

    /* renamed from: d, reason: collision with root package name */
    public final Pools.Pool f16188d;

    public static class EmptyModelLoader implements ModelLoader<Object, Object> {
        @Override // com.bumptech.glide.load.model.ModelLoader
        public final boolean a(Object obj) {
            return false;
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        public final ModelLoader.LoadData b(Object obj, int i2, int i3, Options options) {
            return null;
        }
    }

    public static class Entry<Model, Data> {

        /* renamed from: a, reason: collision with root package name */
        public final Class f16189a;

        /* renamed from: b, reason: collision with root package name */
        public final Class f16190b;

        /* renamed from: c, reason: collision with root package name */
        public final ModelLoaderFactory f16191c;

        public Entry(Class cls, Class cls2, ModelLoaderFactory modelLoaderFactory) {
            this.f16189a = cls;
            this.f16190b = cls2;
            this.f16191c = modelLoaderFactory;
        }
    }

    public static class Factory {
    }

    public MultiModelLoaderFactory(Pools.Pool pool) {
        Factory factory = f16183e;
        this.f16185a = new ArrayList();
        this.f16187c = new HashSet();
        this.f16188d = pool;
        this.f16186b = factory;
    }

    public final ModelLoader a(Entry entry) {
        ModelLoader modelLoaderB = entry.f16191c.b(this);
        Preconditions.c(modelLoaderB, "Argument must not be null");
        return modelLoaderB;
    }

    public final synchronized ModelLoader b(Class cls, Class cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f16185a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (this.f16187c.contains(entry)) {
                    z = true;
                } else if (entry.f16189a.isAssignableFrom(cls) && entry.f16190b.isAssignableFrom(cls2)) {
                    this.f16187c.add(entry);
                    arrayList.add(a(entry));
                    this.f16187c.remove(entry);
                }
            }
            if (arrayList.size() > 1) {
                Factory factory = this.f16186b;
                Pools.Pool pool = this.f16188d;
                factory.getClass();
                return new MultiModelLoader(arrayList, pool);
            }
            if (arrayList.size() == 1) {
                return (ModelLoader) arrayList.get(0);
            }
            if (z) {
                return f16184f;
            }
            throw new Registry.NoModelLoaderAvailableException("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        } catch (Throwable th) {
            this.f16187c.clear();
            throw th;
        }
    }

    public final synchronized ArrayList c(Class cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Iterator it = this.f16185a.iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (!this.f16187c.contains(entry) && entry.f16189a.isAssignableFrom(cls)) {
                    this.f16187c.add(entry);
                    arrayList.add(a(entry));
                    this.f16187c.remove(entry);
                }
            }
        } finally {
        }
        return arrayList;
    }

    public final synchronized ArrayList d(Class cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f16185a.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (!arrayList.contains(entry.f16190b) && entry.f16189a.isAssignableFrom(cls)) {
                arrayList.add(entry.f16190b);
            }
        }
        return arrayList;
    }
}
