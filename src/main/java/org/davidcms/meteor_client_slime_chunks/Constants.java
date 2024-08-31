package org.davidcms.meteor_client_slime_chunks;

import com.mojang.logging.LogUtils;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;

public class Constants {

    public static final String MOD_ID = "meteor_client_slime_chunks";
    public static final Logger LOG = LogUtils.getLogger();

    public static Identifier getModIdentifierOf(String id) {
        return Identifier.of(MOD_ID, id);
    }
}
