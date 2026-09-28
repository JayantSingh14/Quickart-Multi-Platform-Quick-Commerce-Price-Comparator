package coil3.network;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class NetworkHeaders {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    @NotNull
    public static final NetworkHeaders EMPTY = new Builder().build();

    @NotNull
    private final Map<String, List<String>> data;

    @Metadata
    @SourceDebugExtension
    public static final class Builder {

        @NotNull
        private final Map<String, List<String>> data;

        public Builder() {
            this.data = new LinkedHashMap();
        }

        @NotNull
        public final Builder add(@NotNull String str, @NotNull String str2) {
            Map<String, List<String>> map = this.data;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            List<String> arrayList = map.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                map.put(lowerCase, arrayList);
            }
            arrayList.add(str2);
            return this;
        }

        @NotNull
        public final NetworkHeaders build() {
            return new NetworkHeaders(MapsKt.l(this.data), null);
        }

        @NotNull
        public final Builder set(@NotNull String str, @NotNull String str2) {
            Map<String, List<String>> map = this.data;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            map.put(lowerCase, CollectionsKt.J(str2));
            return this;
        }

        @NotNull
        public final Builder set(@NotNull String str, @NotNull List<String> list) {
            Map<String, List<String>> map = this.data;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            map.put(lowerCase, CollectionsKt.f0(list));
            return this;
        }

        public Builder(@NotNull NetworkHeaders networkHeaders) {
            Map map = networkHeaders.data;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), CollectionsKt.f0((Collection) entry.getValue()));
            }
            this.data = linkedHashMap;
        }
    }

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ NetworkHeaders(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(map);
    }

    @NotNull
    public final Map<String, List<String>> asMap() {
        return this.data;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NetworkHeaders) && Intrinsics.b(this.data, ((NetworkHeaders) obj).data);
    }

    @Nullable
    public final String get(@NotNull String str) {
        Map<String, List<String>> map = this.data;
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        List<String> list = map.get(lowerCase);
        if (list != null) {
            return (String) CollectionsKt.G(list);
        }
        return null;
    }

    @NotNull
    public final List<String> getAll(@NotNull String str) {
        Map<String, List<String>> map = this.data;
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        List<String> list = map.get(lowerCase);
        return list == null ? EmptyList.f53609a : list;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    @NotNull
    public final Builder newBuilder() {
        return new Builder(this);
    }

    @NotNull
    public String toString() {
        return "NetworkHeaders(data=" + this.data + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    private NetworkHeaders(Map<String, ? extends List<String>> map) {
        this.data = map;
    }
}
