/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    //beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  public static void testKeepOnlyBlue()
  {
	  Picture butterfly = new Picture("butterfly1.jpg");
	  butterfly.keepOnlyBlue();
	  butterfly.explore();
  }
  
  public static void testNegate()
  {
	  Picture arch = new Picture("arch.jpg");
	  arch.negate();
	  arch.explore();
  }
  
  public static void testGrayscale()
  {
	  Picture temple = new Picture("temple.jpg");
	  temple.explore();
	  temple.grayscaleAverage();
	  temple.explore();
	  temple.grayscaleLightness();
	  temple.explore();
	  temple.grayscaleLuminosity();
	  temple.explore();
  }
  
  public static void testFixUnderwater()
  {
	  Picture water = new Picture("water.jpg");
	  water.explore();
	  water.fixUnderwater();
	  water.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  public static void testMirrorVerticalRightToLeft()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
  }
  
  public static void testMirrorHorizontal()
  {
	  Picture caterpillar = new Picture("caterpillar.jpg");
	    caterpillar.explore();
	    caterpillar.mirrorHorizontal();
	    caterpillar.explore();
  }
  
  public static void testMirrorHorizontalBotToTop()
  {
	  Picture caterpillar = new Picture("caterpillar.jpg");
	    caterpillar.explore();
	    caterpillar.mirrorHorizontalBotToTop();
	    caterpillar.explore();
  }
  
  public static void testMirrorDiagonal()
  {
	  Picture caterpillar = new Picture("beach.jpg");
	    caterpillar.explore();
	    caterpillar.mirrorDiagonal();
	    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  public static void testMirrorArms()
  {
	  Picture temple = new Picture("snowman.jpg");
	    temple.explore();
	    temple.mirrorArms();
	    temple.explore();
  }
  
  public static void testMirrorGull()
  {
	  Picture temple = new Picture("seagull.jpg");
	    temple.explore();
	    temple.mirrorGull();
	    temple.explore();
  }
  
  public static void testMirrorRectangle()
  {
	  Picture temple = new Picture("seagull.jpg");
	    temple.explore();
	    temple.mirrorRectangle(0, 0, 500, 400, false);
	    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  public static void testMyCollage()
  {
	  Picture canvas = new Picture("640x480.jpg");
	    canvas.myCollage();
	    canvas.explore();
	    Picture b = new Picture("butterfly1.jpg");
	    b.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection2(20);
    swan.explore();
  }
  
  public static void testEdgeDetection2()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(20);
    swan.explore();
  }
  
  public static void testBlur(int x, int y, int w, int h, int n)
  {
	  Picture redMoto = new Picture("redMotorcycle.jpg");
	  redMoto.explore();
	   for (int i = 0; i<n; i++){
	      redMoto.blur(x,y,w,h);
	    }
	    redMoto.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
	//testMirrorVerticalRightToLeft();
	//testMirrorHorizontal();
	//testMirrorHorizontalBotToTop();
	//testMirrorDiagonal();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
	//testMirrorRectangle();
    //testMirrorDiagonal();
    //testCollage();
	//testMyCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
	testBlur(160,180,25,30,6);
	//testBlur(0,0,700,500,6);
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}