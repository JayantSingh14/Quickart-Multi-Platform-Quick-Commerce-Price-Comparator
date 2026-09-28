package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ResourceEncoderRegistry {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f16438a = new ArrayList();

    public static final class Entry<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Class f16439a;

        /* renamed from: b, reason: collision with root package name */
        public final ResourceEncoder f16440b;

        public Entry(Class cls, ResourceEncoder resourceEncoder) {
            this.f16439a = cls;
            this.f16440b = resourceEncoder;
        }
    }

    public final synchronized void a(Class cls, ResourceEncoder resourceEncoder) {
        this.f16438a.add(new Entry(cls, resourceEncoder));
    }

    public final synchronized ResourceEncoder b(Class cls) {
        int size = this.f16438a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Entry entry = (Entry) this.f16438a.get(i2);
            if (entry.f16439a.isAssignableFrom(cls)) {
                return entry.f16440b;
            }
        }
        return null;
    }
}
