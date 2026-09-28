package com.zeptoconsumerapp.modules.configservice;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.text.StringsKt__StringsKt;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes4.dex */
public final class SemVer implements Comparable<SemVer> {

    /* renamed from: a, reason: collision with root package name */
    public final int f47637a;

    /* renamed from: b, reason: collision with root package name */
    public final int f47638b;

    /* renamed from: c, reason: collision with root package name */
    public final int f47639c;

    @Metadata
    /* renamed from: com.zeptoconsumerapp.modules.configservice.SemVer$compareTo$1, reason: invalid class name */
    final /* synthetic */ class AnonymousClass1 extends PropertyReference1Impl {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass1 f47640c = new AnonymousClass1("major", "getMajor()I", SemVer.class);

        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
        public final Object get(Object obj) {
            return Integer.valueOf(((SemVer) obj).f47637a);
        }
    }

    @Metadata
    /* renamed from: com.zeptoconsumerapp.modules.configservice.SemVer$compareTo$2, reason: invalid class name */
    final /* synthetic */ class AnonymousClass2 extends PropertyReference1Impl {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass2 f47641c = new AnonymousClass2("minor", "getMinor()I", SemVer.class);

        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
        public final Object get(Object obj) {
            return Integer.valueOf(((SemVer) obj).f47638b);
        }
    }

    @Metadata
    /* renamed from: com.zeptoconsumerapp.modules.configservice.SemVer$compareTo$3, reason: invalid class name */
    final /* synthetic */ class AnonymousClass3 extends PropertyReference1Impl {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass3 f47642c = new AnonymousClass3("patch", "getPatch()I", SemVer.class);

        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
        public final Object get(Object obj) {
            return Integer.valueOf(((SemVer) obj).f47639c);
        }
    }

    public SemVer(String version) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(version, "version");
        int i2 = Integer.parseInt((String) StringsKt__StringsKt.split$default(version, new String[]{CLConstants.DOT_SALT_DELIMETER}, false, 0, 6, null).get(0));
        int i3 = Integer.parseInt((String) StringsKt__StringsKt.split$default(version, new String[]{CLConstants.DOT_SALT_DELIMETER}, false, 0, 6, null).get(1));
        int i4 = Integer.parseInt((String) StringsKt__StringsKt.split$default(version, new String[]{CLConstants.DOT_SALT_DELIMETER}, false, 0, 6, null).get(2));
        this.f47637a = i2;
        this.f47638b = i3;
        this.f47639c = i4;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(SemVer other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return ComparisonsKt.b(this, other, AnonymousClass1.f47640c, AnonymousClass2.f47641c, AnonymousClass3.f47642c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SemVer)) {
            return false;
        }
        SemVer semVer = (SemVer) obj;
        return this.f47637a == semVer.f47637a && this.f47638b == semVer.f47638b && this.f47639c == semVer.f47639c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f47639c) + android.support.v4.media.a.b(this.f47638b, Integer.hashCode(this.f47637a) * 31, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SemVer(major=");
        sb.append(this.f47637a);
        sb.append(", minor=");
        sb.append(this.f47638b);
        sb.append(", patch=");
        return b.o(sb, this.f47639c, ")");
    }
}
