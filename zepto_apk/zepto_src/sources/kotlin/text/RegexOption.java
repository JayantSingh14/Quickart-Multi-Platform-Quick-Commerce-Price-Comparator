package kotlin.text;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class RegexOption implements FlagEnum {

    /* renamed from: b, reason: collision with root package name */
    public static final RegexOption f53995b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ RegexOption[] f53996c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f53997d;

    /* renamed from: a, reason: collision with root package name */
    public final int f53998a;

    static {
        RegexOption regexOption = new RegexOption("IGNORE_CASE", 0, 2, 0, 2, null);
        f53995b = regexOption;
        RegexOption[] regexOptionArr = {regexOption, new RegexOption("MULTILINE", 1, 8, 0, 2, null), new RegexOption("LITERAL", 2, 16, 0, 2, null), new RegexOption("UNIX_LINES", 3, 1, 0, 2, null), new RegexOption("COMMENTS", 4, 4, 0, 2, null), new RegexOption("DOT_MATCHES_ALL", 5, 32, 0, 2, null), new RegexOption("CANON_EQ", 6, 128, 0, 2, null)};
        f53996c = regexOptionArr;
        f53997d = EnumEntriesKt.a(regexOptionArr);
    }

    public RegexOption(String str, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this.f53998a = i3;
    }

    public static RegexOption valueOf(String str) {
        return (RegexOption) Enum.valueOf(RegexOption.class, str);
    }

    public static RegexOption[] values() {
        return (RegexOption[]) f53996c.clone();
    }

    @Override // kotlin.text.FlagEnum
    public final int getValue() {
        return this.f53998a;
    }
}
