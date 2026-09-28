package com.airbnb.lottie.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class KeyPath {

    /* renamed from: c, reason: collision with root package name */
    public static final KeyPath f14466c = new KeyPath("COMPOSITION");

    /* renamed from: a, reason: collision with root package name */
    public final List f14467a;

    /* renamed from: b, reason: collision with root package name */
    public KeyPathElement f14468b;

    public KeyPath(String... strArr) {
        this.f14467a = Arrays.asList(strArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x007e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(int r8, java.lang.String r9) {
        /*
            r7 = this;
            java.util.List r0 = r7.f14467a
            int r1 = r0.size()
            r2 = 0
            if (r8 < r1) goto Lb
            goto L87
        Lb:
            int r1 = r0.size()
            r3 = 1
            int r1 = r1 - r3
            if (r8 != r1) goto L15
            r1 = r3
            goto L16
        L15:
            r1 = r2
        L16:
            java.lang.Object r4 = r0.get(r8)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = "**"
            boolean r6 = r4.equals(r5)
            if (r6 != 0) goto L4f
            boolean r9 = r4.equals(r9)
            if (r9 != 0) goto L35
            java.lang.String r9 = "*"
            boolean r9 = r4.equals(r9)
            if (r9 == 0) goto L33
            goto L35
        L33:
            r9 = r2
            goto L36
        L35:
            r9 = r3
        L36:
            if (r1 != 0) goto L4c
            int r1 = r0.size()
            int r1 = r1 + (-2)
            if (r8 != r1) goto L87
            java.lang.Object r8 = androidx.fragment.app.e.k(r3, r0)
            java.lang.String r8 = (java.lang.String) r8
            boolean r8 = r8.equals(r5)
            if (r8 == 0) goto L87
        L4c:
            if (r9 == 0) goto L87
            goto L7e
        L4f:
            if (r1 != 0) goto L7c
            int r4 = r8 + 1
            java.lang.Object r4 = r0.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            boolean r4 = r4.equals(r9)
            if (r4 == 0) goto L7c
            int r9 = r0.size()
            int r9 = r9 + (-2)
            if (r8 == r9) goto L7e
            int r9 = r0.size()
            int r9 = r9 + (-3)
            if (r8 != r9) goto L87
            java.lang.Object r8 = androidx.fragment.app.e.k(r3, r0)
            java.lang.String r8 = (java.lang.String) r8
            boolean r8 = r8.equals(r5)
            if (r8 == 0) goto L87
            goto L7e
        L7c:
            if (r1 == 0) goto L7f
        L7e:
            return r3
        L7f:
            int r8 = r8 + r3
            int r1 = r0.size()
            int r1 = r1 - r3
            if (r8 >= r1) goto L88
        L87:
            return r2
        L88:
            java.lang.Object r8 = r0.get(r8)
            java.lang.String r8 = (java.lang.String) r8
            boolean r8 = r8.equals(r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.KeyPath.a(int, java.lang.String):boolean");
    }

    public final int b(int i2, String str) {
        if ("__container".equals(str)) {
            return 0;
        }
        List list = this.f14467a;
        if (((String) list.get(i2)).equals("**")) {
            return (i2 != list.size() - 1 && ((String) list.get(i2 + 1)).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public final boolean c(int i2, String str) {
        if ("__container".equals(str)) {
            return true;
        }
        List list = this.f14467a;
        if (i2 >= list.size()) {
            return false;
        }
        return ((String) list.get(i2)).equals(str) || ((String) list.get(i2)).equals("**") || ((String) list.get(i2)).equals("*");
    }

    public final boolean d(int i2, String str) {
        if ("__container".equals(str)) {
            return true;
        }
        List list = this.f14467a;
        return i2 < list.size() - 1 || ((String) list.get(i2)).equals("**");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            KeyPath keyPath = (KeyPath) obj;
            if (!this.f14467a.equals(keyPath.f14467a)) {
                return false;
            }
            KeyPathElement keyPathElement = this.f14468b;
            KeyPathElement keyPathElement2 = keyPath.f14468b;
            if (keyPathElement != null) {
                return keyPathElement.equals(keyPathElement2);
            }
            if (keyPathElement2 == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f14467a.hashCode() * 31;
        KeyPathElement keyPathElement = this.f14468b;
        return iHashCode + (keyPathElement != null ? keyPathElement.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("KeyPath{keys=");
        sb.append(this.f14467a);
        sb.append(",resolved=");
        sb.append(this.f14468b != null);
        sb.append('}');
        return sb.toString();
    }

    public KeyPath(KeyPath keyPath) {
        this.f14467a = new ArrayList(keyPath.f14467a);
        this.f14468b = keyPath.f14468b;
    }
}
