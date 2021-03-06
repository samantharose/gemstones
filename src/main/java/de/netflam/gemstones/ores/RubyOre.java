package de.netflam.gemstones.ores;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class RubyOre extends Block {

    private static final RubyOre RUBY_ORE = new RubyOre();

    private RubyOre() {
        super(FabricBlockSettings.of(Material.STONE)
                .requiresTool()
                .breakByHand(false)
                .breakByTool(FabricToolTags.PICKAXES, 2)
                .hardness(5f)
                .resistance(1.5f)
        );
    }


    //Ruby Ore ore generation settings
    public static ConfiguredFeature<?, ?> getConfiguredOreFeature() {
        return Feature.ORE
                .configure(new OreFeatureConfig(
                        OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                        RUBY_ORE.getDefaultState(),
                        6))
                .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                        0,
                        0,
                        64)))
                .spreadHorizontally()
                .repeat(5);
    }

    public static RubyOre getOre() {
        return RUBY_ORE;
    }
}
