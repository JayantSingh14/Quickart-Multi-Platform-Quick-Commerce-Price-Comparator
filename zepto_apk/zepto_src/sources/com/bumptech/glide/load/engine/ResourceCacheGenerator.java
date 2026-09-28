package com.bumptech.glide.load.engine;

import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import com.bumptech.glide.provider.ModelToResourceClassCache;
import com.bumptech.glide.util.MultiClassKey;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
class ResourceCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {

    /* renamed from: a, reason: collision with root package name */
    public final DataFetcherGenerator.FetcherReadyCallback f16017a;

    /* renamed from: b, reason: collision with root package name */
    public final DecodeHelper f16018b;

    /* renamed from: c, reason: collision with root package name */
    public int f16019c;

    /* renamed from: d, reason: collision with root package name */
    public int f16020d = -1;

    /* renamed from: e, reason: collision with root package name */
    public Key f16021e;

    /* renamed from: f, reason: collision with root package name */
    public List f16022f;

    /* renamed from: g, reason: collision with root package name */
    public int f16023g;

    /* renamed from: h, reason: collision with root package name */
    public volatile ModelLoader.LoadData f16024h;

    /* renamed from: i, reason: collision with root package name */
    public File f16025i;

    /* renamed from: j, reason: collision with root package name */
    public ResourceCacheKey f16026j;

    public ResourceCacheGenerator(DecodeHelper decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f16018b = decodeHelper;
        this.f16017a = fetcherReadyCallback;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public final boolean b() {
        List list;
        ArrayList arrayListD;
        ArrayList arrayListA = this.f16018b.a();
        boolean z = false;
        if (!arrayListA.isEmpty()) {
            DecodeHelper decodeHelper = this.f16018b;
            Registry registry = decodeHelper.f15885c.f15672b;
            Class<?> cls = decodeHelper.f15886d.getClass();
            Class cls2 = decodeHelper.f15889g;
            Class cls3 = decodeHelper.f15893k;
            ModelToResourceClassCache modelToResourceClassCache = registry.f15695h;
            MultiClassKey multiClassKey = (MultiClassKey) modelToResourceClassCache.f16431a.getAndSet(null);
            if (multiClassKey == null) {
                multiClassKey = new MultiClassKey(cls, cls2, cls3);
            } else {
                multiClassKey.f16525a = cls;
                multiClassKey.f16526b = cls2;
                multiClassKey.f16527c = cls3;
            }
            synchronized (modelToResourceClassCache.f16432b) {
                list = (List) modelToResourceClassCache.f16432b.get(multiClassKey);
            }
            modelToResourceClassCache.f16431a.set(multiClassKey);
            List list2 = list;
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                ModelLoaderRegistry modelLoaderRegistry = registry.f15688a;
                synchronized (modelLoaderRegistry) {
                    arrayListD = modelLoaderRegistry.f16170a.d(cls);
                }
                Iterator it = arrayListD.iterator();
                while (it.hasNext()) {
                    Iterator it2 = registry.f15690c.d((Class) it.next(), cls2).iterator();
                    while (it2.hasNext()) {
                        Class cls4 = (Class) it2.next();
                        if (!registry.f15693f.b(cls4, cls3).isEmpty() && !arrayList.contains(cls4)) {
                            arrayList.add(cls4);
                        }
                    }
                }
                ModelToResourceClassCache modelToResourceClassCache2 = registry.f15695h;
                List listUnmodifiableList = Collections.unmodifiableList(arrayList);
                synchronized (modelToResourceClassCache2.f16432b) {
                    modelToResourceClassCache2.f16432b.put(new MultiClassKey(cls, cls2, cls3), listUnmodifiableList);
                }
                list2 = arrayList;
            }
            if (!list2.isEmpty()) {
                while (true) {
                    List list3 = this.f16022f;
                    if (list3 != null && this.f16023g < list3.size()) {
                        this.f16024h = null;
                        while (!z && this.f16023g < this.f16022f.size()) {
                            List list4 = this.f16022f;
                            int i2 = this.f16023g;
                            this.f16023g = i2 + 1;
                            ModelLoader modelLoader = (ModelLoader) list4.get(i2);
                            File file = this.f16025i;
                            DecodeHelper decodeHelper2 = this.f16018b;
                            this.f16024h = modelLoader.b(file, decodeHelper2.f15887e, decodeHelper2.f15888f, decodeHelper2.f15891i);
                            if (this.f16024h != null && this.f16018b.c(this.f16024h.f16169c.a()) != null) {
                                this.f16024h.f16169c.e(this.f16018b.o, this);
                                z = true;
                            }
                        }
                        return z;
                    }
                    int i3 = this.f16020d + 1;
                    this.f16020d = i3;
                    if (i3 >= list2.size()) {
                        int i4 = this.f16019c + 1;
                        this.f16019c = i4;
                        if (i4 >= arrayListA.size()) {
                            break;
                        }
                        this.f16020d = 0;
                    }
                    Key key = (Key) arrayListA.get(this.f16019c);
                    Class cls5 = (Class) list2.get(this.f16020d);
                    Transformation transformationE = this.f16018b.e(cls5);
                    DecodeHelper decodeHelper3 = this.f16018b;
                    this.f16026j = new ResourceCacheKey(decodeHelper3.f15885c.f15671a, key, decodeHelper3.n, decodeHelper3.f15887e, decodeHelper3.f15888f, transformationE, cls5, decodeHelper3.f15891i);
                    File fileB = decodeHelper3.f15890h.a().b(this.f16026j);
                    this.f16025i = fileB;
                    if (fileB != null) {
                        this.f16021e = key;
                        this.f16022f = this.f16018b.f15885c.f15672b.f15688a.b(fileB);
                        this.f16023g = 0;
                    }
                }
            } else if (!File.class.equals(this.f16018b.f15893k)) {
                throw new IllegalStateException("Failed to find any load path from " + this.f16018b.f15886d.getClass() + " to " + this.f16018b.f15893k);
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public final void c(Exception exc) {
        ((DecodeJob) this.f16017a).a(this.f16026j, exc, this.f16024h.f16169c, DataSource.f15791d);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public final void cancel() {
        ModelLoader.LoadData loadData = this.f16024h;
        if (loadData != null) {
            loadData.f16169c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public final void f(Object obj) {
        this.f16017a.c(this.f16021e, obj, this.f16024h.f16169c, DataSource.f15791d, this.f16026j);
    }
}
