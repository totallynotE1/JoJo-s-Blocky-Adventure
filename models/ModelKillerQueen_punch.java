// Made with Blockbench 3.5.2
// Exported for Minecraft version 1.14
// Paste this class into your mod and generate all required imports

public static class ModelKillerQueen_punch extends EntityModel {
	private final ModelRenderer Shape1;

	public ModelKillerQueen_punch() {
		textureWidth = 64;
		textureHeight = 32;

		Shape1 = new ModelRenderer(this);
		Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Shape1.cubeList.add(new ModelBox(Shape1, 0, 0, -2.0F, -2.0F, 0.0F, 4, 4, 12, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Shape1.render(f5);
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