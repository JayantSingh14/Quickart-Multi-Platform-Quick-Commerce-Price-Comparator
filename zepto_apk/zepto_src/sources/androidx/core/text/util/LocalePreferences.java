package androidx.core.text.util;

import android.icu.text.DateFormat;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RequiresApi
/* loaded from: classes3.dex */
public final class LocalePreferences {

    /* renamed from: androidx.core.text.util.LocalePreferences$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2968a;

        static {
            int[] iArr = new int[DateFormat.HourCycle.values().length];
            f2968a = iArr;
            try {
                DateFormat.HourCycle unused = DateFormat.HourCycle.HOUR_CYCLE_11;
                iArr[DateFormat.HourCycle.HOUR_CYCLE_11.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr2 = f2968a;
                DateFormat.HourCycle unused3 = DateFormat.HourCycle.HOUR_CYCLE_12;
                iArr2[DateFormat.HourCycle.HOUR_CYCLE_12.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr3 = f2968a;
                DateFormat.HourCycle unused5 = DateFormat.HourCycle.HOUR_CYCLE_23;
                iArr3[DateFormat.HourCycle.HOUR_CYCLE_23.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr4 = f2968a;
                DateFormat.HourCycle unused7 = DateFormat.HourCycle.HOUR_CYCLE_24;
                iArr4[DateFormat.HourCycle.HOUR_CYCLE_24.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @RequiresApi
    public static class Api24Impl {
    }

    @RequiresApi
    public static class Api33Impl {
    }

    public static class CalendarType {

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo
        public @interface CalendarTypes {
        }
    }

    public static class FirstDayOfWeek {

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo
        public @interface Days {
        }
    }

    public static class HourCycle {

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo
        public @interface HourCycleTypes {
        }
    }

    public static class TemperatureUnit {

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo
        public @interface TemperatureUnits {
        }
    }
}
