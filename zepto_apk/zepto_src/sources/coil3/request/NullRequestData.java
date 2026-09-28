package coil3.request;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class NullRequestData {

    @NotNull
    public static final NullRequestData INSTANCE = new NullRequestData();

    private NullRequestData() {
    }

    public boolean equals(@Nullable Object obj) {
        return this == obj || (obj instanceof NullRequestData);
    }

    public int hashCode() {
        return 2113961193;
    }

    @NotNull
    public String toString() {
        return "NullRequestData";
    }
}
