package com.facebook.common.memory;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes.dex */
public class NoOpMemoryTrimmableRegistry implements MemoryTrimmableRegistry {

    /* renamed from: a, reason: collision with root package name */
    public static NoOpMemoryTrimmableRegistry f17095a;

    public static synchronized NoOpMemoryTrimmableRegistry a() {
        try {
            if (f17095a == null) {
                f17095a = new NoOpMemoryTrimmableRegistry();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f17095a;
    }
}
