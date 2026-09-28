package androidx.room;

import androidx.annotation.RestrictTo;
import com.google.android.gms.common.api.Api;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@RestrictTo
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class AmbiguousColumnResolver {

    @Metadata
    public static final class Match {
    }

    @Metadata
    public static final class ResultColumn {
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResultColumn)) {
                return false;
            }
            ((ResultColumn) obj).getClass();
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "ResultColumn(name=null, index=0)";
        }
    }

    @Metadata
    public static final class Solution implements Comparable<Solution> {

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int f11720d = 0;

        /* renamed from: a, reason: collision with root package name */
        public final List f11721a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11722b;

        /* renamed from: c, reason: collision with root package name */
        public final int f11723c;

        @Metadata
        @SourceDebugExtension
        public static final class Companion {
        }

        static {
            new Solution(Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER, EmptyList.f53609a);
        }

        public Solution(int i2, int i3, List matches) {
            Intrinsics.checkNotNullParameter(matches, "matches");
            this.f11721a = matches;
            this.f11722b = i2;
            this.f11723c = i3;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Solution solution) {
            Solution other = solution;
            Intrinsics.checkNotNullParameter(other, "other");
            int iE = Intrinsics.e(this.f11723c, other.f11723c);
            return iE != 0 ? iE : Intrinsics.e(this.f11722b, other.f11722b);
        }
    }
}
