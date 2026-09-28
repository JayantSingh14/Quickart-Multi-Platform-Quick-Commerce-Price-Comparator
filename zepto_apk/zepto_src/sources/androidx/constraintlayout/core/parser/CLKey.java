package androidx.constraintlayout.core.parser;

import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes3.dex */
public class CLKey extends CLContainer {
    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add("ConstraintSets");
        arrayList.add("Variables");
        arrayList.add("Generate");
        arrayList.add("Transitions");
        arrayList.add("KeyFrames");
        arrayList.add("KeyAttributes");
        arrayList.add("KeyPositions");
        arrayList.add("KeyCycles");
    }

    @Override // androidx.constraintlayout.core.parser.CLContainer, androidx.constraintlayout.core.parser.CLElement
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CLKey) {
            String strD = CLElement.d();
            ((CLKey) obj).getClass();
            if (!Objects.equals(strD, CLElement.d())) {
                return false;
            }
        }
        return super.equals(obj);
    }
}
