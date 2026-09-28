package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;

@CheckReturnValue
/* loaded from: classes3.dex */
public interface MessageLite extends MessageLiteOrBuilder {

    public interface Builder extends MessageLiteOrBuilder, Cloneable {
        MessageLite Z();
    }

    GeneratedMessageLite.Builder a();

    ByteString b();

    int c();

    GeneratedMessageLite.Builder e();

    void g(CodedOutputStream codedOutputStream);
}
