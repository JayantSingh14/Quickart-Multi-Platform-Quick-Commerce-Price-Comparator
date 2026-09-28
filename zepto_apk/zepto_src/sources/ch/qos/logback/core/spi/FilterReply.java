package ch.qos.logback.core.spi;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class FilterReply {

    /* renamed from: a, reason: collision with root package name */
    public static final FilterReply f13739a;

    /* renamed from: b, reason: collision with root package name */
    public static final FilterReply f13740b;

    /* renamed from: c, reason: collision with root package name */
    public static final FilterReply f13741c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ FilterReply[] f13742d;

    static {
        FilterReply filterReply = new FilterReply("DENY", 0);
        f13739a = filterReply;
        FilterReply filterReply2 = new FilterReply("NEUTRAL", 1);
        f13740b = filterReply2;
        FilterReply filterReply3 = new FilterReply("ACCEPT", 2);
        f13741c = filterReply3;
        f13742d = new FilterReply[]{filterReply, filterReply2, filterReply3};
    }

    public static FilterReply valueOf(String str) {
        return (FilterReply) Enum.valueOf(FilterReply.class, str);
    }

    public static FilterReply[] values() {
        return (FilterReply[]) f13742d.clone();
    }
}
