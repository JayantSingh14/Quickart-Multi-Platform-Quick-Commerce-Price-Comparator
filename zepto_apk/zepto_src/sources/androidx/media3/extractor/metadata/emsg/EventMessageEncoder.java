package androidx.media3.extractor.metadata.emsg;

import androidx.media3.common.util.UnstableApi;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@UnstableApi
/* loaded from: classes3.dex */
public final class EventMessageEncoder {

    /* renamed from: a, reason: collision with root package name */
    public final ByteArrayOutputStream f8776a;

    /* renamed from: b, reason: collision with root package name */
    public final DataOutputStream f8777b;

    public EventMessageEncoder() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f8776a = byteArrayOutputStream;
        this.f8777b = new DataOutputStream(byteArrayOutputStream);
    }

    public final byte[] a(EventMessage eventMessage) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = this.f8776a;
        byteArrayOutputStream.reset();
        DataOutputStream dataOutputStream = this.f8777b;
        try {
            dataOutputStream.writeBytes(eventMessage.f8770a);
            dataOutputStream.writeByte(0);
            String str = eventMessage.f8771b;
            if (str == null) {
                str = "";
            }
            dataOutputStream.writeBytes(str);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeLong(eventMessage.f8772c);
            dataOutputStream.writeLong(eventMessage.f8773d);
            dataOutputStream.write(eventMessage.f8774e);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
