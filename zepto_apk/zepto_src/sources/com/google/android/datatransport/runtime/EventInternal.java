package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.auto.value.AutoValue;
import java.util.HashMap;
import java.util.Map;

@AutoValue
/* loaded from: classes3.dex */
public abstract class EventInternal {

    @AutoValue.Builder
    public static abstract class Builder {
        public final void a(String str, String str2) {
            ((HashMap) c()).put(str, str2);
        }

        public abstract EventInternal b();

        public abstract Map c();

        public abstract Builder d(Integer num);

        public abstract Builder e(EncodedPayload encodedPayload);

        public abstract Builder f(long j2);

        public abstract Builder g(byte[] bArr);

        public abstract Builder h(byte[] bArr);

        public abstract Builder i(Integer num);

        public abstract Builder j(String str);

        public abstract Builder k(String str);

        public abstract Builder l(long j2);
    }

    public static Builder a() {
        AutoValue_EventInternal.Builder builder = new AutoValue_EventInternal.Builder();
        builder.f20712f = new HashMap();
        return builder;
    }

    public final String b(String str) {
        String str2 = (String) c().get(str);
        return str2 == null ? "" : str2;
    }

    public abstract Map c();

    public abstract Integer d();

    public abstract EncodedPayload e();

    public abstract long f();

    public abstract byte[] g();

    public abstract byte[] h();

    public final int i(String str) {
        String str2 = (String) c().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public abstract Integer j();

    public abstract String k();

    public abstract String l();

    public abstract long m();

    public final Builder n() {
        AutoValue_EventInternal.Builder builder = new AutoValue_EventInternal.Builder();
        builder.k(l());
        builder.f20708b = d();
        builder.f20713g = j();
        builder.f20714h = k();
        builder.f20715i = g();
        builder.f20716j = h();
        builder.e(e());
        builder.f(f());
        builder.l(m());
        builder.f20712f = new HashMap(c());
        return builder;
    }
}
