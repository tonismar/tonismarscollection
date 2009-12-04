/*
 * MyCollectionApp.java
 */

package mycollection;

import java.sql.Connection;
import java.sql.Statement;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class MyCollectionApp extends SingleFrameApplication {

    private Connection conn;
    private Statement stm;

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new MyCollectionView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of MyCollectionApp
     */
    public static MyCollectionApp getApplication() {
        return Application.getInstance(MyCollectionApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(MyCollectionApp.class, args);
    }
}
