package kotlinx.serialization.descriptors;

import android.support.v4.media.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ClassSerialDescriptorBuilder {

    /* renamed from: a, reason: collision with root package name */
    public final String f55720a;

    /* renamed from: b, reason: collision with root package name */
    public EmptyList f55721b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f55722c;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f55723d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f55724e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f55725f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f55726g;

    public ClassSerialDescriptorBuilder(String serialName) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        this.f55720a = serialName;
        this.f55721b = EmptyList.f53609a;
        this.f55722c = new ArrayList();
        this.f55723d = new HashSet();
        this.f55724e = new ArrayList();
        this.f55725f = new ArrayList();
        this.f55726g = new ArrayList();
    }

    public final void a(String elementName, SerialDescriptor descriptor, List annotations, boolean z) {
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        if (!this.f55723d.add(elementName)) {
            StringBuilder sbY = b.y("Element with name '", elementName, "' is already registered in ");
            sbY.append(this.f55720a);
            throw new IllegalArgumentException(sbY.toString().toString());
        }
        this.f55722c.add(elementName);
        this.f55724e.add(descriptor);
        this.f55725f.add(annotations);
        this.f55726g.add(Boolean.valueOf(z));
    }
}
