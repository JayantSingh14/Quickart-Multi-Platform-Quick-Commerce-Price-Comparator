package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.Map;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public class Joiner {

    /* renamed from: a, reason: collision with root package name */
    public final String f42276a;

    /* renamed from: com.google.common.base.Joiner$2, reason: invalid class name */
    class AnonymousClass2 extends Joiner {
        @Override // com.google.common.base.Joiner
        public final void a(Iterator it, StringBuilder sb) {
            Preconditions.j(it, "parts");
            while (it.hasNext()) {
                if (it.next() != null) {
                    throw null;
                }
            }
            while (it.hasNext()) {
                if (it.next() != null) {
                    throw null;
                }
            }
        }

        @Override // com.google.common.base.Joiner
        public final Joiner f() {
            throw null;
        }
    }

    /* renamed from: com.google.common.base.Joiner$3, reason: invalid class name */
    class AnonymousClass3 extends AbstractList<Object> {
        @Override // java.util.AbstractList, java.util.List
        public final Object get(int i2) {
            if (i2 == 0 || i2 == 1) {
                return null;
            }
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            throw null;
        }
    }

    public static final class MapJoiner {

        /* renamed from: a, reason: collision with root package name */
        public final Joiner f42278a;

        public MapJoiner(Joiner joiner) {
            this.f42278a = joiner;
        }

        public final void a(Iterator it, StringBuilder sb) {
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                Joiner joiner = this.f42278a;
                sb.append(joiner.e(key));
                sb.append("=");
                sb.append(joiner.e(entry.getValue()));
                while (it.hasNext()) {
                    sb.append((CharSequence) joiner.f42276a);
                    Map.Entry entry2 = (Map.Entry) it.next();
                    sb.append(joiner.e(entry2.getKey()));
                    sb.append("=");
                    sb.append(joiner.e(entry2.getValue()));
                }
            }
        }
    }

    public Joiner(String str) {
        str.getClass();
        this.f42276a = str;
    }

    public static Joiner d(char c2) {
        return new Joiner(String.valueOf(c2));
    }

    public void a(Iterator it, StringBuilder sb) {
        if (it.hasNext()) {
            sb.append(e(it.next()));
            while (it.hasNext()) {
                sb.append((CharSequence) this.f42276a);
                sb.append(e(it.next()));
            }
        }
    }

    public final void b(Iterator it, StringBuilder sb) {
        try {
            a(it, sb);
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final String c(Iterable iterable) {
        Iterator it = iterable.iterator();
        StringBuilder sb = new StringBuilder();
        b(it, sb);
        return sb.toString();
    }

    public CharSequence e(Object obj) {
        java.util.Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public Joiner f() {
        return new Joiner(this) { // from class: com.google.common.base.Joiner.1
            @Override // com.google.common.base.Joiner
            public final CharSequence e(Object obj) {
                return obj == null ? "null" : Joiner.this.e(obj);
            }

            @Override // com.google.common.base.Joiner
            public final Joiner f() {
                throw null;
            }
        };
    }

    public Joiner(Joiner joiner) {
        this.f42276a = joiner.f42276a;
    }
}
