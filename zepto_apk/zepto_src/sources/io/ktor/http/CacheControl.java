package io.ktor.http;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata
/* loaded from: classes3.dex */
public abstract class CacheControl {

    @Metadata
    public static final class MaxAge extends CacheControl {
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MaxAge)) {
                return false;
            }
            MaxAge maxAge = (MaxAge) obj;
            maxAge.getClass();
            maxAge.getClass();
            maxAge.getClass();
            maxAge.getClass();
            maxAge.getClass();
            return true;
        }

        public final int hashCode() {
            return (Boolean.hashCode(false) + (Boolean.hashCode(false) * 31)) * 31;
        }

        public final String toString() {
            ArrayList arrayList = new ArrayList(5);
            arrayList.add("max-age=0");
            return CollectionsKt.E(arrayList, ", ", null, null, null, 62);
        }
    }

    @Metadata
    public static final class NoCache extends CacheControl {
        public final boolean equals(Object obj) {
            if (!(obj instanceof NoCache)) {
                return false;
            }
            ((NoCache) obj).getClass();
            return true;
        }

        public final int hashCode() {
            return 0;
        }

        public final String toString() {
            return "no-cache";
        }
    }

    @Metadata
    public static final class NoStore extends CacheControl {
        public final boolean equals(Object obj) {
            if (!(obj instanceof NoStore)) {
                return false;
            }
            ((NoStore) obj).getClass();
            return true;
        }

        public final int hashCode() {
            return 0;
        }

        public final String toString() {
            return "no-store";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class Visibility {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Visibility[] f50115a = {new Visibility("Public", 0), new Visibility("Private", 1)};

        /* JADX INFO: Fake field, exist only in values array */
        Visibility EF5;

        public static Visibility valueOf(String str) {
            return (Visibility) Enum.valueOf(Visibility.class, str);
        }

        public static Visibility[] values() {
            return (Visibility[]) f50115a.clone();
        }
    }
}
