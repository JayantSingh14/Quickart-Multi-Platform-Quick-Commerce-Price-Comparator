package com.bumptech.glide.load.model;

import android.support.v4.media.b;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class LazyHeaders implements Headers {

    /* renamed from: b, reason: collision with root package name */
    public final Map f16154b;

    /* renamed from: c, reason: collision with root package name */
    public volatile Map f16155c;

    public static final class Builder {

        /* renamed from: b, reason: collision with root package name */
        public static final Map f16156b;

        /* renamed from: a, reason: collision with root package name */
        public final Map f16157a = f16156b;

        static {
            String property = System.getProperty("http.agent");
            if (!TextUtils.isEmpty(property)) {
                int length = property.length();
                StringBuilder sb = new StringBuilder(property.length());
                for (int i2 = 0; i2 < length; i2++) {
                    char cCharAt = property.charAt(i2);
                    if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                        sb.append(cCharAt);
                    } else {
                        sb.append('?');
                    }
                }
                property = sb.toString();
            }
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(property)) {
                map.put("User-Agent", Collections.singletonList(new StringHeaderFactory(property)));
            }
            f16156b = Collections.unmodifiableMap(map);
        }
    }

    public static final class StringHeaderFactory implements LazyHeaderFactory {

        /* renamed from: a, reason: collision with root package name */
        public final String f16158a;

        public StringHeaderFactory(String str) {
            this.f16158a = str;
        }

        @Override // com.bumptech.glide.load.model.LazyHeaderFactory
        public final String a() {
            return this.f16158a;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof StringHeaderFactory) {
                return this.f16158a.equals(((StringHeaderFactory) obj).f16158a);
            }
            return false;
        }

        public final int hashCode() {
            return this.f16158a.hashCode();
        }

        public final String toString() {
            return b.r(new StringBuilder("StringHeaderFactory{value='"), this.f16158a, "'}");
        }
    }

    public LazyHeaders(Map map) {
        this.f16154b = Collections.unmodifiableMap(map);
    }

    public final HashMap a() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f16154b.entrySet()) {
            List list = (List) entry.getValue();
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                String strA = ((LazyHeaderFactory) list.get(i2)).a();
                if (!TextUtils.isEmpty(strA)) {
                    sb.append(strA);
                    if (i2 != list.size() - 1) {
                        sb.append(',');
                    }
                }
            }
            String string = sb.toString();
            if (!TextUtils.isEmpty(string)) {
                map.put(entry.getKey(), string);
            }
        }
        return map;
    }

    public final Map b() {
        if (this.f16155c == null) {
            synchronized (this) {
                try {
                    if (this.f16155c == null) {
                        this.f16155c = Collections.unmodifiableMap(a());
                    }
                } finally {
                }
            }
        }
        return this.f16155c;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof LazyHeaders) {
            return this.f16154b.equals(((LazyHeaders) obj).f16154b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f16154b.hashCode();
    }

    public final String toString() {
        return "LazyHeaders{headers=" + this.f16154b + '}';
    }
}
