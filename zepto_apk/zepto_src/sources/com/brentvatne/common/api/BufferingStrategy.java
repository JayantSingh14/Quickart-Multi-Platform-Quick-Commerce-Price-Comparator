package com.brentvatne.common.api;

import com.brentvatne.common.toolbox.DebugLog;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata
/* loaded from: classes3.dex */
public final class BufferingStrategy {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class BufferingStrategyEnum {

        /* renamed from: a, reason: collision with root package name */
        public static final BufferingStrategyEnum f15358a;

        /* renamed from: b, reason: collision with root package name */
        public static final BufferingStrategyEnum f15359b;

        /* renamed from: c, reason: collision with root package name */
        public static final BufferingStrategyEnum f15360c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ BufferingStrategyEnum[] f15361d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f15362e;

        static {
            BufferingStrategyEnum bufferingStrategyEnum = new BufferingStrategyEnum("Default", 0);
            f15358a = bufferingStrategyEnum;
            BufferingStrategyEnum bufferingStrategyEnum2 = new BufferingStrategyEnum("DisableBuffering", 1);
            f15359b = bufferingStrategyEnum2;
            BufferingStrategyEnum bufferingStrategyEnum3 = new BufferingStrategyEnum("DependingOnMemory", 2);
            f15360c = bufferingStrategyEnum3;
            BufferingStrategyEnum[] bufferingStrategyEnumArr = {bufferingStrategyEnum, bufferingStrategyEnum2, bufferingStrategyEnum3};
            f15361d = bufferingStrategyEnumArr;
            f15362e = EnumEntriesKt.a(bufferingStrategyEnumArr);
        }

        public static BufferingStrategyEnum valueOf(String str) {
            return (BufferingStrategyEnum) Enum.valueOf(BufferingStrategyEnum.class, str);
        }

        public static BufferingStrategyEnum[] values() {
            return (BufferingStrategyEnum[]) f15361d.clone();
        }
    }

    @Metadata
    public static final class Companion {
        public static BufferingStrategyEnum a(String str) {
            if (str == null) {
                return BufferingStrategyEnum.f15358a;
            }
            try {
                return BufferingStrategyEnum.valueOf(str);
            } catch (Exception unused) {
                DebugLog.b("BufferingStrategy", "cannot parse buffering strategy ".concat(str));
                return BufferingStrategyEnum.f15358a;
            }
        }
    }
}
