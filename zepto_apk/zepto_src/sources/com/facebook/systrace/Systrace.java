package com.facebook.systrace;

import androidx.tracing.Trace;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class Systrace {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    /* loaded from: classes3.dex */
    public static final class EventScope {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventScope[] f20324a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f20325b;

        static {
            EventScope[] eventScopeArr = {new EventScope("THREAD", 0), new EventScope("PROCESS", 1), new EventScope("GLOBAL", 2)};
            f20324a = eventScopeArr;
            f20325b = EnumEntriesKt.a(eventScopeArr);
        }

        public static EventScope valueOf(String str) {
            return (EventScope) Enum.valueOf(EventScope.class, str);
        }

        public static EventScope[] values() {
            return (EventScope[]) f20324a.clone();
        }
    }

    public static final void a(String sectionName) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        Trace.b(sectionName);
    }
}
