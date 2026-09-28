package kotlinx.serialization.descriptors;

import androidx.fragment.app.e;
import defpackage.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.IndexingIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.internal.CachedNames;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptorKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class SerialDescriptorImpl implements SerialDescriptor, CachedNames {

    /* renamed from: a, reason: collision with root package name */
    public final String f55741a;

    /* renamed from: b, reason: collision with root package name */
    public final SerialKind f55742b;

    /* renamed from: c, reason: collision with root package name */
    public final int f55743c;

    /* renamed from: d, reason: collision with root package name */
    public final EmptyList f55744d;

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f55745e;

    /* renamed from: f, reason: collision with root package name */
    public final String[] f55746f;

    /* renamed from: g, reason: collision with root package name */
    public final SerialDescriptor[] f55747g;

    /* renamed from: h, reason: collision with root package name */
    public final List[] f55748h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean[] f55749i;

    /* renamed from: j, reason: collision with root package name */
    public final Map f55750j;

    /* renamed from: k, reason: collision with root package name */
    public final SerialDescriptor[] f55751k;

    /* renamed from: l, reason: collision with root package name */
    public final Lazy f55752l;

    public SerialDescriptorImpl(String serialName, SerialKind kind, int i2, List typeParameters, ClassSerialDescriptorBuilder builder) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f55741a = serialName;
        this.f55742b = kind;
        this.f55743c = i2;
        this.f55744d = builder.f55721b;
        ArrayList arrayList = builder.f55722c;
        this.f55745e = CollectionsKt.d0(arrayList);
        int i3 = 0;
        this.f55746f = (String[]) arrayList.toArray(new String[0]);
        this.f55747g = Platform_commonKt.b(builder.f55724e);
        this.f55748h = (List[]) builder.f55725f.toArray(new List[0]);
        ArrayList arrayList2 = builder.f55726g;
        Intrinsics.checkNotNullParameter(arrayList2, "<this>");
        boolean[] zArr = new boolean[arrayList2.size()];
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            zArr[i3] = ((Boolean) it.next()).booleanValue();
            i3++;
        }
        this.f55749i = zArr;
        String[] strArr = this.f55746f;
        Intrinsics.checkNotNullParameter(strArr, "<this>");
        IndexingIterable indexingIterable = new IndexingIterable(new b(strArr, 8));
        ArrayList arrayList3 = new ArrayList(CollectionsKt.r(indexingIterable, 10));
        Iterator it2 = indexingIterable.iterator();
        while (true) {
            IndexingIterator indexingIterator = (IndexingIterator) it2;
            if (!indexingIterator.f53615a.hasNext()) {
                this.f55750j = MapsKt.k(arrayList3);
                this.f55751k = Platform_commonKt.b(typeParameters);
                this.f55752l = LazyKt.b(new Function0<Integer>() { // from class: kotlinx.serialization.descriptors.SerialDescriptorImpl$_hashCode$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        SerialDescriptorImpl serialDescriptorImpl = this.f55753c;
                        return Integer.valueOf(PluginGeneratedSerialDescriptorKt.a(serialDescriptorImpl, serialDescriptorImpl.f55751k));
                    }
                });
                return;
            }
            IndexedValue indexedValue = (IndexedValue) indexingIterator.next();
            arrayList3.add(new Pair(indexedValue.f53613b, Integer.valueOf(indexedValue.f53612a)));
        }
    }

    @Override // kotlinx.serialization.internal.CachedNames
    public final Set a() {
        return this.f55745e;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean b() {
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int c(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer num = (Integer) this.f55750j.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialKind d() {
        return this.f55742b;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int e() {
        return this.f55743c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SerialDescriptorImpl) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (Intrinsics.b(this.f55741a, serialDescriptor.i()) && Arrays.equals(this.f55751k, ((SerialDescriptorImpl) obj).f55751k)) {
                int iE = serialDescriptor.e();
                int i2 = this.f55743c;
                if (i2 == iE) {
                    for (int i3 = 0; i3 < i2; i3++) {
                        SerialDescriptor[] serialDescriptorArr = this.f55747g;
                        if (Intrinsics.b(serialDescriptorArr[i3].i(), serialDescriptor.h(i3).i()) && Intrinsics.b(serialDescriptorArr[i3].d(), serialDescriptor.h(i3).d())) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String f(int i2) {
        return this.f55746f[i2];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List g(int i2) {
        return this.f55748h[i2];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List getAnnotations() {
        return this.f55744d;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialDescriptor h(int i2) {
        return this.f55747g[i2];
    }

    public final int hashCode() {
        return ((Number) this.f55752l.getValue()).intValue();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String i() {
        return this.f55741a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isInline() {
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean j(int i2) {
        return this.f55749i[i2];
    }

    public final String toString() {
        return CollectionsKt.E(RangesKt.f(0, this.f55743c), ", ", e.t(new StringBuilder(), this.f55741a, '('), ")", new Function1<Integer, CharSequence>() { // from class: kotlinx.serialization.descriptors.SerialDescriptorImpl.toString.1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int iIntValue = ((Number) obj).intValue();
                StringBuilder sb = new StringBuilder();
                SerialDescriptorImpl serialDescriptorImpl = SerialDescriptorImpl.this;
                sb.append(serialDescriptorImpl.f55746f[iIntValue]);
                sb.append(": ");
                sb.append(serialDescriptorImpl.f55747g[iIntValue].i());
                return sb.toString();
            }
        }, 24);
    }
}
