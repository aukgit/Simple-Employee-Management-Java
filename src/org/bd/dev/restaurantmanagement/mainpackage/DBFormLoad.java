/*------------------------------------------------
 *------------------------------------------------
 * ||id     		:   112 0821 042
 * |name   		:   Alim Ul Karim
 * |email  		:   alim.karim.nsu@gmail.com
 * |course 		:   CSE 115.2 
 * |blog   		:   http://bit.ly/auk-blog
 * |linkedin            :   http://linkd.in/alim-ul-karim
 *------------------------------------------------
 *------------------------------------------------
 */
package org.bd.dev.restaurantmanagement.mainpackage;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import org.bd.dev.res.database.items.forms.CommonJPanel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Alim
 */
public final class DBFormLoad {

    DBFormLoad() {
    }

    DBFormLoad(CommonJPanel o) {
        show(o);
    }

    public CommonForm show(CommonJPanel o) {
        CommonForm frame = new CommonForm();
        frame.CPanel = o;
        frame.setContentPane(o);
        //o.Save();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        setFormOnCenter(frame);
        frame.setVisible(true);
        return frame;
    }

    /**
     * 
     * @param o :show that JFrame
     */
    public void show(JFrame o) {
        o.setVisible(true);
        setFormOnCenter(o);
    }

    /**
     * 
     * @param o : CommonJPanel, create JFrame and that put that content in it.
     * @param Title 
     */
    public void show(CommonJPanel o, String Title) {
        CommonForm frame = show(o);
        frame.setTitle(Title);
    }

    /**
     * 
     * @param table ; Table Name
     * @param eManager : entity manager
     * @param l : collection list item
     * @param qx : query Object
     */
    public void showSearch(String table, EntityManager eManager, List l, Query qx) {
        //System.out.println("helo");
        SearchForm sf = new SearchForm();
        sf.LoadAll(table, eManager, l, qx);
        show(sf);
        sf.setVisible(true);
    }

    /**
     * 
     * @param table ; Table Name
     * @param eManager : entity manager
     * @param l : collection list item
     * @param qx : query Obejct
     * @param LinkedColumnNames :give the linked column names , which should be presented as f.columnid.columnid = ?
     */
    public void showSearch(String table, EntityManager eManager, List l, Query qx, String LinkedColumnNames[]) {
        SearchForm sf = new SearchForm();
        sf.LoadAll(table, eManager, l, qx, LinkedColumnNames);
        show(sf);
        sf.setVisible(true);
    }

    public SearchForm hiddenSearch(String table, EntityManager eManager, List l, Query qx, String LinkedColumnNames[]) {
        SearchForm sf = new SearchForm(true);
        sf.LoadAll(table, eManager, l, qx, LinkedColumnNames);
        //show(sf);
        return sf;
        //sf.setVisible(true);
    }

    public SearchForm hiddenSearch(String table, EntityManager eManager, List l, Query qx) {
        SearchForm sf = new SearchForm(true);
        sf.LoadAll(table, eManager, l, qx);
        //show(sf);
        return sf;
        //sf.setVisible(true);
    }

    /**
     * 
     * @param f : set a frame in the center of the screen
     */
    public void setFormOnCenter(JFrame f) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        //Following three lines make the form centered
        int x = (screenSize.width - f.getWidth()) / 2;
        int y = (screenSize.height - f.getHeight()) / 2;
        f.setLocation(x, y);
    }
}
