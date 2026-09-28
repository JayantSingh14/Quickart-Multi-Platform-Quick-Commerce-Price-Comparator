package io.sentry.metrics;

import io.sentry.MeasurementUnit;
import io.sentry.util.Random;
import java.util.regex.Pattern;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class MetricsHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f52782a = Pattern.compile("\\W+");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f52783b = Pattern.compile("[^\\w\\-.]+");

    /* renamed from: c, reason: collision with root package name */
    public static final long f52784c;

    /* renamed from: io.sentry.metrics.MetricsHelper$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f52785a;

        static {
            int[] iArr = new int[MeasurementUnit.Duration.values().length];
            f52785a = iArr;
            try {
                iArr[MeasurementUnit.Duration.NANOSECOND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f52785a[MeasurementUnit.Duration.MICROSECOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f52785a[MeasurementUnit.Duration.MILLISECOND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f52785a[MeasurementUnit.Duration.SECOND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f52785a[MeasurementUnit.Duration.MINUTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f52785a[MeasurementUnit.Duration.HOUR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f52785a[MeasurementUnit.Duration.DAY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f52785a[MeasurementUnit.Duration.WEEK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    static {
        Pattern.compile("[^\\w\\-./]+");
        f52784c = (long) ((new Random().a(24) / 1.6777216E7f) * 10000.0f);
    }
}
