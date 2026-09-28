package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
@ExperimentalSerializationApi
/* loaded from: classes3.dex */
public final class DecodeSequenceMode {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DecodeSequenceMode[] f55942a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f55943b;

    static {
        DecodeSequenceMode[] decodeSequenceModeArr = {new DecodeSequenceMode("WHITESPACE_SEPARATED", 0), new DecodeSequenceMode("ARRAY_WRAPPED", 1), new DecodeSequenceMode("AUTO_DETECT", 2)};
        f55942a = decodeSequenceModeArr;
        f55943b = EnumEntriesKt.a(decodeSequenceModeArr);
    }

    public static DecodeSequenceMode valueOf(String str) {
        return (DecodeSequenceMode) Enum.valueOf(DecodeSequenceMode.class, str);
    }

    public static DecodeSequenceMode[] values() {
        return (DecodeSequenceMode[]) f55942a.clone();
    }
}
