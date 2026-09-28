package androidx.recyclerview.widget;

/* loaded from: classes3.dex */
interface StableIdStorage {

    public static class IsolatedStableIdStorage implements StableIdStorage {

        public class WrapperStableIdLookup implements StableIdLookup {
        }
    }

    public static class NoStableIdStorage implements StableIdStorage {

        /* renamed from: androidx.recyclerview.widget.StableIdStorage$NoStableIdStorage$1, reason: invalid class name */
        public class AnonymousClass1 implements StableIdLookup {
        }
    }

    public static class SharedPoolStableIdStorage implements StableIdStorage {

        /* renamed from: androidx.recyclerview.widget.StableIdStorage$SharedPoolStableIdStorage$1, reason: invalid class name */
        public class AnonymousClass1 implements StableIdLookup {
        }
    }

    public interface StableIdLookup {
    }
}
