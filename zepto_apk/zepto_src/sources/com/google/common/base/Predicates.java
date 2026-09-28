package com.google.common.base;

import android.support.v4.media.b;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class Predicates {

    public static class AndPredicate<T> implements Predicate<T>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final List f42285a;

        public AndPredicate(List list) {
            this.f42285a = list;
        }

        @Override // com.google.common.base.Predicate
        public final boolean apply(Object obj) {
            int i2 = 0;
            while (true) {
                List list = this.f42285a;
                if (i2 >= list.size()) {
                    return true;
                }
                if (!((Predicate) list.get(i2)).apply(obj)) {
                    return false;
                }
                i2++;
            }
        }

        @Override // com.google.common.base.Predicate
        public final boolean equals(Object obj) {
            if (obj instanceof AndPredicate) {
                return this.f42285a.equals(((AndPredicate) obj).f42285a);
            }
            return false;
        }

        public final int hashCode() {
            return this.f42285a.hashCode() + 306654252;
        }

        public final String toString() {
            return Predicates.a(this.f42285a, "and");
        }
    }

    public static class CompositionPredicate<A, B> implements Predicate<A>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Object f42286a;

        /* renamed from: b, reason: collision with root package name */
        public final Function f42287b;

        public CompositionPredicate(Predicate predicate, Function function) {
            predicate.getClass();
            this.f42286a = predicate;
            this.f42287b = function;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.google.common.base.Predicate, java.lang.Object] */
        @Override // com.google.common.base.Predicate
        public final boolean apply(Object obj) {
            return this.f42286a.apply(this.f42287b.apply(obj));
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [com.google.common.base.Predicate, java.lang.Object] */
        @Override // com.google.common.base.Predicate
        public final boolean equals(Object obj) {
            if (!(obj instanceof CompositionPredicate)) {
                return false;
            }
            CompositionPredicate compositionPredicate = (CompositionPredicate) obj;
            return this.f42287b.equals(compositionPredicate.f42287b) && this.f42286a.equals(compositionPredicate.f42286a);
        }

        public final int hashCode() {
            return this.f42287b.hashCode() ^ this.f42286a.hashCode();
        }

        public final String toString() {
            return this.f42286a + "(" + this.f42287b + ")";
        }
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static class ContainsPatternFromStringPredicate extends ContainsPatternPredicate {
        @Override // com.google.common.base.Predicates.ContainsPatternPredicate
        public final String toString() {
            throw null;
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static class ContainsPatternPredicate implements Predicate<CharSequence>, Serializable {
        @Override // com.google.common.base.Predicate
        public final boolean apply(Object obj) {
            throw null;
        }

        @Override // com.google.common.base.Predicate
        public final boolean equals(Object obj) {
            if (obj instanceof ContainsPatternPredicate) {
                throw null;
            }
            return false;
        }

        public final int hashCode() {
            throw null;
        }

        public String toString() {
            MoreObjects.b(null);
            throw null;
        }
    }

    public static class InPredicate<T> implements Predicate<T>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Collection f42288a;

        public InPredicate(Collection collection) {
            collection.getClass();
            this.f42288a = collection;
        }

        @Override // com.google.common.base.Predicate
        public final boolean apply(Object obj) {
            try {
                return this.f42288a.contains(obj);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // com.google.common.base.Predicate
        public final boolean equals(Object obj) {
            if (obj instanceof InPredicate) {
                return this.f42288a.equals(((InPredicate) obj).f42288a);
            }
            return false;
        }

        public final int hashCode() {
            return this.f42288a.hashCode();
        }

        public final String toString() {
            return "Predicates.in(" + this.f42288a + ")";
        }
    }

    @GwtIncompatible
    public static class InstanceOfPredicate<T> implements Predicate<T>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Class f42289a;

        public InstanceOfPredicate(Class cls) {
            cls.getClass();
            this.f42289a = cls;
        }

        @Override // com.google.common.base.Predicate
        public final boolean apply(Object obj) {
            return this.f42289a.isInstance(obj);
        }

        @Override // com.google.common.base.Predicate
        public final boolean equals(Object obj) {
            return (obj instanceof InstanceOfPredicate) && this.f42289a == ((InstanceOfPredicate) obj).f42289a;
        }

        public final int hashCode() {
            return this.f42289a.hashCode();
        }

        public final String toString() {
            return "Predicates.instanceOf(" + this.f42289a.getName() + ")";
        }
    }

    public static class IsEqualToPredicate implements Predicate<Object>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Object f42290a;

        public IsEqualToPredicate(Object obj) {
            this.f42290a = obj;
        }

        @Override // com.google.common.base.Predicate
        public final boolean apply(Object obj) {
            return this.f42290a.equals(obj);
        }

        @Override // com.google.common.base.Predicate
        public final boolean equals(Object obj) {
            if (obj instanceof IsEqualToPredicate) {
                return this.f42290a.equals(((IsEqualToPredicate) obj).f42290a);
            }
            return false;
        }

        public final int hashCode() {
            return this.f42290a.hashCode();
        }

        public final String toString() {
            return b.q(new StringBuilder("Predicates.equalTo("), this.f42290a, ")");
        }
    }

    public static class NotPredicate<T> implements Predicate<T>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Object f42291a;

        public NotPredicate(Predicate predicate) {
            this.f42291a = predicate;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.base.Predicate, java.lang.Object] */
        @Override // com.google.common.base.Predicate
        public final boolean apply(Object obj) {
            return !this.f42291a.apply(obj);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.google.common.base.Predicate, java.lang.Object] */
        @Override // com.google.common.base.Predicate
        public final boolean equals(Object obj) {
            if (obj instanceof NotPredicate) {
                return this.f42291a.equals(((NotPredicate) obj).f42291a);
            }
            return false;
        }

        public final int hashCode() {
            return ~this.f42291a.hashCode();
        }

        public final String toString() {
            return b.q(new StringBuilder("Predicates.not("), this.f42291a, ")");
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class ObjectPredicate implements Predicate<Object> {

        /* renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f42292a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ ObjectPredicate[] f42293b;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.base.Predicates$ObjectPredicate$1] */
        static {
            ?? r0 = new ObjectPredicate() { // from class: com.google.common.base.Predicates.ObjectPredicate.1
                @Override // com.google.common.base.Predicate
                public final boolean apply(Object obj) {
                    return true;
                }

                @Override // java.lang.Enum
                public final String toString() {
                    return "Predicates.alwaysTrue()";
                }
            };
            f42292a = r0;
            f42293b = new ObjectPredicate[]{r0, new ObjectPredicate() { // from class: com.google.common.base.Predicates.ObjectPredicate.2
                @Override // com.google.common.base.Predicate
                public final boolean apply(Object obj) {
                    return false;
                }

                @Override // java.lang.Enum
                public final String toString() {
                    return "Predicates.alwaysFalse()";
                }
            }, new ObjectPredicate() { // from class: com.google.common.base.Predicates.ObjectPredicate.3
                @Override // com.google.common.base.Predicate
                public final boolean apply(Object obj) {
                    return obj == null;
                }

                @Override // java.lang.Enum
                public final String toString() {
                    return "Predicates.isNull()";
                }
            }, new ObjectPredicate() { // from class: com.google.common.base.Predicates.ObjectPredicate.4
                @Override // com.google.common.base.Predicate
                public final boolean apply(Object obj) {
                    return obj != null;
                }

                @Override // java.lang.Enum
                public final String toString() {
                    return "Predicates.notNull()";
                }
            }};
        }

        public static ObjectPredicate valueOf(String str) {
            return (ObjectPredicate) Enum.valueOf(ObjectPredicate.class, str);
        }

        public static ObjectPredicate[] values() {
            return (ObjectPredicate[]) f42293b.clone();
        }
    }

    public static class OrPredicate<T> implements Predicate<T>, Serializable {
        @Override // com.google.common.base.Predicate
        public final boolean apply(Object obj) {
            throw null;
        }

        @Override // com.google.common.base.Predicate
        public final boolean equals(Object obj) {
            if (!(obj instanceof OrPredicate)) {
                return false;
            }
            ((OrPredicate) obj).getClass();
            throw null;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return Predicates.a(null, "or");
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static class SubtypeOfPredicate implements Predicate<Class<?>>, Serializable {
        @Override // com.google.common.base.Predicate
        public final boolean apply(Object obj) {
            throw null;
        }

        @Override // com.google.common.base.Predicate
        public final boolean equals(Object obj) {
            if (!(obj instanceof SubtypeOfPredicate)) {
                return false;
            }
            ((SubtypeOfPredicate) obj).getClass();
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            throw null;
        }
    }

    public static String a(Iterable iterable, String str) {
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append(str);
        sb.append('(');
        boolean z = true;
        for (Object obj : iterable) {
            if (!z) {
                sb.append(',');
            }
            sb.append(obj);
            z = false;
        }
        sb.append(')');
        return sb.toString();
    }

    public static Predicate b() {
        return ObjectPredicate.f42292a;
    }

    public static Predicate c(Predicate predicate, Predicate predicate2) {
        predicate.getClass();
        predicate2.getClass();
        return new AndPredicate(Arrays.asList(predicate, predicate2));
    }

    public static Predicate d(Predicate predicate, Function function) {
        return new CompositionPredicate(predicate, function);
    }

    public static Predicate e(Object obj) {
        return new IsEqualToPredicate(obj);
    }

    public static Predicate f(Collection collection) {
        return new InPredicate(collection);
    }

    public static Predicate g(Class cls) {
        return new InstanceOfPredicate(cls);
    }

    public static Predicate h(Predicate predicate) {
        return new NotPredicate(predicate);
    }
}
