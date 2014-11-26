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

/**
 *
 * @author Alim
 */
public interface QueryTypes {
    public int EXACT = 0;
    public int EXACT_FROM_FRIST = 1;
    public int ANYWHERE = 2;
    public int WORD_BASE_SEARCH = 3;
    public int WORD_BASE_SEARCH_USING_OR = 4;
    public int BETWEEN = 5;
}
