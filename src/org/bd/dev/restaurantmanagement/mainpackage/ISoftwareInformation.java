/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bd.dev.restaurantmanagement.mainpackage;

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

public interface ISoftwareInformation {
    public String PRODUCTNAME = "Restaurant Management Software";
    public String VENDOR = "Developers Organism";
    public String DEVELOPER = "Alim Ul Karim";
    public String WEBSITE = "NONE";
    public String EMAIL = "auk.junk@live.com";
    public DBFormLoad loader = new DBFormLoad();
    public MsgBox msg = new MsgBox();
    public String DatabaseURL = "jdbc:mysql://localhost:3306/RestaurantManagement";
    public ArrayMore arr = new ArrayMore(); //for getting or readding array in print
    public Err err = new Err();
    public FrontView FrontWindow = new FrontView();
    public DatabaseQuery dbq = new DatabaseQuery();
    public DatabaseQueryEntityManager dbe = new DatabaseQueryEntityManager();
    public SearchForm hidden_search_form = new SearchForm(true);//for hidden search
    public Picture pic = new Picture();
    public String EmployeePicturesLocation = "\\employeeimages2\\";
}
