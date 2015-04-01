package com.vfluff5.netcraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelComputer extends ModelBase
{
  //fields
    ModelRenderer Base;
    ModelRenderer Left;
    ModelRenderer Right;
    ModelRenderer Bottom;
    ModelRenderer Top;
  
  public ModelComputer()
  {
    textureWidth = 128;
    textureHeight = 32;
    
      Base = new ModelRenderer(this, 0, 0);
      Base.addBox(0F, 0F, 0F, 16, 16, 14);
      Base.setRotationPoint(-8F, 8F, -6F);
      Base.setTextureSize(128, 32);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Left = new ModelRenderer(this, 98, 0);
      Left.addBox(0F, 0F, 0F, 2, 16, 1);
      Left.setRotationPoint(-8F, 8F, -7F);
      Left.setTextureSize(128, 32);
      Left.mirror = true;
      setRotation(Left, 0F, 0F, 0F);
      Right = new ModelRenderer(this, 106, 0);
      Right.addBox(0F, 0F, 0F, 2, 16, 1);
      Right.setRotationPoint(6F, 8F, -7F);
      Right.setTextureSize(128, 32);
      Right.mirror = true;
      setRotation(Right, 0F, 0F, 0F);
      Bottom = new ModelRenderer(this, 79, 15);
      Bottom.addBox(0F, 0F, 0F, 3, 16, 1);
      Bottom.setRotationPoint(8F, 21F, -7F);
      Bottom.setTextureSize(128, 32);
      Bottom.mirror = true;
      setRotation(Bottom, 0F, 0F, 1.579523F);
      Top = new ModelRenderer(this, 89, 15);
      Top.addBox(0F, 0F, 0F, 3, 16, 1);
      Top.setRotationPoint(8F, 8F, -7F);
      Top.setTextureSize(128, 32);
      Top.mirror = true;
      setRotation(Top, 0F, 0F, 1.579523F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Base.render(f5);
    Left.render(f5);
    Right.render(f5);
    Bottom.render(f5);
    Top.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
