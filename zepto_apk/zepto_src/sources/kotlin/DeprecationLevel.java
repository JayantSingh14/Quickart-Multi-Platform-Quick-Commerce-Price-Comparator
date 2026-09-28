package kotlin;

import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class DeprecationLevel {

    /* renamed from: a, reason: collision with root package name */
    public static final DeprecationLevel f53519a;

    /* renamed from: b, reason: collision with root package name */
    public static final DeprecationLevel f53520b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ DeprecationLevel[] f53521c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f53522d;

    static {
        DeprecationLevel deprecationLevel = new DeprecationLevel("WARNING", 0);
        f53519a = deprecationLevel;
        DeprecationLevel deprecationLevel2 = new DeprecationLevel(MerchantConstants.ERROR, 1);
        f53520b = deprecationLevel2;
        DeprecationLevel[] deprecationLevelArr = {deprecationLevel, deprecationLevel2, new DeprecationLevel("HIDDEN", 2)};
        f53521c = deprecationLevelArr;
        f53522d = EnumEntriesKt.a(deprecationLevelArr);
    }

    public static DeprecationLevel valueOf(String str) {
        return (DeprecationLevel) Enum.valueOf(DeprecationLevel.class, str);
    }

    public static DeprecationLevel[] values() {
        return (DeprecationLevel[]) f53521c.clone();
    }
}
