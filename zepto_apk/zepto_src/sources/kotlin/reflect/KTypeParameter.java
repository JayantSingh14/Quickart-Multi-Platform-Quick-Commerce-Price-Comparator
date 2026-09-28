package kotlin.reflect;

import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;

@SinceKotlin
@Metadata
/* loaded from: classes3.dex */
public interface KTypeParameter extends KClassifier {
    List getUpperBounds();
}
