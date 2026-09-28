package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ResourceDecoderRegistry {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f16433a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f16434b = new HashMap();

    public static class Entry<T, R> {

        /* renamed from: a, reason: collision with root package name */
        public final Class f16435a;

        /* renamed from: b, reason: collision with root package name */
        public final Class f16436b;

        /* renamed from: c, reason: collision with root package name */
        public final ResourceDecoder f16437c;

        public Entry(Class cls, Class cls2, ResourceDecoder resourceDecoder) {
            this.f16435a = cls;
            this.f16436b = cls2;
            this.f16437c = resourceDecoder;
        }
    }

    public final synchronized void a(ResourceDecoder resourceDecoder, Class cls, Class cls2, String str) {
        c(str).add(new Entry(cls, cls2, resourceDecoder));
    }

    public final synchronized ArrayList b(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f16433a.iterator();
        while (it.hasNext()) {
            List<Entry> list = (List) this.f16434b.get((String) it.next());
            if (list != null) {
                for (Entry entry : list) {
                    if (entry.f16435a.isAssignableFrom(cls) && cls2.isAssignableFrom(entry.f16436b)) {
                        arrayList.add(entry.f16437c);
                    }
                }
            }
        }
        return arrayList;
    }

    public final synchronized List c(String str) {
        List arrayList;
        try {
            if (!this.f16433a.contains(str)) {
                this.f16433a.add(str);
            }
            arrayList = (List) this.f16434b.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f16434b.put(str, arrayList);
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public final synchronized ArrayList d(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f16433a.iterator();
        while (it.hasNext()) {
            List<Entry> list = (List) this.f16434b.get((String) it.next());
            if (list != null) {
                for (Entry entry : list) {
                    if ((entry.f16435a.isAssignableFrom(cls) && cls2.isAssignableFrom(entry.f16436b)) && !arrayList.contains(entry.f16436b)) {
                        arrayList.add(entry.f16436b);
                    }
                }
            }
        }
        return arrayList;
    }
}
