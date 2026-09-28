package j$.time.format;

import java.util.ArrayList;

/* renamed from: j$.time.format.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0121d implements InterfaceC0122e {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0122e[] f53313a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f53314b;

    public C0121d(ArrayList arrayList, boolean z) {
        this((InterfaceC0122e[]) arrayList.toArray(new InterfaceC0122e[arrayList.size()]), z);
    }

    public C0121d(InterfaceC0122e[] interfaceC0122eArr, boolean z) {
        this.f53313a = interfaceC0122eArr;
        this.f53314b = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        if (r2 != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
    
        return true;
     */
    @Override // j$.time.format.InterfaceC0122e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(j$.time.format.w r8, java.lang.StringBuilder r9) {
        /*
            r7 = this;
            int r0 = r9.length()
            r1 = 1
            boolean r2 = r7.f53314b
            if (r2 == 0) goto Le
            int r3 = r8.f53372c
            int r3 = r3 + r1
            r8.f53372c = r3
        Le:
            j$.time.format.e[] r3 = r7.f53313a     // Catch: java.lang.Throwable -> L27
            int r4 = r3.length     // Catch: java.lang.Throwable -> L27
            r5 = 0
        L12:
            if (r5 >= r4) goto L2c
            r6 = r3[r5]     // Catch: java.lang.Throwable -> L27
            boolean r6 = r6.q(r8, r9)     // Catch: java.lang.Throwable -> L27
            if (r6 != 0) goto L29
            r9.setLength(r0)     // Catch: java.lang.Throwable -> L27
            if (r2 == 0) goto L2f
        L21:
            int r9 = r8.f53372c
            int r9 = r9 - r1
            r8.f53372c = r9
            return r1
        L27:
            r9 = move-exception
            goto L30
        L29:
            int r5 = r5 + 1
            goto L12
        L2c:
            if (r2 == 0) goto L2f
            goto L21
        L2f:
            return r1
        L30:
            if (r2 == 0) goto L37
            int r0 = r8.f53372c
            int r0 = r0 - r1
            r8.f53372c = r0
        L37:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.C0121d.q(j$.time.format.w, java.lang.StringBuilder):boolean");
    }

    @Override // j$.time.format.InterfaceC0122e
    public final int s(u uVar, CharSequence charSequence, int i2) {
        boolean z = this.f53314b;
        InterfaceC0122e[] interfaceC0122eArr = this.f53313a;
        int i3 = 0;
        if (z) {
            ArrayList arrayList = uVar.f53364d;
            B bC = uVar.c();
            bC.getClass();
            B b2 = new B();
            b2.f53273a.putAll(bC.f53273a);
            b2.f53274b = bC.f53274b;
            b2.f53275c = bC.f53275c;
            b2.f53276d = bC.f53276d;
            arrayList.add(b2);
            int length = interfaceC0122eArr.length;
            int iS = i2;
            while (i3 < length) {
                iS = interfaceC0122eArr[i3].s(uVar, charSequence, iS);
                if (iS < 0) {
                    arrayList.remove(arrayList.size() - 1);
                    return i2;
                }
                i3++;
            }
            arrayList.remove(arrayList.size() - 2);
            return iS;
        }
        int length2 = interfaceC0122eArr.length;
        while (i3 < length2) {
            i2 = interfaceC0122eArr[i3].s(uVar, charSequence, i2);
            if (i2 < 0) {
                return i2;
            }
            i3++;
        }
        return i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        InterfaceC0122e[] interfaceC0122eArr = this.f53313a;
        if (interfaceC0122eArr != null) {
            boolean z = this.f53314b;
            sb.append(z ? "[" : "(");
            for (InterfaceC0122e interfaceC0122e : interfaceC0122eArr) {
                sb.append(interfaceC0122e);
            }
            sb.append(z ? "]" : ")");
        }
        return sb.toString();
    }
}
