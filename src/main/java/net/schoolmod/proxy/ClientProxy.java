package net.schoolmod.proxy;

import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.schoolmod.TileEntityDeskRenderer;
import net.schoolmod.blocks.TileEntityDesk;

public class ClientProxy implements CommonProxy {

    @Override
    public void setup() {
    	System.out.println("School Mod - Client Load");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDesk.class, new TileEntityDeskRenderer());
    }

    @Override
    public void loadComplete() {
    	System.out.println("School Mod - Client Setup");
    }

}