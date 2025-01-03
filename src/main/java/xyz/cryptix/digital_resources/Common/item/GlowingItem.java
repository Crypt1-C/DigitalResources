package xyz.cryptix.digital_resources.Common.item;

import net.minecraft.world.item.Item;

import java.awt.*;

public class GlowingItem extends Item /*implements IGlowItem, ParticleEmitterHandler.ItemParticleSupplier*/ {
    private final Color startColor;
    private final Color endColor;

    public GlowingItem(Properties pProperties, Color startColor, Color endColor) {
        super(pProperties);
        this.startColor = startColor;
        this.endColor = startColor;
    }

    /*
    @Override
    public Color getStartColor() {
        return startColor;
    }

    @Override
    public Color getEndColor() {
        return endColor;
    }

    @Override
    public void spawnParticles(HashMap<LodestoneScreenParticleRenderType, ArrayList<ScreenParticle>> target, Level level, float partialTick, ItemStack stack, float x, float y) {
        if (ClientConfig.GLOW_EFFECT.getConfigValue()) {
            ScreenParticleEffects.spawnGlowScreenParticles(target, startColor, endColor, stack, x, y);
        }
    }
    */
}
