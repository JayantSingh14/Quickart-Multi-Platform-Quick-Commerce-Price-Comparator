package com.facebook.cache.common;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes.dex */
public interface CacheEventListener {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes3.dex */
    public static final class EvictionReason {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EvictionReason[] f16989a = {new EvictionReason("CACHE_FULL", 0), new EvictionReason("CONTENT_STALE", 1), new EvictionReason("USER_FORCED", 2), new EvictionReason("CACHE_MANAGER_TRIMMED", 3), new EvictionReason("TRIM_EXPIRED", 4)};

        /* JADX INFO: Fake field, exist only in values array */
        EvictionReason EF5;

        public static EvictionReason valueOf(String str) {
            return (EvictionReason) Enum.valueOf(EvictionReason.class, str);
        }

        public static EvictionReason[] values() {
            return (EvictionReason[]) f16989a.clone();
        }
    }
}
