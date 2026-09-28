package kotlinx.serialization.descriptors;

import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface SerialDescriptor {

    @Metadata
    public static final class DefaultImpls {
    }

    boolean b();

    int c(String str);

    SerialKind d();

    int e();

    String f(int i2);

    List g(int i2);

    List getAnnotations();

    SerialDescriptor h(int i2);

    String i();

    boolean isInline();

    boolean j(int i2);
}
