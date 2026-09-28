package com.google.android.datatransport;

import android.support.v4.media.b;

/* loaded from: classes.dex */
public final class Encoding {

    /* renamed from: a, reason: collision with root package name */
    public final String f20513a;

    public Encoding(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f20513a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Encoding)) {
            return false;
        }
        return this.f20513a.equals(((Encoding) obj).f20513a);
    }

    public final int hashCode() {
        return this.f20513a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return b.r(new StringBuilder("Encoding{name=\""), this.f20513a, "\"}");
    }
}
