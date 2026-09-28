package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class EncoderRegistry {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f16424a = new ArrayList();

    public static final class Entry<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Class f16425a;

        /* renamed from: b, reason: collision with root package name */
        public final Encoder f16426b;

        public Entry(Class cls, Encoder encoder) {
            this.f16425a = cls;
            this.f16426b = encoder;
        }
    }

    public final synchronized void a(Class cls, Encoder encoder) {
        this.f16424a.add(new Entry(cls, encoder));
    }

    public final synchronized Encoder b(Class cls) {
        Iterator it = this.f16424a.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (entry.f16425a.isAssignableFrom(cls)) {
                return entry.f16426b;
            }
        }
        return null;
    }
}
