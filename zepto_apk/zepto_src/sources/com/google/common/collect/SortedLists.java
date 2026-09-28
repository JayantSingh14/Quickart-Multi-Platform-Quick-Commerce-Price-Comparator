package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.List;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class SortedLists {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class KeyAbsentBehavior {

        /* renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f43069a;

        /* renamed from: b, reason: collision with root package name */
        public static final AnonymousClass2 f43070b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ KeyAbsentBehavior[] f43071c;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.collect.SortedLists$KeyAbsentBehavior$1] */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.google.common.collect.SortedLists$KeyAbsentBehavior$2] */
        static {
            ?? r0 = new KeyAbsentBehavior() { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.1
                @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
                public final int a(int i2) {
                    return i2 - 1;
                }
            };
            f43069a = r0;
            ?? r1 = new KeyAbsentBehavior() { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.2
                @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
                public final int a(int i2) {
                    return i2;
                }
            };
            f43070b = r1;
            f43071c = new KeyAbsentBehavior[]{r0, r1, new KeyAbsentBehavior() { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.3
                @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
                public final int a(int i2) {
                    return ~i2;
                }
            }};
        }

        public static KeyAbsentBehavior valueOf(String str) {
            return (KeyAbsentBehavior) Enum.valueOf(KeyAbsentBehavior.class, str);
        }

        public static KeyAbsentBehavior[] values() {
            return (KeyAbsentBehavior[]) f43071c.clone();
        }

        public abstract int a(int i2);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class KeyPresentBehavior {

        /* renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f43072a;

        /* renamed from: b, reason: collision with root package name */
        public static final AnonymousClass2 f43073b;

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass3 f43074c;

        /* renamed from: d, reason: collision with root package name */
        public static final AnonymousClass4 f43075d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ KeyPresentBehavior[] f43076e;

        /* renamed from: com.google.common.collect.SortedLists$KeyPresentBehavior$2, reason: invalid class name */
        public enum AnonymousClass2 extends KeyPresentBehavior {
            public AnonymousClass2() {
                super("LAST_PRESENT", 1);
            }

            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public final int a(Comparable comparable, List list, int i2) {
                NaturalOrdering naturalOrdering = NaturalOrdering.f42971c;
                int size = list.size() - 1;
                while (i2 < size) {
                    int i3 = ((i2 + size) + 1) >>> 1;
                    if (naturalOrdering.compare(list.get(i3), comparable) > 0) {
                        size = i3 - 1;
                    } else {
                        i2 = i3;
                    }
                }
                return i2;
            }
        }

        /* renamed from: com.google.common.collect.SortedLists$KeyPresentBehavior$3, reason: invalid class name */
        public enum AnonymousClass3 extends KeyPresentBehavior {
            public AnonymousClass3() {
                super("FIRST_PRESENT", 2);
            }

            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public final int a(Comparable comparable, List list, int i2) {
                NaturalOrdering naturalOrdering = NaturalOrdering.f42971c;
                int i3 = 0;
                while (i3 < i2) {
                    int i4 = (i3 + i2) >>> 1;
                    if (naturalOrdering.compare(list.get(i4), comparable) < 0) {
                        i3 = i4 + 1;
                    } else {
                        i2 = i4;
                    }
                }
                return i3;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.collect.SortedLists$KeyPresentBehavior$1] */
        /* JADX WARN: Type inference failed for: r3v0, types: [com.google.common.collect.SortedLists$KeyPresentBehavior$4] */
        static {
            ?? r0 = new KeyPresentBehavior() { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.1
                @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
                public final int a(Comparable comparable, List list, int i2) {
                    return i2;
                }
            };
            f43072a = r0;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2();
            f43073b = anonymousClass2;
            AnonymousClass3 anonymousClass3 = new AnonymousClass3();
            f43074c = anonymousClass3;
            ?? r3 = new KeyPresentBehavior() { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.4
                @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
                public final int a(Comparable comparable, List list, int i2) {
                    return KeyPresentBehavior.f43073b.a(comparable, list, i2) + 1;
                }
            };
            f43075d = r3;
            f43076e = new KeyPresentBehavior[]{r0, anonymousClass2, anonymousClass3, r3, new KeyPresentBehavior() { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.5
                @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
                public final int a(Comparable comparable, List list, int i2) {
                    return KeyPresentBehavior.f43074c.a(comparable, list, i2) - 1;
                }
            }};
        }

        public static KeyPresentBehavior valueOf(String str) {
            return (KeyPresentBehavior) Enum.valueOf(KeyPresentBehavior.class, str);
        }

        public static KeyPresentBehavior[] values() {
            return (KeyPresentBehavior[]) f43076e.clone();
        }

        public abstract int a(Comparable comparable, List list, int i2);
    }
}
