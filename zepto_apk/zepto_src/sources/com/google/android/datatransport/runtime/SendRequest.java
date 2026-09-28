package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.AutoValue_SendRequest;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes3.dex */
abstract class SendRequest {

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract AutoValue_SendRequest a();

        public abstract Builder b(Encoding encoding);

        public abstract Builder c(Event event);

        public abstract Builder d(Transformer transformer);

        public abstract Builder e(TransportContext transportContext);

        public abstract Builder f(String str);
    }

    public static Builder a() {
        return new AutoValue_SendRequest.Builder();
    }

    public abstract Encoding b();

    public abstract Event c();

    public final byte[] d() {
        return (byte[]) e().apply(c().c());
    }

    public abstract Transformer e();

    public abstract TransportContext f();

    public abstract String g();
}
