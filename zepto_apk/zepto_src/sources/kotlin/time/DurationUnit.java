package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin
@Metadata
@WasExperimental
/* loaded from: classes3.dex */
public final class DurationUnit {

    /* renamed from: b, reason: collision with root package name */
    public static final DurationUnit f54019b;

    /* renamed from: c, reason: collision with root package name */
    public static final DurationUnit f54020c;

    /* renamed from: d, reason: collision with root package name */
    public static final DurationUnit f54021d;

    /* renamed from: e, reason: collision with root package name */
    public static final DurationUnit f54022e;

    /* renamed from: f, reason: collision with root package name */
    public static final DurationUnit f54023f;

    /* renamed from: g, reason: collision with root package name */
    public static final DurationUnit f54024g;

    /* renamed from: h, reason: collision with root package name */
    public static final DurationUnit f54025h;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ DurationUnit[] f54026i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f54027j;

    /* renamed from: a, reason: collision with root package name */
    public final TimeUnit f54028a;

    static {
        DurationUnit durationUnit = new DurationUnit("NANOSECONDS", 0, TimeUnit.NANOSECONDS);
        f54019b = durationUnit;
        DurationUnit durationUnit2 = new DurationUnit("MICROSECONDS", 1, TimeUnit.MICROSECONDS);
        f54020c = durationUnit2;
        DurationUnit durationUnit3 = new DurationUnit("MILLISECONDS", 2, TimeUnit.MILLISECONDS);
        f54021d = durationUnit3;
        DurationUnit durationUnit4 = new DurationUnit("SECONDS", 3, TimeUnit.SECONDS);
        f54022e = durationUnit4;
        DurationUnit durationUnit5 = new DurationUnit("MINUTES", 4, TimeUnit.MINUTES);
        f54023f = durationUnit5;
        DurationUnit durationUnit6 = new DurationUnit("HOURS", 5, TimeUnit.HOURS);
        f54024g = durationUnit6;
        DurationUnit durationUnit7 = new DurationUnit("DAYS", 6, TimeUnit.DAYS);
        f54025h = durationUnit7;
        DurationUnit[] durationUnitArr = {durationUnit, durationUnit2, durationUnit3, durationUnit4, durationUnit5, durationUnit6, durationUnit7};
        f54026i = durationUnitArr;
        f54027j = EnumEntriesKt.a(durationUnitArr);
    }

    public DurationUnit(String str, int i2, TimeUnit timeUnit) {
        this.f54028a = timeUnit;
    }

    public static DurationUnit valueOf(String str) {
        return (DurationUnit) Enum.valueOf(DurationUnit.class, str);
    }

    public static DurationUnit[] values() {
        return (DurationUnit[]) f54026i.clone();
    }
}
