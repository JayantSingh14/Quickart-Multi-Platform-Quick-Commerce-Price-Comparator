package androidx.constraintlayout.core.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes3.dex */
public class CLContainer extends CLElement {

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f1900b;

    @Override // androidx.constraintlayout.core.parser.CLElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CLContainer) {
            return this.f1900b.equals(((CLContainer) obj).f1900b);
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public CLContainer clone() {
        CLContainer cLContainer = (CLContainer) super.clone();
        ArrayList arrayList = new ArrayList(this.f1900b.size());
        Iterator it = this.f1900b.iterator();
        while (it.hasNext()) {
            CLElement cLElementClone = ((CLElement) it.next()).clone();
            cLElementClone.f1901a = cLContainer;
            arrayList.add(cLElementClone);
        }
        cLContainer.f1900b = arrayList;
        return cLContainer;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int hashCode() {
        return Objects.hash(this.f1900b, Integer.valueOf(super.hashCode()));
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it = this.f1900b.iterator();
        while (it.hasNext()) {
            CLElement cLElement = (CLElement) it.next();
            if (sb.length() > 0) {
                sb.append("; ");
            }
            sb.append(cLElement);
        }
        return super.toString() + " = <" + ((Object) sb) + " >";
    }
}
