package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class SerializedCollection implements Externalizable {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Companion f53668b = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public Object f53669a;

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public SerializedCollection() {
        EmptyList collection = EmptyList.f53609a;
        Intrinsics.checkNotNullParameter(collection, "collection");
        this.f53669a = collection;
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput input) throws IOException {
        Object objJ;
        Intrinsics.checkNotNullParameter(input, "input");
        byte b2 = input.readByte();
        int i2 = b2 & 1;
        if ((b2 & (-2)) != 0) {
            throw new InvalidObjectException("Unsupported flags value: " + ((int) b2) + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
        int i3 = input.readInt();
        if (i3 < 0) {
            throw new InvalidObjectException("Illegal size value: " + i3 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
        int i4 = 0;
        if (i2 == 0) {
            ListBuilder builder = new ListBuilder(i3);
            while (i4 < i3) {
                builder.add(input.readObject());
                i4++;
            }
            Intrinsics.checkNotNullParameter(builder, "builder");
            objJ = builder.j();
        } else {
            if (i2 != 1) {
                throw new InvalidObjectException("Unsupported collection type tag: " + i2 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
            }
            SetBuilder setBuilder = new SetBuilder(new MapBuilder(i3));
            while (i4 < i3) {
                setBuilder.add(input.readObject());
                i4++;
            }
            objJ = SetsKt.a(setBuilder);
        }
        this.f53669a = objJ;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, java.util.Collection] */
    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput output) throws IOException {
        Intrinsics.checkNotNullParameter(output, "output");
        output.writeByte(0);
        output.writeInt(this.f53669a.size());
        Iterator it = this.f53669a.iterator();
        while (it.hasNext()) {
            output.writeObject(it.next());
        }
    }
}
