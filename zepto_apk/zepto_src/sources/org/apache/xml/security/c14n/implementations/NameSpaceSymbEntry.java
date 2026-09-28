package org.apache.xml.security.c14n.implementations;

import org.w3c.dom.Attr;

/* loaded from: classes5.dex */
class NameSpaceSymbEntry implements Cloneable {

    /* renamed from: b, reason: collision with root package name */
    String f57163b;

    /* renamed from: c, reason: collision with root package name */
    String f57164c;

    /* renamed from: e, reason: collision with root package name */
    boolean f57166e;

    /* renamed from: f, reason: collision with root package name */
    Attr f57167f;

    /* renamed from: a, reason: collision with root package name */
    int f57162a = 0;

    /* renamed from: d, reason: collision with root package name */
    String f57165d = null;

    public NameSpaceSymbEntry(String str, Attr attr, boolean z, String str2) {
        this.f57164c = str;
        this.f57166e = z;
        this.f57167f = attr;
        this.f57163b = str2;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
