package com.bumptech.glide.load.engine;

import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.provider.LoadPathCache;
import com.bumptech.glide.provider.ResourceDecoderRegistry;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.MultiClassKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
final class DecodeHelper<Transcode> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f15883a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f15884b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public GlideContext f15885c;

    /* renamed from: d, reason: collision with root package name */
    public Object f15886d;

    /* renamed from: e, reason: collision with root package name */
    public int f15887e;

    /* renamed from: f, reason: collision with root package name */
    public int f15888f;

    /* renamed from: g, reason: collision with root package name */
    public Class f15889g;

    /* renamed from: h, reason: collision with root package name */
    public Engine.LazyDiskCacheProvider f15890h;

    /* renamed from: i, reason: collision with root package name */
    public Options f15891i;

    /* renamed from: j, reason: collision with root package name */
    public CachedHashCodeArrayMap f15892j;

    /* renamed from: k, reason: collision with root package name */
    public Class f15893k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f15894l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f15895m;
    public Key n;
    public Priority o;
    public DiskCacheStrategy p;
    public boolean q;
    public boolean r;

    public final ArrayList a() {
        boolean z = this.f15895m;
        ArrayList arrayList = this.f15884b;
        if (!z) {
            this.f15895m = true;
            arrayList.clear();
            ArrayList arrayListB = b();
            int size = arrayListB.size();
            for (int i2 = 0; i2 < size; i2++) {
                ModelLoader.LoadData loadData = (ModelLoader.LoadData) arrayListB.get(i2);
                if (!arrayList.contains(loadData.f16167a)) {
                    arrayList.add(loadData.f16167a);
                }
                int i3 = 0;
                while (true) {
                    List list = loadData.f16168b;
                    if (i3 < list.size()) {
                        if (!arrayList.contains(list.get(i3))) {
                            arrayList.add(list.get(i3));
                        }
                        i3++;
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList b() {
        boolean z = this.f15894l;
        ArrayList arrayList = this.f15883a;
        if (!z) {
            this.f15894l = true;
            arrayList.clear();
            Registry registry = this.f15885c.f15672b;
            List listB = registry.f15688a.b(this.f15886d);
            int size = listB.size();
            for (int i2 = 0; i2 < size; i2++) {
                ModelLoader.LoadData loadDataB = ((ModelLoader) listB.get(i2)).b(this.f15886d, this.f15887e, this.f15888f, this.f15891i);
                if (loadDataB != null) {
                    arrayList.add(loadDataB);
                }
            }
        }
        return arrayList;
    }

    public final LoadPath c(Class cls) {
        LoadPath loadPath;
        Class cls2;
        Class cls3;
        Class cls4;
        Class cls5 = cls;
        Registry registry = this.f15885c.f15672b;
        Class cls6 = this.f15889g;
        Class cls7 = this.f15893k;
        LoadPathCache loadPathCache = registry.f15696i;
        LoadPath loadPath2 = null;
        MultiClassKey multiClassKey = (MultiClassKey) loadPathCache.f16430b.getAndSet(null);
        if (multiClassKey == null) {
            multiClassKey = new MultiClassKey();
        }
        multiClassKey.f16525a = cls5;
        multiClassKey.f16526b = cls6;
        multiClassKey.f16527c = cls7;
        synchronized (loadPathCache.f16429a) {
            loadPath = (LoadPath) loadPathCache.f16429a.get(multiClassKey);
        }
        loadPathCache.f16430b.set(multiClassKey);
        registry.f15696i.getClass();
        if (LoadPathCache.f16428c.equals(loadPath)) {
            return null;
        }
        if (loadPath != null) {
            return loadPath;
        }
        ArrayList arrayList = new ArrayList();
        ResourceDecoderRegistry resourceDecoderRegistry = registry.f15690c;
        Iterator it = resourceDecoderRegistry.d(cls5, cls6).iterator();
        while (it.hasNext()) {
            Class cls8 = (Class) it.next();
            TranscoderRegistry transcoderRegistry = registry.f15693f;
            Iterator it2 = transcoderRegistry.b(cls8, cls7).iterator();
            while (it2.hasNext()) {
                Class cls9 = (Class) it2.next();
                arrayList.add(new DecodePath(cls5, cls8, cls9, resourceDecoderRegistry.b(cls5, cls8), transcoderRegistry.a(cls8, cls9), registry.f15697j));
                cls5 = cls;
            }
            cls5 = cls;
        }
        if (arrayList.isEmpty()) {
            cls2 = cls;
            cls3 = cls6;
            cls4 = cls7;
        } else {
            cls2 = cls;
            cls3 = cls6;
            cls4 = cls7;
            loadPath2 = new LoadPath(cls2, cls3, cls4, arrayList, registry.f15697j);
        }
        LoadPathCache loadPathCache2 = registry.f15696i;
        synchronized (loadPathCache2.f16429a) {
            loadPathCache2.f16429a.put(new MultiClassKey(cls2, cls3, cls4), loadPath2 != null ? loadPath2 : LoadPathCache.f16428c);
        }
        return loadPath2;
    }

    public final Encoder d(Object obj) {
        Registry registry = this.f15885c.f15672b;
        registry.getClass();
        Encoder encoderB = registry.f15689b.b(obj.getClass());
        if (encoderB != null) {
            return encoderB;
        }
        throw new Registry.NoSourceEncoderAvailableException("Failed to find source encoder for data class: " + obj.getClass());
    }

    public final Transformation e(Class cls) {
        Transformation transformation = (Transformation) this.f15892j.get(cls);
        if (transformation == null) {
            Iterator it = this.f15892j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    transformation = (Transformation) entry.getValue();
                    break;
                }
            }
        }
        if (transformation != null) {
            return transformation;
        }
        if (!this.f15892j.isEmpty() || !this.q) {
            return UnitTransformation.f16246b;
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }
}
