package coil3.size;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class Scale {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Scale[] $VALUES;
    public static final Scale FILL = new Scale("FILL", 0);
    public static final Scale FIT = new Scale("FIT", 1);

    private static final /* synthetic */ Scale[] $values() {
        return new Scale[]{FILL, FIT};
    }

    static {
        Scale[] scaleArr$values = $values();
        $VALUES = scaleArr$values;
        $ENTRIES = EnumEntriesKt.a(scaleArr$values);
    }

    private Scale(String str, int i2) {
    }

    @NotNull
    public static EnumEntries<Scale> getEntries() {
        return $ENTRIES;
    }

    public static Scale valueOf(String str) {
        return (Scale) Enum.valueOf(Scale.class, str);
    }

    public static Scale[] values() {
        return (Scale[]) $VALUES.clone();
    }
}
