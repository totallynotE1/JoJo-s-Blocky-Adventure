// Made with Blockbench 3.5.2
// Exported for Minecraft version 1.14
// Paste this class into your mod and generate all required imports

public static class ModelStoneMask extends EntityModel {
	private final ModelRenderer head;
	private final ModelRenderer RightEye2;
	private final ModelRenderer Mask;
	private final ModelRenderer RightEye;

	public ModelStoneMask() {
		textureWidth = 32;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);

		RightEye2 = new ModelRenderer(this);
		RightEye2.setRotationPoint(-5.05F, -4.25F, -3.5F);
		head.addChild(RightEye2);
		setRotationAngle(RightEye2, 0.0F, 0.0F, 1.7453F);
		RightEye2.cubeList.add(new ModelBox(RightEye2, 7, 0, -1.0961F, -4.2566F, -0.5F, 1, 3, 1, 0.0F, true));

		Mask = new ModelRenderer(this);
		Mask.setRotationPoint(-2.5F, 48.5F, 4.5F);
		head.addChild(Mask);
		Mask.cubeList.add(new ModelBox(Mask, 0, 6, -0.5F, -49.5F, -8.5F, 6, 1, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 0, 0, -1.5F, -51.5F, -8.5F, 8, 2, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 1, 0, -0.5F, -55.5F, -8.5F, 7, 3, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 13, 13, 1.5F, -52.5F, -8.5F, 2, 1, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 8, 10, 1.5F, -51.5F, -8.75F, 2, 1, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 0, 8, 1.5F, -57.5F, -8.7F, 2, 5, 2, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 11, 15, -1.5F, -53.5F, -8.5F, 1, 2, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 8, 12, 3.5F, -56.5F, -8.5F, 2, 1, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 14, 9, -1.5F, -55.5F, -8.75F, 1, 2, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 15, 15, -0.5F, -54.5F, -8.75F, 1, 1, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 6, 8, -1.5F, -56.5F, -8.75F, 3, 1, 1, 0.0F, false));
		Mask.cubeList.add(new ModelBox(Mask, 0, 15, 5.5F, -53.5F, -8.5F, 1, 2, 1, 0.0F, false));

		RightEye = new ModelRenderer(this);
		RightEye.setRotationPoint(5.05F, -4.25F, -3.5F);
		head.addChild(RightEye);
		setRotationAngle(RightEye, 0.0F, 0.0F, -1.7453F);
		RightEye.cubeList.add(new ModelBox(RightEye, 5, 0, 0.0961F, -4.2566F, -0.5F, 1, 3, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
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