package org.apache.xml.security.c14n.implementations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.w3c.dom.Attr;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public class NameSpaceSymbTable {

    /* renamed from: e, reason: collision with root package name */
    static final SymbMap f57168e;

    /* renamed from: b, reason: collision with root package name */
    int f57170b = 0;

    /* renamed from: d, reason: collision with root package name */
    boolean f57172d = true;

    /* renamed from: c, reason: collision with root package name */
    List f57171c = new ArrayList(10);

    /* renamed from: a, reason: collision with root package name */
    SymbMap f57169a = (SymbMap) f57168e.clone();

    static {
        SymbMap symbMap = new SymbMap();
        f57168e = symbMap;
        NameSpaceSymbEntry nameSpaceSymbEntry = new NameSpaceSymbEntry("", null, true, "xmlns");
        nameSpaceSymbEntry.f57165d = "";
        symbMap.a("xmlns", nameSpaceSymbEntry);
    }

    public Attr a(String str) {
        NameSpaceSymbEntry nameSpaceSymbEntryA = this.f57169a.a(str);
        if (nameSpaceSymbEntryA == null || nameSpaceSymbEntryA.f57166e) {
            return null;
        }
        NameSpaceSymbEntry nameSpaceSymbEntry = (NameSpaceSymbEntry) nameSpaceSymbEntryA.clone();
        e();
        this.f57169a.a(str, nameSpaceSymbEntry);
        nameSpaceSymbEntry.f57166e = true;
        nameSpaceSymbEntry.f57162a = this.f57170b;
        nameSpaceSymbEntry.f57165d = nameSpaceSymbEntry.f57164c;
        return nameSpaceSymbEntry.f57167f;
    }

    public Attr b(String str) {
        NameSpaceSymbEntry nameSpaceSymbEntryA = this.f57169a.a(str);
        if (nameSpaceSymbEntryA == null || nameSpaceSymbEntryA.f57166e) {
            return null;
        }
        return nameSpaceSymbEntryA.f57167f;
    }

    public void c() {
        this.f57171c.add(null);
        this.f57172d = false;
    }

    public void d() {
        int size = this.f57171c.size();
        int i2 = size - 1;
        Object objRemove = this.f57171c.remove(i2);
        if (objRemove == null) {
            this.f57172d = false;
            return;
        }
        this.f57169a = (SymbMap) objRemove;
        if (i2 == 0) {
            this.f57172d = false;
        } else {
            this.f57172d = this.f57171c.get(size + (-2)) != this.f57169a;
        }
    }

    public final void e() {
        if (this.f57172d) {
            return;
        }
        List list = this.f57171c;
        list.set(list.size() - 1, this.f57169a);
        this.f57169a = (SymbMap) this.f57169a.clone();
        this.f57172d = true;
    }

    public int f() {
        return this.f57171c.size();
    }

    public void a() {
        this.f57170b++;
        c();
    }

    public Node b(String str, String str2, Attr attr) {
        String str3;
        NameSpaceSymbEntry nameSpaceSymbEntryA = this.f57169a.a(str);
        if (nameSpaceSymbEntryA != null && str2.equals(nameSpaceSymbEntryA.f57164c)) {
            if (nameSpaceSymbEntryA.f57166e) {
                return null;
            }
            NameSpaceSymbEntry nameSpaceSymbEntry = (NameSpaceSymbEntry) nameSpaceSymbEntryA.clone();
            e();
            this.f57169a.a(str, nameSpaceSymbEntry);
            nameSpaceSymbEntry.f57165d = str2;
            nameSpaceSymbEntry.f57166e = true;
            return nameSpaceSymbEntry.f57167f;
        }
        NameSpaceSymbEntry nameSpaceSymbEntry2 = new NameSpaceSymbEntry(str2, attr, true, str);
        nameSpaceSymbEntry2.f57165d = str2;
        e();
        this.f57169a.a(str, nameSpaceSymbEntry2);
        if (nameSpaceSymbEntryA == null || (str3 = nameSpaceSymbEntryA.f57165d) == null || !str3.equals(str2)) {
            return nameSpaceSymbEntry2.f57167f;
        }
        nameSpaceSymbEntry2.f57166e = true;
        return null;
    }

    public void c(String str) {
        if (this.f57169a.a(str) != null) {
            e();
            this.f57169a.a(str, null);
        }
    }

    public void d(String str) {
        NameSpaceSymbEntry nameSpaceSymbEntryA = this.f57169a.a(str);
        if (nameSpaceSymbEntryA == null || nameSpaceSymbEntryA.f57166e) {
            return;
        }
        e();
        this.f57169a.a(str, null);
    }

    public boolean e(String str) {
        NameSpaceSymbEntry nameSpaceSymbEntryA = this.f57169a.a(str);
        if (nameSpaceSymbEntryA == null || !nameSpaceSymbEntryA.f57166e) {
            return false;
        }
        e();
        this.f57169a.a(str, null);
        return false;
    }

    public void a(Collection collection) {
        for (NameSpaceSymbEntry nameSpaceSymbEntry : this.f57169a.a()) {
            if (!nameSpaceSymbEntry.f57166e && nameSpaceSymbEntry.f57167f != null) {
                NameSpaceSymbEntry nameSpaceSymbEntry2 = (NameSpaceSymbEntry) nameSpaceSymbEntry.clone();
                e();
                this.f57169a.a(nameSpaceSymbEntry2.f57163b, nameSpaceSymbEntry2);
                nameSpaceSymbEntry2.f57165d = nameSpaceSymbEntry2.f57164c;
                nameSpaceSymbEntry2.f57166e = true;
                collection.add(nameSpaceSymbEntry2.f57167f);
            }
        }
    }

    public void b() {
        this.f57170b--;
        d();
    }

    public boolean a(String str, String str2, Attr attr) {
        NameSpaceSymbEntry nameSpaceSymbEntryA = this.f57169a.a(str);
        if (nameSpaceSymbEntryA != null && str2.equals(nameSpaceSymbEntryA.f57164c)) {
            return false;
        }
        NameSpaceSymbEntry nameSpaceSymbEntry = new NameSpaceSymbEntry(str2, attr, false, str);
        e();
        this.f57169a.a(str, nameSpaceSymbEntry);
        if (nameSpaceSymbEntryA != null) {
            nameSpaceSymbEntry.f57165d = nameSpaceSymbEntryA.f57165d;
            String str3 = nameSpaceSymbEntryA.f57165d;
            if (str3 != null && str3.equals(str2)) {
                nameSpaceSymbEntry.f57166e = true;
            }
        }
        return true;
    }
}
