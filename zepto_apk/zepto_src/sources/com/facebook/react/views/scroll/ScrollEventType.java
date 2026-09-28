package com.facebook.react.views.scroll;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class ScrollEventType {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f20083a;

    /* renamed from: b, reason: collision with root package name */
    public static final ScrollEventType f20084b;

    /* renamed from: c, reason: collision with root package name */
    public static final ScrollEventType f20085c;

    /* renamed from: d, reason: collision with root package name */
    public static final ScrollEventType f20086d;

    /* renamed from: e, reason: collision with root package name */
    public static final ScrollEventType f20087e;

    /* renamed from: f, reason: collision with root package name */
    public static final ScrollEventType f20088f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ ScrollEventType[] f20089g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f20090h;

    @Metadata
    public static final class Companion {

        @Metadata
        public /* synthetic */ class WhenMappings {
            static {
                int[] iArr = new int[ScrollEventType.values().length];
                try {
                    iArr[0] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    Companion companion = ScrollEventType.f20083a;
                    iArr[1] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    Companion companion2 = ScrollEventType.f20083a;
                    iArr[2] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    Companion companion3 = ScrollEventType.f20083a;
                    iArr[3] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    Companion companion4 = ScrollEventType.f20083a;
                    iArr[4] = 5;
                } catch (NoSuchFieldError unused5) {
                }
            }
        }

        public static String a(ScrollEventType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            int iOrdinal = type.ordinal();
            if (iOrdinal == 0) {
                return "topScrollBeginDrag";
            }
            if (iOrdinal == 1) {
                return "topScrollEndDrag";
            }
            if (iOrdinal == 2) {
                return "topScroll";
            }
            if (iOrdinal == 3) {
                return "topMomentumScrollBegin";
            }
            if (iOrdinal == 4) {
                return "topMomentumScrollEnd";
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
        ScrollEventType scrollEventType = new ScrollEventType("BEGIN_DRAG", 0);
        f20084b = scrollEventType;
        ScrollEventType scrollEventType2 = new ScrollEventType("END_DRAG", 1);
        f20085c = scrollEventType2;
        ScrollEventType scrollEventType3 = new ScrollEventType("SCROLL", 2);
        f20086d = scrollEventType3;
        ScrollEventType scrollEventType4 = new ScrollEventType("MOMENTUM_BEGIN", 3);
        f20087e = scrollEventType4;
        ScrollEventType scrollEventType5 = new ScrollEventType("MOMENTUM_END", 4);
        f20088f = scrollEventType5;
        ScrollEventType[] scrollEventTypeArr = {scrollEventType, scrollEventType2, scrollEventType3, scrollEventType4, scrollEventType5};
        f20089g = scrollEventTypeArr;
        f20090h = EnumEntriesKt.a(scrollEventTypeArr);
        f20083a = new Companion();
    }

    public static ScrollEventType valueOf(String str) {
        return (ScrollEventType) Enum.valueOf(ScrollEventType.class, str);
    }

    public static ScrollEventType[] values() {
        return (ScrollEventType[]) f20089g.clone();
    }
}
