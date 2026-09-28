package com.zeptoconsumerapp.slotmachine;

import kotlin.Metadata;

@Metadata
/* loaded from: classes4.dex */
public final class Datum {

    /* renamed from: a, reason: collision with root package name */
    public char f47814a;

    /* renamed from: b, reason: collision with root package name */
    public final char f47815b;

    public Datum(char c2, char c3) {
        this.f47814a = c2;
        this.f47815b = c3;
    }

    public final char a() {
        return this.f47815b;
    }

    public final char b() {
        return this.f47814a;
    }

    public final void c() {
        this.f47814a = '0';
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Datum)) {
            return false;
        }
        Datum datum = (Datum) obj;
        return this.f47814a == datum.f47814a && this.f47815b == datum.f47815b;
    }

    public final int hashCode() {
        return Character.hashCode(this.f47815b) + (Character.hashCode(this.f47814a) * 31);
    }

    public final String toString() {
        return "Datum(prevChar=" + this.f47814a + ", newChar=" + this.f47815b + ")";
    }
}
