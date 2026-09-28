package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MessageLite;

/* loaded from: classes3.dex */
public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {
    static {
        ExtensionRegistryLite.a();
    }
}
