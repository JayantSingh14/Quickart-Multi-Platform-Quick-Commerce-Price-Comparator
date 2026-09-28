package org.apache.xml.security.c14n.implementations;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
class SymbMap implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    int f57173a = 23;

    /* renamed from: b, reason: collision with root package name */
    NameSpaceSymbEntry[] f57174b = new NameSpaceSymbEntry[23];

    /* renamed from: c, reason: collision with root package name */
    String[] f57175c = new String[23];

    public int a(Object obj) {
        String str;
        String[] strArr = this.f57175c;
        int length = strArr.length;
        int iHashCode = (obj.hashCode() & Api.BaseClientBuilder.API_PRIORITY_OTHER) % length;
        String str2 = strArr[iHashCode];
        if (str2 != null && !str2.equals(obj)) {
            int i2 = length - 1;
            do {
                iHashCode = iHashCode == i2 ? 0 : iHashCode + 1;
                str = strArr[iHashCode];
                if (str == null) {
                    break;
                }
            } while (!str.equals(obj));
        }
        return iHashCode;
    }

    public Object clone() {
        try {
            SymbMap symbMap = (SymbMap) super.clone();
            NameSpaceSymbEntry[] nameSpaceSymbEntryArr = new NameSpaceSymbEntry[this.f57174b.length];
            symbMap.f57174b = nameSpaceSymbEntryArr;
            NameSpaceSymbEntry[] nameSpaceSymbEntryArr2 = this.f57174b;
            System.arraycopy(nameSpaceSymbEntryArr2, 0, nameSpaceSymbEntryArr, 0, nameSpaceSymbEntryArr2.length);
            String[] strArr = new String[this.f57175c.length];
            symbMap.f57175c = strArr;
            String[] strArr2 = this.f57175c;
            System.arraycopy(strArr2, 0, strArr, 0, strArr2.length);
            return symbMap;
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public List a() {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            NameSpaceSymbEntry[] nameSpaceSymbEntryArr = this.f57174b;
            if (i2 >= nameSpaceSymbEntryArr.length) {
                return arrayList;
            }
            NameSpaceSymbEntry nameSpaceSymbEntry = nameSpaceSymbEntryArr[i2];
            if (nameSpaceSymbEntry != null && !"".equals(nameSpaceSymbEntry.f57164c)) {
                arrayList.add(this.f57174b[i2]);
            }
            i2++;
        }
    }

    public NameSpaceSymbEntry a(String str) {
        return this.f57174b[a((Object) str)];
    }

    public void a(int i2) {
        String[] strArr = this.f57175c;
        int length = strArr.length;
        NameSpaceSymbEntry[] nameSpaceSymbEntryArr = this.f57174b;
        this.f57175c = new String[i2];
        this.f57174b = new NameSpaceSymbEntry[i2];
        while (true) {
            int i3 = length - 1;
            if (length <= 0) {
                return;
            }
            String str = strArr[i3];
            if (str != null) {
                int iA = a((Object) str);
                this.f57175c[iA] = str;
                this.f57174b[iA] = nameSpaceSymbEntryArr[i3];
            }
            length = i3;
        }
    }

    public void a(String str, NameSpaceSymbEntry nameSpaceSymbEntry) {
        int iA = a((Object) str);
        String[] strArr = this.f57175c;
        String str2 = strArr[iA];
        strArr[iA] = str;
        this.f57174b[iA] = nameSpaceSymbEntry;
        if (str2 == null || !str2.equals(str)) {
            int i2 = this.f57173a - 1;
            this.f57173a = i2;
            if (i2 == 0) {
                int length = this.f57174b.length;
                this.f57173a = length;
                a(length << 2);
            }
        }
    }
}
