package com.bumptech.glide.load.resource.transcode;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class TranscoderRegistry {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f16393a = new ArrayList();

    public static final class Entry<Z, R> {

        /* renamed from: a, reason: collision with root package name */
        public final Class f16394a;

        /* renamed from: b, reason: collision with root package name */
        public final Class f16395b;

        /* renamed from: c, reason: collision with root package name */
        public final ResourceTranscoder f16396c;

        public Entry(Class cls, Class cls2, ResourceTranscoder resourceTranscoder) {
            this.f16394a = cls;
            this.f16395b = cls2;
            this.f16396c = resourceTranscoder;
        }
    }

    public final synchronized ResourceTranscoder a(Class cls, Class cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return UnitTranscoder.f16397a;
        }
        Iterator it = this.f16393a.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (entry.f16394a.isAssignableFrom(cls) && cls2.isAssignableFrom(entry.f16395b)) {
                return entry.f16396c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public final synchronized ArrayList b(Class cls, Class cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        Iterator it = this.f16393a.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (entry.f16394a.isAssignableFrom(cls) && cls2.isAssignableFrom(entry.f16395b)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public final synchronized void c(Class cls, Class cls2, ResourceTranscoder resourceTranscoder) {
        this.f16393a.add(new Entry(cls, cls2, resourceTranscoder));
    }
}
