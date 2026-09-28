package coil3.request;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class CachePolicy {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CachePolicy[] $VALUES;
    private final boolean readEnabled;
    private final boolean writeEnabled;
    public static final CachePolicy ENABLED = new CachePolicy("ENABLED", 0, true, true);
    public static final CachePolicy READ_ONLY = new CachePolicy("READ_ONLY", 1, true, false);
    public static final CachePolicy WRITE_ONLY = new CachePolicy("WRITE_ONLY", 2, false, true);
    public static final CachePolicy DISABLED = new CachePolicy("DISABLED", 3, false, false);

    private static final /* synthetic */ CachePolicy[] $values() {
        return new CachePolicy[]{ENABLED, READ_ONLY, WRITE_ONLY, DISABLED};
    }

    static {
        CachePolicy[] cachePolicyArr$values = $values();
        $VALUES = cachePolicyArr$values;
        $ENTRIES = EnumEntriesKt.a(cachePolicyArr$values);
    }

    private CachePolicy(String str, int i2, boolean z, boolean z2) {
        this.readEnabled = z;
        this.writeEnabled = z2;
    }

    @NotNull
    public static EnumEntries<CachePolicy> getEntries() {
        return $ENTRIES;
    }

    public static CachePolicy valueOf(String str) {
        return (CachePolicy) Enum.valueOf(CachePolicy.class, str);
    }

    public static CachePolicy[] values() {
        return (CachePolicy[]) $VALUES.clone();
    }

    public final boolean getReadEnabled() {
        return this.readEnabled;
    }

    public final boolean getWriteEnabled() {
        return this.writeEnabled;
    }
}
