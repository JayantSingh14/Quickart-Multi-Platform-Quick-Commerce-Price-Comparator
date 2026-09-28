package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.StringUtils;
import java.nio.charset.Charset;
import java.util.UUID;

/* loaded from: classes.dex */
public final class SentryId implements JsonSerializable {

    /* renamed from: b, reason: collision with root package name */
    public static final SentryId f52907b = new SentryId(new UUID(0, 0));

    /* renamed from: a, reason: collision with root package name */
    public final UUID f52908a;

    /* loaded from: classes3.dex */
    public static final class Deserializer implements JsonDeserializer<SentryId> {
        public static SentryId b(ObjectReader objectReader) {
            return new SentryId(objectReader.K0());
        }

        @Override // io.sentry.JsonDeserializer
        public final /* bridge */ /* synthetic */ Object a(ObjectReader objectReader, ILogger iLogger) {
            return b(objectReader);
        }
    }

    public SentryId() {
        this((UUID) null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && SentryId.class == obj.getClass() && this.f52908a.compareTo(((SentryId) obj).f52908a) == 0;
    }

    public final int hashCode() {
        return this.f52908a.hashCode();
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.e(toString());
    }

    public final String toString() {
        String string = this.f52908a.toString();
        Charset charset = StringUtils.f53134a;
        if (string.equals("0000-0000")) {
            string = "00000000-0000-0000-0000-000000000000";
        }
        return string.replace("-", "");
    }

    public SentryId(UUID uuid) {
        this.f52908a = uuid == null ? UUID.randomUUID() : uuid;
    }

    public SentryId(String str) {
        Charset charset = StringUtils.f53134a;
        str = str.equals("0000-0000") ? "00000000-0000-0000-0000-000000000000" : str;
        str = str.length() == 32 ? new StringBuilder(str).insert(8, "-").insert(13, "-").insert(18, "-").insert(23, "-").toString() : str;
        if (str.length() == 36) {
            this.f52908a = UUID.fromString(str);
            return;
        }
        throw new IllegalArgumentException("String representation of SentryId has either 32 (UUID no dashes) or 36 characters long (completed UUID). Received: ".concat(str));
    }
}
