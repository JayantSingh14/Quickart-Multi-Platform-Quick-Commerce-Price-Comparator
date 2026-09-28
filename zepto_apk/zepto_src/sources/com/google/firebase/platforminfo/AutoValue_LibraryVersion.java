package com.google.firebase.platforminfo;

/* loaded from: classes.dex */
final class AutoValue_LibraryVersion extends LibraryVersion {

    /* renamed from: a, reason: collision with root package name */
    public final String f44901a;

    /* renamed from: b, reason: collision with root package name */
    public final String f44902b;

    public AutoValue_LibraryVersion(String str, String str2) {
        this.f44901a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.f44902b = str2;
    }

    @Override // com.google.firebase.platforminfo.LibraryVersion
    public final String a() {
        return this.f44901a;
    }

    @Override // com.google.firebase.platforminfo.LibraryVersion
    public final String b() {
        return this.f44902b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LibraryVersion)) {
            return false;
        }
        LibraryVersion libraryVersion = (LibraryVersion) obj;
        return this.f44901a.equals(libraryVersion.a()) && this.f44902b.equals(libraryVersion.b());
    }

    public final int hashCode() {
        return ((this.f44901a.hashCode() ^ 1000003) * 1000003) ^ this.f44902b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LibraryVersion{libraryName=");
        sb.append(this.f44901a);
        sb.append(", version=");
        return android.support.v4.media.b.r(sb, this.f44902b, "}");
    }
}
