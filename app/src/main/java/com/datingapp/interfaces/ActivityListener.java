package com.datingapp.interfaces;
/**
 * @package com.datingapp
 * @subpackage interfaces
 * @category ActivityListener
 * @author Trioangle Product Team
 * @version 1.0
 **/

import android.content.res.Resources;

import com.datingapp.views.main.HomeActivity;

/*****************************************************************
 ActivityListener
 ****************************************************************/

public interface ActivityListener {

    Resources getRes();

    HomeActivity getInstance();

}
