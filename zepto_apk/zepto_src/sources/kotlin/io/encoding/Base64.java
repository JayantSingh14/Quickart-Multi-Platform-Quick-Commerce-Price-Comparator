package kotlin.io.encoding;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@ExperimentalEncodingApi
@SinceKotlin
@Metadata
/* loaded from: classes3.dex */
public class Base64 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final Default f53754a = new Default(null);

    @Metadata
    public static final class Default extends Base64 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Default(DefaultConstructorMarker defaultConstructorMarker) {
            super(false, false);
            PaddingOption[] paddingOptionArr = PaddingOption.f53755a;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @SinceKotlin
    @Metadata
    public static final class PaddingOption {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PaddingOption[] f53755a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f53756b;

        static {
            PaddingOption[] paddingOptionArr = {new PaddingOption("PRESENT", 0), new PaddingOption("ABSENT", 1), new PaddingOption("PRESENT_OPTIONAL", 2), new PaddingOption("ABSENT_OPTIONAL", 3)};
            f53755a = paddingOptionArr;
            f53756b = EnumEntriesKt.a(paddingOptionArr);
        }

        public static PaddingOption valueOf(String str) {
            return (PaddingOption) Enum.valueOf(PaddingOption.class, str);
        }

        public static PaddingOption[] values() {
            return (PaddingOption[]) f53755a.clone();
        }
    }

    static {
        PaddingOption[] paddingOptionArr = PaddingOption.f53755a;
        new Base64(true, false);
        new Base64(false, true);
    }

    public Base64(boolean z, boolean z2) {
        PaddingOption[] paddingOptionArr = PaddingOption.f53755a;
        if (z && z2) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }
}
