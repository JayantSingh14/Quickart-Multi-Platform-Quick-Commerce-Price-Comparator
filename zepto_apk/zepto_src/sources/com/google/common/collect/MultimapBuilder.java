package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import com.google.common.collect.Multimaps;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class MultimapBuilder<K0, V0> {

    /* renamed from: com.google.common.collect.MultimapBuilder$1, reason: invalid class name */
    class AnonymousClass1 extends MultimapBuilderWithKeys<Object> {
        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        public final Map b() {
            return new CompactHashMap(8);
        }
    }

    /* renamed from: com.google.common.collect.MultimapBuilder$2, reason: invalid class name */
    class AnonymousClass2 extends MultimapBuilderWithKeys<Object> {
        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        public final Map b() {
            return new CompactLinkedHashMap(0);
        }
    }

    /* renamed from: com.google.common.collect.MultimapBuilder$4, reason: invalid class name */
    class AnonymousClass4 extends MultimapBuilderWithKeys<Enum<Object>> {
        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        public final Map b() {
            return new EnumMap((Class) null);
        }
    }

    public static final class ArrayListSupplier<V> implements Supplier<List<V>>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final int f42945a;

        public ArrayListSupplier() {
            CollectPreconditions.b(2, "expectedValuesPerKey");
            this.f42945a = 2;
        }

        @Override // com.google.common.base.Supplier
        public final Object get() {
            return new ArrayList(this.f42945a);
        }
    }

    public static final class EnumSetSupplier<V extends Enum<V>> implements Supplier<Set<V>>, Serializable {
        @Override // com.google.common.base.Supplier
        public final Object get() {
            return EnumSet.noneOf(null);
        }
    }

    public static final class HashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
        @Override // com.google.common.base.Supplier
        public final Object get() {
            return new CompactHashSet(0);
        }
    }

    public static final class LinkedHashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
        @Override // com.google.common.base.Supplier
        public final Object get() {
            return new CompactLinkedHashSet(0);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class LinkedListSupplier implements Supplier<List<?>> {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LinkedListSupplier[] f42946a = {new LinkedListSupplier("INSTANCE", 0)};

        /* JADX INFO: Fake field, exist only in values array */
        LinkedListSupplier EF5;

        public static LinkedListSupplier valueOf(String str) {
            return (LinkedListSupplier) Enum.valueOf(LinkedListSupplier.class, str);
        }

        public static LinkedListSupplier[] values() {
            return (LinkedListSupplier[]) f42946a.clone();
        }

        @Override // com.google.common.base.Supplier
        public final Object get() {
            return new LinkedList();
        }
    }

    public static abstract class ListMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        public abstract ListMultimap c();
    }

    public static abstract class MultimapBuilderWithKeys<K0> {

        /* renamed from: com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$2, reason: invalid class name */
        class AnonymousClass2 extends ListMultimapBuilder<Object, Object> {
            @Override // com.google.common.collect.MultimapBuilder.ListMultimapBuilder
            public final ListMultimap c() {
                throw null;
            }
        }

        /* renamed from: com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$3, reason: invalid class name */
        class AnonymousClass3 extends SetMultimapBuilder<Object, Object> {
        }

        /* renamed from: com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$4, reason: invalid class name */
        class AnonymousClass4 extends SetMultimapBuilder<Object, Object> {
        }

        /* renamed from: com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$5, reason: invalid class name */
        class AnonymousClass5 extends SortedSetMultimapBuilder<Object, Object> {
        }

        /* renamed from: com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$6, reason: invalid class name */
        class AnonymousClass6 extends SetMultimapBuilder<Object, Enum<Object>> {
        }

        public final ListMultimapBuilder a() {
            CollectPreconditions.b(2, "expectedValuesPerKey");
            return new ListMultimapBuilder<Object, Object>() { // from class: com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.1
                @Override // com.google.common.collect.MultimapBuilder.ListMultimapBuilder
                public final ListMultimap c() {
                    Map mapB = MultimapBuilderWithKeys.this.b();
                    ArrayListSupplier arrayListSupplier = new ArrayListSupplier();
                    Multimaps.CustomListMultimap customListMultimap = new Multimaps.CustomListMultimap(mapB);
                    customListMultimap.f42950g = arrayListSupplier;
                    return customListMultimap;
                }
            };
        }

        public abstract Map b();
    }

    public static abstract class SetMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
    }

    public static abstract class SortedSetMultimapBuilder<K0, V0> extends SetMultimapBuilder<K0, V0> {
    }

    public static final class TreeSetSupplier<V> implements Supplier<SortedSet<V>>, Serializable {
        @Override // com.google.common.base.Supplier
        public final Object get() {
            return new TreeSet((Comparator) null);
        }
    }

    public static MultimapBuilderWithKeys a() {
        CollectPreconditions.b(8, "expectedKeys");
        return new AnonymousClass1();
    }

    public static MultimapBuilderWithKeys b() {
        return new MultimapBuilderWithKeys<Object>() { // from class: com.google.common.collect.MultimapBuilder.3

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Comparator f42944a = NaturalOrdering.f42971c;

            @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
            public final Map b() {
                return new TreeMap(this.f42944a);
            }
        };
    }
}
