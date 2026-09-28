package androidx.datastore.preferences.core;

import android.support.v4.media.b;
import androidx.datastore.preferences.core.Preferences;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class MutablePreferences extends Preferences {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f3717a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f3718b;

    @Metadata
    /* renamed from: androidx.datastore.preferences.core.MutablePreferences$toString$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    final class AnonymousClass1 extends Lambda implements Function1<Map.Entry<Preferences.Key<?>, Object>, CharSequence> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass1 f3719c = new AnonymousClass1(1);

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Intrinsics.checkNotNullParameter(entry, "entry");
            Object value = entry.getValue();
            return b.s(new StringBuilder("  "), ((Preferences.Key) entry.getKey()).f3725a, " = ", value instanceof byte[] ? ArraysKt.C((byte[]) value, ", ", null, 56) : String.valueOf(entry.getValue()));
        }
    }

    public MutablePreferences() {
        this(false, 3);
    }

    @Override // androidx.datastore.preferences.core.Preferences
    public final Map a() {
        Pair pair;
        Set<Map.Entry> setEntrySet = this.f3717a.entrySet();
        int iF = MapsKt.f(CollectionsKt.r(setEntrySet, 10));
        if (iF < 16) {
            iF = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iF);
        for (Map.Entry entry : setEntrySet) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                Object key = entry.getKey();
                byte[] bArr = (byte[]) value;
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
                pair = new Pair(key, bArrCopyOf);
            } else {
                pair = new Pair(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(pair.f53533a, pair.f53534b);
        }
        return Actual_jvmKt.b(linkedHashMap);
    }

    @Override // androidx.datastore.preferences.core.Preferences
    public final Object b(Preferences.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = this.f3717a.get(key);
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    public final void c() {
        if (this.f3718b.f3716a.get()) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
        }
    }

    public final void d(Preferences.Key key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        c();
        LinkedHashMap linkedHashMap = this.f3717a;
        if (obj == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            c();
            linkedHashMap.remove(key);
        } else {
            if (obj instanceof Set) {
                linkedHashMap.put(key, Actual_jvmKt.a((Set) obj));
                return;
            }
            if (!(obj instanceof byte[])) {
                linkedHashMap.put(key, obj);
                return;
            }
            byte[] bArr = (byte[]) obj;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
            linkedHashMap.put(key, bArrCopyOf);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.datastore.preferences.core.MutablePreferences
            r1 = 0
            if (r0 != 0) goto L6
            goto L62
        L6:
            androidx.datastore.preferences.core.MutablePreferences r7 = (androidx.datastore.preferences.core.MutablePreferences) r7
            java.util.LinkedHashMap r0 = r7.f3717a
            java.util.LinkedHashMap r2 = r6.f3717a
            r3 = 1
            if (r0 != r2) goto L10
            goto L63
        L10:
            int r0 = r0.size()
            int r4 = r2.size()
            if (r0 == r4) goto L1b
            goto L62
        L1b:
            java.util.LinkedHashMap r7 = r7.f3717a
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto L24
            goto L63
        L24:
            java.util.Set r7 = r7.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L2c:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L63
            java.lang.Object r0 = r7.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r4 = r0.getKey()
            java.lang.Object r4 = r2.get(r4)
            if (r4 == 0) goto L5f
            java.lang.Object r0 = r0.getValue()
            boolean r5 = r0 instanceof byte[]
            if (r5 == 0) goto L5a
            boolean r5 = r4 instanceof byte[]
            if (r5 == 0) goto L5f
            byte[] r0 = (byte[]) r0
            byte[] r4 = (byte[]) r4
            boolean r0 = java.util.Arrays.equals(r0, r4)
            if (r0 == 0) goto L5f
            r0 = r3
            goto L60
        L5a:
            boolean r0 = kotlin.jvm.internal.Intrinsics.b(r0, r4)
            goto L60
        L5f:
            r0 = r1
        L60:
            if (r0 != 0) goto L2c
        L62:
            return r1
        L63:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.core.MutablePreferences.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator it = this.f3717a.entrySet().iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            iHashCode += value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value.hashCode();
        }
        return iHashCode;
    }

    public final String toString() {
        return CollectionsKt.E(this.f3717a.entrySet(), ",\n", "{\n", "\n}", AnonymousClass1.f3719c, 24);
    }

    public /* synthetic */ MutablePreferences(boolean z, int i2) {
        this(new LinkedHashMap(), (i2 & 2) != 0 ? true : z);
    }

    public MutablePreferences(LinkedHashMap preferencesMap, boolean z) {
        Intrinsics.checkNotNullParameter(preferencesMap, "preferencesMap");
        this.f3717a = preferencesMap;
        this.f3718b = new AtomicBoolean(z);
    }
}
