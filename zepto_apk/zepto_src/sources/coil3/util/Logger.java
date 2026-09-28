package coil3.util;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public interface Logger {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class Level {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Level[] $VALUES;
        public static final Level Verbose = new Level("Verbose", 0);
        public static final Level Debug = new Level("Debug", 1);
        public static final Level Info = new Level("Info", 2);
        public static final Level Warn = new Level("Warn", 3);
        public static final Level Error = new Level("Error", 4);

        private static final /* synthetic */ Level[] $values() {
            return new Level[]{Verbose, Debug, Info, Warn, Error};
        }

        static {
            Level[] levelArr$values = $values();
            $VALUES = levelArr$values;
            $ENTRIES = EnumEntriesKt.a(levelArr$values);
        }

        private Level(String str, int i2) {
        }

        @NotNull
        public static EnumEntries<Level> getEntries() {
            return $ENTRIES;
        }

        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

        public static Level[] values() {
            return (Level[]) $VALUES.clone();
        }
    }

    @NotNull
    Level getMinLevel();

    void log(@NotNull String str, @NotNull Level level, @Nullable String str2, @Nullable Throwable th);

    void setMinLevel(@NotNull Level level);
}
