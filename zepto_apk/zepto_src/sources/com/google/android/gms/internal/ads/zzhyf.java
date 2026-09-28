package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
final class zzhyf extends zzhxq {

    /* renamed from: a, reason: collision with root package name */
    public static final zzhyf f34508a = new zzhyf();

    public static void b(zzhyq zzhyqVar, zzhxj zzhxjVar) throws IOException {
        if (zzhxjVar == null || (zzhxjVar instanceof zzhxk)) {
            zzhyqVar.a();
            return;
        }
        boolean z = zzhxjVar instanceof zzhxn;
        Writer writer = zzhyqVar.f34525a;
        if (z) {
            zzhxn zzhxnVarF = zzhxjVar.f();
            Serializable serializable = zzhxnVarF.f34471a;
            if (!(serializable instanceof Number)) {
                if (serializable instanceof Boolean) {
                    boolean zBooleanValue = serializable != null ? ((Boolean) serializable).booleanValue() : Boolean.parseBoolean(zzhxnVarF.b());
                    zzhyqVar.e();
                    zzhyqVar.s();
                    writer.write(true != zBooleanValue ? "false" : "true");
                    return;
                }
                String strB = zzhxnVarF.b();
                if (strB == null) {
                    zzhyqVar.a();
                    return;
                }
                zzhyqVar.e();
                zzhyqVar.s();
                zzhyqVar.l(strB);
                return;
            }
            Number numberG = zzhxnVarF.g();
            if (numberG == null) {
                zzhyqVar.a();
                return;
            }
            zzhyqVar.e();
            String string = numberG.toString();
            Class<?> cls = numberG.getClass();
            if (cls != Integer.class && cls != Long.class && cls != Byte.class && cls != Short.class && cls != BigDecimal.class && cls != BigInteger.class && cls != AtomicInteger.class && cls != AtomicLong.class) {
                if (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN")) {
                    if (zzhyqVar.f34532h != zzhxo.f34472a) {
                        throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(string));
                    }
                } else if (cls != Float.class && cls != Double.class && !zzhyq.f34523j.matcher(string).matches()) {
                    String strValueOf = String.valueOf(cls);
                    throw new IllegalArgumentException(android.support.v4.media.a.n(new StringBuilder(strValueOf.length() + 47 + string.length()), "String created by ", strValueOf, " is not a valid JSON number: ", string));
                }
            }
            zzhyqVar.s();
            writer.append((CharSequence) string);
            return;
        }
        boolean z2 = zzhxjVar instanceof zzhxi;
        if (z2) {
            zzhyqVar.e();
            zzhyqVar.s();
            int i2 = zzhyqVar.f34527c;
            int[] iArr = zzhyqVar.f34526b;
            if (i2 == iArr.length) {
                zzhyqVar.f34526b = Arrays.copyOf(iArr, i2 + i2);
            }
            int[] iArr2 = zzhyqVar.f34526b;
            int i3 = zzhyqVar.f34527c;
            zzhyqVar.f34527c = i3 + 1;
            iArr2[i3] = 1;
            writer.write(91);
            if (!z2) {
                throw new IllegalStateException("Not a JSON Array: ".concat(zzhxjVar.toString()));
            }
            Iterator it = ((zzhxi) zzhxjVar).f34468a.iterator();
            while (it.hasNext()) {
                b(zzhyqVar, (zzhxj) it.next());
            }
            zzhyqVar.b(1, 2, ']');
            return;
        }
        if (!(zzhxjVar instanceof zzhxl)) {
            throw new IllegalArgumentException("Couldn't write ".concat(String.valueOf(zzhxjVar.getClass())));
        }
        zzhyqVar.e();
        zzhyqVar.s();
        int i4 = zzhyqVar.f34527c;
        int[] iArr3 = zzhyqVar.f34526b;
        if (i4 == iArr3.length) {
            zzhyqVar.f34526b = Arrays.copyOf(iArr3, i4 + i4);
        }
        int[] iArr4 = zzhyqVar.f34526b;
        int i5 = zzhyqVar.f34527c;
        zzhyqVar.f34527c = i5 + 1;
        iArr4[i5] = 3;
        writer.write(WKSRecord.Service.NTP);
        Iterator it2 = ((zzhxv) zzhxjVar.d().f34470a.entrySet()).iterator();
        while (((zzhxy) it2).hasNext()) {
            zzhxz next = ((zzhxu) it2).next();
            String str = (String) next.getKey();
            Objects.requireNonNull(str, "name == null");
            if (zzhyqVar.f34533i != null) {
                throw new IllegalStateException("Already wrote a name, expecting a value.");
            }
            int iC = zzhyqVar.c();
            if (iC != 3 && iC != 5) {
                throw new IllegalStateException("Please begin an object before writing a name.");
            }
            zzhyqVar.f34533i = str;
            b(zzhyqVar, (zzhxj) next.getValue());
        }
        zzhyqVar.b(3, 5, '}');
    }
}
