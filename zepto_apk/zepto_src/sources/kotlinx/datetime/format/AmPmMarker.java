package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class AmPmMarker {

    /* renamed from: a, reason: collision with root package name */
    public static final AmPmMarker f55370a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AmPmMarker[] f55371b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f55372c;

    static {
        AmPmMarker amPmMarker = new AmPmMarker("AM", 0);
        AmPmMarker amPmMarker2 = new AmPmMarker("PM", 1);
        f55370a = amPmMarker2;
        AmPmMarker[] amPmMarkerArr = {amPmMarker, amPmMarker2};
        f55371b = amPmMarkerArr;
        f55372c = EnumEntriesKt.a(amPmMarkerArr);
    }

    public static AmPmMarker valueOf(String str) {
        return (AmPmMarker) Enum.valueOf(AmPmMarker.class, str);
    }

    public static AmPmMarker[] values() {
        return (AmPmMarker[]) f55371b.clone();
    }
}
