package com.facebook.react.common;

import com.facebook.infer.annotation.Nullsafe;
import java.io.Serializable;
import java.util.HashMap;

@Nullsafe
@Deprecated
/* loaded from: classes.dex */
public class MapBuilder {

    public static final class Builder<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public HashMap f18696a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f18697b;

        public final HashMap a() {
            if (!this.f18697b) {
                throw new IllegalStateException("Underlying map has already been built");
            }
            this.f18697b = false;
            return this.f18696a;
        }

        public final void b(Object obj, Serializable serializable) {
            if (!this.f18697b) {
                throw new IllegalStateException("Underlying map has already been built");
            }
            this.f18696a.put(obj, serializable);
        }
    }

    public static Builder a() {
        Builder builder = new Builder();
        builder.f18696a = new HashMap();
        builder.f18697b = true;
        return builder;
    }

    public static HashMap b(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        HashMap map = new HashMap();
        map.put(obj, obj2);
        map.put(obj3, obj4);
        map.put(obj5, obj6);
        map.put(obj7, obj8);
        return map;
    }

    public static HashMap c(String str, Serializable serializable) {
        HashMap map = new HashMap();
        map.put(str, serializable);
        return map;
    }

    public static HashMap d(String str, Serializable serializable, String str2, Serializable serializable2) {
        HashMap map = new HashMap();
        map.put(str, serializable);
        map.put(str2, serializable2);
        return map;
    }

    public static HashMap e(String str, Serializable serializable, String str2, Serializable serializable2, String str3, Serializable serializable3) {
        HashMap map = new HashMap();
        map.put(str, serializable);
        map.put(str2, serializable2);
        map.put(str3, serializable3);
        return map;
    }

    public static HashMap f(String str, Serializable serializable, String str2, Serializable serializable2, String str3, Serializable serializable3, String str4, Serializable serializable4, String str5, Serializable serializable5) {
        HashMap map = new HashMap();
        map.put(str, serializable);
        map.put(str2, serializable2);
        map.put(str3, serializable3);
        map.put(str4, serializable4);
        map.put(str5, serializable5);
        return map;
    }
}
