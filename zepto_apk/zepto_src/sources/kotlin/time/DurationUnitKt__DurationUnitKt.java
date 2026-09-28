package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
class DurationUnitKt__DurationUnitKt extends DurationUnitKt__DurationUnitJvmKt {

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[DurationUnit.values().length];
            try {
                iArr[DurationUnit.f54019b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DurationUnit.f54020c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DurationUnit.f54021d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DurationUnit.f54022e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DurationUnit.f54023f.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DurationUnit.f54024g.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DurationUnit.f54025h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final DurationUnit d(char c2, boolean z) {
        if (!z) {
            if (c2 == 'D') {
                return DurationUnit.f54025h;
            }
            throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + c2);
        }
        if (c2 == 'H') {
            return DurationUnit.f54024g;
        }
        if (c2 == 'M') {
            return DurationUnit.f54023f;
        }
        if (c2 == 'S') {
            return DurationUnit.f54022e;
        }
        throw new IllegalArgumentException("Invalid duration ISO time unit: " + c2);
    }

    public static final DurationUnit e(String shortName) {
        Intrinsics.checkNotNullParameter(shortName, "shortName");
        int iHashCode = shortName.hashCode();
        if (iHashCode != 100) {
            if (iHashCode != 104) {
                if (iHashCode != 109) {
                    if (iHashCode != 115) {
                        if (iHashCode != 3494) {
                            if (iHashCode != 3525) {
                                if (iHashCode == 3742 && shortName.equals("us")) {
                                    return DurationUnit.f54020c;
                                }
                            } else if (shortName.equals("ns")) {
                                return DurationUnit.f54019b;
                            }
                        } else if (shortName.equals("ms")) {
                            return DurationUnit.f54021d;
                        }
                    } else if (shortName.equals("s")) {
                        return DurationUnit.f54022e;
                    }
                } else if (shortName.equals("m")) {
                    return DurationUnit.f54023f;
                }
            } else if (shortName.equals("h")) {
                return DurationUnit.f54024g;
            }
        } else if (shortName.equals("d")) {
            return DurationUnit.f54025h;
        }
        throw new IllegalArgumentException("Unknown duration unit short name: ".concat(shortName));
    }
}
