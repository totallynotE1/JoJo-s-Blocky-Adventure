// Made with Blockbench 3.5.2
// Exported for Minecraft version 1.14
// Paste this class into your mod and generate all required imports

public static class Modelmr extends EntityModel {
	private final ModelRenderer rightleg;
	private final ModelRenderer leftleg;
	private final ModelRenderer chest;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer leftarm;
	private final ModelRenderer rightarm;
	private final ModelRenderer head;
	private final ModelRenderer bone13;
	private final ModelRenderer bone14;
	private final ModelRenderer bone15;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer bone10;
	private final ModelRenderer bone11;
	private final ModelRenderer bone12;
	private final ModelRenderer bone8;
	private final ModelRenderer bone9;
	private final ModelRenderer leftarm2;
	private final ModelRenderer rightarm2;

	public Modelmr() {
		textureWidth = 128;
		textureHeight = 128;

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
		rightleg.cubeList.add(new ModelBox(rightleg, 16, 32, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
		rightleg.cubeList.add(new ModelBox(rightleg, 0, 48, -2.0F, 8.0F, -2.0F, 4, 4, 4, 0.125F, false));

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(2.0F, 12.0F, 0.0F);
		leftleg.cubeList.add(new ModelBox(leftleg, 0, 32, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
		leftleg.cubeList.add(new ModelBox(leftleg, 32, 37, -2.0F, 8.0F, -2.0F, 4, 4, 4, 0.125F, false));

		chest = new ModelRenderer(this);
		chest.setRotationPoint(0.0F, 0.0F, 0.0F);
		chest.cubeList.add(new ModelBox(chest, 32, 0, -3.5F, 0.0F, -2.0F, 7, 12, 4, 0.0F, false));
		chest.cubeList.add(new ModelBox(chest, 32, 32, -4.0F, 11.0F, -2.0F, 8, 1, 4, 0.0625F, false));
		chest.cubeList.add(new ModelBox(chest, 54, 0, -4.0F, 0.0F, -2.0F, 8, 7, 4, 0.125F, false));

		bone = new ModelRenderer(this);
		bone.setRotationPoint(3.0F, 12.0F, 0.0F);
		chest.addChild(bone);
		setRotationAngle(bone, 0.0F, 0.0F, -0.4363F);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(-3.0F, 12.0F, 0.0F);
		chest.addChild(bone2);
		setRotationAngle(bone2, 0.0F, 0.0F, 0.4363F);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		leftarm.cubeList.add(new ModelBox(leftarm, 48, 16, 9.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));
		leftarm.cubeList.add(new ModelBox(leftarm, 64, 48, 9.0F, 6.0F, -2.0F, 4, 3, 4, 0.125F, false));
		leftarm.cubeList.add(new ModelBox(leftarm, 16, 63, 9.0F, 4.75F, -2.0F, 4, 1, 4, 0.125F, false));

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(5.0F, 2.0F, 0.0F);
		rightarm.cubeList.add(new ModelBox(rightarm, 32, 16, -13.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));
		rightarm.cubeList.add(new ModelBox(rightarm, 48, 48, -13.0F, 6.0F, -2.0F, 4, 3, 4, 0.125F, false));
		rightarm.cubeList.add(new ModelBox(rightarm, 0, 63, -13.0F, 4.75F, -2.0F, 4, 1, 4, 0.125F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, false));

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.addChild(bone13);
		bone13.cubeList.add(new ModelBox(bone13, 60, 69, 1.0F, -28.25F, -4.05F, 1, 1, 5, 0.0F, false));
		bone13.cubeList.add(new ModelBox(bone13, 48, 69, 2.45F, -29.45F, -4.075F, 1, 1, 5, 0.0F, false));
		bone13.cubeList.add(new ModelBox(bone13, 36, 69, -3.45F, -29.45F, -4.075F, 1, 1, 5, 0.0F, false));
		bone13.cubeList.add(new ModelBox(bone13, 24, 69, -2.0F, -28.25F, -4.05F, 1, 1, 5, 0.0F, false));
		bone13.cubeList.add(new ModelBox(bone13, 12, 69, 2.0F, -28.25F, -4.05F, 1, 1, 5, 0.0F, false));
		bone13.cubeList.add(new ModelBox(bone13, 0, 69, -3.0F, -28.25F, -4.05F, 1, 1, 5, 0.0F, false));

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone13.addChild(bone14);
		setRotationAngle(bone14, 0.0F, 0.0F, -0.3927F);
		bone14.cubeList.add(new ModelBox(bone14, 46, 63, 11.5648F, -26.2772F, -4.075F, 2, 1, 5, 0.0F, false));

		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone13.addChild(bone15);
		setRotationAngle(bone15, 0.0F, 0.0F, 0.3927F);
		bone15.cubeList.add(new ModelBox(bone15, 32, 63, -13.5648F, -26.2772F, -4.075F, 2, 1, 5, 0.0F, false));

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.addChild(bone5);
		setRotationAngle(bone5, 0.3491F, 0.0F, 0.0F);
		bone5.cubeList.add(new ModelBox(bone5, 60, 56, -1.0F, -28.5F, 11.0F, 2, 2, 5, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 12, 75, -1.0F, -28.5F, 16.0F, 2, 3, 3, 0.0F, false));

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.addChild(bone6);
		setRotationAngle(bone6, 0.1745F, 0.0F, 0.0F);
		bone6.cubeList.add(new ModelBox(bone6, 0, 75, -1.0F, -27.25F, 6.5F, 2, 1, 4, 0.0F, false));
		bone6.cubeList.add(new ModelBox(bone6, 22, 75, -1.0F, -27.25F, 10.5F, 2, 2, 2, 0.0F, false));

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(bone7);
		bone7.cubeList.add(new ModelBox(bone7, 60, 63, -1.0F, -2.5F, -6.0F, 2, 2, 4, 0.0F, false));

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone7.addChild(bone10);
		setRotationAngle(bone10, -0.3927F, 0.0F, 0.0F);
		bone10.cubeList.add(new ModelBox(bone10, 30, 77, -1.0F, 0.8221F, -6.6522F, 2, 1, 1, 0.0F, false));

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, 48.0F, 0.0F);
		bone7.addChild(bone11);
		setRotationAngle(bone11, 0.3927F, 0.0F, 0.0F);
		bone11.cubeList.add(new ModelBox(bone11, 30, 75, -1.0F, -48.9471F, 12.8478F, 2, 1, 1, 0.0F, false));

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone11.addChild(bone12);
		setRotationAngle(bone12, 0.3927F, 0.0F, 0.0F);
		bone12.cubeList.add(new ModelBox(bone12, 22, 79, -1.0F, -40.2983F, 29.7142F, 2, 1, 1, 0.0F, false));

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone7.addChild(bone8);
		setRotationAngle(bone8, 0.0F, 0.3927F, 0.0F);
		bone8.cubeList.add(new ModelBox(bone8, 46, 56, 1.2346F, -2.5F, -5.1522F, 2, 2, 5, 0.0F, false));

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone7.addChild(bone9);
		setRotationAngle(bone9, 0.0F, -0.3927F, 0.0F);
		bone9.cubeList.add(new ModelBox(bone9, 32, 56, -3.2346F, -2.5F, -5.1522F, 2, 2, 5, 0.0F, false));

		leftarm2 = new ModelRenderer(this);
		leftarm2.setRotationPoint(-5.0F, 2.0F, 0.0F);
		setRotationAngle(leftarm2, -0.9599F, 0.0F, 0.0F);
		leftarm2.cubeList.add(new ModelBox(leftarm2, 16, 16, 9.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));
		leftarm2.cubeList.add(new ModelBox(leftarm2, 32, 48, 9.0F, 6.0F, -2.0F, 4, 3, 4, 0.125F, false));
		leftarm2.cubeList.add(new ModelBox(leftarm2, 16, 56, 9.0F, 4.75F, -2.0F, 4, 1, 4, 0.125F, false));

		rightarm2 = new ModelRenderer(this);
		rightarm2.setRotationPoint(5.0F, 2.0F, 0.0F);
		setRotationAngle(rightarm2, -0.9599F, 0.0F, 0.0F);
		rightarm2.cubeList.add(new ModelBox(rightarm2, 0, 16, -13.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));
		rightarm2.cubeList.add(new ModelBox(rightarm2, 16, 48, -13.0F, 6.0F, -2.0F, 4, 3, 4, 0.125F, false));
		rightarm2.cubeList.add(new ModelBox(rightarm2, 0, 56, -13.0F, 4.75F, -2.0F, 4, 1, 4, 0.125F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		rightleg.render(f5);
		leftleg.render(f5);
		chest.render(f5);
		leftarm.render(f5);
		rightarm.render(f5);
		head.render(f5);
		leftarm2.render(f5);
		rightarm2.render(f5);
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