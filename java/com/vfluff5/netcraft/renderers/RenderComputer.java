package com.vfluff5.netcraft.renderers;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.vfluff5.netcraft.Netcraft;
import com.vfluff5.netcraft.models.ModelComputer;

public class RenderComputer extends TileEntitySpecialRenderer{

    ResourceLocation texture = new ResourceLocation(Netcraft.MODID+":textures/blocks/computer.png");

    //The model of your block
    private final ModelComputer model;

    public RenderComputer() {
        this.model = new ModelComputer();
    }
	@Override
	public void renderTileEntityAt(TileEntity p_180535_1_, double x,
			double z, double y, float p_180535_8_, int p_180535_9_) {
        //The PushMatrix tells the renderer to "start" doing something.
        GL11.glPushMatrix();
        //This is setting the initial location.
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.7F, (float) z + 0.5F);
        //This is the texture of your block. It's pathed to be the same place as your other blocks here.
        //Outdated bindTextureByName("/mods/roads/textures/blocks/TrafficLightPoleRed.png");
        //Use in 1.6.2  this

        //the ':' is very important
        //binding the textures
        this.bindTexture(texture);

        //This rotation part is very important! Without it, your model will render upside-down! And for some reason you DO need PushMatrix again!
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        //A reference to your Model file. Again, very important.
        this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0700F);
        //Tell it to stop rendering for both the PushMatrix's
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

}
