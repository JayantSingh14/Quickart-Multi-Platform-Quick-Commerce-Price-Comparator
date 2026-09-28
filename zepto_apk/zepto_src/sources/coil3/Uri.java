package coil3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class Uri {

    @Nullable
    private final String authority;

    @NotNull
    private final String data;

    @Nullable
    private final String fragment;

    @Nullable
    private final String path;

    @Nullable
    private final String query;

    @Nullable
    private final String scheme;

    @NotNull
    private final String separator;

    public Uri(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        this.data = str;
        this.separator = str2;
        this.scheme = str3;
        this.authority = str4;
        this.path = str5;
        this.query = str6;
        this.fragment = str7;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Uri) && Intrinsics.b(((Uri) obj).data, this.data);
    }

    @Nullable
    public final String getAuthority() {
        return this.authority;
    }

    @Nullable
    public final String getFragment() {
        return this.fragment;
    }

    @Nullable
    public final String getPath() {
        return this.path;
    }

    @Nullable
    public final String getQuery() {
        return this.query;
    }

    @Nullable
    public final String getScheme() {
        return this.scheme;
    }

    @NotNull
    public final String getSeparator() {
        return this.separator;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    @NotNull
    public String toString() {
        return this.data;
    }
}
