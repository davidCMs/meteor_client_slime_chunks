package org.davidcms.meteor_client_slime_chunks.modules;

import meteordevelopment.meteorclient.events.render.Render3DEvent;
import meteordevelopment.meteorclient.renderer.ShapeMode;
import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.modules.Categories;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.utils.render.color.Color;
import meteordevelopment.meteorclient.utils.render.color.SettingColor;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;

public class ModuleExample extends Module{
    private final SettingGroup sgGeneral = this.settings.getDefaultGroup();
    private final SettingGroup sgRender = this.settings.createGroup("Render");

    private final Setting<String> seed = sgGeneral.add(new StringSetting.Builder()
            .name("World seed")
            .description("The seed of the world")
            .defaultValue("696969420420")
            .build()
    );

    private final Setting<Integer> y_stretch = sgGeneral.add(new IntSetting.Builder()
            .name("Y Stretch")
            .description("The Y Stretch of the marker.")
            .defaultValue(100)
            .range(-64, 320)
            .build()
    );

    private final Setting<SettingColor> color = sgRender.add(new ColorSetting.Builder()
            .name("color")
            .description("The color of the marker.")
            .defaultValue(Color.GREEN)
            .build()
    );

    public ModuleExample() {
        super(Categories.Render, "Show Slime Chunks", "An module that highlights slime chunks given a seed");
    }

    @EventHandler
    private void onRender3d(Render3DEvent event) {



        Box marker = new Box(new BlockPos(BlockPos.ORIGIN));
        marker.stretch(
                16 * marker.getLengthX(),
                y_stretch.get() * marker.getLengthY(),
                16 * marker.getLengthZ()
        );

        event.renderer.box(marker, color.get(), color.get(), ShapeMode.Both, 0);
    }
}
