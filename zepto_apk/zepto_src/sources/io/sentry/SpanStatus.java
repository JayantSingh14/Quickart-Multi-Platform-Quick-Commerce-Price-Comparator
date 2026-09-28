package io.sentry;

import java.io.IOException;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes.dex */
public enum SpanStatus implements JsonSerializable {
    OK(200, 299),
    CANCELLED(499),
    INTERNAL_ERROR(500),
    UNKNOWN(500),
    UNKNOWN_ERROR(500),
    INVALID_ARGUMENT(400),
    DEADLINE_EXCEEDED(504),
    NOT_FOUND(404),
    ALREADY_EXISTS(409),
    PERMISSION_DENIED(403),
    RESOURCE_EXHAUSTED(429),
    FAILED_PRECONDITION(400),
    ABORTED(409),
    OUT_OF_RANGE(400),
    UNIMPLEMENTED(501),
    UNAVAILABLE(503),
    DATA_LOSS(500),
    UNAUTHENTICATED(401);

    private final int maxHttpStatusCode;
    private final int minHttpStatusCode;

    public static final class Deserializer implements JsonDeserializer<SpanStatus> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            return SpanStatus.valueOf(objectReader.K0().toUpperCase(Locale.ROOT));
        }
    }

    SpanStatus(int i2) {
        this.minHttpStatusCode = i2;
        this.maxHttpStatusCode = i2;
    }

    @Nullable
    public static SpanStatus fromHttpStatusCode(int i2) {
        for (SpanStatus spanStatus : values()) {
            if (spanStatus.matches(i2)) {
                return spanStatus;
            }
        }
        return null;
    }

    private boolean matches(int i2) {
        return i2 >= this.minHttpStatusCode && i2 <= this.maxHttpStatusCode;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(@NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
        objectWriter.e(name().toLowerCase(Locale.ROOT));
    }

    @NotNull
    public static SpanStatus fromHttpStatusCode(@Nullable Integer num, @NotNull SpanStatus spanStatus) {
        SpanStatus spanStatusFromHttpStatusCode = num != null ? fromHttpStatusCode(num.intValue()) : spanStatus;
        return spanStatusFromHttpStatusCode != null ? spanStatusFromHttpStatusCode : spanStatus;
    }

    SpanStatus(int i2, int i3) {
        this.minHttpStatusCode = i2;
        this.maxHttpStatusCode = i3;
    }
}
