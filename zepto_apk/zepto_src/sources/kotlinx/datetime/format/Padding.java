package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class Padding {

    /* renamed from: a, reason: collision with root package name */
    public static final Padding f55478a;

    /* renamed from: b, reason: collision with root package name */
    public static final Padding f55479b;

    /* renamed from: c, reason: collision with root package name */
    public static final Padding f55480c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ Padding[] f55481d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f55482e;

    static {
        Padding padding = new Padding("NONE", 0);
        f55478a = padding;
        Padding padding2 = new Padding("ZERO", 1);
        f55479b = padding2;
        Padding padding3 = new Padding("SPACE", 2);
        f55480c = padding3;
        Padding[] paddingArr = {padding, padding2, padding3};
        f55481d = paddingArr;
        f55482e = EnumEntriesKt.a(paddingArr);
    }

    public static Padding valueOf(String str) {
        return (Padding) Enum.valueOf(Padding.class, str);
    }

    public static Padding[] values() {
        return (Padding[]) f55481d.clone();
    }
}
