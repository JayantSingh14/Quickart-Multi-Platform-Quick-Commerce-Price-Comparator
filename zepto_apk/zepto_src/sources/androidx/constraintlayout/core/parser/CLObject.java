package androidx.constraintlayout.core.parser;

import java.util.Iterator;

/* loaded from: classes3.dex */
public class CLObject extends CLContainer implements Iterable<CLKey> {

    public static class CLObjectIterator implements Iterator<CLKey> {

        /* renamed from: a, reason: collision with root package name */
        public CLObject f1902a;

        /* renamed from: b, reason: collision with root package name */
        public int f1903b;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f1903b < this.f1902a.f1900b.size();
        }

        @Override // java.util.Iterator
        public final CLKey next() {
            CLKey cLKey = (CLKey) this.f1902a.f1900b.get(this.f1903b);
            this.f1903b++;
            return cLKey;
        }
    }

    @Override // androidx.constraintlayout.core.parser.CLContainer, androidx.constraintlayout.core.parser.CLElement
    /* renamed from: b */
    public final CLElement clone() {
        return (CLObject) super.clone();
    }

    @Override // androidx.constraintlayout.core.parser.CLContainer, androidx.constraintlayout.core.parser.CLElement
    public final Object clone() {
        return (CLObject) super.clone();
    }

    @Override // androidx.constraintlayout.core.parser.CLContainer
    /* renamed from: f */
    public final CLContainer clone() {
        return (CLObject) super.clone();
    }

    @Override // java.lang.Iterable
    public final Iterator<CLKey> iterator() {
        CLObjectIterator cLObjectIterator = new CLObjectIterator();
        cLObjectIterator.f1903b = 0;
        cLObjectIterator.f1902a = this;
        return cLObjectIterator;
    }
}
