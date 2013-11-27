package testsforlibgdx;
import static org.junit.Assert.*;

import org.iwt2.nikky.model.actors.NikkiActor;
import org.iwt2.nikky.model.stages.CombatStage;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL11;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GLCommon;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class TestStage {

	class FakeBatch implements Batch {

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void begin() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void disableBlending() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void draw(Texture arg0, float arg1, float arg2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void draw(TextureRegion arg0, float arg1, float arg2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void draw(Texture arg0, float[] arg1, int arg2, int arg3) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void draw(Texture arg0, float arg1, float arg2, float arg3,
				float arg4) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void draw(TextureRegion arg0, float arg1, float arg2,
				float arg3, float arg4) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void draw(Texture arg0, float arg1, float arg2, int arg3,
				int arg4, int arg5, int arg6) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void draw(Texture arg0, float arg1, float arg2, float arg3,
				float arg4, float arg5, float arg6, float arg7, float arg8) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void draw(TextureRegion arg0, float arg1, float arg2,
				float arg3, float arg4, float arg5, float arg6, float arg7,
				float arg8, float arg9) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void draw(Texture arg0, float arg1, float arg2, float arg3,
				float arg4, int arg5, int arg6, int arg7, int arg8,
				boolean arg9, boolean arg10) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void draw(TextureRegion arg0, float arg1, float arg2,
				float arg3, float arg4, float arg5, float arg6, float arg7,
				float arg8, float arg9, boolean arg10) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void draw(Texture arg0, float arg1, float arg2, float arg3,
				float arg4, float arg5, float arg6, float arg7, float arg8,
				float arg9, int arg10, int arg11, int arg12, int arg13,
				boolean arg14, boolean arg15) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void enableBlending() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void end() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void flush() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int getBlendDstFunc() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getBlendSrcFunc() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Color getColor() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Matrix4 getProjectionMatrix() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Matrix4 getTransformMatrix() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isBlendingEnabled() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setBlendFunction(int arg0, int arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setColor(Color arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setColor(float arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setColor(float arg0, float arg1, float arg2, float arg3) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setProjectionMatrix(Matrix4 arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setShader(ShaderProgram arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setTransformMatrix(Matrix4 arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class FakeGraphics implements Graphics {

		@Override
		public boolean isGL11Available() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isGL20Available() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public GLCommon getGLCommon() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public GL10 getGL10() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public GL11 getGL11() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public GL20 getGL20() {
			// TODO Auto-generated method stub
			return null;
		}

		/**
		 * Faked
		 */
		@Override
		public int getWidth() {
			return 800;
		}

		/**
		 * Faked
		 */
		@Override
		public int getHeight() {
			return 600;
		}

		@Override
		public float getDeltaTime() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public float getRawDeltaTime() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getFramesPerSecond() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public GraphicsType getType() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public float getPpiX() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public float getPpiY() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public float getPpcX() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public float getPpcY() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public float getDensity() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean supportsDisplayModeChange() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public DisplayMode[] getDisplayModes() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DisplayMode getDesktopDisplayMode() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean setDisplayMode(DisplayMode displayMode) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean setDisplayMode(int width, int height, boolean fullscreen) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setTitle(String title) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setVSync(boolean vsync) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public BufferFormat getBufferFormat() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean supportsExtension(String extension) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setContinuousRendering(boolean isContinuous) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean isContinuousRendering() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void requestRendering() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean isFullscreen() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
	
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * I have to mock
	 *  GDX.graphicxs for methods getWidth and getHeight
	 *  SpriteBach
	 *  Uses the cnstructor that accepts a spritebatch
	 */
	@Test
	public void tesAddActorIntoStage() {
		
		Gdx.graphics = new FakeGraphics();
		
		Stage stage = new Stage(800f, 600f, true, new FakeBatch());
		
		
	
	}
}
