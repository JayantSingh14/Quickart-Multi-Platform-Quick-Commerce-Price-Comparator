package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
class MultiModelLoader<Model, Data> implements ModelLoader<Model, Data> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f16174a;

    /* renamed from: b, reason: collision with root package name */
    public final Pools.Pool f16175b;

    public static class MultiFetcher<Data> implements DataFetcher<Data>, DataFetcher.DataCallback<Data> {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f16176a;

        /* renamed from: b, reason: collision with root package name */
        public final Pools.Pool f16177b;

        /* renamed from: c, reason: collision with root package name */
        public int f16178c;

        /* renamed from: d, reason: collision with root package name */
        public Priority f16179d;

        /* renamed from: e, reason: collision with root package name */
        public DataFetcher.DataCallback f16180e;

        /* renamed from: f, reason: collision with root package name */
        public List f16181f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f16182g;

        public MultiFetcher(ArrayList arrayList, Pools.Pool pool) {
            this.f16177b = pool;
            if (arrayList.isEmpty()) {
                throw new IllegalArgumentException("Must not be empty.");
            }
            this.f16176a = arrayList;
            this.f16178c = 0;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final Class a() {
            return ((DataFetcher) this.f16176a.get(0)).a();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void b() {
            List list = this.f16181f;
            if (list != null) {
                this.f16177b.a(list);
            }
            this.f16181f = null;
            Iterator it = this.f16176a.iterator();
            while (it.hasNext()) {
                ((DataFetcher) it.next()).b();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public final void c(Exception exc) {
            List list = this.f16181f;
            Preconditions.c(list, "Argument must not be null");
            list.add(exc);
            g();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void cancel() {
            this.f16182g = true;
            Iterator it = this.f16176a.iterator();
            while (it.hasNext()) {
                ((DataFetcher) it.next()).cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final DataSource d() {
            return ((DataFetcher) this.f16176a.get(0)).d();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void e(Priority priority, DataFetcher.DataCallback dataCallback) {
            this.f16179d = priority;
            this.f16180e = dataCallback;
            this.f16181f = (List) this.f16177b.b();
            ((DataFetcher) this.f16176a.get(this.f16178c)).e(priority, this);
            if (this.f16182g) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public final void f(Object obj) {
            if (obj != null) {
                this.f16180e.f(obj);
            } else {
                g();
            }
        }

        public final void g() {
            if (this.f16182g) {
                return;
            }
            if (this.f16178c < this.f16176a.size() - 1) {
                this.f16178c++;
                e(this.f16179d, this.f16180e);
            } else {
                Preconditions.b(this.f16181f);
                this.f16180e.c(new GlideException("Fetch failed", new ArrayList(this.f16181f)));
            }
        }
    }

    public MultiModelLoader(ArrayList arrayList, Pools.Pool pool) {
        this.f16174a = arrayList;
        this.f16175b = pool;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final boolean a(Object obj) {
        Iterator it = this.f16174a.iterator();
        while (it.hasNext()) {
            if (((ModelLoader) it.next()).a(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final ModelLoader.LoadData b(Object obj, int i2, int i3, Options options) {
        ModelLoader.LoadData loadDataB;
        ArrayList arrayList = this.f16174a;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        Key key = null;
        for (int i4 = 0; i4 < size; i4++) {
            ModelLoader modelLoader = (ModelLoader) arrayList.get(i4);
            if (modelLoader.a(obj) && (loadDataB = modelLoader.b(obj, i2, i3, options)) != null) {
                arrayList2.add(loadDataB.f16169c);
                key = loadDataB.f16167a;
            }
        }
        if (arrayList2.isEmpty() || key == null) {
            return null;
        }
        return new ModelLoader.LoadData(key, new MultiFetcher(arrayList2, this.f16175b));
    }

    public final String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f16174a.toArray()) + '}';
    }
}
