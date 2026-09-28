package androidx.constraintlayout.core.parser;

/* loaded from: classes3.dex */
public class CLString extends CLElement {
    @Override // androidx.constraintlayout.core.parser.CLElement
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CLString) {
            String strD = CLElement.d();
            ((CLString) obj).getClass();
            if (strD.equals(CLElement.d())) {
                return true;
            }
        }
        return super.equals(obj);
    }
}
