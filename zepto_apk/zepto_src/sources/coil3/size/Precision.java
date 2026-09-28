package coil3.size;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class Precision {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Precision[] $VALUES;
    public static final Precision EXACT = new Precision("EXACT", 0);
    public static final Precision INEXACT = new Precision("INEXACT", 1);

    private static final /* synthetic */ Precision[] $values() {
        return new Precision[]{EXACT, INEXACT};
    }

    static {
        Precision[] precisionArr$values = $values();
        $VALUES = precisionArr$values;
        $ENTRIES = EnumEntriesKt.a(precisionArr$values);
    }

    private Precision(String str, int i2) {
    }

    @NotNull
    public static EnumEntries<Precision> getEntries() {
        return $ENTRIES;
    }

    public static Precision valueOf(String str) {
        return (Precision) Enum.valueOf(Precision.class, str);
    }

    public static Precision[] values() {
        return (Precision[]) $VALUES.clone();
    }
}
