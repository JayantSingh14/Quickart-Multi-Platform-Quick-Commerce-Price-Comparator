package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import android.support.v4.media.b;
import com.google.android.datatransport.runtime.time.Clock;

/* loaded from: classes3.dex */
final class AutoValue_CreationContext extends CreationContext {

    /* renamed from: a, reason: collision with root package name */
    public final Context f20775a;

    /* renamed from: b, reason: collision with root package name */
    public final Clock f20776b;

    /* renamed from: c, reason: collision with root package name */
    public final Clock f20777c;

    /* renamed from: d, reason: collision with root package name */
    public final String f20778d;

    public AutoValue_CreationContext(Context context, Clock clock, Clock clock2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f20775a = context;
        if (clock == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f20776b = clock;
        if (clock2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f20777c = clock2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f20778d = str;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public final Context b() {
        return this.f20775a;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public final String c() {
        return this.f20778d;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public final Clock d() {
        return this.f20777c;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public final Clock e() {
        return this.f20776b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreationContext)) {
            return false;
        }
        CreationContext creationContext = (CreationContext) obj;
        return this.f20775a.equals(creationContext.b()) && this.f20776b.equals(creationContext.e()) && this.f20777c.equals(creationContext.d()) && this.f20778d.equals(creationContext.c());
    }

    public final int hashCode() {
        return ((((((this.f20775a.hashCode() ^ 1000003) * 1000003) ^ this.f20776b.hashCode()) * 1000003) ^ this.f20777c.hashCode()) * 1000003) ^ this.f20778d.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CreationContext{applicationContext=");
        sb.append(this.f20775a);
        sb.append(", wallClock=");
        sb.append(this.f20776b);
        sb.append(", monotonicClock=");
        sb.append(this.f20777c);
        sb.append(", backendName=");
        return b.r(sb, this.f20778d, "}");
    }
}
