package com.facebook.react.bridge;

import androidx.annotation.GuardedBy;

/* loaded from: classes.dex */
public class JavaScriptContextHolder {

    @GuardedBy
    private long mContext;

    public JavaScriptContextHolder(long j2) {
        this.mContext = j2;
    }

    public synchronized void clear() {
        this.mContext = 0L;
    }

    @GuardedBy
    public long get() {
        return this.mContext;
    }
}
