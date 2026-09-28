package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
public abstract class RemovalCause {

    /* renamed from: a, reason: collision with root package name */
    public static final RemovalCause f42436a;

    /* renamed from: b, reason: collision with root package name */
    public static final RemovalCause f42437b;

    /* renamed from: c, reason: collision with root package name */
    public static final RemovalCause f42438c;

    /* renamed from: d, reason: collision with root package name */
    public static final RemovalCause f42439d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ RemovalCause[] f42440e;

    static {
        RemovalCause removalCause = new RemovalCause() { // from class: com.google.common.cache.RemovalCause.1
            @Override // com.google.common.cache.RemovalCause
            public final boolean a() {
                return false;
            }
        };
        f42436a = removalCause;
        RemovalCause removalCause2 = new RemovalCause() { // from class: com.google.common.cache.RemovalCause.2
            @Override // com.google.common.cache.RemovalCause
            public final boolean a() {
                return false;
            }
        };
        f42437b = removalCause2;
        RemovalCause removalCause3 = new RemovalCause() { // from class: com.google.common.cache.RemovalCause.3
            @Override // com.google.common.cache.RemovalCause
            public final boolean a() {
                return true;
            }
        };
        f42438c = removalCause3;
        RemovalCause removalCause4 = new RemovalCause() { // from class: com.google.common.cache.RemovalCause.4
            @Override // com.google.common.cache.RemovalCause
            public final boolean a() {
                return true;
            }
        };
        RemovalCause removalCause5 = new RemovalCause() { // from class: com.google.common.cache.RemovalCause.5
            @Override // com.google.common.cache.RemovalCause
            public final boolean a() {
                return true;
            }
        };
        f42439d = removalCause5;
        f42440e = new RemovalCause[]{removalCause, removalCause2, removalCause3, removalCause4, removalCause5};
    }

    public static RemovalCause valueOf(String str) {
        return (RemovalCause) Enum.valueOf(RemovalCause.class, str);
    }

    public static RemovalCause[] values() {
        return (RemovalCause[]) f42440e.clone();
    }

    public abstract boolean a();
}
