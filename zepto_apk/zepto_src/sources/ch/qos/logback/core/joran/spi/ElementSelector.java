package ch.qos.logback.core.joran.spi;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ElementSelector extends ElementPath {
    @Override // ch.qos.logback.core.joran.spi.ElementPath
    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ElementSelector)) {
            return false;
        }
        ElementSelector elementSelector = (ElementSelector) obj;
        int size = elementSelector.f13556a.size();
        ArrayList arrayList = this.f13556a;
        if (size != arrayList.size()) {
            return false;
        }
        int size2 = arrayList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (!a(i2).equalsIgnoreCase(elementSelector.a(i2))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int size = this.f13556a.size();
        int iHashCode = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iHashCode ^= a(i2).toLowerCase().hashCode();
        }
        return iHashCode;
    }
}
