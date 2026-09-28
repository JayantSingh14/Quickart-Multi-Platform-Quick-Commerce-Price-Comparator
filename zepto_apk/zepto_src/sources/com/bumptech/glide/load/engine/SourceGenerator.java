package com.bumptech.glide.load.engine;

import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.LogTime;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes3.dex */
class SourceGenerator implements DataFetcherGenerator, DataFetcherGenerator.FetcherReadyCallback {

    /* renamed from: a, reason: collision with root package name */
    public final DecodeHelper f16038a;

    /* renamed from: b, reason: collision with root package name */
    public final DataFetcherGenerator.FetcherReadyCallback f16039b;

    /* renamed from: c, reason: collision with root package name */
    public int f16040c;

    /* renamed from: d, reason: collision with root package name */
    public DataCacheGenerator f16041d;

    /* renamed from: e, reason: collision with root package name */
    public Object f16042e;

    /* renamed from: f, reason: collision with root package name */
    public volatile ModelLoader.LoadData f16043f;

    /* renamed from: g, reason: collision with root package name */
    public DataCacheKey f16044g;

    public SourceGenerator(DecodeHelper decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f16038a = decodeHelper;
        this.f16039b = fetcherReadyCallback;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public final void a(Key key, Exception exc, DataFetcher dataFetcher, DataSource dataSource) {
        ((DecodeJob) this.f16039b).a(key, exc, dataFetcher, this.f16043f.f16169c.d());
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public final boolean b() {
        Object obj = this.f16042e;
        if (obj != null) {
            this.f16042e = null;
            int i2 = LogTime.f16520b;
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            try {
                Encoder encoderD = this.f16038a.d(obj);
                DataCacheWriter dataCacheWriter = new DataCacheWriter(encoderD, obj, this.f16038a.f15891i);
                Key key = this.f16043f.f16167a;
                DecodeHelper decodeHelper = this.f16038a;
                this.f16044g = new DataCacheKey(key, decodeHelper.n);
                decodeHelper.f15890h.a().a(this.f16044g, dataCacheWriter);
                if (Log.isLoggable("SourceGenerator", 2)) {
                    Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.f16044g + ", data: " + obj + ", encoder: " + encoderD + ", duration: " + LogTime.a(jElapsedRealtimeNanos));
                }
                this.f16043f.f16169c.b();
                this.f16041d = new DataCacheGenerator(Collections.singletonList(this.f16043f.f16167a), this.f16038a, this);
            } catch (Throwable th) {
                this.f16043f.f16169c.b();
                throw th;
            }
        }
        DataCacheGenerator dataCacheGenerator = this.f16041d;
        if (dataCacheGenerator != null && dataCacheGenerator.b()) {
            return true;
        }
        this.f16041d = null;
        this.f16043f = null;
        boolean z = false;
        while (!z && this.f16040c < this.f16038a.b().size()) {
            ArrayList arrayListB = this.f16038a.b();
            int i3 = this.f16040c;
            this.f16040c = i3 + 1;
            this.f16043f = (ModelLoader.LoadData) arrayListB.get(i3);
            if (this.f16043f != null && (this.f16038a.p.c(this.f16043f.f16169c.d()) || this.f16038a.c(this.f16043f.f16169c.a()) != null)) {
                final ModelLoader.LoadData loadData = this.f16043f;
                this.f16043f.f16169c.e(this.f16038a.o, new DataFetcher.DataCallback<Object>() { // from class: com.bumptech.glide.load.engine.SourceGenerator.1
                    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
                    public final void c(Exception exc) {
                        SourceGenerator sourceGenerator = SourceGenerator.this;
                        ModelLoader.LoadData loadData2 = loadData;
                        ModelLoader.LoadData loadData3 = sourceGenerator.f16043f;
                        if (loadData3 == null || loadData3 != loadData2) {
                            return;
                        }
                        DataCacheKey dataCacheKey = sourceGenerator.f16044g;
                        DataFetcher dataFetcher = loadData2.f16169c;
                        ((DecodeJob) sourceGenerator.f16039b).a(dataCacheKey, exc, dataFetcher, dataFetcher.d());
                    }

                    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
                    public final void f(Object obj2) {
                        SourceGenerator sourceGenerator = SourceGenerator.this;
                        ModelLoader.LoadData loadData2 = loadData;
                        ModelLoader.LoadData loadData3 = sourceGenerator.f16043f;
                        if (loadData3 == null || loadData3 != loadData2) {
                            return;
                        }
                        DiskCacheStrategy diskCacheStrategy = sourceGenerator.f16038a.p;
                        if (obj2 != null && diskCacheStrategy.c(loadData2.f16169c.d())) {
                            sourceGenerator.f16042e = obj2;
                            ((DecodeJob) sourceGenerator.f16039b).q();
                            return;
                        }
                        Key key2 = loadData2.f16167a;
                        DataFetcher dataFetcher = loadData2.f16169c;
                        ((DecodeJob) sourceGenerator.f16039b).c(key2, obj2, dataFetcher, dataFetcher.d(), sourceGenerator.f16044g);
                    }
                });
                z = true;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public final void c(Key key, Object obj, DataFetcher dataFetcher, DataSource dataSource, Key key2) {
        this.f16039b.c(key, obj, dataFetcher, this.f16043f.f16169c.d(), key);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public final void cancel() {
        ModelLoader.LoadData loadData = this.f16043f;
        if (loadData != null) {
            loadData.f16169c.cancel();
        }
    }
}
