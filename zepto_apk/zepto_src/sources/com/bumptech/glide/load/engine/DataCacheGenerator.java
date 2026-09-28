package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

/* loaded from: classes3.dex */
class DataCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {

    /* renamed from: a, reason: collision with root package name */
    public final List f15869a;

    /* renamed from: b, reason: collision with root package name */
    public final DecodeHelper f15870b;

    /* renamed from: c, reason: collision with root package name */
    public final DataFetcherGenerator.FetcherReadyCallback f15871c;

    /* renamed from: d, reason: collision with root package name */
    public int f15872d = -1;

    /* renamed from: e, reason: collision with root package name */
    public Key f15873e;

    /* renamed from: f, reason: collision with root package name */
    public List f15874f;

    /* renamed from: g, reason: collision with root package name */
    public int f15875g;

    /* renamed from: h, reason: collision with root package name */
    public volatile ModelLoader.LoadData f15876h;

    /* renamed from: i, reason: collision with root package name */
    public File f15877i;

    public DataCacheGenerator(List list, DecodeHelper decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f15869a = list;
        this.f15870b = decodeHelper;
        this.f15871c = fetcherReadyCallback;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public final boolean b() {
        while (true) {
            List list = this.f15874f;
            boolean z = false;
            if (list != null && this.f15875g < list.size()) {
                this.f15876h = null;
                while (!z && this.f15875g < this.f15874f.size()) {
                    List list2 = this.f15874f;
                    int i2 = this.f15875g;
                    this.f15875g = i2 + 1;
                    ModelLoader modelLoader = (ModelLoader) list2.get(i2);
                    File file = this.f15877i;
                    DecodeHelper decodeHelper = this.f15870b;
                    this.f15876h = modelLoader.b(file, decodeHelper.f15887e, decodeHelper.f15888f, decodeHelper.f15891i);
                    if (this.f15876h != null && this.f15870b.c(this.f15876h.f16169c.a()) != null) {
                        this.f15876h.f16169c.e(this.f15870b.o, this);
                        z = true;
                    }
                }
                return z;
            }
            int i3 = this.f15872d + 1;
            this.f15872d = i3;
            if (i3 >= this.f15869a.size()) {
                return false;
            }
            Key key = (Key) this.f15869a.get(this.f15872d);
            DecodeHelper decodeHelper2 = this.f15870b;
            File fileB = decodeHelper2.f15890h.a().b(new DataCacheKey(key, decodeHelper2.n));
            this.f15877i = fileB;
            if (fileB != null) {
                this.f15873e = key;
                this.f15874f = this.f15870b.f15885c.f15672b.f15688a.b(fileB);
                this.f15875g = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public final void c(Exception exc) {
        this.f15871c.a(this.f15873e, exc, this.f15876h.f16169c, DataSource.f15790c);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public final void cancel() {
        ModelLoader.LoadData loadData = this.f15876h;
        if (loadData != null) {
            loadData.f16169c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public final void f(Object obj) {
        this.f15871c.c(this.f15873e, obj, this.f15876h.f16169c, DataSource.f15790c, this.f15873e);
    }
}
