package kotlinx.datetime;

import kotlin.Metadata;
import kotlinx.datetime.serializers.DatePeriodIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;

@Metadata
@Serializable(with = DatePeriodIso8601Serializer.class)
/* loaded from: classes3.dex */
public final class DatePeriod extends DateTimePeriod {

    @NotNull
    public static final Companion Companion = new Companion();

    /* renamed from: a, reason: collision with root package name */
    public final int f55338a;

    /* renamed from: b, reason: collision with root package name */
    public final int f55339b;

    @Metadata
    public static final class Companion {
        @NotNull
        public final KSerializer<DatePeriod> serializer() {
            return DatePeriodIso8601Serializer.f55645a;
        }
    }

    public DatePeriod(int i2, int i3) {
        this.f55338a = i2;
        this.f55339b = i3;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public final int a() {
        return this.f55339b;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public final int b() {
        return 0;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public final int c() {
        return 0;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public final int e() {
        return 0;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public final int f() {
        return 0;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public final int g() {
        return this.f55338a;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public final long h() {
        return 0L;
    }
}
