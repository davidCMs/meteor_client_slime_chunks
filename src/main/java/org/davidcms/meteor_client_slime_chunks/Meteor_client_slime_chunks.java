package org.davidcms.meteor_client_slime_chunks;

import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.modules.Modules;
import org.davidcms.meteor_client_slime_chunks.modules.SlimeChunkModule;

public class Meteor_client_slime_chunks extends MeteorAddon {

    @Override
    public void onInitialize() {
        Modules.get().add(new SlimeChunkModule());
    }

    @Override
    public String getPackage() {
        return "org.davidcms.meteor_client_slime_chunks";
    }
}
