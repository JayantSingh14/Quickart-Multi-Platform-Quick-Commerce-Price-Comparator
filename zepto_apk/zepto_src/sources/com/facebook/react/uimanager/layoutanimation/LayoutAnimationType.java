package com.facebook.react.uimanager.layoutanimation;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class LayoutAnimationType {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f19813a;

    /* renamed from: b, reason: collision with root package name */
    public static final LayoutAnimationType f19814b;

    /* renamed from: c, reason: collision with root package name */
    public static final LayoutAnimationType f19815c;

    /* renamed from: d, reason: collision with root package name */
    public static final LayoutAnimationType f19816d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ LayoutAnimationType[] f19817e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f19818f;

    @Metadata
    public static final class Companion {

        @Metadata
        public /* synthetic */ class WhenMappings {
            static {
                int[] iArr = new int[LayoutAnimationType.values().length];
                try {
                    iArr[0] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    Companion companion = LayoutAnimationType.f19813a;
                    iArr[1] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    Companion companion2 = LayoutAnimationType.f19813a;
                    iArr[2] = 3;
                } catch (NoSuchFieldError unused3) {
                }
            }
        }
    }

    static {
        LayoutAnimationType layoutAnimationType = new LayoutAnimationType("CREATE", 0);
        f19814b = layoutAnimationType;
        LayoutAnimationType layoutAnimationType2 = new LayoutAnimationType("UPDATE", 1);
        f19815c = layoutAnimationType2;
        LayoutAnimationType layoutAnimationType3 = new LayoutAnimationType("DELETE", 2);
        f19816d = layoutAnimationType3;
        LayoutAnimationType[] layoutAnimationTypeArr = {layoutAnimationType, layoutAnimationType2, layoutAnimationType3};
        f19817e = layoutAnimationTypeArr;
        f19818f = EnumEntriesKt.a(layoutAnimationTypeArr);
        f19813a = new Companion();
    }

    public static final String a(LayoutAnimationType type) {
        f19813a.getClass();
        Intrinsics.checkNotNullParameter(type, "type");
        int iOrdinal = type.ordinal();
        if (iOrdinal == 0) {
            return CLConstants.CRED_SUB_TYPE_MANDATE_CREATE;
        }
        if (iOrdinal == 1) {
            return "update";
        }
        if (iOrdinal == 2) {
            return "delete";
        }
        throw new NoWhenBranchMatchedException();
    }

    public static LayoutAnimationType valueOf(String str) {
        return (LayoutAnimationType) Enum.valueOf(LayoutAnimationType.class, str);
    }

    public static LayoutAnimationType[] values() {
        return (LayoutAnimationType[]) f19817e.clone();
    }
}
