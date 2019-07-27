package net.schoolmod.blocks.alphabet;

import java.util.ArrayList;
import java.util.Arrays;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.monster.GiantEntity;
import net.minecraft.entity.monster.HuskEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.monster.StrayEntity;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.entity.monster.WitchEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.PandaEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.passive.horse.LlamaEntity;
import net.minecraft.entity.passive.horse.MuleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WordFinder {

	public static ArrayList<String> bigListOfWords = new ArrayList<String>(Arrays.asList("CAT", "DOG", "WOLF", "TREE",
			"COW", "SHEEP", "HORSE", "ENDER", "FISH", "BOAT", "STONE", "PIG", "ANVIL", "BELL", "BIRCH", "BLUE", "RED",
			"BLACK", "BROWN", "CYAN", "GREEN", "LIME", "BRICK", "CAKE", "STRAY", "CHEST", "CLAY", "COAL", "IRON",
			"GOLD", "LAPIS", "COCOA", "DIRT", "GRASS", "HEAD", "FERN", "FIRE", "POT", "GLASS", "HAY", "WHEAT", "ICE",
			"KELP", "LAVA", "LEVER", "LILAC", "WATER", "LILY", "LOOM", "WITCH", "MELON", "OAK", "CRAFT", "PEONY",
			"POPPY", "RAIL", "SAND", "SNOW", "SUGAR", "TNT", "TORCH", "VINES", "BOOK", "EGG", "EYE", "LEAD", "SEEDS",
			"APPLE", "ARROW", "BONE", "BOWL", "BREAD", "COD", "MAP", "MULE", "INK", "MILK", "SLICE", "MELON", "BEEF",
			"FLESH", "STEAK", "TOTEM", "BLAZE", "CLOCK", "FLINT", "TEAR", "GHAST", "PAPER", "STICK", "VEX", "BAT",
			"SQUID", "LLAMA", "PANDA", "BEAR", "HUSK", "SLIME", "FOX", "GOLEM", "BUNNY", "GIANT", "TOWER"));

	public static void whatToDo(String word, World w, PlayerEntity p, BlockPos pos) {
		System.out.println(word);
		// DO
		switch (word.toLowerCase()) {
		case "tree":
			for (int x = 0; x < 5; x++) {
				w.setBlockState(new BlockPos(pos.getX(), pos.getY() + x, pos.getZ()), Blocks.OAK_LOG.getDefaultState());
			}
			w.setBlockState(new BlockPos(pos.getX(), pos.getY() + 5, pos.getZ()), Blocks.OAK_LEAVES.getDefaultState());
			w.setBlockState(new BlockPos(pos.getX(), pos.getY() + 6, pos.getZ()), Blocks.OAK_LEAVES.getDefaultState());

			w.setBlockState(new BlockPos(pos.getX() - 1, pos.getY() + 5, pos.getZ()),
					Blocks.OAK_LEAVES.getDefaultState());
			w.setBlockState(new BlockPos(pos.getX() - 1, pos.getY() + 6, pos.getZ()),
					Blocks.OAK_LEAVES.getDefaultState());

			w.setBlockState(new BlockPos(pos.getX() + 1, pos.getY() + 5, pos.getZ()),
					Blocks.OAK_LEAVES.getDefaultState());
			w.setBlockState(new BlockPos(pos.getX() + 1, pos.getY() + 6, pos.getZ()),
					Blocks.OAK_LEAVES.getDefaultState());

			w.setBlockState(new BlockPos(pos.getX(), pos.getY() + 5, pos.getZ() + 1),
					Blocks.OAK_LEAVES.getDefaultState());
			w.setBlockState(new BlockPos(pos.getX(), pos.getY() + 6, pos.getZ() + 1),
					Blocks.OAK_LEAVES.getDefaultState());

			w.setBlockState(new BlockPos(pos.getX(), pos.getY() + 5, pos.getZ() - 1),
					Blocks.OAK_LEAVES.getDefaultState());
			w.setBlockState(new BlockPos(pos.getX(), pos.getY() + 6, pos.getZ() - 1),
					Blocks.OAK_LEAVES.getDefaultState());

			w.setBlockState(new BlockPos(pos.getX() + 1, pos.getY() + 5, pos.getZ() + 1),
					Blocks.OAK_LEAVES.getDefaultState());
			w.setBlockState(new BlockPos(pos.getX() - 1, pos.getY() + 5, pos.getZ() - 1),
					Blocks.OAK_LEAVES.getDefaultState());
			w.setBlockState(new BlockPos(pos.getX() - 1, pos.getY() + 5, pos.getZ() + 1),
					Blocks.OAK_LEAVES.getDefaultState());
			w.setBlockState(new BlockPos(pos.getX() + 1, pos.getY() + 5, pos.getZ() - 1),
					Blocks.OAK_LEAVES.getDefaultState());

			break;
		case "cat":
			CatEntity cat = new CatEntity(EntityType.CAT, w);
			cat.setPosition(pos.getX(), pos.getY(), pos.getZ());
			cat.setOwnerId(p.getUniqueID());
			w.addEntity(cat);
			break;
		case "dog":
			WolfEntity dog = new WolfEntity(EntityType.WOLF, w);
			dog.setPosition(pos.getX(), pos.getY(), pos.getZ());
			dog.setOwnerId(p.getUniqueID());
			w.addEntity(dog);
			break;
		case "wolf":
			WolfEntity dog2 = new WolfEntity(EntityType.WOLF, w);
			dog2.setPosition(pos.getX(), pos.getY(), pos.getZ());
			dog2.setOwnerId(p.getUniqueID());
			w.addEntity(dog2);
			break;
		case "cow":
			CowEntity cow = new CowEntity(EntityType.COW, w);
			cow.setPosition(pos.getX(), pos.getY(), pos.getZ());
			w.addEntity(cow);
			break;
		case "sheep":
			SheepEntity sheep = new SheepEntity(EntityType.SHEEP, w);
			sheep.setPosition(pos.getX(), pos.getY(), pos.getZ());
			w.addEntity(sheep);
			break;
		case "horse":
			HorseEntity horse = new HorseEntity(EntityType.HORSE, w);
			horse.setPosition(pos.getX(), pos.getY(), pos.getZ());
			w.addEntity(horse);
			break;
		case "ender":
			EndermanEntity ender = new EndermanEntity(EntityType.ENDERMAN, w);
			ender.setPosition(pos.getX(), pos.getY(), pos.getZ());
			w.addEntity(ender);
			break;
		case "fish":
			TropicalFishEntity fish = new TropicalFishEntity(EntityType.TROPICAL_FISH, w);
			fish.setPosition(pos.getX(), pos.getY(), pos.getZ());
			w.addEntity(fish);
			break;
		case "boat":
			BoatEntity boat = new BoatEntity(EntityType.BOAT, w);
			boat.setPosition(pos.getX(), pos.getY(), pos.getZ());
			w.addEntity(boat);
			break;
		case "stone":
			w.setBlockState(pos, Blocks.STONE.getDefaultState());
			break;
		case "pig":
			PigEntity pig = new PigEntity(EntityType.PIG, w);
			pig.setPosition(pos.getX(), pos.getY(), pos.getZ());
			w.addEntity(pig);
			break;
		case "anvil":
			w.setBlockState(pos, Blocks.ANVIL.getDefaultState());
			break;
		case "bell":
			w.setBlockState(pos, Blocks.BELL.getDefaultState());
			break;
		case "birch":
			w.setBlockState(pos, Blocks.BIRCH_LOG.getDefaultState());
			break;
		case "blue":
			w.setBlockState(pos, Blocks.BLUE_WOOL.getDefaultState());
			break;
		case "red":
			w.setBlockState(pos, Blocks.RED_WOOL.getDefaultState());
			break;
		case "black":
			w.setBlockState(pos, Blocks.BLACK_WOOL.getDefaultState());
			break;
		case "brown":
			w.setBlockState(pos, Blocks.BROWN_WOOL.getDefaultState());
			break;
		case "cyan":
			w.setBlockState(pos, Blocks.CYAN_WOOL.getDefaultState());
			break;
		case "green":
			w.setBlockState(pos, Blocks.GREEN_WOOL.getDefaultState());
			break;
		case "lime":
			w.setBlockState(pos, Blocks.LIME_WOOL.getDefaultState());
			break;
		case "brick":
			w.setBlockState(pos, Blocks.BRICKS.getDefaultState());
			break;
		case "cake":
			w.setBlockState(pos, Blocks.CAKE.getDefaultState());
			break;
		case "stray":
			StrayEntity stray = new StrayEntity(EntityType.STRAY, w);
			stray.setPosition(pos.getX(), pos.getY(), pos.getZ());
			w.addEntity(stray);
			break;
		case "chest":
			w.setBlockState(pos, Blocks.CHEST.getDefaultState());
			break;
		case "clay":
			w.setBlockState(pos, Blocks.CLAY.getDefaultState());
			break;
		case "coal":
			w.setBlockState(pos, Blocks.COAL_BLOCK.getDefaultState());
			break;
		case "iron":
			w.setBlockState(pos, Blocks.IRON_BLOCK.getDefaultState());
			break;
		case "gold":
			w.setBlockState(pos, Blocks.GOLD_BLOCK.getDefaultState());
			break;
		case "lapis":
			w.setBlockState(pos, Blocks.LAPIS_BLOCK.getDefaultState());
			break;
		case "cocoa":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.COCOA_BEANS)));
			break;
		case "dirt":
			w.setBlockState(pos, Blocks.DIRT.getDefaultState());
			break;
		case "grass":
			w.setBlockState(pos, Blocks.GRASS_BLOCK.getDefaultState());
			break;
		case "head":
			w.setBlockState(pos, Blocks.PLAYER_HEAD.getDefaultState());
			break;
		case "fern":
			w.setBlockState(pos, Blocks.FERN.getDefaultState());
			break;
		case "fire":
			w.setBlockState(pos, Blocks.FIRE.getDefaultState());
			break;
		case "pot":
			w.setBlockState(pos, Blocks.FLOWER_POT.getDefaultState());
			break;
		case "glass":
			w.setBlockState(pos, Blocks.GLASS.getDefaultState());
			break;
		case "hay":
			w.setBlockState(pos, Blocks.HAY_BLOCK.getDefaultState());
			break;
		case "wheat":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.WHEAT)));
			break;
		case "ice":
			w.setBlockState(pos, Blocks.ICE.getDefaultState());
			break;
		case "kelp":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.KELP)));
			break;
		case "lava":
			w.setBlockState(pos, Blocks.LAVA.getDefaultState());
			break;
		case "lever":
			w.setBlockState(pos, Blocks.LEVER.getDefaultState());
			break;
		case "lilac":
			w.setBlockState(pos, Blocks.LILAC.getDefaultState());
			break;
		case "water":
			w.setBlockState(pos, Blocks.WATER.getDefaultState());
			break;
		case "lily":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.LILY_PAD)));
			break;
		case "loom":
			w.setBlockState(pos, Blocks.LOOM.getDefaultState());
			break;
		case "witch":
			WitchEntity witch = new WitchEntity(EntityType.WITCH, w);
			witch.setPosition(pos.getX(), pos.getY(), pos.getZ());
			w.addEntity(witch);
			break;
		case "melon":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.MELON)));
			break;
		case "oak":
			w.setBlockState(pos, Blocks.OAK_LOG.getDefaultState());
			break;
		case "craft":
			w.setBlockState(pos, Blocks.CRAFTING_TABLE.getDefaultState());
			break;
		case "peony":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.PEONY)));
			break;
		case "poppy":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.POPPY)));
			break;
		case "rail":
			w.setBlockState(pos, Blocks.RAIL.getDefaultState());
			break;
		case "sand":
			w.setBlockState(pos, Blocks.SAND.getDefaultState());
			break;
		case "snow":
			w.setBlockState(pos, Blocks.SNOW_BLOCK.getDefaultState());
			break;
		case "sugar":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.SUGAR)));
			break;
		case "tnt":
			w.setBlockState(pos, Blocks.TNT.getDefaultState());
			break;
		case "torch":
			w.setBlockState(pos, Blocks.TORCH.getDefaultState());
			break;
		case "vines":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.VINE)));
			break;
		case "book":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.BOOK)));
			break;
		case "egg":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.EGG)));
			break;
		case "eye":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.ENDER_EYE)));
			break;
		case "lead":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.LEAD)));
			break;
		case "seeds":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.WHEAT_SEEDS)));
			break;
		case "apple":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.APPLE)));
			break;
		case "arrow":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.ARROW)));
			break;
		case "bone":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.BONE)));
			break;
		case "bowl":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.BOWL)));
			break;
		case "bread":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.BREAD)));
			break;
		case "cod":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.COD)));
			break;
		case "map":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.MAP)));
			break;
		case "mule":
			MuleEntity mule = new MuleEntity(EntityType.MULE, w);
			mule.setPosition(pos.getX(), pos.getY(), pos.getZ());
			w.addEntity(mule);
			break;
		case "ink":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.INK_SAC)));
			break;
		case "milk":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.MILK_BUCKET)));
			break;
		case "slice":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.MELON_SLICE)));
			break;
		case "beef":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.BEEF)));
			break;
		case "flesh":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.ROTTEN_FLESH)));
			break;
		case "steak":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.COOKED_BEEF)));
			break;
		case "totem":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.TOTEM_OF_UNDYING)));
			break;
		case "blaze":
			BlazeEntity blaze = new BlazeEntity(EntityType.BLAZE, w);
			blaze.setPosition(pos.getX(), pos.getY(), pos.getZ());
			w.addEntity(blaze);
			break;
		case "clock":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.CLOCK)));
			break;
		case "flint":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.FLINT)));
			break;
		case "tear":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.GHAST_TEAR)));
			break;
		case "ghast":
			GhastEntity ghast = new GhastEntity(EntityType.GHAST, w);
			ghast.setPosition(pos.getX(), pos.getY(), pos.getZ());
			w.addEntity(ghast);
			break;
		case "paper":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.PAPER)));
			break;
		case "stick":
			w.addEntity(new ItemEntity(w, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(),
					new ItemStack(Items.STICK)));
			break;
		case "vex":
			VexEntity vex = new VexEntity(EntityType.VEX, w);
			vex.setPosition(pos.getX(), pos.getY(), pos.getZ());
			w.addEntity(vex);
			break;
		case "bat":
			BatEntity bat = new BatEntity(EntityType.BAT, w);
			bat.setPosition(pos.getX(), pos.getY(), pos.getZ());
			w.addEntity(bat);
			break;
		case "squid":
			SquidEntity squid = new SquidEntity(EntityType.SQUID, w);
			squid.setPosition(pos.getX(), pos.getY(), pos.getZ());
			w.addEntity(squid);
			break;
		case "llama":
			LlamaEntity llama = new LlamaEntity(EntityType.LLAMA, w);
			llama.setPosition(pos.getX(), pos.getY(), pos.getZ());
			w.addEntity(llama);
			break;
		case "panda":
			PandaEntity panda = new PandaEntity(EntityType.PANDA, w);
			panda.setPosition(pos.getX(), pos.getY(), pos.getZ());
			w.addEntity(panda);
			break;
		case "bear":
			PolarBearEntity bear = new PolarBearEntity(EntityType.POLAR_BEAR, w);
			bear.setPosition(pos.getX(), pos.getY(), pos.getZ());
			w.addEntity(bear);
			break;
		case "husk":
			HuskEntity husk = new HuskEntity(EntityType.HUSK, w);
			husk.setPosition(pos.getX(), pos.getY(), pos.getZ());
			w.addEntity(husk);
			break;
		case "slime":
			SlimeEntity slime = new SlimeEntity(EntityType.SLIME, w);
			slime.setPosition(pos.getX(), pos.getY(), pos.getZ());
			w.addEntity(slime);
			break;
		case "fox":
			FoxEntity fox = new FoxEntity(EntityType.FOX, w);
			fox.setPosition(pos.getX(), pos.getY(), pos.getZ());
			w.addEntity(fox);
			break;
		case "golem":
			IronGolemEntity golem = new IronGolemEntity(EntityType.IRON_GOLEM, w);
			golem.setPosition(pos.getX(), pos.getY(), pos.getZ());
			w.addEntity(golem);
			break;
		case "bunny":
			RabbitEntity bunny = new RabbitEntity(EntityType.RABBIT, w);
			bunny.setPosition(pos.getX(), pos.getY(), pos.getZ());
			w.addEntity(bunny);
			break;
		case "giant":
			GiantEntity giant = new GiantEntity(EntityType.GIANT, w);
			giant.setPosition(pos.getX(), pos.getY(), pos.getZ());
			w.addEntity(giant);
			break;
		case "tower":
			for (int x = 0; x < 100; x++) {
				if (pos.getY() + x < 255) {
					w.setBlockState(new BlockPos(pos.getX(), pos.getY() + x, pos.getZ()),
							Blocks.STONE_BRICKS.getDefaultState());
				}
			}
			break;
		default:
			break;
		}

	}

}
