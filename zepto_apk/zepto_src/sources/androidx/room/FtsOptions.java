package androidx.room;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class FtsOptions {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class MatchInfo {

        /* renamed from: a, reason: collision with root package name */
        public static final MatchInfo f11753a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ MatchInfo[] f11754b;

        /* JADX INFO: Fake field, exist only in values array */
        MatchInfo EF0;

        static {
            MatchInfo matchInfo = new MatchInfo("FTS3", 0);
            MatchInfo matchInfo2 = new MatchInfo("FTS4", 1);
            f11753a = matchInfo2;
            f11754b = new MatchInfo[]{matchInfo, matchInfo2};
        }

        public static MatchInfo valueOf(String str) {
            return (MatchInfo) Enum.valueOf(MatchInfo.class, str);
        }

        public static MatchInfo[] values() {
            return (MatchInfo[]) f11754b.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class Order {

        /* renamed from: a, reason: collision with root package name */
        public static final Order f11755a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Order[] f11756b;

        static {
            Order order = new Order("ASC", 0);
            f11755a = order;
            f11756b = new Order[]{order, new Order("DESC", 1)};
        }

        public static Order valueOf(String str) {
            return (Order) Enum.valueOf(Order.class, str);
        }

        public static Order[] values() {
            return (Order[]) f11756b.clone();
        }
    }
}
