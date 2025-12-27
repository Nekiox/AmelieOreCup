package fr.nekiox.mineral.DeathAnimations.Animations;

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.effect.*;
import fr.nekiox.mineral.DeathAnimations.EffectAnimation;
import org.bukkit.Material;

public class HeartAnimation extends EffectAnimation {

    @Override
    public String getAnimationName() {
        return "Araignée d'eau";
    }

    @Override
    public Material getIcone() {
        return Material.APPLE;
    }

    @Override
    protected Class getEffectClass() {
        return ImageEffect.class;
    }

    @Override
    public int getDuration() {
        return 5;
    }

    @Override
    public int getHeighOffset() {
        return 0;
    }

    @Override
    public void applyCustomSettings(Effect e) {

    }
}
