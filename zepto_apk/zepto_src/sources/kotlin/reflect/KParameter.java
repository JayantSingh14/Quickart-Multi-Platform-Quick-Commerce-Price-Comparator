package kotlin.reflect;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata
/* loaded from: classes3.dex */
public interface KParameter extends KAnnotatedElement {

    @Metadata
    public static final class DefaultImpls {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class Kind {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Kind[] f53875a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f53876b;

        static {
            Kind[] kindArr = {new Kind("INSTANCE", 0), new Kind("EXTENSION_RECEIVER", 1), new Kind("VALUE", 2)};
            f53875a = kindArr;
            f53876b = EnumEntriesKt.a(kindArr);
        }

        public static Kind valueOf(String str) {
            return (Kind) Enum.valueOf(Kind.class, str);
        }

        public static Kind[] values() {
            return (Kind[]) f53875a.clone();
        }
    }
}
