package kotlin.reflect;

import android.support.v4.media.b;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@ExperimentalStdlibApi
@SourceDebugExtension
/* loaded from: classes3.dex */
final class TypeVariableImpl implements TypeVariable<GenericDeclaration>, TypeImpl {

    /* renamed from: a, reason: collision with root package name */
    public final KTypeParameter f53886a;

    public TypeVariableImpl(KTypeParameter typeParameter) {
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        this.f53886a = typeParameter;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TypeVariable)) {
            return false;
        }
        this.f53886a.getClass();
        if (!Intrinsics.b(null, ((TypeVariable) obj).getName())) {
            return false;
        }
        getGenericDeclaration();
        throw null;
    }

    @Override // java.lang.reflect.TypeVariable
    public final Type[] getBounds() {
        List upperBounds = this.f53886a.getUpperBounds();
        ArrayList arrayList = new ArrayList(CollectionsKt.r(upperBounds, 10));
        Iterator it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(TypesJVMKt.b((KType) it.next(), true));
        }
        return (Type[]) arrayList.toArray(new Type[0]);
    }

    @Override // java.lang.reflect.TypeVariable
    public final GenericDeclaration getGenericDeclaration() {
        throw new NotImplementedError(b.C("An operation is not implemented: ", "getGenericDeclaration() is not yet supported for type variables created from KType: " + this.f53886a));
    }

    @Override // java.lang.reflect.TypeVariable
    public final String getName() {
        this.f53886a.getClass();
        return null;
    }

    @Override // java.lang.reflect.Type
    public final String getTypeName() {
        this.f53886a.getClass();
        return null;
    }

    public final int hashCode() {
        this.f53886a.getClass();
        throw null;
    }

    public final String toString() {
        this.f53886a.getClass();
        return null;
    }
}
