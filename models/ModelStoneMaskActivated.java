// Made with Blockbench 3.5.2
// Exported for Minecraft version 1.14
// Paste this class into your mod and generate all required imports

public static class ModelStoneMaskActivated extends EntityModel {
	private final ModelRenderer Mask;
	private final ModelRenderer RightEye;
	private final ModelRenderer RightEye2;

	public ModelStoneMaskActivated() {
		textureWidth = 64;
		textureHeight = 64;

		Mask = new ModelRenderer(this);
		Mask.setRotationPoint(0.0F, 0.0F, 0.0F);
		Mask.cubeList.add(new ModelBox(Mask, 24, 0, -3.0F, -1.0F, -4.0F, 6, 1, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 0, 23, -4.0F, -3.0F, -4.0F, 8, 2, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 18, 23, -3.0F, -7.0F, -4.0F, 7, 2, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 12, 4, -1.0F, -4.0F, -4.0F, 2, 1, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 12, 0, -1.0F, -3.0F, -4.25F, 2, 1, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 12, 12, -3.0F, -4.0F, -3.5F, 2, 1, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 0, 11, 1.0F, -4.0F, -3.5F, 2, 1, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 0, 0, -1.0F, -9.0F, -4.2F, 2, 5, 2, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 12, 14, -4.0F, -5.0F, -4.0F, 1, 2, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 12, 2, 1.0F, -8.0F, -4.0F, 2, 1, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 0, 13, -4.0F, -7.0F, -4.25F, 1, 2, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 16, 6, -3.0F, -6.0F, -4.25F, 1, 1, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 0, 7, -4.0F, -8.0F, -4.25F, 3, 1, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 4, 14, 3.0F, -5.0F, -4.0F, 1, 2, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 12, 1, 4.0F, -7.0F, -4.0F, 1, 1, 10, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 0, 0, 4.0F, -5.0F, -4.0F, 1, 1, 10, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 12, 12, -5.0F, -7.0F, -4.0F, 1, 1, 10, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 0, 11, -5.0F, -5.0F, -4.0F, 1, 1, 10, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 15, 16, 3.0F, -7.0F, 5.0F, 1, 1, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 6, 0, 3.0F, -5.0F, 5.0F, 1, 1, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 0, 16, -4.0F, -7.0F, 5.0F, 1, 1, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 15, 8, -4.0F, -5.0F, 5.0F, 1, 1, 1, 0.0F, false));

		RightEye = new ModelRenderer(this);
		RightEye.setRotationPoint(5.8F, -4.25F, -3.5F);
		Mask.addChild(RightEye);
		setRotationAngle(RightEye, 0.0F, 0.0F, -1.7453F);
		RightEye.cubeList.add(new ModelBox(RightEye, 2, 3, 0.1946F, -5.2392F, -0.5F, 2, 3, 1, 0.0F, false));

		RightEye2 = new ModelRenderer(this);
		RightEye2.setRotationPoint(-5.8F, -4.25F, -3.5F);
		Mask.addChild(RightEye2);
		setRotationAngle(RightEye2, 0.0F, 0.0F, 1.7453F);
		RightEye2.cubeList.add(new ModelBox(RightEye2, 2, 3, -2.1946F, -5.2392F, -0.5F, 2, 3, 1, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Mask.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}