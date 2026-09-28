package androidx.datastore.preferences.protobuf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class ProtoSyntax {

    /* renamed from: a, reason: collision with root package name */
    public static final ProtoSyntax f4108a;

    /* renamed from: b, reason: collision with root package name */
    public static final ProtoSyntax f4109b;

    /* renamed from: c, reason: collision with root package name */
    public static final ProtoSyntax f4110c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ ProtoSyntax[] f4111d;

    static {
        ProtoSyntax protoSyntax = new ProtoSyntax("PROTO2", 0);
        f4108a = protoSyntax;
        ProtoSyntax protoSyntax2 = new ProtoSyntax("PROTO3", 1);
        f4109b = protoSyntax2;
        ProtoSyntax protoSyntax3 = new ProtoSyntax("EDITIONS", 2);
        f4110c = protoSyntax3;
        f4111d = new ProtoSyntax[]{protoSyntax, protoSyntax2, protoSyntax3};
    }

    public static ProtoSyntax valueOf(String str) {
        return (ProtoSyntax) java.lang.Enum.valueOf(ProtoSyntax.class, str);
    }

    public static ProtoSyntax[] values() {
        return (ProtoSyntax[]) f4111d.clone();
    }
}
