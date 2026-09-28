package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
final class InactiveNodeList implements Incomplete {

    /* renamed from: a, reason: collision with root package name */
    public final NodeList f54114a;

    public InactiveNodeList(NodeList nodeList) {
        this.f54114a = nodeList;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final boolean a() {
        return false;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final NodeList c() {
        return this.f54114a;
    }
}
