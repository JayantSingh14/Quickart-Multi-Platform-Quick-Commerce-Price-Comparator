package com.truecaller.android.sdk.common.callVerification;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class RequestPermissionHandler {

    @Metadata
    public interface Listener {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class Status {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f47211a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f47212b;

        static {
            Status[] statusArr = {new Status("GRANTED", 0), new Status("UN_GRANTED", 1), new Status("TEMPORARY_DENIED", 2), new Status("PERMANENT_DENIED", 3)};
            f47211a = statusArr;
            f47212b = EnumEntriesKt.a(statusArr);
        }

        public static Status valueOf(String str) {
            return (Status) Enum.valueOf(Status.class, str);
        }

        public static Status[] values() {
            return (Status[]) f47211a.clone();
        }
    }

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[Status.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Status[] statusArr = Status.f47211a;
                iArr[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Status[] statusArr2 = Status.f47211a;
                iArr[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Status[] statusArr3 = Status.f47211a;
                iArr[1] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
