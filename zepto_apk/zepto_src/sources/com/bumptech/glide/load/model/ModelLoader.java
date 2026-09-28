package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.util.Preconditions;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public interface ModelLoader<Model, Data> {

    public static class LoadData<Data> {

        /* renamed from: a, reason: collision with root package name */
        public final Key f16167a;

        /* renamed from: b, reason: collision with root package name */
        public final List f16168b;

        /* renamed from: c, reason: collision with root package name */
        public final DataFetcher f16169c;

        public LoadData(Key key, DataFetcher dataFetcher) {
            List list = Collections.EMPTY_LIST;
            Preconditions.c(key, "Argument must not be null");
            this.f16167a = key;
            Preconditions.c(list, "Argument must not be null");
            this.f16168b = list;
            Preconditions.c(dataFetcher, "Argument must not be null");
            this.f16169c = dataFetcher;
        }
    }

    boolean a(Object obj);

    LoadData b(Object obj, int i2, int i3, Options options);
}
