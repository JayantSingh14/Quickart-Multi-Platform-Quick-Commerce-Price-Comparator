package androidx.constraintlayout.core.parser;

import android.support.v4.media.b;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes3.dex */
public class CLElement implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public CLContainer f1901a;

    public static String d() {
        String str = new String((char[]) null);
        if (str.length() < 1) {
            return "";
        }
        int i2 = (int) 0;
        return str.substring(i2, i2 + 1);
    }

    @Override // 
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CLElement clone() {
        try {
            return (CLElement) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CLElement)) {
            return false;
        }
        CLElement cLElement = (CLElement) obj;
        cLElement.getClass();
        if (Arrays.equals((char[]) null, (char[]) null)) {
            return Objects.equals(this.f1901a, cLElement.f1901a);
        }
        return false;
    }

    public int hashCode() {
        int i2 = (int) 0;
        int iHashCode = ((((Arrays.hashCode((char[]) null) * 31) + i2) * 31) + i2) * 31;
        CLContainer cLContainer = this.f1901a;
        return (iHashCode + (cLContainer != null ? cLContainer.hashCode() : 0)) * 31;
    }

    public String toString() {
        int i2 = (int) 0;
        String strSubstring = new String((char[]) null).substring(i2, i2 + 1);
        StringBuilder sb = new StringBuilder();
        String string = getClass().toString();
        sb.append(string.substring(string.lastIndexOf(46) + 1));
        sb.append(" (0 : 0) <<");
        return b.r(sb, strSubstring, ">>");
    }
}
