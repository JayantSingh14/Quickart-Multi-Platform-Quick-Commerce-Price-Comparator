package com.google.firebase.logger;

import androidx.annotation.VisibleForTesting;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public abstract class Logger {

    @Metadata
    @SourceDebugExtension
    public static final class AndroidLogger extends Logger {

        @Metadata
        public /* synthetic */ class WhenMappings {
            static {
                int[] iArr = new int[Level.values().length];
                try {
                    iArr[0] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[1] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[2] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[3] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[4] = 5;
                } catch (NoSuchFieldError unused5) {
                }
            }
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }

    @Metadata
    @VisibleForTesting
    @SourceDebugExtension
    public static final class FakeLogger extends Logger {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class Level {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Level[] f44664a = {new Level("VERBOSE", 0), new Level("DEBUG", 1), new Level("INFO", 2), new Level("WARN", 3), new Level(MerchantConstants.ERROR, 4)};

        /* JADX INFO: Fake field, exist only in values array */
        Level EF5;

        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

        public static Level[] values() {
            return (Level[]) f44664a.clone();
        }
    }

    static {
        new ConcurrentHashMap();
    }
}
