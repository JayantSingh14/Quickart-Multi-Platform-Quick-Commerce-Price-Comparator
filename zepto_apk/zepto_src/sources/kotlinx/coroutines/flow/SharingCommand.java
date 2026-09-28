package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class SharingCommand {

    /* renamed from: a, reason: collision with root package name */
    public static final SharingCommand f54897a;

    /* renamed from: b, reason: collision with root package name */
    public static final SharingCommand f54898b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ SharingCommand[] f54899c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f54900d;

    static {
        SharingCommand sharingCommand = new SharingCommand("START", 0);
        f54897a = sharingCommand;
        SharingCommand sharingCommand2 = new SharingCommand("STOP", 1);
        SharingCommand sharingCommand3 = new SharingCommand("STOP_AND_RESET_REPLAY_CACHE", 2);
        f54898b = sharingCommand3;
        SharingCommand[] sharingCommandArr = {sharingCommand, sharingCommand2, sharingCommand3};
        f54899c = sharingCommandArr;
        f54900d = EnumEntriesKt.a(sharingCommandArr);
    }

    public static SharingCommand valueOf(String str) {
        return (SharingCommand) Enum.valueOf(SharingCommand.class, str);
    }

    public static SharingCommand[] values() {
        return (SharingCommand[]) f54899c.clone();
    }
}
