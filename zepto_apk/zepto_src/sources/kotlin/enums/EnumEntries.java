package kotlin.enums;

import java.lang.Enum;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.markers.KMappedMarker;

@SinceKotlin
@Metadata
@WasExperimental
/* loaded from: classes.dex */
public interface EnumEntries<E extends Enum<E>> extends List<E>, KMappedMarker {
}
