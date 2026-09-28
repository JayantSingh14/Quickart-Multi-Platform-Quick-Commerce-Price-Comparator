package io.ktor.client.plugins.cache;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class ValidateStatus {

    /* renamed from: a, reason: collision with root package name */
    public static final ValidateStatus f49746a;

    /* renamed from: b, reason: collision with root package name */
    public static final ValidateStatus f49747b;

    /* renamed from: c, reason: collision with root package name */
    public static final ValidateStatus f49748c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ ValidateStatus[] f49749d;

    static {
        ValidateStatus validateStatus = new ValidateStatus("ShouldValidate", 0);
        f49746a = validateStatus;
        ValidateStatus validateStatus2 = new ValidateStatus("ShouldNotValidate", 1);
        f49747b = validateStatus2;
        ValidateStatus validateStatus3 = new ValidateStatus("ShouldWarn", 2);
        f49748c = validateStatus3;
        f49749d = new ValidateStatus[]{validateStatus, validateStatus2, validateStatus3};
    }

    public static ValidateStatus valueOf(String str) {
        return (ValidateStatus) Enum.valueOf(ValidateStatus.class, str);
    }

    public static ValidateStatus[] values() {
        return (ValidateStatus[]) f49749d.clone();
    }
}
