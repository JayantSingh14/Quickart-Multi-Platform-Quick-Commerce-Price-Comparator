package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMakerInternalMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@J2ktIncompatible
@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class MapMaker {

    /* renamed from: a, reason: collision with root package name */
    public boolean f42824a;

    /* renamed from: b, reason: collision with root package name */
    public MapMakerInternalMap.Strength.AnonymousClass2 f42825b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Dummy {

        /* renamed from: a, reason: collision with root package name */
        public static final Dummy f42826a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Dummy[] f42827b;

        static {
            Dummy dummy = new Dummy("VALUE", 0);
            f42826a = dummy;
            f42827b = new Dummy[]{dummy};
        }

        public static Dummy valueOf(String str) {
            return (Dummy) Enum.valueOf(Dummy.class, str);
        }

        public static Dummy[] values() {
            return (Dummy[]) f42827b.clone();
        }
    }

    public final ConcurrentMap a() {
        if (!this.f42824a) {
            return new ConcurrentHashMap(16, 0.75f, 4);
        }
        MapMakerInternalMap.AnonymousClass1 anonymousClass1 = MapMakerInternalMap.f42828j;
        MapMakerInternalMap.Strength.AnonymousClass2 anonymousClass2 = this.f42825b;
        MapMakerInternalMap.Strength.AnonymousClass1 anonymousClass12 = MapMakerInternalMap.Strength.f42858a;
        if (((MapMakerInternalMap.Strength) MoreObjects.a(anonymousClass2, anonymousClass12)) == anonymousClass12) {
            return new MapMakerInternalMap(this, MapMakerInternalMap.StrongKeyStrongValueEntry.Helper.f42863a);
        }
        if (((MapMakerInternalMap.Strength) MoreObjects.a(this.f42825b, anonymousClass12)) == MapMakerInternalMap.Strength.f42859b) {
            return new MapMakerInternalMap(this, MapMakerInternalMap.WeakKeyStrongValueEntry.Helper.f42872a);
        }
        throw new AssertionError();
    }

    public final void b() {
        MapMakerInternalMap.Strength.AnonymousClass2 anonymousClass2 = MapMakerInternalMap.Strength.f42859b;
        MapMakerInternalMap.Strength.AnonymousClass2 anonymousClass22 = this.f42825b;
        Preconditions.o(anonymousClass22 == null, "Key strength was already set to %s", anonymousClass22);
        this.f42825b = anonymousClass2;
        this.f42824a = true;
    }

    public final String toString() {
        MoreObjects.ToStringHelper toStringHelperB = MoreObjects.b(this);
        MapMakerInternalMap.Strength.AnonymousClass2 anonymousClass2 = this.f42825b;
        if (anonymousClass2 != null) {
            toStringHelperB.a(Ascii.b(anonymousClass2.toString()), "keyStrength");
        }
        return toStringHelperB.toString();
    }
}
