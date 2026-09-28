package kotlin.collections.builders;

import android.support.v4.media.b;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
final class SerializedMap implements Externalizable {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Companion f53670b = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public Object f53671a;

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public SerializedMap() {
        Map map = MapsKt.c();
        Intrinsics.checkNotNullParameter(map, "map");
        this.f53671a = map;
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput input) throws IOException {
        Intrinsics.checkNotNullParameter(input, "input");
        byte b2 = input.readByte();
        if (b2 != 0) {
            throw new InvalidObjectException(b.f(b2, "Unsupported flags value: "));
        }
        int i2 = input.readInt();
        if (i2 < 0) {
            throw new InvalidObjectException("Illegal size value: " + i2 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
        MapBuilder builder = new MapBuilder(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            builder.put(input.readObject(), input.readObject());
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f53671a = builder.b();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, java.util.Map] */
    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput output) throws IOException {
        Intrinsics.checkNotNullParameter(output, "output");
        output.writeByte(0);
        output.writeInt(this.f53671a.size());
        for (Map.Entry entry : this.f53671a.entrySet()) {
            output.writeObject(entry.getKey());
            output.writeObject(entry.getValue());
        }
    }
}
