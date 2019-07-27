package net.schoolmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.schoolmod.blocks.BlockChair;
import net.schoolmod.blocks.BlockDesk;
import net.schoolmod.blocks.BlockGraduatedCylinder;
import net.schoolmod.blocks.TileEntityDesk;
import net.schoolmod.blocks.alphabet.BlockLetterA;
import net.schoolmod.blocks.alphabet.BlockLetterB;
import net.schoolmod.blocks.alphabet.BlockLetterC;
import net.schoolmod.blocks.alphabet.BlockLetterD;
import net.schoolmod.blocks.alphabet.BlockLetterE;
import net.schoolmod.blocks.alphabet.BlockLetterF;
import net.schoolmod.blocks.alphabet.BlockLetterG;
import net.schoolmod.blocks.alphabet.BlockLetterH;
import net.schoolmod.blocks.alphabet.BlockLetterI;
import net.schoolmod.blocks.alphabet.BlockLetterJ;
import net.schoolmod.blocks.alphabet.BlockLetterK;
import net.schoolmod.blocks.alphabet.BlockLetterL;
import net.schoolmod.blocks.alphabet.BlockLetterM;
import net.schoolmod.blocks.alphabet.BlockLetterN;
import net.schoolmod.blocks.alphabet.BlockLetterO;
import net.schoolmod.blocks.alphabet.BlockLetterP;
import net.schoolmod.blocks.alphabet.BlockLetterQ;
import net.schoolmod.blocks.alphabet.BlockLetterR;
import net.schoolmod.blocks.alphabet.BlockLetterS;
import net.schoolmod.blocks.alphabet.BlockLetterT;
import net.schoolmod.blocks.alphabet.BlockLetterU;
import net.schoolmod.blocks.alphabet.BlockLetterV;
import net.schoolmod.blocks.alphabet.BlockLetterW;
import net.schoolmod.blocks.alphabet.BlockLetterX;
import net.schoolmod.blocks.alphabet.BlockLetterY;
import net.schoolmod.blocks.alphabet.BlockLetterZ;
import net.schoolmod.init.BlockInit;
import net.schoolmod.init.ItemInit;
import net.schoolmod.init.TileEntityInit;
import net.schoolmod.items.ItemAlgebraTextbook;
import net.schoolmod.items.ItemAstronomyTextbook;
import net.schoolmod.items.ItemBiologyTextbook;
import net.schoolmod.items.ItemBusinessTextbook;
import net.schoolmod.items.ItemCalculusTextbook;
import net.schoolmod.items.ItemChemistryTextbook;
import net.schoolmod.items.ItemCompositionTextbook;
import net.schoolmod.items.ItemCultureTextbook;
import net.schoolmod.items.ItemGeographyTextbook;
import net.schoolmod.items.ItemGeologyTextbook;
import net.schoolmod.items.ItemGeometryTextbook;
import net.schoolmod.items.ItemLanguageTextbook;
import net.schoolmod.items.ItemLiteratureTextbook;
import net.schoolmod.items.ItemMusicTextbook;
import net.schoolmod.items.ItemPhilosophyTextbook;
import net.schoolmod.items.ItemPhysicsTextbook;
import net.schoolmod.items.ItemPsychologyTextbook;
import net.schoolmod.items.ItemStatisticsTextbook;
import net.schoolmod.proxy.ClientProxy;
import net.schoolmod.proxy.CommonProxy;
import net.schoolmod.proxy.ServerProxy;

@Mod("schoolmod")
public class SchoolMod {
	public static final String modid = "schoolmod";
	private static final Logger LOGGER = LogManager.getLogger();
	
    public static CommonProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);
	
	static final ItemGroup tabSchoolMod = (new ItemGroup("tabSchoolMod") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(BlockInit.desk);
		}
	});
	
	public SchoolMod() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);

		//FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {
		LOGGER.info("Initalizing School Mod!");
		proxy.setup();
	}

	private void loadComplete(final FMLLoadCompleteEvent event) {
        proxy.loadComplete();
    }
	
	/*private void doClientStuff(final FMLClientSetupEvent event) {
	}*/

	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {
		LOGGER.info("School Mod Server Start");
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		@SubscribeEvent
		public static void registerTE(RegistryEvent.Register<TileEntityType<?>> evt) {
			TileEntityInit.DESK = TileEntityType.Builder.create(TileEntityDesk::new, BlockInit.desk).build(null);
			TileEntityInit.DESK.setRegistryName("schoolmod", "desk");
			evt.getRegistry().register(TileEntityInit.DESK);
		}

		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			event.getRegistry().registerAll(
					ItemInit.desk = new BlockItem(BlockInit.desk, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.desk.getRegistryName()),

					ItemInit.graduated_cylinder = new BlockItem(BlockInit.graduated_cylinder,
							new Item.Properties().group(tabSchoolMod))
									.setRegistryName(BlockInit.graduated_cylinder.getRegistryName()),
					ItemInit.chair = new BlockItem(BlockInit.chair, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.chair.getRegistryName()),

					ItemInit.textbook = new Item(new Item.Properties().group(tabSchoolMod))
							.setRegistryName(location("textbook")),
					ItemInit.math_textbook = new Item(new Item.Properties().group(tabSchoolMod))
							.setRegistryName(location("math_textbook")),
					ItemInit.history_textbook = new Item(new Item.Properties().group(tabSchoolMod))
							.setRegistryName(location("history_textbook")),
					ItemInit.science_textbook = new Item(new Item.Properties().group(tabSchoolMod))
							.setRegistryName(location("science_textbook")),
					ItemInit.english_textbook = new Item(new Item.Properties().group(tabSchoolMod))
							.setRegistryName(location("english_textbook")),

					ItemInit.algebra_textbook = new ItemAlgebraTextbook(
							new Item.Properties().group(tabSchoolMod).maxDamage(20 * 30))
									.setRegistryName(location("algebra_textbook")),
					ItemInit.geometry_textbook = new ItemGeometryTextbook(
							new Item.Properties().group(tabSchoolMod).maxDamage(20 * 60))
									.setRegistryName(location("geometry_textbook")),
					ItemInit.statistics_textbook = new ItemStatisticsTextbook(
							new Item.Properties().group(tabSchoolMod).maxDamage(20 * 60 * 5))
									.setRegistryName(location("statistics_textbook")),
					ItemInit.calculus_textbook = new ItemCalculusTextbook(new Item.Properties().group(tabSchoolMod).maxDamage(20 * 60 * 10))
							.setRegistryName(location("calculus_textbook")),
					ItemInit.basic_calculator = new Item(new Item.Properties().group(tabSchoolMod))
							.setRegistryName(location("basic_calculator")),
					ItemInit.graphing_calculator = new Item(new Item.Properties().group(tabSchoolMod))
							.setRegistryName(location("graphing_calculator")),

					ItemInit.chemistry_textbook = new ItemChemistryTextbook(new Item.Properties().group(tabSchoolMod))
							.setRegistryName(location("chemistry_textbook")),
					ItemInit.biology_textbook = new ItemBiologyTextbook(new Item.Properties().group(tabSchoolMod).maxDamage(20 * 60 * 10))
							.setRegistryName(location("biology_textbook")),
					ItemInit.physics_textbook = new ItemPhysicsTextbook(new Item.Properties().group(tabSchoolMod).maxDamage(20 * 15))
							.setRegistryName(location("physics_textbook")),
					ItemInit.astronomy_textbook = new ItemAstronomyTextbook(new Item.Properties().group(tabSchoolMod).maxDamage(20 * 60 * 10))
							.setRegistryName(location("astronomy_textbook")),
					ItemInit.geology_textbook = new ItemGeologyTextbook(
							new Item.Properties().group(tabSchoolMod).maxDamage(20 * 60 * 10))
									.setRegistryName(location("geology_textbook")),

					ItemInit.literature_textbook = new ItemLiteratureTextbook(
							new Item.Properties().group(tabSchoolMod).maxDamage(20 * 60 * 10))
									.setRegistryName(location("literature_textbook")),
					ItemInit.composition_textbook = new ItemCompositionTextbook(
							new Item.Properties().group(tabSchoolMod))
									.setRegistryName(location("composition_textbook")),

					ItemInit.culture_textbook = new ItemCultureTextbook(new Item.Properties().group(tabSchoolMod).maxDamage(20 * 60 * 15))
							.setRegistryName(location("culture_textbook")),
					ItemInit.geography_textbook = new ItemGeographyTextbook(new Item.Properties().group(tabSchoolMod).maxDamage(20 * 60 * 15))
							.setRegistryName(location("geography_textbook")),

					ItemInit.language_textbook = new ItemLanguageTextbook(new Item.Properties().group(tabSchoolMod).maxDamage(20 * 60 * 20))
							.setRegistryName(location("language_textbook")),
					ItemInit.psychology_textbook = new ItemPsychologyTextbook(
							new Item.Properties().group(tabSchoolMod).maxDamage(20 * 60))
									.setRegistryName(location("psychology_textbook")),
					ItemInit.philosophy_textbook = new ItemPhilosophyTextbook(
							new Item.Properties().group(tabSchoolMod).maxDamage(20 * 30))
									.setRegistryName(location("philosophy_textbook")),
					ItemInit.business_textbook = new ItemBusinessTextbook(new Item.Properties().group(tabSchoolMod).maxDamage(20 * 30))
							.setRegistryName(location("business_textbook")),
					ItemInit.music_textbook = new ItemMusicTextbook(new Item.Properties().group(tabSchoolMod).maxDamage(20 * 60 * 20))
							.setRegistryName(location("music_textbook")),

					ItemInit.letter_a = new BlockItem(BlockInit.letter_a, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_a.getRegistryName()),
					ItemInit.letter_b = new BlockItem(BlockInit.letter_b, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_b.getRegistryName()),
					ItemInit.letter_c = new BlockItem(BlockInit.letter_c, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_c.getRegistryName()),
					ItemInit.letter_d = new BlockItem(BlockInit.letter_d, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_d.getRegistryName()),
					ItemInit.letter_e = new BlockItem(BlockInit.letter_e, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_e.getRegistryName()),
					ItemInit.letter_f = new BlockItem(BlockInit.letter_f, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_f.getRegistryName()),
					ItemInit.letter_g = new BlockItem(BlockInit.letter_g, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_g.getRegistryName()),
					ItemInit.letter_h = new BlockItem(BlockInit.letter_h, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_h.getRegistryName()),
					ItemInit.letter_i = new BlockItem(BlockInit.letter_i, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_i.getRegistryName()),
					ItemInit.letter_j = new BlockItem(BlockInit.letter_j, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_j.getRegistryName()),
					ItemInit.letter_k = new BlockItem(BlockInit.letter_k, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_k.getRegistryName()),
					ItemInit.letter_l = new BlockItem(BlockInit.letter_l, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_l.getRegistryName()),
					ItemInit.letter_m = new BlockItem(BlockInit.letter_m, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_m.getRegistryName()),
					ItemInit.letter_n = new BlockItem(BlockInit.letter_n, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_n.getRegistryName()),
					ItemInit.letter_o = new BlockItem(BlockInit.letter_o, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_o.getRegistryName()),
					ItemInit.letter_p = new BlockItem(BlockInit.letter_p, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_p.getRegistryName()),
					ItemInit.letter_q = new BlockItem(BlockInit.letter_q, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_q.getRegistryName()),
					ItemInit.letter_r = new BlockItem(BlockInit.letter_r, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_r.getRegistryName()),
					ItemInit.letter_s = new BlockItem(BlockInit.letter_s, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_s.getRegistryName()),
					ItemInit.letter_t = new BlockItem(BlockInit.letter_t, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_t.getRegistryName()),
					ItemInit.letter_u = new BlockItem(BlockInit.letter_u, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_u.getRegistryName()),
					ItemInit.letter_v = new BlockItem(BlockInit.letter_v, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_v.getRegistryName()),
					ItemInit.letter_w = new BlockItem(BlockInit.letter_w, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_w.getRegistryName()),
					ItemInit.letter_x = new BlockItem(BlockInit.letter_x, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_x.getRegistryName()),
					ItemInit.letter_y = new BlockItem(BlockInit.letter_y, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_y.getRegistryName()),
					ItemInit.letter_z = new BlockItem(BlockInit.letter_z, new Item.Properties().group(tabSchoolMod))
							.setRegistryName(BlockInit.letter_z.getRegistryName()));
		}

		@SubscribeEvent
		public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
			event.getRegistry().registerAll(
					BlockInit.desk = new BlockDesk(Block.Properties.create(Material.WOOD)
							.hardnessAndResistance(1.5f, 1.0f).sound(SoundType.WOOD)).setRegistryName(location("desk")),
					BlockInit.chair = new BlockChair(Block.Properties.create(Material.WOOD)
							.hardnessAndResistance(1.5f, 1.0f).sound(SoundType.WOOD))
									.setRegistryName(location("chair")),

					BlockInit.graduated_cylinder = new BlockGraduatedCylinder(Block.Properties.create(Material.GLASS)
							.hardnessAndResistance(0.5f, 1.0f).sound(SoundType.GLASS))
									.setRegistryName(location("graduated_cylinder")),

					BlockInit.letter_a = new BlockLetterA(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_a")),
					BlockInit.letter_b = new BlockLetterB(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_b")),
					BlockInit.letter_c = new BlockLetterC(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_c")),
					BlockInit.letter_d = new BlockLetterD(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_d")),
					BlockInit.letter_e = new BlockLetterE(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_e")),
					BlockInit.letter_f = new BlockLetterF(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_f")),
					BlockInit.letter_g = new BlockLetterG(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_g")),
					BlockInit.letter_h = new BlockLetterH(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_h")),
					BlockInit.letter_i = new BlockLetterI(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_i")),
					BlockInit.letter_j = new BlockLetterJ(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_j")),
					BlockInit.letter_k = new BlockLetterK(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_k")),
					BlockInit.letter_l = new BlockLetterL(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_l")),
					BlockInit.letter_m = new BlockLetterM(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_m")),
					BlockInit.letter_n = new BlockLetterN(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_n")),
					BlockInit.letter_o = new BlockLetterO(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_o")),
					BlockInit.letter_p = new BlockLetterP(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_p")),
					BlockInit.letter_q = new BlockLetterQ(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_q")),
					BlockInit.letter_r = new BlockLetterR(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_r")),
					BlockInit.letter_s = new BlockLetterS(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_s")),
					BlockInit.letter_t = new BlockLetterT(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_t")),
					BlockInit.letter_u = new BlockLetterU(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_u")),
					BlockInit.letter_v = new BlockLetterV(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_v")),
					BlockInit.letter_w = new BlockLetterW(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_w")),
					BlockInit.letter_x = new BlockLetterX(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_x")),
					BlockInit.letter_y = new BlockLetterY(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_y")),
					BlockInit.letter_z = new BlockLetterZ(Block.Properties.create(Material.SPONGE)
							.hardnessAndResistance(1.0f, 1.0f).sound(SoundType.CLOTH))
									.setRegistryName(location("letter_z"))

			);

		}

		private static ResourceLocation location(String name) {
			return new ResourceLocation(modid, name);
		}
	}
}
