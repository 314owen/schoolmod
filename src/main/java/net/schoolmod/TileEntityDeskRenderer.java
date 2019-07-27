package net.schoolmod;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Direction;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.schoolmod.blocks.BlockDesk;
import net.schoolmod.blocks.TileEntityDesk;
import net.schoolmod.init.ItemInit;

public class TileEntityDeskRenderer extends TileEntityRenderer<TileEntityDesk> {

	@Override
	public void render(TileEntityDesk te, double x, double y, double z, float partialTicks, int destroyStage) {
		super.render(te, x, y, z, partialTicks, destroyStage);

		Direction d = ((BlockState) te.getBlockState()).get(((BlockDesk) te.getBlockState().getBlock()).FACING);
		LazyOptional<IItemHandler> l = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);

		switch (d) {
		case EAST:
			l.ifPresent(h -> {
				if (DeskRecipeManager.testRecipe(h).getItem() != Items.AIR) {
					ItemStack i = new ItemStack(DeskRecipeManager.testRecipe(h));

					GameRenderer.drawNameplate(this.getFontRenderer(),
							new TranslationTextComponent(i.getTranslationKey(), new Object[0]).getString().toString(),
							(float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F, 0, 90F, 0, false);
				}

			});

			GlStateManager.pushMatrix();
			GlStateManager.translated(x + 0.4, y + 1, z + 0.5);
			GlStateManager.rotated(90F, 1, 0, 0);
			GlStateManager.rotated(90F, 0, 0, 1);
			RenderHelper.enableStandardItemLighting();
			l.ifPresent(h -> {
				Minecraft.getInstance().getItemRenderer().renderItem(h.getStackInSlot(0),
						ItemCameraTransforms.TransformType.GROUND);
			});
			RenderHelper.disableStandardItemLighting();
			GlStateManager.popMatrix();

			GlStateManager.pushMatrix();
			GlStateManager.translated(x + 0.8, y + 1, z + 0.7);
			GlStateManager.rotated(90F, 1, 0, 0);
			GlStateManager.rotated(90F, 0, 0, 1);
			RenderHelper.enableStandardItemLighting();
			l.ifPresent(h -> {
				Minecraft.getInstance().getItemRenderer().renderItem(h.getStackInSlot(1),
						ItemCameraTransforms.TransformType.GROUND);
			});
			RenderHelper.disableStandardItemLighting();
			GlStateManager.popMatrix();

			GlStateManager.pushMatrix();
			GlStateManager.translated(x + 0.8, y + 1, z + 0.3);
			GlStateManager.rotated(90F, 1, 0, 0);
			GlStateManager.rotated(90F, 0, 0, 1);
			RenderHelper.enableStandardItemLighting();
			l.ifPresent(h -> {
				Minecraft.getInstance().getItemRenderer().renderItem(h.getStackInSlot(2),
						ItemCameraTransforms.TransformType.GROUND);
			});
			RenderHelper.disableStandardItemLighting();
			GlStateManager.popMatrix();
			break;
		case WEST:

			l.ifPresent(h -> {
				if (DeskRecipeManager.testRecipe(h).getItem() != Items.AIR) {
					ItemStack i = new ItemStack(DeskRecipeManager.testRecipe(h));

					GameRenderer.drawNameplate(this.getFontRenderer(),
							new TranslationTextComponent(i.getTranslationKey(), new Object[0]).getString().toString(),
							(float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F, 0, 270F, 0, false);
				}

			});

			GlStateManager.pushMatrix();
			GlStateManager.translated(x + 0.6, y + 1, z + 0.5);
			GlStateManager.rotated(90F, 1, 0, 0);
			GlStateManager.rotated(270F, 0, 0, 1);
			RenderHelper.enableStandardItemLighting();
			l.ifPresent(h -> {
				Minecraft.getInstance().getItemRenderer().renderItem(h.getStackInSlot(0),
						ItemCameraTransforms.TransformType.GROUND);
			});
			RenderHelper.disableStandardItemLighting();
			GlStateManager.popMatrix();

			GlStateManager.pushMatrix();
			GlStateManager.translated(x + 0.2, y + 1, z + 0.3);
			GlStateManager.rotated(90F, 1, 0, 0);
			GlStateManager.rotated(270F, 0, 0, 1);
			RenderHelper.enableStandardItemLighting();
			l.ifPresent(h -> {
				Minecraft.getInstance().getItemRenderer().renderItem(h.getStackInSlot(1),
						ItemCameraTransforms.TransformType.GROUND);
			});
			RenderHelper.disableStandardItemLighting();
			GlStateManager.popMatrix();

			GlStateManager.pushMatrix();
			GlStateManager.translated(x + 0.2, y + 1, z + 0.7);
			GlStateManager.rotated(90F, 1, 0, 0);
			GlStateManager.rotated(270F, 0, 0, 1);
			RenderHelper.enableStandardItemLighting();
			l.ifPresent(h -> {
				Minecraft.getInstance().getItemRenderer().renderItem(h.getStackInSlot(2),
						ItemCameraTransforms.TransformType.GROUND);
			});
			RenderHelper.disableStandardItemLighting();
			GlStateManager.popMatrix();
			break;
		case SOUTH:

			l.ifPresent(h -> {
				if (DeskRecipeManager.testRecipe(h).getItem() != Items.AIR) {
					ItemStack i = new ItemStack(DeskRecipeManager.testRecipe(h));

					GameRenderer.drawNameplate(this.getFontRenderer(),
							new TranslationTextComponent(i.getTranslationKey(), new Object[0]).getString().toString(),
							(float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F, 0, 180F, 0, false);
				}

			});

			GlStateManager.pushMatrix();
			GlStateManager.translated(x + 0.5, y + 1, z + 0.4);
			GlStateManager.rotated(90F, 1, 0, 0);
			GlStateManager.rotated(180F, 0, 0, 1);
			RenderHelper.enableStandardItemLighting();
			l.ifPresent(h -> {
				Minecraft.getInstance().getItemRenderer().renderItem(h.getStackInSlot(0),
						ItemCameraTransforms.TransformType.GROUND);
			});
			RenderHelper.disableStandardItemLighting();
			GlStateManager.popMatrix();

			GlStateManager.pushMatrix();
			GlStateManager.translated(x + 0.3, y + 1, z + 0.8);
			GlStateManager.rotated(90F, 1, 0, 0);
			GlStateManager.rotated(180F, 0, 0, 1);
			RenderHelper.enableStandardItemLighting();
			l.ifPresent(h -> {
				Minecraft.getInstance().getItemRenderer().renderItem(h.getStackInSlot(1),
						ItemCameraTransforms.TransformType.GROUND);
			});
			RenderHelper.disableStandardItemLighting();
			GlStateManager.popMatrix();

			GlStateManager.pushMatrix();
			GlStateManager.translated(x + 0.7, y + 1, z + 0.8);
			GlStateManager.rotated(90F, 1, 0, 0);
			GlStateManager.rotated(180F, 0, 0, 1);
			RenderHelper.enableStandardItemLighting();
			l.ifPresent(h -> {
				Minecraft.getInstance().getItemRenderer().renderItem(h.getStackInSlot(2),
						ItemCameraTransforms.TransformType.GROUND);
			});
			RenderHelper.disableStandardItemLighting();
			GlStateManager.popMatrix();
			break;
		case NORTH:

			l.ifPresent(h -> {
				if (DeskRecipeManager.testRecipe(h).getItem() != Items.AIR) {
					ItemStack i = new ItemStack(DeskRecipeManager.testRecipe(h));

					GameRenderer.drawNameplate(this.getFontRenderer(),
							new TranslationTextComponent(i.getTranslationKey(), new Object[0]).getString().toString(),
							(float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F, 0, 0, 0, false);
				}

			});

			GlStateManager.pushMatrix();
			GlStateManager.translated(x + 0.5, y + 1, z + 0.6);
			GlStateManager.rotated(90F, 1, 0, 0);
			RenderHelper.enableStandardItemLighting();
			l.ifPresent(h -> {
				Minecraft.getInstance().getItemRenderer().renderItem(h.getStackInSlot(0),
						ItemCameraTransforms.TransformType.GROUND);
			});
			RenderHelper.disableStandardItemLighting();
			GlStateManager.popMatrix();

			GlStateManager.pushMatrix();
			GlStateManager.translated(x + 0.7, y + 1, z + 0.2);
			GlStateManager.rotated(90F, 1, 0, 0);
			RenderHelper.enableStandardItemLighting();
			l.ifPresent(h -> {
				Minecraft.getInstance().getItemRenderer().renderItem(h.getStackInSlot(1),
						ItemCameraTransforms.TransformType.GROUND);
			});

			RenderHelper.disableStandardItemLighting();
			GlStateManager.popMatrix();

			GlStateManager.pushMatrix();
			GlStateManager.translated(x + 0.3, y + 1, z + 0.2);
			GlStateManager.rotated(90F, 1, 0, 0);
			RenderHelper.enableStandardItemLighting();
			l.ifPresent(h -> {
				Minecraft.getInstance().getItemRenderer().renderItem(h.getStackInSlot(2),
						ItemCameraTransforms.TransformType.GROUND);
			});
			RenderHelper.disableStandardItemLighting();
			GlStateManager.popMatrix();
			break;
		}

	}

}