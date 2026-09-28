package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;

/* loaded from: classes3.dex */
public class UnitModelLoader<Model> implements ModelLoader<Model, Model> {

    /* renamed from: a, reason: collision with root package name */
    public static final UnitModelLoader f16200a = new UnitModelLoader();

    public static class Factory<Model> implements ModelLoaderFactory<Model, Model> {

        /* renamed from: a, reason: collision with root package name */
        public static final Factory f16201a = new Factory();

        @Deprecated
        public Factory() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader b(MultiModelLoaderFactory multiModelLoaderFactory) {
            return UnitModelLoader.f16200a;
        }
    }

    public static class UnitFetcher<Model> implements DataFetcher<Model> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f16202a;

        public UnitFetcher(Object obj) {
            this.f16202a = obj;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final Class a() {
            return this.f16202a.getClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void b() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final DataSource d() {
            return DataSource.f15788a;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void e(Priority priority, DataFetcher.DataCallback dataCallback) {
            dataCallback.f(this.f16202a);
        }
    }

    @Deprecated
    public UnitModelLoader() {
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final boolean a(Object obj) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final ModelLoader.LoadData b(Object obj, int i2, int i3, Options options) {
        return new ModelLoader.LoadData(new ObjectKey(obj), new UnitFetcher(obj));
    }
}
