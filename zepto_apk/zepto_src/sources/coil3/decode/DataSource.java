package coil3.decode;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class DataSource {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DataSource[] $VALUES;
    public static final DataSource MEMORY_CACHE = new DataSource("MEMORY_CACHE", 0);
    public static final DataSource MEMORY = new DataSource("MEMORY", 1);
    public static final DataSource DISK = new DataSource("DISK", 2);
    public static final DataSource NETWORK = new DataSource("NETWORK", 3);

    private static final /* synthetic */ DataSource[] $values() {
        return new DataSource[]{MEMORY_CACHE, MEMORY, DISK, NETWORK};
    }

    static {
        DataSource[] dataSourceArr$values = $values();
        $VALUES = dataSourceArr$values;
        $ENTRIES = EnumEntriesKt.a(dataSourceArr$values);
    }

    private DataSource(String str, int i2) {
    }

    @NotNull
    public static EnumEntries<DataSource> getEntries() {
        return $ENTRIES;
    }

    public static DataSource valueOf(String str) {
        return (DataSource) Enum.valueOf(DataSource.class, str);
    }

    public static DataSource[] values() {
        return (DataSource[]) $VALUES.clone();
    }
}
