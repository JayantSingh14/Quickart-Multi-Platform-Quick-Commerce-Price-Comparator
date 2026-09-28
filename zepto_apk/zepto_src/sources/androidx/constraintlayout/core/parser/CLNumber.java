package androidx.constraintlayout.core.parser;

/* loaded from: classes3.dex */
public class CLNumber extends CLElement {
    @Override // androidx.constraintlayout.core.parser.CLElement
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CLNumber) {
            throw null;
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public final int hashCode() {
        return super.hashCode() * 31;
    }
}
