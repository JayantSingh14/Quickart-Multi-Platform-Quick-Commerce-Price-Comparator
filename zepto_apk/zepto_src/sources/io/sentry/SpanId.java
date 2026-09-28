package io.sentry;

import io.sentry.util.Objects;
import io.sentry.util.StringUtils;
import java.nio.charset.Charset;
import java.util.UUID;

/* loaded from: classes.dex */
public final class SpanId implements JsonSerializable {

    /* renamed from: b, reason: collision with root package name */
    public static final SpanId f51931b = new SpanId(new UUID(0, 0));

    /* renamed from: a, reason: collision with root package name */
    public final String f51932a;

    public static final class Deserializer implements JsonDeserializer<SpanId> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            return new SpanId(objectReader.K0());
        }
    }

    public SpanId(String str) {
        Objects.b(str, "value is required");
        this.f51932a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SpanId.class != obj.getClass()) {
            return false;
        }
        return this.f51932a.equals(((SpanId) obj).f51932a);
    }

    public final int hashCode() {
        return this.f51932a.hashCode();
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.e(this.f51932a);
    }

    public final String toString() {
        return this.f51932a;
    }

    public SpanId() {
        this(UUID.randomUUID());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SpanId(UUID uuid) {
        String string = uuid.toString();
        Charset charset = StringUtils.f53134a;
        this((string.equals("0000-0000") ? "00000000-0000-0000-0000-000000000000" : string).replace("-", "").substring(0, 16));
    }
}
