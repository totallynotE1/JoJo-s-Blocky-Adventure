// Made with Blockbench 3.5.2
// Exported for Minecraft version 1.14
// Paste this class into your mod and generate all required imports

public static class ModelKillerQueen extends EntityModel {
	private final ModelRenderer HEAD;
	private final ModelRenderer Shape7;
	private final ModelRenderer Shape5;
	private final ModelRenderer Shape6;
	private final ModelRenderer Bodybase;
	private final ModelRenderer Shape10;
	private final ModelRenderer Shape3;
	private final ModelRenderer leftleg;
	private final ModelRenderer rightleg;
	private final ModelRenderer leftarm;
	private final ModelRenderer rightarm;
	private final ModelRenderer body;
	private final ModelRenderer Shape4;
	private final ModelRenderer Shape2;
	private final ModelRenderer Shape1;
	private final ModelRenderer Shape8;

	public ModelKillerQueen() {
		textureWidth = 128;
		textureHeight = 128;

		HEAD = new ModelRenderer(this);
		HEAD.setRotationPoint(0.0F, 1.0F, 0.0F);

		Shape7 = new ModelRenderer(this);
		Shape7.setRotationPoint(0.0F, 0.0F, 0.0F);
		HEAD.addChild(Shape7);
		Shape7.cubeList.add(new ModelBox(Shape7, 32, 0, -4.0F, -14.0F, -2.0F, 1, 3, 5, 0.0F, false));

		Shape5 = new ModelRenderer(this);
		Shape5.setRotationPoint(0.0F, 0.0F, 0.0F);
		HEAD.addChild(Shape5);
		Shape5.cubeList.add(new ModelBox(Shape5, 0, 0, -4.0F, -11.0F, -4.0F, 8, 8, 8, 0.0F, false));

		Shape6 = new ModelRenderer(this);
		Shape6.setRotationPoint(0.0F, 0.0F, 0.0F);
		HEAD.addChild(Shape6);
		Shape6.cubeList.add(new ModelBox(Shape6, 32, 0, 3.0F, -14.0F, -2.0F, 1, 3, 5, 0.0F, false));

		Bodybase = new ModelRenderer(this);
		Bodybase.setRotationPoint(0.0F, 0.0F, 0.0F);

		Shape10 = new ModelRenderer(this);
		Shape10.setRotationPoint(3.0F, 18.0F, -5.0F);
		Bodybase.addChild(Shape10);
		setRotationAngle(Shape10, 0.0F, -0.1745F, 0.0F);
		Shape10.cubeList.add(new ModelBox(Shape10, 36, 103, -2.0F, 0.0F, -2.0F, 4, 9, 4, 0.0F, false));

		Shape3 = new ModelRenderer(this);
		Shape3.setRotationPoint(-3.0F, 18.0F, -2.0F);
		Bodybase.addChild(Shape3);
		Shape3.cubeList.add(new ModelBox(Shape3, 36, 103, -2.0F, 0.0F, -2.0F, 4, 9, 4, 0.0F, false));

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(2.0F, 10.0F, -3.0F);
		Bodybase.addChild(leftleg);
		setRotationAngle(leftleg, -0.2618F, -0.1745F, 0.0F);
		leftleg.cubeList.add(new ModelBox(leftleg, 53, 103, -1.5F, 0.0F, -2.0F, 4, 9, 4, 0.0F, false));

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-2.0F, 10.0F, -3.0F);
		Bodybase.addChild(rightleg);
		setRotationAngle(rightleg, 0.0873F, 0.0F, 0.0F);
		rightleg.cubeList.add(new ModelBox(rightleg, 53, 103, -2.5F, 0.0F, -2.0F, 4, 9, 4, 0.0F, false));

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(5.0F, 0.0F, 0.0F);
		Bodybase.addChild(leftarm);
		setRotationAngle(leftarm, 0.0F, 0.0F, -0.2618F);
		leftarm.cubeList.add(new ModelBox(leftarm, 67, 73, 0.0F, 1.0F, -3.0F, 4, 12, 4, 0.0F, true));

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(-6.0F, 0.0F, 0.0F);
		Bodybase.addChild(rightarm);
		setRotationAngle(rightarm, 0.0F, 0.0F, 0.2618F);
		rightarm.cubeList.add(new ModelBox(rightarm, 67, 73, -3.0F, 1.0F, -2.0F, 4, 12, 4, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -0.5F, -1.0F);
		Bodybase.addChild(body);
		setRotationAngle(body, -0.5236F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 16, 16, -5.5F, 0.0F, -3.0F, 11, 6, 5, 0.0F, false));

		Shape4 = new ModelRenderer(this);
		Shape4.setRotationPoint(0.0F, -2.0F, -4.0F);
		Bodybase.addChild(Shape4);
		Shape4.cubeList.add(new ModelBox(Shape4, 36, 91, -10.0F, 0.0F, 0.0F, 20, 5, 6, 0.0F, false));

		Shape2 = new ModelRenderer(this);
		Shape2.setRotationPoint(0.0F, 9.0F, -4.0F);
		Bodybase.addChild(Shape2);
		Shape2.cubeList.add(new ModelBox(Shape2, 36, 79, -4.5F, -1.0F, -3.0F, 9, 4, 6, 0.0F, false));

		Shape1 = new ModelRenderer(this);
		Shape1.setRotationPoint(0.0F, 6.0F, -5.0F);
		Bodybase.addChild(Shape1);
		Shape1.cubeList.add(new ModelBox(Shape1, 18, 28, -3.5F, -3.4667F, -1.0F, 7, 7, 4, 0.0F, false));

		Shape8 = new ModelRenderer(this);
		Shape8.setRotationPoint(0.0F, 10.0F, -7.0F);
		Bodybase.addChild(Shape8);
		Shape8.cubeList.add(new ModelBox(Shape8, 46, 74, -2.0F, 1.0F, 0.0F, 4, 4, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		HEAD.render(f5);
		Bodybase.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.HEAD.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.HEAD.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}