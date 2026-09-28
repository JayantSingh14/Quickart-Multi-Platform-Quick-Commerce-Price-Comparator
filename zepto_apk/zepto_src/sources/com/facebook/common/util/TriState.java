package com.facebook.common.util;

import com.facebook.infer.annotation.Nullsafe;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Nullsafe
/* loaded from: classes3.dex */
public final class TriState {

    /* renamed from: a, reason: collision with root package name */
    public static final TriState f17143a;

    /* renamed from: b, reason: collision with root package name */
    public static final TriState f17144b;

    /* renamed from: c, reason: collision with root package name */
    public static final TriState f17145c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ TriState[] f17146d;

    /* renamed from: com.facebook.common.util.TriState$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17147a;

        static {
            int[] iArr = new int[TriState.values().length];
            f17147a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17147a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17147a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        TriState triState = new TriState("YES", 0);
        f17143a = triState;
        TriState triState2 = new TriState("NO", 1);
        f17144b = triState2;
        TriState triState3 = new TriState("UNSET", 2);
        f17145c = triState3;
        f17146d = new TriState[]{triState, triState2, triState3};
    }

    public static TriState valueOf(String str) {
        return (TriState) Enum.valueOf(TriState.class, str);
    }

    public static TriState[] values() {
        return (TriState[]) f17146d.clone();
    }
}
