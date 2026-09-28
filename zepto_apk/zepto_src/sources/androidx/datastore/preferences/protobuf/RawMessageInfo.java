package androidx.datastore.preferences.protobuf;

@CheckReturnValue
/* loaded from: classes3.dex */
final class RawMessageInfo implements MessageInfo {

    /* renamed from: a, reason: collision with root package name */
    public final MessageLite f4118a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4119b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f4120c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4121d;

    public RawMessageInfo(MessageLite messageLite, String str, Object[] objArr) {
        this.f4118a = messageLite;
        this.f4119b = str;
        this.f4120c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f4121d = cCharAt;
            return;
        }
        int i2 = cCharAt & 8191;
        int i3 = 1;
        int i4 = 13;
        while (true) {
            int i5 = i3 + 1;
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 < 55296) {
                this.f4121d = i2 | (cCharAt2 << i4);
                return;
            } else {
                i2 |= (cCharAt2 & 8191) << i4;
                i4 += 13;
                i3 = i5;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.MessageInfo
    public final boolean a() {
        return (this.f4121d & 2) == 2;
    }

    @Override // androidx.datastore.preferences.protobuf.MessageInfo
    public final MessageLite b() {
        return this.f4118a;
    }

    @Override // androidx.datastore.preferences.protobuf.MessageInfo
    public final ProtoSyntax c() {
        int i2 = this.f4121d;
        return (i2 & 1) != 0 ? ProtoSyntax.f4108a : (i2 & 4) == 4 ? ProtoSyntax.f4110c : ProtoSyntax.f4109b;
    }
}
