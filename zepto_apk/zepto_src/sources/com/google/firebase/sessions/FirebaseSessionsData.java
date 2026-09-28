package com.google.firebase.sessions;

import androidx.fragment.app.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class FirebaseSessionsData {

    /* renamed from: a, reason: collision with root package name */
    public final String f45007a;

    public FirebaseSessionsData(String str) {
        this.f45007a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FirebaseSessionsData) && Intrinsics.b(this.f45007a, ((FirebaseSessionsData) obj).f45007a);
    }

    public final int hashCode() {
        String str = this.f45007a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        return e.t(new StringBuilder("FirebaseSessionsData(sessionId="), this.f45007a, ')');
    }
}
