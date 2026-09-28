package kotlinx.serialization.internal;

import androidx.fragment.app.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;

@Metadata
@PublishedApi
@SourceDebugExtension
/* loaded from: classes.dex */
public class PluginGeneratedSerialDescriptor implements SerialDescriptor, CachedNames {

    /* renamed from: a, reason: collision with root package name */
    public final String f55871a;

    /* renamed from: b, reason: collision with root package name */
    public final GeneratedSerializer f55872b;

    /* renamed from: c, reason: collision with root package name */
    public final int f55873c;

    /* renamed from: d, reason: collision with root package name */
    public int f55874d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f55875e;

    /* renamed from: f, reason: collision with root package name */
    public final List[] f55876f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean[] f55877g;

    /* renamed from: h, reason: collision with root package name */
    public Object f55878h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f55879i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f55880j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f55881k;

    public PluginGeneratedSerialDescriptor(String serialName, GeneratedSerializer generatedSerializer, int i2) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        this.f55871a = serialName;
        this.f55872b = generatedSerializer;
        this.f55873c = i2;
        this.f55874d = -1;
        String[] strArr = new String[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            strArr[i3] = "[UNINITIALIZED]";
        }
        this.f55875e = strArr;
        int i4 = this.f55873c;
        this.f55876f = new List[i4];
        this.f55877g = new boolean[i4];
        this.f55878h = MapsKt.c();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f53529b;
        this.f55879i = LazyKt.a(lazyThreadSafetyMode, new Function0<KSerializer<?>[]>() { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$childSerializers$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                GeneratedSerializer generatedSerializer2 = this.f55883c.f55872b;
                return generatedSerializer2 != null ? generatedSerializer2.d() : PluginHelperInterfacesKt.f55886a;
            }
        });
        this.f55880j = LazyKt.a(lazyThreadSafetyMode, new Function0<SerialDescriptor[]>() { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$typeParameterDescriptors$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Platform_commonKt.b(this.f55885c.f55872b != null ? new ArrayList(0) : null);
            }
        });
        this.f55881k = LazyKt.a(lazyThreadSafetyMode, new Function0<Integer>() { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$_hashCode$2
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, kotlin.Lazy] */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = this.f55882c;
                return Integer.valueOf(PluginGeneratedSerialDescriptorKt.a(pluginGeneratedSerialDescriptor, (SerialDescriptor[]) pluginGeneratedSerialDescriptor.f55880j.getValue()));
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Map] */
    @Override // kotlinx.serialization.internal.CachedNames
    public final Set a() {
        return this.f55878h.keySet();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean b() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.Map] */
    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int c(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer num = (Integer) this.f55878h.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind d() {
        return StructureKind.CLASS.f55765a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int e() {
        return this.f55873c;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, kotlin.Lazy] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, kotlin.Lazy] */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PluginGeneratedSerialDescriptor) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (Intrinsics.b(this.f55871a, serialDescriptor.i()) && Arrays.equals((SerialDescriptor[]) this.f55880j.getValue(), (SerialDescriptor[]) ((PluginGeneratedSerialDescriptor) obj).f55880j.getValue())) {
                int iE = serialDescriptor.e();
                int i2 = this.f55873c;
                if (i2 == iE) {
                    for (int i3 = 0; i3 < i2; i3++) {
                        if (Intrinsics.b(h(i3).i(), serialDescriptor.h(i3).i()) && Intrinsics.b(h(i3).d(), serialDescriptor.h(i3).d())) {
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
        return this.f55875e[i2];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List g(int i2) {
        List list = this.f55876f[i2];
        return list == null ? EmptyList.f53609a : list;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List getAnnotations() {
        return EmptyList.f53609a;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor h(int i2) {
        return ((KSerializer[]) this.f55879i.getValue())[i2].a();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    public int hashCode() {
        return ((Number) this.f55881k.getValue()).intValue();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String i() {
        return this.f55871a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean j(int i2) {
        return this.f55877g[i2];
    }

    public final void k(String name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        int i2 = this.f55874d + 1;
        this.f55874d = i2;
        String[] strArr = this.f55875e;
        strArr[i2] = name;
        this.f55877g[i2] = z;
        this.f55876f[i2] = null;
        if (i2 == this.f55873c - 1) {
            HashMap map = new HashMap();
            int length = strArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                map.put(strArr[i3], Integer.valueOf(i3));
            }
            this.f55878h = map;
        }
    }

    public String toString() {
        return CollectionsKt.E(RangesKt.f(0, this.f55873c), ", ", e.t(new StringBuilder(), this.f55871a, '('), ")", new Function1<Integer, CharSequence>() { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.toString.1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int iIntValue = ((Number) obj).intValue();
                StringBuilder sb = new StringBuilder();
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = PluginGeneratedSerialDescriptor.this;
                sb.append(pluginGeneratedSerialDescriptor.f55875e[iIntValue]);
                sb.append(": ");
                sb.append(pluginGeneratedSerialDescriptor.h(iIntValue).i());
                return sb.toString();
            }
        }, 24);
    }
}
