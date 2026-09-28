package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.coroutines.ObsoleteCoroutinesApi;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@ObsoleteCoroutinesApi
@Metadata
/* loaded from: classes3.dex */
public final class TickerMode {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TickerMode[] f54438a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f54439b;

    static {
        TickerMode[] tickerModeArr = {new TickerMode("FIXED_PERIOD", 0), new TickerMode("FIXED_DELAY", 1)};
        f54438a = tickerModeArr;
        f54439b = EnumEntriesKt.a(tickerModeArr);
    }

    public static TickerMode valueOf(String str) {
        return (TickerMode) Enum.valueOf(TickerMode.class, str);
    }

    public static TickerMode[] values() {
        return (TickerMode[]) f54438a.clone();
    }
}
