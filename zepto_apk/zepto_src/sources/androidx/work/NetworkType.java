package androidx.work;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class NetworkType {

    /* renamed from: a, reason: collision with root package name */
    public static final NetworkType f12536a;

    /* renamed from: b, reason: collision with root package name */
    public static final NetworkType f12537b;

    /* renamed from: c, reason: collision with root package name */
    public static final NetworkType f12538c;

    /* renamed from: d, reason: collision with root package name */
    public static final NetworkType f12539d;

    /* renamed from: e, reason: collision with root package name */
    public static final NetworkType f12540e;

    /* renamed from: f, reason: collision with root package name */
    public static final NetworkType f12541f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ NetworkType[] f12542g;

    static {
        NetworkType networkType = new NetworkType("NOT_REQUIRED", 0);
        f12536a = networkType;
        NetworkType networkType2 = new NetworkType("CONNECTED", 1);
        f12537b = networkType2;
        NetworkType networkType3 = new NetworkType("UNMETERED", 2);
        f12538c = networkType3;
        NetworkType networkType4 = new NetworkType("NOT_ROAMING", 3);
        f12539d = networkType4;
        NetworkType networkType5 = new NetworkType("METERED", 4);
        f12540e = networkType5;
        NetworkType networkType6 = new NetworkType("TEMPORARILY_UNMETERED", 5);
        f12541f = networkType6;
        f12542g = new NetworkType[]{networkType, networkType2, networkType3, networkType4, networkType5, networkType6};
    }

    public static NetworkType valueOf(String str) {
        return (NetworkType) Enum.valueOf(NetworkType.class, str);
    }

    public static NetworkType[] values() {
        return (NetworkType[]) f12542g.clone();
    }
}
